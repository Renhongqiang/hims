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
    <title>查看通讯录</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <s:actionmessage></s:actionmessage>
    <h4>用户 <s:property value="#session.username"></s:property> 的联系人：</h4>
    <div style="margin-right: auto; margin-left: auto; width: 850px;">
        <s:form action="find_friend" theme="simple" style="display: inline; float: right;">
            <s:submit value="显示全部"></s:submit>
            <s:textfield name="friends.name" value="" style="display:none;"></s:textfield>
        </s:form>　　
        <s:form action="find_friend" theme="simple" style="display: inline; float: right;">
            <s:submit value="查找"></s:submit>
            <s:textfield name="friends.name"></s:textfield>
        </s:form>
        <br>
        <table style="text-align: center; font-family: verdana,arial,sans-serif;
        border-collapse: collapse; border-style: solid; border-width: 1px; color:#333333;
        width: 850px; margin-left: auto; margin-right: auto;">
            <tr>
                <th>姓　名</th>
                <th>电　话</th>
                <th>Q　Q</th>
                <th>邮　箱</th>
                <th>工作单位</th>
                <th>家庭住址</th>
                <th>操　作</th>
            </tr>
            <s:iterator value="#request.friendsList" var="friends" status="st">
                <tr <s:if test="#st.odd">style="background: #bbbbbb"</s:if> >
                    <td><s:property value="name"></s:property></td>
                    <td><s:property value="phone"></s:property></td>
                    <td><s:property value="qq"></s:property></td>
                    <td><s:property value="email"></s:property></td>
                    <td><s:property value="workplace"></s:property></td>
                    <td><s:property value="place"></s:property></td>
                    <td>
                        <a href="change_friend?friends.id=<s:property value="id"></s:property>">修改</a>　
                        <a href="delete_friend?friends.id=<s:property value="id"></s:property>">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
</body>
</html>
