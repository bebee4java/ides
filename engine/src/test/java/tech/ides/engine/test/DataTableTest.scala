package tech.ides.engine.test

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.scalatest.FunSuite
import tech.ides.datasource.{AnyJavaBeanDataTable, AnyProductDataTable}
import tech.ides.strategy.PlatformFrameEnum.SPARK

/**
 * DataTable 测试
 * Created by songgr on 2022/05/30.
 */
class DataTableTest extends FunSuite {

  implicit val spark = SparkSession.builder()
    .master("local[*]")
    .appName("test")
    .getOrCreate()


  test("spark") {
    spark.createDataFrame(Seq(A("1"))).show()

    spark.createDataFrame(Seq((1,2,3))).toDF().show()

    spark.createDataFrame(Seq((1,2,3))).toDF().show()
  }


  test("AnyProductDataTable") {
    val anyDataTable = AnyProductDataTable(Seq(A("test any data table")), SPARK)

    anyDataTable.table[DataFrame].get.show()


    AnyProductDataTable(Seq((1,2,3)), SPARK).table[DataFrame].get.show()

  }

  test("AnyJavaBeanDataTable") {
    val list = Seq(new Person("a", 1), new Person("b", 2), new Person("c", 3))
    AnyJavaBeanDataTable(list, SPARK).createOrReplaceTempView("aa")
    spark.sql("select name, count(1) from aa group by name").show()
  }

  test("AnyJavaBeanDataTable + schema") {
    val list = Seq(new Person("a", 1), new Person("b", 2), new Person("c", 3))
    val schema = StructType(Seq(
      StructField("name111", StringType, nullable = false),
      StructField("age111", IntegerType, nullable = false))
    )

    AnyJavaBeanDataTable(list, SPARK, schema).table[DataFrame].get.show()

  }

  case class A(a:String)
}