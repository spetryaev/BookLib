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
public class XMLApiTest {
    
    private static final Logger log = Logger.getLogger(XMLApiTest.class);
    
    public XMLApiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    log.debug("------------------------XML API TEST LOG-------------------------");
    
    }
    
    @After
    public void tearDown(){
    log.debug("----------------------------------------------------------------");
    }
    

    /**
     * Test of createDataFile method, of class XMLApi.
     */
    @Before
    public void testCreateDataFile() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testCreateDataFile\" =>");
        XMLApi instance = new XMLApi();
        instance.createDataFile();
        log.debug("----------------------------------------------------------------");
        
    }

    /**
     * Test of addBook method, of class XMLApi.
     */
    @Test
    public void testAddBook() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testAddBook\" =>");
        Book bookObject = new Book(23,"The Witr","Sapkovsky", "Fantasy", "1985","Poland","304");
        XMLApi instance = new XMLApi();
        boolean expResult = true;
        boolean result = instance.addBook(bookObject);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBookList method, of class XMLApi.
     */
    @Test
    public void testGetBookList() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testGetBookList\" =>");
        XMLApi instance = new XMLApi();
        List<Book> expResult = instance.getBookList();
        List<Book> result = expResult;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBookById method, of class XMLApi.
     */
    @Test
    public void testGetBookById() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testGetBookById\" =>");
        int bookID = 16;
        XMLApi instance = new XMLApi();
        Book expResult = instance.getBookById(bookID);
        Book result = expResult;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of update method, of class XMLApi.
     */
    @Test
    public void testUpdate() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testUpdate\" =>");
        Book newBookObject = new Book(23,"Test xml","Sapkovsky", "Fantasy", "1985","Poland","304");
        XMLApi instance = new XMLApi();
        boolean expResult = true;
        boolean result = instance.update(newBookObject);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class XMLApi.
     */
    @Test
    public void testDelete() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testDelete\" =>");
        int bookID = 1;
        XMLApi instance = new XMLApi();
        boolean expResult = false;
        boolean result = instance.delete(bookID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printBookList method, of class XMLApi.
     */
    @Test
    public void testPrintBookList() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testPrintBookList\" =>");
        XMLApi instance = new XMLApi();
        boolean expResult = true;
        boolean result = instance.printBookList();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printBook method, of class XMLApi.
     */
    @Test
    public void testPrintBook() {
        log.debug("\t @TEST@ \t \"XMLApiTest\" => \"testPrintBook\" =>");
        Book bookObject = new Book(23,"Test xml","Sapkovsky", "Fantasy", "1985","Poland","304");
        XMLApi instance = new XMLApi();
        boolean expResult = true;
        boolean result = instance.printBook(bookObject);
        assertEquals(expResult, result);
        
    }
    
}
