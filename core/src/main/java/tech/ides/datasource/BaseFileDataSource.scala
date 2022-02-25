package tech.ides.datasource

import org.apache.spark.sql.{DataFrameReader, DataFrameWriter, Row, SaveMode}
import tech.ides.constants.ScriptConstants.{IMPL_CLASS, PARTITION_BY_COL}
import tech.ides.datasource.reader.{DataReader, Reader}
import tech.ides.datasource.writer.{DataWriter, Writer}
import tech.ides.strategy.PlatformFrameImpl
import tech.ides.strategy.PlatformFrameEnum.{FLINK, SPARK}
import tech.ides.strategy.PlatformStrategyCenter.SparkDataTable

/**
  * 文件基本类型数据
  * Created by songgr on 2020/11/05.
  */
@PlatformFrameImpl(frameName = SPARK)
abstract class BaseFileDataSource extends DataReader with DataWriter {

  override def load(reader: Reader, config: DataSourceConfig): DataTable = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val sparkDataReader = reader.getReader[DataFrameReader]
    val dataFrame = sparkDataReader.options(config.config).format(format).load(config.path)
    SparkDataTable(dataFrame)
  }

  override def save(writer: Writer, config: DataSinkConfig): Unit = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val partitionByCol = config.config.getOrElse(PARTITION_BY_COL, "").split(",").filterNot(_.isEmpty)
    val sparkDataWriter = writer.getWriter[DataFrameWriter[Row]]
    if (partitionByCol.length > 0) {
      sparkDataWriter.partitionBy(partitionByCol: _*)
    }
    val saveMode = SaveMode.valueOf(config.mode.name())
    sparkDataWriter.options(config.config).mode(saveMode).format(format).save(config.path)
  }
}
