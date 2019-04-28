<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rhq
  Date: 2019/4/27
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <link rel="stylesheet" type="text/css" href="/css/nav.css">
    <link rel="stylesheet" type="text/css" href="/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/font/iconfont1.css">

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/nav.js"></script>
</head>
<body>

    <div class="container">
        <div class="nav">
            <div class="nav-top">
                <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)">
                    <img class="headpic"  src="/images/mini.png">
                    <span id="top-span" class="top-span">用户：<s:property value="session.username"></s:property></span>
                </div>
            </div>
            <ul>
                <li class="nav-item">
                    <a href="javascript:;"><i class="iconfont icon-shezhi"></i><span>个人信息</span><i class="my-icon nav-more"></i></a>
                    <ul>
                        <li><a href= "look_info " target= "iFrame1"><span>查看信息</span></a></li>
                        <li><a href="change_info" target= "iFrame1"><span>修改信息</span></a></li>
                        <li><a href="change_password" target= "iFrame1"><span>修改密码</span></a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;"><i class="iconfont icon-renyuan"></i><span>通讯录管理</span><i class="my-icon nav-more"></i></a>
                    <ul>
                        <li><a href="javascript:;" target= "iFrame1"><span>查看通讯录</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>添加联系人</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>修改联系人</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>删除联系人</span></a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;"><i class="iconfont icon-changyonggoupiaorenbianji"></i><span>日程管理</span><i class="my-icon nav-more"></i></a>
                    <ul>
                        <li><a href="javascript:;" target= "iFrame1"><span>查看日程</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>增加日程</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>修改和删除</span></a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-wenjian1"></i><span>个人文件</span>
                        <i class="my-icon nav-more"></i>
                    </a>
                    <ul>
                        <li><a href="javascript:;" target= "iFrame1"><span>查看文件</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>目录操作</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>上传下载</span></a></li>
                        <li><a href="javascript:;" target= "iFrame1"><span>修改信息</span></a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#"><span>退出登录</span>&nbsp;<i class="iconfont icon-tuichu1"></i></a>
                </li>
            </ul>
        </div>

        <div class="maindiv" id="test">
            <iframe id="frameContentRight" name= "iFrame1" src="welcome"></iframe>
        </div>
    </div>

</body>
</html>
