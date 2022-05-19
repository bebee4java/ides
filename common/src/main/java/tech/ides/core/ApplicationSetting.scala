package tech.ides.core

import tech.sqlclub.common.context.YamlContext
import java.util
import scala.collection.JavaConverters._

/**
  * 读取application.yml配置，解析成每个参数
  * Created by songgr on 2021/03/11.
  */
object ApplicationSetting {

  private lazy val setting = YamlContext.getAnyRefMap("application")

  def getAllSettings: Map[String, AnyRef] = {
    setting.toMap
  }

  def getSetting(key: String): Option[AnyRef] = {
    setting.get(key)
  }

  def getList(key: String): List[Map[String, AnyRef]] = {
    getSetting(key).map(x => {
      x.asInstanceOf[util.List[util.Map[String, AnyRef]]].asScala.toList.map(y => y.asScala.toMap)
    }).getOrElse(List.empty)
  }

  def getString(key: String): String = {
   getSetting(key).map(x => x.asInstanceOf[String]).orNull
  }

  def getInt(key: String): Int = {
    getSetting(key).map(x => x.asInstanceOf[Int]).getOrElse(0)
  }

  def getDouble(key: String): Double = {
    getSetting(key).map(x => x.asInstanceOf[Double]).getOrElse(0D)
  }

  def getOptionString(key: String): Option[String] = {
    getSetting(key).map(x => x.asInstanceOf[String])
  }

  val SERVICE_IMPL = setting.get("service").map(_.asInstanceOf[String])

  val PLATFORM_LIFECYCLES = setting.get("platformLifecycles").map(_.asInstanceOf[util.List[String]].asScala)

  val SERVICE_LIFECYCLES = setting.get("serviceLifecycles").map(_.asInstanceOf[util.List[String]].asScala)

}
