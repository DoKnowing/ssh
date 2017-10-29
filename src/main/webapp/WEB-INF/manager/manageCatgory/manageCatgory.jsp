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
    <h2>管理类型</h2>
    <div>
        <a href="/manage/manage/addCatgoryPage.action"><button>增加类型</button></a>
    </div>
    <div>
        <table border="1">
            <c:forEach items="${catgories}" var="catgory" varStatus="rowStatus">
                <tr>
                    <td>${catgory.name}</td>
                    <td>
                        <a href="/manage/manage/modifyCatgoryPage.action?catgoryId=${catgory.id}">修改</a>
                        <a href="/manage/manage/deleteCatgory.action?catgoryId=${catgory.id}">删除</a>
                        <a href="/manage/manage/manageActivityPage.action?catgoryId=${catgory.id}">管理活动</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
