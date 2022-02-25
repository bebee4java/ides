package tech.ides.rest

import org.scalatest.FunSuite
import tech.ides.conf.IdesConf

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
