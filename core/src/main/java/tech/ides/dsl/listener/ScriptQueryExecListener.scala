package tech.ides.dsl.listener

import java.util.concurrent.atomic.AtomicReference

import ides.dsl.parser.{IdesDslBaseListener, IdesDslParser}
import org.apache.commons.lang3.StringUtils
import org.apache.spark.sql.SparkSession
import tech.ides.core.ScriptStage
import tech.ides.dsl.adaptor.{LoadAdaptor, SelectAdaptor}
import tech.ides.constants.ScriptConstants.PATH_SEPARATOR
import tech.sqlclub.common.log.Logging

import scala.collection.mutable

/**
  * 脚本执行监听器类
  * Created by songgr on 2020/10/28.
  */
class ScriptQueryExecListener(val sparkSession: SparkSession, val defaultPathPrefix:String, val owner:String) extends IdesDslBaseListener with Logging {

  logInfo(s"create ScriptQueryExecListener for $owner.")

  // 整个Script的env变量
  private val _env = new mutable.HashMap[String, String]()
  // Script stage
  private var _stage: Option[ScriptStage.stage] = None
  // last table name
  private val lastTableName = new AtomicReference[String](null)

  def exportEnv(key:String, value:String) = {
    _env(key) = value
    this
  }

  def env = this._env

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
  override def exitStatement(ctx: IdesDslParser.StatementContext): Unit = {}

  /**
    * 单条sql的context
    */
  override def exitSql(ctx: IdesDslParser.SqlContext): Unit = {}

  /**
    * load语句的context
    */
  override def exitLoad(ctx: IdesDslParser.LoadContext): Unit = {
    LoadAdaptor(this).enterContext(ctx)
  }

  /**
    * select语句的context
    */
  override def exitSelect(ctx: IdesDslParser.SelectContext): Unit = {
    SelectAdaptor(this).enterContext(ctx)
  }

  /**
    * save语句的context
    */
  override def exitSave(ctx: IdesDslParser.SaveContext): Unit = {}
}
