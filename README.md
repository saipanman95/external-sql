# external-sql
Utility class for loading external SQL files and returns them a String.

# How to use:

String mySql = SqlCalls.getSql("db/scripts/application/mySql.sql");

Location of sql files is understood as follows:

src/main/resources/db/scripts
