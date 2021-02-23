package tech.ides.storage

import org.apache.spark.sql.DataFrame
import tech.ides.storage.ExternalStorageInfo.StorageInfo

/**
  * 外部存储数据接口
  * Created by songgr on 2021/02/15.
  */
trait ExternalStorage {

  def rootPath = "__datalinked__/externalStorage"

  def readConfig(configId:String, storageInfo:StorageInfo, key:String): Option[String]

  def readConfig(configId:String, storageInfo:StorageInfo):Map[String, String]

  def readConfig(storageInfo:StorageInfo):Map[String,Map[String,String]]

  def saveConfig(configId:String, storageInfo:StorageInfo, key:String, value:String, overwrite:Boolean):Unit

  def saveConfig(configId:String, storageInfo:StorageInfo, configMap:Map[String,String], overwrite:Boolean):Unit

  def readAsTable(tableName:String):DataFrame

  def saveAsTable(tableName:String, table:DataFrame, overwrite:Boolean):Unit

}

object ExternalStorageInfo extends Enumeration {
  type StorageInfo = Value
  val ConnectMetaData = Value("connectMetaData")
}