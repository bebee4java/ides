package tech.ides.storage

import tech.ides.storage.ExternalStorageInfo.StorageInfo

/**
  * 外部存储数据接口
  * Created by songgr on 2021/02/15.
  */
trait ExternalStorage {

  def rootPath = "__datalinked__/externalStorage"

  /**
   * 获取指定配置项
   */
  def readConfig(configId:String, storageInfo:StorageInfo, key:String): Option[String]

  /**
   * 获取指定configId的所有配置项
   */
  def readConfig(configId:String, storageInfo:StorageInfo):Map[String, String]

  /**
   *获取所有配置项
   */
  def readConfig(storageInfo:StorageInfo):Map[String,Map[String,String]]

  /**
   * 保存单个配置项
   */
  def saveConfig(configId:String, storageInfo:StorageInfo, key:String, value:String, overwrite:Boolean):Unit

  /**
   * 保存所有配置项
   */
  def saveConfig(configId:String, storageInfo:StorageInfo, configMap:Map[String,String], overwrite:Boolean):Unit

  /**
   * 删除指定configId的所有配置
   */
  def dropConfig(configId:String, storageInfo:StorageInfo):Boolean

}

object ExternalStorageInfo extends Enumeration {
  type StorageInfo = Value
  val ConnectMetaData = Value("connectMetaData")
}