package tech.ides.rest

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.swagger.{Parameter, _}

/**
  *
  * Created by songgr on 2020/06/16.
  */
class RestController(implicit val swagger: Swagger) extends ScalatraServlet with JacksonJsonSupport with SwaggerSupport {

  get("/", operation(apiOperation[String]("/")
    summary "/"
    description "welcome page"
  )) {
    contentType="text/html"
    import tech.ides.BANNER
    <html>
      <head><title>IDES</title></head>
      <body><pre>{BANNER}</pre></body>
    </html>

  }

  post("/run/script", operation(apiOperation[String]("runScript")
    summary "used to execute ides script"
    description ""
    parameters(
       Parameter("sql", DataType.String, description=Option("ides script content"), required = true)
      ,Parameter("owner", DataType.String, description=Option("the user who execute this script, default: admin."), required = true, defaultValue = Option("admin"))
    )
    schemes "{}"
  )) {
    contentType="application/json"
    val sql = params("sql")

    s"""
       |"sql" : $sql
    """.stripMargin

  }


  override protected def applicationDescription: String = "The IDES REST API"

  override protected implicit def jsonFormats: Formats = DefaultFormats
}

