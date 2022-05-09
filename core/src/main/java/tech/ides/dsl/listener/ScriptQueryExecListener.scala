package tech.ides.dsl.listener

import java.util.concurrent.atomic.AtomicReference

import ides.dsl.parser.{IdesParser, IdesParserBaseListener}
import org.apache.commons.lang3.StringUtils
import org.apache.spark.sql.SparkSession
import tech.ides.core.ScriptStage
import tech.ides.dsl.adaptor._
import tech.ides.constants.ScriptConstants.PATH_SEPARATOR
import tech.ides.dsl.utils.DslUtil
import tech.sqlclub.common.log.Logging

import scala.collection.mutable

/**
  * 脚本执行监听器类
  * Created by songgr on 2020/10/28.
  */
class ScriptQueryExecListener(val sparkSession: SparkSession, val defaultPathPrefix:String, val owner:String) extends IdesParserBaseListener with Logging {

  logInfo(s"create ScriptQueryExecListener for $owner.")

  // 整个Script的env变量
  private val _env = new mutable.HashMap[String, Any]()
  // Script stage
  private var _stage: Option[ScriptStage.stage] = None
  // last table name
  private val lastTableName = new AtomicReference[String](null)

  def addEnv(key:String, value:Any) = {
    _env(key) = value
    this
  }

  def env = this._env.toMap

  def env(key: String) = this._env.get(key)

  def setStage(stage: ScriptStage.stage) = {
    this._stage = Option(stage)
  }

  def getStage = this._stage

  def setLastTableName(tableName:String) = lastTableName.set(tableName)

  def getLastTableName = if (null == lastTableName.get()) None else Some(lastTableName.get)


  def ownerPath(owner: Option[String]): String = {
    if (defaultPathPrefix != null && defaultPathPrefix.nonEmpty && owner.isDefined) {
      if (defaultPathPrefix.endsWith(PATH_SEPARATOR)) {
        StringUtils.join(defaultPathPrefix, owner.get, PATH_SEPARATOR)
      } else {
        StringUtils.join(defaultPathPrefix, PATH_SEPARATOR, owner.get, PATH_SEPARATOR)
      }
    } else if (defaultPathPrefix != null && defaultPathPrefix.nonEmpty) {
      if (defaultPathPrefix.endsWith(PATH_SEPARATOR)) {
        defaultPathPrefix
      } else {
        defaultPathPrefix + PATH_SEPARATOR
      }
    } else {
      ""
    }
  }


  /**
    * 整个脚本的context
    */
  override def exitStatement(ctx: IdesParser.StatementContext): Unit = {}


  /**
   * 执行scala 代码的context
   * example:
   * %scala
   * val a = 1+2;
   * val strLen = (s: String) => if (s == null) 0 else s.length();
   * %
   */
  override def exitScala(ctx: IdesParser.ScalaContext): Unit = {
    val context = ctx.scalaCode()
    val s = DslUtil.currentText(context)
    println("scala: \n" + s)
  }

  /**
    * 执行python 代码的context
    *
    * example:
    * %python
    * # use table
    * a=1
    * print(a)
    * % > output
    */
  override def exitPy(ctx: IdesParser.PyContext): Unit = {
    // todo 执行python代码
    val pyMode = ctx.getStart.getText
    val bracket_l = pyMode.indexOf('(')
    val bracket_r = pyMode.indexOf(')')

    val table = if ( bracket_l > 0 &&  bracket_r > bracket_l + 1) {
      Some( pyMode.substring(bracket_l + 1, bracket_r) )
    } else None

    // todo table需要format
    if (table.isDefined)
      println("input table: " + table.get)

    val context = ctx.pythonCode()
    val pys = context.pyStatement()
    println("total line: " + pys.size())
//    val s = context.getText
    val s = DslUtil.currentText(context)
    println("py: \n" + s)

    // todo table需要format
    if (ctx.outTable() != null) {
      val tb = ctx.outTable().assetName()
      println("py output: \n" + tb.getText)
    }

  }

  /**
    * 执行sql脚本（jdbc语句）的context
    * example:
    * %sql
    * # use table
    * select 1 from test;
    * % > output
    */
  override def exitSql(ctx: IdesParser.SqlContext): Unit = {
    // todo 执行sql代码
    val sqlMode = ctx.getStart.getText
    val bracket_l = sqlMode.indexOf('(')
    val bracket_r = sqlMode.indexOf(')')

    val connect = if ( bracket_l > 0 &&  bracket_r > bracket_l + 1) {
      Some( sqlMode.substring(bracket_l + 1, bracket_r) )
    } else None

    // todo connect需要format
    if (connect.isDefined)
      println("sql connect: " + connect.get)

    val context = ctx.sqlCode()
    val sqls = context.sqlStatement()
    println("total line: " + sqls.size())
    val s = context.getText
    println("sql: \n" + s)

    // todo table需要format
    if (ctx.outTable() != null) {
      val tb = ctx.outTable().assetName()
      println("sql output: \n" + tb.getText)
    }
  }


  /**
    * 执行shell脚本的context
    * example:
    * %sh
    * # test
    * ls -las /;
    * % > output
    */
  override def exitSh(ctx: IdesParser.ShContext): Unit = {
    val context = ctx.shellCode()
    val shs = context.shellStatement()
    println("total line: " + shs.size())
    val s = context.getText
    println("shell: \n" + s)

    // todo table需要format
    if (ctx.outTable() != null) {
      val tb = ctx.outTable().assetName()
      println("shell output: \n" + tb.getText)
    }
  }

  /**
    * 执行load语句的context
    */
  override def exitLoad(ctx: IdesParser.LoadContext): Unit = {
    LoadAdaptor(this).execute(ctx)
  }

  /**
    * 执行select语句的context
    */
  override def exitSelect(ctx: IdesParser.SelectContext): Unit = {
    SelectAdaptor(this).execute(ctx)
  }

  /**
    * 执行save语句的context
    */
  override def exitSave(ctx: IdesParser.SaveContext): Unit = {
    SaveAdaptor(this).execute(ctx)
  }

  /**
    * 执行connect语句的context
    */
  override def exitConnect(ctx: IdesParser.ConnectContext): Unit = {
    ConnectAdaptor(this).execute(ctx)
  }

  /**
    * 执行drop语句的context
    */
  override def exitDrop(ctx: IdesParser.DropContext): Unit = {
    DropAdaptor(this).execute(ctx)
  }

  /**
   * 执行run语句的context
   */
  override def exitRun(ctx: IdesParser.RunContext): Unit = {
    RunAdaptor(this).execute(ctx)
  }

  /**
   * 执行command语句的context
   */
  override def exitCommand(ctx: IdesParser.CommandContext): Unit = {
    CommandAdaptor(this).execute(ctx)
  }
}
