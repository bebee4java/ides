package tech.ides.core.platform

import tech.ides.conf.IdesConf._
import tech.ides.conf.IdesConf
import tech.ides.core.ApplicationSetting
import tech.ides.exception.IdesException
import tech.ides.rest.RestServer
import tech.ides.runtime.SQLRuntime
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.sqlclub.common.log.Logging
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import java.util.concurrent.atomic.{AtomicBoolean, AtomicReference}
import scala.collection.mutable.ArrayBuffer

/**
  *
  * Created by songgr on 2020/07/14.
  */
class PlatformManager extends Logging {

  val config = new AtomicReference[IdesConf]()

  def startRestServer = {
    val serviceImpl = ApplicationSetting.SERVICE_IMPL
    if (serviceImpl.isEmpty) throw new IdesException("not found service impl class. Please set in application.yml !")
    Reflection(ClassPath.from(serviceImpl.get)).instance[RestServer].start(config.get())
  }


  def run(conf:IdesConf, reRun:Boolean = false) = {
    if (!reRun) {
      config.set(conf)
    }

    PlatformManager.lifeCycles.filter(_.isInstanceOf[PlatformLifecycle])
      .foreach( _.asInstanceOf[PlatformLifecycle].beforeSQLRuntime(config.get()))
    // 创建SQLRuntime
    val runtime = PlatformManager.getRuntime

    if (conf.get(IDES_SPARK_SERVICE) && !reRun && !conf.get(IDES_SHELL_MODE)) {
      PlatformManager.lifeCycles.filter(_.isInstanceOf[ServiceLifecycle])
        .foreach(_.asInstanceOf[ServiceLifecycle].beforeService(config.get()))
      // 启动rest server
      startRestServer
      PlatformManager.lifeCycles.filter(_.isInstanceOf[ServiceLifecycle])
        .foreach(_.asInstanceOf[ServiceLifecycle].afterService(config.get()))
    }

    PlatformManager.lifeCycles.filter(_.isInstanceOf[PlatformLifecycle])
      .foreach( _.asInstanceOf[PlatformLifecycle].afterSQLRuntime(config.get()))

    PlatformManager.RUNTIME_IS_READY.compareAndSet(false, true)
    if (conf.get(IDES_SERVICE_RUNTIME_AWAITTERMINATION)) {
      runtime.awaitTermination
    }
  }

  PlatformManager.setLastInstantiatedContext(this)
}

object PlatformManager {

  private val INSTANTIATION_LOCK = new Object()

  val RUNTIME_IS_READY = new AtomicBoolean(false)

  private val lifeCycles = ArrayBuffer[Lifecycle]()

  def registerLifecycle(lifecycle: Lifecycle) = lifeCycles += lifecycle

  def removeLifecycle(lifecycle: Lifecycle) = lifeCycles -= lifecycle

  /**
    * Reference to the last created PlatformManager.
    */
  @transient private val lastInstantiatedContext = new AtomicReference[PlatformManager]()

  /**
    * Get the singleton PlatformManager if it exists or create a new one.
    * This function can be used to create a singleton PlatformManager object that can be shared across
    * the JVM.
    */
  def getOrCreate: PlatformManager = {
    INSTANTIATION_LOCK.synchronized {
      if (lastInstantiatedContext.get() == null) {
        new PlatformManager()
      }
    }
    lastInstantiatedContext.get()
  }

  private def setLastInstantiatedContext(platformManager: PlatformManager): Unit = {
    INSTANTIATION_LOCK.synchronized {
      lastInstantiatedContext.set(platformManager)
    }
  }

  def clear = lastInstantiatedContext.set(null)

  def getRuntime:SQLRuntime = {
    val conf = getOrCreate.config.get()
    val platform = conf.get(IDES_RUN_PLATFORM_FRAME)

    Class.forName(platformNameMapping(platform)).
      getMethod("getOrCreate", classOf[IdesConf]).
      invoke(null, conf).asInstanceOf[SQLRuntime]
  }

  def platformNameMapping = Map[String, String](
    SPARK.frame -> "tech.ides.runtime.SparkRuntime"
  )
}
