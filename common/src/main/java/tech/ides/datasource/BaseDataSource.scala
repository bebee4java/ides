package tech.ides.datasource

import java.io.File

/**
  *
  * Created by songgr on 2020/10/26.
  */
trait BaseDataSource {

  def pathSeparator = {
    File.pathSeparator
  }

  def fullFormat: String

  @Deprecated
  def shortFormat: String

  def aliasFormat: String = {
    shortFormat
  }

}
