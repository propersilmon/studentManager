package com.pro.dao;

import com.pro.model.User;
import com.pro.util.utils.JdbcUtil;

import java.sql.*;

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
}
