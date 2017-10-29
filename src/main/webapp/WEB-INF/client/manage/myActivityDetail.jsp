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
</head>
<body>
<div>
    <h2>${activity.name}</h2>
    <table>
        <tr><td>活动时间：</td><td>${activity.time}</td></tr>
        <tr><td>活动地点：</td><td>${activity.location}</td></tr>
        <tr><td>发起人：</td><td>${activity.initiator.name}</td></tr>
        <tr><td>学校：</td><td>${activity.initiator.institution}</td></tr>
        <tr><td>活动概要：</td><td>${activity.outline}</td></tr>
        <tr style="color: crimson"><td>活动状态：</td><td>${activity.status}</td></tr>
        <tr><td><a href="/client/operate/moreDetailPage.action?activityId=${activity.id}">查看详情-></a></td></tr>
    </table>
</div>
<div>
<label>已报名的人</label><br>
    <table>
        <c:forEach items="${activity.participators}" var="participator" varStatus="rowStatus">
            <a href="/client/operate/participatorDetail.action?participatorId=${participator.id}"><button>
                <label>${participator.name}</label><br>
                <label>${participator.gender}</label>
            </button></a>
        </c:forEach>
    </table>
</div>
</body>
</html>
