package com.neuedu.service.impl;

import com.neuedu.main.Welcome;
import com.neuedu.pojo.Book;
import com.neuedu.service.BookService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.neuedu.service.impl.UserServiceImpl.isAdmin;

public class BookServiceImpl implements BookService {
    //创建对象，调用方法
    BookMange bookMange = new BookMange();
    //定义全局输入
    Scanner scanner = new Scanner(System.in);
    String name;
    int count;


    /**
     *添加功能
     */
    @Override
    public boolean addBook(List<Book> bookList) {

            System.out.println("请输入书名");
            name = scanner.next();
            System.out.println("请输入添加的数量");
            count = scanner.nextInt();
            //存储到集合中
            Book book = new Book();
            book.setId(++Book.index);
            book.setName(name);
            book.setBookCount(count);
            book.setCrateTime(new Date());
            bookList.add(book);
            System.out.println(bookList);

            //判断是否继续添加
            System.out.println("是否继续添加图书？y：是  n：否");
            String info = scanner.next();
            if(info.equals("y")){
                addBook(bookList);
            }else{
                bookMange.check(bookList);
            }
        return false;
    }



    /**
     *删除功能
     */
    @Override
    public boolean subBook(List<Book> bookList) {
        boolean flag = false;

            System.out.println("请输入下架的图书名称");
            String name = scanner.next();
            for(Book book:bookList){
                if(book.getName().equals(name)){
                    bookList.remove(book);
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("删除成功！！！");
            }else{
                System.out.println("删除失败,请核查书名是否正确！！！");
            }

        //判断是否继续删除
        System.out.println("是否继续删除图书？y：是  n：否");
        String info = scanner.next();
        if(info.equals("y")){
            subBook(bookList);
        }else{
            bookMange.check(bookList);
        }
        return flag;
    }
    /**
     *查看功能
     */
    @Override
    public boolean checkBook(List<Book> bookList) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("\t\t序号\t\t书名\t\t数量\t\t创建时间");
        for(int index = 0;index< bookList.size();index++){
            Book book = bookList.get(index);
            name = book.getName();
            count = book.getBookCount();
            String creatTime = format.format(book.getCrateTime());
            System.out.println("\t\t"+(index+1)+"\t\t"+name+"\t\t"+count+"\t\t"+creatTime);
        }
       return false;
    }


}
