<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/26
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Create Activity</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/js/manage_index_date.js"></script>
</head>
<body>
<div>
    <form action="/client/operate/createActivity.action" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td colspan="2"><input name="activity.name" placeholder="活动名称(4-20个字)"/></td>
            </tr>
            <tr>
                <td>活动时间</td>
                <td><input name="activity.time" id="startDate" type="text"/></td>
            </tr>
            <tr>
                <td>活动地点</td>
                <td><input name="activity.location" type="text"/></td>
            </tr>
            <tr>
                <td>活动类别</td>
                <td>
                    <select name="catgoryId">
                        <c:forEach items="${catgories}"  var="catgory" varStatus="rowStatus">
                            <option value="${catgory.id}">${catgory.title}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>活动简介</td>
                <td><textarea name="activity.outline"></textarea></td>
            </tr>
            <tr>
                <td>详细介绍</td>
                <td><textarea name="activity.detail"></textarea></td>
            </tr>
            <tr>
                <td>上传图片</td><td>
                <input type="file" name="img"/>
                <input type="file" name="img"/>
                <input type="file" name="img"/></td>
            </tr>
        </table>
        <input type="submit" value="发布">
    </form>

</div>
</body>
</html>
