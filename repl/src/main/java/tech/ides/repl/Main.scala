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

import scala.tools.nsc.GenericRunnerSettings
import org.apache.spark._
import org.apache.spark.sql.SparkSession
import tech.sqlclub.common.log.Logging

object Main extends Logging {

//  initializeLogIfNecessary(true)
  Signaling.cancelOnInterrupt()

  val conf = new IdesConf()
//  val rootDir = conf.getOption("ides.repl.classdir").getOrElse(Utils.getLocalDir(conf))
//  val outputDir = Utils.createTempDir(root = rootDir, namePrefix = "repl")

  var sparkContext: SparkContext = _
  var sparkSession: SparkSession = _
  // this is a public var because tests reset it.
  var interp: IdesILoop = _

  private var hasErrors = false
  private var isShellSession = false

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
    interp = _interp
    val jars = "" // getLocalUserJarsForShell
    val interpArguments = List(
      "-Yrepl-class-based",
      "-Yrepl-outdir", s"",
      "-classpath", jars
    ) ++ args.toList

    val settings = new GenericRunnerSettings(scalaOptionError)
    settings.processArguments(interpArguments, true)
    //Solve following problem:
    //error: error while loading Object, Missing dependency 'object scala in compiler mirror', required by /Library/Java/.../jre/lib/rt.jar(java/lang/Object.class)
    //[error] (run-main-0) scala.reflect.internal.MissingRequirementError: object scala in compiler mirror not found.
    settings.usejavacp.value = true // solved

    if (!hasErrors) {
      interp.process(settings) // Repl starts and goes in loop of R.E.P.L
      // finish close context
      Option(sparkContext).foreach(_.stop)
    }
  }

  def createSparkSession(): SparkSession = {
    try {
      sparkSession = SparkSession.builder().appName("ides shell").master("local[*]").getOrCreate()
      sparkContext = sparkSession.sparkContext
      sparkSession
    } catch {
      case e: Exception if isShellSession =>
        logError("Failed to initialize Spark session.", e)
        sys.exit(1)
    }
  }

}
