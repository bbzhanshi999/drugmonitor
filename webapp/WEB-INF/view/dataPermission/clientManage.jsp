<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>数据用户管理</title>
</head>
<body>
<header class="dataClientManage_header"><span class="tab-inside-title">数据用户管理</span></header>
<table id="dataClientManage_dataGrid"></table>
<div id="dataClientManage_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-plus" plain="true"
       onclick="javascript:$('#dataClientManage_dataGrid').edatagrid('addRow')">创建用户</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-trash-o" plain="true"
       onclick="javascript:$('#dataClientManage_dataGrid').edatagrid('destroyRow')">删除用户</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-save" plain="true"
       onclick="javascript:$('#dataClientManage_dataGrid').edatagrid('saveRow')">保存用户</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-rotate-left" plain="true"
       onclick="javascript:$('#dataClientManage_dataGrid').edatagrid('cancelRow')">取消</a>
</div>
<script>
    $(document).ready(function () {
        var clientNameFilter='',organIdFilter='',areaIdFilter='';
        var dataClientManageGrid = $('#dataClientManage_dataGrid').edatagrid({
            url: ctx + '/dataPermission/getClients',
            saveUrl: ctx + '/dataPermission/createClient',
            updateUrl: ctx + '/dataPermission/updateClient',
            destroyUrl: ctx + '/dataPermission/deleteClient',
            header: '.dataClientManage_header',
            pagination: true,
            pageSize: 30,
            pageList: [30],
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            idField: "id",
            fitColumns: true,
            toolbar: '#dataClientManage_toolbar',
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'id', hidden: true},
                {
                    field: 'clientName',
                    title: '用户名',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true,
                            validType: 'clientName[4,19]',
                            validateOnCreate: false,
                            delay: 1000,
                            validateOnBlur: false
                        }
                    }
                }, {
                    field: 'password',
                    title: '密码',
                    width: 200,
                    editor: {
                        type: 'textbox',
                        options:{
                            required: true,
                            validType:'password',
                            validateOnCreate:false,
                            validateOnBlur:false
                        }
                    }
                }, {
                    field: 'organId',
                    title: '所属机构',
                    width: 100,
                    formatter: function (value, row) {

                        return row.organName;
                    },
                    editor: {
                        type: 'combobox',
                        options: {
                            valueField: 'id',
                            textField: 'organName',
                            method: 'post',
                            url: ctx + '/dataPermission/getAllOrganizations',
                            required: true
                        }
                    }
                }, {
                    field: 'areaId',
                    width: 100,
                    title: '所属区域',
                    formatter: function (value, row) {
                        return row.areaName;
                    },
                    editor: {
                        type: 'combobox',
                        options: {
                            valueField: 'id',
                            textField: 'areaName',
                            method: 'post',
                            url: ctx + '/dataPermission/getAllAreas',
                            required: true
                        }
                    }
                }
            ]],
            remoteFilter: true,
            filterStringify:function(data){
                console.log(data);

                return data[0].value
            },

            onSuccess:function(index,row){
                debugger;
                $(this).edatagrid('reload');
            }
        });
        dataClientManageGrid.datagrid('enableFilter', [{
            field:'organId',
            type:'combobox',
            options:{
                valueField:'id',
                textField:'organName',
                url:ctx + '/dataPermission/getAllOrganizations',
                onChange:function(newValue,oldValue){
                    if (newValue == ''){
                        dataClientManageGrid.datagrid('removeFilterRule', 'organId');
                    } else {
                        dataClientManageGrid.datagrid('addFilterRule', {
                            field: 'organId',
                            op: 'equal',
                            value: newValue
                        });
                    }
                    dataClientManageGrid.datagrid('doFilter');
                }
            }
        },{
            field:'password',
            type:'validatebox',
            options:{
                disabled:true
            }
        },{
            field: 'areaId',
            type: 'combobox',
            options:{
                valueField:'id',
                textField:'areaName',
                url:ctx + '/dataPermission/getAllAreas',
                onChange:function(newValue,oldValue){
                    if (newValue == ''){
                        dataClientManageGrid.datagrid('removeFilterRule', 'areaId');
                    } else {
                        dataClientManageGrid.datagrid('addFilterRule', {
                            field: 'areaId',
                            op: 'equal',
                            value: newValue
                        });
                    }
                    dataClientManageGrid.datagrid('doFilter');
                }
            }
         },{
            field:'clientName',
            type:'validatebox'
        }]);
    });


</script>
</body>

</html>
