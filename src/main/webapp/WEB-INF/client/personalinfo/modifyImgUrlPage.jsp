<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Image</title>
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
        <legend>修改头像</legend>
        <form name="/client/personalinfo/modifyImgUrl.action" method="post" enctype="multipart/form-data">
            <input name="img" type="file" accept="image/gif, image/jpeg"/><br>
            <input type="submit" value="确认修改"/>
        </form>
    </fieldset>
</div>
</body>
</html>
