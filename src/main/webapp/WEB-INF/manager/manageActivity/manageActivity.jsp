<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/28
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Manage Catgory</title>
</head>
<body>
<div>
    <h2>管理</h2>
    <div>
        <a href="/manage/manage/addActivityPage.action?catgoryId=${catgoryId}"><button>增加活动</button></a>
    </div>
    <div>
        <table border="1">
            <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
                <tr>
                    <td>${activity.name}</td>
                    <td>
                        <a href="/manage/manage/modifyActivityPage.action?activityId=${activity.id}">修改</a>
                        <a href="/manage/manage/deleteActivity.action?activityId=${activity.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
