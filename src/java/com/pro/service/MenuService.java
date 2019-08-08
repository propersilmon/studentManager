package com.pro.service;

import com.pro.model.Menu;

import java.util.List;

public interface MenuService {
    void addMenu(Menu menu);

    void deleteMenuById(int menu_id);

    void alterMenu(int menu_id, int p_id, String anthorty_name, String anthorty_desc, String anthorty_url);

    List<Menu> showMenu();
}
