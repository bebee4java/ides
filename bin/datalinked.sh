#!/usr/bin/env bash

####################################################
#               用于一次性提交脚本作业                 #
# 实例1：sh datalinked.sh -e  "select 1 as t;"      #
# 实例2：sh datalinked.sh -f /home/ides/etl/etl.sql #
####################################################


cygwin=false
case "$(uname)" in
  CYGWIN*) cygwin=true;;
esac

# Enter posix mode for bash
set -o posix

if [ -z "${IDES_HOME}" ]; then
  source "$(dirname "$0")"/find-ides-home
fi

IDES_SUBMIT_OPTS="$IDES_SUBMIT_OPTS -Dscala.usejavacp=true"
appName="ides-query-"$(date +"%Y%m%d%H")

function main() {
  if $cygwin; then
    # Workaround for issue involving JLine and Cygwin
    # (see http://sourceforge.net/p/jline/bugs/40/).
    # If you're using the Mintty terminal emulator in Cygwin, may need to set the
    # "Backspace sends ^H" setting in "Keys" section of the Mintty options
    # (see https://github.com/sbt/sbt/issues/562).
    stty -icanon min 1 -echo > /dev/null 2>&1
    export IDES_SUBMIT_OPTS="$IDES_SUBMIT_OPTS -Djline.terminal=unix"
    "${IDES_HOME}"/bin/ides-submit --class tech.ides.cli.DatalinkedCli --name ${appName} "$@"
    stty icanon echo > /dev/null 2>&1
  else
    export IDES_SUBMIT_OPTS
    "${IDES_HOME}"/bin/ides-submit --class tech.ides.cli.DatalinkedCli --name ${appName} "$@"
  fi
}

# Copy restore-TTY-on-exit functions from Scala script so ides-shell exits properly even in
# binary distribution of IDES where Scala is not installed
exit_status=127
saved_stty=""

# restore stty settings (echo in particular)
function restoreSttySettings() {
  stty $saved_stty
  saved_stty=""
}

function onExit() {
  if [[ "$saved_stty" != "" ]]; then
    restoreSttySettings
  fi
  exit $exit_status
}

# to reenable echo if we are interrupted before completing.
trap onExit INT

# save terminal settings
saved_stty=$(stty -g 2>/dev/null)
# clear on error so we don't later try to restore them
if [[ ! $? ]]; then
  saved_stty=""
fi

main "$@" $IDES_HOME/bin/datalinked.sh

# record the exit status lest it be overwritten:
# then reenable echo and propagate the code.
exit_status=$?
onExit