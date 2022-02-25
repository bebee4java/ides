package tech.ides.rest

import java.io.File
import org.eclipse.jetty.server.NCSARequestLog
import org.eclipse.jetty.server.handler.{HandlerCollection, RequestLogHandler}
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import tech.ides.conf.IdesConf
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.utils.FileUtils
import tech.ides.constants.IdesEnvConstants._

/**
  * Ides server
  * Created by songgr on 2020/06/16.
  */
object IdesServer extends RestServer with Logging {

  import IdesConf._

  private var server: WebServer = _
  private var _serverUrl: Option[String] = None
  private[rest] var host:String = _
  private[rest] var port:Int = _

  override def start(conf:IdesConf): Unit = {
    host = conf.get(IDES_SERVER_HOST)
    port = conf.get(IDES_SERVER_PORT)
    server = new WebServer(conf, host, port)

    val handlers = new HandlerCollection

    val context = new WebAppContext()
    context.setContextPath("/")
    val resourceUrl = getClass.getClassLoader.getResource("webapp/WEB-INF")
    if (resourceUrl != null) {
      context.setResourceBase(resourceUrl.toExternalForm)
      logInfo("Ides Server set resource base dir: " + resourceUrl.toExternalForm)
    } else {
      context.setResourceBase("")
      logError("We can't find the resource base dir for ides server!")
    }
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[DefaultServlet], "/")
    context.setInitParameter(ScalatraListener.LifeCycleKey, classOf[ScalatraBootstrap].getName)
    handlers.addHandler(context)

    if (conf.get(IDES_REQUEST_LOG)) {
      // Configure the access log
      val requestLogHandler = new RequestLogHandler
      val requestLog = new NCSARequestLog(sys.env.getOrElse(IDES_LOG_DIR,
        sys.env.getOrElse(IDES_HOME, ".") + "/logs") + "/ides_yyyy_mm_dd.request.log")
      requestLog.setAppend(true)
      // 设置时区
      requestLog.setLogTimeZone("GMT+8")
      // 设置日期格式
      requestLog.setLogDateFormat("yyyy-MM-dd hh:mm:ss:SSS")

      requestLog.setExtended(false)
      requestLog.setPreferProxiedForAddress(true)
      // 请求 延迟时间
      requestLog.setLogLatency(true)
      requestLog.setRetainDays(conf.get(IdesConf.REQUEST_LOG_RETAIN_DAYS))
      requestLogHandler.setRequestLog(requestLog)
      val logFile = new File(requestLog.getFilename)
      if (!logFile.getParentFile.exists()) {
        FileUtils.mkdirs(logFile.getParent)
      }
      handlers.addHandler(requestLogHandler)
    }
    server.setHandler(handlers)

    server.start()

    Runtime.getRuntime.addShutdownHook(new Thread("Ides Server Shutdown") {
      override def run(): Unit = {
        logInfo("Shutting down ides server.")
        server.stop()
      }
    })

    _serverUrl = Some(s"${server.protocol}://${server.host}:${server.port}")
    sys.props("ides.server.server-url") = _serverUrl.get
  }

  def awaitStarted() = {
//    server.join()
    new Thread(){
      setDaemon(true)
      override def run(): Unit = server.join()
    }.start()
  }

  override def stop(): Unit = {
    if (server != null) {
      server.stop()
    }
  }

  def serverUrl(): String = {
    _serverUrl.getOrElse(throw new IllegalStateException("Server not yet started."))
  }
}
