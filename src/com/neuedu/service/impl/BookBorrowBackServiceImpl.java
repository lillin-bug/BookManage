package com.neuedu.service.impl;

import com.neuedu.pojo.Book;
import com.neuedu.pojo.BookBorrowBack;
import com.neuedu.pojo.User;
import com.neuedu.service.BookBorrowBackService;
import com.neuedu.tools.CustomSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookBorrowBackServiceImpl implements BookBorrowBackService {
    //创建对象,调用方法
    BookBorrowBackMange bookBorrowBackMange = new BookBorrowBackMange();
    //定义全局变量
    Scanner scanner = new Scanner(System.in);
    String bookname;
    int countBorrow;
    int countBack;


    /**
     *借阅功能
     */
    @Override
    public boolean borrow(List<BookBorrowBack> bbbList, List<BookBorrowBack> backList,List<Book> bookList) {

        System.out.println("请输入要借阅的书籍");
        bookname = scanner.next();
        System.out.println("请输入要借阅的数量");
        countBorrow = scanner.nextInt();

        boolean flag_name = false;
        boolean flag_count = true;

        for(Book book:bookList){
            //判断所借书籍是否存在
            if(book.getName().equals(bookname)){
                flag_name = true;
                //判断书籍数量是否满足要求
                if(book.getBookCount()<countBorrow){
                    flag_count = false;
                }else{
                    //若借阅成功，书籍数量减少
                    book.setBookCount(book.getBookCount()-countBorrow);
                    //将借阅的记录保存
                    borrowRecord(book,bbbList);
                }
            }
        }

        if(!flag_name){
            System.out.println("您借阅的书籍不存在，请重新借阅！！！");
            borrow(bbbList,backList, bookList);
        }else if(!flag_count){
            System.out.println("书籍数量不足，请重新借阅！！！");
            borrow(bbbList,backList, bookList);
        }else{
            System.out.println("书籍借阅成功,时间为："
                    +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //询问是否继续借阅
            System.out.println("是否继续借阅？y:是  n:否");
            String info = scanner.next();
            if(info.equals("y")){
                borrow(bbbList,backList,bookList);
            }else{
                //返回用户管理界面
                bookBorrowBackMange.check(bbbList,backList,bookList);
            }
        }
        return false;
    }


    /**
     *归还功能
     */

    @Override
    public boolean back(List<BookBorrowBack> bbbList, List<BookBorrowBack> backList,List<Book> bookList) {

        System.out.println("请输入要归还的图书");
        bookname = scanner.next();
        System.out.println("请输入要归还的数量");
        countBack = scanner.nextInt();
        BookBorrowBack bookBorrowBack = new BookBorrowBack();

        boolean flag_name = false;
        boolean flag_count = true;
        for(Book book:bookList){
            //判断所还书籍是否存在
            if(book.getName().equals(bookname)){
                flag_name = true;
                //判断书籍数量是否满足要求
                for(BookBorrowBack bbb:bbbList){
                    if(bbb.getCount()<countBack){
                        flag_count = false;
                    }else{
                        //若归还成功，书籍数量增加
                        book.setBookCount(book.getBookCount() +countBack);
                        //将归还的记录保存
                        backRecord(book,backList);
                    }
                }

            }
        }
        if(!flag_name){
            System.out.println("您未借阅此书，请重新输入！！！");
            back(bbbList,backList,bookList);
        }else if(!flag_count){
            System.out.println("归还数量超出借阅数量，请重新输入！！！");
            back(backList,backList,bookList);
        }else{
            System.out.println("书籍归还成功,时间为："
                    +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //询问是否继续归还
            System.out.println("是否继续归还？y:是  n:否");
            String info = scanner.next();
            if(info.equals("y")){
                back(bbbList,backList,bookList);
            }else{
                //返回用户管理界面
                bookBorrowBackMange.check(bbbList,backList,bookList);
            }
        }
        return false;
    }


    private void borrowRecord(Book book,List<BookBorrowBack> bbbList){
        HashMap<String, User> hashMap = CustomSession.getHashMap();
        User user = hashMap.get("user");
        BookBorrowBack borrow = new BookBorrowBack();
        borrow.setBookId(book.getId());
        borrow.setBookName(book.getName());
        borrow.setCount(countBorrow);
        borrow.setUserId(user.getId());
        borrow.setUserName(user.getName());
        borrow.setTime(new Date());
        //存储到集合中
        bbbList.add(borrow);
    }
    private void backRecord(Book book,List<BookBorrowBack> backList){

        HashMap<String, User> hashMap = CustomSession.getHashMap();
        User user = hashMap.get("user");
        BookBorrowBack back = new BookBorrowBack();
        back.setBookId(book.getId());
        back.setBookName(book.getName());
        back.setCount(countBack);
        back.setUserId(user.getId());
        back.setUserName(user.getName());
        back.setTime(new Date());
        //存储到集合中
        backList.add(back);
    }

    /**
     * 借阅记录功能
     */
    @Override
    public boolean record(List<BookBorrowBack> bbbList,List<BookBorrowBack> backList) {
        for(BookBorrowBack bookBorrow:bbbList){
            System.out.println("借阅:"+bookBorrow);
        }
        for(BookBorrowBack bookBack:backList){
            System.out.println("归还:"+bookBack);
        }
        return false;

    }




}
