<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<center>
<h3>注册</h3>
<s:fielderror cssStyle="color:red"></s:fielderror>
<form action="/client/register.action" method="post" >
    <div>用户名:<input name="client.name"  /></div>
    <div>密码:<input name="client.pswd" type="password" /></div>
    <div>邮箱:<input name="client.email" type="email"/></div>
    <div><input type="submit" name="register" value="注册" /></div>
</form>
</center>
</body>
</html>