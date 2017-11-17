<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/23
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Detail</title>
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
        <legend>活动相关信息</legend>
        <h2>${activity.name}</h2>
        <table>
            <tr>
                <td>活动时间：</td>
                <td>${activity.time}</td>
            </tr>
            <tr>
                <td>活动地点：</td>
                <td>${activity.location}</td>
            </tr>
            <tr>
                <td>发起人：</td>
                <td>${activity.initiator.name}</td>
            </tr>
            <tr>
                <td>学校：</td>
                <td>${activity.initiator.institution}</td>
            </tr>
            <tr>
                <td>活动概要：</td>
                <td>${activity.outline}</td>
            </tr>
            <tr>
                <td><a href="/client/operate/moreDetailPage.action?activityId=${activityId}">查看详情-></a></td>
            </tr>
            <tr>
                <td><a href="/client/operate/participatePage.action?activityId=${activityId}">我要参加</a>
                </td>
            </tr>
        </table>
    </fieldset>
    <br>
    <fieldset>
        <legend>已报名的人</legend>
        <table>
            <c:forEach items="${activity.clientActivities}" var="clientActivity" varStatus="rowStatus">
                <c:if test="${not empty clientActivity}">
                    <a href="/client/operate/participatorDetail.action?participatorId=${clientActivity.client.id}">
                        <img src="${clientActivity.client.imgUrl}" width="30" height="30"/><br>
                        <label>${clientActivity.client.name}</label><br>
                        <label>${clientActivity.client.gender}</label>
                    </a>
                </c:if>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
