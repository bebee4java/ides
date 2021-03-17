package tech.ides.rest

import org.scalatra.swagger.{DataType, Parameter}
import tech.ides.exception.ExceptionUtil
import tech.ides.tool.QueryTool

/**
  *
  * Created by songgr on 2020/12/29.
  */
class IdesAppController extends RestController with QueryTool {

  get("/", operation(apiOperation[String]("/")
    summary "/"
  )) {
    contentType="text/html"
    import tech.ides.BANNER
    layoutTemplate("/templates/views/index.ssp",  "BANNER" -> BANNER)
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
      val jobType = param("jobType", BATCH_JOB)
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
      val job = createJob(owner, jobType, jobName, sql, timeOut)
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
    } finally {
      // todo 请求结束清理session
      cleanActiveSession
    }
    render(200, outputResult)
  }

}
