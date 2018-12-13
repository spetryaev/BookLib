/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.utils;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergey
 */
public class FileOperationUtilTest {
    
    private static final Logger log = Logger.getLogger(FileOperationUtilTest.class);
    public FileOperationUtilTest() {
    }
    
   
    @BeforeClass
    public static void setUpClass() {
    log.debug("------------------------File Operation Util TEST LOG-------------------------");
    }
    
    @AfterClass
    public static void tearDownClass() {
    log.debug("----------------------------------------------------------------");
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() {
    
    }

    /**
     * Test of checkAndCreateDataFile method, of class FileOperationUtil.
     */
    @Test
    public void testCheckAndCreateDataFile() {
        System.out.println("checkAndCreateDataFile");
        String fileType = "test txt";
        String FILE_PATH = "src\\test\\java\\testOutputFiles\\testFile.txt";
        FileOperationUtil instance = new FileOperationUtil();
        boolean expResult = false; //false if file exists
        boolean result = instance.checkAndCreateDataFile(fileType, FILE_PATH);
        assertEquals(expResult, result);
        
    }
    
    
}
