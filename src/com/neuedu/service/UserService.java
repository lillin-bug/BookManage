package com.neuedu.service;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserService {
    public boolean register(List<User> list);
    public  boolean login(List<User> list);
    public boolean check(List<User> list);
    public boolean manage(List<User> list);
    public boolean admin(List<User> list);

}
