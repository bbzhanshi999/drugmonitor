<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>医院月进销存汇总统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">医院月进销存汇总统计</span></header>
    <div class="form-line wide">
        <label for="erp-monthDate">时间:</label>
        <input class="easyui-datebox" id="erp-monthDate" data-options="formatter:myformatter,
        parser:myparser,
        value:myformatter(new Date())" style="width:100px">
        <label for="erp-organ">医院:</label>
        <input class="easyui-combobox" id="erp-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="erpSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container erp"></div>
</div>
<script>
    var erpQuery;
    var erpOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.value + '万元<br/>时间：' + params[1] + '<br/><span style="color:red">点击查看明细</span>';
                return res;
            },
            // trigger: 'axis'
        },
        legend: {
            orient: 'horizontal', // 'vertical'
            x: 'right', // 'center' | 'left' | {number},
            y: 'top',
            data: ['入库', '出库']
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
                itemStyle: {
                    normal: {
                        color: '#C05C81'
                    }
                }
            },
            {
                "name": "入库",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData: [],
                itemStyle: {
                    normal: {
                        color: '#6D5FC0'
                    }
                }
            },
            {
                "name": "结存",
                "type": "bar",
                /*待设置*/
                "data": [],
                rawData: []
            }

        ]
    };
    $(document).ready(function () {
        $('#erpSearch').linkbutton({
            onClick: function () {
                var monthDate = $('#erp-monthDate').datebox('getText');
                var institution = $('#erp-organ').combobox('getValue');
                erpQuery = {
                    monthDate: monthDate,
                    period: 'yyyy/mm',
                    institution: institution
                };
                erpSearch(erpQuery);
            }
        })
    });

    function erpShowDetail(param) {
        debugger;
        var query = erpOptsModel.series[param.seriesIndex].rawData[param.dataIndex], option = {}, url, columns = [];
        switch (param.seriesIndex) {
            case 1:
                option.title = '入库明细';
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
            case 0:
                option.title = '出库明细';
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
            case 2:
                option.title = '结存明细';
                url = ctx + '/erp/surplusDetail';
                columns = [[
                    {field: 'drugName', title: '药品名称'},
                    {field: 'organName', title: '所属机构'},
                    {field: 'count', title: '数量'},
                    {field: 'amount', title: '金额'},
                    {field: 'surplusDate', title: '结存时间'}
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


    function erpSearch(query) {
        $.post(ctx + '/erp/erpData', query, function (result) {
            var month = $('#erp-monthDate').datebox('getText').split("-");
            month = month[0]+"-"+month[1];
            var institution = $('#erp-organ').combobox('getText') || '全区',title;
            title =  institution+month+'月进销存汇总统计';
            query.startDate = result.startDate;
            query.endDate = result.endDate;
            erpOptsModel.title.text = title;//xAxis.data,series.data
            erpOptsModel.xAxis[0].data = [month];
            erpOptsModel.series[0].data = [result.out[0].amount];
            erpOptsModel.series[1].data = [result.in[0].amount];
            erpOptsModel.series[2].data = [result.surplus[0].amount];
            erpOptsModel.series[0].rawData = [$.extend({},{index:result.out[0].period},query)];
            erpOptsModel.series[1].rawData = [$.extend({},{index:result.in[0].period},query)];
            erpOptsModel.series[2].rawData = [$.extend({},{index:result.surplus[0].period},query)];

            var erpChart = require('echarts').init($('.chart-container.erp')[0], echartTheme);
            erpChart.setOption(erpOptsModel);
            erpChart.on(ecConfig.EVENT.CLICK, erpShowDetail);
        }, 'json');
    }


</script>
</body>
</html>
