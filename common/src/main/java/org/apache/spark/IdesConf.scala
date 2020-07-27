package org.apache.spark

import org.apache.spark.internal.config._
import org.apache.spark.SparkConf.getDeprecatedConfig
import scala.collection.JavaConverters._

/**
  * IDES 配置类(参考SparkConf)
  * Created by songgr on 2020/06/09.
  */
class IdesConf {

  private[this] val settings = new java.util.concurrent.ConcurrentHashMap[String, String]()

  @transient private lazy val reader: ConfigReader = {
    val _reader = new ConfigReader(new IdesConfigProvider(settings))
    _reader.bindEnv(new ConfigProvider {
      override def get(key: String): Option[String] = Option(getenv(key))
    })
    _reader
  }

  private[spark] def getenv(name: String): String = System.getenv(name)

  /** Remove a parameter from the configuration */
  def remove(key: String): IdesConf = {
    settings.remove(key)
    this
  }

  def remove(entry: ConfigEntry[_]): IdesConf = {
    remove(entry.key)
    this
  }

  /** Get a parameter as an Option */
  def getOption(key: String): Option[String] = {
    Option(settings.get(key)).orElse(getDeprecatedConfig(key, settings))
  }

  /** Get a parameter; throws a NoSuchElementException if it's not set */
  def get(key: String): String = {
    getOption(key).getOrElse(throw new NoSuchElementException(key))
  }

  /** Get a parameter, falling back to a default if not set */
  def get(key: String, defaultValue: String): String = {
    getOption(key).getOrElse(defaultValue)
  }

  def get[T](entry: ConfigEntry[T]): T = {
    entry.readFrom(reader)
  }

  def getAll():Map[String,String] = {
    settings.entrySet().asScala.map(e => (e.getKey, e.getValue)).toMap
  }

  def set(key: String, value: String): IdesConf = {
    if (key == null) {
      throw new NullPointerException("null key")
    }
    if (value == null) {
      throw new NullPointerException("null value for " + key)
    }
    settings.put(key, value)
    this
  }

  def set[T](entry: ConfigEntry[T], value: T): IdesConf = {
    set(entry.key, entry.stringConverter(value))
    this
  }

  def set[T](entry: OptionalConfigEntry[T], value: T): IdesConf = {
    set(entry.key, entry.rawStringConverter(value))
    this
  }

}

object IdesConf {
  private[this] val entries = new java.util.HashMap[String, ConfigEntry[_]]()

  private[this] def register(entry: ConfigEntry[_]): Unit = {
    require(!entries.containsKey(entry.key),
      s"Duplicate ConfigEntry. ${entry.key} has been registered")
    entries.put(entry.key, entry)
  }

  private[this] object IdesConfigBuilder {
    def apply(key: String): ConfigBuilder = ConfigBuilder(key).onCreate(register)
  }

  val IDES_RUN_PLATFORM = IdesConfigBuilder("ides.run.platform").doc(
    "ides running platform"
  ).stringConf.createWithDefault("spark")

  val IDES_SPARK_SERVICE = IdesConfigBuilder("ides.spark.service").doc(
    """
      |Run IDES as service and without quit.
    """.stripMargin).booleanConf.createWithDefault(false)

  val IDES_SHELL_MODE = IdesConfigBuilder("ides.shell.mode").doc(
    """
      |Run IDES as shell Repl.
    """.stripMargin).booleanConf.createWithDefault(false)

  val IDES_SERVICE_RUNTIME_AWAITTERMINATION = IdesConfigBuilder("ides.service.runtime.awaitTermination").doc(
    """
      |Run IDES service and await termination.
    """.stripMargin).booleanConf.createWithDefault(true)

  val IDES_ENABLE_HIVE_SUPPORT = IdesConfigBuilder("ides.enableHiveSupport").doc(
    "enable hive support"
  ).booleanConf.createWithDefault(false)

  val IDES_SERVER_HOST = IdesConfigBuilder("ides.server.host").doc("The host of rest api").stringConf.createWithDefault("0.0.0.0")
  val IDES_SERVER_PORT = IdesConfigBuilder("ides.server.port").doc("The port of rest api").intConf.createWithDefault(9003)

  val REQUEST_HEADER_SIZE = IdesConfigBuilder("ides.server.request-header.size").doc("request header Size").intConf.createWithDefault(131072)
  val RESPONSE_HEADER_SIZE = IdesConfigBuilder("ides.server.response-header.size").doc("response header size").intConf.createWithDefault(131072)

  val SSL_KEYSTORE = IdesConfigBuilder("ides.keystore").doc("ides keystore path").stringConf.createOptional
  val SSL_KEYSTORE_PASSWORD = IdesConfigBuilder("ides.keystore.password").doc("ides keystore password").stringConf.createOptional
  val SSL_KEY_PASSWORD = IdesConfigBuilder("ides.key-password").doc("ides key password").stringConf.createOptional

  val IDES_HTTP_MIN_THREADS = IdesConfigBuilder("ides.server.http.threads.min").doc(
    "Set the minimum number of ides server threads"
  ).intConf.createWithDefault(30)
  val IDES_HTTP_MAX_THREADS = IdesConfigBuilder("ides.server.http.threads.max").doc(
    "Set the maximum number of ides server threads"
  ).intConf.createWithDefault(100)
  val IDES_HTTP_THREAD_IDLETIMEOUT = IdesConfigBuilder("ides.server.http.thread.idleTimeout").doc(
    "Set the maximum thread idle time.Threads that are idle for longer than this period may be stopped. Max idle time in ms"
  ).intConf.createWithDefault(10 * 60 * 1000)

  val IDES_REQUEST_LOG = IdesConfigBuilder("ides.server.request-log.enable").doc(
    "Whether to enable ides server request log."
  ).booleanConf.createWithDefaultString("false")
  val REQUEST_LOG_RETAIN_DAYS = IdesConfigBuilder("ides.server.request-log-retain.days").doc(
    "Days to keep ides server request logs.").intConf.createWithDefault(5)

}

private[spark] class IdesConfigProvider(conf: java.util.Map[String, String]) extends ConfigProvider {
  override def get(key: String): Option[String] = {
    if (key.startsWith("ides.")) {
      Option(conf.get(key)).orElse(SparkConf.getDeprecatedConfig(key, conf))
    } else {
      None
    }
  }
}