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
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body >
<div class="ui-widget" align="center">
    <fieldset style="width: 500px">
        <h2>登录</h2>
        <div class="ui-state-highlight"></div><br>
        <form action="/manage/base/login.action" method="post">
            <div>账号:<input name="manager.name" type="text"></div>
            <div>密码:<input name="manager.pswd" type="password"></div>
            <div><input type="submit" value="登录"></div>
        </form>
    </fieldset>
</div>
</body>
</html>
