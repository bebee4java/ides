package tech.ides.runtime

import java.util.concurrent.atomic.AtomicReference

import org.apache.spark.{IdesConf, SparkConf}
import org.apache.spark.IdesConf._
import org.apache.spark.sql.SparkSession
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.utils.ConfigUtils

/**
  *
  * Created by songgr on 2020/07/10.
  */
class SparkRuntime(val conf: IdesConf) extends SQLRuntime with Logging {
  lazy val _conf = conf.getAll()

  val sparkSession = createSession

  override def awaitTermination: Unit = {
    if (conf.get(IDES_SPARK_SERVICE) && !conf.get(IDES_SHELL_MODE)){
      Thread.currentThread().join()
    }
  }

  override def createRuntime: Unit = {

  }

  def createSession = {
    logInfo("create session ......")
    val sparkConf = new SparkConf()
    params.filter(_._1.startsWith("spark.")).foreach { f =>
      sparkConf.set(f._1, f._2)
    }

    val sparkSession = SparkSession.builder().config(sparkConf)

    if (conf.get(IDES_ENABLE_HIVE_SUPPORT)) {
      sparkSession.enableHiveSupport()
    }

    val session = sparkSession.getOrCreate()

    if (params.nonEmpty) ConfigUtils.showConf(params)

    session
  }

  override def params: Map[String, String] = _conf

  SparkRuntime.setLastInstantiatedContext(this)
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


