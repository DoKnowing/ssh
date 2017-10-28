<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/27
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form action="/manager/base/login.action" method="post">
        <input name="account" type="text">
        <input name="pswd" type="text">
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
