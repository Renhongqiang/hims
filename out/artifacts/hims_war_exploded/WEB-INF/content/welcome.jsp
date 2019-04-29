<%@ page import="com.hims.bean.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <h1 style="margin-left: auto;margin-right: auto; width:400px;">欢迎登陆个人信息管理系统</h1>
    <hr><br>
    当前用户：<s:property value="#session.username"></s:property>
    <br>
    <s:bean name="java.util.Date" var="time">
        <s:date name="time" format="yyyy-MM-dd"></s:date>
    </s:bean>
</body>
</html>
