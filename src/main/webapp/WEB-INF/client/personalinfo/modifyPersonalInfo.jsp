<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Information</title>
</head>
<body>
<div>
    <h2>修改个人信息</h2>
    <form action="/client/personalinfo/modifyPersonalInfo.action" method="post">
        <div>
            <table>
                <tr><td>昵称：</td><td><input name="client.name" type="text" value=""/></td></tr>
                <tr><td>性别：</td><td><input name="client.gender" type="text" value=""/></td></tr>
                <tr><td>年龄：</td><td><input name="client.age" type="text" /></td></tr>
                <tr><td>邮箱：</td><td><input name="client.email" type="email" value=""/></td></tr>
            </table>
        </div>
        <div>
            <input  type="submit" value="确认修改"/>
        </div>
    </form>
</div>
</body>
</html>
