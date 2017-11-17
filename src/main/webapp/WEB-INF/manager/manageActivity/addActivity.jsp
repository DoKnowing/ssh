<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/28
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Activity</title>
    <%--<link rel="stylesheet" href="/js/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>--%>
    <%--<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>--%>
    <%--<script type="text/javascript" src="/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>--%>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myManJquery-ui.js"></script>
    <script type="text/javascript" src="/js/manage_index_date.js"></script>
</head>
<body>
<div class="ui-widget">
    <fieldset>
        <h2>增加活动</h2>
        <div class="ui-state-highlight"></div>
        <br>
        <form action="/manage/manage/addActivity.action?catgoryId=${catgoryId}" enctype="multipart/form-data"
              method="post">
            <table>
                <tr>
                    <td colspan="2"><input name="activity.name" placeholder="活动名称(4-20个字)"/></td>
                </tr>
                <tr>
                    <td>发起人邮箱</td>
                    <td><input name="email" id="email" type="email"/></td>
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
                            <c:forEach items="${catgories}" var="catgory" varStatus="rowStatus">
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
                    <td>上传图片</td>
                    <td>
                        <input name="img" type="file" accept="image/gif, image/jpeg"/><br>
                        <input name="img" type="file" accept="image/gif, image/jpeg"/><br>
                        <input name="img" type="file" accept="image/gif, image/jpeg"/></td>
                </tr>
            </table>
            <input type="submit" value="确认添加">
        </form>
    </fieldset>
</div>
</body>
</html>
