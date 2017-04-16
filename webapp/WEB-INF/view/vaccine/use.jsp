<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>疫苗使用统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">疫苗使用统计</span></header>
    <div class="form-line wide">
        <label for="vaccineUse-startDate">开始日期:</label>
        <input class="easyui-datebox" id="vaccineUse-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="vaccineUse-endDate">结束日期:</label>
        <input class="easyui-datebox" id="vaccineUse-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="vaccineUse-period">统计周期:</label>
        <select class="easyui-combobox" id="vaccineUse-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="vaccineUse-organ">医院:</label>
        <input class="easyui-combobox" id="vaccineUse-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="vaccineUseSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container vaccineUse"></div>
</div>
<script>
    var vaccineUseQuery;
    var vaccineUseOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.value + '万元<br/>时间：'+params[1]+'<br/><span style="color:red">点击查看明细</span>';
                return res;
            },
            // trigger: 'axis'
        },
        legend: {
            orient: 'horizontal', // 'vertical'
            x: 'right', // 'center' | 'left' | {number},
            y: 'top',
            data:['入库','出库']
        },
        /*待设置*/
        title: {
            text: '',
            subtext: ''
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
                "name": "出库",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData: [],
                itemStyle:{normal: {
                    color:'#C05C81'
                }}
            },
            {
                "name": "入库",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData: [],
                itemStyle:{normal: {
                    color:'#6D5FC0'
                }}
            }

        ]
    };
    $(document).ready(function () {
        $('#vaccineUseSearch').linkbutton({
            onClick: function () {
                var startDate = $('#vaccineUse-startDate').datebox('getText');
                var endDate = $('#vaccineUse-endDate').datebox('getText');
                var institution = $('#vaccineUse-organ').combobox('getValue');
                var period = $('#vaccineUse-period').combobox('getValue');
                vaccineUseQuery = {
                    startDate: startDate,
                    endDate: endDate,
                    period: period,
                    institution: institution,
                    vaccine:'1'
                };
                vaccineUseSearch(vaccineUseQuery);
            }
        })
    });

    function vaccineUseShowDetail(param) {
        debugger;
        var query = vaccineUseOptsModel.series[param.seriesIndex].rawData[param.dataIndex], option = {}, url, columns = [];
        switch (param.seriesIndex) {
            case 0:
                option.title = '疫苗入库明细';
                url = ctx + '/erp/instoreDetail';
                columns = [[
                    {field: 'drugName', title: '药品名称'},
                    {field: 'organName', title: '所属机构'},
                    {field: 'supporter', title: '供应商'},
                    {field: 'count', title: '数量'},
                    {field: 'amount', title: '金额'},
                    {field: 'acceptType', title: '入库类型'},
                    {field: 'acceptDate', title: '入库时间'},
                    {field: 'areaName', title: '所属区域'}
                ]];
                break;
            case 1:
                option.title = '疫苗出库明细';
                url = ctx + '/erp/outstoreDetail';
                columns = [[
                    {field: 'drugName', title: '药品名称'},
                    {field: 'organName', title: '所属机构'},
                    {field: 'supporter', title: '供应商'},
                    {field: 'count', title: '数量'},
                    {field: 'amount', title: '金额'},
                    {field: 'outType', title: '出库类型'},
                    {field: 'outDate', title: '出库时间'},
                    {field: 'areaName', title: '所属区域'}
                ]];
                break;
        }
        option.data = query;
        option.dialogConfig = {
            url: url,
            pagination: true,
            pageSize: 30,
            queryParams: query,
            singleSelect: true,
            fit: true,
            border: false,
            striped: true,
            /*fitColumns: true,*/
            loadMsg: '数据加载中',
            emptyMsg: '无数据',
            fitColumns: true,
            columns: columns,
            remoteFilter: true
        };
        openGridDialog(option);
    }




    function vaccineUseSearch(query) {
        $.post(ctx + '/erp/storageData', query, function (result) {
            var startDate = $('#vaccineUse-startDate').datebox('getText');
            var endDate = $('#vaccineUse-endDate').datebox('getText');
            var institution = $('#vaccineUse-organ').combobox('getText') || '全区';
            var period = $('#vaccineUse-period').combobox('getText') || '天';
            var seriesIn = [], xdata = [], rawDataIn = [], seriesOut = [], rawDataOut = [],
                    title, subTitle, inResult = result.inResult, outResult = result.outResult, mark = 0, flag = true, compare, start, second;
            title = startDate + '~' + endDate + '疫苗使用统计';
            subTitle = '机构:' + institution + '   周期:' + period;
            vaccineUseOptsModel.title.text = title;//xAxis.data,series.data
            vaccineUseOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if (inResult.length == 0 || outResult.length == 0) {
                if (inResult.length == 0) {
                    vaccineUseOptsModel.xAxis[0].data = [];
                    vaccineUseOptsModel.series[0].rawData = [];
                    vaccineUseOptsModel.series[0].data = [];
                } else {
                    for (var a = 0; a < inResult.length; a++) {
                        seriesIn.push(inResult[a].amount);
                        xdata.push(inResult[a].period);
                        rawDataIn.push($.extend({}, {index: inResult[a].period}, query));
                    }
                    vaccineUseOptsModel.xAxis[0].data = xdata;
                    vaccineUseOptsModel.series[0].rawData = seriesIn;
                    vaccineUseOptsModel.series[0].data = rawDataIn;
                }
                if (outResult.length == 0) {
                    vaccineUseOptsModel.series[1].rawData = [];
                    vaccineUseOptsModel.series[1].data = [];
                } else {
                    for (var b = 0; b < outResult.length; b++) {
                        seriesIn.push(outResult[b].amount);
                        xdata.push(outResult[b].period);
                        rawDataIn.push($.extend({}, {index: outResult[b].period}, query));
                    }
                    vaccineUseOptsModel.xAxis[0].data = xdata;
                    vaccineUseOptsModel.series[1].rawData = seriesOut;
                    vaccineUseOptsModel.series[1].data = rawDataOut;
                }
            } else {
                compare = comparePeriod(inResult[0].period, inResult[1].period, outResult[0].period, query.period);
                if (compare == 3) {
                    start = outResult;
                    second = inResult;
                    flag = false;
                } else {
                    start = inResult;
                    second = outResult;
                }
                for (var x = 0; x < start.length; x++) {
                    seriesIn.push(start[x].amount);
                    xdata.push(start[x].period);
                    rawDataIn.push($.extend({}, {index: start[x].period}, query));
                    for (var y = mark; y < second.length; y++) {
                        compare = comparePeriod(start[x].period, start[x + 1] ? start[x + 1].period : start[x].period, second[y].period, query.period);
                        if (compare == 0) {
                            xdata.push(second[y].period);
                            seriesOut.push(second[y].amount);
                            rawDataOut.push($.extend({}, {index: second[y].period}, query));
                            seriesIn.push(0);
                            rawDataIn.push($.extend({}, {index: second[y].period}, query));
                            mark++;
                        } else if (compare == 1) {
                            seriesOut.push(second[y].amount);
                            rawDataOut.push($.extend({}, {index: second[y].period}, query));
                            mark++;
                        }
                    }
                }

                vaccineUseOptsModel.xAxis[0].data = xdata;
                debugger;
                if (flag) {
                    vaccineUseOptsModel.series[0].rawData = rawDataIn;
                    vaccineUseOptsModel.series[0].data = seriesIn;
                    vaccineUseOptsModel.series[1].rawData = rawDataOut;
                    vaccineUseOptsModel.series[1].data = seriesOut;
                } else {
                    vaccineUseOptsModel.series[1].rawData = rawDataIn;
                    vaccineUseOptsModel.series[1].data = seriesIn;
                    vaccineUseOptsModel.series[0].rawData = rawDataOut;
                    vaccineUseOptsModel.series[0].data = seriesOut;
                }
            }
            var vaccineUseChart = require('echarts').init($('.chart-container.vaccineUse')[0], echartTheme);
            vaccineUseChart.setOption(vaccineUseOptsModel);
            vaccineUseChart.on(ecConfig.EVENT.CLICK, vaccineUseShowDetail);
        }, 'json');
    }


</script>
</body>
</html>
