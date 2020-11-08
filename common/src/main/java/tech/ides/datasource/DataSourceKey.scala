package tech.ides.datasource

import org.apache.spark.sql.{DataFrame, SaveMode}

/**
  *
  * Created by songgr on 2020/11/05.
  */

case class DataSourceKey(name:String, direct:Boolean)

case class DataSourceConfig(path: String, config: Map[String, String], df: Option[DataFrame] = None)

case class DataSinkConfig(path: String, config: Map[String, String], mode: SaveMode, df: Option[DataFrame] = None)
