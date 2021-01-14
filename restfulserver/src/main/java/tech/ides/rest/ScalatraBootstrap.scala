package tech.ides.rest

import javax.servlet.ServletContext
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.{LifeCycle, ScalatraServlet}
import org.scalatra.swagger.{ApiInfo, JacksonSwaggerBase, Swagger}
import tech.ides.core.platform.PlatformManager
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import scala.collection.mutable

/**
  *
  * Created by songgr on 2020/06/22.
  */
class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with JacksonSwaggerBase {
    override implicit val jsonFormats: Formats = DefaultFormats
}

object SwaggerApiInfo extends ApiInfo(
  "The DESC API",
  "Docs for the DESC API",
  "https://github.com/bebee4java/ides",
  "grsong.cn@gmail.com",
  "LICENSE",
  "https://github.com/bebee4java/ides/blob/master/LICENSE"
)

class SwaggerInfo(override val apiVersion: String) extends Swagger(Swagger.SpecVersion, apiVersion, SwaggerApiInfo)

object SwaggerInfo {
  import tech.ides.IDES_VERSION
  implicit val swagger = new SwaggerInfo(IDES_VERSION)
}

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {
    import SwaggerInfo._
    context.mount(new ResourcesApp, "/api-docs")
    ControlHandlerHook.allHandlers.foreach {
      handler =>
        context.mount(handler, "/*")
    }
  }
}

object ControlHandlerHook extends Logging {

  import org.scalatra.Handler
  private val _handlers = mutable.Set[Handler]()

  def allHandlers = _handlers.toSet

  def addHandler(handlers: Handler*) = handlers.foreach(_handlers.add)

  def removeHandler(handlers: Handler*) = handlers.foreach(_handlers.remove)

  def registerControllers = {
    import org.apache.spark.IdesConf.IDES_CONTROLLER_PACKAGES
    val option = PlatformManager.getConf.get(IDES_CONTROLLER_PACKAGES)

    val controllerDefaultPackages = Array("tech.ides.rest")

    val userControllersPackages = if (option.isDefined) {
      option.get.split(",").filter(_.nonEmpty).map(_.trim)
    } else {Array[String]()}

    val scanPackages = controllerDefaultPackages ++ userControllersPackages

    logInfo("look for the rest controllers from packages: " + scanPackages.mkString(", "))
    val allControllers = Reflection.allSubtypeClasses(classOf[RestController], scanPackages:_*)

    val controllers = allControllers.map {
      controllerClass =>
        Reflection(ClassPath.from(controllerClass)).instance[RestController]
    }

    addHandler(controllers.toSeq:_*)

    logInfo(s"""A total of ${controllers.size} rest controller scanned: [${controllers.map(_.getClass.getName).mkString(", ")}].""")
  }
}