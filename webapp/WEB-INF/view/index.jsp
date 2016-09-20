<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript">
        $(document).ready(function () {

        });
    </script>
</head>
<body class="easyui-layout" style="text-align:left">
<div region="north" border="false" class="group wrap header" style="height:66px;font-size:100%">
    <div class="content">
        <div class="navigation-toggle" data-tools="navigation-toggle" data-target="#navbar-1">
            <span>EasyUI</span>
        </div>
        <div id="elogo" class="navbar navbar-left">
            <ul>
                <li>
                    <span href="#" style="color:white"><i class="e-icon fa fa-2x fa-medkit"></i>&nbsp;&nbsp;&nbsp;Drug Monitor System</span>
                </li>
            </ul>
        </div>
        <div id="navbar-1" class="navbar navbar-right">
            <ul>
                <li><a href="javascript:void(0);">Home</a></li>
                <li><a href="javascript:void(0);">Demo</a></li>
                <li><a href="javascript:void(0);">Tutorial</a></li>
                <li><a href="javascript:void(0);">Documentation</a></li>
                <li><a href="javascript:void(0);">Download</a></li>
                <li><a href="javascript:void(0);">Extension</a></li>
                <li><a href="javascript:void(0);">Contact</a></li>
                <li><a href="javascript:void(0);">Forum</a></li>
            </ul>
        </div>
        <div style="clear:both"></div>
    </div>
</div>
<div region="west" split="true" title="系统管理" style="width:20%;min-width:180px;padding:5px;">
    <ul class="menu-tree"></ul>
</div>
<div region="center">
    <div id="mainTabs" class="easyui-tabs" fit="true" border="false" plain="true">
        <div title="welcome" class="content-doc" data-options="iconCls:'e-icon fa fa-edit'"></div>
    </div>
</div>
</body>