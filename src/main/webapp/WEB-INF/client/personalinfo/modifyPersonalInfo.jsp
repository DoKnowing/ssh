<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Modify Information</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <br>
    <div align="right"><a href="/client/base/homePage.action">返回主页</a></div>
    <br>
    <div class="ui-state-highlight"></div>
    <br>
    <fieldset>
        <legend>修改个人信息</legend>
        <form action="/client/personalinfo/modifyPersonalInfo.action" method="post">
            <div>
                <table>
                    <tr>
                        <td>昵称：</td>
                        <td><input name="client.name" type="text" value="${client.name}"/></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input name="client.gender" type="text" value="${client.gender}"/></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input name="client.age" type="text" value="${client.age}"/></td>
                    </tr>
                    <tr>
                        <td>邮箱：</td>
                        <td>${client.email}</td>
                    </tr>
                </table>
            </div>
            <div>
                <input type="submit" value="确认修改"/>
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>
