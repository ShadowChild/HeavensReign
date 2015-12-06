@ECHO OFF

:setup
set currentDir="%CD%"
set silenceDir=%currentDir%\SilenceEngine
set commonDir=%currentDir%\ShadowCommon
set mainDir=%silenceDir%\..\

:buildShadowCommon
echo Copying Files...
echo f | xcopy /y %currentDir%\setupSC.bat %commonDir%\setup.bat
pushd %commonDir%
call setup.bat
popd

:buildEngine
echo Copying Files...
echo f | xcopy /y %currentDir%\setupSE.bat %silenceDir%\setup.bat
pushd %silenceDir%
call setup.bat
popd

:copyLibs
echo Copying Libraries...
echo f | xcopy /y %silenceDir%\build\libs\SilenceEngine.jar %mainDir%\libs\SilenceEngine\SilenceEngine.jar
robocopy %silenceDir%\libs\ %mainDir%\libs\LWJGL\
robocopy %commonDir%\build\ %mainDir%\libs\ShadowCommon\

:mvnInstall
call mvnw clean install

:cleanup
echo Cleaning Up...
del %silenceDir%\setup.bat
del %commonDir%\setup.bat

:end
pause

