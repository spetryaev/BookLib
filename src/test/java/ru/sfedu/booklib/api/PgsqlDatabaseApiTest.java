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
public class PgsqlDatabaseApiTest extends PgsqlDatabaseApi{
    
    public PgsqlDatabaseApiTest() {
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
     * Test of connectToDatabase method, of class PgsqlDatabaseApi.
     */
    @Before
    public void testConnectToDatabase() throws Exception {
        System.out.println("connectToDatabase");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = true;
        boolean result = instance.connectToDatabase();
        assertEquals(expResult, result);
    }
    
    @After
    public void testCloseConnection() {
    System.out.println("closeConnection");
    PgsqlDatabaseApi.closeConnection();
    }

    /**
     * Test of addBook method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book bookObject = new Book(47,"The Witr","Test", "Fantasy", "1985","Poland","304");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = instance.addBook(bookObject);
        boolean result = true;
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getBookList method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testGetBookList() {
        System.out.println("getBookList");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        List<Book> expResult = instance.getBookList();
        List<Book> result = expResult;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBookById method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testGetBookById() {
        System.out.println("getBookById");
        int bookID = 7;
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        Book expResult = null;
        Book result = instance.getBookById(bookID);
        assertEquals(expResult, result);
    }

    /**
     * Test of printBookList method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testPrintBookList() {
        System.out.println("printBookList");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = true;
        boolean result = instance.printBookList();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Book bookObject = new Book(12,"update test 5","Test", "TTTTEEEST", "1985","Poland","304");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = true;
        boolean result = instance.update(bookObject);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int bookID = 47;
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = true;
        boolean result = instance.delete(bookID);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of printBook method, of class PgsqlDatabaseApi.
     */
    @Test
    public void testPrintBook() {
        System.out.println("printBook");
        Book bookObject = new Book(47,"TESTPRINT","Test", "Fantasy", "1488","Poland","304");
        PgsqlDatabaseApi instance = new PgsqlDatabaseApi();
        boolean expResult = true;
        boolean result = instance.printBook(bookObject);
        assertEquals(expResult, result);
    }
    
}
