package com.jspservletrenshu.dao;

import com.jspservletrenshu.bean.EmployeeBean;
import com.jspservletrenshu.dbm.DBM;

import javax.management.Attribute;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlMthos {

    //会員情報一覧表示用のメソッド
    private String sql = "select * from user";

    public List<EmployeeBean> getSelectEmploeeAll() throws SQLException {
        Connection con = DBM.getConnection();
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        List<EmployeeBean> employeelist = new ArrayList<EmployeeBean>();

        while (result.next()) {
            EmployeeBean employeebean = new EmployeeBean(result);
            employeelist.add(employeebean);
        }
        return employeelist;
    }

    //会員情報
    public boolean getSelectEmploee(String name, String password) throws SQLException {

        String sql = "select * from user WHERE name = ? AND password = ?";
        Connection con = DBM.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);

        ResultSet result = ps.executeQuery();

        if (result.next() == true) {
            return true;
        }else{
            return false;
        }
    }
    public boolean InsertEmploee(String name, String age, String tell, String password, String code) throws SQLException {

        String sql = "INSERT INTO user (name,age,tell,password,code) VALUES (?,?,?,?,?)";
        Connection con = DBM.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,age);
        ps.setString(3,tell);
        ps.setString(4,password);
        ps.setString(5,code);

        int result = ps.executeUpdate();
        System.out.println(result);

        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean UpdateEmployee(String name,String age,String tell, String password,String code) throws SQLException {
        String sql = "UPDATE user SET name = ?, age = ?, tell = ?, password = ? WHERE code = "+ code;
        Connection con = DBM.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,age);
        ps.setString(3,tell);
        ps.setString(4,password);

        int result = ps.executeUpdate();
        System.out.println(result);

        if(result == 1){
            return true;
        }else{
            return false;
        }

    }
}
