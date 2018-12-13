/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib;

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
public class ConstantsTest {
    
    private static final Logger log = Logger.getLogger(ConstantsTest.class);
    public ConstantsTest() {
    }
    
   @BeforeClass
    public static void setUpClass() {
    log.debug("------------------------Constants TEST LOG-------------------------");
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
     * Test of getCSV_FILE_PATH method, of class Constants.
     */
    @Test
    public void testGetCSV_FILE_PATH() {
        System.out.println("getCSV_FILE_PATH");
        String expResult = "src\\test\\java\\testOutputFiles\\csv_test.csv";
        String result = Constants.getCSV_FILE_PATH();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getXML_FILE_PATH method, of class Constants.
     */
    @Test
    public void testGetXML_FILE_PATH() {
        System.out.println("getXML_FILE_PATH");
        String expResult = "src\\test\\java\\testOutputFiles\\xml_test.xml";
        String result = Constants.getXML_FILE_PATH();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDATABASE_URL method, of class Constants.
     */
    @Test
    public void testGetDATABASE_URL() {
        System.out.println("getDATABASE_URL");
        Constants instance = new Constants();
        String expResult = "jdbc:postgresql://127.0.0.1:5432/db";
        String result = instance.getDATABASE_URL();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDATABASE_USER method, of class Constants.
     */
    @Test
    public void testGetDATABASE_USER() {
        System.out.println("getDATABASE_USER");
        String expResult = "postgres";
        String result = Constants.getDATABASE_USER();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDATABASE_PASSWORD method, of class Constants.
     */
    @Test
    public void testGetDATABASE_PASSWORD() {
        System.out.println("getDATABASE_PASSWORD");
        String expResult = "somepass";
        String result = Constants.getDATABASE_PASSWORD();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getProperty method, of class Constants.
     */
    @Test
    public void testGetProperty() {
        System.out.println("getProperty");
        String key = "DATABASE_NAME";
        String expResult = "db";
        String result = Constants.getProperty(key);
        assertEquals(expResult, result);
        
    }
    
}
