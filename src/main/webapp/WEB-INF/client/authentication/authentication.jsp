<%--
  Created by IntelliJ IDEA.
  User: lq
  Date: 2017/10/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Authentication</title>
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function refreshCity() {
            $.ajax({
                type: "POST",
                url: "/client_address/getCity.action",
                data:{
                    provinceId:$("#provinceId").val()
                },
                dataType: "json",//设置需要返回的数据类型
                success: function (data) {
                    alert(data);
                    var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                    for (var key in d) {
                        $("#cityId").append("<option value='" + key + "'>" + d[key] + "</option>");
                    }
                },
                error:function(){
                    alert("系统异常，请稍后重试！");
                }
            });
        }
    </script>
</head>
<body>
<div>
    <h2>个人实名认证</h2>
    <form action="/client/authentication.action" method="post">
        <table>
            <tr>
                <td>认证地区</td>
                <td>
                    <input name="message.location" type="radio" value="大陆">大陆
                    <input name="message.location" type="radio" value="港澳">港澳
                    <input name="message.location" type="radio" value="台湾">台湾
                    <input name="message.location" type="radio" value="海外">海外
                </td>
            </tr>
            <tr>
                <td>认证方式</td>
                <td>
                    <input name="message.mode" type="radio" value="微信认证">微信认证
                    <input name="message.mode" type="radio" value="QQ认证">QQ认证
                </td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td>
                    <input name="message.realName" type="text" placeholder="请填写身份证上的姓名">
                </td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td>
                    <input name="message.idcard" type="text" placeholder="请填写18位二代身份证号码">
                </td>
            </tr>
            <tr>
                <td>通信地址</td>
                <td>
                    <select name="provinceId" id="provinceId" onchange="refreshCity()">
                        <option value="0">请选择</option>
                        <c:forEach items="${provinces}" var="province" varStatus="rowStatus">
                            <option value="${province.id}">${province.value}</option>
                        </c:forEach>
                    </select>
                    <select name="message.cityId" id="cityId">
                        <option value="0">请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input name="message.address" type="text" placeholder="通讯地址为2-60个字符且不能包含特殊字符" autocomplete="off">
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    该方式为系统自动审核，将实时反馈审核结果
                </td>
            </tr>
        </table>
        <input type="submit" value="提交审核">
    </form>
</div>
</body>
</html>
