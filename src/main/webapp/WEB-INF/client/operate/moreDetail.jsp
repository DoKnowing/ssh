<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MoreDetail</title>
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
        <legend>活动详情</legend>
        <label>${activity.detail}</label>
    </fieldset>
    <fieldset>
        <legend>相关图片</legend>
        <c:forEach items="${activity.imgs}" var="img" varStatus="rowStatus">
            <img name="img" src="${img}" width="150" height="150"/><br/><br/>
        </c:forEach>
    </fieldset>
</div>
</body>
</html>
