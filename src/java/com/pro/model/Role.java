package com.pro.model;

import java.util.Date;
import java.util.List;

public class Role {
    //角色ID
    private int role_id;
    //角色名称
    private String role_name;
    //描述
    private String role_desc;
    //状态
    private String role_state;
    //创建时间
    private Date create_time;
    //角色对应的用户队列
    private List<User> userList;
    //角色所对应的菜单
    private List<Menu> menuList;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public String getRole_state() {
        return role_state;
    }

    public void setRole_state(String role_state) {
        this.role_state = role_state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Role() {
        super();
    }

    public Role(String role_name, String role_desc, String role_state, Date create_time) {
        this.role_name = role_name;
        this.role_desc = role_desc;
        this.role_state = role_state;
        this.create_time = create_time;
    }

    public Role(int role_id, String role_name, String role_desc, String role_state, Date create_time) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_desc = role_desc;
        this.role_state = role_state;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                ", role_state='" + role_state + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
