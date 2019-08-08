package com.pro.service;

import com.pro.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role queryRoleById(int role_id);

    void alterRole(int role_id, String role_name, String role_desc, String role_state);

    List<Role> showRole();

    void deleteRoleById(int role_id);
}
