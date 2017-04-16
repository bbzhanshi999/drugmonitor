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
        clientName: {
            validator: function (value, param) {
                var regStr = '^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){' + param[0] + ',' + param[1] + '}$';
                var pattern = new RegExp(regStr, '');
                if (!pattern.exec(value)) return false;
                return true;
            },
            message: '用户名为{0}-{1}个以字母开头、可带数字、“_”、“.”的字符组成，用户名不能重复'
        },
        usernameExists:{
            validator: function (value, param) {
                var flag = true;
                var id = $('#userManager_form').find('input[name="id"]').val();
                $.ajax({
                        url: ctx+'/system/userNameValidate',
                        data: {userName:value,id:id},
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
        validatePwd: {
            validator: function (value, param) {
                //  var regStr = '^(\w){6,20}$/';
                var old = $('#initPassword').val();
                if((old!==value)){
                    return false;
                }
                return true;
            },
            message: '两次输入结果不一致'
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
            }else if('menu_userManage'===tab.panel('options').id){
                userRoleCombo.combobox('destroy');
                $('#userManager_form').form('clear');
                $('#userManager_dialog').dialog('destroy');
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
                    href: ctx + node.url+'?r='+Math.random(),
                    closable: true,
                    iconCls: 'e-icon ' + node.iconCls
                });
            } else {
                $('#mainTabs').tabs('select', node.text);
            }
        },
        loadFilter:menuTreeLoadFilter
    })
});

function menuTreeLoadFilter(data){
    if(data&&data.length>0){
        for (var x in data) {
            if($.trim(data[x].children)){
                data[x].state = 'closed';
                if(data[x].children&&data[x].children.length>0){
                    menuTreeLoadFilter(data[x].children);
                }
            }
        }
    }
    return data;
}

/**
 * 日期格式化
 * @param date
 * @returns {string}
 */
function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

/**
 * 日期转换
 * @param s
 * @returns {Date}
 */
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}

function startDateOnSelect(startDate){

    var startId =$(this).attr('id');
    var endId = startId.split('-')[0]+'-endDate';
    $('#'+endId).datebox().datebox('calendar').calendar({
        validator: function(date){
            return startDate<=date;
        }
    });
}

function eConsole(param) {
    var mes = '【' + param.type + '】';
    if (typeof param.seriesIndex != 'undefined') {
        mes += '  seriesIndex : ' + param.seriesIndex;
        mes += '  dataIndex : ' + param.dataIndex;
    }
    console.log(param);
    console.log(mes);
}

/**
 * 创建一个grid-dialog
 */
function openGridDialog(options){
    //todo
    //$('#gridDialog').dialog('destory');
    $('#gridDialog').dialog({
        title:options.title,
        closed:true,
        modal:true,
        /*content:'<iframe src="'+options.url+'?'+parseParam(options.data)+'" style="width: 100%;height:100%;border: none"' +
        ' frameborder="no" marginwidth="0" marginheight="0" scrolling="no" ></iframe>',*/
        onOpen:function(){
            var roleDg = $('#grid').datagrid(options.dialogConfig);
        }
    });
    $('#gridDialog').dialog('open');
}

/**
 * 对象转换成url
 * @param param
 * @param key
 * @returns {string}
 */
function parseParam(param, key){
    var paramStr="";
    if(param instanceof String||param instanceof Number||param instanceof Boolean){
        paramStr+="&"+key+"="+encodeURIComponent(param);

    }else{
        $.each(param,function(i){
            var k=key==null?i:key+(param instanceof Array?"["+i+"]":"."+i);
            paramStr+='&'+parseParam(this, k);
        });
    }
    return paramStr.substr(1);
}

function mergeArray(arr1, arr2) {
    for (var i = 0; i < arr1.length; i++) {
        for (var j = 0; j < arr2.length; j++) {
            if (arr1[i] === arr2[j]) {
                arr1.splice(i, 1); //利用splice函数删除元素，从第i个位置，截取长度为1的元素
            }
        }
    }
    for (var k = 0; k < arr2.length; k++) {
        arr1.push(arr2[k]);
    }
    return arr1;
}


function getTime(time, period) {
    var arr = time.split("/");
    var length = period.split("/").length,date;
    for(var i=0;i<length;i++){
        arr[i] = parseInt(arr[i],10);
    }
    if(length==2){
        date = new Date(arr[0], arr[1] - 1);
    }else if (length == 3) {
        date = new Date(arr[0], arr[1] - 1, arr[2]);

    } else {
        date = new Date(arr[0], 1);
    }
    return date.getTime();
}

