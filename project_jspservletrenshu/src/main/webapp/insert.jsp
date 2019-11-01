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
String name_errer_msg = (String)request.getAttribute("insert_name_errer");
String age_errer_msg = (String)request.getAttribute("insert_age_errer");
String tell_errer_msg = (String)request.getAttribute("insert_tell_errer");
String password_errer_msg = (String)request.getAttribute("insert_password_errer");
String code_errer_msg = (String)request.getAttribute("insert_password_errer");


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
if(code_errer_msg == null){
    code_errer_msg = "";
}
%>
<h1>会員登録画面</h1>
<form action="EmployeeInsert" method="get">
    名前<input type="text" name = "name"><%=name_errer_msg%><br>
    年齢<input type="text" name = "age"><%=age_errer_msg%><br>
    電話番号<input type="text" name = "tell"><%=tell_errer_msg%><br>
    パスワード<input type="password" name = "password"><%=password_errer_msg%><br>
    コード<input type="text" name = "code"><%=code_errer_msg %>>
    <input type="submit" value="登録">
</form>

</body>
</html>
