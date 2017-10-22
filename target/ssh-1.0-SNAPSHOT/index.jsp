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
    <title>Index</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/client/client_login.action" method="post" >
    姓名:<input name="user.name" />
    <input type="submit" name="login" value="登录" />
</form>
<a href="/client/client_registerPage">没有账号？点击注册</a>

</body>
</html>
