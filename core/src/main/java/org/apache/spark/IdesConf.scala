package org.apache.spark

import org.apache.spark.internal.config._
import org.apache.spark.SparkConf.getDeprecatedConfig

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
  private[this] val entrys = new java.util.HashMap[String, ConfigEntry[_]]()

  private[this] def register(entry: ConfigEntry[_]): Unit = {
    require(!entrys.containsKey(entry.key),
      s"Duplicate ConfigEntry. ${entry.key} has been registered")
    entrys.put(entry.key, entry)
  }

  private[this] object IdesConfigBuilder {
    def apply(key: String): ConfigBuilder = ConfigBuilder(key).onCreate(register)
  }

  val IDES_SPARK_SERVICE = IdesConfigBuilder("ides.spark.service").doc(
    """
      |Run IDES as service and without quit.
    """.stripMargin).booleanConf.createWithDefault(false)

  val IDES_DRIVER_PORT = IdesConfigBuilder("ides.driver.port").doc("The port of rest api").intConf.createWithDefault(9003)

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