/**
 * 生成xData
 * @param data [2015,2013,2016,2013,2017]
 * @param period
 */
function sortPeriod(data, period) {
    var temp;
    for(var i = 0; i<data.length-1;i++){
        for(var j=i+1;j<data.length;j++ ){
            if(getTime(data[i],period)>getTime(data[j],period)){
                temp = data[i];
                data[j] = data[i];
                data[i]=  temp;
            }
        }
    }
    return data;
}

/**
 * 生成xData
 * @param periods [[2012,2013],[...]..]
 * @param query
 */
function generateXdata(periods, query) {
    var data = [];
    for (var i = 0; i < periods.length; i++) {
        data = mergeArray(periods[i], data);
    }
    return sortPeriod(data, query.period);
}
/*生成series*/
function generateSerieData(data, xdata,query) {
    var flag = 0,serieData = [],rawData= [],time1,time2;

    for(var i=0;i<data.length;i++){
        time1 = getTime(data[i].period, query.period);
        for(var j=flag;j<xdata.length;j++){
            time2 = getTime(xdata[j], query.period);
            if(time1>time2){
                serieData.push(0);
                rawData.push($.extend({}, {index: xdata[j]}, query));
                flag++;
            }else if(time1<=time2){
                break;
            }
        }
        serieData.push(data[i].amount);
        rawData.push($.extend({}, {index: data[i].period}, query));
        flag++;
    }
    var lostLength = xdata.length-serieData.length;
    if(lostLength>0){
        for(var k=serieData.length;k<xdata.length;k++){
            serieData.push(0);
            rawData.push($.extend({}, {index: xdata[k]}, query));
        }
    }

    return {data:serieData,rawData:rawData}
}
/**
 * 生成比较后的data
 * @param dataList [[{amount:120,period:'2012/12/12'},{amount:120,period:'2015/12/12'}],
 * [amount:120,period:'2015/12/12'],[...]]
 * @param query 'yyyy/Q'
 */
function generateData(dataList, query) {
    var periods = [], p = [], xdata = [],result = {},serieDatas = [],serieData;
    for (var i = 0; i < dataList.length; i++) {
        p = [];
        for (var j = 0; j < dataList[i].length; j++) {
            p.push(dataList[i][j].period)
        }
        periods.push(p);
    }
    xdata = generateXdata(periods, query);
    result.xdata = xdata;

    for(var k = 0; k < dataList.length; k++){
        serieData = generateSerieData(dataList[k],xdata,query);
        serieDatas.push(serieData);
    }
    result.serieDatas = serieDatas;

    return result;
}

/*比较两周期大小*/
function comparePeriod(x1, x2, y, period) {
    var arrX1, arrX2, arrY, res1, res2, dateX1, dateX2, dateY;
    if (x1 == y)return 1;
    if (x2 == y)return 2;
    arrX1 = x1.split("/");
    arrX2 = x2.split("/");
    arrY = y.split("/");
    var length = period.split("/").length;
    for (var x = 0; x < length; x++) {
        arrX1[x] = parseInt(arrX1[x]);
        arrX2[x] = parseInt(arrX2[x]);
        arrY[x] = parseInt(arrY[x]);
    }
    if (length == 2) {
        dateX1 = new Date(arrX1[0], arrX1[1] - 1);
        dateX2 = new Date(arrX2[0], arrX2[1] - 1);
        dateY = new Date(arrY[0], arrY[1] - 1);
    } else if (length == 3) {
        dateX1 = new Date(arrX1[0], arrX1[1] - 1, arrX1[2]);
        dateX2 = new Date(arrX2[0], arrX2[1] - 1, arrX2[2]);
        dateY = new Date(arrY[0], arrY[1] - 1, arrY[2]);
    } else {
        dateX1 = new Date(arrX1[0], 1);
        dateX2 = new Date(arrX2[0], 1);
        dateY = new Date(arrY[0], 1);
    }
    if (dateX1.getTime() == dateY.getTime())return 1;
    if (dateX2.getTime() == dateY.getTime())return 2;
    if (dateX1.getTime() > dateY.getTime() && dateX2.getTime() > dateY.getTime())return 3;
    if (dateX1.getTime() < dateY && dateX2.getTime() > dateY.getTime())return 0;

    return 4;
}