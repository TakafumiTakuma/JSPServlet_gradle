package com.jspservletrenshu;

import com.jspservletrenshu.bean.EmployeeBean;
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

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String tell = request.getParameter("tell");
        String password = request.getParameter("password");

        SqlMthos sqlmethod = new SqlMthos();

        try{
            sqlmethod.InsertEmploee(name,age,tell,password);
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
