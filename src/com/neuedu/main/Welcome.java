package com.neuedu.main;

import com.neuedu.pojo.Book;
import com.neuedu.pojo.BookBorrowBack;
import com.neuedu.pojo.User;

import com.neuedu.service.impl.*;
import com.neuedu.tools.CustomSession;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 欢迎界面
 */
public class Welcome {
    //创建对象，调用方法
    UserMange userMange = new UserMange();
    BookMange bookMange = new BookMange();
    BookBorrowBackMange bookBorrowBackMange = new BookBorrowBackMange();

    Scanner scanner = new Scanner(System.in);

    public static void welcome(){

        System.out.println(" ......................阿弥陀佛......................\n"+
                "                       _oo0oo_                      \n"+
                "                      o8888888o                     \n"+
                "                      88\" . \"88                     \n"+
                "                      (| -_- |)                     \n"+
                "                      0\\  =  /0                     \n"+
                "                   ___/‘---’\\___                   \n"+
                "                  .' \\|       |/ '.                 \n"+
                "                 / \\\\|||  :  |||// \\                \n"+
                "                / _||||| -卍-|||||_ \\               \n"+
                "               |   | \\\\\\  -  /// |   |              \n"+
                "               | \\_|  ''\\---/''  |_/ |              \n"+
                "               \\  .-\\__  '-'  ___/-. /              \n"+
                "             ___'. .'  /--.--\\  '. .'___            \n"+
                "         .\"\" ‘<  ‘.___\\_<|>_/___.’>’ \"\".          \n"+
                "       | | :  ‘- \\‘.;‘\\ _ /’;.’/ - ’ : | |        \n"+
                "         \\  \\ ‘_.   \\_ __\\ /__ _/   .-’ /  /        \n"+
                "    =====‘-.____‘.___ \\_____/___.-’___.-’=====     \n"+
                "                       ‘=---=’                      \n"+
                "                                                    \n"+
                "....................佛祖保佑,永无BUG...................\n"+
                "....................高斯林保佑,永无BUG.................");

        System.out.println("\t欢迎使用XXX图书借阅系统");
        System.out.println("\t1.用户管理模块：");
        System.out.println("\t2.图书管理模块：");
        System.out.println("\t3.图书借阅模块：");
        System.out.println("\t4.退出系统");
    }
    public void checkNum(List<User> list, List<Book> bookList, List<BookBorrowBack> bbbList,List<BookBorrowBack> backList,Book book){

        System.out.println("请输入您选择的编号：");
        String bh = scanner.next();
        switch (bh){
            case "1":{
                System.out.println("****您正在用户管理界面****");
                userMange.check(list);
            }break;
            case "2":{
                System.out.println("****您正在图书管理界面****");
                bookMange.check(bookList);
            }break;
            case "3":{
                HashMap<String, User> hashMap = CustomSession.getHashMap();
                User user1 = hashMap.get("user");
                //判断是否登录
                if(user1 == null){
                    System.out.println("请先登录！！！");
                }else{
                    bookBorrowBackMange.check(bbbList,backList,bookList);

                }
            }break;
            case"4":{
                System.out.println("您已退出系统！！！");
                System.exit(0);
            }break;
            default:{
                System.out.println("您输入的序号不存在，请重新输入！！！");
            }
        }
    }
    //-:退出：false  继续：true
    public boolean goon(){
        boolean flag = true;
        System.out.println("您继续其他操作(y)，还是退出(n)？");
        String str = scanner.next();
        switch (str){
            case "y":{
                flag = true;
            }break;
            case "n":{
                flag = false;
            }break;
            default:{
                System.out.println("您输入错误，请重新输入");
                goon();
            }
        }
        return flag;
    }
}