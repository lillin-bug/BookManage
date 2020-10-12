package com.neuedu.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookBorrowBack {
   private int userId;
   private String userName;
   private int bookId;
   private String bookName;
   private int count;
   private Date time;
   public BookBorrowBack() {
    }

    public BookBorrowBack(int userId, String userName, int bookId, String bookName, int count, Date time) {
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.count = count;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", count=" + count +
                ", time=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
