<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>数据机构管理</title>
</head>
<body>
<header class="dataOrganization_header"><span class="tab-inside-title">数据机构管理</span></header>
<table id="dataOrganization_dataGrid"></table>
<div id="dataOrganization_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-plus" plain="true"
       onclick="javascript:$('#dataOrganization_dataGrid').edatagrid('addRow')">创建机构</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-trash-o" plain="true"
       onclick="javascript:$('#dataOrganization_dataGrid').edatagrid('destroyRow')">删除机构</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-save" plain="true"
       onclick="javascript:$('#dataOrganization_dataGrid').edatagrid('saveRow')">保存机构</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-rotate-left" plain="true"
       onclick="javascript:$('#dataOrganization_dataGrid').edatagrid('cancelRow')">取消</a>
</div>
<script>
    $(document).ready(function () {

        var dataOrganizationManageGrid = $('#dataOrganization_dataGrid').edatagrid({
            url: ctx + '/dataPermission/getOrganizations',
            saveUrl: ctx + '/dataPermission/createOrganization',
            updateUrl: ctx + '/dataPermission/updateOrganization',
            destroyUrl: ctx + '/dataPermission/deleteOrganization',
            header: '.dataOrganization_header',
            pagination: true,
            pageSize: 30,
            pageList: [30],
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            idField: "id",
            /* fitColumns: true,*/
            toolbar: '#dataOrganization_toolbar',
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'id', hidden: true},
                {
                    field: 'organName',
                    title: '机构名称',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true
                        }
                    }
                }, {
                    field: 'organEname',
                    title: '机构英文简称',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true
                        }
                    }
                }, {
                    field: 'organCode',
                    title: '机构编码',
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
       /* dataOrganizationManageGrid.datagrid('enableFilter');*/
    });


</script>
</body>

</html>
