<%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/11
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>ログイン画面</title>
  </head>
  <body>
  <h1>ログイン画面</h1>
  <%
  String iderrermsg = (String)request.getAttribute("iderrer");
  String passerrermsg = (String)request.getAttribute("passerrer");
  String emperrermsg = (String)request.getAttribute("emperrer");

  if(iderrermsg == null){
    iderrermsg = "";
  }
  if(passerrermsg == null){
    passerrermsg = "";
  }
    if(emperrermsg == null){
      emperrermsg = "";
    }

  %>
  <form action = "EmployeeList" method="get">
    <%= emperrermsg%><br>
    ログインID<input type="text" name="id"><%=iderrermsg%><br>
    パスワード<input type="password" name="pass"><%=passerrermsg%><br>
    <input type="submit" value="ログイン" >
  </form>
  </body>
</html>
