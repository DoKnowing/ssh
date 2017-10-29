<%--
  Created by IntelliJ IDEA.
  User: 73708
  Date: 2017/10/22
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div>
    <a href="/client/personalinfo/personalPage.action"><input name="personalInformation" value="个人主页" title="个人主页" type="button"/></a>
</div>
<div>
    <table>
        <tr><td>本学校的活动</td></tr>
        <tr>
            <c:forEach items="${catgories}" var="catg" varStatus="rowStatus">
                <td><a href="/client/operate/activity_byCatgory.action?catgoryId=${catg.id}"><input type="button" value="${catg.title}"/></a>|</td>
            </c:forEach>
        </tr>
    </table>

</div>
<div>
    <table>
        <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
            <tr>
                <td>
                    <a href="/client/operate/detailPage.action?activityId=${activity.id}">
                        <button>
                        <label>${activity.name}</label><br>
                        <label>${activity.time}</label><br>
                        <label>${activity.location}</label><label>人数：</label><br>
                        <label>----------------------------------------------</label>
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
