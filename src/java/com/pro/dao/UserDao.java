package com.pro.dao;

import com.pro.model.User;

import java.util.List;

public interface UserDao {
    //根据用户名和密码查询用户
    User queryByUserNameAndPassword(String username, String password);

    void add(User user);

    List<User> queryAll();

    void deleteById(int user_id);

    void alterUserById(int user_id, String name, String age, String sex, String hobby, String login_name, String password);
}
