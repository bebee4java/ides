package org.apache.spark

import tech.ides.utils.ScriptUtils.readLines

/**
  *
  * Created by songgr on 2020/11/10.
  */
object ScriptUtilTest {

  def main(args: Array[String]): Unit = {
    val script =
      """
        |val a = ''' ""s; ''';
        |
        |val a = "sddede;;;;dede;;;dede"; val aa='''sds''';select `sddse;dede`;
        |
        |/*
        |ddede
        |；；；
        |dede
        |;;;
        |*/
        |
        |val a=`a`; val b='s'; val c="s";
        |
        |--- select * from as t; val a=1;
        |
        |select "sdsd;" from tt;
      """.stripMargin

    val strings = readLines(script)

    println(strings.mkString("\n"))

    println(readLines("val a=1;/*;;;*/ val a=3;").mkString("\n"))

    println(readLines("--val a=1;/*;;;*/ val a=3;").mkString("\n"))

    println(readLines("select \\s \"\"\"llllkkkkk;;;\"\"\" as tl as tl;").mkString("\n"))
  }

}
