package com.neuedu.service;

import com.neuedu.pojo.Book;
import com.neuedu.pojo.BookBorrowBack;

import java.util.List;

public interface BookBorrowBackService {
    public boolean borrow(List<BookBorrowBack> bbbList, List<BookBorrowBack> backList,List<Book> bookList);
    public boolean back(List<BookBorrowBack> bbbList, List<BookBorrowBack> backList,List<Book> bookList);
    public boolean record(List<BookBorrowBack> bbbList,List<BookBorrowBack> backList);
}
