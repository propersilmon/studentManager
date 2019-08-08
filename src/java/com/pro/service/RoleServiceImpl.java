package com.pro.service;

import com.pro.dao.RoleDao;
import com.pro.dao.RoleDaoImpl;
import com.pro.model.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    //注入RoleDao
    RoleDao roleDao = new RoleDaoImpl();

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role queryRoleById(int role_id) {
        return roleDao.queryRoleById(role_id);
    }


    @Override
    public void alterRole(int role_id, String role_name, String role_desc, String role_state) {
        roleDao.alterRoleById(role_id, role_name, role_desc, role_state);
    }

    @Override
    public List<Role> showRole() {
        return roleDao.showRole();
    }

    @Override
    public void deleteRoleById(int role_id) {
        roleDao.deleteRoleById(role_id);
    }
}
