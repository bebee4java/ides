package tech.ides.core

import org.apache.spark.IdesConf
import tech.ides.core.platform.{PlatformLifecycle, PlatformManager}
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import tech.sqlclub.common.utils.ParamsUtils

/**
  *
  * Created by songgr on 2020/07/14.
  */
object IdesApp {

  def main(args: Array[String]): Unit = {

    val params = new ParamsUtils(args)
    val idesConf = new IdesConf()
    params.getParamsMap.foreach(kv => idesConf.set(kv._1, kv._2))

    val platformLifecycles = ApplicationSetting.PLATFORM_LIFECYCLES
    if (platformLifecycles.isDefined) {
      platformLifecycles.get.foreach {
        clazz =>
          val lifecycle = Reflection(ClassPath.from(clazz)).instance[PlatformLifecycle]
          PlatformManager.registerPlatformLifecycle(lifecycle)
      }
    }

    PlatformManager.getOrCreate.run(idesConf)



  }

}
