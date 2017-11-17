<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Information</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
</head>
<body>
<div>
    <form action="/client/operate/participate.action?activityId=${activityId}" method="post">
        <h2>我要报名</h2>
        <div><input name="clientActivity.phone" value="手机号码" required="required"/></div>
        <div><input name="clientActivity.selfIntroduction" value="自我介绍"/></div>
        <div><input name="participate" type="submit" value="报名"/></div>
    </form>
</div>
</body>
</html>
