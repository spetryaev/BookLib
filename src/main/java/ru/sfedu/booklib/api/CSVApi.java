/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import ru.sfedu.booklib.model.Book;
import ru.sfedu.booklib.Constants;
import ru.sfedu.booklib.utils.FileOperationUtil;
/**
 *
 * @author Sergey
 */
public class CSVApi implements InterfaceAPI {
    
    Constants c = new Constants();
    private final String CSV_FILE_PATH = c.getCSV_FILE_PATH();
    
        
    private final static Logger log = Logger.getLogger(CSVApi.class);
    
    
    public boolean createDataFile() {
        FileOperationUtil csvFileOperation = new FileOperationUtil();
        try {
            boolean csvFileStatus = csvFileOperation.checkAndCreateDataFile("CSV", CSV_FILE_PATH);
            return csvFileStatus;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
           
    }

    @Override
    public boolean addBook(Book bookObject) {
        try{
            List<Book> bookList = getBookList();
            
            boolean idIsNotExist = true;
            boolean isListChanged = false;
            for(Book tempBook : bookList){
                if(tempBook.bookID == bookObject.bookID){
                    idIsNotExist = false;
                }
            }
            
            if (idIsNotExist == true){
                bookList.add(bookObject);
                log.info("\"addBook\" => Book with (bookID = " + bookObject.bookID +") added to book list");
                isListChanged = true;
            }
            else {
                log.error("\"addBook\" => Add error. Book with (bookID = "+ bookObject.bookID + ") exists already.");
                return false;
            }
            
            if (isListChanged){
                writeData(bookList);
                log.info("\"addData\" => ADD data successfully.");
                return true;
            }
            else {
                return false;
            }
            
        }
        catch(Exception e){
            log.error(e);
            return false;
        }
    }
    
    
    @Override
    public Book getBookById(int bookID) {
       List<Book> bookList = getBookList();
       
       if (bookList.size() >= 1) {
           
            for(Book bookObject : bookList){
                
                if(bookObject.bookID == bookID){
                    printBook(bookObject);
                    return bookObject;
                }
            }
       }
        return null;
    }

    
      @Override
    public List<Book> getBookList() {
        try (Reader reader = new FileReader( new File(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader)) {
            List<Book> bookList = new ArrayList<>();
            String[] nextBook;
            
            while ((nextBook = csvReader.readNext()) != null){  //collecting book objects from csv by parsing strings
                bookList.add(
                        new Book(
                        Integer.parseInt(nextBook[0]),
                        nextBook[1],
                        nextBook[2],
                        nextBook[3],
                        nextBook[4],
                        nextBook[5],
                        nextBook[6]));
            } 
            if (bookList.size() > 0) {
                log.info("\"getBookList\" => Book list RECIEVED successfully.");
                return bookList;
            }
            
        }
        catch(Exception e){
            log.error(e);
            return null;
        }
        log.info("\"getBookList\" => Book list CREATED successfully.");
        return new ArrayList<>();
    }
    
    
    
    @Override
    public boolean update(Book newBook) {
        List<Book> bookList = getBookList();
        boolean isListChanged = false;
        
        if (bookList.size() <= 0) {
            log.error("\"update\" => Update error. Book list have no elements to update");
            return false;
        }
        
        for (Book oldBook: bookList){
            if (oldBook.bookID == newBook.bookID){
                oldBook.bookName = newBook.bookName;
                oldBook.bookAuthor = newBook.bookAuthor;
                oldBook.bookGenre = newBook.bookGenre;
                oldBook.bookPublisher =newBook.bookPublisher;
                oldBook.bookYear = newBook.bookYear;
                oldBook.pageQuantity = newBook.pageQuantity;
                isListChanged = true;
                log.info("\"update\" => Book list was updated. Updated element with (bookID = " + oldBook.bookID + ").");
            }
        }
        
        if (isListChanged){
           writeData(bookList);
           log.info("\"update\" UPDATE data successfully");
           return true;
        }
        else{
            log.error("\"update\" => There is no element with (bookId =" + newBook.bookID + ").");
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
           writeData(bookList);
           log.info("\"delete\" => DELETE data successfully.");
           return true;
       }
       else {
               log.error("\"delete\" => Delete error. There is no element with (bookID = "+ bookID + ").");
           }
       
       return false;
    }
   
    
    private void writeData(List<Book> bookList) {
      try {
          Writer writer = new FileWriter(CSV_FILE_PATH);
          CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
          
          List<String[]> stringList = new ArrayList<>();
          for (Book bookObject : bookList){
              stringList.add(new String[]{
                  String.valueOf(bookObject.bookID),
                  bookObject.bookName,
                  bookObject.bookAuthor, 
                  bookObject.bookGenre,
                  bookObject.bookYear,
                  bookObject.bookPublisher,
                  bookObject.pageQuantity
              });
          }
          
          csvWriter.writeAll(stringList);
          log.info("\"writeData\" => WRITE data successful.");
          csvWriter.close();
         }
      catch (IOException e) {
          log.error(e);
      }
    }
    
    
    
    @Override
    public boolean printBookList (){
        
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
