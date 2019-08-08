package com.pro.model;

import java.util.Date;
import java.util.List;

public class Menu {
    //菜单ID
    private int menu_id;
    //父菜单ID
    private int p_id;
    //菜单名称
    private String anthorty_name;
    //菜单描述
    private String anthorty_desc;
    //URL
    private String anthorty_url;
    //创建时间
    private Date create_time;
    //可以参看该菜单的角色
    private List<Role> roleList;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getAnthorty_name() {
        return anthorty_name;
    }

    public void setAnthorty_name(String anthorty_name) {
        this.anthorty_name = anthorty_name;
    }

    public String getAnthorty_desc() {
        return anthorty_desc;
    }

    public void setAnthorty_desc(String anthorty_desc) {
        this.anthorty_desc = anthorty_desc;
    }

    public String getAnthorty_url() {
        return anthorty_url;
    }

    public void setAnthorty_url(String anthorty_url) {
        this.anthorty_url = anthorty_url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Menu() {
        super();
    }

    public Menu(int p_id, String anthorty_name, String anthorty_desc, String anthorty_url, Date create_time) {
        this.p_id = p_id;
        this.anthorty_name = anthorty_name;
        this.anthorty_desc = anthorty_desc;
        this.anthorty_url = anthorty_url;
        this.create_time = create_time;
    }

    public Menu(int menu_id, int p_id, String anthorty_name, String anthorty_desc, String anthorty_url, Date create_time) {
        this.menu_id = menu_id;
        this.p_id = p_id;
        this.anthorty_name = anthorty_name;
        this.anthorty_desc = anthorty_desc;
        this.anthorty_url = anthorty_url;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", p_id=" + p_id +
                ", anthorty_name='" + anthorty_name + '\'' +
                ", anthorty_desc='" + anthorty_desc + '\'' +
                ", anthorty_url='" + anthorty_url + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
