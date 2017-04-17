<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<%--<div class="easyui-panel"  data-options="fit:true,border:false" style="padding-left: 10%;padding-top: 30px">--%>
<header id="cycle_header"><span class="tab-inside-title">电子监管码追溯</span></header>
    <table id="cycle_dataGrid"></table>


<script>


    function searchCode() {
        $('#cycleSearch-dialog').dialog({
            title: '输入电子监管码',
            closed: true,
            modal: true,
            content: '<div style="margin:15px 8px"><input class="easyui-textbox" id="cycleSearch" style="width:150px"> <a href="#" class="easyui-linkbutton" data-options="onClick:getCycleCode">确定</a></div>'
        });

        $('#cycleSearch-dialog').dialog('open');
    }

    function getCycleCode() {
        $('#cycle_dataGrid').datagrid('load', {
            code:$('#cycleSearch').textbox('getText')
        });
        $('#cycleSearch-dialog').dialog('close');
    }


    $(document).ready(function () {

        $('#cycle_dataGrid').datagrid({
            url: ctx + '/distribute/getScanCycle',
            /* title:'角色管理',*/
            header: '#cycle_header',
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            fitColumns: true,
            toolbar: [{
                text: '搜索电子监管码',
                iconCls: 'fa fa-edit',
                onClick: searchCode
            }],
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'drugName', title: '药品名称', width: 200},
                {field: 'organName', title: '所属机构', width: 200},
                {field: 'code', title: '条码号', width: 200},
                {field: 'status', title: '状态', width: 200},
                {field: 'drugType', title: '药品种类', width: 200},
                {field: 'manufacture', title: '制造商', width: 200},
                {field: 'addDate', title: '扫码时间', width: 200}
            ]],
            remoteFilter: true
        });
    });


</script>
</body>

</html>
