package tech.ides.rest

import org.scalatra.swagger.{DataType, Parameter}
import tech.ides.exception.ExceptionUtil
import tech.ides.platform.PlatformManager
import tech.ides.runtime.SparkRuntime

/**
  *
  * Created by songgr on 2020/12/29.
  */
class IdesAppController extends RestController with ControllerUtils {

  get("/", operation(apiOperation[String]("/")
    summary "/"
  )) {
    contentType="text/html"
    import tech.ides.BANNER
    ssp("/index",  "BANNER" -> BANNER)
  }

  post("/run/script", operation(apiOperation[String]("runScript")
    summary "used to execute ides script"
    parameters(
    Parameter("sql", DataType.String, description=Option("ides script content"), required = true)
    ,Parameter("owner", DataType.String, description=Option("the user who execute this script, default: admin."), required = true, defaultValue = Option("admin"))
  )
  )) {
    contentType="application/json"
    var outputResult: String = ""

    try {
      val sql = param("sql")
      val owner = param("owner", "admin")

      val session = getSession

      val jsonTable = session.sql(sql).toJSON

      val result = new StringBuffer()
      result.append("{\"schema\":")
      result.append(jsonTable.schema.json)
      result.append(",\"data\":[")
      result.append(jsonTable.collect().mkString(","))
      result.append("]}")
      outputResult = result.toString
    } catch {
      case e:Throwable =>
        val errorMsg = ExceptionUtil.format_throwable(e)
        outputResult = errorMsg
        render(500, outputResult)
    }
    render(200, outputResult)
  }

}


trait ControllerUtils {

  val runtime = PlatformManager.getRuntime

  def getSession = {
    runtime.asInstanceOf[SparkRuntime].sparkSession
  }

}