package tech.ides.datasource.impl

import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.datasource.DataSource.Method._
import tech.ides.datasource.{BaseFileDataSource, DataSinkConfig, DataSource, DataSourceConfig}
import tech.ides.constants.ScriptConstants.IMPL_CLASS
import org.apache.spark.sql.{functions => F}
import tech.ides.exception.IdesException

/**
  * CSV 文件数据源
  * Created by songgr on 2020/10/26.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "text",
  sinceVersion = "1.0.0"
)
class TextDataSource extends BaseFileDataSource {

  override def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame = {
    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val paths = config.path.split(",").map(_.trim).filter(_.nonEmpty)
    val df = reader.options(config.config).format(format).text(paths: _*)

    df.select(F.input_file_name().as("fileName"), F.col("value").as("content"))

  }

  override def save(writer: DataFrameWriter[Row], config: DataSinkConfig): Unit = {
    val options = config.config
    if (options.contains("usingCol") && config.df.isDefined) {
      val col = options("usingCol")

      val table = config.df.get
      if ( !table.columns.contains(col) ) throw new IdesException(s""" cannot resolve '`$col`' given input columns: [${table.columns.mkString(", ")}]; """)

      val finalTable = if ( StringType != table.schema.apply(col).dataType ) {
        table.select(F.col(col).cast(StringType).as("value"))
      } else {
        table.select(F.col(col).as("value"))
      }

      finalTable.write.options(options).mode(config.mode).text(config.path)
    } else writer.options(options).mode(config.mode).format(fullFormat).save(config.path)
  }

  override def fullFormat: String = "text"

  override def shortFormat: String = fullFormat
}
