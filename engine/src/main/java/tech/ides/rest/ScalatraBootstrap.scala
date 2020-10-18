package tech.ides.rest

import javax.servlet.ServletContext
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.{LifeCycle, ScalatraServlet}
import org.scalatra.swagger.{ApiInfo, JacksonSwaggerBase, Swagger}

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

class SwaggerController extends Swagger(Swagger.SpecVersion, "1.0.0", SwaggerApiInfo)


class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new SwaggerController

  override def init(context: ServletContext) {
    context.mount (new ResourcesApp, "/rest/v1/api-docs")
    context.mount(new RestController, "/*")
  }
}
