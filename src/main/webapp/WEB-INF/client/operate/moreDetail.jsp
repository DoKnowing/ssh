<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>MoreDetail</title>
</head>
<body>
<div>
    ${activity.detail}
</div>
<div>
    <label>相关图片:</label>
    <c:forEach items="${activity.imgs}" var="img" varStatus="rowStatus">
        <div>
            <img name="img" src="img"/>
        </div>
    </c:forEach>
</div>
</body>
</html>
