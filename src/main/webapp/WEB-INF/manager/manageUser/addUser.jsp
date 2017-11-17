<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <fieldset>
        <h2>增加用户</h2>
        <div class="ui-state-highlight"></div><br>
        <form action="/manage/manage/addUser.action" method="post" enctype="multipart/form-data">
            <div>用户名:<input name="client.name"/></div>
            <div>密码:<input name="client.pswd" type="password"/></div>
            <div>性别:<input name="client.gender" type="text" value=""/></div>
            <div>邮箱:<input name="client.email" type="email"/></div>
            <div>头像:<input name="img" type="file" accept="image/gif, image/jpeg"/></div>
            <div><input type="submit" name="add" value="确认添加"/></div>
        </form>
    </fieldset>
</div>
</body>
</html>
