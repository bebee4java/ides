package tech.ides.rest

import org.apache.spark.IdesConf

/**
  *
  * Created by songgr on 2021/03/11.
  */
trait RestServer {

  def start(conf: IdesConf):Unit

  def stop

}
