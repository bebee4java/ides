package tech.ides.metastore

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.{AtomicBoolean, AtomicReference}
import tech.ides.core.platform.PlatformManager
import tech.ides.conf.IdesConf.EXTERNAL_STORAGE_IMPL_CLASS_NAME
import tech.ides.storage.{ExternalStorage, ExternalStorageInfo}
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import collection.JavaConverters._

/**
  * 连接元数据存储
  * Created by songgr on 2021/02/23.
  */
object ConnectMetaStore extends Logging {
  private val connectMapping = new ConcurrentHashMap[ConnectMappingKey, Map[String, String]]()
  private[this] val externalStorage: AtomicReference[ExternalStorage] = new AtomicReference[ExternalStorage]
  private[this] val flag = new AtomicBoolean(false)
  if (!flag.get) {
    flag.synchronized {
      if (!flag.get) {
        try {
          // 加入持久化的连接信息
          connectMapping.putAll(initialize)
          logInfo("ConnectMetaStore initialized successfully! Catalog info: " + catalog.keys.mkString(","))
        } catch {
          case e: Exception =>
            logError(e.getMessage, e)
        }
        flag.set(true)
      }
    }
  }

  def storage = externalStorage.get()

  private[this] def initialize = {
    val conf = PlatformManager.getConf
    val storageImplClass = conf.get(EXTERNAL_STORAGE_IMPL_CLASS_NAME)
    val externalStorage = Reflection(ClassPath.from(storageImplClass)).instance[ExternalStorage]
    this.externalStorage.set(externalStorage)
    val connectMetaData = externalStorage.readConfig(ExternalStorageInfo.ConnectMetaData)
    connectMetaData.map{
      it =>
        val connectName = it._1
        val format = it._2.getOrElse("format", null)
        if (format == null) {
          (null, it._2)
        } else {
          (ConnectMappingKey(format, connectName), it._2)
        }
    }.filterNot(_._1 == null).asJava
  }

  def add(key:ConnectMappingKey, options:Map[String,String]) = {
    this.synchronized {
      connectMapping.put(key, options)
    }
  }

  def remove(key: ConnectMappingKey) = {
    this.synchronized {
      connectMapping.remove(key)
    }
  }

  def options(key: ConnectMappingKey) = catalog.get(key)

  def catalog = connectMapping.asScala.toMap
}

case class ConnectMappingKey(format:String, connectName:String) {
  override def toString: String = format + "." + connectName
}