package tech.ides.runtime

import java.util
import java.util.{Map => JMap}
import java.util.concurrent.atomic.AtomicReference
import org.apache.spark.{IdesConf, SparkConf}
import org.apache.spark.IdesConf._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.internal.StaticSQLConf.CATALOG_IMPLEMENTATION
import tech.ides.constants.ScriptConstants
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.utils.ConfigUtils

/**
  *
  * Created by songgr on 2020/07/10.
  */
class SparkRuntime(conf: IdesConf, _params:JMap[Any,Any]= new util.HashMap[Any,Any]()) extends SQLRuntime with Logging {
  val _conf = conf.getAll()

  _conf.map(kv => _params.put(kv._1.asInstanceOf[Any], kv._2.asInstanceOf[Any]))

  private[this] val session = new AtomicReference[SparkSession]()

  def sparkSession = session.get()

  override def awaitTermination: Unit = {
    if (conf.get(IDES_SPARK_SERVICE) && !conf.get(IDES_SHELL_MODE)){
      Thread.currentThread().join()
    }
  }

  override private[runtime] def createRuntime: SQLRuntime = {
    session.set(createSession)
    postInit()
    this
  }

  private def createSession = {
    logInfo("create session ......")
    val sparkConf = new SparkConf()
    _conf.filter(_._1.startsWith("spark.")).foreach { f =>
      sparkConf.set(f._1, f._2)
    }

    val sparkSession = SparkSession.builder().config(sparkConf)

    if (conf.get(IDES_ENABLE_HIVE_SUPPORT)) {
      sparkSession.enableHiveSupport()
      logInfo("Created Spark session with Hive support")
    } else {
      sparkSession.config(CATALOG_IMPLEMENTATION.key, "in-memory")
    }

    val session = sparkSession.getOrCreate()

    if (_conf.nonEmpty) ConfigUtils.showConf(_conf)

    session
  }

  private def postInit() = {
    params.put(ScriptConstants.__SESSION__, sparkSession)
    createCommandTable
  }

  private def createCommandTable = sparkSession.sql("select 1").createOrReplaceTempView("command")

  override def params: JMap[Any, Any] = _params

  SparkRuntime.setLastInstantiatedContext(createRuntime.asInstanceOf[SparkRuntime])
}

object SparkRuntime {

  private val INSTANTIATION_LOCK = new Object()

  /**
    * Reference to the last created SparkRuntime.
    */
  @transient private val lastInstantiatedContext = new AtomicReference[SparkRuntime]()

  def getOrCreate(conf:IdesConf): SparkRuntime = {
    INSTANTIATION_LOCK.synchronized {
      if (lastInstantiatedContext.get() == null) {
        new SparkRuntime(conf)
      }
    }
    lastInstantiatedContext.get()
  }

  private def clearLastInstantiatedContext(): Unit = {
    INSTANTIATION_LOCK.synchronized {
      lastInstantiatedContext.set(null)
    }
  }

  private def setLastInstantiatedContext(sparkRuntime: SparkRuntime): Unit = {
    INSTANTIATION_LOCK.synchronized {
      lastInstantiatedContext.set(sparkRuntime)
    }
  }

}


