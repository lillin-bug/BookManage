package com.neuedu.service.impl;

import com.neuedu.main.Welcome;
import com.neuedu.pojo.Book;
import com.neuedu.pojo.BookBorrowBack;
import com.neuedu.service.BookBorrowBackService;
import com.neuedu.service.BookService;

import java.util.List;
import java.util.Scanner;

/**
 * 图书借阅界面
 */
public class BookBorrowBackMange {

    public static void check(List<BookBorrowBack> bbbList,List<BookBorrowBack> backList, List<Book> bookList){
        //创建对象，调用方法
        BookService bookService = new BookServiceImpl();
        BookBorrowBackService bookBorrowBackService = new BookBorrowBackServiceImpl();

        //定义全局输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t1.借阅图书");
        System.out.println("\t2.归还图书");
        System.out.println("\t3.借阅记录");
        System.out.println("\t4.返回欢迎界面");
        System.out.println("请输入要操作的序号");
        String info = scanner.next();

        //对输入的序号进行判断
        switch(info){
            case"1":{
                System.out.println("****您正在图书借阅界面****");
                bookService.checkBook(bookList);
                bookBorrowBackService.borrow(bbbList,backList,bookList);
            }break;
            case "2":{
                System.out.println("***您正在图书归还界面***");
                bookBorrowBackService.back(bbbList,backList,bookList);
            }break;
            case "3":{
                System.out.println("***您正在图书借阅记录界面***");
                bookBorrowBackService.record(bbbList,backList);
            }break;
            case "4":{
                Welcome.welcome();
            }break;
            default:{
                System.out.println("您输入的序号不存在，请重新输入");
            }
        }
    }
}
