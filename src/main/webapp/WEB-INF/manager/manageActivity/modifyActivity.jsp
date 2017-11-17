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
        <h2>修改活动信息</h2>
        <div class="ui-state-highlight"></div><br>
        <form action="/manage/manage/modifyActivity.action" enctype="multipart/form-data" method="post">
            <table>
                <tr>
                    <td colspan="2"><input name="activity.name" placeholder="活动名称(4-20个字)" value="${activity.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>活动时间</td>
                    <td><input name="activity.time" id="startDate" type="text" value="${activity.time}"/></td>
                </tr>
                <tr>
                    <td>活动地点</td>
                    <td><input name="activity.location" type="text" value="${activity.location}"/></td>
                </tr>
                <tr>
                    <td>活动类别</td>
                    <td>
                        <input name="catgoryId" type="text" value="${activity.catgory.id}"/>
                    </td>
                </tr>
                <tr>
                    <td>活动简介</td>
                    <td><textarea name="activity.outline" content="${activity.outline}"></textarea></td>
                </tr>
                <tr>
                    <td>详细介绍</td>
                    <td><textarea name="activity.detail" content="${activity.outline}"></textarea></td>
                </tr>
                <tr>
                    <td>上传图片</td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <c:forEach items="${activity.imgs}" var="img" varStatus="rowStatus">
                            <div style="height: 60px">
                                <img src="${img}" style="float:left" width="50" height="50"/>
                                <input type="file" name="img"/>
                            </div>
                        </c:forEach></td>
                </tr>
            </table>
            <input type="submit" value="确认修改">
        </form>
    </fieldset>
</div>
</body>
</html>
