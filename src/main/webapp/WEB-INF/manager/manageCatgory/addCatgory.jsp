<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/28
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Catgory</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <fieldset>
        <h2>添加类型</h2>
        <div class="ui-state-highlight"></div><br>
        <form action="/manage/manage/addCatgory.action" method="post" enctype="multipart/form-data">
            <div>
                <table>
                    <tr>
                        <td>名称：</td>
                        <td><input name="catgory.name" type="text" value=""/></td>
                    </tr>
                    <tr>
                        <td>标题：</td>
                        <td><input name="catgory.title" type="text" value=""/></td>
                    </tr>
                    <tr>
                        <td>图像：</td>
                        <td><input name="img" type="file" accept="image/gif, image/jpeg"/></td>
                    </tr>
                </table>
            </div>
            <div>
                <input type="submit" value="确认添加"/>
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>
