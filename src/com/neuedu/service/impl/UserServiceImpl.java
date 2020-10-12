package com.neuedu.service.impl;

import com.neuedu.main.Welcome;
import com.neuedu.pojo.Book;
import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import com.neuedu.tools.CustomSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserServiceImpl implements UserService {
    //创建对象，调用方法
    UserMange userMange = new UserMange();
    //定义全局输入
    Scanner scanner = new Scanner(System.in);
    String name;
    String password;
    String repassword;

    public static boolean isAdmin ;

    /**
     *定义管理员信息
     */
    @Override
    public boolean admin(List<User> userList) {
        User user = new User();
        user.setId(0);
        user.setName("admin");
        user.setPassword("123456");
        user.setRole('0');
        //获取时间
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String date = format.format(new Date());
        user.setCrateTime(date);
        //存储到集合中
        userList.add(user);
        return false;
    }


    /**
     *注册功能
     */
    @Override
    public boolean register(List<User> userList) {


        System.out.println("请输入用户名");
        name = scanner.next();

        //判断用户名是否相等
        for(User user:userList){
            if(user.getName().equals(name)){
                System.out.println("此用户名已被注册，请重新输入！！！");
                register(userList);
            }
        }

        System.out.println("请输入密码");
        password = scanner.next();
        System.out.println("请再次输入密码");
        repassword = scanner.next();

        //判断两次密码是否相等
        if(password.equals(repassword)){
            boolean flag = false ;

            System.out.println("注册成功");

            //将数据存储到集合中
            if(!flag){
                User user = new User(name,password);
                user.setId(++User.index);
                user.setName(name);
                user.setPassword(password);
                user.setRole('1');
                //获取时间
                DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                String date = format.format(new Date());
                user.setCrateTime(date);
                user.setLoginTime(null);
                userList.add(user);
                System.out.println(userList);
            }

        }else{
            System.out.println("您输入的密码不匹配，请重新输入！！！");
            register(userList);
        }
        //询问是否继续注册
        System.out.println("是否继续注册？y:是  n:否");
        String info = scanner.next();
        if(info.equals("y")){
            register(userList);
        }else{
            //返回用户管理界面
            userMange.check(userList);
        }

        return false;
    }

    /**
     *登录功能
     */
    @Override
    public  boolean login(List<User> userList) {

            System.out.println("请输入用户名");
            String name = scanner.next();
            System.out.println("请输入密码");
            String password = scanner.next();
            //遍历集合中的数据
            for(User user1:userList){
                //对输入的用户名和密码进行判断
                if(user1.getName().equals(name)&&user1.getPassword().equals(password)){
                    System.out.println("登录成功");

                        //登录成功将登录的用户信息存储到容器中
                        HashMap<String,User> map = CustomSession.getHashMap();
                        map.put("user",user1);
                        //返回用户管理界面
                        userMange.check(userList);
                }else
                    //用户名不正确，密码正确
                    if(!user1.getName().equals(name)&&user1.getPassword().equals(password)){
                        System.out.println("用户名不正确，请重新输入！！！");
                        login(userList);

                    }else
                    //用户名正确，密码不正确
                    if(user1.getName().equals(name)&&!user1.getPassword().equals(password)){
                        System.out.println("密码不正确，请重新输入！！！");
                        login(userList);
                    }
            }
        return false;
    }


    /**
     * 查看功能
     */
    @Override
    public boolean check(List<User> userList) {

            //遍历集合中的数据
            Iterator<User> iterator = userList.iterator();
            while(iterator.hasNext()){
                Object object = iterator.next();
                System.out.println(object);
            }
            //返回用户管理界面
            userMange.check(userList);

        return false;
    }

    /**
     *管理功能
     */
    @Override
    public boolean manage(List<User> userList) {

            System.out.println("请选择您要进行的操作");
            System.out.println("1、修改信息");
            System.out.println("2、删除信息");
            String info = scanner.next();
            switch(info){
                case"1":{
                    //输出信息
                    Iterator<User> iterator = userList.iterator();
                    while(iterator.hasNext()){
                        Object object = iterator.next();
                        System.out.println(object);
                    }

                    boolean flag = true;
                    System.out.println("请输入要更改的用户名");
                    String name = scanner.next();
                    System.out.println("请输入密码");
                    String password = scanner.next();
                    if("admin".equals(name)){
                        System.out.println("管理员不可更改,请重新输入！！！");
                        flag = false;
                        manage(userList);

                    }
                    if (flag){
                        for(User user:userList){
                            if(user.getName().equals(name)&&user.getPassword().equals(password)){
                                System.out.println("请输入新的用户名");
                                String newname = scanner.next();
                                System.out.println("请输入新的密码");
                                String newpassword = scanner.next();
                                user.setName(newname);
                                user.setPassword(newpassword);
                                System.out.println("修改成功！！！");
                                System.out.println(userList);
//                                userMange.check(userList);
//                                Welcome.welcome();
                                break;
                            }
                        }
                    }else {
                        System.out.println("删除失败,请核查信息是否正确！！！");
                        manage(userList);
                    }
                }break;

                case "2":{
                    //输出信息
                    Iterator<User> iterator = userList.iterator();
                    while(iterator.hasNext()){
                        Object object = iterator.next();
                        System.out.println(object);
                    }

                    boolean flag = true;
                    System.out.println("请输入要删除的用户名");
                    String name = scanner.next();
                    System.out.println("请输入密码");
                    String password = scanner.next();
                    if("admin".equals(name)){
                        System.out.println("管理员不可删除,请重新输入！！！");
                        flag = false;
                        manage(userList);

                    }
                    if (flag){
                        boolean flag1 = true;
                        for(int i = 0;i<userList.size();i++){
                            if(userList.get(i).getName().equals(name)&&userList.get(i).getPassword().equals(password)){
                                flag1 = true;
                                userList.remove(i);

                            }else
                                {
                                flag1 = false;

                            }
                        }
                        if(flag1) {

                            System.out.println("删除成功！！！");
                            userMange.check(userList);
                            break;

                        }
                    }


                }break;
                default:{
                    System.out.println("您输入的信息不正确，请重新输入！！！");
                    manage(userList);
                }
            }
        return false;
    }


}
