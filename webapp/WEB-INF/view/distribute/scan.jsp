<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>入库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">医院扫码统计</span></header>
    <div class="form-line wide">
        <label for="scan-startDate">开始日期:</label>
        <input class="easyui-datebox" id="scan-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="scan-endDate">结束日期:</label>
        <input class="easyui-datebox" id="scan-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="scan-period">统计周期:</label>
        <select class="easyui-combobox" id="scan-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
        <label for="scan-organ">医院:</label>
        <input class="easyui-combobox" id="scan-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="scanSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container scan"></div>
</div>
<script>
    var scanQuery;
    var scanOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.value + '次'+'<br/><span style="color:red">点击查看明细</span>';
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
                    formatter: '{value}次',    // Template formatter!
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
                "name": "扫码总次数",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData:[]
            }
        ]
    };
    $(document).ready(function () {
        $('#scanSearch').linkbutton({
            onClick:function(){
                var startDate  = $('#scan-startDate').datebox('getText');
                var endDate  = $('#scan-endDate').datebox('getText');
                var institution = $('#scan-organ').combobox('getValue');
                var period = $('#scan-period').combobox('getValue');
                scanQuery = {
                    startDate:startDate,
                    endDate:endDate,
                    period:period,
                    institution:institution};
                scanSearch(scanQuery);
            }
        })
    });

    function scanShowDetail(param){
        var query = scanOptsModel.series[param.seriesIndex].rawData[param.dataIndex],option = {};
        option.data = query;
        //option.url = '${ctx}/erp/scanDetail/page';
        option.title = '扫码明细';
        option.dialogConfig ={
            url: ctx + '/distribute/scanDetail',
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
                {field: 'code', title: '条码号'},
                {field: 'status', title: '状态' },
                {field: 'drugType', title: '药品种类' },
                {field: 'manufacture', title: '制造商' },
                {field: 'addDate', title: '添加时间' }
            ]],
            remoteFilter:true
        };
        openGridDialog(option);
    }

    function scanSearch(query){
        $.post(ctx + '/distribute/scanData', query, function (result) {
            var startDate  = $('#scan-startDate').datebox('getText');
            var endDate  = $('#scan-endDate').datebox('getText');
            var institution = $('#scan-organ').combobox('getText')||'全区';
            var period = $('#scan-period').combobox('getText')||'天';
            var series = [],xdata = [],rawData=[],title,subTitle;
            debugger;
            title = startDate+'~'+endDate+'医院扫码统计';
            subTitle = '机构:'+institution+'   周期:'+period;
            scanOptsModel.title.text = title;//xAxis.data,series.data
            scanOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].period);
                rawData.push($.extend({},{index:result[x].period},query));
            }
            scanOptsModel.xAxis[0].data = xdata;
            scanOptsModel.series[0].rawData = rawData;
            scanOptsModel.series[0].data = series;
            var scanChart  =require('echarts').init($('.chart-container.scan')[0],echartTheme);
            scanChart.setOption(scanOptsModel);
            scanChart.on(ecConfig.EVENT.CLICK, scanShowDetail);
        }, 'json');
    }



</script>
</body>
</html>
