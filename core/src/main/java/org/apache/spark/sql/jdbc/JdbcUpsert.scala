package org.apache.spark.sql.jdbc

import java.sql.Connection
import org.apache.spark.sql.Row
import org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions
import org.apache.spark.sql.types.StructType

/**
  * jdbc upsert 接口定义
  * Created by songgr on 2021/03/04.
  */
trait JdbcUpsert {

  /**
    * 执行upsert
    * @param conn 数据库连接
    * @param upsertReq upsert请求对象
    * @param upsertRow upsert记录行
    * @param iterator 插入数据集
    * @param batchSize 批处理大小
    * @return Boolean
    */
  def execute(conn: Connection, upsertReq: UpsertReq, upsertRow:UpsertRow, iterator: Iterator[Row], batchSize:Int):Boolean

  /**
    * 预备SQL语句行
    * @param upsertReq upsert请求对象
    * @param isCaseSensitive 区分大小写
    * @return UpsertRow
    */
  def preparedStatementSQLRow(upsertReq: UpsertReq, isCaseSensitive: Boolean):UpsertRow

}

/**
  * Upsert 请求对象
  * @param option jdbc连接信息
  * @param schema 表schema结构
  * @param dialect jdbc方言
  * @param jdbcNullType jdbc null类型
  * @param primaryKeys 更新主key，可以由多个字段组成
  */
case class UpsertReq(option: JDBCOptions, schema: StructType, dialect: JdbcDialect, jdbcNullType:Array[Int], primaryKeys: Option[Seq[String]])

/**
  * upsert 行对象
  * @param upsertSQL  upsert语句
  * @param cols       字段名称列表，对应所有的占位符
  */
case class UpsertRow(upsertSQL:String, cols:Seq[String])