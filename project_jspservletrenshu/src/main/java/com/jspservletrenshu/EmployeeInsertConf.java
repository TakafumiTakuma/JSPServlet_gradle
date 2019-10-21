package com.jspservletrenshu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeInsertConf")
public class EmployeeInsertConf extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeInsertConf(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String tell = request.getParameter("tell");
        String password = request.getParameter("password");

        int namefrg = 0;
        int agefrg = 0;
        int tellfrg = 0;
        int passwordfrg = 0;

        /**
         * ログイン入力チェック
         */
        if (name.equals("") || name == null) {
            request.setAttribute("nameerrer", "ユーザー名が正しくありません");
            namefrg = 1;
        }

        if (age.equals("") || age == null) {
            request.setAttribute("ageerrer", "年齢が正しくありません");
            agefrg = 1;
        }
        if (tell.equals("") || tell == null) {
            request.setAttribute("tellerrer", "電話番号が正しくありません");
            tellfrg = 1;
        }
        if (password.equals("") || password == null) {
            request.setAttribute("passerrer", "パスワードが正しくありません");
            passwordfrg = 1;
        }

        if (namefrg == 1 || agefrg == 1 || tellfrg == 1 || passwordfrg == 1) {
            RequestDispatcher dispatch1 = request.getRequestDispatcher("insert.jsp");
            dispatch1.forward(request, response);
            return;

        }

        request.setAttribute("name",name);
        request.setAttribute("age",age);
        request.setAttribute("tell",tell);
        request.setAttribute("password",password);

        RequestDispatcher dispatch = request.getRequestDispatcher("insertconf.jsp");
        dispatch.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
