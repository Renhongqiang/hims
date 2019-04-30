<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改日程</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Popt.js"></script>
</head>
<body>
<h1 class="title">个人信息管理系统</h1><hr>
<s:actionmessage></s:actionmessage>
<h4>修改用户 <s:property value="#session.username"></s:property> 的日程：</h4>
<s:form action="change_date_do" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
    <s:textfield name="date.id" value="%{request.date.id}" style="display:none;"></s:textfield>
    <s:textfield name="date.date" label="日程" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="%{request.date.date}"></s:textfield>
    <s:textfield name="date.thing" label="内容"  value="%{request.date.thing}"></s:textfield>
    <s:submit value="提交" ></s:submit>
</s:form>
</body>
</html>
