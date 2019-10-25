<%--
  Created by IntelliJ IDEA.
  User: takumatakashi
  Date: 2019/10/25
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会員情報変更画面</title>
</head>
<body>
<h1>会員情報変更画面</h1>
<p>コードは必ず入力してください</p>
<form action="EmployeeUpdate" method = "get">
    名前<input type="text" name="name"><br>
    年齢<input type="text" name="age"><br>
    電話番号<input type="text" name="tell"><br>
    パスワード<input type="password" name="password"><br>
    コード<input type="text" name="code"><br>
    <input type="submit" value="変更">
</form>
</body>
</html>
