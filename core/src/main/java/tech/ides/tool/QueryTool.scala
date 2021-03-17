package tech.ides.tool

import org.apache.spark.IdesConf
import tech.ides.core.{ScriptQueryExecute, ScriptQueryExecuteContext}
import tech.ides.core.platform.PlatformManager
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.job.{ScriptJobManager, ScriptJobType}
import tech.ides.runtime.SparkRuntime
import tech.sqlclub.common.log.Logging

/**
  *
  * Created by songgr on 2021/03/16.
  */
trait QueryTool extends Logging {

  def BATCH_JOB =  ScriptJobType.BATCH.toString
  def STREAM_JOB = ScriptJobType.STREAM.toString

  def createJob(owner: String,
                jobType: String,
                jobName: String,
                jobContent: String,
                timeout: Long) = ScriptJobManager.newJob(owner, jobType, jobName, jobContent, timeout)

  import org.apache.spark.sql._

  def runtime = PlatformManager.getRuntime

  def getSession = {
    runtime.asInstanceOf[SparkRuntime].sparkSession
  }

  def cleanActiveSession = {
    ScriptQueryExecute.reset
    SparkSession.clearActiveSession()
  }

  def runScript(script: String,
                listener: ScriptQueryExecListener,
                skipInclude: Boolean ,
                skipGrammarValidate: Boolean,
                skipAuth: Boolean,
                skipPhysicalJob: Boolean) = {

    // todo 对job进行管理
    ScriptQueryExecute.exec(script, listener, skipInclude, skipGrammarValidate, skipAuth, skipPhysicalJob)

  }

  def createScriptQueryExecListener(session:SparkSession, defaultPathPrefix:String, owner:String, groupId:String, params:Map[String,String]) = {
    val sqel = new ScriptQueryExecListener(session, defaultPathPrefix, owner)
    ScriptQueryExecute.setContext(ScriptQueryExecuteContext(sqel, owner, sqel.ownerPath(Option(owner)), groupId, params))
    sqel
  }

  def getScriptResult(listener: ScriptQueryExecListener, session: SparkSession, fetchType:String, outputSize:Int): String = {
    val result = new StringBuffer()
    var size = 0
    listener.getLastTableName match {
      case Some(table) =>
        val df = session.table(table)
        val limitDF = limitOrNot(df.limit(outputSize), outputSize )
        val limitSize = limitDF._2
        val jsonDF = limitDF._1.toJSON
        val scriptJsonStringResult = fetchType match {
          case "collect" => jsonDF.collect()
          case "take" => df.toJSON.take(limitSize)
        }
        size = scriptJsonStringResult.length
        result.append("{\"schema\":")
        result.append(df.schema.json)
        result.append(",\"data\":[")
        result.append(scriptJsonStringResult.mkString(","))
        result.append("]}")
      case None =>
        result.append(s"""{"schema":{"type":"struct","fields":[]},"data":[]} """)
    }

    logInfo(s"Job executed successfully, fetch a total of $size rows of records!")
    result.toString
  }


  /**
    * | enable limit | global | maxResultSize | condition                       | result           |
    * | ------------ | ------ | ------------- | ------------------------------- | ---------------- |
    * | true         | -1     | -1            | N/A                             | defualt = 1000   |
    * | true         | -1     | Int           | N/A                             | ${maxResultSize} |
    * | true         | Int    | -1            | Or ${maxResultSize} > ${global} | ${global}        |
    * | true         | Int    | Int           | AND ${maxResultSize} < ${global}| ${maxResultSize} |
    *
    * when we enable result size limitation, the size of result should <= ${maxSize} <= ${global}
    *
    * @param ds
    * @param maxResultSize
    * @tparam T
    * @return (limitDF, limitSize)
    */
  private def limitOrNot[T](ds: Dataset[T], maxResultSize: Int = -1):(Dataset[T], Int) = {
    var result = ds
    var size = maxResultSize
    val conf = ds.sparkSession.sparkContext.getConf
    val defaultGlobalSize = IdesConf.RESTFUL_API_MAX_RESULT_SIZE.defaultValue.get
    val globalLimit = conf.getInt(IdesConf.RESTFUL_API_MAX_RESULT_SIZE.key, -1)
    if (conf.getBoolean(IdesConf.ENABLE_MAX_RESULT_SIZE.key, false)) {
      if (globalLimit == -1) {
        if (maxResultSize == -1) {
          result = ds.limit(defaultGlobalSize)
          size = defaultGlobalSize
        } else {
          result = ds.limit(maxResultSize)
          size = maxResultSize
        }
      } else {
        if (maxResultSize == -1 || maxResultSize > globalLimit) {
          result = ds.limit(globalLimit)
          size = globalLimit
        } else {
          result = ds.limit(maxResultSize)
          size = maxResultSize
        }
      }
    }
    (result, size)
  }

}
