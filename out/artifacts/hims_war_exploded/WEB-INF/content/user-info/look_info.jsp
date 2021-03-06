<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看信息</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <h4>用户 <s:property value="#session.username"></s:property> 的个人信息：</h4>
    <br>
    <div style="margin-left: 150px">
        <span>用户名：<s:property value="#request.user.username" /></span><br><br>
        <span>姓名：<s:property value="#request.user.name" /></span><br><br>
        <span>性别：
            <s:if test='#request.user.sex=="f"'>
                女
            </s:if>
            <s:elseif test='#request.user.sex=="m"'>
                男
            </s:elseif>
        </span><br><br>
        <span>生日：<s:property value="#request.user.birth" /></span><br><br>
        <span>民族：<s:property value="#request.user.nation" /></span><br><br>
        <span>学历：<s:property value="#request.user.edu" /></span><br><br>
        <span>职称：<s:property value="#request.user.work" /></span><br><br>
        <span>电话：<s:property value="#request.user.phone" /></span><br><br>
        <span>邮箱：<s:property value="#request.user.email" /></span><br><br>
        <span>住址：<s:property value="#request.user.place" /></span><br><br>
    </div>
</body>
</html>
