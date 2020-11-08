package tech.ides.datasource.impl

import tech.ides.datasource.{BaseFileDataSource, DataSource}
import tech.ides.datasource.DataSource.Method._

/**
  * CSV 文件数据源
  * Created by songgr on 2020/10/26.
  */
@DataSource(
  types = Array(SOURCE, SINK),
  name = "csv",
  sinceVersion = "1.0.0"
)
class CSVDataSource extends BaseFileDataSource {

  override def fullFormat: String = "csv"

  override def shortFormat: String = "csv"
}
