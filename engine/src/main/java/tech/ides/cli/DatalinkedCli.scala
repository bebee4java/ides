package tech.ides.cli

import java.io.PrintWriter
import com.google.common.base.Strings
import tech.ides.core.IdesApp
import tech.ides.exception.IdesException
import tech.ides.tool.QueryTool
import tech.ides.utils.FileUtils
import scala.collection.mutable
import scala.collection.JavaConverters._

/**
  * Datalinked cli
  * Created by songgr on 2021/03/16.
  */
object DatalinkedCli extends OptionsProcessor with QueryTool {

  private var sqlText:String = null

  def init(args:Array[String]):Array[String] = {
    val options = args.zipWithIndex.filter(arg => isOption(arg._1))

    if (options.isEmpty) process(Array("-h"))

    val optionsOfCli = new mutable.ArrayBuffer[String]()
    options.foreach{
      it =>
        if (hasArg(it._1)) {
          optionsOfCli += args(it._2)
          val valueIndex = it._2 + 1
          if ( valueIndex >= args.length) {
            val opt = getOption(it._1)
            throw new IdesException(s"${it._1} <${opt.getArgName}> has ${opt.getArgs} args, must be set.")
          }
          optionsOfCli += args(valueIndex)
        } else optionsOfCli += args(it._2)
    }
    process(optionsOfCli.toArray)

    sqlText = if (hasOption('e')) {
      getText('e')
    } else if (hasOption('f')) {
      getTextFromFile('f')
    } else {
      ""
    }

    if (hasOption('d')) {
      val env = getOptionProperties("d")
      sys.props ++= env.asScala
    }

    if (Strings.isNullOrEmpty(sqlText)) {
      sysOut("The SQL content you entered is empty!\n")
      System.exit(0)
    }
    args diff optionsOfCli
  }

  protected def getText(opt: Char): String = getValue(opt)

  protected def getTextFromFile(opt: Char): String = {
    val filepaths = getValue(opt)
    filepaths.split(",").map(FileUtils.readFileToString).mkString("\n")
  }

  def sysOut(mess:String) = {
    val pw = new PrintWriter(System.out)
    pw.append(mess)
    pw.flush()
    pw.close()
  }

  def main(args: Array[String]): Unit = {
    // 启动ides app
    IdesApp.main(args)
    val session = getSession
    val owner = sys.props.getOrElse("owner", "ides")
    val jobName = sys.props.getOrElse("jobName", if(sqlText.length > 100) sqlText.substring(0, 100) else sqlText )
    val timeOut = sys.props.getOrElse("timeout", "-1")
    val defaultPathPrefix = sys.props.getOrElse("defaultPathPrefix", "")
    val skipInclude = sys.props.getOrElse("skipInclude", "false")
    val skipGrammarValidate = sys.props.getOrElse("skipGrammarValidate", "false")
    val skipAuth = sys.props.getOrElse("skipAuth", "true")
    val skipPhysicalJob = sys.props.getOrElse("skipPhysicalJob", "false")

    val numRows = sys.props.getOrElse("numRows", "20")
    val truncate = sys.props.getOrElse("truncate", "true")

    val job = createJob(owner,BATCH_JOB, jobName, sqlText, timeOut.toLong)
    val sqel = createScriptQueryExecListener(session, defaultPathPrefix, owner, job.groupId, sys.env)
    try {
      runScript(sqlText, sqel, skipInclude.toBoolean, skipGrammarValidate.toBoolean, skipAuth.toBoolean, skipPhysicalJob.toBoolean)

      if (hasOption('v')) {
        sqel.getLastTableName match {
          case Some(tb) =>
            session.table(tb).show(numRows.toInt, truncate.toBoolean)
          case None =>
            session.emptyDataFrame.show()
        }
      }
    } catch {
      case e:Throwable =>
        // todo 异常管理
        logError(e.getMessage, e)
    } finally {
      cleanActiveSession
    }
  }
}

class DatalinkedCli