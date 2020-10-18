package tech.ides.platform

import org.apache.spark.IdesConf
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


    PlatformManager.getOrCreate.run(idesConf)



  }

}
