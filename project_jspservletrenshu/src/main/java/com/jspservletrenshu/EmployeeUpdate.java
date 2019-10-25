package com.jspservletrenshu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeUpdate(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = (String)request.getParameter("name");
        String age = (String)request.getParameter("age");
        String tell = (String)request.getParameter("tell");
        String password = (String)request.getParameter("password");
        String code = (String)request.getParameter("code");

        int namefrg = 0;
        int agefrg = 0;
        int tellfrg = 0;
        int passwordfrg = 0;
        int codefrg = 0;


        if(name.equals("") || name == null){
            request.setAttribute("nameerrer","名前の入力が正しくありません");
            namefrg = 1;
        }

        if(age.equals("") || age == null){
            request.setAttribute("ageerrer","年齢の入力が正しくありません");
            agefrg = 1;
        }

        if(tell.equals("") || tell == null){
            request.setAttribute("tellerrer","電話番号の入力が正しくありません");
            tellfrg = 1;
        }

        if(password.equals("") || password == null){
            request.setAttribute("passworderrer","パスワードの入力が正しくありません");
            passwordfrg = 1;
        }

        if(code.equals("") || password == null){
            request.setAttribute("codeerrer","コードの入力が正しくありません");
        }

        if(namefrg == 1 || agefrg == 1 || tellfrg == 1 || passwordfrg == 1){
            RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
            dispatcher.forward(request,response);
            
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            doGet(request, response);
    }


}
