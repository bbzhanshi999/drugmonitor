<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>供应商配送统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">供应商配送统计</span></header>
    <div class="form-line wide">
        <label for="supporter-startDate">开始日期:</label>
        <input class="easyui-datebox" id="supporter-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="supporter-endDate">结束日期:</label>
        <input class="easyui-datebox" id="supporter-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="supporter-period">统计周期:</label>
        <select class="easyui-combobox" id="supporter-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="supporterSearch" style="width: 50px;">查询</a>
    </div>
    <div class="form-line wide">
        <label for="supporter-organ">医院:</label>
        <input class="easyui-combobox" id="supporter-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <label for="supporter-supporter">供应商:</label>
        <input class="easyui-combobox" id="supporter-supporter" style="width:100px;" data-options="
                    url:'${ctx}/system/getAllSupporter',
                    method:'get',
                    valueField:'id',
                    textField:'supporterName',
                    panelHeight:'auto'">
        <label for="supporter-drugName">药品名称:</label>
        <input class="easyui-textbox" id="supporter-drugName" style="width:100px">
    </div>
    <div class="chart-container supporter"></div>
</div>
<script>
    var supporterQuery;
    var supporterOptsModel = {
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
                "name": "供应商配送总金额",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData:[]
            }
        ]
    };
    $(document).ready(function () {
        $('#supporterSearch').linkbutton({
            onClick:function(){
                var startDate  = $('#supporter-startDate').datebox('getText');
                var endDate  = $('#supporter-endDate').datebox('getText');
                var supporter = $('#supporter-supporter').combobox('getValue');
                var institution = $('#supporter-organ').combobox('getValue');
                var drugName = $('#supporter-drugName').combobox('getText');
                var period = $('#supporter-period').combobox('getValue');
                supporterQuery = {
                    startDate:startDate,
                    endDate:endDate,
                    instoreType:'HD_SIIP_001_007',//设置为供应商配送
                    period:period,
                    supporter:supporter,
                    institution:institution,
                    drugName:drugName};
                supporterSearch(supporterQuery);
            }
        })
    });

    function supporterShowDetail(param){
        var query = supporterOptsModel.series[param.seriesIndex].rawData[param.dataIndex],option = {};
        option.data = query;
        //option.url = '${ctx}/erp/supporterDetail/page';
        option.title = '供应商配送明细';
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
                {field: 'acceptDate', title: '供应商配送时间' },
                {field: 'areaName', title: '所属区域' }
            ]],
            remoteFilter:true
        };
        openGridDialog(option);
    }

    function supporterSearch(query){
        $.post(ctx + '/erp/instoreData', query, function (result) {
            var startDate  = $('#supporter-startDate').datebox('getText');
            var endDate  = $('#supporter-endDate').datebox('getText');
            var supporter = $('#supporter-supporter').combobox('getText')||'所有';
            var institution = $('#supporter-organ').combobox('getText')||'全区';
            var drugName = $('#supporter-drugName').combobox('getText')||'所有';
            var period = $('#supporter-period').combobox('getText')||'天';
            var series = [],xdata = [],rawData=[],title,subTitle;
            debugger;
            title = startDate+'~'+endDate+'供应商配送金额统计';
            subTitle = '机构:'+institution+'   药品:'+drugName+'   供应商:'+supporter+'   周期:'+period;
            supporterOptsModel.title.text = title;//xAxis.data,series.data
            supporterOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].period);
                rawData.push($.extend({},{index:result[x].period},query));
            }
            supporterOptsModel.xAxis[0].data = xdata;
            supporterOptsModel.series[0].rawData = rawData;
            supporterOptsModel.series[0].data = series;
            var supporterChart  =require('echarts').init($('.chart-container.supporter')[0],echartTheme);
            supporterChart.setOption(supporterOptsModel);
            supporterChart.on(ecConfig.EVENT.CLICK, supporterShowDetail);
        }, 'json');
    }



</script>
</body>
</html>
