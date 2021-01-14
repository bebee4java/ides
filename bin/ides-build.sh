#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)
PROJECT_ROOT_DIR=$(cd $(dirname "$SHELL_FOLDER"); pwd)

export MAVEN_OPTS="-Xmx512m"

cd $PROJECT_ROOT_DIR

rm -rf jars

mode=$1

usage() {
  echo "please input build mode:[shell/rest]"
  exit -1
}

if [ -z "${mode}" ]; then
    usage
fi

if [ "shell" == "${mode}" ]; then
  mvn -DskipTests clean package \
  -pl repl,assembly -am  \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Ponline \
  -Pbuild
elif [ "rest" == "${mode}" ]; then
  mvn -DskipTests clean package \
  -pl repl,assembly -am  \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Ponline \
  -Prestful-server \
  -Pbuild
else
  usage
fi
