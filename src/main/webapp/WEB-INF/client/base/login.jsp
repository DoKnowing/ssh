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
    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function refresh() {
            $("#img").attr("src","/client/base/createCheckCode.action?d="+new Date().valueOf());
        }
    </script>
</head>
<body>
<center>
     <h3>用户登录</h3>
     <s:fielderror cssStyle="color:red"></s:fielderror>
     <form action="/client/base/login.action" method="post">
         <div>账号:<input name="client.email" type="email"/></div>
         <div>密码:<input name="client.pswd" type="password"/></div>
         <div>验证码:<input  name="checkCode" />
         <img id="img" src="/client/base/createCheckCode.action" alt="验证码" title="看不清，换一张" onclick="refresh()"></div>
         <div><input type="submit" name="login"  value="登录"/><input type="reset" value="重新输入"/></div>
         <div><a href="register.jsp">尚未注册，点击注册</a></div>
    </form>
</center>
</body>
</html>
