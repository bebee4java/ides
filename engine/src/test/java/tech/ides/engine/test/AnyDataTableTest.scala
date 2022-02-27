package tech.ides.engine.test

import tech.ides.datasource.AnyDataTable
import tech.ides.strategy.PlatformFrameEnum.SPARK

/**
 * test
 * Created by songgr on 2022/02/27.
 */
object AnyDataTableTest {

  def main(args: Array[String]): Unit = {

    val anyDataTable = AnyDataTable("test any data table", SPARK)

    val frame = anyDataTable.frame.frame
    val table = anyDataTable.table[String]

    println(frame)
    println(table)

  }

}
