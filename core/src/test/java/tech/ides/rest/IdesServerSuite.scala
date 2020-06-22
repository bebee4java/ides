package tech.ides.rest

import org.scalatest.FunSuite

/**
  *
  * Created by songgr on 2020/06/16.
  */
class IdesServerSuite extends FunSuite {

  test("ides server test") {

    IdesServer.start()
    println(IdesServer.serverUrl())
    Thread.currentThread().join()

  }

}
