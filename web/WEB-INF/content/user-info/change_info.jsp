<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/28
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
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
    <h4>修改用户 <s:property value="#session.username"></s:property> 的个人信息：</h4>
    <s:form action="change_info_do" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
        <s:textfield name="user.id" value="%{request.user.id}" style="display:none;"></s:textfield>
        <s:textfield name="user.username" label="用户名　" value="%{request.user.username}"></s:textfield>
        <s:textfield name="user.name" label="真实姓名" value="%{request.user.name}"></s:textfield>
        <s:radio list="#{'m':'男','f':'女'}" name="user.sex" value="%{request.user.sex}" label="性　　别"/>
        <s:textfield name="user.birth" label="生　　日" value="%{request.user.birth}" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></s:textfield>
        <s:textfield name="user.nation" label="民　　族" value="%{request.user.nation}"></s:textfield>
        <s:textfield name="user.edu" label="学　　历" value="%{request.user.edu}"></s:textfield>
        <s:textfield name="user.work" label="职　　称" value="%{request.user.work}"></s:textfield>
        <s:textfield name="user.phone" label="电　　话" value="%{request.user.phone}"></s:textfield>
        <s:textfield name="user.email" label="邮　　箱" value="%{request.user.email}"></s:textfield>
        <s:textfield name="user.place" label="家庭住址" value="%{request.user.place}" class="input" id="city" placeholder="请选择" autocomplete="off" readonly="true"></s:textfield>
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
