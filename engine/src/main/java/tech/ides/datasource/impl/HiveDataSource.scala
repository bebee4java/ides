package tech.ides.datasource.impl

import org.apache.hadoop.hive.custom.inputformat.MultiLineCSVInputFormat
import org.apache.hadoop.hive.custom.serde.OpenCSVSerde
import org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.datasource._
import tech.ides.datasource.DataSource.Method.{SINK, SOURCE}
import tech.ides.constants.ScriptConstants.{FILE_FORMAT, IMPL_CLASS, PARTITION_BY_COL}
import tech.ides.exception.IdesException
import tech.sqlclub.common.utils.StringEscapeUtils

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

    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val fileFormat = config.config.getOrElse(FILE_FORMAT, "parquet")

    var options = config.config - FILE_FORMAT - IMPL_CLASS

    // 只支持'sequencefile', 'rcfile', 'orc', 'parquet', 'textfile' 'avro' 6种类型
    // 参考：https://spark.apache.org/docs/latest/sql-data-sources-hive-tables.html
    options += (FILE_FORMAT -> ( if ("csv" == fileFormat) "textfile" else fileFormat ))  // csv转成textfile格式

    val containsDelimiters = HiveOptions.delimiterOptions.keys.exists(options.contains)
    if (containsDelimiters &&  "textfile" != options(FILE_FORMAT) ) {
      throw new IdesException(s"""These options:[${HiveOptions.delimiterOptions.keys.mkString(", ")}] can only be used with "textfile/csv" fileFormat. They define how to read delimited files into rows.""")
    }

    if (containsDelimiters) {
//      fieldDelim, escapeDelim, collectionDelim, mapkeyDelim, lineDelim
      HiveOptions.delimiterOptions.keys.foreach {
        // 将delimiter options都进行反向转义
        k =>
          options.get(k).foreach(v => options = options.updated(k, StringEscapeUtils.unescapeJava(v)))
      }
    }

    if ( "csv" == fileFormat && options.getOrElse("multiline", "false").toBoolean ) {
      // 先判断所有字段是否是String类型
      val table = config.df.get
      val notStringCols = table.schema.filterNot(_.dataType == StringType)
      // TextFileFormat只支持StringType可以参考supportDataType方法
      if (notStringCols.nonEmpty) throw new IdesException("All fields must be String type when stored as csv type!")
      // 解决csv中存在换行问题
      options = options.updated("serde", classOf[OpenCSVSerde].getName) // 使用自定义serde
      // 使用自定义FileInputFormat
      options = options.updated("inputFormat", classOf[MultiLineCSVInputFormat].getName)
      options = options.updated("outputFormat", classOf[HiveIgnoreKeyTextOutputFormat[_,_]].getName)

      options = options - FILE_FORMAT // 不能同时指定 fileFormat 和 inputFormat/outputFormat
    }

    val containsSerdeOptions = HiveOptions.openCSVSerdeOptions.exists(options.contains)
    if ( containsSerdeOptions ) {
      // 将serde options 进行转义
      HiveOptions.openCSVSerdeOptions.foreach {
        k =>
          options.get(k).foreach(v => options = options.updated(k, StringEscapeUtils.unescapeJava(v)))
      }
    }
    writer.format(format).options(options).mode(config.mode).saveAsTable(config.path)
  }

  override def fullFormat: String = "hive"

  override def shortFormat: String = fullFormat
}

object HiveOptions {

  val delimiterOptions = Map(
    "fieldDelim" -> "field.delim",
    "escapeDelim" -> "escape.delim",
    // The following typo is inherited from Hive...
    "collectionDelim" -> "colelction.delim",
    "mapkeyDelim" -> "mapkey.delim",
    "lineDelim" -> "line.delim")

  val openCSVSerdeOptions = Set(
    OpenCSVSerde.SEPARATORCHAR, // separatorChar
    OpenCSVSerde.QUOTECHAR, // quoteChar
    OpenCSVSerde.ESCAPECHAR // escapeChar
  )

}