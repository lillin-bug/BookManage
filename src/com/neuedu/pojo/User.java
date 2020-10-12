package com.neuedu.pojo;

import java.util.Date;

public class User {
    public static int index = 0;
    private int id;
    private String name;
    private String password;
    //角色：0  管理员  1  普通会员
    private char role;
    private String crateTime;
    private Date loginTime;

    public User() {
    }
    public User(int id, String name, String password, char role, String crateTime, Date loginTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.crateTime = crateTime;
        this.loginTime = loginTime;
    }

    public User(String name, String password) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "User:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", crateTime=" + crateTime +
                ", loginTime=" + loginTime ;
    }
}
