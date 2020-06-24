package tech

import java.util.Properties

import tech.ides.exception.IdesException

package object ides {
  private object IdesBuildInfo {

    val (
      ides_version: String,
      ides_branch: String,
      ides_revision: String,
      ides_build_user: String,
      ides_repo_url: String,
      ides_build_date: String) = {

      val resourceStream = Thread.currentThread().getContextClassLoader.
        getResourceAsStream("ides-version-info.properties")
      if (resourceStream == null) {
        throw new IdesException("Could not find ides-version-info.properties")
      }

      try {
        val unknownProp = "<unknown>"
        val props = new Properties()
        props.load(resourceStream)
        (
          props.getProperty("version", unknownProp),
          props.getProperty("branch", unknownProp),
          props.getProperty("revision", unknownProp),
          props.getProperty("user", unknownProp),
          props.getProperty("url", unknownProp),
          props.getProperty("date", unknownProp)
        )
      } catch {
        case e: Exception =>
          throw new IdesException("Error loading properties from ides-version-info.properties", e)
      } finally {
        if (resourceStream != null) {
          try {
            resourceStream.close()
          } catch {
            case e: Exception =>
              throw new IdesException("Error closing ides build info resource stream", e)
          }
        }
      }
    }
  }

  val IDES_VERSION = IdesBuildInfo.ides_version
  val IDES_BRANCH = IdesBuildInfo.ides_branch
  val IDES_REVISION = IdesBuildInfo.ides_revision
  val IDES_BUILD_USER = IdesBuildInfo.ides_build_user
  val IDES_REPO_URL = IdesBuildInfo.ides_repo_url
  val IDES_BUILD_DATE = IdesBuildInfo.ides_build_date

  val BANNER =
    """Welcome to
     ___  ________  _______   ________
    |\  \|\   ___ \|\  ___ \ |\   ____\
    \ \  \ \  \_|\ \ \   __/|\ \  \___|_
     \ \  \ \  \ \\ \ \  \_|/_\ \_____  \
      \ \  \ \  \_\\ \ \  \_|\ \|____|\  \
       \ \__\ \_______\ \_______\____\_\  \
        \|__|\|_______|\|_______|\_________\  version %s
                                \|_________|
    """.format(IDES_VERSION)


}
