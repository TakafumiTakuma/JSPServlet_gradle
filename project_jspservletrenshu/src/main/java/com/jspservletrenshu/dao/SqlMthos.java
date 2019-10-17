package com.jspservletrenshu.dao;

import com.jspservletrenshu.bean.EmployeeBean;
import com.jspservletrenshu.dbm.DBM;

import javax.management.Attribute;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlMthos {

    private String sql = "select * from user";
    public List<EmployeeBean>getSelectEmploeeAll() throws SQLException{
        Connection con = DBM.getConnection();
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        List<EmployeeBean> employeelist = new ArrayList<EmployeeBean>();

        while(result.next()){
            EmployeeBean employeebean = new EmployeeBean(result);
            employeelist.add(employeebean);
        }
        return employeelist;
    }

    public boolean getSelectEmploee(String userid, String userpassword) throws SQLException{
        String sql = "select * from user where id = ? AND password = ?";
        Connection con = DBM.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userid);
        ps.setString(2, userpassword);

        ResultSet result = ps.executeQuery(sql);

        if(result.next() == true){
            return true;
        }else{
            return false;
        }



    }


}
