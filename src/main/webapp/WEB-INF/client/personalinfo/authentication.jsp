<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authentication</title>
    <%--<script src="/js/jquery-1.7.2.min.js"></script>--%>
    <link rel="stylesheet" href="/js/jquery-ui-1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="/js/jquery-ui-themes-1.12.1/themes/le-frog/theme.css">
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="/js/myJquery-ui.js"></script>
    <script type="text/javascript">
        function refreshCity() {
            $.ajax({
                type: "POST",
                url: "/client/personalinfo/getCity.action",
                data: {
                    provinceId: $("#provinceId").val()
                },
                dataType: "json",//设置需要返回的数据类型
                success: function (data) {
                    alert(data);
                    var d = eval("(" + data + ")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                    for (var key in d) {
                        $("#cityId").append("<option value='" + key + "'>" + d[key] + "</option>");
                    }
                },
                error: function () {
                    alert("系统异常，请稍后重试！");
                }
            });
        }
    </script>
</head>
<body>
<div class="ui-widget">
    <h2>个人实名认证</h2>
    <div class="ui-state-highlight"></div><br>
    <form action="/client/personalinfo/authentication.action" method="post">

                    <fieldset style="width: 40%">
                        <legend>认证地区</legend>
                        <label for="radio-1">大陆</label>
                        <input name="message.location" type="radio" id="radio-1">
                        <label for="radio-2">港澳</label>
                        <input name="message.location" type="radio" id="radio-2">
                        <label for="radio-3">台湾</label>
                        <input name="message.location" type="radio" id="radio-3">
                        <label for="radio-4">海外</label>
                        <input name="message.location" type="radio" id="radio-4">
                    </fieldset>

                    <fieldset style="width: 40%">
                        <legend>认证方式</legend>
                        <label for="radio1-1">微信认证</label>
                        <input name="message.mode" type="radio" id="radio1-1">
                        <label for="radio1-2">QQ认证</label>
                        <input name="message.mode" type="radio"  id="radio1-2">
                    </fieldset>

                    <fieldset style="width: 40%">
                        <legend>真实姓名</legend>
                        <input name="message.realName" type="text" placeholder="请填写身份证上的姓名">
                    </fieldset>

                    <fieldset style="width: 40%">
                        <legend>身份证号</legend>
                        <input name="message.idcard" type="text" placeholder="请填写18位二代身份证号码">
                    </fieldset>

                    <fieldset style="width:40%">
                        <legend>通信地址</legend>
                        <select name="provinceId" id="provinceId" onchange="refreshCity()">
                            <option value="0">请选择</option>
                            <c:forEach items="${provinces}" var="province" varStatus="rowStatus">
                                <option value="${province.id}">${province.value}</option>
                            </c:forEach>
                        </select><br><br>
                        <select name="message.cityId" id="cityId">
                            <option value="0">请选择</option>
                        </select><br><br>
                        <input name="message.address" type="text" placeholder="通讯地址为2-60个字符且不能包含特殊字符"
                               autocomplete="off">
                    </fieldset>
                    <div>
                    <label>该方式为系统自动审核，将实时反馈审核结果</label>
                    </div>
        <input type="submit" value="提交审核">
    </form>
</div>
</body>
</html>
