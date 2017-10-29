<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/28
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Modify</title>
</head>
<body>
<div>
    <h2>修改用户信息</h2>
    <form action="/manage/manage/modifyCatgory.action?catgoryId=${catgoryId}" method="post" enctype="multipart/form-data">
        <div>
            <table>
                <tr><td>名称：</td><td><input name="catgory.name" type="text" value=""/></td></tr>
                <tr><td>标题：</td><td><input name="catgory.gender" type="text" value=""/></td></tr>
                <tr><td>图像：</td><td><input name="img" type="file" accept="image/gif, image/jpeg"/></td></tr>
            </table>
        </div>
        <div>
            <input  type="submit" value="确认修改"/>
        </div>
    </form>
</div>
</body>
</html>
