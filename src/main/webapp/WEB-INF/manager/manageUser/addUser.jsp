<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<div>
    <h2>增加用户</h2>
    <form action="/manager/manageUser/addUser.action" method="post" >
        <div>用户名:<input name="client.name"  /></div>
        <div>密码:<input name="client.pswd" type="password" /></div>
        <div>邮箱:<input name="client.email" type="email"/></div>
        <div><input type="submit" name="add" value="确认添加" /></div>
    </form>
</div>
</body>
</html>
