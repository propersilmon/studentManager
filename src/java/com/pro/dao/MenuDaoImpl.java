package com.pro.dao;

import com.pro.model.Menu;
import com.pro.util.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    @Override
    public void addMenu(Menu menu) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "insert into sys_menu (p_id, anthorty_name, anthorty_desc, anthorty_url, create_time) values (?, ?, ?, ?, ?)";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setInt(1, menu.getP_id());
            psdm.setString(2, menu.getAnthorty_name());
            psdm.setString(3, menu.getAnthorty_desc());
            psdm.setString(4, menu.getAnthorty_url());
            psdm.setDate(5, new java.sql.Date(menu.getCreate_time().getTime()));

            psdm.executeUpdate();
            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenuById(int menu_id) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "delete from sys_menu where menu_id= ?";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setInt(1, menu_id);
            psdm.executeUpdate();

            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterMenuById(int menu_id, int p_id, String anthorty_name, String anthorty_desc, String anthorty_url) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "update sys_menu set p_id=?, anthorty_name=?, anthorty_desc=?, anthorty_url=? where menu_id=?;";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setInt(1, p_id);
            psdm.setString(2, anthorty_name);
            psdm.setString(3, anthorty_desc);
            psdm.setString(4, anthorty_url);
            psdm.setInt(5, menu_id);
            psdm.executeUpdate();

            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> showMenu() {
        List<Menu> menuList = new ArrayList<>();
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "select * from sys_menu";
            PreparedStatement psdm = con.prepareStatement(sqlStr);

            ResultSet rs = psdm.executeQuery();
            while (rs.next()){
                int menu_id = rs.getInt("menu_id");
                int p_id = rs.getInt("p_id");
                String anthorty_name = rs.getString("anthorty_name");
                String anthorty_desc = rs.getString("anthorty_desc");
                String anthorty_url = rs.getString("anthorty_url");
                Date create_time = rs.getDate("create_time");

                Menu menu = new Menu(menu_id, p_id, anthorty_name, anthorty_desc, anthorty_url, create_time);
                menuList.add(menu);
            }

            JdbcUtil.relase(con);
            psdm.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }
}
