<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Participator</title>
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
        <legend>参与人信息</legend>
        <img name="img" src="${participator.imgUrl}" width="50" height="50"/>
        <table>
            <tr>
                <td>姓名：</td>
                <td>${participator.name}</td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td>${participator.age}</td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>${participator.gender}</td>
            </tr>
            <tr>
                <td>学校：</td>
                <td>${participator.institution}</td>
            </tr>
        </table>
    </fieldset>
</div>
</body>
</html>
