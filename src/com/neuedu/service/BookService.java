package com.neuedu.service;

import com.neuedu.pojo.Book;

import java.util.List;

public interface BookService {
    public boolean checkBook(List<Book> bookList);
    public boolean addBook(List<Book> bookList);
    public boolean subBook(List<Book> bookList);
}
