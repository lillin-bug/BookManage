package com.neuedu.tools;

import com.neuedu.pojo.User;

import java.util.HashMap;

/**
 * 模拟Javaweb的会话机制
 */
public class CustomSession {
    public static HashMap<String, User> map;
    private CustomSession(){}

    //整个应用中只有一个session存储机制
    public static HashMap<String,User> getHashMap(){
        if(map == null){
            map = new HashMap<>();
        }
        return  map;
    }
}
