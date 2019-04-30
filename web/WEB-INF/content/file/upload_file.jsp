<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/30
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <s:actionmessage></s:actionmessage>
    <s:fielderror></s:fielderror>
    <h4>上传用户 <s:property value="#session.username"></s:property> 的文件：</h4>
    <div style="margin-right: auto; margin-left: auto; width: 500px;">
        <s:form action="upload_file_do" enctype="multipart/form-data" theme="simple">
            文件标题: <s:textfield name="file.title" ></s:textfield><br><br>
            选择文件: <s:file name="upload"></s:file><br><br>
            <s:submit value="上传"></s:submit>
        </s:form>
    </div>
</body>
</html>
