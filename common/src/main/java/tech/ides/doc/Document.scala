package tech.ides.doc

/**
 * ET插件文档类
 * Created by songgr on 2022/02/11.
 */

case class Document(docType: DocType, doc: String)

sealed abstract class DocType
(
  val docType: String
)

case object HtmlDoc extends DocType("html")

case object MarkDownDoc extends DocType("md")

case object TextDoc extends DocType("text")


