package org.apache.spark.sql

import org.apache.spark.sql.types._

/**
  *
  * Created by songgr on 2021/02/15.
  */
object DataFrameUtils {

  /**
    * 指定数据类型展开Row对象
    * @param row row数据
    * @param name 字段名
    * @param dataType 数据类型
    * @return Any
    */
  def unwrapRow(row: Row, name:String, dataType: DataType):Any = {
    val i = row.fieldIndex(name)
    dataType match {
      case IntegerType =>  row.getInt(i)
      case LongType => row.getLong(i)
      case DoubleType => row.getDouble(i)
      case FloatType => row.getFloat(i)
      case ShortType => row.getShort(i)
      case ByteType => row.getByte(i)
      case BooleanType => row.getBoolean(i)
      case StringType => row.getString(i)
      case BinaryType => row.getAs[Array[Byte]](i)
      case TimestampType => row.getAs[java.sql.Timestamp](i)
      case DateType => row.getAs[java.sql.Date](i)
      case t: DecimalType => row.getDecimal(i)
      case ArrayType(dt, _) => row.getSeq[AnyRef](i).toArray
      case _ => throw new IllegalArgumentException(
        s"Can't unwrap non-null value for field $name, $i"
      )
    }
  }

  /**
    * 获取指定列第一行数据
    * @param table 数据表
    * @param name 字段名
    * @return `Option[Any]`
    */
  def getFieldHeadValueByName(table:DataFrame, name:String):Option[Any] = {
    val fieldOption = table.schema.find(f => f.name == name)

    if (fieldOption.isEmpty) return None

    val dataType = fieldOption.get.dataType
    val results = table.select(name).head(1).map(row => unwrapRow(row, name, dataType))
    results.headOption
  }

  /**
    * 根据字段名获取整列数据，数据量大时driver可能会OOM，慎用！
    * @param table 数据表
    * @param name 字段名
    * @return `List[Any]`
    */
  def getFieldValueByName(table:DataFrame, name:String):List[Any] = {
    val fieldOption = table.schema.find(f => f.name == name)

    if (fieldOption.isEmpty) return List()
    val dataType = fieldOption.get.dataType

    table.select(name).collect().map(row => unwrapRow(row, name, dataType)).toList
  }

  /**
    * 获取所有列数据，数据量大时driver可能会OOM，慎用！
    * @param table 数据表
    * @return `List[Seq[Any]]`
    */
  def getAllFieldValue(table:DataFrame):List[Seq[Any]] = {
    val schema = table.schema.map(f => (f.name, f.dataType))
    table.collect().map{
      row =>
        schema.map(it => unwrapRow(row, it._1, it._2))
    }.toList
  }
}
