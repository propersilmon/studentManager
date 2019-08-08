package com.pro.controller;

import com.pro.model.User;
import com.pro.service.UserService;
import com.pro.service.UserServiceImpl;
import com.pro.util.annotation.Controller;
import com.pro.util.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    //注入Userservice
    UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/main")
    public String main(HttpServletRequest req, HttpServletResponse resp){
        return "view/userMain.jsp";
    }

    @RequestMapping(value = "/add")
    public String add(HttpServletRequest req, HttpServletResponse resp){
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
       return "/show";
    }



    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.queryUserByUserNameAndPassword(username, password);
        if(user != null){
            return "view/userMain.jsp";
        }else{
            req.setAttribute("message", "登录失败");
           return "index.jsp";
        }
    }

    @RequestMapping(value = "/show")
    public String queryAllUser(HttpServletRequest req, HttpServletResponse resp){
        List<User> userList = null;
        userList = userService.showAllUser();
        req.setAttribute("userList", userList);
        return "view/userList.jsp";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(HttpServletRequest req, HttpServletResponse resp){
        String user_id_str = req.getParameter("user_id");
        int user_id = Integer.parseInt(user_id_str);
        userService.deleteUser(user_id);
        return "/show";
    }

    @RequestMapping(value = "/alter")
    public String alter(HttpServletRequest req, HttpServletResponse resp){
        String user_id = req.getParameter("user_id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String hobby = req.getParameter("hobby");
        String login_name = req.getParameter("login_name");
        String password = req.getParameter("password");

        userService.alterUser(Integer.parseInt(user_id), name, age, sex, hobby, login_name, password);

        return "/show";
    }

}