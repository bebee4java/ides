package tech.ides.datasource.impl

import org.apache.spark.sql.types.StringType
import tech.ides.datasource.DataSource.Method._
import tech.ides.datasource.{BaseFileDataSource, DataSinkConfig, DataSource, DataSourceConfig, DataTable, SparkDataTable}
import tech.ides.constants.ScriptConstants.IMPL_CLASS
import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row, SaveMode, functions => F}
import tech.ides.datasource.reader.Reader
import tech.ides.datasource.writer.Writer
import tech.ides.exception.IdesException
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl

/**
  * CSV 文件数据源
  * Created by songgr on 2020/10/26.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "text",
  sinceVersion = "1.0.0"
)
@PlatformFrameImpl(frameName = SPARK)
class TextDataSource extends BaseFileDataSource {

  override def load(reader: Reader, config: DataSourceConfig): DataTable = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val paths = config.path.split(",").map(_.trim).filter(_.nonEmpty)
    val sparkDataReader = reader.getReader[DataFrameReader]
    val df = sparkDataReader.options(config.config).format(format).text(paths: _*)
    val dataFrame = df.select(F.input_file_name().as("fileName"), F.col("value").as("content"))
    SparkDataTable(dataFrame)
  }

  override def save(writer: Writer, config: DataSinkConfig): Unit = {
    val options = config.config
    val sparkDataWriter = writer.getWriter[DataFrameWriter[Row]]
    val saveMode = SaveMode.valueOf(config.mode.name())
    if (options.contains("usingCol") && config.dt.table.isDefined) {
      val col = options("usingCol")

      val table = config.dt.table[DataFrame].get
      if ( !table.columns.contains(col) ) throw new IdesException(s""" cannot resolve '`$col`' given input columns: [${table.columns.mkString(", ")}]; """)

      val finalTable = if ( StringType != table.schema.apply(col).dataType ) {
        table.select(F.col(col).cast(StringType).as("value"))
      } else {
        table.select(F.col(col).as("value"))
      }

      finalTable.write.options(options).mode(saveMode).text(config.path)
    } else sparkDataWriter.options(options).mode(saveMode).format(fullFormat).save(config.path)
  }

  override def fullFormat: String = "text"

  override def shortFormat: String = fullFormat
}
