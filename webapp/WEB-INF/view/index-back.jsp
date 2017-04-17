<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head-back.jsp" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#logoutButton').click(function(){
                $.messager.confirm('', '确定退出系统?', function(r){
                    if (r){
                        window.location.href = '${ctx}/logout'
                    }
                });
            });
        });
    </script>
</head>
<body class="easyui-layout" style="text-align:left">
<script src="${ctxStatic}/echarts/dist/echarts.js"></script>
<script type="text/javascript">
    var echartTheme;
    require.config({
        paths: {
            echarts: '${ctxStatic}/echarts/dist'
        }
    });
    require(
            [
                'echarts',
                'echarts/theme/helianthus',
                'echarts/chart/bar',
                'echarts/chart/pie',
                'echarts/chart/line'
            ],
            function (ec, theme) {
                // 基于准备好的dom，初始化echarts图表
                echartTheme = theme;
                /*var instoreChart = ec.init($('.chart-container.instore')[0], theme);

                instoreChart.setOption(instoreOptsModel);

                var ecConfig = require('echarts/config');
                instoreChart.on(ecConfig.EVENT.CLICK, eConsole);*/
            }
    );
    var ecConfig = require('echarts/config');
</script>
<div region="north" border="false" class="group wrap header" style="height:66px;font-size:100%">
    <div class="content">
        <div class="navigation-toggle" data-tools="navigation-toggle" data-target="#navbar-1">
            <span>EasyUI</span>
        </div>
        <div id="elogo" class="navbar navbar-left" style="padding-top: 5px">
            <ul>
                <li>
                    <span href="#" style="color:white;font-family: 'Microsoft YaHei UI'"><i class="e-icon fa fa-2x fa-medkit"></i>&nbsp;&nbsp;&nbsp;药品监督系统</span>
                </li>
            </ul>
        </div>
        <div id="navbar-1" class="navbar navbar-right">
            <ul>
                <%--<li><a href="javascript:void(0);">Home</a></li>
                <li><a href="javascript:void(0);">Demo</a></li>
                <li><a href="javascript:void(0);">Tutorial</a></li>
                <li><a href="javascript:void(0);">Documentation</a></li>
                <li><a href="javascript:void(0);">Download</a></li>
                <li><a href="javascript:void(0);">Extension</a></li>--%>
                <li><span class="user-content">您好：${user.userName}</span></li>
                <li><a id="logoutButton" href="javascript:void(0);">退出系统</a></li>
            </ul>
        </div>
        <div style="clear:both"></div>
    </div>
</div>
<div region="west" split="true" title="系统菜单" style="width:20%;min-width:180px;padding:5px;">
    <ul class="menu-tree"></ul>
</div>
<div region="center">
    <div id="mainTabs">
        <div title="welcome" class="content-doc" data-options="iconCls:'e-icon fa fa-edit'">
            <%--<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
                <header><i class='fa fa-user'></i>   入库信息汇总统计</header>
                <div class="chart-container year"></div>
                <div class="chart-container season"></div>
                <div class="chart-container month"></div>
            </div>--%>
        </div>
    </div>
</div>
<div id="gridDialog" style="width:500px;height:400px"><table id="grid"></table></div>
<div id="cycleSearch-dialog" style="width:220px;height:120px"></div>
</body>