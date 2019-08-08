package com.pro.controller;

import com.pro.model.Role;
import com.pro.service.RoleService;
import com.pro.service.RoleServiceImpl;
import com.pro.util.annotation.Controller;
import com.pro.util.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RoleController {

    //注入RoleService
    RoleService roleService = new RoleServiceImpl();

    @RequestMapping("/addRole")
    public String addRole(HttpServletRequest req, HttpServletResponse resp){
        String role_name = req.getParameter("role_name");
        String role_desc = req.getParameter("role_desc");
        String role_state = req.getParameter("role_state");
        Date create_time = new Date();

        Role role = new Role(role_name, role_desc, role_state, create_time);
        roleService.addRole(role);
        return "/showRole";
    }

    @RequestMapping("deleteRole")
    public String deleteRole(HttpServletRequest req, HttpServletResponse resp){

        roleService.deleteRoleById(Integer.parseInt(req.getParameter("role_id")));
        return "/showRole";
    }

    @RequestMapping("/alterRole")
    public String alterRole(HttpServletRequest req, HttpServletResponse resp){
        int role_id = Integer.parseInt(req.getParameter("role_id"));
        String role_name = req.getParameter("role_name");
        String role_desc = req.getParameter("role_desc");
        String role_state = req.getParameter("role_state");

        roleService.alterRole(role_id, role_name, role_desc, role_state);
        return "/showRole";
    }

    @RequestMapping("/showRole")
    public String showRole(HttpServletRequest req, HttpServletResponse resp){
        List<Role> roleList = new ArrayList<>();
        roleList = roleService.showRole();
        req.setAttribute("roleList", roleList);
        return "view/role/showRole.jsp";
    }
}
