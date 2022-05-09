package tech.ides.core

import ides.dsl.parser._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.CommonTokenStream
import tech.ides.dsl.listener.{PreProcessListener, ScriptQueryExecListener}
import tech.sqlclub.common.log.Logging
import tech.ides.constants.ScriptConstants._
import tech.ides.dsl.{CaseChangeCharStream, SyntaxErrorListener}

/**
  *
  * Created by songgr on 2020/10/28.
  */
object ScriptQueryExecute extends Logging {

  // 脚本执行上下文当前线程独享
  private[this] val scriptExecuteContext: ThreadLocal[ScriptQueryExecuteContext] = new ThreadLocal[ScriptQueryExecuteContext]

  def context = scriptExecuteContext.get()

  def setContext(sqec:ScriptQueryExecuteContext) = scriptExecuteContext.set(sqec)

  def reset = scriptExecuteContext.remove()

  def getOrCreateContext() = {
    if (context == null) {
      logWarning("Create default context for unit test, there may be some problems if used in real program!")
      val scriptQueryExecListener = new ScriptQueryExecListener(null, DEFAULT_PATH_PREFIX, TEST_USER)
      setContext(ScriptQueryExecuteContext(scriptQueryExecListener, TEST_USER, scriptQueryExecListener.ownerPath(None), ""))
    }
    context
  }

  /**
    * 脚本执行
    * @param script 脚本内容
    * @param listener 脚本执行监听器
    * @param skipInclude 是否跳过include阶段
    * @param skipGrammarValidate 是否跳过语法检验阶段
    * @param skipAuth 是否跳过权限验证阶段
    * @param skipPhysicalJob 是否跳过物理执行阶段
    */
  def exec(script: String,
           listener: ScriptQueryExecListener,
           skipInclude: Boolean = true,
           skipGrammarValidate: Boolean = true,
           skipAuth: Boolean = true,
           skipPhysicalJob: Boolean = false
          ) = {


    var querySQL = script

    // include stage
    if ( !skipInclude ) {
      // todo 实现include功能
    }

    // set replace stage
    // todo 实现set语法替换

    val preProcessListener = new PreProcessListener(listener)

    listener.setStage(ScriptStage.preProcess)
    parse(querySQL, preProcessListener)

    // 预处理完的sql
    querySQL = preProcessListener.toScript

//    println("======预处理结束========")
//    println(querySQL)



    // grammar validate stage
    if ( !skipGrammarValidate ) {
      // todo 实现语法校验
    }

    // auth stage
    if ( !skipAuth ) {
      // todo 实现权限校验
    }

    // physical job stage
    if ( !skipPhysicalJob ) {
      listener.setStage(ScriptStage.physical)
      parse(querySQL, listener)
    }

  }


  private def parse(script: String, listener: IdesParserBaseListener): Unit = {
    val charStream = new CaseChangeCharStream(script)
    val idesDslLexer = new IdesLexer(charStream)
    val tokenStream = new CommonTokenStream(idesDslLexer)
    val parser = new IdesParser(tokenStream)

    // add syntax error listener
    parser.addErrorListener(new SyntaxErrorListener)

    val statement = parser.statement
    ParseTreeWalker.DEFAULT.walk(listener, statement)
  }

}

/**
  * 脚本查询执行上下文
  * @param execListener 脚本执行监听器
  * @param owner 脚本所有者
  * @param home 所有者家目录
  * @param groupId 脚本groupId
  * @param userDefinedParam 用户自定义参数
  */
case class ScriptQueryExecuteContext(
    @transient execListener: ScriptQueryExecListener,
    owner: String,
    home: String,
    groupId: String,
    userDefinedParam: Map[String, String] = Map())