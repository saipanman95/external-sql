package com.mdrsolutions.external.sql;

import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class SqlCalls {

    private SqlCalls() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlCalls.class);

    public static String getSql(String filePath) {
        String sql = "";
        InputStream is;
        try {
            is = SqlCalls.class.getResourceAsStream(filePath);
            if ( null != is) {
                sql = CharStreams.toString(new InputStreamReader(is));
                if (sql.isEmpty()) {
                    Closeables.closeQuietly(is);
                    throw new IOException("File path to SQL file could not be read!");
                } else {
                    Closeables.closeQuietly(is);
                    return sql;
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Could not read the sql file specified!", ex);
        }
        return sql;
    }

    public static String getSql(String filePath, boolean notClassPath) {

        String sql = "";
        InputStream is;

        if(!notClassPath){
            return getSql(filePath);
        }
        
        try {
            File f = new File(filePath);
            is = new FileInputStream(f);
            if (null != is) {
                sql = CharStreams.toString(new InputStreamReader(is));
                if (null == sql || sql.isEmpty()) {
                    Closeables.closeQuietly(is);
                    throw new IOException("File path to SQL file could not be read!");
                } else {
                    Closeables.closeQuietly(is);
                    return sql;
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Could not read the sql file specified!", ex);
        }
        return sql;
    }

}
