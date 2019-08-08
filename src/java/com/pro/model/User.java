package com.pro.model;

import java.util.Date;
import java.util.List;

public class User {

//    用户ID
    private int user_id;
//    用户名称
    private String name;
//    年龄
    private String age;
//    性别
    private String sex;
//    爱好
    private String hobby;
//    登录名
    private String login_name;
//  密码
    private String password;
//    创建时间
    private Date create_time;

//    用户角色
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public User() {
        super();
    }

    public User(String name, String age, String sex, String hobby, String login_name, String password, Date create_time) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.login_name = login_name;
        this.password = password;
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int user_id, String name, String age, String sex, String hobby, String login_name, String password, Date create_time) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.login_name = login_name;
        this.password = password;
        this.create_time = create_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", login_name='" + login_name + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
