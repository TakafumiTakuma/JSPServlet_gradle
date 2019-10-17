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

@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userid = (String) request.getParameter("id");
        String userpass = (String) request.getParameter("pass");

        int idfrg = 0;
        int passfrg = 0;

        /**
         * ログイン入力チェック
         */
        if (userid.equals("") || userid == null) {
            request.setAttribute("iderrer", "ユーザーIDが正しくありません");
            idfrg = 1;
        }

        if (userpass.equals("") || userpass == null) {
            request.setAttribute("passerrer", "パスワードが正しくありません");
            passfrg = 1;
        }

        if (idfrg == 1 || passfrg == 1) {
            RequestDispatcher dispatch1 = request.getRequestDispatcher("index.jsp");
            dispatch1.forward(request, response);
            return;

        }

        SqlMthos sqlmthos = new SqlMthos();

        boolean emp = true;
        try {
            emp = sqlmthos.getSelectEmploee(userid,userpass);

            if(emp == false){
                System.out.println("ログインエラー");
                request.setAttribute("emperrer","該当する会員情報がございません");
                RequestDispatcher dispatch2 = request.getRequestDispatcher("index.jsp");
                dispatch2.forward(request, response);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        List<EmployeeBean> emplist = new ArrayList<EmployeeBean>();
        try {
            emplist = sqlmthos.getSelectEmploeeAll();

        } catch (SQLException e) {
            System.out.println("会員一覧表示ができません");
            e.printStackTrace();
        }

        //会員情報一覧を表示するための配列を生成
        ArrayList<EmployeeBean> employeelist = new ArrayList<EmployeeBean>();

        //データベースから会員情報のデータを読み取る
        for (int i = 0; i < emplist.size(); i++) {
            EmployeeBean eb = emplist.get(i);
            String id = eb.getId();
            String name = eb.getName();
            String age = eb.getAge();
            String tell = eb.getTell();
            String pass = eb.getPassword();

            employeelist.add(new EmployeeBean(id, name, age, tell, pass));
        }
        request.setAttribute("employeelists", employeelist);
        RequestDispatcher dispatch1 = request.getRequestDispatcher("main.jsp");
        dispatch1.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

