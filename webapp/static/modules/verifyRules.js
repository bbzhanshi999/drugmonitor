/**
 * Created by Administrator on 2017/2/20 0020.
 */
layui.define(['jquery','form'],function(exports){
    var form = layui.form();
    var $ = layui.jquery;
    form.verify({
        repeatVerify:function(value){
            if($('#initPassword').val()!=value){
                return '密码输入不一致。';
            }

        }
    });
    exports('verifyRules', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});