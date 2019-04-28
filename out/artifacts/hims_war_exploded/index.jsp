<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/26
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <style>
      .errorMessage {
        color: red;
      }
    </style>
  </head>
  <body>
    <s:actionmessage></s:actionmessage>

    <h3 style="margin-left:auto; margin-right:auto; width:300px;">请登录</h3>
    <hr>
    <s:form action="login" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
      <s:textfield name="user.username" label="用户名" value="%{request.username}"></s:textfield>
      <s:password name="user.password" label="密　码"></s:password>
      <s:submit value="登录" ></s:submit>
    </s:form>
    <a href="/register_page" style="margin-left:auto; margin-right:auto; width:300px; display: block;">没有账号?去注册</a>
  <s:debug></s:debug>
  </body>
</html>
