package tech.ides.rest

import org.json4s.JsonAST.{JField, JInt, JObject, JString}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.scalate.ScalateSupport
import org.scalatra.swagger._

/**
  *
  * Created by songgr on 2020/06/16.
  */
abstract class RestController extends ScalatraServlet with ScalateSupport with JacksonJsonSupport with SwaggerSupport {

  /**
    * 渲染响应结果，然后直接结束请求（通过throw空异常）
    * @param code 状态码
    * @param content 响应内容
    * @return Nothing
    */
  def render(code:Int, content:String) = {
    val response = JObject(JField("code",JInt(code)), JField("content", JString(content)))
    val out = super.render(response)
    super.renderResponse(out)
    throw new RuntimeException()
  }

  def param(key: String) = super.params(key)

  def param(key: String, defaultValue:String): String = {
    val p = super.params.get(key)
    if (p.isDefined) p.get else defaultValue
  }

  def paramAsInt(key:String, defaultValue:Int):Int = {
    val p = super.params.get(key)
    if (p.isDefined) p.get.toInt else defaultValue
  }

  def paramAsLong(key:String, defaultValue:Long):Long = {
    val p = super.params.get(key)
    if (p.isDefined) p.get.toLong else defaultValue
  }

  def paramAsBoolean(key:String, defaultValue:Boolean):Boolean = {
    val p = super.params.get(key)
    if (p.isDefined) p.get.toBoolean else defaultValue
  }

  override protected implicit def jsonFormats: Formats = DefaultFormats

  override protected implicit def swagger: SwaggerEngine[_] = SwaggerInfo.swagger

  override protected def applicationDescription: String = "The IDES REST API"
}
