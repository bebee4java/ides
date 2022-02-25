package tech.ides.dsl.statement

import tech.ides.datasource.writer.SaveMode

/**
  *
  * Created by songgr on 2020/11/05.
  */

sealed trait SqlStatement {
  def sql:String
}

// LOAD format DOT path whereExpressions? asAsset
case class LoadSqlStatement(sql: String, format: String, path: String, options: Map[String, String], tableName: String) extends SqlStatement

// SAVE assetName saveMode? INTO format DOT path whereExpressions? partitionbyExpression?
case class SaveSqlStatement(sql: String, inputTableName: String, saveMode: SaveMode, format: String, path: String, options: Map[String, String], partitionByCol: List[String]) extends SqlStatement

// SELECT ~(EOQ)+ asAsset
case class SelectSqlStatement(sql:String, tableName:String) extends SqlStatement

// CONNECT format whereExpressions asAsset
case class ConnectSqlStatement(sql:String, format: String, options: Map[String, String], connectionName:String) extends SqlStatement

// DROP resource=(CONNECTION|FUNCTION) format DOT assetName
case class DropSqlStatement(sql:String, resource:Int, format:String, assetName:String) extends SqlStatement

// RUN module DOT path whereExpressions? asAsset? # Run
case class RunSqlStatement(sql: String, module: String, path: String, options: Map[String, String], tableName: String) extends SqlStatement