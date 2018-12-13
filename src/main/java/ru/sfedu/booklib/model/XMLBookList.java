/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
/**
 *
 * @author Sergey
 */
public class XMLBookList {
    
    @ElementList
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
    
}
