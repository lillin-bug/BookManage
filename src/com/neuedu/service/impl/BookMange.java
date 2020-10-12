package com.neuedu.service.impl;

import com.neuedu.main.Welcome;
import com.neuedu.pojo.Book;
import com.neuedu.pojo.User;
import com.neuedu.service.BookService;
import com.neuedu.tools.CustomSession;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 图书管理界面
 */
public class BookMange {
    public void check(List<Book> bookList){

        //创建对象，调用方法
        BookService bookService = new BookServiceImpl();

        //定义全局输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t1.查看图书：");
        System.out.println("\t2.添加图书：");
        System.out.println("\t3.下架图书：");
        System.out.println("\t4.返回欢迎界面");

        System.out.println("请输入要操作的序号");
        String info = scanner.next();

        //对输入的序号进行判断
        switch(info){
            case"1":{
                System.out.println("****您正在图书查看界面****");
                bookService.checkBook(bookList);
            }break;
            case "2":{
                HashMap<String, User> hashMap = CustomSession.getHashMap();
                User user1 = hashMap.get("user");
                //判断是否登录
                if(user1 == null){
                    System.out.println("请先登录！！！");
                }else{
                    //判断登录的是否是管理员
                    if('0' == user1.getRole()){
                        System.out.println("***您正在图书添加界面***");
                        bookService.addBook(bookList);
                    }else{
                        System.out.println("您没有此权限！！！");
                    }
                }
            }break;
            case "3":{
                HashMap<String, User> hashMap = CustomSession.getHashMap();
                User user1 = hashMap.get("user");
                //判断是否登录
                if(user1 == null){
                    System.out.println("请先登录！！！");
                }else{
                    //判断登录的是否是管理员
                    if('0' == user1.getRole()){
                        System.out.println("***您正在图书下架界面***");
                        bookService.subBook(bookList);
                    }else{
                        System.out.println("您没有此权限！！！");
                    }
                }
            }break;
            case "4":{
                Welcome.welcome();
            }break;
            default:{
                System.out.println("您输入的序号不存在，请重新输入！！！");
            }
        }

    }
}
