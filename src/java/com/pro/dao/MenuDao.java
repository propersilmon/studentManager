package com.pro.dao;

import com.pro.model.Menu;

import java.util.List;

public interface MenuDao {
    void addMenu(Menu menu);

    void deleteMenuById(int menu_id);

    void alterMenuById(int menu_id, int p_id, String anthorty_name, String anthorty_desc, String anthorty_url);

    List<Menu> showMenu();
}
