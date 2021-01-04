package tech.ides.rest

import org.json4s.JsonAST._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra
import org.scalatra.{Route, ScalatraServlet}
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.scalate.ScalateSupport
import org.scalatra.swagger._
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.net.NetUtils
import tech.sqlclub.common.utils.CaseClassUtil.{JString => CJString , caseClassFields, SInt, SLong}

/**
  *
  * Created by songgr on 2020/06/16.
  */
abstract class RestController extends ScalatraServlet with ScalateSupport with JacksonJsonSupport with SwaggerSupport with Logging {
  // 请求开始时间
  private final val requestStartTime: ThreadLocal[Long] = new ThreadLocal[Long]
  // 请求结束时间
  private final val requestEndTime: ThreadLocal[Long] = new ThreadLocal[Long]

  def actionWithTimeTrack(action: => Any):Any = {
    val now = System.currentTimeMillis()
    requestStartTime.set(now)
    // 执行post body 方法
    val result = action
    // 移除线程记录的时间
    requestStartTime.remove()
    requestEndTime.remove()
    result
  }

  override def post(transformers: scalatra.RouteTransformer*)(action: => Any): Route = {
    super.post(transformers:_*)(actionWithTimeTrack(action))
  }



  /**
    * 渲染响应结果，然后直接结束请求（通过throw空异常）
    * @param code 状态码
    * @param content 响应内容
    * @return Nothing
    */
  def render(code:Int, content:String) = {
    val method = request.getMethod
    val uri = request.getRequestURI
    val now = System.currentTimeMillis()
    requestEndTime.set(now)
    val durationBackend = requestEndTime.get() - requestStartTime.get()
    val response = Response(code, content, durationBackend)
    val result = caseClassFields(response).map {
      it =>
        it.fieldType match {
          case SInt => JField(it.fieldName, JInt(it.fieldValue.asInstanceOf[Int]))
          case CJString => JField(it.fieldName, JString(it.fieldValue.asInstanceOf[String]))
          case SLong => JField(it.fieldName, JLong(it.fieldValue.asInstanceOf[Long]))
          case _ => throw new RuntimeException(s"Unsupported dataType: ${it.fieldType.getName}")
        }
    }
    val obj = JObject(result:_*)
    val out = super.render(obj)
    super.renderResponse(out)
    logInfo(s"Request completed!\t${Array(method, uri, code, NetUtils.getLocalServerIp, durationBackend+"ms").mkString("\t")}")
    throw new RuntimeException()
  }

  def requestParam = super.params.toMap[String,String]

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

case class Response(code:Int, content:String, durationBackend:Long)
