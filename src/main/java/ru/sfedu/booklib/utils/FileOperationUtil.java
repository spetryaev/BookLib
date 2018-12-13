/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import org.apache.log4j.Logger;

/**
 *
 * @author Sergey
 */
public class FileOperationUtil {
    
    private static final Logger log = Logger.getLogger(FileOperationUtil.class);
    
    private static boolean checkFile(String fileType, final String FILE_PATH) {
        
        final File file = new File(FILE_PATH);
        
        if (file.exists()) {
            log.info("\"checkFile\" => "+ fileType +" file EXISTS by path: " + FILE_PATH);
            return true;
        } 
        else {
            log.info("\"checkFile\" => "+ fileType +" file DOES NOT EXIST by path");
            return false;
        }
    }
    
    
    public boolean checkAndCreateDataFile(String fileType, String FILE_PATH) {
        
        try {
            
            boolean fileCheckStatus = checkFile(fileType, FILE_PATH);
            
            if (fileCheckStatus == false) {
                Writer writer = new FileWriter(new File(FILE_PATH));
                log.info("\"checkAndCreateDataFile\" => "+ fileType +" file CREATED successfully");
                }
            else {
                log.info("\"checkAndCreateDataFile\" => Existing "+ fileType +" file have chosen by path: " + FILE_PATH);
                return false;
                }
            return true;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
           
    }

}
