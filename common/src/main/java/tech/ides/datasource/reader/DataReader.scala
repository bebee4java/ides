package tech.ides.datasource.reader

import tech.ides.datasource.{BaseDataSource, DataSourceConfig, DataTable}

/**
 * 数据读取接口
 * Created by songgr on 2020/11/05.
 */
trait DataReader extends BaseDataSource {
  def load(reader: Reader, config: DataSourceConfig): DataTable
}
abstract class Reader {
  def getReader[T:Manifest]: T
}