package com.pro.service;

import com.pro.model.User;

public interface UserService {
    User queryUserByUserNameAndPassword(String username, String password);

    void addUser(User user);
}
