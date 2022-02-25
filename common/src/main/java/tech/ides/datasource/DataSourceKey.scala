package tech.ides.datasource

import tech.ides.datasource.DataSource.Method
import tech.ides.datasource.writer.SaveMode

/**
  *
  * Created by songgr on 2020/11/05.
  */

case class DataSourceKey(name:String, method:Method, direct:Boolean)

case class DataSourceConfig(path: String, config: Map[String, String], dt: DataTable)

case class DataSinkConfig(path: String, config: Map[String, String], mode: SaveMode, dt: DataTable)
