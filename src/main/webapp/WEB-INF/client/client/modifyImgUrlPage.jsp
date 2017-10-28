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
</head>
<body>
<div>
    <form name="/client/modifyImgUrl.action" method="post"  enctype="multipart/form-data">
        <input name="img" type="file" accept="image/gif, image/jpeg"/>
        <input type="submit" value="确认修改"/>
    </form>
</div>
</body>
</html>
