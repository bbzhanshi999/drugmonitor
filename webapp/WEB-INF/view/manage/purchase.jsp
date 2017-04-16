<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>药品采购汇总统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">药品采购汇总统计</span></header>
    <div class="form-line wide">
        <label for="purchase-startDate">开始日期:</label>
        <input class="easyui-datebox" id="purchase-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="purchase-endDate">结束日期:</label>
        <input class="easyui-datebox" id="purchase-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="purchase-period">统计周期:</label>
        <select class="easyui-combobox" id="purchase-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="purchase-organ">医院:</label>
        <input class="easyui-combobox" id="purchase-organ" style="width:200px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    multiple:true,
                    multiline:true,
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="purchaseSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container purchase"></div>
</div>
<script>
    var purchaseQuery;
    var purchaseOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.value + '万元<br/>时间：' + params[1];
                return res;
            },
            // trigger: 'axis'
        },
        legend: {
            orient: 'horizontal', // 'vertical'
            x: 'right', // 'center' | 'left' | {number},
            y: 'top',
            data: []//待设置
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
        series: []/*待设置*/
    };
    $(document).ready(function () {
        $('#purchaseSearch').linkbutton({
            onClick: function () {
                debugger;
                var startDate = $('#purchase-startDate').datebox('getText');
                var endDate = $('#purchase-endDate').datebox('getText');
                var period = $('#purchase-period').combobox('getValue');
                var institution = $('#purchase-organ').combobox('getValues').join(",");

                purchaseQuery = {
                    startDate: startDate,
                    endDate: endDate,
                    period: period,
                    institution: institution,
                    instoreType: 'HD_SIIP_001_007'//设置类型为采购
                };
                purchaseSearch(purchaseQuery);
            }
        })
    });


    function purchaseSearch(query) {
        $.post(ctx + '/manage/purchaseData', query, function (result) {
            var startDate = $('#purchase-startDate').datebox('getText'), endDate = $('#purchase-endDate').datebox('getText'),
                    period = $('#purchase-period').combobox('getText') || '天';
            var title = '药品采购汇总';
            var subTitle = '   周期:' + period;
            purchaseOptsModel.title.text = title;//xAxis.data,series.data
            purchaseOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            var xdata = [], serieDatas = [], legendData = [], dataList = [], compareResult;
            for (var i = 0; i < result.length; i++) {
                legendData.push(result[i].institution);
                dataList.push(result[i].data);
            }
            compareResult = generateData(dataList, query);
            serieDatas = compareResult.serieDatas;
            xdata = compareResult.xdata;

            purchaseOptsModel.legend.data = legendData;
            purchaseOptsModel.xAxis[0].data = xdata;
            purchaseOptsModel.series =[];
            for (var j = 0; j < result.length; j++) {
                purchaseOptsModel.series.push({
                    "name": result[j].institution,
                    "type": "line",
                    "data": serieDatas[j].data,
                    rawData: serieDatas[j].rawData
                })
            }

            //todo
            var purchaseChart = require('echarts').init($('.chart-container.purchase')[0], echartTheme);
            purchaseChart.setOption(purchaseOptsModel);
        }, 'json');
    }


</script>
</body>
</html>
