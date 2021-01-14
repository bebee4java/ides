#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)
PROJECT_ROOT_DIR=$(cd $(dirname "$SHELL_FOLDER"); pwd)

export MAVEN_OPTS="-Xmx512m"

cd $PROJECT_ROOT_DIR

function package_2.4 {
  mvn -DskipTests clean package \
  -pl engine -am  \
  -Ponline \
  -Pscala-2.11 \
  -Pspark-2.4.x \
  -Prestful-server \
  -Pshade
}

function package_2.3 {
  mvn -DskipTests clean package \
  -pl engine -am  \
  -Ponline \
  -Pscala-2.11 \
  -Pspark-2.3.x \
  -Prestful-server \
  -Pshade
}

function usage() {
    echo "Usage: ./package.sh <2.3|2.4>"
}

case "$1" in
    2.3)
        package_2.3
        ;;
    2.4)
        package_2.4
        ;;
    *)
        usage
        exit 0
esac