<%@ page import="com.jspservletrenshu.bean.EmployeeBean" %>
<%@ page import="com.jspservletrenshu.bean.EmployeeInsertBean" %><%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/21
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登録確認画面</title>
</head>
<body>
<%
String name = (String)request.getAttribute("name");
String age = (String)request.getAttribute("age");
String tell = (String)request.getAttribute("tell");
String password = (String)request.getAttribute("password");


EmployeeInsertBean employeeInsertBean = new EmployeeInsertBean(name,age,tell,password);

request.setAttribute("employeeInsertBean",employeeInsertBean);


%>
<h1>確認画面</h1>
<p>下記の通りに登録します</p>
<form action="EmployeeInsert" method = "get">
名前:<%=name%><br>
年齢:<%=age%><br>
電話番号:<%=tell%><br>
パスワード:<%=password%><br>
    <input type="submit" value="登録">
</form>
</body>
</html>
