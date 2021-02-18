package tech.ides.storage

import org.apache.spark.sql.DataFrame

/**
  * 外部存储数据接口
  * Created by songgr on 2021/02/15.
  */
trait ExternalStorage {

  def rootPath = "__datalinked__/externalStorage"

  def readConfig(configId:String, key:String): Option[String]

  def readConfig(configId:String):Map[String, String]

  def saveConfig(configId:String, key:String, value:String, overwrite:Boolean):Unit

  def saveConfig(configId:String, configMap:Map[String,String], overwrite:Boolean):Unit

  def readAsTable(tableName:String):DataFrame

  def saveAsTable(tableName:String, table:DataFrame, overwrite:Boolean):Unit

}
