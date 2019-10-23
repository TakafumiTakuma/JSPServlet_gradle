<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/11
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>メイン画面</title>
</head>
<body>
<h1>メイン画面</h1>
<a href="insert.jsp">新規登録はこちら</a>
<table border = 1>
    <tr>
        <th>ID</th>
        <th>名前</th>
        <th>年齢</th>
        <th>電話番号</th>
        <th>パスワード</th>
    </tr>
    <c:forEach var="list" items="${employeelists}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.age}</td>
            <td>${list.tell}</td>
            <td>${list.password}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
