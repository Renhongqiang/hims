<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <s:actionmessage></s:actionmessage>
    <h4>修改用户 <s:property value="#session.username"></s:property> 的密码：</h4>
    <s:form action="change_password_do" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
        <s:password name="oldpassword" label="旧密码　"></s:password>
        <s:password name="newpassword" label="新密码　"></s:password>
        <s:password name="repassword" label="确认密码"></s:password>
        <s:submit value="修改" ></s:submit>
    </s:form>
</body>
</html>
