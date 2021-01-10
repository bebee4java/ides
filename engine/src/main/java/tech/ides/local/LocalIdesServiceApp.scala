package tech.ides.local

import tech.ides.core.IdesApp


/**
  *
  * Created by songgr on 2020/07/14.
  */
object LocalIdesServiceApp {

  def main(args: Array[String]): Unit = {

    IdesApp.main(Array(
      "-spark.app.name", "ides",
      "-spark.master", "local[*]",
      "-spark.driver.memory", "512m",
      "-ides.spark.service", "true",
      "-ides.server.port", "9009",
      "-ides.server.request-log.enable", "true",
      "-ides.enableHiveSupport", "true"
    ))
  }

}
