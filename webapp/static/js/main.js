$(document).ready(function(){
    $('.menu-tree').tree({
        url:ctx+'/system/menu',
        method:'post',
        animate:true,
        onClick:function(node){
            if(!node.leaf||node.leaf!=='1'){
                return;
            }
            var tab = $('#mainTabs').tabs('getTab',node.text);
            if(!tab||tab.length<=0){
                tab = $('#mainTabs').tabs('add',{
                    id:node.permission,
                    title:node.text,
                    href:ctx+node.url,
                    closable:true,
                    iconCls:'e-icon '+node.iconCls
                });
            }else{
                $('#mainTabs').tabs('select',node.text);
            }
        }
    })



});

