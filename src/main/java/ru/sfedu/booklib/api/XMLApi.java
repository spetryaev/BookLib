/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.api;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import ru.sfedu.booklib.Constants;
import ru.sfedu.booklib.model.Book;
import org.apache.log4j.Logger;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.booklib.utils.FileOperationUtil;
import ru.sfedu.booklib.model.XMLBookList;

public class XMLApi implements InterfaceAPI {

    
    Constants c = new Constants();
    private final String XML_FILE_PATH = c.getXML_FILE_PATH();
    
    private static final Logger log = Logger.getLogger(XMLApi.class);
    private static boolean debug = true;
     
    
    public boolean createDataFile() {
         FileOperationUtil xmlFileOperation = new FileOperationUtil();
        try {
            boolean xmlFileStatus = xmlFileOperation.checkAndCreateDataFile("XML", XML_FILE_PATH);
            return xmlFileStatus;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    
    @Override
    public boolean addBook(Book bookObject) {
        boolean status = false;
        try{
            List<Book> bookList = getBookList();
            bookList.add(bookObject);
            log.info("\"addBook\" => "+ bookObject.toString());
            XMLBookList xmlBookList = new XMLBookList();
            xmlBookList.setBookList(bookList);
            status = writeData(xmlBookList);
            return status;
        }
        catch(Exception e){
            log.error(e);
            return status;
        }
    }

    @Override
    public List<Book> getBookList() {
        try {
            Serializer serializer = new Persister();
            
            XMLBookList xmlBookList = serializer.read(XMLBookList.class, new File(XML_FILE_PATH));
            log.info("got book list!");
            List<Book> bookList = xmlBookList.getBookList();
            if (bookList != null) {
                return bookList;
            }
            return new ArrayList<>();
        }
        catch (Exception e){
            log.error(e);
            return new ArrayList<>();
        }
        
    }

    @Override
    public Book getBookById(int bookID) {
        try {
            List<Book> bookList = getBookList();
            for (Book bookObject : bookList){
                if(bookObject.bookID == bookID){
                    log.info("\"getBookById\" => Got it!");
                    return bookObject;
                }
            }
            return null;
        }
        catch (Exception e){
            log.error(e);
            return null;
        }
    }


    @Override
    public boolean update(Book newBookObject) {
         boolean isListChanged = false;
         List<Book> bookList = getBookList();
         
         if (bookList.size() <= 0) {
           log.error("\"delete\" => Delete error. Book list has no elements to update");
           return false;
            }
         
        try {
            
            for (Book oldBookObject: bookList){
                if (oldBookObject.bookID == newBookObject.bookID) {
                    oldBookObject.bookName = newBookObject.bookName;
                    oldBookObject.bookAuthor = newBookObject.bookAuthor;
                    oldBookObject.bookGenre = newBookObject.bookGenre;
                    oldBookObject.bookPublisher =newBookObject.bookPublisher;
                    oldBookObject.bookYear = newBookObject.bookYear;
                    oldBookObject.pageQuantity = newBookObject.pageQuantity;
                    log.info("\"update\" => Object has been updated in the book list");
                    isListChanged = true;
                }
            }
            
            if (isListChanged) {
           XMLBookList xmlBookList = new XMLBookList();
           xmlBookList.setBookList(bookList);
           writeData(xmlBookList);
           log.info("\"update\" => UPDATE success.");
           return true;
       }
            else {
               log.error("\"update\" => Update error");
           }
            return false;
        }
        catch(Exception e){
            log.error(e);
            return false;
        }
    }

    @Override
    public boolean delete(int bookID) {
       List<Book> bookList = getBookList();
       
       boolean isListChanged = false;
      
       if (bookList.size() <= 0) {
           log.error("\"delete\" => Delete error. Book list has no elements to delete");
           return false;
       }
       
       for (int i = 0; i < bookList.size(); i++) {
           if (bookList.get(i).bookID == bookID) {
               bookList.remove(i);
               isListChanged = true;
               log.info("\"delete\" => Element with (bookID = "+ bookID + ") deleted from book list" );
           }
           
       }
       
       if (isListChanged) {
           XMLBookList xmlBookList = new XMLBookList();
            xmlBookList.setBookList(bookList);
           writeData(xmlBookList);
           log.info("\"delete\" => DELETE data successfully.");
           return true;
       }
       else {
               log.error("\"delete\" => Delete error. There is no element with (bookID = "+ bookID + ").");
           }
       
       return false;
    }
    
    
    private boolean writeData(XMLBookList xmlBookList){
        try {
            Serializer serializer = new Persister();
            Writer xmlWriter = new FileWriter(XML_FILE_PATH);
            serializer.write(xmlBookList, xmlWriter);
            log.info("\"writeData\" => WRITE data success.");
            return true;
        }
        catch (IOException e){
            log.error(e);
            return false;
        }
        catch(Exception e){
            log.error(e);
            return false;
        }
        
    }

    
    @Override
    public boolean printBookList() {
        
        List<Book> bookList = getBookList();
        
          if (bookList.size() >=1){
              log.info("\"printBookList\" => \"printBook\"");
              for (Book bookObject : bookList){
                  
                  printBook(bookObject);
             }
              return true;
          }
          
          return false;
    }
    
    
    public boolean printBook (Book bookObject){
        try {
            log.info("\"printBook\" => "+ String.valueOf(bookObject.bookID) +" "+
                  bookObject.bookName +" "+
                  bookObject.bookAuthor +" "+
                  bookObject.bookGenre +" "+
                  bookObject.bookYear +" "+
                  bookObject.bookPublisher +" "+
                  bookObject.pageQuantity);
            return true;
        }
        catch (Exception e){
        log.error(e);
        return false;
        }
    }
    
}
