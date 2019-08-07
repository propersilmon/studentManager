package com.pro.service;

import com.pro.dao.UserDao;
import com.pro.dao.UserDaoImpl;
import com.pro.model.User;

public class UserServiceImpl implements UserService {

//    注入Dao
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        User user = userDao.queryByUserNameAndPassword(username, password);
        return user;
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }
}
