package com.pro.dao;

import com.pro.model.Role;
import com.pro.util.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public void addRole(Role role) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "insert into sys_role (role_name, role_desc, role_state, create_time) values (?, ?, ?, ?)";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setString(1, role.getRole_name());
            psdm.setString(2, role.getRole_desc());
            psdm.setString(3, role.getRole_state());
            psdm.setDate(4, new java.sql.Date(role.getCreate_time().getTime()));

            psdm.executeUpdate();
            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role queryRoleById(int role_id) {
        Role role = null;
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "select * from sys_role where id= ?";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setInt(1, role_id);

            ResultSet rs = psdm.executeQuery();
            while (rs.next()){
                String role_name = rs.getString("role_name");
                String role_desc = rs.getString("role_desc");
                String role_state = rs.getString("role_state");
                Date create_time = rs.getDate("create_time");

                role = new Role(role_name, role_desc, role_state, create_time);
            }

            JdbcUtil.relase(con);
            psdm.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void alterRoleById(int role_id, String role_name, String role_desc, String role_state) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "update sys_role set role_name=?, role_desc=?, role_state=? where role_id=?;";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setString(1, role_name);
            psdm.setString(2, role_desc);
            psdm.setString(3, role_state);
            psdm.setInt(4, role_id);
            psdm.executeUpdate();

            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> showRole() {
        List<Role> roleList = new ArrayList<>();
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "select * from sys_role";
            PreparedStatement psdm = con.prepareStatement(sqlStr);

            ResultSet rs = psdm.executeQuery();
            while (rs.next()){
                int role_id = rs.getInt("role_id");
                String role_name = rs.getString("role_name");
                String role_desc = rs.getString("role_desc");
                String role_state = rs.getString("role_state");
                Date create_time = rs.getDate("create_time");

                Role role = new Role(role_id, role_name, role_desc, role_state, create_time);
                roleList.add(role);
            }

            JdbcUtil.relase(con);
            psdm.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }

    @Override
    public void deleteRoleById(int role_id) {
        try {
            Connection con = JdbcUtil.getConnection();
            String sqlStr = "delete from sys_role where role_id= ?";
            PreparedStatement psdm = con.prepareStatement(sqlStr);
            psdm.setInt(1, role_id);
            psdm.executeUpdate();

            JdbcUtil.relase(con);
            psdm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
