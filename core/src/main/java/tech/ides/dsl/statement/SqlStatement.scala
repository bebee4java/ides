package tech.ides.dsl.statement

import org.apache.spark.sql.SaveMode

/**
  *
  * Created by songgr on 2020/11/05.
  */

sealed trait SqlStatement {
  def sql:String
}

// LOAD format DOT path whereExpressions? asTableName
case class LoadSqlStatement(sql: String, format: String, path: String, options: Map[String, String], tableName: String) extends SqlStatement

// SAVE tableName saveMode? INTO format DOT path whereExpressions? partitionbyExpression? # Save
case class SaveSqlStatement(sql: String, inputTableName: String, saveMode: SaveMode, format: String, path: String, options: Map[String, String], partitionByCol: List[String]) extends SqlStatement

// SELECT ~(EOQ)+ asTableName
case class SelectSqlStatement(sql:String, tableName:String) extends SqlStatement