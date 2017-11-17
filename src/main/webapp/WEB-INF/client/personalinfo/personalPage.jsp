<%@ page import="common.model.Client" %><%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>PersonalPage</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
    <script type="text/javascript">
        function modifyImg() {
            $(location).attr('href', '/client/personalinfo/modifyImgUrlPage.action');
        }
    </script>
</head>
<body>
<div class="ui-widget">
    <br>
    <div align="right"><a href="/client/base/homePage.action">返回主页</a></div>
    <br>
    <div class="ui-state-highlight"></div>
    <br>

    <fieldset>
        <legend>个人信息</legend>
    <table>
        <tr><td colspan="2"><img src="${client.imgUrl}" style="float:left" width="50" height="50" onclick="modifyImg()"/></td></tr>
        <tr><td>昵称：</td><td>${client.name}</td></tr>
        <tr><td>性别：</td><td>${client.gender}</td></tr>
        <tr><td>年龄：</td><td>${client.age}</td></tr>
        <%if(((Client)request.getAttribute("client")).getIsAuthenticated()==1){%>
        <tr><td>学校：</td><td>${client.institution}</td></tr>
        <%}else{%>
        <tr><td>学校：</td><td></td></tr>
        <%}%>
        <tr><td>邮箱：</td><td>${client.email}</td></tr>
        <tr><td  style="color:#007fff"><a href="/client/personalinfo/authPage.action">学生认证</a></td>
            <%if(((Client)request.getAttribute("client")).getIsAuthenticated()==0){%>
                <td style="background-color: #c5c5c5;color: white">未认证</td>
            <%}else{%>
                <td style="background-color: limegreen;color: white">已认证</td>
            <%}%>
        </tr>
        <tr><td colspan="2"><a href="/client/manage/myCreaActPage.action">我创建的活动</a></td></tr>
        <tr><td colspan="2"><a href="/client/manage/myPartActPage.action">我参加的活动</a></td></tr>
        <tr><td colspan="2"><a href="/client/personalinfo/modifyPersonalInfoPage.action">修改个人信息</a></td></tr>
    </table>
    </fieldset>
</div>
</body>
</html>
