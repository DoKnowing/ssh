<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/27
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div>
    <h2>管理平台</h2>
    <table border="1">
        <tr><td><a href="/manage/manage/manageUserPage.action"><input name="manageUser" type="button" value="管理用户"/></a></td></tr>
        <tr><td><a href="/manage/manage/manageCatgoryPage.action"><input name="manageCatgory" type="button" value="管理活动类别"/></a></td></tr>
    </table>
</div>
</body>
</html>
