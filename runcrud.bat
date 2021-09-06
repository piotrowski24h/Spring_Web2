call gradlew build
if "ERRORLEVEL"  == "0" goto rename
echo.
echo GRADLEW BUILD has errors - braking work goto fail

:rename
@rem here will be placed next commands

goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished