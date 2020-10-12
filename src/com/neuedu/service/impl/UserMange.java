package com.neuedu.service.impl;

import com.neuedu.main.Welcome;
import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import com.neuedu.tools.CustomSession;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 用户管理界面
 */
public class UserMange {

    public void check(List<User> list) {

        //创建对象，调用方法
        UserService userService = new UserServiceImpl();

        //定义全局输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t1.注册用户信息：");
        System.out.println("\t2.登录用户信息：");
        System.out.println("\t3.查看用户信息：");
        System.out.println("\t4.管理用户信息：");
        System.out.println("\t5.返回欢迎界面");

        System.out.println("请输入要操作的序号");
        String info = scanner.next();

        //对输入的序号进行判断
        switch (info) {
            case "1": {
                System.out.println("****您正在用户注册界面****");
                userService.register(list);

            }break;
            case "2":{
                System.out.println("****您正在用户登录界面****");
                userService.login(list);

            }break;
            case "3":{

                //判断是否登录
                HashMap<String, User> hashMap = CustomSession.getHashMap();
                User user1 = hashMap.get("user");
                if(user1 == null){
                    System.out.println("请先登录！！！");
                    check(list);
                }else{
                    System.out.println("****您正在用户查看界面****");
                    userService.check(list);
                }
            }break;

            case "4":{

                //判断是否登录
                HashMap<String, User> hashMap = CustomSession.getHashMap();
                User user1 = hashMap.get("user");
                if(user1 == null){
                    System.out.println("请先登录！！！");
                    check(list);
                }else{
                    System.out.println("****您正在用户管理界面****");
                    userService.manage(list);
                }
            }break;

            case "5":{
                Welcome.welcome();
            }break;
            default:{
                System.out.println("您输入的序号不存在，请重新输入！！！");
            }
        }
    }

}
