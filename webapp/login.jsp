<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<html>
<head>
    <title>登录页</title>
    <style>
        body .login .layui-layer-title {
            background: #1E9FFF;
            color: #fff;
            border: none;
        }

        body .login .layui-layer-btn {
            border-top: 1px solid #E9E7E7
        }

        body .login .layui-layer-btn a {
            background: #333;
        }

        body .login .layui-layer-btn .layui-layer-btn1 {
            background: #999;
        }

        .background-div {
            FILTER: progid: DXImageTransform . Microsoft . Gradient(gradientType = 0, startColorStr = #032760, endColorStr = #1A90CB); /*IE 6 7 8*/

            background: -ms-linear-gradient(top, #032760, #1A90CB); /* IE 10 */

            background: -moz-radial-gradient(circle, #1E90FF, #032760);
            /* Safari 4-5, Chrome 1-9 */
            /* Can't specify a percentage size? Laaaaaame. */
            background: -webkit-gradient(radial, center center, 0, center center, 460, from(#1E90FF), to(#032760));
            /* Safari 5.1+, Chrome 10+ */
            background: -webkit-radial-gradient(circle, #1E90FF, #032760);

        }
    </style>
    <script type="text/javascript">
        layui.config({
            base: ctxStatic + '/modules/' //你的模块目录
        }).use(['element', 'form', 'verifyRules', 'layer'], function () {
            var element = layui.element(), form = layui.form(), layer = layui.layer;
            $.ajax({
                type: 'post',
                url: '${ctx}/login',
                cahe: false,
                data: '',
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        layer.msg('系统已登录。', {icon: 6, time: 2000,  shade: [0.5, '#fff']}, function () {
                            layer.load(1, {
                                shade: [0.1, '#fff'], //0.1透明度的白色背景
                                time: 2000
                            });
                            window.location.href = '${ctx}' + data.url;
                        });
                    }
                }
            });
            var loginIndex = layer.open({
                type: 1,
//                skin: 'layui-layer-rim', //加上边框
                area: ['500px'], //宽高
                content: formTpl.innerHTML,
                closeBtn: 0,
                title: '登录界面',
                skin: 'login',
                shade: [0.1, 'transparent']
            });
            //监听提交
            form.on('submit(loginSubmit)', function (data) {
                var loadIndex = layer.load(0, {shade: [0.5, '#fff']});
                $.ajax({
                    type: 'post',
                    url: '${ctx}/login',
                    cahe: false,
                    data: data.field,
                    dataType: 'json',
                    success: function (data) {
                        layer.close(loadIndex);
                        if (data.error) {
                            layer.msg(data.error);
                        } else if (data.success) {
                            layer.load(0, {
                                shade: [0.1, '#fff'], //0.1透明度的白色背景
                                time: 2000
                            });
                            window.location.href = '${ctx}' + data.url;
                        } else if (data.initPassword) {
                            layer.close(loginIndex);
                            layer.msg('请完成初始化密码。', {icon: 2, time: 2000}, function () {
                                layer.open({
                                    type: 1,
                                    area: ['500px'], //宽高
                                    content: initPasswordTpl.innerHTML,
                                    closeBtn: 0,
                                    title: '初始化密码',
                                    skin: 'login',
                                    shade: [0.1, 'transparent']
                                });
                                var metaData = data;
                                form.on('submit(initSubmit)', function (data) {
                                    data.field.initPasswordUser = metaData.userName;
                                    data.field.credential = metaData.credential;
                                    var initLoadIndex = layer.load(0, {shade: [0.5, '#fff']});
                                    $.ajax({
                                        url: '${ctx}/updateInitPassword',
                                        dataType: 'json',
                                        data: data.field,
                                        cache: false,
                                        type: 'post',
                                        success: function (data) {
                                            layer.close(initLoadIndex);
                                            if (data.error) {
                                                layer.alert(data.error, {
                                                    skin: 'layui-layer-molv' //样式类名
                                                    , closeBtn: 0
                                                }, function (index) {
                                                    layer.close(index);
                                                });
                                                window.location.reload();
                                            } else if (data.success) {
                                                layer.msg('初始化密码成功', {
                                                    icon: 1,
                                                    time: 4000 //2秒关闭（如果不配置，默认是3秒）
                                                }, function () {
                                                    window.location.reload();
                                                });
                                            }
                                        }
                                    });
                                    return false;
                                })
                            });

                        }
                    }

                });
                return false;
            });

            $('#code').click(function () {
                var src = $(this).prop('src');
                $(this).prop('src', src + '?r=' + Math.random());
            }).bind('mouseover', function () {
                var index = layer.tips('点击更新验证码', this, {
                    tips: [1, '#3595CC']
                });
                $(this).one('mouseout', function () {
                    layer.close(index);
                })
            })


        }); //加载入口
    </script>
</head>
<body>
<script id="formTpl" type="text/html">
    <form class="layui-form" lay-filter="loginForm" style="margin-top: 10px">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名：</label>

            <div class="layui-input-inline">
                <input type="text" name="username" id="username" lay-verify="required" placeholder="请输入用户名"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>

            <div class="layui-input-inline">
                <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码：</label>

            <div class="layui-input-inline">
                <input type="text" name="validateCode" id="validateCode" lay-verify="required" placeholder="请输入验证码"
                       autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-word-aux"><img id="code" src="${ctx}/getvcode"
                                             style="width: 100px; height: 38px;vertical-align: middle"/></div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="loginSubmit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</script>
<script id="initPasswordTpl" type="text/html">
    <form class="layui-form" lay-filter="initPasswordForm" style="margin-top: 10px">
        <input type="hidden" name="initPasswordUser" id="initPasswordUser"/>
        <input type="hidden" name="credential" id="credential"/>

        <div class="layui-form-item">
            <label class="layui-form-label">新密码：</label>

            <div class="layui-input-inline">
                <input type="password" name="initPassword" id="initPassword" lay-verify="required" placeholder="请输入新密码"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">再次输入：</label>

            <div class="layui-input-inline">
                <input type="password" name="validatePwd" id="validatePwd" required lay-verify="repeatVerify"
                       placeholder="请再次输入密码" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="initSubmit">提交</button>
            </div>
        </div>
    </form>
</script>
<h1 style="color:white;font-family: 'Microsoft YaHei UI';position: absolute;z-index: 9999;left:50px;top:50px;font-size: 2em">
    <i
            class="e-icon fa fa-2x fa-medkit"></i>&nbsp;&nbsp;&nbsp;药品监督系统</h1>
<%--<img src="${ctxStatic}/images/background2.png" style="width:100%;height:100%;position: absolute;left: 0;top: 0;"/>--%>
<div class="background-div" style="width:100%;height:100%;position: absolute;left: 0;top: 0;"></div>
</body>