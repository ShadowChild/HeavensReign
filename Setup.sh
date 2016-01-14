#!/bin/bash
# Setup.sh

set +v

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
SILENCEDIR=$DIR/SilenceEngine
COMMONDIR=$DIR/ShadowCommon
MAINDIR=$COMMONDIR/../

function setupSC {
  echo Building ShadowCommon...
  pushd $COMMONDIR
  mvnw clean build install
  popd
}

function setupSE {
  echo Building SilenceEngine...
  pushd $SILENCEDIR
  graldew clean build javadoc
  popd
}

function copyLibs {
  echo Copying libs...
  cp $SILENCEDIR/build/libs/SilenceEngine.jar $MAINDIR/libs/SilenceEngine/SilenceEngine.jar
  rsync $SILENCEDIR/libs $MAINDIR/libs/LWJGL
  rsync $SHADOWDIR/build $MAINDIR/libs/ShadowCommon
}

setupSC
setupSE
copyLibs
sleep
