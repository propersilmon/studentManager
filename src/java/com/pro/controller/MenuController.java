package com.pro.controller;

import com.pro.model.Menu;
import com.pro.service.MenuService;
import com.pro.service.MenuServiceImpl;
import com.pro.util.annotation.Controller;
import com.pro.util.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MenuController {

    //注入MenuService
    MenuService menuService = new MenuServiceImpl();

    @RequestMapping("/addMenu")
    public String addMenu(HttpServletRequest req, HttpServletResponse resp){
        int p_id = Integer.parseInt(req.getParameter("p_id"));
        String anthorty_name = req.getParameter("anthorty_name");
        String anthorty_desc = req.getParameter("anthorty_desc");
        String anthorty_url = req.getParameter("anthorty_url");
        Date create_time = new Date();

        Menu menu = new Menu(p_id, anthorty_name, anthorty_desc, anthorty_url, create_time);
        menuService.addMenu(menu);
        return "/showMenu";
    }

    @RequestMapping("deleteMenu")
    public String deleteMenu(HttpServletRequest req, HttpServletResponse resp){

        menuService.deleteMenuById(Integer.parseInt(req.getParameter("menu_id")));
        return "/showMenu";
    }

    @RequestMapping("/alterMenu")
    public String alterMenu(HttpServletRequest req, HttpServletResponse resp){
        int menu_id = Integer.parseInt(req.getParameter("menu_id"));
        int p_id = Integer.parseInt(req.getParameter("p_id"));
        String anthorty_name = req.getParameter("anthorty_name");
        String anthorty_desc = req.getParameter("anthorty_desc");
        String anthorty_url = req.getParameter("anthorty_url");

        menuService.alterMenu(menu_id, p_id, anthorty_name, anthorty_desc, anthorty_url);
        return "/showMenu";
    }

    @RequestMapping("/showMenu")
    public String showMenu(HttpServletRequest req, HttpServletResponse resp){
        List<Menu> menuList = new ArrayList<>();
        menuList = menuService.showMenu();
        req.setAttribute("menuList", menuList);
        return "view/Menu/showMenu.jsp";
    }
}
