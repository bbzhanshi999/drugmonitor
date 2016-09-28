$(document).ready(function () {

    /*添加自定义validate*/
    $.extend($.fn.validatebox.defaults.rules, {
        username: {
            validator: function (value, param) {

                var regStr = '^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){' + param[0] + ',' + param[1] + '}$';
                var pattern = new RegExp(regStr, '');
                if (!pattern.exec(value)) return false;
                return true;
            },
            message: '用户名为{0}-{1}个以字母开头、可带数字、“_”、“.”的字符组成'
        },
        usernameExists:{
            validator: function (value, param) {
                var flag = true;

                $.ajax({
                        url: ctx+'/system/userNameValidate',
                        data: {userName:value},
                        dataType: 'json',
                        type: 'post',
                        async:false,
                        cache: false,
                        success: function (isExist) {
                            flag = isExist;
                        }
                });
                return flag;
            },
            message: '用户名已存在。'
        },
        clientNameExists:{
            validator: function (value, param) {
                var flag = true;

                $.ajax({
                        url: ctx+'/dataPermission/clientNameValidate',
                        data: {clientName:value},
                        dataType: 'json',
                        type: 'post',
                        async:false,
                        cache: false,
                        success: function (isExist) {
                            flag = isExist;
                        }
                });
                return flag;
            },
            message: '用户名已存在。'
        },
        password: {
            validator: function (value, param) {
                //  var regStr = '^(\w){6,20}$/';
                var pattern =/^(\w){6,20}$/;
                if (!pattern.exec(value) || '66666' == value) return false;
                return true;
            },
            message: '密码由6-20个字母、数字、下划线 （不能使用初始密码）'
        },
    });


    $('#mainTabs').tabs({
        fit:true,
        border:false,
        plain:true,
        onBeforeClose:function(title,index){
            var tab = $(this).tabs('getTab',title);
            if('menu_rolePermission'===tab.panel('options').id){
                roleManagerMenuTree.combotree('destroy');
                $('#roleManager_form').form('clear');
                $('#roleManager_dialog').dialog('destroy');
            }
        }
    });

    /**
     * 生成菜单树
     */
    $('.menu-tree').tree({
        url: ctx + '/system/menu',
        method: 'post',
        animate: true,
        onClick: function (node) {
            if (!node.leaf || node.leaf !== '1') {
                return;
            }
            var tab = $('#mainTabs').tabs('getTab', node.text);
            if (!tab || tab.length <= 0) {
                tab = $('#mainTabs').tabs('add', {
                    id: node.ename,
                    title: node.text,
                    href: ctx + node.url,
                    closable: true,
                    iconCls: 'e-icon ' + node.iconCls
                });
            } else {
                $('#mainTabs').tabs('select', node.text);
            }
        }
    })


});

