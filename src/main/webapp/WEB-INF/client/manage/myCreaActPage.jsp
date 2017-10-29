<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/24
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Activity</title>
</head>
<body>
<div>
    <h2>我发起的活动</h2>
    <table>
        <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
            <tr>
                <td>
                    <a href="/client/manage/myActivityDetailPage.action?activityId=${activity.id}">
                        <button>
                            <label>${activity.name}</label>
                        </button>
                    </a>
                </td>
                <td>
                    <a href="/client/manage/closeActivity.action?activityId=${activity.id}">
                        <button>
                            <label>关闭活动</label>
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
