package org.apache.spark.deploy

import java.lang.reflect.{InvocationTargetException, UndeclaredThrowableException}
import org.apache.spark.SparkUserAppException
import org.apache.spark.deploy.SparkSubmit.{exitFn, printMessage}
import org.apache.spark.util.Utils
import tech.ides.exception.IdesException
import tech.sqlclub.common.log.Logging
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import java.util
import tech.ides.cli.DatalinkedCli

/**
  *
  * Created by songgr on 2020/07/26.
  */
object IdesSubmit extends Logging {
  private val CLASS_NOT_FOUND_EXIT_STATUS = 101

  def main(args: Array[String]): Unit = {
    val mainApp = args.last
    val debugOpt = args.zipWithIndex.find(_._1.startsWith("-debug"))
    if (debugOpt.isDefined) {
      val debug = debugOpt.get._1
      val index = debugOpt.get._2
      // 将debug参数置空
      if (debug.matches("\\-debug=[0-9]+")){
        args.update(index, null)
      } else {
        args.update(index, null)
        args.update(index+1, null)
      }
    }
    val options = args.filterNot(null == _).dropRight(1)
    val cliArgs = if (args.contains(classOf[DatalinkedCli].getName)) {
      DatalinkedCli.init(options)
    } else options

    import scala.collection.JavaConverters._
    val argsArray = new util.ArrayList[String](cliArgs.toList.asJava)
    val argsBuffer = new ArrayBuffer[String]()
    for (x <- cliArgs) {
      if (x.startsWith("-ides.")) {
        // The config format must be -ides.k=v
        x.split("=", 2).toSeq match {
          case Seq(k, v) => argsBuffer += k; argsBuffer += v
          case _ => throw new IdesException(s"IDES config without '=': $x")
        }
        argsArray.remove(x)
      }
    }
    // 加入 mian app
    argsArray.add(mainApp)
    lazy val submitArguments = new SparkSubmitArguments(argsArray.asScala) {
      self =>
      override protected def logInfo(msg: => String): Unit = printMessage(msg)

      override protected def logWarning(msg: => String): Unit = printMessage(s"Warning: $msg")
    }

    try {
      submitArguments
    } catch {
      case e: SparkUserAppException =>
        exitFn(e.exitCode)
    }

    val (childArgs, childClasspath, sparkConf, childMainClass) = new SparkSubmit().prepareSubmitEnvironment(submitArguments)
    var mainClass: Class[_] = null

    try {
      mainClass = Utils.classForName(childMainClass)
    } catch {
      case e: ClassNotFoundException =>
        logWarning(s"Failed to load $childMainClass.", e)
        if (childMainClass.contains("thriftserver")) {
          logInfo(s"Failed to load main class $childMainClass.")
          logInfo("You need to build Spark with -Phive and -Phive-thriftserver.")
        }
        throw new SparkUserAppException(CLASS_NOT_FOUND_EXIT_STATUS)
      case e: NoClassDefFoundError =>
        logWarning(s"Failed to load $childMainClass: ${e.getMessage()}")
        if (e.getMessage.contains("org/apache/hadoop/hive")) {
          logInfo(s"Failed to load hive class.")
          logInfo("You need to build Spark with -Phive and -Phive-thriftserver.")
        }
        throw new SparkUserAppException(CLASS_NOT_FOUND_EXIT_STATUS)
    }

    val app: SparkApplication = if (classOf[SparkApplication].isAssignableFrom(mainClass)) {
      mainClass.newInstance().asInstanceOf[SparkApplication]
    } else {
      // SPARK-4170
      if (classOf[scala.App].isAssignableFrom(mainClass)) {
        logWarning("Subclasses of scala.App may not work correctly. Use a main() method instead.")
      }
      new JavaMainApplication(mainClass)
    }

    @tailrec
    def findCause(t: Throwable): Throwable = t match {
      case e: UndeclaredThrowableException =>
        if (e.getCause() != null) findCause(e.getCause()) else e
      case e: InvocationTargetException =>
        if (e.getCause() != null) findCause(e.getCause()) else e
      case e: Throwable =>
        e
    }

    try {
      app.start(argsBuffer.toArray, sparkConf)
    } catch {
      case t: Throwable =>
        throw findCause(t)
    }

  }

}
