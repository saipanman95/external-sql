# external-sql
Utility class for loading external SQL files and returns them as a String via class loader "getResourseAsStream". This means that the packaged jar or war must contain the sql files to be loaded.

# How to use:

String mySql = SqlCalls.getSql("db/scripts/application/mySql.sql");

OR

boolean notClassPath = true;
String mySql = SqlCalls.getSql("c:/apps/db/scripts/application/mySql.sql", notClassPath);

Location of sql files is understood as follows:

src/main/resources/db/scripts
