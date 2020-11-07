package tech.ides.dsl.utils

import ides.dsl.parser.IdesDslLexer
import ides.dsl.parser.IdesDslParser.{ExpressionContext, QueryContext, WhereExpressionsContext}
import org.antlr.v4.runtime.misc.Interval
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.constants.ScriptConstants.{PATH_SEPARATOR, PATH_SEPARATOR_SIZE}
import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  *
  * Created by songgr on 2020/11/05.
  */
object DslUtil {

  def currentText(ctx: QueryContext):String = {
    if ( ctx == null ) return null
    val input = ctx.start.getTokenSource.asInstanceOf[IdesDslLexer]._input

    val start = ctx.start.getStartIndex
    val stop = ctx.stop.getStopIndex
    val interval = new Interval(start, stop)
    input.getText(interval)
  }


  def cleanStr(str: String):String = {
    if ( str == null ) return null
    if (str.startsWith("'''") || str.startsWith("\"\"\"")) {
      return str.substring(3, str.length - 3)
    }

    if (str.startsWith("`") || str.startsWith("'") || str.startsWith("\"")) {
      str.substring(1, str.length - 1)
    } else {
      str
    }
  }

  def getExpressionKey(ec: ExpressionContext):String = {
    if ( ec == null ) return null

    ec.qualifiedName().getText
  }

  def getExpressionValue(ec: ExpressionContext):String = {
    if ( ec == null ) return null

    if (ec.MUMERIC() != null) {
      ec.MUMERIC().getText
    } else if (ec.STRING_TEXT() != null ) {
      cleanStr(ec.STRING_TEXT().getText)
    } else if (ec.BLOCK_STRING_TEXT() != null) {
      cleanStr(ec.BLOCK_STRING_TEXT().getText)
    } else {
      null
    }
  }

  def whereExpressionsToMap(ec: WhereExpressionsContext):Map[String,String] = {
    if (ec == null) return Map()

    val options = new mutable.HashMap[String,String]()
    options(getExpressionKey(ec.expression())) = getExpressionValue(ec.expression())
    ec.booleanExpression().asScala.foreach {
      booleanExpression =>
        val expression = booleanExpression.expression()
        options(getExpressionKey(expression)) = getExpressionValue(expression)
    }
    options.toMap
  }

  def withPathPrefix(prefix: String, path: String): String = {
    if( prefix == null || path == null ) return null
    if (prefix.isEmpty) return path

    if (path.startsWith(PATH_SEPARATOR)) {
      prefix + path.substring(PATH_SEPARATOR_SIZE, path.length)
    } else {
      prefix + path
    }
  }

  /**
    * calculate the real absolute path of resource.
    * resource path = owner path prefix + input path
    *
    * @param scriptQueryExecListener script query execute listener, which contains owner and path prefix relationship.
    * @param resourceOwner         resource owner
    * @param path                  resource relative path
    * @return String
    */
  def resourceRealPath(scriptQueryExecListener: ScriptQueryExecListener,
                       resourceOwner: Option[String],
                       path: String): String = {
    withPathPrefix(scriptQueryExecListener.ownerPath(resourceOwner), cleanStr(path))
  }

}
