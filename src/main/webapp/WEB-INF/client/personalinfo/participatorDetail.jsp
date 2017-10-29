<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Participator</title>
</head>
<body>
<div>
    <img name="img" src="${participator.imgUrl}"/>
</div>
<div>
    <table>
        <tr><td>姓名：</td><td>${participator.name}</td></tr>
        <tr><td>年龄：</td><td>${participator.age}</td></tr>
        <tr><td>性别：</td><td>${participator.gender}</td></tr>
        <tr><td>学校：</td><td>${participator.institution}</td></tr>
    </table>
</div>
</body>
</html>
