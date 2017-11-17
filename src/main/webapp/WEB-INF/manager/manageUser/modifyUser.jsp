<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modify</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <fieldset>
        <h2>修改用户信息</h2>
        <div class="ui-state-highlight"></div><br>
        <form action="/manage/manage/modifyUser.action?clientId=${clientId}" method="post"
              enctype="multipart/form-data">
            <div>
                <table>
                    <tr>
                        <td>昵称：</td>
                        <td><input name="client.name" type="text" value="${client.name}"/></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input name="client.gender" type="text" value="${client.gender}"/></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input name="client.age" type="text" value="${client.age}"/></td>
                    </tr>
                    <tr>
                        <td>邮箱：</td>
                        <td><input name="client.email" type="email" value="${client.email}"/></td>
                    </tr>
                    <tr>
                        <td>头像：</td>
                        <td><img src="${client.imgUrl}" style="float:left" width="50" height="50"><input type="file"
                                                                                                         name="img"/>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <input type="submit" value="确认修改"/>
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>
