package tech.ides.datasource

import tech.ides.core.platform.PlatformLifecycle
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import tech.ides.conf.IdesConf.IDES_DATASOURCE_PACKAGES
import tech.ides.conf.IdesConf
import tech.ides.constants.ScriptConstants
import tech.ides.datasource.DataSource.Method
import tech.ides.utils.PlatformUtils
import tech.sqlclub.common.log.Logging

import scala.collection.JavaConverters._

/**
  * 数据类工厂: 注册/获取 数据源
  * Created by songgr on 2020/10/25.
  */
object DataSourceFactory extends PlatformLifecycle with Logging {

  // 数据源注册表
  private val registry = new java.util.HashMap[DataSourceKey, BaseDataSource]()

  def listName() = registry.keySet().asScala.map(_.name).toSet

  def findBothNames(name:String) = {
    registry.asScala.find(_._1.name == name).map(it => Set(it._2.fullFormat, it._2.aliasFormat))
  }

  /**
    * 注册所有数据源
    */
  def register(idesConf: IdesConf): Unit = {
    val dataSourceDefaultPackages = Array("tech.ides.external.datasource", "tech.ides.datasource.impl")
    val option = idesConf.get(IDES_DATASOURCE_PACKAGES)
    val userDatasourcePackages = if (option.isDefined) {
      option.get.split(",").filter(_.nonEmpty).map(_.trim)
    } else {Array[String]()}

    val scanPackages = dataSourceDefaultPackages ++ userDatasourcePackages

    logInfo("look for the DataSource plugin from packages: " + scanPackages.mkString(", "))

    val allDataSource = Reflection.allClassWithAnnotation(classOf[DataSource], scanPackages:_*)
    val ds = allDataSource.filter {
      dataSourceClass =>
        // 跳过 实现框架不一致的ds
        PlatformUtils.frameworkEquals(idesConf, dataSourceClass)
    }.map {
      dataSourceClass =>
        val annotation = Reflection.getAnnotation(dataSourceClass, classOf[DataSource])
        val dataSourceInstace = Reflection(ClassPath.from(dataSourceClass)).instance[BaseDataSource]
        val direct = annotation.directDataSource()
        val sourceTypes = annotation.types()

        if (sourceTypes != null && sourceTypes.nonEmpty) {
          sourceTypes.foreach(
            sourceType => {
              registry.put(DataSourceKey(dataSourceInstace.aliasFormat,sourceType, direct), dataSourceInstace)
              registry.put(DataSourceKey(dataSourceInstace.fullFormat, sourceType, direct), dataSourceInstace)
            }
          )
        }
        annotation.name()
    }

    logInfo(s"""A total of ${allDataSource.size} dataSource plugins scanned: [${ds.mkString(", ")}].""")
  }

  def take(name:String, sourceType:Method, options:Map[String,String]=Map()): Option[BaseDataSource] = {
    val direct = options.contains(ScriptConstants.DIRECT_QUERY)
    val key = DataSourceKey(name, sourceType, direct)
    if (registry.containsKey(key)) {
      Some(registry.get(key))
    } else {
      None
    }
  }

  override def beforeSQLRuntime(idesConf: IdesConf): Unit = { register(idesConf) }

  override def afterSQLRuntime(idesConf: IdesConf): Unit = {}
}