package com.pro.util.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JdbcUtil {

    private static InputStream in = null;
    private static List<Connection> con = new ArrayList<>();

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String pwd = null;

    static {
        //加载驱动
        try {

            ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
            driver = rb.getString("driverClassName");
            url = rb.getString("url");
            username = rb.getString("username");
            pwd = rb.getString("pwd");

            Class.forName(driver);
            addConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void addConnection() throws SQLException {
        for(int i = 0; i < 10; i++){
            Connection ct = null;
            ct = DriverManager.getConnection(url, username, pwd);
            con.add(ct);
        }
    }

    public static Connection getConnection() throws SQLException {
        if(con.isEmpty()) {
            return con.remove(0);
        }else{
            Connection ct = null;
            ct = DriverManager.getConnection(url, username, pwd);
            return ct;
        }
    }

    public static void relase(Connection cl) throws SQLException {
        con.add(cl);
    }

    public static void closeAll() throws SQLException {
        for( Connection temp : con){
            temp.close();
        }
    }
}