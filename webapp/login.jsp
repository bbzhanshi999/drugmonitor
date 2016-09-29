<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ include file="/WEB-INF/view/include/head.jsp"%>
<html>
<head>
    <title>登录页</title>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#form').form({
                url:'${ctx}/login',
                success:function(data){
                    debugger;
                    data = $.parseJSON(data);
                    if(data.error){
                        $('#messageBox').text(data.error);
                    }else if (data.success){
                        window.location.href ='${ctx}'+data.url;
                    }else if(data.initPassword){
                        $('#dd').dialog('close');
                        $('#initPasswordDiag').dialog('open');
                        $('#initPasswordUser').val(data.userName);
                        $('#credential').val(data.credential);
                    }
                }
            });

            $('#initPasswordForm').form({
                url:'${ctx}/updateInitPassword',
                success:function(data){
                    debugger;
                    data = $.parseJSON(data);
                    if(data.error){
                        $.messager.alert('错误信息',data.error,'error',function(){
                            window.location.reload();
                        });
                    }else if (data.success){
                        $.messager.alert('信息','密码修改成功，请重新登录!','info',function(){
                            window.location.reload();
                        });
                    }
                }
            });

            $('#submit').on('click',function(){
                $('#form').submit();
            });


            $('#code').click(function(){
                var src = $(this).prop('src') ;
                $(this).prop('src',src+'?r='+Math.random());
            });

            $('#initPasswordSubmit').on('click',function(){
                $('#initPasswordForm').submit();
            });
        });
    </script>
</head>
<body>
<img src="${ctxStatic}/images/background.jpg" style="width:100%;height:100%;position: absolute;left: 0;top: 0;"/>
<div id="dd" class="easyui-dialog" title="登录界面" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closable:false,modal:false">
    <form id="form" method="post" style="padding-top: 10px">
        <div class="form-line">
            <label for="username">用户名:</label>
            <input class="easyui-textbox" prompt="用户名" data-options="required:true,iconCls:'icon-man',tipPosition:'top',validateOnCreate:false" name="username" id="username"/>
            <a id="submit" href="#" class="easyui-linkbutton">提 交</a>
        </div>
        <div class="form-line">
            <label for="password">密码:</label>
            <input  class="easyui-passwordbox" prompt="密码" data-options="required:true,tipPosition:'top',validateOnCreate:false" name="password" id="password"/>
        </div>
        <div class="form-line">
            <label for="validateCode">验证码:</label>
            <input class="easyui-textbox" prompt="验证码" data-options="required:true,iconCls:'icon-lock',tipPosition:'top',validateOnCreate:false" name="validateCode" id="validateCode"/>
            <img id="code" src="${ctx}/getvcode" style="width: 80px; height: 25px;vertical-align: middle" alt="点击更换验证码" />
        </div>
        <div class="form-line" id="messageBox" style="color: red">
        </div>
    </form>
</div>
<div id="initPasswordDiag" class="easyui-dialog" title="密码初始化" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closable:false,modal:false,closed:true">
    <form id="initPasswordForm" method="post" style="padding-top: 10px">
        <p style="margin-left:10px;font-family: 'Microsoft YaHei UI'">您是首次登录，请修改初始化密码后重新登录。</p>
        <div class="form-line">
            <label for="initPassword" style="width:100px">请修改初始化密码:</label>
            <input type="hidden" name="initPasswordUser" id="initPasswordUser"/>
            <input type="hidden" name="credential" id="credential"/>
            <input  class="easyui-passwordbox" prompt="输入新密码" data-options="required:true,tipPosition:'top',validType:'password',validateOnCreate:false" name="initPassword" id="initPassword"/>
        </div>
        <div class="form-line">
            <label for="validatePwd" style="width:100px">请再次輸入:</label>
            <input  class="easyui-passwordbox" prompt="再次輸入新密码" data-options="required:true,delay:1000,tipPosition:'top',validType:'validatePwd',validateOnCreate:false" name="validatePwd" id="validatePwd"/>
            <a id="initPasswordSubmit" href="#" class="easyui-linkbutton">修改</a>
        </div>
    </form>
</div>
</body>