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

        String insert_name = (String)request.getParameter("name");
        String insert_age = (String)request.getParameter("age");
        String insert_tell = (String)request.getParameter("tell");
        String insert_password = (String)request.getParameter("password");
        String insert_code = (String)request.getParameter("code");

        int insert_namefrg = 0;
        int insert_agefrg = 0;
        int insert_tellfrg = 0;
        int insert_passwordfrg = 0;
        int insert_codefrg = 0;

        if(insert_name.equals("") || insert_name == null){
            request.setAttribute("insert_name_errer","名前の入力が正しくありません");
            insert_namefrg = 1;
        }
        if(insert_age.equals("") || insert_age == null){
            request.setAttribute("insert_age_errer","年齢の入力が正しくありません");
            insert_agefrg = 1;
        }
        if(insert_tell.equals("") || insert_tell == null){
            request.setAttribute("insert_tell_errer","電話番号の入力が正しくありません");
            insert_tellfrg = 1;
        }
        if(insert_password.equals("") || insert_password == null){
            request.setAttribute("insert_password_errer","パスワードの入力が正しくありません");
            insert_passwordfrg = 1;
        }

        if(insert_code.equals("") || insert_code == null){
            request.setAttribute("insert_password_errer","パスワードの入力が正しくありません");
            insert_codefrg = 1;
        }

        if(insert_namefrg == 1 || insert_agefrg == 1 || insert_tellfrg == 1 || insert_passwordfrg == 1 || insert_codefrg == 1){

            RequestDispatcher dispatch = request.getRequestDispatcher("insert.jsp");
            dispatch.forward(request, response);
            return;
        }

        SqlMthos sqlmethod = new SqlMthos();

        try{
            sqlmethod.InsertEmploee(insert_name,insert_age,insert_tell,insert_password,insert_code);
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
