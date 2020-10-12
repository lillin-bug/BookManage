package com.neuedu.main;

import com.neuedu.pojo.Book;
import com.neuedu.pojo.BookBorrowBack;
import com.neuedu.pojo.User;
import com.neuedu.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //定义全局的集合
    static List<User> userList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();
    static List<BookBorrowBack> bbbList = new ArrayList<>();
    static List<BookBorrowBack> backList = new ArrayList<>();
    private static Book book;

    //-初始化管理员信息
    static{
        new UserServiceImpl().admin(userList);
    }
    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        boolean flag = true;
        while(flag){
            //欢迎界面
            Welcome.welcome();
            welcome.checkNum(userList,bookList,bbbList,backList,book);
            //-提示信息：继续(true)或退出(false)
            flag = welcome.goon();
        }
        System.out.println("欢迎下次使用");


    }
}
