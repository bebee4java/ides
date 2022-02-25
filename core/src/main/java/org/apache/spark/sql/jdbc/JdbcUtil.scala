package org.apache.spark.sql.jdbc

import org.apache.spark.sql.execution.datasources.jdbc.{JDBCOptions, JdbcUtils}
import org.apache.spark.sql.types.{DataType, StructType}

/**
  *
  * Created by songgr on 2021/03/04.
  */
object JdbcUtil {

  def getJdbcType(dt: DataType, dialect: JdbcDialect): JdbcType = {
    dialect.getJDBCType(dt).orElse(JdbcUtils.getCommonJDBCType(dt)).getOrElse(
      throw new IllegalArgumentException(s"Can't get JDBC type for ${dt.simpleString}")
    )
  }

  def getDialect(option: JDBCOptions) = {
    JdbcDialects.get(option.url)
  }

  def jdbcNullType(schema: StructType, option: JDBCOptions) = {
    val dialect = getDialect(option)
    schema.fields.map { field =>
      getJdbcType(field.dataType, dialect).jdbcNullType
    }
  }

}
