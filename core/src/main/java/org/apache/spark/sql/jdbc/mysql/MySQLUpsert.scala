package org.apache.spark.sql.jdbc.mysql

import java.sql.{Connection, PreparedStatement}
import org.apache.spark.sql.Row
import org.apache.spark.sql.execution.datasources.jdbc.JdbcUtils
import org.apache.spark.sql.jdbc.{JdbcUpsert, UpsertReq, UpsertRow}
import org.apache.spark.sql.types._
import tech.sqlclub.common.log.Logging
import org.apache.spark.sql.jdbc.JdbcUtil.getJdbcType
import scala.util.control.NonFatal

/**
  * mysql upsert 实现
  * Created by songgr on 2021/03/04.
  */
class MySQLUpsert extends JdbcUpsert with Serializable with Logging {
  /**
    * 执行upsert
    *
    * @param conn      数据库连接
    * @param upsertReq upsert请求对象
    * @param upsertRow upsert记录行
    * @param iterator  插入数据集
    * @param batchSize 批处理大小
    * @return Boolean
    */
  override def execute(conn: Connection, upsertReq: UpsertReq, upsertRow: UpsertRow, iterator: Iterator[Row], batchSize: Int): Boolean = {
    var committed = true
    // 事务支持
    val supportsTransactions = try {
      conn.getMetaData.supportsDataManipulationTransactionsOnly() ||
        conn.getMetaData.supportsDataDefinitionAndDataManipulationTransactions() ||
        conn.getMetaData.supportsTransactions()
    } catch {
      case NonFatal(e) =>
        logWarning("Exception while checking transaction support", e)
        true
    }
    val schema = upsertReq.schema
    val dialect = upsertReq.dialect
    val nullTypes = upsertReq.jdbcNullType
    val upsertSQL = upsertRow.upsertSQL
    val cols = upsertRow.cols

    try {
      if (supportsTransactions) {
        if (conn.getAutoCommit)
          conn.setAutoCommit(false) // Everything in the same db transaction.
        logInfo("First, start the transaction and set autoCommit to false!")
        committed = false
      }
      var statement: PreparedStatement = null
      try {
        statement = conn.prepareStatement(upsertSQL)
        var rowCount = 0
        while (iterator.hasNext) {
          val row = iterator.next()

          cols.zipWithIndex.foreach {
            case (col, idx) =>
              val i = row.fieldIndex(col)
              if (row.isNullAt(i)) {
                statement.setNull(idx + 1, nullTypes(i))
              } else {
                schema.fields(i).dataType match {
                  case IntegerType => statement.setInt(idx + 1, row.getInt(i))
                  case LongType => statement.setLong(idx + 1, row.getLong(i))
                  case DoubleType => statement.setDouble(idx + 1, row.getDouble(i))
                  case FloatType => statement.setFloat(idx + 1, row.getFloat(i))
                  case ShortType => statement.setInt(idx + 1, row.getShort(i))
                  case ByteType => statement.setInt(idx + 1, row.getByte(i))
                  case BooleanType => statement.setBoolean(idx + 1, row.getBoolean(i))
                  case StringType => statement.setString(idx + 1, row.getString(i))
                  case BinaryType => statement.setBytes(idx + 1, row.getAs[Array[Byte]](i))
                  case TimestampType => statement.setTimestamp(idx + 1, row.getAs[java.sql.Timestamp](i))
                  case DateType => statement.setDate(idx + 1, row.getAs[java.sql.Date](i))
                  case t: DecimalType => statement.setBigDecimal(idx + 1, row.getDecimal(i))
                  case ArrayType(et, _) =>
                    val array = conn.createArrayOf(
                      getJdbcType(et, dialect).databaseTypeDefinition.toLowerCase,
                      row.getSeq[AnyRef](i).toArray
                    )
                    statement.setArray(idx + 1, array)
                  case _ => throw new IllegalArgumentException(
                    s"Can't translate non-null value for field $i"
                  )
                }
              }
          }
          statement.addBatch()
          rowCount += 1
          if (rowCount % batchSize == 0) {
            statement.executeBatch()
// 最后一次性提交
//            if (supportsTransactions) {
//              conn.commit()
//            }
            rowCount = 0
          }
        }
        if (rowCount > 0) {
          statement.executeBatch()
        }
      } finally {
        if ( null != statement )
          statement.close()
      }

      if (supportsTransactions) {
        // 最后手动提交事务
        conn.commit()
        logInfo("Finally, manually commit the transaction successfully!")
        committed = true
      }
    } catch {
      case e:Exception =>
        logError(e.getMessage, e)
        committed = false
    } finally {
      if (supportsTransactions) {
        try {
          if ( !committed )
            conn.rollback() // 事务进行回滚
        } catch {
          case e: Exception => logWarning("Transaction rollback failed", e)
        }

        try {
          if ( !conn.getAutoCommit )
            conn.setAutoCommit(true) // 重新开启自动提交事务
        } catch {
          case e: Exception => logWarning("Connection reset autoCommit failed", e)
        }
      }

      // The stage must succeed.  We cannot propagate any exception close() might throw.
      try {
        if ( null != conn)
          conn.close()
      } catch {
        case e: Exception => logWarning("Transaction succeeded, but closing failed", e)
      }
    }
    committed
  }



  /**
    * 预备SQL语句行
    *
    * @param upsertReq       upsert请求对象
    * @param isCaseSensitive 区分大小写
    * @return UpsertRow
    */
  override def preparedStatementSQLRow(upsertReq: UpsertReq, isCaseSensitive: Boolean): UpsertRow = {
    val tableName = upsertReq.option.tableOrQuery
    val schema = upsertReq.schema
    val dialect = upsertReq.dialect
    val primaryKeys = upsertReq.primaryKeys

    // 没有主键
    if (primaryKeys.isEmpty) {
      val sql = JdbcUtils.getInsertStatement(tableName, schema, None, isCaseSensitive, dialect)
      val cols = schema.fields.map(_.name).toSeq
      return UpsertRow(sql, cols)
    }

    // 所有字段
    val columns = schema.fields
    // quoted
    val quotedColumns = columns.map(f => dialect.quoteIdentifier(f.name))
    // 占位符
    val placeholders = columns.map(_ => "?")
    // 主键keys
    val keys = primaryKeys.get
    // 更新字段
    val updateColumns = columns.map(_.name) diff keys
    // 更新字段 占位符
    val updatePlaceholders = updateColumns.map(_ => "?")
    val updateFields = updateColumns.map(dialect.quoteIdentifier).zip(updatePlaceholders).map(f => s"${f._1} = ${f._2}")

    val upsertSql =
      s"""insert into $tableName (${quotedColumns.mkString(",")}) values (${placeholders.mkString(",")})
         |ON DUPLICATE KEY UPDATE
         |${updateFields.mkString(",")}
         |;""".stripMargin

    logInfo(s"Mysql upsert using sql:\n $upsertSql")
    UpsertRow(upsertSql, columns.map(_.name) ++ updateColumns)
  }
}
