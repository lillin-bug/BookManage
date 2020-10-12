package com.neuedu.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    public static int index = 0;
    private int id;
    private String name;
    private int bookCount;
    private Date crateTime;

    public Book() {
    }

    public Book(int id, String name, int bookCount, Date crateTime) {
        this.id = id;
        this.name = name;
        this.bookCount = bookCount;
        this.crateTime = crateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    @Override
    public String toString() {
        return "Book:" +
                "id=" + id +
                ",\tname=《" + name +"》,\t"+
                " bookCount=" + bookCount +",\t"+"crateTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) ;
    }
}
