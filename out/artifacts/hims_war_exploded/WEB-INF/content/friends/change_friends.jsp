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
    <title>修改联系人</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Popt.js"></script>
    <script type="text/javascript" src="/js/city.json.js"></script>
    <script type="text/javascript" src="/js/citySet.js"></script>
</head>
<body>
<h1 class="title">个人信息管理系统</h1><hr>
<s:actionmessage></s:actionmessage>
<h4>修改用户 <s:property value="#session.username"></s:property> 的联系人：</h4>
<s:form action="change_friend_do" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
    <s:textfield name="friends.id" value="%{request.friends.id}" style="display:none;"></s:textfield>
    <s:textfield name="friends.name" label="联系人姓名"  value="%{request.friends.name}"></s:textfield>
    <s:textfield name="friends.phone" label="联系人电话"  value="%{request.friends.phone}"></s:textfield>
    <s:textfield name="friends.qq" label="联系人QQ　"  value="%{request.friends.qq}"></s:textfield>
    <s:textfield name="friends.email" label="联系人邮箱"  value="%{request.friends.email}"></s:textfield>
    <s:textfield name="friends.workplace" label="联系人单位"  value="%{request.friends.workplace}"></s:textfield>
    <s:textfield name="friends.place" label="联系人住址" value="%{request.friends.place}"  class="input" id="city" placeholder="请选择" autocomplete="off" readonly="true"></s:textfield>
    <s:submit value="提交" ></s:submit>
</s:form>
</body>
<script type="text/javascript">
    $("#city").click(function (e) {
        SelCity(this,e);
    });
    $("s").click(function (e) {
        SelCity(document.getElementById("city"),e);
    });

    //为家庭住址 input 动态添加父 div 节点，设置class="wrap"
    var city = document.querySelector("#city");
    var city_div = document.createElement("div");
    var city_father = city.parentNode;
    city_div.className = "wrap";
    city_father.removeChild(city);
    city_div.appendChild(city);
    city_father.appendChild(city_div);
    //        var s = document.createElement("s");
    //        city_father.appendChild(s);

</script>
</html>
