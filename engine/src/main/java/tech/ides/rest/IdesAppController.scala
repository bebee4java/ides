package tech.ides.rest

import org.apache.spark.IdesConf
import org.scalatra.swagger.{DataType, Parameter}
import tech.ides.core.{ScriptQueryExecute, ScriptQueryExecuteContext}
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.exception.ExceptionUtil
import tech.ides.job.{ScriptJobManager, ScriptJobType}
import tech.ides.core.platform.PlatformManager
import tech.ides.runtime.SparkRuntime
import tech.sqlclub.common.log.Logging

/**
  *
  * Created by songgr on 2020/12/29.
  */
class IdesAppController extends RestController with ControllerUtils {

  get("/", operation(apiOperation[String]("/")
    summary "/"
  )) {
    contentType="text/html"
    import tech.ides.BANNER
    ssp("/index",  "BANNER" -> BANNER)
  }

  post("/run/script", operation(apiOperation[String]("runScript")
    summary "used to execute ides script"
    parameters(
      Parameter("sql", DataType.String, description=Option("脚本内容"), required = true)
      ,Parameter("owner", DataType.String, description=Option("the user who execute this script, default: admin."), required = false, defaultValue = Option("admin"))
      ,Parameter("jobType", DataType.String, description=Option("脚本作业类型, default: batch."), required = false, defaultValue = Option("batch"))
      ,Parameter("jobName", DataType.String, description=Option("脚本作业名称."), required = true)
      ,Parameter("timeout", DataType.Long, description=Option("脚本作业超时时间，单位毫秒, default: -1."), required = false, defaultValue = Option("-1L"))
      ,Parameter("skipInclude", DataType.Boolean, description=Option("是否跳过include阶段, default: false."), required = true, defaultValue = Option("false"))
      ,Parameter("skipGrammarValidate", DataType.Boolean, description=Option("是否跳过语法校验阶段, default: false."), required = true, defaultValue = Option("false"))
      ,Parameter("skipAuth", DataType.Boolean, description=Option("是否跳过权限校验阶段, default: true."), required = true, defaultValue = Option("true"))
      ,Parameter("skipPhysicalJob", DataType.Boolean, description=Option("是否跳过物理作业执行阶段, default: false."), required = true, defaultValue = Option("false"))
      ,Parameter("defaultPathPrefix", DataType.String, description=Option("用户默认资源路径前缀, default: ''."), required = true, defaultValue = Option(""))
      ,Parameter("fetchType", DataType.String, description=Option("数据拉取模式，有collect/take两种, default: collect."), required = true, defaultValue = Option("collect"))
      ,Parameter("outputSize", DataType.Int, description=Option("作业数据最大输出记录数, default: 1000."), required = true, defaultValue = Option("1000"))
    )
  )) {
    contentType="application/json;charset=utf-8"
    var outputResult: String = ""

    try {
      val sql = param("sql")
      val owner = param("owner", "admin")
      val jobType = param("jobType", ScriptJobType.BATCH.toString)
      val jobName = param("jobName", if(sql.length > 100) sql.substring(0, 100) else sql )
      val timeOut = paramAsLong("timeout", -1L)
      val skipInclude = paramAsBoolean("skipInclude", false)
      val skipGrammarValidate = paramAsBoolean("skipGrammarValidate", false)
      val skipAuth = paramAsBoolean("skipAuth", true)
      val skipPhysicalJob = paramAsBoolean("skipPhysicalJob", false)
      val defaultPathPrefix = param("defaultPathPrefix", "")
      val fetchType = param("fetchType", "collect")
      val outputSize = paramAsInt("outputSize", 1000)

      // 获取用户session
      // todo 进行用户session隔离
      val session = getSession
      // 创建job
      val job = ScriptJobManager.newJob(owner, jobType, jobName, sql, timeOut)
      // 创建脚本执行监听器
      val sqel = createScriptQueryExecListener(session, defaultPathPrefix, owner, job.groupId, requestParam)
      // 执行脚本
      runScript(sql, sqel, skipInclude, skipGrammarValidate, skipAuth, skipPhysicalJob)
      // 获取输出
      outputResult = getScriptResult(sqel, session, fetchType , outputSize)
    } catch {
      case e:Throwable =>
        // todo 异常管理
        logError(e.getMessage, e)
        val errorMsg = ExceptionUtil.format_throwable(e)
        outputResult = errorMsg
        render(500, outputResult)
    }
    logInfo("Congratulations completed!\tPOST\t/run/script")
    render(200, outputResult)
  }

}


trait ControllerUtils extends Logging {
  import org.apache.spark.sql._

  val runtime = PlatformManager.getRuntime

  def getSession = {
    runtime.asInstanceOf[SparkRuntime].sparkSession
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