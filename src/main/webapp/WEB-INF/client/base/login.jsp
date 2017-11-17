<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
    <%--<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>--%>
    <script type="text/javascript">
        function refresh() {
            $("#img").attr("src", "/client/base/createCheckCode.action?d=" + new Date().valueOf());
        }
    </script>
</head>
<body>
<div class="ui-widget" align="center">
    <fieldset style="width: 500px">
        <h2>用户登录</h2>
        <div class="ui-state-highlight"><s:fielderror cssStyle="color:red"></s:fielderror></div><br>
        <form action="/client/base/login.action" method="post">
            <div>账号:<input name="client.email" type="email"/></div><br>
            <div>密码:<input name="client.pswd" type="password"/></div><br>
            <div>验证码:<input name="checkCode"/>
                <img id="img" src="/client/base/createCheckCode.action" alt="验证码" title="看不清，换一张" onclick="refresh()">
            </div><br>
            <div><input type="submit" name="login" value="登录"/><input type="reset" value="重新输入"/></div><br>
            <div><a href="/client/base/registerPage.action">尚未注册，点击注册</a></div>
        </form>
    </fieldset>
</div>
</body>
</html>
