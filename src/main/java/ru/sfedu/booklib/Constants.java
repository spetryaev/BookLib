/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib;

import ru.sfedu.booklib.utils.ConfigurationUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author Sergey
 */
public class Constants {
    
    private static final boolean debug = true;
    
    private static final Logger log = Logger.getLogger(Constants.class);
    
    private static final String CSV_FILE_PATH = getProperty("CSV_FILE_PATH");
    
    private static final String XML_FILE_PATH = getProperty("XML_FILE_PATH");
    
    private static final String DATABASE_HOST = getProperty("DATABASE_HOST");
    private static final String DATABASE_PORT = getProperty("DATABASE_PORT");
    private static final String DATABASE_NAME = getProperty("DATABASE_NAME");
  
    private static final String DATABASE_URL = "jdbc:postgresql://" + 
                                                DATABASE_HOST+ ":" +
                                                DATABASE_PORT+ "/" + 
                                                DATABASE_NAME;
    
    private static final String DATABASE_USER = getProperty("DATABASE_USER");
    
    private static final String DATABASE_PASSWORD = getProperty("DATABASE_PASSWORD");
    
    

    public static String getCSV_FILE_PATH() {
        if(debug){logPropGetter("CSV_FILE_PATH = " + CSV_FILE_PATH);}
        return CSV_FILE_PATH;
    }

    public static String getXML_FILE_PATH() {
        logPropGetter("XML_FILE_PATH = " + XML_FILE_PATH);
        return XML_FILE_PATH;
    }

    public String getDATABASE_URL() {
        logPropGetter("DATABASE_URL (//HOST:PORT/DBNAME) = " + DATABASE_URL);
        return DATABASE_URL;
    }

    public static String getDATABASE_USER() {
        logPropGetter("DATABASE_USER = " + DATABASE_USER);
        return DATABASE_USER;
    }

    public static String getDATABASE_PASSWORD() {
        logPropGetter("DATABASE_PASSWORD = " + DATABASE_PASSWORD);
        return DATABASE_PASSWORD;
    }
    
    
    
    protected static String getProperty(String key){
        try {
            ConfigurationUtil config = new ConfigurationUtil("/config.properties");
             final String property = config.readConfig(key);
             return property;
        }
        catch (Exception e) {
            log.fatal(e);
            return null;
        }  
    }
    
    
    
    private static void logPropGetter(String property){
        if (debug) {log.info("\"getProperty\" => (" + property + ") from src/main/resources/config.properties");}
    }
}