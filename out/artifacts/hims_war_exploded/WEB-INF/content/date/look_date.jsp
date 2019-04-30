<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看日程</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <s:actionmessage></s:actionmessage>
    <h4>用户 <s:property value="#session.username"></s:property> 的日程：</h4>
    <div style="margin-right: auto; margin-left: auto; width: 850px;">
        <table style="text-align: center; font-family: verdana,arial,sans-serif;
        border-collapse: collapse; border-style: solid; border-width: 1px; color:#333333;
        width: 850px; margin-left: auto; margin-right: auto;">
            <tr>
                <th>日　期</th>
                <th>内　容</th>
                <th>操　作</th>
            </tr>
            <s:iterator value="#request.dates" var="dates" status="st">
                <tr <s:if test="#st.odd">style="background: #bbbbbb"</s:if> >
                    <td><s:property value="date"></s:property></td>
                    <td><s:property value="thing"></s:property></td>
                    <td>
                        <a href="change_date?date.id=<s:property value="id"></s:property>">修改</a>　
                        <a href="delete_date?date.id=<s:property value="id"></s:property>">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
</body>
</html>
