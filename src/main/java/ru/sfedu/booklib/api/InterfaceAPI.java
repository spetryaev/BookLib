package ru.sfedu.booklib.api;

import java.util.List;
import ru.sfedu.booklib.model.Book;


public interface InterfaceAPI {
   
   
   boolean addBook (Book bookObject);
   
   List<Book> getBookList ();   
   Book getBookById (int bookID);
   
   boolean printBookList ();
   
   boolean update (Book bookObject);
   
   boolean delete (int bookID);
   
   
}
