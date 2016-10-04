<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>角色管理</title>
</head>
<body>
<%--<div class="easyui-panel"  data-options="fit:true,border:false" style="padding-left: 10%;padding-top: 30px">--%>
<header class="roleMange_header"><span class="tab-inside-title">角色管理</span></header>
<table id="roleManager_dataGrid"></table>
<%--</div>--%>
<div id="roleManager_dialog" class="easyui-dialog" style="width:400px;"
     closed="true" buttons="#roleManager-dialog-buttons" data-options="modal:true">
    <form id="roleManager_form" method="post" novalidate style="margin:0;padding:20px 50px">
        <input name="id" type="hidden">
        <input id="roleManager_dialog_menuIds" name="menuIds" type="hidden">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">角色信息</div>
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" required="true" label="角色名称：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="ename" class="easyui-textbox" required="true" label="英文简称：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label class="menuList">菜单权限：</label>
            <input name="menuList" style="width:100%">
        </div>
    </form>
</div>
<div id="roleManager-dialog-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRole()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#roleManager_dialog').dialog('close')" style="width:90px">取消</a>
</div>
<script>
    var roleMangeUrl,roleManagerMenuTree;
    function saveRole(){
        $('#roleManager_form').form('submit',{
            url:roleMangeUrl,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                result = JSON.parse(result);
                if (result.error){
                    $.messager.show({
                        title: '错误信息',
                        msg: result.error
                    });
                } else {
                    $.messager.show({
                        title:'信息提示',
                        msg:'保存成功。',
                        showType:'show'
                    });
                    $('#roleManager_dialog').dialog('close');
                    $('#roleManager_dataGrid').datagrid('reload');    // reload the user data
                }
            }
        })
    }

    function createRole () {
        $('#roleManager_dialog').dialog('open').dialog('setTitle','创建角色');
        $('#roleManager_form').form('clear');
        roleManagerMenuTree.combotree('reload',ctx+'/permission/getMenus?r='+Math.random());
        roleMangeUrl = ctx+'/permission/createRole';
    }

    function updateRole(){
        var row = $('#roleManager_dataGrid').datagrid('getSelected');
        if (row){
            $('#roleManager_dialog').dialog('open').dialog('setTitle','修改角色');
            $('#roleManager_form').form('clear');
            $('#roleManager_form').form('load',row);
            roleManagerMenuTree.combotree('reload');
            roleMangeUrl = ctx+'/permission/updateRole';
        }
    }

    function destroyRole(){
        var row = $('#roleManager_dataGrid').datagrid('getSelected');
        if (row){
            $.messager.confirm('确认信息','您确认删除当前角色?',function(r){
                if (r){
                    $.post(ctx+'/permission/deleteRole',{id:row.id},function(result){
                        if (result.success){
                            $.messager.show({
                                title:'信息提示',
                                msg:'删除角色成功。',
                                showType:'show'
                            });
                            $('#roleManager_dataGrid').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: '错误信息',
                                msg: result.error
                            });
                        }
                    },'json');
                }
            });
        }
    }

    function checkMenu(menus,menusIds){
        for(var x = 0;x<menus.length;x++){
            for(var y = 0;y<menusIds.length;y++){
                if(menusIds[y]===menus[x].id){
                    menus[x].checked = true;
                    menusIds.splice(y,1);
                }
            }
            if(menus[x].children&&menus[x].children.length>0){
                checkMenu(menus[x].children,menusIds);
            }
        }
    }


    $(document).ready(function () {
        var roleDg = $('#roleManager_dataGrid').datagrid({
            url: ctx + '/permission/getRoles',
            /* title:'角色管理',*/
            header: '.roleMange_header',
            pagination: true,
            pageSize: 30,
            pageList: [30],
            singleSelect: true,
            fit: true,
            border: false,
            striped:true,
            /*fitColumns: true,*/
            toolbar: [{
                text: '新增角色',
                iconCls: 'fa fa-plus',
                onClick: createRole
            }, {
                text: '修改角色',
                iconCls: 'fa fa-edit',
                onClick: updateRole
            }, {
                text: '删除角色',
                iconCls: 'fa fa-trash-o',
                onClick: destroyRole
            }],
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            columns: [[
                {field: 'id', hidden:true},
                {field: 'menuIds', hidden:true},
                {field: 'name', title: '角色名称', width: 200},
                {field: 'ename', title: '英文简称', width: 200},
                {field: 'menuNames', title: '菜单权限' ,width: 400}
            ]],
            remoteFilter:true,
            loadFilter:function(data){
                if(data&&data.rows&&data.rows.length>0){
                    for(var i = 0;i<data.rows.length;i++){
                        var menuList= data.rows[i].menuNames;
                        if(menuList&&menuList.length>0){
                            data.rows[i].menuNames= menuList.join(',')
                        }else{
                            data.rows[i].menuNames ='无'
                        }
                        var menus = data.rows[i].menus;
                        if(menus&&menus.length>0){
                            var menuIds = [];
                            for(var j = 0;j<menus.length;j++){
                                menuIds.push(menus[j].id);
                            }
                            data.rows[i].menuIds = menuIds.join(",");
                        }
                    }
                }
                return data;
            }
        });
        roleDg.datagrid('enableFilter', [{
            field:'name',
            type:'combobox',
            options:{
                valueField:'id',
                textField:'name',
                url:'${ctx}/system/getAllRoles',
                onChange:function(newValue,oldValue){
                    roleDg.datagrid('load',{
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
        },/*{
            field:'menus',
            type:'validatebox',
            options:{
                disabled:true
            }
        },*/{
            field:'menuNames',
            type:'validatebox',
            options:{
                disabled:true
            }
        }]);

        roleManagerMenuTree = $('input[name=menuList]').combotree({
            url:ctx+'/permission/getMenus',
            method: 'post',
            animate: true,
            cascadeCheck:false,
            multiple:true,
            multiline:true,
            checkbox:true,
            loadFilter:function(data){
                debugger;
                if(data&&data.length>0){
                    var val = $.trim($('#roleManager_dialog_menuIds').val())?$('#roleManager_dialog_menuIds').val().split(','):[];
                    if(val.length>0){
                        checkMenu(data,val);
                    }
                }
                return  data;
            },
            onCheck:function(node,checked){
                if(checked){
                    var tree=roleManagerMenuTree.combotree('tree');
                    var node1 = tree.tree('getParent',node.target);
                    if(node1&&node1.target){
                        tree.tree('check', node1.target);
                    }
                }
            }
        });

    });


</script>
</body>

</html>
