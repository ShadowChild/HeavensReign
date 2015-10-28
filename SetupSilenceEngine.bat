@ECHO OFF

:setup
set currentDir=%CD%
set silenceDir=%currentDir%\SilenceEngine
set mainDir=%silenceDir%\..\

:buildEngine
echo Copying Files...
echo f | xcopy /y %currentDir%\setup.bat %currentDir%\SilenceEngine\setup.bat
cd %silenceDir%
call setup.bat

:copyLibs
echo Copying Libraries...
echo f | xcopy /y %silenceDir%\build\libs\SilenceEngine.jar %mainDir%\libs\SilenceEngine\SilenceEngine.jar
robocopy %silenceDir%\libs\ %mainDir%\libs\LWJGL\

:cleanup
echo Cleaning Up...
del %silenceDir%\setup.bat

pause
