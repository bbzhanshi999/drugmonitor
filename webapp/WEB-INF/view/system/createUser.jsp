<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ include file="/WEB-INF/view/include/head.jsp"%>
<html>
<head>
    <title>创建用户</title>
</head>
<body>
    <div class="easyui-panel"  data-options="fit:true,border:false" style="padding-left: 10%">
        <header style="background-color: #2D3E50;color:white;font-size: 12px"><i class='fa fa-user'></i>   创建用户</header>
        <form id="createUserForm"  method="post" style="padding-top: 10px">
            <div class="form-line">
                <label for="username">用户名:</label>
                <input class="easyui-textbox" prompt="用户名" data-options="required:true,iconCls:'icon-man',validateOnCreate:false,validateOnBlur:false" name="username" id="username"/>
                <label for="name">姓名:</label>
                <input  class="easyui-textbox" prompt="姓名" data-options="required:true,iconCls:'icon-man',validateOnCreate:false,validateOnBlur:false" name="name" id="name"/>
            </div>
            <div class="form-line">
                <label for="email">Email:</label>
                <input class="easyui-textbox" prompt="Email" data-options="required:true,iconCls:'input-icon fa fa-envelope',tipPosition:'top',validType:'email',validateOnCreate:false,validateOnBlur:false" name="email" id="email"/>
                <label for="phone">联系电话:</label>
                <input  class="easyui-numberbox" prompt="联系电话" data-options="required:true,iconCls:'input-icon fa fa-phone',validType:'length[5,11]',validateOnCreate:false,validateOnBlur:false" name="phone" id="phone"/>
            </div>
            <div class="form-line">
                <label for="pwdGenMode">密码策略:</label>
                <input class="easyui-switchbutton" data-options="onText:'默认',offText:'手动'" id="pwdGenMode" checked style="height:20px"><span class="interval" style="width: 92px"></span>
                <label for="password">密码:</label>
                <input  class="easyui-passwordbox" prompt="密码" data-options="required:true,tipPosition:'top',validateOnCreate:false,validateOnBlur:false" name="password" id="password"/>
            </div>
            <div class="form-line">
                <label for="role">选择角色:</label>
                <input class="easyui-textbox" prompt="选择角色" data-options="required:true,iconCls:'input-icon fa fa-envelope',tipPosition:'top',validType:'email',validateOnCreate:false,validateOnBlur:false" name="role" id="role"/>


            </div>
            <div class="form-line" id="messageBox" style="color: red">
            </div>
        </form>
    </div>

</body>
</html>
