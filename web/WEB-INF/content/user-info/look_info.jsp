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
    <style>
        span {
            float: left;
            font-size: 16px;
            color: #4d4d4d;
            font-family: 'Microsoft YaHei','SF Pro Display',Roboto,Noto,Arial,'PingFang SC',sans-serif;
        }
    </style>
</head>
<body>
    <h1 style="margin-left: auto;margin-right: auto; width: 400px;">个人信息管理系统</h1><hr>
    <h4>用户 <s:property value="#session.username"></s:property> 的个人信息：</h4>
    <br>
    <div style="margin-left: 150px">
        <span>用户名：<s:property value="#request.user.username" /></span><br><br>
        <span>姓名：<s:property value="#request.user.name" /></span><br><br>
        <span>性别：<s:property value="#request.user.sex" /></span><br><br>
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
