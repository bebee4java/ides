package tech.ides.conf

import scala.collection.JavaConverters._

/**
  * IDES 配置类(参考SparkConf)
  * Created by songgr on 2020/06/09.
  */
class IdesConf {

  private[this] val settings = new java.util.concurrent.ConcurrentHashMap[String, String]()

  @transient private lazy val reader: ConfigReader = {
    val _reader = new ConfigReader(new IdesConfigProvider(settings))
    _reader.bindEnv(new EnvProvider())
    _reader
  }

  private[conf] def getenv(name: String): String = System.getenv(name)

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
    Option(settings.get(key))
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

  import tech.ides.strategy.PlatformFrameEnum.SPARK
  val IDES_RUN_PLATFORM_FRAME = IdesConfigBuilder("ides.run.platform.frame").doc(
    "ides running platform"
  ).stringConf.createWithDefault(SPARK.frame)

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
  ).booleanConf.createWithDefault(false)
  val REQUEST_LOG_RETAIN_DAYS = IdesConfigBuilder("ides.server.request-log-retain.days").doc(
    "Days to keep ides server request logs.").intConf.createWithDefault(5)

  val IDES_PLUGIN_PACKAGES = IdesConfigBuilder("ides.plugin.scan.package.paths").doc(
    "ides plugin scan package paths, multiple values separated by ','."
  ).stringConf.createOptional

  val IDES_DATASOURCE_PACKAGES = IdesConfigBuilder("ides.datasource.scan.package.paths").doc(
    "ides datasource scan package paths, multiple values separated by ','."
  ).stringConf.createOptional

  val IDES_CONTROLLER_PACKAGES = IdesConfigBuilder("ides.rest.controller.scan.package.paths").doc(
    "ides rest controller scan package paths, multiple values separated by ','."
  ).stringConf.createOptional

  val IDES_JOB_RUN_TIMEOUT = IdesConfigBuilder("ides.job.run.timeout").doc(
    "ides job run timeout(ms). Default is -1, means never timeout."
  ).longConf.createWithDefault(-1L)

  val IDES_SHELL_REPL_CODE_MULTI_LINE = IdesConfigBuilder("ides.shell.repl.code.multi-line").doc(
    "ides shell repl code support multi-line input"
  ).booleanConf.createWithDefault(true)

  val ENABLE_MAX_RESULT_SIZE =
    IdesConfigBuilder("spark.ides.api.enable.max.result.limit")
      .doc("enable restful max result size limitation. when you enable this configuration. you should pass `outputSize` for your rest request. if not, you take only max 1000 record.")
      .booleanConf
      .createWithDefault(false)

  val RESTFUL_API_MAX_RESULT_SIZE =
    IdesConfigBuilder("spark.ides.restful.api.max.result.size")
      .doc("the max size of restful api result.").intConf.createWithDefault(1000)

  val EXTERNAL_STORAGE_IMPL_CLASS_NAME = IdesConfigBuilder("ides.external.storage.impl.class.name")
    .doc("ides external storage implementation class name")
    .stringConf
    .createWithDefault("tech.ides.storage.impl.ParquetExternalStorage")

}

private[conf] class IdesConfigProvider(conf: java.util.Map[String, String]) extends ConfigProvider {
  override def get(key: String): Option[String] = {
    if (key.startsWith("ides.")) {
      Option(conf.get(key))
    } else {
      None
    }
  }
}