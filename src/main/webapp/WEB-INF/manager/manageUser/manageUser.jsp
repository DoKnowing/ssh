<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Manage User</title>
</head>
<body>
<div>
<h2>管理用户</h2>
    <div>
        <a href="/manager/manageUser/addUserPage.action"><button>增加用户</button></a>
    </div>
    <div>
        <table border="1">
            <c:forEach items="${clients}" var="client" varStatus="rowStatus">
                <tr>
                    <td>${client.name}</td>
                    <td>
                        <a href="/manager/manageUser/modifyUserPage.action?clientId=${client.id}">修改</a>
                        <a href="/manager/manageUser/deleteUser.action?clientId=${client.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
