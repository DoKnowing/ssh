<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/23
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CatgoryActivity</title>
    <%--日期控件若要生效，一定要注意两个问题：--%>
    <%--1.脚本文件的路径要对，若对了按control键可以从连接点进去；--%>
    <%--2.一定要导入ui.css和ui.js文件--%>
    <%--<link rel="stylesheet" href="/js/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>--%>
    <%--<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>--%>
    <%--<script type="text/javascript" src="/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>--%>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
    <script type="text/javascript" src="/js/manage_index_date.js"></script>
</head>
<body>
<div class="ui-widget">
    <br>
    <div align="right"><a href="/client/base/homePage.action">返回主页</a></div>
    <br>
    <div class="ui-state-highlight"></div>
    <br>
    <fieldset>
        <legend>相关操作</legend>
        <form action="/client/operate/activity_byDate.action" method="post">
            <label>按日期查询活动：</label><br>
            <label>起始日期：</label> <input name="startDate" id="startDate" type="text"/>
            <label>终止日期：</label> <input name="endDate" id="endDate" type="text"/><input type="submit" value="查询"/>
        </form>
        <div align="right"><a href="/client/operate/creaActPage.action">创建活动</a></div>

    </fieldset>
    <fieldset>
        <legend>当前类型的活动</legend>
        <table>
            <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
                <tr>
                    <td>
                        <a href="/client/operate/detailPage.action?activityId=${activity.id}">
                                ${activity.name}<br>
                                ${activity.time}<br>
                                ${activity.location}<br>
                            人数<br>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
