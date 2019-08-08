package com.pro.service;

import com.pro.model.User;

import java.util.List;

public interface UserService {
    User queryUserByUserNameAndPassword(String username, String password);

    void addUser(User user);

    List<User> showAllUser();

    void deleteUser(int user_id);

    void alterUser(int user_id, String name, String age, String sex, String hobby, String login_name, String password);
}
