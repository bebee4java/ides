package tech.ides.utils

import java.io.{BufferedReader, InputStreamReader}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

import scala.collection.mutable.ArrayBuffer

/**
  *
  * Created by songgr on 2021/03/17.
  */
object FileUtils {

  /**
    * 读取文件内容输出
    * 根据Path获取FileSystem，无需判断路径是以hdfs://还是file://可直接读取
    * @param filePath 文件路径
    * @return String
    */
  def readFileToString(filePath:String):String = {
    val conf = new Configuration
    val path = new Path(filePath)
    val fs = FileSystem.get(path.toUri, conf)

    var br: BufferedReader = null
    var line: String = null
    val result = new ArrayBuffer[String]()
    try {
      br = new BufferedReader(new InputStreamReader(fs.open(path)))
      line = br.readLine()
      while (line != null) {
        result += line
        line = br.readLine()
      }
    } finally {
      if (br != null) br.close()
      if (fs != null) fs.close()
    }
    result.mkString("\n")
  }
}
