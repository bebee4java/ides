package tech.ides.rest

import java.net.InetAddress

import org.apache.spark.IdesConf
import org.apache.spark.IdesConf._
import org.eclipse.jetty.server.{Handler, _}
import org.eclipse.jetty.util.ssl.SslContextFactory
import org.eclipse.jetty.util.thread.QueuedThreadPool
import tech.sqlclub.common.log.Logging

/**
  *
  * Created by songgr on 2020/06/16.
  */
class WebServer(val idesConf: IdesConf, var host: String, var port: Int) extends Logging {

  val threadPool = new QueuedThreadPool
  threadPool.setName("jetty-server-threadPool")
  threadPool.setIdleTimeout(idesConf.get(IDES_HTTP_THREAD_IDLETIMEOUT))
  threadPool.setMinThreads(idesConf.get(IDES_HTTP_MIN_THREADS))
  threadPool.setMaxThreads(idesConf.get(IDES_HTTP_MAX_THREADS))
  threadPool.setDaemon(true)
  val server = new Server(threadPool)

  def jettyServer = server

  server.setStopTimeout(1000)
  server.setStopAtShutdown(true)

  val (connector, protocol) = idesConf.get(IdesConf.SSL_KEYSTORE) match {
    case None =>
      val http = new HttpConfiguration()
      http.setRequestHeaderSize(idesConf.get(IdesConf.REQUEST_HEADER_SIZE))
      http.setResponseHeaderSize(idesConf.get(IdesConf.RESPONSE_HEADER_SIZE))
      (new ServerConnector(server, new HttpConnectionFactory(http)), "http")

    case Some(keystore) =>
      val https = new HttpConfiguration()
      https.setRequestHeaderSize(idesConf.get(IdesConf.REQUEST_HEADER_SIZE))
      https.setResponseHeaderSize(idesConf.get(IdesConf.RESPONSE_HEADER_SIZE))
      https.addCustomizer(new SecureRequestCustomizer())

      val sslContextFactory = new SslContextFactory()
      sslContextFactory.setKeyStorePath(keystore)
      Option(idesConf.get(IdesConf.SSL_KEYSTORE_PASSWORD).get)
        .foreach(sslContextFactory.setKeyStorePassword)
      Option(idesConf.get(IdesConf.SSL_KEY_PASSWORD).get)
        .foreach(sslContextFactory.setKeyManagerPassword)

      (new ServerConnector(server,
        new SslConnectionFactory(sslContextFactory, "http/1.1"),
        new HttpConnectionFactory(https)), "https")
  }

  connector.setHost(host)
  connector.setPort(port)

  server.setConnectors(Array(connector))

  def setHandler(handler: Handler) = {
    server.setHandler(handler)
  }

  def start(): Unit = {
    server.start()

    val connector = server.getConnectors()(0).asInstanceOf[NetworkConnector]

    if (host == "0.0.0.0") {
      host = InetAddress.getLocalHost.getCanonicalHostName
    }
    port = connector.getLocalPort

    logInfo(s"Starting server on $protocol://$host:$port ,api-docs url on $protocol://$host:$port/api-docs")
  }

  def join(): Unit = {
    server.join()
  }

  def stop(): Unit = {
    if (server != null) {
      server.getHandlers.foreach(_.stop())
      server.stop()
      server.destroy()
    }
  }
}
