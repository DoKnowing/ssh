<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/28
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Catgory</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget" align="center">
    <fieldset style="width: 700px">
        <h2>管理活动</h2>
        <div class="ui-state-highlight"></div>
        <br>
        <div align="left">
            <a href="/manage/manage/addActivityPage.action?catgoryId=${catgoryId}">增加活动</a>
            <a href="/manage/base/homePage.action">返回主页</a>
        </div>
        <div>
            <table border="1" width="700px">
                <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
                    <tr>
                        <td width="500px" align="center">${activity.name}</td>
                        <td width="200px" align="center">
                            <a href="/manage/manage/modifyActivityPage.action?activityId=${activity.id}">修改</a>
                            <a href="/manage/manage/deleteActivity.action?activityId=${activity.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </fieldset>
</div>
</body>
</html>
