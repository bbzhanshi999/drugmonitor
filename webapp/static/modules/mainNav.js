/**
 * Created by Administrator on 2017/2/23 0023.
 */
/**
 * 顶部导航条
 * Created by Administrator on 2017/2/20 0020.
 */
layui.define(['jquery', 'element'], function (exports) {
    var $ = layui.jquery,variables;//variables原始数据
    var api = {
        refresh:function(){

        }
    };
    var assembleHtml = function(data){
        //todo 组装列表项
        var html = $('<ul></ul>');
        (function(){
            for(var i = 0;i<=data.length;i++){
                var $li = $('<li class="layui-nav-item"><a href="javascript:void;" data-url="'+data[i].url+'">'+data[i].menuName+'</a></li>');
                if(data[i].children&&data[i].children.length>0){
                    var $dl = $('<dl class="layui-nav-child"></dl>').appendTo($li);
                    for(var j=0;j<=data[i].children;j++){
                        $dl.append('<dd><a href="javascript:void;" data-url="'+data[i].children[j].url+'">'+data[i].children[j].menuName+'</a></dd>')
                    }
                }
                html.append($li);
            }
        })();
        return html;
    };
    exports('mainNav', function (params) {
        /*params参数
        * el:容器元素
        * url：异步获取数据请求地址
        * data；同步数据
        * onclick:点击元素回调函数
        * */
        if(params.url&&params.url.length>0){
            $.ajax({
                type:'post',
                url:params.url,
                dataType:'json',
                success:function(data){
                    $(params.el).append(assembleHtml(data)).addClass('layui-nav').attr('filter','mainNav');
                    if(params.onclick){
                        $(params.el).find('li.layui-nav-item>a,dl.layui-nav-child>dd>a,ul.layui-nav-child>li>a').on('click',function(){
                            params.onclick.call(this,$(this).data('url'));
                        })
                    }
                }
            })
        }else if(params.data&&params.data.length>0){
            $(params.el).append(assembleHtml(data)).addClass('layui-nav').attr('filter','mainNav');
            if(params.onclick){
                $(params.el).find('li.layui-nav-item>a,dl.layui-nav-child>dd>a,ul.layui-nav-child>li>a').on('click',function(){
                    params.onclick.call(this,$(this).data('url'));
                })
            }
        }
        variables = params;

        return api;
    }); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});