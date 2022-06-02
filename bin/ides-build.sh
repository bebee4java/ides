#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)
PROJECT_ROOT_DIR=$(cd $(dirname "$SHELL_FOLDER"); pwd)

export MAVEN_OPTS="-Xmx512m"

cd $PROJECT_ROOT_DIR

rm -rf jars

mode=$1
version=$2
echo "build start! mode: $mode, version: $version"

usage() {
  echo "please input build mode:[shell/rest]"
  exit -1
}

if [ -z "${mode}" ]; then
    usage
fi

build_version="publish-version"
if [ -n "${version}" -a "dev" == "${version}" ]; then
    build_version="dev-version"
fi

if [ "shell" == "${mode}" ]; then
  mvn -DskipTests clean package \
  -pl repl,assembly -am  \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Ponline \
  -P${build_version} \
  -Pbuild
elif [ "rest" == "${mode}" ]; then
  mvn -DskipTests clean package \
  -pl repl,assembly -am  \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Ponline \
  -Prestful-server \
  -P${build_version} \
  -Pbuild
else
  usage
fi
