/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.api;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.booklib.model.Book;
import org.apache.log4j.Logger;

/**
 *
 * @author Sergey
 */
public class CSVApiTest {
    
    private static final Logger log = Logger.getLogger(CSVApiTest.class);
    
    public CSVApiTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    log.debug("------------------------CSV API TEST LOG-------------------------");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        log.debug("----------------------------------------------------------------");
    }

    /**
     * Test of createDataFile method, of class CSVApi.
     */
    @Before
    public void testCreateDataFile() {
       
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"createDataFile\" =>");
        CSVApi instance = new CSVApi();
        boolean result = instance.createDataFile();
        
        log.debug("----------------------------------------------------------------");
    }

    /**
     * Test of addBook method, of class CSVApi.
     */
    @Test
    public void testAddBook() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testAddBook\" =>");
        Book bookObject = new Book(23,"The Witr","Sapkovsky", "Fantasy", "1985","Poland","304");
        CSVApi instance = new CSVApi();
        boolean expResult = true;
        boolean result = instance.addBook(bookObject);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBookById method, of class CSVApi.
     */
    @Test
    public void testGetBookById() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testGetBookById\" =>");
        int bookID = 1;
        CSVApi instance = new CSVApi();
        Book expResult = instance.getBookById(bookID);
        Book result = expResult;
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getBookList method, of class CSVApi.
     */
    @Test
    public void testGetBookList() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testGetBookList\" =>");
        CSVApi instance = new CSVApi();
        List<Book> expResult = instance.getBookList();
        List<Book> result = expResult;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of update method, of class CSVApi.
     */
    @Test
    public void testUpdate() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testUpdate\" =>");
        Book newBook = new Book(1,"TESTS","Sapkovsky", "Fantasy", "1985","Poland","304");
        CSVApi instance = new CSVApi();
        
        boolean expResult = false;
        boolean result = instance.update(newBook);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class CSVApi.
     */
    @Test
    public void testDelete() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testDelete\" =>");
        int bookID = 23;
        CSVApi instance = new CSVApi();
        boolean expResult = true;
        boolean result = instance.delete(bookID);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of printBookList method, of class CSVApi.
     */
    @Test
    public void testPrintBookList() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testPrintBookList\" =>");
        CSVApi instance = new CSVApi();
        boolean expResult = true;
        boolean result = instance.printBookList();
        assertEquals(expResult, result);
    }

    /**
     * Test of printBook method, of class CSVApi.
     */
    @Test
    public void testPrintBook() {
        log.debug("\t @TEST@ \t \"CSVApiTest\" => \"testPrintBook\" =>");
        Book bookObject = new Book(1,"PRINT TEST","Sapkovsky", "Fantasy", "1985","Poland","304");
        CSVApi instance = new CSVApi();
        boolean expResult = true;
        boolean result = instance.printBook(bookObject);
        assertEquals(expResult, result);
    }
    
}
