package tech.ides.storage.impl

import tech.ides.core.ApplicationSetting
import tech.ides.storage.ExternalStorage
import tech.ides.storage.ExternalStorageInfo.StorageInfo
import tech.sqlclub.common.exception.SQLClubException
import tech.sqlclub.common.utils.Assert

/**
 * external storage implement by yaml config file
 * Created by songgr on 2022/05/19.
 */
class YamlFileExternalStorage extends ExternalStorage {
  /**
   * 获取指定配置项
   */
  override def readConfig(configId: String, storageInfo: StorageInfo, key: String): Option[String] = {
    readConfig(configId, storageInfo).get(key)
  }

  /**
   * 获取指定configId的所有配置项
   */
  override def readConfig(configId: String, storageInfo: StorageInfo): Map[String, String] = {
    readConfig(storageInfo).getOrElse(configId, Map.empty[String, String])
  }

  /**
   * 获取所有配置项
   */
  override def readConfig(storageInfo: StorageInfo): Map[String, Map[String, String]] = {
    ApplicationSetting.getList(storageInfo.toString).map(item => {
      Assert.isTrue(item.contains("name"), "config name is not defined")
      val name = item("name").asInstanceOf[String]
      val m = item - "name"
      name -> m.map(it => it._1 -> it._2.asInstanceOf[String])
    }).toMap
  }

  /**
   * 保存单个配置项
   */
  override def saveConfig(configId: String, storageInfo: StorageInfo, key: String, value: String, overwrite: Boolean): Unit = {
    throw new SQLClubException(s"${getClass.getName} not support saveConfig !")
  }

  /**
   * 保存所有配置项
   */
  override def saveConfig(configId: String, storageInfo: StorageInfo, configMap: Map[String, String], overwrite: Boolean): Unit = {
    throw new SQLClubException(s"${getClass.getName} not support saveConfig !")
  }

  /**
   * 删除指定configId的所有配置
   */
  override def dropConfig(configId: String, storageInfo: StorageInfo): Boolean = {
    throw new SQLClubException(s"${getClass.getName} not support dropConfig !")
  }

}
