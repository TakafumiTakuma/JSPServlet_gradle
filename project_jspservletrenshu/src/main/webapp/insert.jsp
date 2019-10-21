<%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/21
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会員登録画面</title>
</head>
<body>
<%
String name_errer_msg = (String)request.getAttribute("nameerrer");
String age_errer_msg = (String)request.getAttribute("ageerrer");
String tell_errer_msg = (String)request.getAttribute("tellerrer");
String password_errer_msg = (String)request.getAttribute("passworderrer");


if(name_errer_msg == null){
    name_errer_msg = "";
}

if(age_errer_msg == null){
    age_errer_msg = "";
}

if(tell_errer_msg == null){
    tell_errer_msg = "";
}

if(password_errer_msg == null){
    password_errer_msg = "";
}
%>
<h1>会員登録画面</h1>
<form action="EmployeeInsertConf" method="get">
    名前<input type="text" name = "name"><%=name_errer_msg%><br>
    年齢<input type="text" name = "age"><%=age_errer_msg%><br>
    電話番号<input type="text" name = "tell"><%=tell_errer_msg%><br>
    パスワード<input type="password" name = "password"><%=password_errer_msg%><br>
    <input type="submit" value="確認">
</form>
</body>
</html>
