package com.jspservletrenshu.dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBM {
    private static String drivername = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/javarenshu?useUnicode=true&characterEncoding=utf8";
    private static String user = "root";
    private static String pass = "";

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(drivername);
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
