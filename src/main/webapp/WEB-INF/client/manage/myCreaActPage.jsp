<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Activity</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget">
    <br>
    <div align="right"><a href="/client/base/homePage.action">返回主页</a></div>
    <br>
    <div class="ui-state-highlight"></div>
    <br>
    <fieldset>
        <legend>我发起的活动</legend>
        <table>
            <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
                <tr>
                    <td>
                        <a href="/client/manage/myActivityDetailPage.action?activityId=${activity.id}">
                            <label>${activity.name}</label>
                        </a>
                    </td>
                    <td>
                        <a href="/client/manage/closeActivity.action?activityId=${activity.id}">
                            <label>关闭活动</label>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>

</body>
</html>
