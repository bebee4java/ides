package tech.ides.rest

import org.apache.spark.IdesConf
import org.scalatest.FunSuite

/**
  *
  * Created by songgr on 2020/06/16.
  */
class IdesServerSuite extends FunSuite {

  test("ides server test") {

    IdesServer.start(new IdesConf)
    println(IdesServer.serverUrl())
    Thread.currentThread().join()

  }

}
