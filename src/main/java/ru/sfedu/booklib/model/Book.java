/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.model;
import  org.simpleframework.xml.Element;

/**
 *
 * @author Sergey
 */
public class Book {
    
    @Element
    public int bookID;
    
    @Element
    public String bookName;
    
    @Element
    public String bookAuthor;
    
    @Element
    public String bookGenre;
    
    @Element
    public String bookYear;
    
    @Element
    public String bookPublisher;
    
    @Element
    public String pageQuantity;
   
    
    
    public Book() {}
    

    public Book(int bookID, String bookName, String bookAuthor, String bookGenre, String bookYear, String bookPublisher, String pageQuantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookYear = bookYear;
        this.bookPublisher = bookPublisher;
        this.pageQuantity = pageQuantity;
    }

   

   
    

 
    
}
