<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/27
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget" align="center">
    <fieldset style="width:700px;">
        <h2>管理平台</h2>
        <div class="ui-state-highlight"></div>
        <br>
        <table border="1" style="width: 700px">
            <tr>
                <td><a href="/manage/manage/manageUserPage.action">管理用户</a></td>
            </tr>
            <tr>
                <td><a href="/manage/manage/manageCatgoryPage.action">管理活动类别</a></td>
            </tr>
        </table>
    </fieldset>
</div>
</body>
</html>
