package com.pro.dao;

import com.pro.model.User;

public interface UserDao {
    //根据用户名和密码查询用户
    User queryByUserNameAndPassword(String username, String password);

    void add(User user);
}
