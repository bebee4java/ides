package tech.ides.datasource.impl

import java.util.Properties
import org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions
import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.datasource._
import tech.ides.datasource.DataSource.Method.{SINK, SOURCE}
import tech.ides.constants.ScriptConstants.{IMPL_CLASS, PRIMARY_KEYS}
import tech.ides.dsl.utils.DslUtil
import tech.ides.exception.IdesException
import tech.ides.metastore.{ConnectMappingKey, ConnectMetaStore}
import tech.sqlclub.common.utils.StringEscapeUtils

/**
  * JDBC 数据源
  * Created by songgr on 2021/03/02.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "jdbc",
  sinceVersion = "1.0.0"
)
class JDBCDataSource extends DataReader with DataWriter {
  override def pathSeparator: String = "."

  override def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    var dbTable = config.path
    var url = config.config.get("url")

    if (config.path.contains(pathSeparator)) {
      val splitPath = StringEscapeUtils.unescapeJava(pathSeparator)
      val Array(db, table) = config.path.split(splitPath, 2)
      val connectMeta = ConnectMetaStore.options(ConnectMappingKey(format, db))
      if (connectMeta.isEmpty) throw new IdesException(s"Can't find the jdbc mapping of connection name: $db, please re-execute connect")
      dbTable = table
      val options = connectMeta.get
      reader.options(options)
      url = options.get("url")
    }
    // 字段选择默认全选
    val cols = config.config.getOrElse("cols", "*")
    // 过滤条件默认为空
    val filter = if (config.config.contains("filter")) {
      " where " + config.config("filter")
    } else {
      ""
    }
    // 组装table 包含字段/过滤条件
    val filterTable =  if ( filter.nonEmpty || !"*".equals(cols) ) {
      s"(select $cols from $dbTable $filter) $dbTable"
    } else dbTable

    val table = if (config.config.contains("prePtConditions")) {
      // 预分区条件
      val predicates = config.config("prePtConditions")
        .split(config.config.getOrElse("prePtConditionsDelim", ","))

      //使用当前配置覆盖连接信息
      reader.options(config.config)
      reader.jdbc(url.get, filterTable, predicates, new Properties())
    } else {
      if (config.config.contains("partitionColumn") && (!config.config.contains("lowerBound") || !config.config.contains("upperBound"))) {
        val partitionColumn = config.config("partitionColumn")
        // 自动查询分区字段的max/min值
        val boundSql = s"(select max($partitionColumn) as upper, min($partitionColumn) as lower from $dbTable $filter) t1"
        reader.option("partitionColumn", partitionColumn)
        val bound = reader.jdbc(url.get, boundSql, new Properties()).collect()(0)
        reader.option("upperBound", bound.getLong(0))
        reader.option("lowerBound", bound.getLong(1))
      }
      reader.option("dbtable", filterTable)
      //使用当前配置覆盖连接信息
      reader.options(config.config)
      reader.format(format).load()
    }

    // 简洁字段名称 使其不带表名
    val columns = table.columns
      .map(DslUtil.cleanStr)
      .map(_.split("\\."))
      .map(it => if (it.length > 1) it.splitAt(1)._2.mkString(".") else it.head)

    val newDf = table.toDF(columns: _*)
    // todo 使用cache加速
    newDf
  }

  override def save(writer: DataFrameWriter[Row], config: DataSinkConfig): Unit = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    var dbTable = config.path

    var options = config.config
    if (dbTable.contains(pathSeparator)) {
      val splitPath = StringEscapeUtils.unescapeJava(pathSeparator)
      val Array(db, table) = dbTable.split(splitPath, 2)
      val connectMeta = ConnectMetaStore.options(ConnectMappingKey(format, db))
      if (connectMeta.isEmpty) throw new IdesException(s"Can't find the jdbc mapping of connection name: $db, please re-execute connect")
      dbTable = table
      val connOptions = connectMeta.get
      writer.options(connOptions)
      // 将两个配置合并，并且使用用当前的配置覆盖
      options = connOptions ++ options
    }

    writer.mode(config.mode)
    writer.option("dbtable", dbTable)
    // save configs should overwrite connect configs
    writer.options(options)

    if (options.contains(PRIMARY_KEYS)) {
      import org.apache.spark.sql.jdbc.DataFrameWriterExtensions._
      val jdbcOptions = new JDBCOptions( Map("dbtable" -> dbTable) ++ options)
      writer.upsert( config.df.get, jdbcOptions, config.mode, Some(options(PRIMARY_KEYS)) )
    } else {
      writer.format(format).save()
    }
  }

  override def fullFormat: String = "jdbc"

  override def shortFormat: String = fullFormat
}
