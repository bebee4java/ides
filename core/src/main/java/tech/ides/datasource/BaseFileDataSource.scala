package tech.ides.datasource

import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.constants.ScriptConstants.{IMPL_CLASS, PARTITION_BY_COL}

/**
  * 文件基本类型数据
  * Created by songgr on 2020/11/05.
  */
abstract class BaseFileDataSource extends DataReader with DataWriter {
  override def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    reader.options(config.config).format(format).load(config.path)
  }

  override def save(writer: DataFrameWriter[Row], config: DataSinkConfig): Unit = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val partitionByCol = config.config.getOrElse(PARTITION_BY_COL, "").split(",").filterNot(_.isEmpty)
    if (partitionByCol.length > 0) {
      writer.partitionBy(partitionByCol: _*)
    }
    writer.options(config.config).mode(config.mode).format(format).save(config.path)
  }
}
