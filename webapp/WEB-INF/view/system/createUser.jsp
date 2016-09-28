<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>创建用户</title>
</head>
<body>
    <div class="easyui-panel"  data-options="fit:true,border:false,footer:'#createUserFooter'" style="padding-left: 10%">
        <header ><span class="tab-inside-title">创建用户</span></header>
        <form id="createUserForm"  method="post" style="padding-top: 10px">
            <div class="form-line wide">
                <label for="userName">用户名:</label>
                <input class="easyui-textbox" prompt="用户名" data-options="required:true,
                iconCls:'icon-man',
                validType:['username[4,19]','usernameExists'],
                validateOnCreate:false,
                delay:1000,
                validateOnBlur:false" name="userName" id="userName"/>
                <span class="interval" style="width: 92px"></span><label for="name">姓名:</label>
                <input  class="easyui-textbox" prompt="姓名" data-options="required:true,
                validType:'length[3,64]',
                iconCls:'icon-man',
                validateOnCreate:false,
                validateOnBlur:false" name="name" id="name"/>
            </div>
            <div class="form-line wide">
                <label for="email">Email:</label>
                <input class="easyui-textbox" prompt="Email" data-options="required:true,iconCls:'input-icon fa fa-envelope',
                validType:'email',validateOnCreate:false,validateOnBlur:false" name="email" id="email"/>
                <span class="interval" style="width: 92px"></span><label for="phone">联系电话:</label>
                <input  class="easyui-numberbox" prompt="联系电话" data-options="required:true,
                iconCls:'input-icon fa fa-phone',
                validType:'length[5,11]',
                validateOnCreate:false,
                validateOnBlur:false" name="phone" id="phone"/>
            </div>
            <div class="form-line wide">
                <label for="pwdGenMode">密码策略:</label>
                <input id="pwdGenMode" style="height:20px"><span class="interval" style="width: 92px"></span>
                <span class="interval" style="width: 92px"></span>
                <span class="passwordbox" style="display: none">
                    <label for="password">密码:</label>
                    <input name="password" id="password"/>
                </span>
            </div>
            <div class="form-line wide">
                <label for="role">选择角色:</label>
                <input class="easyui-combobox" prompt="选择角色" multiple="true" multiline="true"
                       data-options="required:true,
                       validateOnCreate:false,
                       validateOnBlur:false,
                       valueField:'id',
                       textField:'name',
                       url:'${ctx}/system/getOrganizations'" name="role" id="role"/>
            </div>
        </form>
    </div>
    <div id="createUserFooter" style="padding:5px;text-align: center">
        <a href="#" class="easyui-linkbutton createUserSubmit" data-options="iconCls:'icon-save'" style="width: 80px;">提&nbsp;&nbsp;交</a>
    </div>
    <script>
        $(document).ready(function(){
            $('input[name="password"]').passwordbox({
                prompt:'密码',
                validType:'password',
                tipPosition:'top',
                validateOnCreate:false,
                validateOnBlur:false
            });


            $('#pwdGenMode').switchbutton({
                onText:'默认',
                offText:'手动',
                checked:true,
                onChange: function(checked){
                    debugger;
                    if(checked){
                        $('.passwordbox').hide();
                        $('#password').passwordbox('clear');
                    }else{
                        $('.passwordbox').show();
                    }
                }
            });


            $('#createUserForm').form({
                url:'${ctx}/system/user/create',
                success:function(data){
                    debugger;
                    data = $.parseJSON(data);
                    if(data.error){
                        $.messager.alert('错误信息',data.error,'error');
                    }else if (data.message){
                        $.messager.show({
                            title:'信息提示',
                            msg:'保存成功。',
                            showType:'show'
                        });
                        $('#menu_createUser').panel('refresh');
                    }
                }
            });


            $('.createUserSubmit').on('click',function(){
                $('#createUserForm').submit();
            });
        })
    </script>
</body>
</html>
