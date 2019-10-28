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
<%
//String update_name_errer = (String)request.getAttribute("nameerrer");
//String update_age_errer = (String)request.getAttribute("ageerrer");
//String update_tell_errer = (String)request.getAttribute("tellerrer");
//String update_password_errer = (String)request.getAttribute("passworderrer");
String update_code_errer = (String)request.getAttribute("codeerrer");

//String update_name_errer_msg;
//String update_age_errer_msg;
//String update_tell_errer_msg;
//String update_password_errer_msg;

String update_code_errer_msg = null;

//if(update_name_errer == null){
//    update_name_errer = "";
//}
//if(update_age_errer == null){
//    update_age_errer = "";
//}
//
//if(update_tell_errer == null){
//    update_tell_errer = "";
//}
//
//if(update_password_errer == null){
//    update_password_errer = "";
//}

if(update_code_errer == null ){
    update_code_errer_msg = "";
}else{
    update_code_errer_msg = update_code_errer;
}

%>
<form action="EmployeeUpdate" method = "get">
    名前<input type="text" name="name"><br>
    年齢<input type="text" name="age"><br>
    電話番号<input type="text" name="tell"><br>
    パスワード<input type="password" name="password"><br>
    コード<input type="text" name="code"><%=update_code_errer_msg%><br>
    <input type="submit" name = "hidden" value="変更">
</form>
</body>
</html>
