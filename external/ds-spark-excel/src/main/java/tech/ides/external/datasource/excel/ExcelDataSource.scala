package tech.ides.external.datasource.excel

import org.apache.hadoop.hdfs.HdfsOperator
import org.apache.spark.sql.{DataFrame, DataFrameReader}
import tech.ides.constants.ScriptConstants.IMPL_CLASS
import tech.ides.core.ScriptQueryExecute
import tech.ides.datasource.{BaseFileDataSource, DataSource, DataSourceConfig, DataTable}
import tech.ides.datasource.DataSource.Method._
import tech.ides.datasource.reader.Reader
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl
import tech.ides.strategy.PlatformStrategyCenter.SparkDataTable
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.utils.Assert
import scala.collection.mutable.ListBuffer

/**
  *
  * Created by songgr on 2020/10/25.
  */

@DataSource(
  types = Array(SOURCE, SINK),
  name = "excel",
  sinceVersion = "1.0.0"
)
@PlatformFrameImpl(frameName = SPARK)
class ExcelDataSource extends BaseFileDataSource with Logging {

  override def load(reader: Reader, config: DataSourceConfig): DataTable = {
    Assert.isNotEmpty(config.path, "excel path must be non-empty!")
    val fileList = new ListBuffer[String]()

    config.path.split(",").foreach( path => {
      val isFile = HdfsOperator.isFile(path)
      if (isFile) {
        fileList += path
      } else {
        val files = HdfsOperator.listFiles(path)
        files.foreach(file => fileList += file.getPath.toString)
      }
    })

    log.info("read excel file list: {}", fileList)
    if (fileList.isEmpty) {
      val spark = ScriptQueryExecute.context.execListener.sparkSession
      return SparkDataTable(spark.emptyDataFrame)
    }

    val format = config.config.getOrElse(IMPL_CLASS, fullFormat)
    val sparkDataReader = reader.getReader[DataFrameReader]

    // 读取excel
    val readExcel = (file: String) => sparkDataReader.options(config.config).format(format).load(file)

    val dataFrame = if (fileList.size > 1) fileList.map(readExcel).reduce(_ union _) else readExcel(fileList.head)
    SparkDataTable(dataFrame)
  }

  override def fullFormat: String = "com.crealytics.spark.excel"

  override def shortFormat: String = "excel"
}
