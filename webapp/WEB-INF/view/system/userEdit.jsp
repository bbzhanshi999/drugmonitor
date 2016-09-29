<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<%--<div class="easyui-panel"  data-options="fit:true,border:false" style="padding-left: 10%;padding-top: 30px">--%>
<header class="userMange_header"><span class="tab-inside-title">用户管理</span></header>
<table id="userManager_dataGrid"></table>
<%--</div>--%>
<div id="userManager_dialog" class="easyui-dialog" style="width:400px;"
     closed="true" buttons="#userManager-dialog-buttons" data-options="modal:true">
    <form id="userManager_form" method="post" novalidate style="margin:0;padding:20px 50px">
        <input name="id" type="hidden">
        <input id="userManager_dialog_roleIds" name="roleIds" type="hidden">

        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">用户信息</div>
        <div style="margin-bottom:10px">
            <input name="userName" class="easyui-textbox" data-options="required:true,
                iconCls:'icon-man',
                validType:['username[4,19]','usernameExists'],
                validateOnCreate:false,
                delay:1000,
                validateOnBlur:false" label="用户名：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" data-options="required:true,
                validType:'length[3,64]',
                iconCls:'icon-man',
                validateOnCreate:false,
                validateOnBlur:false" label="姓名：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="email" class="easyui-textbox" data-options="required:true,iconCls:'input-icon fa fa-envelope',
                validType:'email',validateOnCreate:false,validateOnBlur:false" label="Email：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="phone" class="easyui-numberbox" data-options="required:true,
                iconCls:'input-icon fa fa-phone',
                validType:'length[5,11]',
                validateOnCreate:false,
                validateOnBlur:false" label="联系电话：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input style="width:100%" name="role"/>
        </div>
    </form>
</div>
<div id="userManager-dialog-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#userManager_dialog').dialog('close')" style="width:90px">取消</a>
</div>
<script>
    var userMangeUrl,userRoleCombo;
    function saveUser() {
        $('#userManager_form').form('submit', {
            url: userMangeUrl,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                result = JSON.parse(result);
                if (result.error) {
                    $.messager.show({
                        title: '错误信息',
                        msg: result.error
                    });
                } else {
                    $.messager.show({
                        title: '信息提示',
                        msg: '保存成功。',
                        showType: 'show'
                    });
                    $('#userManager_dialog').dialog('close');
                    $('#userManager_dataGrid').datagrid('reload');    // reload the user data
                }
            }
        })
    }


    function updateUser() {
        var row = $('#userManager_dataGrid').datagrid('getSelected');
        if (row) {
            $('#userManager_dialog').dialog('open').dialog('setTitle', '修改用户信息');
            $('#userManager_form').form('clear');
            $('#userManager_form').form('load', row);
            userRoleCombo.combobox('reload');
            userMangeUrl = ctx + '/system/user/updateUser';
        }
    }

    function destroyUser() {
        var row = $('#userManager_dataGrid').datagrid('getSelected');
        if (row) {
            $.messager.confirm('确认信息', '您确认删除当前用户?', function (r) {
                if (r) {
                    $.post(ctx + '/system/user/deleteUser', {id: row.id}, function (result) {
                        if (result.success) {
                            $.messager.show({
                                title: '信息提示',
                                msg: '删除用户成功。',
                                showType: 'show'
                            });
                            $('#userManager_dataGrid').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: '错误信息',
                                msg: result.error
                            });
                        }
                    }, 'json');
                }
            });
        }
    }

    function resetPassword(){
        var row = $('#userManager_dataGrid').datagrid('getSelected');
        if (row) {
            $.messager.confirm('确认信息', '确认重置该用户密码吗?', function (r) {
                if (r) {
                    $.post(ctx + '/system/user/resetPassword', {id: row.id}, function (result) {
                        if (result.success) {
                            $.messager.show({
                                title: '信息提示',
                                msg: '重置用户密码成功。默认密码为666666',
                                showType: 'show'
                            });
                            $('#userManager_dataGrid').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: '错误信息',
                                msg: result.error
                            });
                        }
                    }, 'json');
                }
            });
        }
    }

    $(document).ready(function () {

        userRoleCombo = $('#userManager_form').find('input[name="role"]').combobox({
            required:true,
            validateOnCreate:false,
            validateOnBlur:false,
            valueField:'id',
            textField:'name',
            url:'${ctx}/system/getAllRoles',
            multiple:true,
            multiline:true,
            label:"选择角色：",
            prompt:'选择角色',
            onLoadSuccess:function(){
                debugger;
                var roleIds = $('#userManager_dialog_roleIds').val();
                if($.trim(roleIds)) {
                    roleIds = roleIds.split(',');
                    for(var y = 0;y<roleIds.length;y++){
                        $(this).combobox('select',roleIds[y]);
                    }
                }
            }
        });

        var userManageDg = $('#userManager_dataGrid').datagrid({
            url: ctx + '/system/user/getUsers',
            /* title:'角色管理',*/
            header: '.userMange_header',
            pagination: true,
            pageSize: 30,
            pageList: [30],
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            fitColumns: true,
            toolbar: [{
                text: '修改用户',
                iconCls: 'fa fa-edit',
                onClick: updateUser
            }, {
                text: '删除用户',
                iconCls: 'fa fa-trash-o',
                onClick: destroyUser
            }, {
                text: '重置密码',
                iconCls: 'fa fa-refresh',
                onClick: resetPassword
            }],
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'id', hidden: true},
                {field: 'roleIds', hidden: true},
                {field: 'userName', title: '用户名', width: 200},
                {field: 'name', title: '英文简称', width: 200},
                {field: 'phone', title: '联系电话', width: 200},
                {field: 'email', title: 'Email', width: 200},
                {
                    field: 'roleNames',
                    title: '角色权限',
                    formatter: function (value, row) {
                        var roleNames='';
                        if(row&&row.roles&&row.roles.length>0){
                            for(var x=0;x<row.roles.length;x++){
                                roleNames = roleNames+row.roles[x].name+',';
                            }
                        }
                        roleNames = roleNames.substring(0,roleNames.length -1);
                        return roleNames;
                    }
                }
            ]],
            remoteFilter: true,
            loadFilter: function (data) {
                if (data && data.rows && data.rows.length > 0) {
                    for (var i = 0; i < data.rows.length; i++) {
                        var roleList = data.rows[i].roleNames;
                        if (roleList && roleList.length > 0) {
                            data.rows[i].roleNames = roleList.join(',')
                        } else {
                            data.rows[i].roleNames = '无'
                        }
                        var roles = data.rows[i].roles;
                        if (roles && roles.length > 0) {
                            var roleIds = [];
                            for (var j = 0; j < roles.length; j++) {
                                roleIds.push(roles[j].id);
                            }
                            data.rows[i].roleIds = roleIds.join(",");
                        }
                    }
                }
                debugger;
                return data;
            }
        });
        /*userManageDg.datagrid('enableFilter', [{
         field:'name',
         type:'combobox',
         options:{
         valueField:'id',
         textField:'name',
         url:'
        ${ctx}/system/getAllRoles',
         onChange:function(newValue,oldValue){
         userManageDg.datagrid('load',{
         id:newValue
         })
         }
         }
         },{
         field:'ename',
         type:'validatebox',
         options:{
         disabled:true
         }
         },*/
        /*{
         field:'menus',
         type:'validatebox',
         options:{
         disabled:true
         }
         },*/
        /*{
         field:'menuNames',
         type:'validatebox',
         options:{
         disabled:true
         }
         }]);*/

    });


</script>
</body>

</html>
