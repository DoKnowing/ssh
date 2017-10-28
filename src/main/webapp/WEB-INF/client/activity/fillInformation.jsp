<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<div>
    <form action="/client/participate.action?activityId=${activityId}" method="post">
        <h2>我要报名</h2>
        <div><input name="phone" value="手机号码" required="required"/></div>
        <div><input name="selfIntroduction" value="自我介绍"/></div>
        <div><input name="participate" type="submit" value="报名"/></div>
    </form>
</div>
</body>
</html>
