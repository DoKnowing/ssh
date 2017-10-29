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
</head>
<body>
<div>
    <a href="/client/personalinfo/modifyImgUrlPage.action"><img src="${client.imgUrl}"/></a>
</div>
<div>
    <table>
        <tr><td>昵称：</td><td>${client.name}</td></tr>
        <tr><td>性别：</td><td>${client.gender}</td></tr>
        <tr><td>年龄：</td><td>${client.age}</td></tr>
        <%if(((Client)request.getAttribute("client")).getIsAuthenticated()==1){%>
        <tr><td>学校：</td><td>${client.institution}</td></tr>
        <%}else{%>
        <tr><td>学校：</td><td></td></tr>
        <%}%>
        <tr><td>邮箱：</td><td>${client.email}</td></tr>
        <tr><td  style="color:#007fff"><a href="/client/personalinfo/authPage.action"><input name="authentication" type="button" value="学生认证"/></a></td>
            <%if(((Client)request.getAttribute("client")).getIsAuthenticated()==0){%>
                <td style="background-color: #c5c5c5;color: white">未认证</td>
            <%}else{%>
                <td style="background-color: limegreen;color: white">已认证</td>
            <%}%>
        </tr>
        <tr><td colspan="2"><a href="/client/manage/myCreaActPage.action"><input name="myCreatedActivity" type="button" value="我创建的活动"/></a></td></tr>
        <tr><td colspan="2"><a href="/client/manage/myPartActPage.action"><input name="myParticipatedActivity" type="button" value="我参加的活动"/></a></td></tr>
        <tr><td colspan="2"><a href="/client/personalinfo/modifyPersonalInfoPage.action"><input name="modifyPersonalInfo" type="button" value="修改个人信息"/></a></td></tr>
    </table>
</div>
</body>
</html>
