package com.pro.dao;

import com.pro.model.User;
import com.pro.util.utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryByUserNameAndPassword(String username, String password) {
        User user = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager", "root", "123456");
            String sqlStr = "select * from user where login_name=? and `password`=?;";
            PreparedStatement pres = con.prepareStatement(sqlStr);
            pres.setString(1, username);
            pres.setString(2, password);
            ResultSet rs = pres.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String sex = rs.getString("sex");
                String hobby = rs.getString("hobby");
                String login_name = rs.getString("login_name");
                String pwd = rs.getString("password");
                java.util.Date create_time = (java.sql.Date)rs.getDate("create_time");
                user = new User(name, age, sex, hobby, login_name, pwd, create_time);
            }

            con.close();
            pres.close();
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void add(User user) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "insert into `user` (name, age, sex, hobby, login_name, password, create_time) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sqlStr);

            pre.setString(1, user.getName());
            pre.setString(2, user.getAge());
            pre.setString(3, user.getSex());
            pre.setString(4, user.getHobby());
            pre.setString(5, user.getLogin_name());
            pre.setString(6, user.getPassword());
            pre.setDate(7, new Date(user.getCreate_time().getTime()));

            pre.executeUpdate();
            JdbcUtil.relase(con);
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> queryAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "select * from user;";
            PreparedStatement pres = con.prepareStatement(sqlStr);

            ResultSet rs = pres.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String sex = rs.getString("sex");
                String hobby = rs.getString("hobby");
                String login_name = rs.getString("login_name");
                String pwd = rs.getString("password");
                java.util.Date create_time = rs.getDate("create_time");
                User user = new User(user_id, name, age, sex, hobby, login_name, pwd, create_time);
                userList.add(user);
            }

            JdbcUtil.relase(con);
            pres.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void deleteById(int user_id) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "delete from user where user_id= ?";
            PreparedStatement pre = con.prepareStatement(sqlStr);
            pre.setInt(1, user_id);
            pre.executeUpdate();

            JdbcUtil.relase(con);
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterUserById(int user_id, String name, String age, String sex, String hobby, String login_name, String password) {
        Connection con = null;
        try {
            con = JdbcUtil.getConnection();
            String sqlStr = "update user set name = ?, age = ?, sex = ?, hobby = ?, login_name = ?, password = ? where user_id = ?";
            PreparedStatement pre = con.prepareStatement(sqlStr);
            pre.setString(1, name);
            pre.setString(2, age);
            pre.setString(3, sex);
            pre.setString(4, hobby);
            pre.setString(5, login_name);
            pre.setString(6, password);
            pre.setInt(7, user_id);
            pre.executeUpdate();

            con.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
