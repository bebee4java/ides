package tech.ides.datasource

import org.apache.spark.sql.{DataFrameWriter, Row}

/**
  * 数据存储接口
  * Created by songgr on 2020/11/05.
  */
trait DataWriter extends BaseDataSource {
  def save(writer: DataFrameWriter[Row], config: DataSinkConfig)
}
