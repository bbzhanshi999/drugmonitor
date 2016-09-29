<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>系统设置</title>
</head>
<body>
<div class="easyui-panel"  data-options="fit:true,border:false" style="padding-left: 10%">
    <header ><span class="tab-inside-title">系统设置</span></header>
        <div class="form-line wide">
            <label for="sessionInterval">超时时间:</label>
            <input  class="easyui-numberbox" prompt="会话超时时间（秒）" data-options="required:true,
                iconCls:'input-icon fa fa-history',
                validType:'length[1,11]',
                validateOnCreate:false,value:${sessionInterval}" name="sessionInterval" id="sessionInterval"/>
            <span class="interval" style="width: 92px">
            <a href="#" class="easyui-linkbutton sessionIntervalSubmit" data-options="iconCls:'icon-save'" style="width: 80px;">确认</a>
        </div>
</div>
<script>
    $(document).ready(function(){

        $('.sessionIntervalSubmit').on('click',function(){
            var sessionIntervalValue = $('#sessionInterval').numberbox('getValue');
            $.post(ctx+'/system/config/sessionInterval',{value:sessionIntervalValue},function(result){
                if(result.success){
                    $.messager.show({
                        title:'信息提示',
                        msg:'修改成功。',
                        showType:'show'
                    });
                    $('#roleManager_dataGrid').datagrid('reload');    // reload the user data
                } else {
                    $.messager.show({    // show error message
                        title: '错误信息',
                        msg: result.error
                    });
                }
            })
        });
    })
</script>
</body>
</html>
