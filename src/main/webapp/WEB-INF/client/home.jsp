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
    <input name="personalInformation" value="个人主页" title="个人主页" type="button"/>
</div>
<div>
    <table>
        <tr>
            <c:forEach items="${catgories}" var="catg" varStatus="rowStatus">
                <td><input name="${catg.name}" value="${catg.title}"  type="button" />|</td>
            </c:forEach>
        </tr>
    </table>

</div>
<div>
    <table>
        <c:forEach items="${activities}" var="activity" varStatus="rowStatus">
            <tr>
                <td>
                    <button>
                    <label>${activity.name}</label><br>
                    <label>${activity.time}</label><br>
                    <label>${activity.location}</label><label>人数</label><br>
                    <label>----------------------------------------------</label>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
