package com.pro.controller;

import com.pro.model.User;
import com.pro.service.UserService;
import com.pro.service.UserServiceImpl;
import com.pro.util.annotation.Controller;
import com.pro.util.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
public class UserController {

    //注入Userservice
    UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/main")
    public void main(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("view/userMain.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/add")
    public void add(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String hobby = req.getParameter("hobby");
        String login_name = req.getParameter("login_name");
        String password = req.getParameter("password");

        User user = new User(name, age, sex, hobby, login_name, password, new Date());
        userService.addUser(user);
        try {
            resp.sendRedirect("view/userMain.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "/login")
    public void login(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.queryUserByUserNameAndPassword(username, password);
        if(user != null){
            try {
                resp.sendRedirect("view/userMain.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            req.setAttribute("message", "登录失败");
        }
    }

}
