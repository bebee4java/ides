package org.apache.hadoop.hdfs

import java.io.{BufferedReader, InputStreamReader}
import org.apache.commons.io.output.ByteArrayOutputStream
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FSDataInputStream, FileStatus, FileSystem, Path}
import org.apache.hadoop.io.IOUtils
import org.apache.spark.deploy.SparkHadoopUtil
import scala.collection.mutable.ArrayBuffer

/**
  * hdfs 文件系统操作类
  * Created by songgr on 2021/02/23.
  */
object HdfsOperator {

  def hadoopConfiguration:Configuration = {
    val sparkHadoopUtil = SparkHadoopUtil.get
    if(sparkHadoopUtil != null){
      sparkHadoopUtil.conf
    } else new Configuration()
  }

  def isDir(path: String):Boolean = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.isDirectory(new Path(path))
  }

  def isFile(path: String):Boolean = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.isFile(new Path(path))
  }

  def fileExists(path: Path):Boolean = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.exists(path)
  }

  def fileExists(path: String):Boolean = {
    fileExists(new Path(path))
  }

  def createDir(path: String):Boolean = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.mkdirs(new Path(path))
  }

  def deleteDir(path: String) = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.delete(new Path(path), true)
  }

  def getFileStatus(path: String):FileStatus = {
    val fs = FileSystem.get(hadoopConfiguration)
    val file = fs.getFileStatus(new Path(path))
    file
  }

  def listFiles(path: String): Seq[FileStatus] = {
    val fs = FileSystem.get(hadoopConfiguration)
    fs.listStatus(new Path(path))
  }

  def readFile(path: String): String = {
    val fs = FileSystem.get(hadoopConfiguration)
    var br: BufferedReader = null
    var line: String = null
    val result = new ArrayBuffer[String]()
    try {
      br = new BufferedReader(new InputStreamReader(fs.open(new Path(path))))
      line = br.readLine()
      while (line != null) {
        result += line
        line = br.readLine()
      }
    } finally {
      if (br != null) br.close()
    }
    result.mkString("\n")
  }

  def readBytes(fileName: String): Array[Byte] = {
    val fs = FileSystem.get(hadoopConfiguration)
    val src: Path = new Path(fileName)
    var in: FSDataInputStream = null
    try {
      in = fs.open(src)
      val byteArrayOut = new ByteArrayOutputStream()
      IOUtils.copyBytes(in, byteArrayOut, 1024, true)
      byteArrayOut.toByteArray
    } finally {
      if (null != in) in.close()
    }
  }

}
