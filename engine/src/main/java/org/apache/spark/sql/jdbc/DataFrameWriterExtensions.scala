package org.apache.spark.sql.jdbc

import java.sql.{Connection, Statement}
import org.apache.spark.sql.execution.datasources.jdbc.{JDBCOptions, JdbcOptionsInWrite, JdbcUtils}
import org.apache.spark.sql.jdbc.mysql.MySQLUpsert
import org.apache.spark.sql.{DataFrame, DataFrameWriter, Row, SaveMode}
import tech.ides.exception.IdesException
import tech.sqlclub.common.log.Logging

/**
  * 扩展DataFrameWriter支持upsert
  * Note：只支持到分区级事务
  * Created by songgr on 2021/03/04.
  */
object DataFrameWriterExtensions extends Logging {

  implicit class Upsert(writer: DataFrameWriter[Row]) {

    def upsert(df: DataFrame, jdbcOptions: JDBCOptions, mode:SaveMode, keys: Option[String]): Unit = {
      val url = jdbcOptions.url
      val table = jdbcOptions.tableOrQuery
      val primaryKeys = keys.map( f => df.schema.fields.map(_.name).filter(f.split(",").contains).toSeq )
      // 是否区分大小写
      val isCaseSensitive = df.sqlContext.conf.caseSensitiveAnalysis
      val dialect = JdbcUtil.getDialect(jdbcOptions)

      if (!dialect.isInstanceOf[MySQLDialect.type]) {
        throw new IdesException("Only mysql db supports upsert mode now!")
      }

      val nullType = JdbcUtil.jdbcNullType(df.schema, jdbcOptions)
      val writeOption = new JdbcOptionsInWrite(url, table, jdbcOptions.parameters)
      val upsertReq = UpsertReq(jdbcOptions, df.schema, dialect, nullType, primaryKeys)

      var conn:Connection = null
      try {
        conn = JdbcUtils.createConnectionFactory(jdbcOptions)()
        var tableExists = JdbcUtils.tableExists(conn, writeOption)
        (mode, tableExists) match {
          case (SaveMode.Ignore, true) =>
            // 如果存在 则忽略
            return
          case (SaveMode.ErrorIfExists, true) =>
            // 如果存在 则报错
            throw new IdesException(s"Table $table already exists.")
          case (SaveMode.Overwrite, true) =>
            // 如果存在 则删除
            logInfo(s"table: $table exists, drop it first in Overwrite mode!")
            JdbcUtils.dropTable(conn, table, writeOption)
            tableExists = false
          case _ =>
        }

        if (!tableExists) {
          val schema = JdbcUtils.schemaString(df, url, jdbcOptions.createTableColumnTypes)
          val pkeys = primaryKeys.map(
            keys =>
              s" , primary key(${keys.map(dialect.quoteIdentifier).mkString(",")})"
          ).getOrElse("")
          val createSql =
            s"""CREATE TABLE $table (
               |$schema
               |$pkeys
               |)""".stripMargin
          var statement: Statement = null
          try {
            statement = conn.createStatement
            logInfo(s"Exec create table sql:\n $createSql")
            statement.executeUpdate(createSql)
          }catch {
            case e:Exception =>
              log.error(e.getMessage, e)
              throw e
          } finally {
            if (null != statement)
              statement.close()
          }
        }
      } catch {
        case e:Exception =>
          log.error(e.getMessage, e)
          throw e
      } finally {
        if ( null != conn )
          conn.close()
      }

      primaryKeys match {
        case Some(ids) =>
          logInfo(s"Start to upsert, primaryKeys are [${ids.mkString(",")}].")
          val upsertRow = new MySQLUpsert().preparedStatementSQLRow(upsertReq, isCaseSensitive)
          val getConnection: () => Connection = JdbcUtils.createConnectionFactory(jdbcOptions)
          // 按分区进行插入
          val upsertPartition = (partitionId:Int, it:Iterator[Row]) => {
            val res = new MySQLUpsert(){
              override def logInfo(msg: => String): Unit = super.logInfo(s"[Partition-$partitionId]" + msg)
              override def logWarning(msg: => String): Unit = super.logWarning(s"[Partition-$partitionId]" + msg)
              override def logError(msg: => String): Unit = super.logError(s"[Partition-$partitionId]" + msg)
            }.execute(conn = getConnection(), upsertReq, upsertRow, it, jdbcOptions.batchSize)
            Seq(res).iterator
          }

          val res = df.rdd.mapPartitionsWithIndex(upsertPartition).collect()
          logInfo(s"Successfully inserted ${res.count(i => i)} partitions, ${res.count(i => !i)} partitions failed!")

          if ( res.exists(!_) )
            throw new IdesException(s"There are ${res.count(i => !i)} partitions failed to upsert!")
        case None =>
          JdbcUtils.saveTable(df, Some(df.schema), isCaseSensitive, options = writeOption)
      }
    }
  }
}
