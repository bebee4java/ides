package org.apache.spark

import org.scalatest.FunSuite
import org.apache.spark.IdesConf._

/**
  *
  * Created by songgr on 2020/06/09.
  */
class IdesConfSuite extends FunSuite {
  test("test default conf value") {
    val conf = new IdesConf()
    val value = conf.get(IDES_DRIVER_PORT)

    assert(IDES_DRIVER_PORT.defaultValue.get == value)

  }

  test("test set conf value") {
    val conf = new IdesConf()
    conf.set(IDES_DRIVER_PORT.key, "9009")
    val value = conf.get(IDES_DRIVER_PORT)

    assert(9009 == value)

  }

}
