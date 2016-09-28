<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>数据区域管理</title>
</head>
<body>
<header class="dataAreaManage_header"><span class="tab-inside-title">数据区域管理</span></header>
<table id="dataAreaManage_dataGrid"></table>
<div id="dataAreaManage_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-plus" plain="true"
       onclick="javascript:$('#dataAreaManage_dataGrid').edatagrid('addRow')">创建区域</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-trash-o" plain="true"
       onclick="javascript:$('#dataAreaManage_dataGrid').edatagrid('destroyRow')">删除区域</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-save" plain="true"
       onclick="javascript:$('#dataAreaManage_dataGrid').edatagrid('saveRow')">保存区域</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-rotate-left" plain="true"
       onclick="javascript:$('#dataAreaManage_dataGrid').edatagrid('cancelRow')">取消</a>
</div>
<script>
    $(document).ready(function () {

        var dataAreaManageGrid = $('#dataAreaManage_dataGrid').edatagrid({
            url: ctx + '/dataPermission/getAreas',
            saveUrl: ctx + '/dataPermission/createArea',
            updateUrl: ctx + '/dataPermission/updateArea',
            destroyUrl: ctx + '/dataPermission/deleteArea',
            header: '.dataAreaManage_header',
            pagination: true,
            pageSize: 30,
            pageList: [30],
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            idField: "id",
           /* fitColumns: true,*/
            toolbar: '#dataAreaManage_toolbar',
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'id', hidden: true},
                {
                    field: 'areaName',
                    title: '区域名称',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true
                        }
                    }
                }, {
                    field: 'areaEname',
                    title: '区域英文简称',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true
                        }
                    }
                }, {
                    field: 'areaCode',
                    title: '区域编码',
                    width: 100,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true
                        }
                    }
                }
            ]],
            /*remoteFilter: true,*/

            onSuccess:function(index,row){
                debugger;
                $(this).edatagrid('reload');
            }
        });
        /*dataAreaManageGrid.datagrid('enableFilter');*/
    });


</script>
</body>

</html>
