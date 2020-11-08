package tech.ides.datasource

import tech.ides.platform.PlatformManager
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import org.apache.spark.IdesConf.IDES_DATASOURCE_PACKAGES
import tech.ides.constants.ScriptConstants
import tech.sqlclub.common.log.Logging

import scala.collection.JavaConverters._

/**
  * 数据类工厂: 注册/获取 数据源
  * Created by songgr on 2020/10/25.
  */
object DataSourceFactory extends Logging {

  // 数据源注册表
  private val registry = new java.util.HashMap[DataSourceKey, BaseDataSource]()

  def listName() = registry.keySet().asScala.map(_.name).toSet

  /**
    * 注册所有数据源
    */
  def register: Unit = {
    val dataSourceDefaultPackages = Array("tech.ides.external.datasource", "tech.ides.datasource.impl")
    val option = PlatformManager.getConf.get(IDES_DATASOURCE_PACKAGES)
    val userDatasourcePackages = if (option.isDefined) {
      option.get.split(",").filter(_.nonEmpty).map(_.trim)
    } else {Array[String]()}

    val scanPackages = dataSourceDefaultPackages ++ userDatasourcePackages

    logInfo("look for the DataSource plugin from packages: " + scanPackages.mkString(", "))

    val allDataSource = Reflection.allClassWithAnnotation(classOf[DataSource], scanPackages:_*)
    allDataSource.foreach {
      dataSourceClass =>
        val annotation = Reflection.getAnnotation(dataSourceClass, classOf[DataSource])
        val dataSourceInstace = Reflection(ClassPath.from(dataSourceClass)).instance[BaseDataSource]
        val direct = annotation.directDataSource()

        registry.put(DataSourceKey(dataSourceInstace.aliasFormat, direct), dataSourceInstace)
        registry.put(DataSourceKey(dataSourceInstace.fullFormat, direct), dataSourceInstace)
    }
    logInfo(s"A total of ${allDataSource.size} dataSource plugins scanned!")
  }

  def take(name:String, options:Map[String,String]=Map()): Option[BaseDataSource] = {
    val direct = options.contains(ScriptConstants.DIRECT_QUERY)
    val key = DataSourceKey(name, direct)
    if (registry.containsKey(key)) {
      Some(registry.get(key))
    } else {
      None
    }
  }

}
