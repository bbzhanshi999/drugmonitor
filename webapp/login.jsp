<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>登录页</title>
    <link href="${ctxStatic}/style/main.css" type="text/css" rel="stylesheet" />
    <link href="${ctxStatic}/themes/metro-gray/easyui.css" type="text/css" rel="stylesheet" />
    <link href="${ctxStatic}/themes/icon.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/jquery.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <script src="${ctxStatic}/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('form').form({
                url:'${ctx}/login',

                success:function(data){
                    data = $.parseJSON(data);
                    if(data.error){
                        $('#messageBox').val(data.error);
                    }else if (data.success){
                        window.location.href ='${ctx}'+data.url;
                    }
                }
            });


            $('#submit').on('click',function(){
                $('form').submit();
            });


            $('#code').click(function(){
                var src = $(this).prop('src') ;
                $(this).prop('src',src+'?r='+Math.random());
            });
        });
    </script>
</head>
<body>
<img src="${ctxStatic}/images/background.jpg" style="width:100%;height:100%;position: absolute;left: 0;top: 0;"/>
<div id="dd" class="easyui-dialog" title="登录界面" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closable:false">
    <form id="form" method="post" style="padding-top: 10px">
        <div class="form-line">
            <label for="username">用户名:</label>
            <input class="easyui-textbox" data-options="required:true,iconCls:'icon-man'" name="username" id="username"/>
            <a id="submit" href="#" class="easyui-linkbutton">提 交</a>
        </div>
        <div class="form-line">
            <label for="password">密码:</label>
            <input class="easyui-textbox" data-options="required:true,iconCls:'icon-lock',type:'password'" type="password" name="password" id="password"/>
        </div>
        <div class="form-line">
            <label for="validateCode">验证码:</label>
            <input class="easyui-textbox" data-options="required:true,iconCls:'icon-lock'" name="validateCode" id="validateCode"/>
            <img id="code" src="${ctx}/getvcode" style="width: 80px; height: 25px;vertical-align: middle" alt="点击更换验证码" />
        </div>
        <div class="form-line" id="messageBox" style="color: red">
        </div>
    </form>
</div>
</body>