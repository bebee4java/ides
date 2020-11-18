package tech.ides.datasource.impl

import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.datasource._
import tech.ides.datasource.DataSource.Method.{SINK, SOURCE}
import tech.ides.constants.ScriptConstants.{IMPL_CLASS, PARTITION_BY_COL}

/**
  * Hive 数据源
  * Created by songgr on 2020/11/18.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "hive",
  sinceVersion = "1.0.0"
)
class HiveDataSource extends DataReader with DataWriter{
  override def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    reader.options(config.config).format(format).table(config.path)
  }

  override def save(writer: DataFrameWriter[Row], config: DataSinkConfig): Unit = {

    val fileFormat = config.config.getOrElse("fileFormat", "parquet")

    var options = config.config - "fileFormat" - IMPL_CLASS

    // 只支持'sequencefile', 'rcfile', 'orc', 'parquet', 'textfile' 'avro' 6种类型
    // 参考：https://spark.apache.org/docs/latest/sql-data-sources-hive-tables.html
    options += ("fileFormat" -> ( if ("csv" == fileFormat) "textfile" else fileFormat ))

    //todo 这里有点问题 \t 变成了\\t

    // 如果需要分区 进行partitionBy
    options.get(PARTITION_BY_COL).map(partitionColumn => partitionColumn.split(",").filterNot(_.isEmpty))
      .filterNot(_.length == 0)
      .map(partitionColumns => writer.partitionBy(partitionColumns: _*))

    writer.format(fullFormat).options(options).mode(config.mode).saveAsTable(config.path)
  }

  override def fullFormat: String = "hive"

  override def shortFormat: String = fullFormat
}
