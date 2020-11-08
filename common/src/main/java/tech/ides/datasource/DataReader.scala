package tech.ides.datasource

import org.apache.spark.sql.{DataFrame, DataFrameReader}


/**
  * 数据读取接口
  * Created by songgr on 2020/11/05.
  */
trait DataReader extends BaseDataSource {
  def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame
}
