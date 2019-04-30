<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/30
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看文件</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <h1 class="title">个人信息管理系统</h1><hr>
    <s:actionmessage></s:actionmessage>
    <h4>用户 <s:property value="#session.username"></s:property> 的文件：</h4>
    <div style="margin-right: auto; margin-left: auto; width: auto;">
        <table style="text-align: center; font-family: verdana,arial,sans-serif;
        border-collapse: collapse; border-style: solid; border-width: 1px; color:#333333;
        width: 1000px; margin-left: auto; margin-right: auto;">
            <tr>
                <th>文件标题</th>
                <th>文件名</th>
                <th>文件类型</th>
                <th>文件大小</th>
                <th>操　　作</th>
            </tr>
            <s:iterator value="#request.files" var="files" status="st">
                <tr <s:if test="#st.odd">style="background: #bbbbbb"</s:if> >
                    <td><s:property value="title"></s:property></td>
                    <td><s:property value="name"></s:property></td>
                    <td><s:property value="contenttype"></s:property></td>
                    <td><s:property value="size"></s:property></td>
                    <td>
                        <a href="download_file?file.id=<s:property value="id"></s:property>">下载</a>　
                        <a href="delete_file?file.id=<s:property value="id"></s:property>">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
</body>
</html>
