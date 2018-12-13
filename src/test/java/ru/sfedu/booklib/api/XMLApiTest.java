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

/**
 *
 * @author Sergey
 */
public class XMLApiTest {
    
    public XMLApiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createDataFile method, of class XMLApi.
     */
    @Before
    public void testCreateDataFile() {
        System.out.println("createDataFile");
        XMLApi instance = new XMLApi();
        instance.createDataFile();
        
    }

    /**
     * Test of addBook method, of class XMLApi.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
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
        System.out.println("getBookList");
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
        System.out.println("getBookById");
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
        System.out.println("update");
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
        System.out.println("delete");
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
        System.out.println("printBookList");
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
        System.out.println("printBook");
        Book bookObject = new Book(23,"Test xml","Sapkovsky", "Fantasy", "1985","Poland","304");
        XMLApi instance = new XMLApi();
        boolean expResult = true;
        boolean result = instance.printBook(bookObject);
        assertEquals(expResult, result);
        
    }
    
}
