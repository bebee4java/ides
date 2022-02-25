package tech.ides.datasource.writer

import tech.ides.datasource.{BaseDataSource, DataSinkConfig}

/**
 * 数据存储接口
 * Created by songgr on 2020/11/05.
 */
trait DataWriter extends BaseDataSource {
  def save(writer: Writer, config: DataSinkConfig)
}

abstract class Writer {
  def getWriter[T:Manifest]: T
}