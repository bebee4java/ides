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

  val SERVICE_IMPL = setting.get("service").map(_.asInstanceOf[String])

  val PLATFORM_LIFECYCLES = setting.get("platformLifecycles").map(_.asInstanceOf[util.List[String]].asScala)

  val SERVICE_LIFECYCLES = setting.get("serviceLifecycles").map(_.asInstanceOf[util.List[String]].asScala)

}
