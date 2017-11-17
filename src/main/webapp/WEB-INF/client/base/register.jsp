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
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <fieldset>
        <h2>注册</h2>
        <div class="ui-state-highlight"><s:fielderror cssStyle="color:red"></s:fielderror></div><br>
        <form action="/client/base/register.action" method="post">
            <div>用户名:<input name="client.name"/></div>
            <div>密码:<input name="client.pswd" type="password"/></div>
            <div>邮箱:<input name="client.email" type="email"/></div>
            <div><input type="submit" name="register" value="注册"/></div>
        </form>
    </fieldset>
</div>
</body>
</html>