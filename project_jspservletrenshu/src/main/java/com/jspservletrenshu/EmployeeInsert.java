package com.jspservletrenshu;

import com.jspservletrenshu.bean.EmployeeBean;
import com.jspservletrenshu.bean.EmployeeInsertBean;
import com.jspservletrenshu.dao.SqlMthos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EmployeeInsert")
public class EmployeeInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeInsert(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        EmployeeInsertBean employeeinsertbean = (EmployeeInsertBean) request.getAttribute("employeeInsertBean");



        String insert_name = employeeinsertbean.getName();
        String insert_age = employeeinsertbean.getAge();
        String insert_tell = employeeinsertbean.getTell();
        String insert_password = employeeinsertbean.getPassword();

        if(insert_name == null){
            System.out.println("名前がnullです");
        }
        if(insert_age == null){
            System.out.println("年齢がnullです");
        }
        if(insert_tell == null){
            System.out.println("電話番号がnullです");
        }
        if(insert_password == null){
            System.out.println("パスワードがnullです");
        }

        SqlMthos sqlmethod = new SqlMthos();

        try{
            sqlmethod.InsertEmploee(insert_name,insert_age,insert_tell,insert_password);
            RequestDispatcher dispatch1 = request.getRequestDispatcher("insertend.jsp");
            dispatch1.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
