@echo off
set BAT_HOME = ./runtime/bin
java -jar LwhResourceManager.jar -Xmx128M -Xms64M -Xmn32M --illegal-access=deny --add-opens java.base/java.lang.reflect=ALL-UNNAMED
