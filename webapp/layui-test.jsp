<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript">
        layui.config({
            base: ctxStatic + '/modules/' //你的模块目录
        }).use(['mainNav','element'],function(){
            //var mainNav = layui.mainNav('wori');
        })
    </script>
</head>
<body>
<ul class="layui-nav main-nav" lay-filter="">
    <li class="layui-nav-item"><a href="">最新活动</a></li>
    <li class="layui-nav-item layui-this"><a href="">产品</a></li>
    <li class="layui-nav-item"><a href="">大数据</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">解决方案</a>
        <ul class="layui-nav-child"> <!-- 二级菜单 -->
            <li>
                <a href="">移动模块</a>
            </li>
            <li><a href="">后台模版</a></li>
            <li><a href="">电商平台</a></li>
        </ul>
    </li>
    <li class="layui-nav-item"><a href="">社区</a></li>
</ul>

</body>