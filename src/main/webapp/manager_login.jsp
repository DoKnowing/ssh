<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/27
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
<div>
    <form action="/manage/base/login.action" method="post">
        <div>账号:<input name="manager.account" type="text"></div>
        <div>密码:<input name="manager.pswd" type="password"></div>
        <div><input type="submit" value="登录"></div>
    </form>
</div>
</center>
</body>
</html>
