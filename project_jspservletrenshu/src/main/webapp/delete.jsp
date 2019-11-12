<%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/31
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会員情報削除画面</title>
</head>
<body>
<h1>会員情報削除画面</h1>

<%
String code_errer_msg = (String)request.getAttribute("errercode");

if(code_errer_msg == null){
    code_errer_msg = "";
}

%>
<form action="EmployeeDelete" method = "get">
    削除コード<input type="text" name="code"><%= code_errer_msg%><br>
    <input type="submit" value="削除">
</form>
<form action="EmployeeList" method="get">
    <input type="submit" name = "delete_back_hidden" value="ログイン画面に戻る">
</form>
</body>
</html>
