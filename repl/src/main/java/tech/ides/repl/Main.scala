/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.ides.repl

import org.apache.hadoop.fs.FileUtil
import scala.tools.nsc.GenericRunnerSettings
import org.apache.spark._
import org.apache.spark.sql.SparkSession
import tech.ides.conf.IdesConf
import tech.ides.core.platform.PlatformManager
import tech.ides.runtime.SparkRuntime
import tech.sqlclub.common.log.Logging
import tech.ides.conf.IdesConf.{IDES_SHELL_MODE, IDES_SHELL_REPL_CODE_MULTI_LINE, IDES_REPL_CLASS_DIR}
import tech.ides.constants.IdesEnvConstants.IDES_HOME
import tech.ides.core.IdesApp
import tech.ides.dsl.listener.ScriptQueryExecListener
import java.io.File
import java.net.URI
import scala.collection.mutable
import org.apache.spark.repl.Utils

object Main extends Logging {

//  initializeLogIfNecessary(true)
  Signaling.cancelOnInterrupt()
  val idesConf = IdesConf.getOrCreate
  val rootDir = idesConf.get(IDES_REPL_CLASS_DIR).getOrElse(Utils.getLocalDir(new SparkConf()))
  val outputDir = Utils.createTempDir(root = rootDir, namePrefix = "repl")

  // ides script query exec listener
  var listener:ScriptQueryExecListener = _
  var sparkContext: SparkContext = _
  var sparkSession: SparkSession = _
  // this is a public var because tests reset it.
  var interp: IdesILoop = _
  val initialized:ThreadLocal[Boolean] = new ThreadLocal[Boolean]()

  private var hasErrors = false
  private var isShellSession = false

  def offMultiLineInput = idesConf.set(IDES_SHELL_REPL_CODE_MULTI_LINE, false)
  def onMultiLineInput = idesConf.set(IDES_SHELL_REPL_CODE_MULTI_LINE, true)

  private def scalaOptionError(msg: String): Unit = {
    hasErrors = true
    // scalastyle:off println
    Console.err.println(msg)
    // scalastyle:on println
  }

  def main(args: Array[String]) {
    isShellSession = true
    doMain(args, new IdesILoop)
  }

  // Visible for testing
  private[repl] def doMain(args: Array[String], _interp: IdesILoop): Unit = {
    val optionsOfIdes = new mutable.ArrayBuffer[String]()
    args.zipWithIndex.filter(_._1.startsWith("-")).foreach{
      it =>
        optionsOfIdes += args(it._2)
        optionsOfIdes += args(it._2 + 1)
    }

    val optionsOfRepl = args diff optionsOfIdes

    interp = _interp

    var jars = "" // getLocalUserJarsForShell
    val idesHomePath = sys.env.getOrElse(IDES_HOME, null)
    if (idesHomePath != null) {
      jars = FileUtil.listFiles(new File(idesHomePath , "jars")).map(f => f.getAbsolutePath)
        .map { x => if (x.startsWith("file:")) new File(new URI(x)).getPath else x }
        .mkString(File.pathSeparator)
    }

    val replClassOutputDir = outputDir.getAbsolutePath
    idesConf.set(IDES_REPL_CLASS_DIR, replClassOutputDir)
    log.info("ides repl class outputDir: " + replClassOutputDir)
    val interpArguments = List(
      "-Yrepl-class-based",
      "-Yrepl-outdir", replClassOutputDir,
      "-classpath", jars
    ) ++ optionsOfRepl

    val idesArgs = new mutable.ArrayBuffer[String]()
    idesArgs ++= optionsOfIdes += s"-${IDES_SHELL_MODE.key}" += isShellSession.toString
    IdesApp.main(Array(idesArgs:_*))

    val settings = new GenericRunnerSettings(scalaOptionError)
    settings.processArguments(interpArguments, true)
    //Solve following problem:
    //error: error while loading Object, Missing dependency 'object scala in compiler mirror', required by /Library/Java/.../jre/lib/rt.jar(java/lang/Object.class)
    //[error] (run-main-0) scala.reflect.internal.MissingRequirementError: object scala in compiler mirror not found.
    settings.usejavacp.value = true // solved

    if (!hasErrors) {
      interp.process(settings) // Repl starts and goes in loop of R.E.P.L
      // finish close context
      initialized.remove()
      Option(sparkContext).foreach(_.stop)
    }
  }

  def createSparkSession(): SparkSession = {
    try {
      val runtime = PlatformManager.getRuntime
      sparkSession = runtime.asInstanceOf[SparkRuntime].sparkSession
//      sparkSession.sessionState // 解决Error while instantiating 'org.apache.spark.sql.internal.SessionStateBuilder'
//      sparkSession.sharedState.externalCatalog // 解决caused by: java.lang.NoSuchMethodException: org.apache.spark.sql.catalyst.catalog.InMemoryCatalog.<init>(org.apache.spark.SparkConf, org.apache.hadoop.conf.Configuration)
      sparkContext = sparkSession.sparkContext
      sparkSession
    } catch {
      case e: Exception if isShellSession =>
        logError("Failed to initialize Spark session.", e)
        sys.exit(1)
    }
  }

}
