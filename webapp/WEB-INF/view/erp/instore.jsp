<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>入库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">入库信息汇总统计</span></header>
    <div class="form-line wide">
        <label for="instore-startDate">开始日期:</label>
        <input class="easyui-datebox" id="instore-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="instore-endDate">结束日期:</label>
        <input class="easyui-datebox" id="instore-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="instore-period">统计周期:</label>
        <select class="easyui-combobox" id="instore-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="instoreSearch" style="width: 50px;">查询</a>
    </div>
    <div class="form-line wide">
        <label for="instore-organ">医院:</label>
        <input class="easyui-combobox" id="instore-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <label for="instore-type">入库类型:</label>
        <input class="easyui-combobox" id="instore-type" style="width:100px;" data-options="
                    url:'${ctx}/system/getDicts?type=instoreType',
                    method:'get',
                    valueField:'key',
                    textField:'value',
                    panelHeight:'auto'">
        <label for="instore-drugName">药品名称:</label>
        <input class="easyui-textbox" id="instore-drugName" style="width:100px">
    </div>
    <div class="chart-container instore"></div>
</div>
<script>
    var instoreQuery;
    var instoreOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.value + '万元'+'<br/><span style="color:red">点击查看明细</span>';
                return res;
            }
        },
        /*待设置*/
        title: {
            text: '',
            subtext:''
        },
        legend: {
            data: ['']
        },
        grid: {
            x: 60,
            y: 60,
            x2: 40,
            y2: 60
        },
        xAxis: [
            {
                type: 'category',
                position: 'bottom',
                boundaryGap: true,
                axisLine: {    // 轴线
                    show: true,
                    lineStyle: {
                        color: 'green',
                        type: 'solid',
                        width: 1
                    }
                },
                axisTick: {    // 轴标记
                    show: true,
                    length: 10,
                    lineStyle: {
                        color: 'red',
                        type: 'solid',
                        width: 1
                    }
                },
                axisLabel: {
                    show: true,
                    interval: '0',
                    margin: 4,
                    textStyle: {
                        color: 'grey',
                        fontSize: 10
                    }
                },
                splitArea: {
                    show: true,
                    areaStyle: {
                        color: ['rgba(144,238,144,0.3)', 'rgba(135,200,250,0.3)']
                    }
                },
                /*待设置*/
                data: []
            }
        ],
        yAxis: [
            {
                type: 'value',
                position: 'left',
                axisLabel: {
                    show: true,
                    interval: '0',    // {number}
                    margin: 4,
                    formatter: '{value}万元',    // Template formatter!
                    textStyle: {
                        color: '#1e90ff',
                        fontSize: 10
                    }
                },
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#483d8b',
                        type: 'dotted',
                        width: 2
                    }
                }
            }
        ],
        series: [
            {
                "name": "入库总金额",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData:[]
            }
        ]
    };
    $(document).ready(function () {
        $('#instoreSearch').linkbutton({
            onClick:function(){
                var startDate  = $('#instore-startDate').datebox('getText');
                var endDate  = $('#instore-endDate').datebox('getText');
                var instoreType = $('#instore-type').combobox('getValue');
                var institution = $('#instore-organ').combobox('getValue');
                var drugName = $('#instore-drugName').combobox('getText');
                var period = $('#instore-period').combobox('getValue');
                instoreQuery = {
                    startDate:startDate,
                    endDate:endDate,
                    instoreType:instoreType,
                    period:period,
                    institution:institution,
                    drugName:drugName};
               instoreSearch(instoreQuery);
            }
        })
    });

    function instoreShowDetail(param){
        var query = instoreOptsModel.series[param.seriesIndex].rawData[param.dataIndex],option = {};
        option.data = query;
        //option.url = '${ctx}/erp/instoreDetail/page';
        option.title = '入库明细';
        option.dialogConfig ={
            url: ctx + '/erp/instoreDetail',
            pagination: true,
            pageSize: 30,
            queryParams:query,
            singleSelect: true,
            fit: true,
            border: false,
            striped:true,
            /*fitColumns: true,*/
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            fitColumns:true,
            columns: [[
                {field: 'drugName', title: '药品名称'},
                {field: 'organName', title: '所属机构'},
                {field: 'supporter', title: '供应商'},
                {field: 'count', title: '数量' },
                {field: 'amount', title: '金额' },
                {field: 'acceptType', title: '入库类型' },
                {field: 'acceptDate', title: '入库时间' },
                {field: 'areaName', title: '所属区域' }
            ]],
            remoteFilter:true
        };
        openGridDialog(option);
       /* $.ajax({
            type:'POST',
            url: '${ctx}/erp/instoreDetail',
            data: query,
            dataType: 'json',
            cache: false,
            success: function (result) {
                console.log(result);
            }
        });*/
    }

    function instoreSearch(query){
        $.post(ctx + '/erp/instoreData', query, function (result) {
            var startDate  = $('#instore-startDate').datebox('getText');
            var endDate  = $('#instore-endDate').datebox('getText');
            var instoreType = $('#instore-type').combobox('getText')||'所有';
            var institution = $('#instore-organ').combobox('getText')||'全区';
            var drugName = $('#instore-drugName').combobox('getText')||'所有';
            var period = $('#instore-period').combobox('getText')||'天';
            var series = [],xdata = [],rawData=[],title,subTitle;
            debugger;
            title = startDate+'~'+endDate+'入库金额统计';
            subTitle = '机构:'+institution+'   药品:'+drugName+'   入库类型:'+instoreType+'   周期:'+period;
            instoreOptsModel.title.text = title;//xAxis.data,series.data
            instoreOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].period);
                rawData.push($.extend({},{index:result[x].period},query));
            }
            instoreOptsModel.xAxis[0].data = xdata;
            instoreOptsModel.series[0].rawData = rawData;
            instoreOptsModel.series[0].data = series;
            var instoreChart  =require('echarts').init($('.chart-container.instore')[0],echartTheme);
            instoreChart.setOption(instoreOptsModel);
            instoreChart.on(ecConfig.EVENT.CLICK, instoreShowDetail);
        }, 'json');
    }



</script>
</body>
</html>
