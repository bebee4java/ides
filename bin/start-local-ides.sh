#!/usr/bin/env bash

if [ -z "${IDES_HOME}" ]; then
  source "$(dirname "$0")"/find-ides-home
fi

. "${IDES_HOME}"/bin/load-ides-env

# Find the java binary
if [ -n "${JAVA_HOME}" ]; then
  RUNNER="${JAVA_HOME}/bin/java"
else
  if [ "$(command -v java)" ]; then
    RUNNER="java"
  else
    echo "JAVA_HOME is not set" >&2
    exit 1
  fi
fi

# Find Spark jars.
if [ -d "${IDES_HOME}/jars" ]; then
  IDES_JARS_DIR="${IDES_HOME}/jars"
fi

if [ ! -d "$IDES_JARS_DIR" ]; then
  echo "Failed to find IDES jars directory ($IDES_JARS_DIR)." 1>&2
  exit 1
else
  LAUNCH_CLASSPATH="$IDES_JARS_DIR/*"
fi

build_envs() {
    export HADOOP_CONF_DIR="${HADOOP_CONF_DIR:-""}"
    export YARN_CONF_DIR="${YARN_CONF_DIR:-""}"
    export SPARK_DIST_CLASSPATH="${SPARK_DIST_CLASSPATH:-""}"
    export IDES_CONF_DIR="${IDES_CONF_DIR:-"${IDES_HOME}"/conf}"

    printf "%s:" $IDES_CONF_DIR $HADOOP_CONF_DIR $YARN_CONF_DIR $SPARK_DIST_CLASSPATH
}

default_args() {
      printf "%s " \
      "-spark.app.name" "ides" \
      "-spark.master" "local[*]" \
      "-spark.driver.memory" "512m" \
      "-ides.spark.service" "true" \
      "-ides.server.port" "9009" \
      "-ides.server.request-log.enable" "true"
}

#DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8888"
DRIVER_MEM=4g

JAVA_OPTS="-Xmx${DRIVER_MEM:-1g} $DEBUG_OPTS"

$RUNNER $JAVA_OPTS -cp $(build_envs)"$LAUNCH_CLASSPATH" tech.ides.core.IdesApp  $(default_args)" $@"