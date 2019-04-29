<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Popt.js"></script>
    <script type="text/javascript" src="/js/city.json.js"></script>
    <script type="text/javascript" src="/js/citySet.js"></script>
</head>
<body>
    <s:actionmessage></s:actionmessage>
    <h3 style="margin-left:auto; margin-right:auto; width:300px;">请输入注册信息：</h3>
    <hr>
    <s:form action="register" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
        <s:textfield name="user.username" label="用户名　"></s:textfield>
        <s:password name="user.password" label="密　码　"></s:password>
        <s:password name="repassword" label="确认密码"></s:password>
        <s:textfield name="user.name" label="真实姓名"></s:textfield>
        <s:radio list="#{'m':'男','f':'女'}" name="user.sex" value="m" label="性　　别"/>
        <s:textfield name="user.birth" label="生　　日" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></s:textfield>
        <s:textfield name="user.nation" label="民　　族"></s:textfield>
        <s:textfield name="user.edu" label="学　　历"></s:textfield>
        <s:textfield name="user.work" label="职　　称"></s:textfield>
        <s:textfield name="user.phone" label="电　　话"></s:textfield>
        <s:textfield name="user.email" label="邮　　箱"></s:textfield>
        <s:textfield name="user.place" label="家庭住址" class="input" id="city" placeholder="请选择" autocomplete="off" readonly="true"></s:textfield>
        <s:submit value="注册" ></s:submit>
    </s:form>
    <a href="/index.jsp" style="margin-left:auto; margin-right:auto; width:300px; display: block;">登录</a>

    <%--<div class="wrap"><input class="input" name="" id="city" type="text" placeholder="请选择" autocomplete="off" readonly="true"><s></s></div>--%>

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
</body>
</html>
