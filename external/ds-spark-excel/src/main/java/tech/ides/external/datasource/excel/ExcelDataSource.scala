package tech.ides.external.datasource.excel

import tech.ides.datasource.{BaseDataSource, BaseFileDataSource, DataSource}
import tech.ides.datasource.DataSource.Method._
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl

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
class ExcelDataSource extends BaseFileDataSource {

  override def fullFormat: String = "com.crealytics.spark.excel"

  override def shortFormat: String = "excel"
}
