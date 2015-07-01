package com.mdrsolutions.external.sql;

import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import java.io.*;
import org.apache.log4j.Logger;

public class SqlCalls {

    private SqlCalls() {
    }

    private static final Logger logger = Logger.getLogger(SqlCalls.class);

    public static final String getSql(String filePath) {
        String sql = "";
        InputStream is;
        try {

            is = SqlCalls.class.getResourceAsStream(filePath);
            sql = CharStreams.toString(new InputStreamReader(is));
            if (null == sql || sql.isEmpty()) {
                Closeables.closeQuietly(is);
                throw new IOException("File path to SQL file could not be read!");
            } else {
                Closeables.closeQuietly(is);
                return sql;
            }
        } catch (IOException ex) {
            logger.error("Could not read the sql file specified!", ex);
        }
        return sql;
    }

    public static final String getSql(String filePath, boolean notClassPath) {

        String sql = "";
        InputStream is;

        if(!notClassPath){
            return getSql(filePath);
        }
        
        try {
            File f = new File(filePath);
            is = new FileInputStream(f);
            if (null == sql || sql.isEmpty()) {
                Closeables.closeQuietly(is);
                throw new IOException("File path to SQL file could not be read!");
            } else {
                Closeables.closeQuietly(is);
                return sql;
            }
        } catch (IOException ex) {
            logger.error("Could not read the sql file specified!", ex);
        }
        return sql;
    }

}
