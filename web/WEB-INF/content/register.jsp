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
    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Popt.js"></script>
    <script type="text/javascript" src="/js/city.json.js"></script>
    <script type="text/javascript" src="/js/citySet.js"></script>

    <style type="text/css">
        * { -ms-word-wrap: break-word; word-wrap: break-word; }
        html { -webkit-text-size-adjust: none; text-size-adjust: none; }
        html, body {height:99%;width:99%; }
        .wrap{border:0;position:relative;margin-top: -10px;}
        .input{position:absolute;top:0;left:0;margin:0;padding-left:0px;width: 174;height:22px;line-height:22px;font-size:12px;border:1px
        solid #c9cacb;}
        s{position:absolute;top:0px;left:172px;width:24px;height:24px;background:url("img/arrow.png") no-repeat;
            background-size: cover;}
        ._citys { background: #ebebeb; width: 450px; display: inline-block; border: 2px solid #eee; padding: 5px; position: relative; }
        ._citys span { color: #cfcfcf; height: 15px; width: 15px; line-height: 15px; text-align: center; border-radius: 3px;
            position: absolute; right: 10px; top: 10px; border: 1px solid #cfcfcf; cursor: pointer; }
        ._citys0 { width: 95%; height: 34px; line-height: 34px; display: inline-block; border-bottom: 2px solid #cfcfcf;
            padding: 0px 5px; font-size:14px; font-weight:bold; margin-left:6px; }
        ._citys0 li { display: inline-block; line-height: 34px; font-size: 15px; color: #888; width: 80px; text-align: center;
            cursor: pointer; }
        ._citys1 { width: 100%; display: inline-block; padding: 10px 0; }
        ._citys1 a { width: 83px; height: 35px; display: inline-block; background-color: #f5f5f5; color: #666; margin-left:
                6px; margin-top: 3px; line-height: 35px; text-align: center; cursor: pointer; font-size: 12px; border-radius: 5px;
            overflow: hidden; }
        ._citys1 a:hover { color: #fff; background-color: #eb0000; }
        .AreaS { background-color: #cfcfcf !important; color: #fff !important; }
    </style>

</head>
<body>
    <h3 style="margin-left:auto; margin-right:auto; width:300px;">请输入注册信息：</h3>
    <hr>
    <s:form action="register" validate="true" theme="xhtml" style="margin-left:auto; margin-right:auto; width:300px;">
        <s:textfield name="user.username" label="用户名　"></s:textfield>
        <s:password name="user.password" label="密　码　"></s:password>
        <s:password name="repassword" label="确认密码"></s:password>
        <s:textfield name="user.name" label="真实姓名"></s:textfield>
        <s:radio list="#{'m':'男','f':'女'}" name="user.sex" value="1" label="性　　别"/>
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
