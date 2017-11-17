<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/22
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
</head>
<body>
<div class="ui-widget" align="left">
    <br>
    <div>
        <a href="/client/personalinfo/personalPage.action">个人主页</a>
    </div>
    <br>
    <div class="ui-state-highlight"></div>
    <br>
    <div>
        <fieldset>
            <legend>活动类别</legend>
            <c:forEach items="${catgories}" var="catg" varStatus="rowStatus">
                <a href="/client/operate/activity_byCatgory.action?catgoryId=${catg.id}">
                    <img src="${catg.urlImage}" width="45" height="45"/><br>
                        ${catg.title}
                </a>|
            </c:forEach>
        </fieldset>
    </div>
    <div>
        <fieldset>
            <legend>本学校的活动</legend>

            <table>
                <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
                    <tr>
                        <td style="height: 125px">
                            <a href="/client/operate/detailPage.action?activityId=${activity.id}" style="width: 500px;height:98px">
                                <div style="margin-left: 0;position: absolute">
                                    <img src="${activity.imgs[0]}" height="100" width="130"/>
                                </div>
                                <div style="margin-left: 130px">
                                <label>${activity.name}</label><br>
                                <label>${activity.time}</label><br>
                                <label>${activity.location}</label><br>
                                <label>人数：</label>
                                </div>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </div>
</div>
</body>
</html>
