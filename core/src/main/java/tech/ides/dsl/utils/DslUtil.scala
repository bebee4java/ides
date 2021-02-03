package tech.ides.dsl.utils

import ides.dsl.parser.{IdesLexer, IdesParser}
import ides.dsl.parser.IdesParser._
import org.antlr.v4.runtime.{ParserRuleContext, Token}
import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.TerminalNode
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.constants.ScriptConstants.{PATH_SEPARATOR, PATH_SEPARATOR_SIZE}
import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  *
  * Created by songgr on 2020/11/05.
  */
object DslUtil {

  def currentText(ctx: ParserRuleContext):String = {
    if ( ctx == null ) return null
    val input = ctx.start.getTokenSource.asInstanceOf[IdesLexer]._input

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

  def parserRuleContext(ruleContext: ParserRuleContext):String = {
    ruleContext.children.asScala.headOption.map {
      case pt if pt.isInstanceOf[Token] || pt.isInstanceOf[TerminalNode] =>
        val tTpye = pt match {
          case t:Token => t.asInstanceOf[Token].getType
          case t:TerminalNode => t.asInstanceOf[TerminalNode].getSymbol.getType
          case _ => return pt.getText
        }

        tTpye match {
          case IdesParser.MUMERIC |
               IdesParser.IDENTIFIER
          => pt.getText
          case
            IdesParser.STRING_TEXT |
            IdesParser.BLOCK_STRING_TEXT |
            IdesParser.QUOTED_TEXT
          => cleanStr(pt.getText)
          case _
          => pt.getText
        }
      case pt:ParserRuleContext =>
        parserRuleContext(pt.asInstanceOf[ParserRuleContext])
      case pt => pt.getText
    }.getOrElse("")
  }

  def parseAssetName(assetName:AssetNameContext):String = {
    if (assetName == null) return ""
    parserRuleContext(assetName)
  }

  def getExpressionKey(ec: ExpressionContext):String = {
    if ( ec == null ) return null
    ec.keyName().getText
  }

  def getExpressionValue(ec: ExpressionContext):String = {
    if ( ec == null ) return null
    parserRuleContext(ec.valueName())
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
