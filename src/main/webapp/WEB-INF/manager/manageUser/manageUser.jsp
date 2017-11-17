<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage User</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget" align="center">
    <fieldset style="width: 700px">
        <h2>管理用户</h2>
        <div class="ui-state-highlight"></div><br>
        <div align="left">
            <a href="/manage/manage/addUserPage.action" style="align-items: center">增加用户</a>
            <a href="/manage/base/homePage.action">返回主页</a>        </div>
        <div>
            <table border="1" width="700px">
                <c:forEach items="${clients}" var="client" varStatus="rowStatus">
                    <tr>
                        <td width="500px" align="center">${client.name}</td>
                        <td width="200px" align="center">
                            <a href="/manage/manage/modifyUserPage.action?clientId=${client.id}">修改</a>
                            <a href="/manage/manage/deleteUser.action?clientId=${client.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </fieldset>
</div>
</body>
</html>
