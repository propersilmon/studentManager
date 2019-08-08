package com.pro.service;

import com.pro.dao.UserDao;
import com.pro.dao.UserDaoImpl;
import com.pro.model.User;

import java.util.List;

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

    @Override
    public List<User> showAllUser() {
        List<User> userList = userDao.queryAll();
        return userList;
    }

    @Override
    public void deleteUser(int user_id) {
        userDao.deleteById(user_id);
    }

    @Override
    public void alterUser(int user_id, String name, String age, String sex, String hobby, String login_name, String password) {
        userDao.alterUserById(user_id, name, age, sex, hobby, login_name, password);
    }
}
