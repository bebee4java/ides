package tech.ides.datasource.impl

import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row, SaveMode}
import java.util.Properties
import org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions
import tech.ides.datasource._
import tech.ides.datasource.DataSource.Method.{SINK, SOURCE}
import tech.ides.constants.ScriptConstants.{IMPL_CLASS, PRIMARY_KEYS}
import tech.ides.datasource.reader.{DataReader, Reader}
import tech.ides.datasource.writer.{DataWriter, Writer}
import tech.ides.dsl.utils.DslUtil
import tech.ides.exception.IdesException
import tech.ides.metastore.{ConnectMappingKey, ConnectMetaStore}
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl
import tech.ides.strategy.PlatformStrategyCenter.SparkDataTable

/**
  * JDBC 数据源
  * Created by songgr on 2021/03/02.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "jdbc",
  sinceVersion = "1.0.0"
)
@PlatformFrameImpl(frameName = SPARK)
class JDBCDataSource extends DataReader with DataWriter {
  override def pathSeparator: String = "."

  override def load(reader: Reader, config: DataSourceConfig): DataTable = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    var dbTable = config.path
    var url = config.config.get("url")
    val sparkDataReader = reader.getReader[DataFrameReader]

    if (config.path.contains(pathSeparator)) {
      val splitPath = "\\."
      val Array(db, table) = config.path.split(splitPath, 2)
      val connectMeta = ConnectMetaStore.options(ConnectMappingKey(format, db))
      if (connectMeta.isEmpty) throw new IdesException(s"Can't find the jdbc mapping of connection name: $db, please re-execute connect")
      dbTable = table
      val options = connectMeta.get
      sparkDataReader.options(options)
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
      sparkDataReader.options(config.config)
      sparkDataReader.jdbc(url.get, filterTable, predicates, new Properties())
    } else {
      if (config.config.contains("partitionColumn") && (!config.config.contains("lowerBound") || !config.config.contains("upperBound"))) {
        val partitionColumn = config.config("partitionColumn")
        // 自动查询分区字段的max/min值
        val boundSql = s"(select max($partitionColumn) as upper, min($partitionColumn) as lower from $dbTable $filter) t1"
        val bound = sparkDataReader.jdbc(url.get, boundSql, new Properties()).collect()(0)
        sparkDataReader.option("partitionColumn", partitionColumn)
        sparkDataReader.option("upperBound", bound.getLong(0))
        sparkDataReader.option("lowerBound", bound.getLong(1))
      }
      sparkDataReader.option("dbtable", filterTable)
      //使用当前配置覆盖连接信息
      sparkDataReader.options(config.config)
      sparkDataReader.format(format).load()
    }

    // 简洁字段名称 使其不带表名
    val columns = table.columns
      .map(DslUtil.cleanStr)
      .map(_.split("\\."))
      .map(it => if (it.length > 1) it.splitAt(1)._2.mkString(".") else it.head)

    val newDf = table.toDF(columns: _*)
    // todo 使用cache加速
    SparkDataTable(newDf)
  }

  override def save(writer: Writer, config: DataSinkConfig): Unit = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    var dbTable = config.path

    var options = config.config
    val sparkDataWriter = writer.getWriter[DataFrameWriter[Row]]
    if (dbTable.contains(pathSeparator)) {
      val splitPath = "\\."
      val Array(db, table) = dbTable.split(splitPath, 2)
      val connectMeta = ConnectMetaStore.options(ConnectMappingKey(format, db))
      if (connectMeta.isEmpty) throw new IdesException(s"Can't find the jdbc mapping of connection name: $db, please re-execute connect")
      dbTable = table
      val connOptions = connectMeta.get
      sparkDataWriter.options(connOptions)
      // 将两个配置合并，并且使用用当前的配置覆盖
      options = connOptions ++ options
    }
    val saveMode = SaveMode.valueOf(config.mode.name())

    sparkDataWriter.mode(saveMode)
    sparkDataWriter.option("dbtable", dbTable)
    // save configs should overwrite connect configs
    sparkDataWriter.options(options)

    if (options.contains(PRIMARY_KEYS)) {
      import org.apache.spark.sql.jdbc.DataFrameWriterExtensions._
      val jdbcOptions = new JDBCOptions( Map("dbtable" -> dbTable) ++ options)
      val df = config.dt.table[DataFrame].get
      sparkDataWriter.upsert( df, jdbcOptions, saveMode, Some(options(PRIMARY_KEYS)) )
    } else {
      sparkDataWriter.format(format).save()
    }
  }

  override def fullFormat: String = "jdbc"

  override def shortFormat: String = fullFormat
}
