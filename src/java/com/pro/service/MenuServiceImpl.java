package com.pro.service;

import com.pro.dao.MenuDao;
import com.pro.dao.MenuDaoImpl;
import com.pro.model.Menu;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    //注入MenuDao
    MenuDao menuDao = new MenuDaoImpl();

    @Override
    public void addMenu(Menu menu) {
        menuDao.addMenu(menu);
    }

    @Override
    public void deleteMenuById(int menu_id) {
        menuDao.deleteMenuById(menu_id);
    }

    @Override
    public void alterMenu(int menu_id, String anthorty_name, String anthorty_desc, String anthorty_url) {
        menuDao.alterMenuById(menu_id, anthorty_name, anthorty_desc, anthorty_url);
    }

    @Override
    public List<Menu> showMenu() {
        return menuDao.showMenu();
    }
}
