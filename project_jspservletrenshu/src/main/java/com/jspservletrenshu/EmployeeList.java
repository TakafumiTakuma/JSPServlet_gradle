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



        String username = (String) request.getParameter("name");
        String userpass = (String) request.getParameter("pass");
        String login_hidden = (String) request.getParameter("login_hidden");
        String delete_back_hidden = (String) request.getParameter("delete_back_hidden");
        String insert_back_hidden = (String) request.getParameter("insert_back_hidden");

        int namefrg = 0;
        int passfrg = 0;

        /**
         * 未入力チェック
         */

        //ログインボタンが押された場合の処理
        if(login_hidden != null) {
            if (username.equals("") || username == null) {
                request.setAttribute("nameerrer", "ユーザー名が正しくありません");
                namefrg = 1;
            }

            if (userpass.equals("") || userpass == null) {
                request.setAttribute("passerrer", "パスワードが正しくありません");
                passfrg = 1;
            }

            if (namefrg == 1 || passfrg == 1) {
                RequestDispatcher dispatch1 = request.getRequestDispatcher("index.jsp");
                dispatch1.forward(request, response);
                return;
            }
        }


        try {

            SqlMthos sqlmthos = new SqlMthos();



            if (sqlmthos.getSelectEmploee(username, userpass) || delete_back_hidden != null || insert_back_hidden != null) {
                System.out.println("ログイン成功");
                //getSelectEmploeeAllメソッドの実行結果をリストに格納
                List<EmployeeBean> emplist;
                emplist = sqlmthos.getSelectEmploeeAll();

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
                    String code = eb.getCode();

                    //
                    employeelist.add(new EmployeeBean(id, name, age, tell, pass,code));
                }
                request.setAttribute("employeelists", employeelist);
                RequestDispatcher dispatch1 = request.getRequestDispatcher("main.jsp");
                dispatch1.forward(request, response);
            }else{
                System.out.println("ログインエラー");
                request.setAttribute("emperrer", "該当する会員情報がございません");
                RequestDispatcher dispatch2 = request.getRequestDispatcher("index.jsp");
                dispatch2.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

