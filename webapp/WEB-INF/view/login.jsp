<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>登录页</title>
    <link href="${ctxStatic}/jquery.validate.min.css" type="text/css" rel="stylesheet" />
    <link href="${ctxStatic}/themes/default/easyui.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/jquery.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <script src="${ctxStatic}/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("form").validate({
                rules: {
                    validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
                },
                messages: {
                    username: {required: "请填写用户名."},password: {required: "请填写密码."},
                    validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
                },
                errorLabelContainer: "#messageBox",
                errorPlacement: function(error, element) {
                    error.appendTo($("#messageBox"));
                }
            });

            $('#code').click(function(){
                var src = $(this).prop('src') ;
                $(this).prop('src',src+'?r='+Math.random());
            });
        });
    </script>
    <style type="text/css">
        body{margin:0px;padding:0px;}
        .text{margin:0px;padding:0px;width:220px;}
        .btn{margin:0px;padding:0px;border:0px;width:60px}
    </style>
</head>
<body>
<form action="${ctx}/login" method="post" >
    <table>
        <tr>
            <th colspan="2">用户登录</th>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username" class="text"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password" class="text"/></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="password" name="validateCode" id="validateCode" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <img id="code" src="${ctx}/servlet/validateCodeServlet" style="width: 80px; height: 25px;" alt="点击更换验证码" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"  value="登录" class="btn"/>&nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="2">
               <div id="messageBox" style="color: red">

               </div>
            </td>
        </tr>
    </table>
</form>