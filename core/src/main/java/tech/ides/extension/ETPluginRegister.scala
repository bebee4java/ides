package tech.ides.extension

import org.apache.spark.IdesConf
import org.apache.spark.IdesConf.IDES_PLUGIN_PACKAGES
import tech.ides.core.platform.PlatformLifecycle
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.reflect.{ClassPath, Reflection}

/**
 * ET插件注册入口
 * Created by songgr on 2022/02/16.
 */
object ETPluginRegister extends PlatformLifecycle with Logging {

  // et插件注册表
  private val registry = new java.util.HashMap[String, ETPlugin]()

  /**
   * 注册所有ET插件
   */
  def register(idesConf: IdesConf): Unit = {
    val etDefaultPackages = Array("tech.ides.external.ets", "tech.ides.ets")
    val option = idesConf.get(IDES_PLUGIN_PACKAGES)
    val userETPackages = option.map(packages => packages.split(",").filter(_.nonEmpty).map(_.trim))
      .getOrElse(Array[String]())

    val scanPackages = etDefaultPackages ++ userETPackages
    logInfo("look for the et plugin from packages: " + scanPackages.mkString(", "))

    val allETs = Reflection.allClassWithAnnotation(classOf[Extension], scanPackages:_*)
    val ets = allETs.map {
      etClass =>
        val annotation = Reflection.getAnnotation(etClass, classOf[Extension])
        val etInstace = Reflection(ClassPath.from(etClass)).instance[ETPlugin]
        val etName = annotation.name()

        registry.put(etName, etInstace)
        etName
    }
    logInfo(s"""A total of ${allETs.size} ET plugins scanned: [${ets.mkString(", ")}].""")
  }

  def find(etName:String, options:Map[String,String]=Map()):Option[ETPlugin] = {
    if (registry.containsKey(etName)) {
      Some(registry.get(etName))
    } else {
      None
    }
  }

  override def beforeSQLRuntime(idesConf: IdesConf): Unit = { register(idesConf) }

  override def afterSQLRuntime(idesConf: IdesConf): Unit = {}
}
