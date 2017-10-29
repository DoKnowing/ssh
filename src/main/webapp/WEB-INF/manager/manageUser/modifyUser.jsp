<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Modify</title>
</head>
<body>
<div>
    <h2>修改用户信息</h2>
    <form action="/manage/manage/modifyUser.action?clientId=${clientId}" method="post"  enctype="multipart/form-data">
        <div>
            <table>
                <tr><td>昵称：</td><td><input name="client.name" type="text" value=""/></td></tr>
                <tr><td>性别：</td><td><input name="client.gender" type="text" value=""/></td></tr>
                <tr><td>年龄：</td><td><input name="client.age" type="text" /></td></tr>
                <tr><td>邮箱：</td><td><input name="client.email" type="email" value=""/></td></tr>
                <tr><td>头像：</td><td><input type="file" name="img"/></td></tr>
            </table>
        </div>
        <div>
            <input  type="submit" value="确认修改"/>
        </div>
    </form>
</div>
</body>
</html>
