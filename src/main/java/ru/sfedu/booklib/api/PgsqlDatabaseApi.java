/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import ru.sfedu.booklib.Constants;
import ru.sfedu.booklib.model.Book;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
public class PgsqlDatabaseApi implements InterfaceAPI{

    
    private static final Constants c = new Constants();
    private static final String DATABASE_URL = c.getDATABASE_URL();
    private static final String DATABASE_USER = c.getDATABASE_USER();
    private static final String DATABASE_PASSWORD = c.getDATABASE_PASSWORD();
    
        
    private final static Logger log = Logger.getLogger(PgsqlDatabaseApi.class);
    private static final boolean debug = true;
    private static Connection conn;
    private static Statement statement;
    private static ResultSet queryResult;
    private static boolean connStatus = connectToDatabase();
    
    
    private static boolean connectToDatabase(){
        log.info("\"connectToDatabase\" => Try to get connection");
        try {            
            Class.forName("org.postgresql.Driver");
            PgsqlDatabaseApi.conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            conn.setAutoCommit(false);
             PgsqlDatabaseApi.connStatus = conn.isValid(0);
            
            if (connStatus) {
                log.info("\"connectToDatabase\" => CONNECTED to " + DATABASE_URL + ".");
                PgsqlDatabaseApi.statement = conn.createStatement();
                if (debug) {log.info("\"connectToDatabase\" => Statement created");
                            log.info("\"connectToDatabase\" => Query result set variable created. Ready to execute.");}
                return true;
            }
            else {
                log.fatal("Connection error");
                return false;
            }
            
        }
        catch (Exception e){
            log.fatal("\"connectToDatabase\" => Connection failed." + e);
                return false;
        }
        
    }
    
    
    @Override
    public boolean addBook (Book bookObject) {
        boolean status = false;
        if (connStatus){
            try {
            String query = "insert into books (bookId, bookName, bookAuthor, bookGenre, bookYear, bookPublisher, pageQuantity) values ";
            query += "(" + bookObject.bookID + ", '"+ 
                           bookObject.bookName + "', '" + 
                           bookObject.bookAuthor + "', '" + 
                           bookObject.bookGenre + "', '" + 
                           bookObject.bookYear + "', '" + 
                           bookObject.bookPublisher + "', '" + 
                           bookObject.pageQuantity + "')";
            
            int result = statement.executeUpdate(query);
            if (result>0) {
                status = true;
                log.info("\"addBook\" => ADD data success.");
                commitConnection();
                return status;
            }
            return status;
            }
            
            catch (SQLException e){
                log.error(e);
                return status;
            }
        }
        return connStatus;
    }

    
    @Override
    public List<Book> getBookList() {
        
        if (connStatus) {
            
            try{
            String query = "select * from books";
            queryResult = statement.executeQuery(query);
            List<Book> bookList = new ArrayList<>();
            while (queryResult.next()){
                bookList.add(
                        new Book(
                        queryResult.getInt(1),
                        queryResult.getString(2),
                        queryResult.getString(3),
                        queryResult.getString(4),
                        queryResult.getString(5),
                        queryResult.getString(6),
                        queryResult.getString(7)));
            } 
            
            if (bookList.size() > 0) {
                log.info("\"getBookList\" => Book list RECIEVED successfully.");
                return bookList;
            }
            return null;
           
            }
        
            catch (SQLException e){
            log.error(e);
            return null;
            }
        
        }
        return null;
    }

    
    @Override
    public Book getBookById(int bookID) {
        try {
            String query = "select * from books where bookId = " + bookID;
            queryResult = statement.executeQuery(query);
            queryResult.next();
            Book bookObject = new Book(
                        queryResult.getInt(1),
                        queryResult.getString(2),
                        queryResult.getString(3),
                        queryResult.getString(4),
                        queryResult.getString(5),
                        queryResult.getString(6),
                        queryResult.getString(7));
            
            printBook(bookObject);
            return bookObject;
        }
        catch (SQLException e){
            log.error(e);
            return null;
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

    
    @Override
    public boolean update(Book bookObject) {
        boolean status = false;
        
        if (connStatus){
            try {
            
                String query = "update books set ";
                query += "bookName = '" + bookObject.bookName + "', " + 
                        "bookAuthor = '" + bookObject.bookAuthor + "', " + 
                        "bookGenre = '" + bookObject.bookGenre + "', " + 
                        "bookYear = '" + bookObject.bookYear + "', " + 
                        "bookPublisher = '" + bookObject.bookPublisher + "', " + 
                        "pageQuantity = '" + bookObject.pageQuantity + "'";
                query +=" where bookId = " + bookObject.bookID;
            
                int result = statement.executeUpdate(query);
                if (result>0){
                    status = true;
                    commitConnection();
                    log.info("\"update\" => UPDATE data success.");
                    return status;
                }
           
                return status;
            }
            catch(SQLException e){
                log.error(e);
                return status;
            }
        }
        return connStatus;
    }

    
    @Override
    public boolean delete(int bookID) {
        boolean status = false;
        
        if(connStatus){
            try {
                String query = "delete from books where bookId = " + bookID;
                int result = statement.executeUpdate(query);
                if (result>0) {
                    status = true;
                    log.info("\"delete\" => DELETE data success.");
                    commitConnection();
                return status;
                }
                else {log.error("\"delete\" => Delete error.");}
            return status;
        }
            catch (SQLException e){
                log.error(e);
                return status;
            }
        }
        return connStatus;
      
    }
    
    
    public boolean printBook (Book bookObject){
        try {
            log.info("\"printBook\" => "+ String.valueOf(bookObject.bookID) +" | "+
                  bookObject.bookName +" | "+
                  bookObject.bookAuthor +" | "+
                  bookObject.bookGenre +" | "+
                  bookObject.bookYear +" | "+
                  bookObject.bookPublisher +" | "+
                  bookObject.pageQuantity);
            return true;
        }
        catch (Exception e){
            log.error(e);
            return false;
        }
    }
    
    
    protected static void commitConnection (){
        try {
            if (connStatus){
                conn.commit();
                log.info("\"commitConnection\" => COMMIT");
            }
        }
        catch (SQLException e){
            log.error("e");
        }
    }
    
    
    protected static void rollbackConnection (){
        try {
            if (connStatus){
                conn.rollback();
                log.info("\"rollbackConnection\" => ROLLBACK");
            }
        }
        catch (SQLException e){
            log.error("e");
        }
    }
    
    
    protected static void closeConnection (){
        try {
            if (connStatus){
                conn.close();
                log.info("\"closeConnection\" => CONNECTION CLOSED");
            }
        }
        catch (SQLException e){
            log.error("e");
        }
    }
    
}
