/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.external.xml;

import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import com.mdrsolutions.external.sql.SqlCalls;
import static com.mdrsolutions.external.sql.SqlCalls.getSql;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author mrodgers9
 */
public class XmlCalls {

    private static final Logger logger = Logger.getLogger(XmlCalls.class);

    public static final String getXml(String filePath) {
        String xml = "";
        try {
            InputStream is = SqlCalls.class.getResourceAsStream(filePath);
            xml = CharStreams.toString(new InputStreamReader(is));
            if (null == xml || xml.isEmpty()) {
                Closeables.closeQuietly(is);
                throw new IOException("File path to XML file could not be read!");
            } else {
                Closeables.closeQuietly(is);
                return xml;
            }
        } catch (IOException ex) {
            logger.error("Could not read the sql file specified!", ex);
        }
        return xml;
    }

    public static final String getXml(String filePath, boolean notClassPath) {

        String xml = "";
        InputStream is;

        if (!notClassPath) {
            return getXml(filePath);
        }

        try {
            File f = new File(filePath);
            is = new FileInputStream(f);
            if (null == xml || xml.isEmpty()) {
                Closeables.closeQuietly(is);
                throw new IOException("File path to SQL file could not be read!");
            } else {
                Closeables.closeQuietly(is);
                return xml;
            }
        } catch (IOException ex) {
            logger.error("Could not read the sql file specified!", ex);
        }
        return xml;
    }
}
