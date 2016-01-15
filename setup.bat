@ECHO OFF

:setup
set currentDir="%CD%"
set silenceDir=%currentDir%\SilenceEngine
set commonDir=%currentDir%\ShadowCommon
set mainDir=%silenceDir%\..\

:buildShadowCommon
echo Building ShadowCommon...
pushd %commonDir%
call mvnw clean install
popd

:buildEngine
echo Building SilenceEngine...
pushd %silenceDir%
call gradlew clean build javadoc
popd

:copyLibs
echo Copying Libraries...
echo f | xcopy /y %silenceDir%\build\libs\SilenceEngine.jar %mainDir%\libs\SilenceEngine\SilenceEngine.jar
robocopy %silenceDir%\libs\ %mainDir%\libs\LWJGL\
robocopy %commonDir%\build\ %mainDir%\libs\ShadowCommon\

:mvnInstall
call mvnw clean install

:end
pause

