#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)
PROJECT_ROOT_DIR=$(cd $(dirname "$SHELL_FOLDER"); pwd)

export MAVEN_OPTS="-Xmx512m"

cd $PROJECT_ROOT_DIR

rm -rf jars

mvn -DskipTests clean package \
  -pl repl -am  \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Plocal \
  -Pbuild
