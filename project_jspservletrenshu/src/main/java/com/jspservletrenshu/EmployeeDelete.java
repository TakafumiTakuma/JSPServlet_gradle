package com.jspservletrenshu;

import com.jspservletrenshu.dao.SqlMthos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EmployeeDelete")
public class EmployeeDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EmployeeDelete(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String code = (String)request.getParameter("code");

        int codefrg = 0;

        if(code.equals("") || code == null){
            request.setAttribute("errercode","コードが正しくありません");
            codefrg = 1;
        }

        if(codefrg == 1){
            RequestDispatcher dispatch = request.getRequestDispatcher("delete.jsp");
            dispatch.forward(request, response);
            return;
        }

        SqlMthos sqlmtos = new SqlMthos();

        try{
            sqlmtos.DeleteEmployee(code);

            RequestDispatcher dispatch = request.getRequestDispatcher("deleteend.jsp");
            dispatch.forward(request, response);

        }catch (SQLException e){
            e.getStackTrace();
        }catch(Exception e){
            e.getStackTrace();
        }


    }

}
