<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>药品分类采购汇总</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">药品分类采购汇总</span></header>
    <div class="form-line wide">
        <label for="classify-startDate">开始日期:</label>
        <input class="easyui-datebox" id="classify-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="classify-endDate">结束日期:</label>
        <input class="easyui-datebox" id="classify-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:80px">
        <label for="classify-period">统计周期:</label>
        <select class="easyui-combobox" id="classify-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="classify-organ">医院:</label>
        <input class="easyui-combobox" id="classify-organ" style="width:200px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="classifySearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container classify"></div>
</div>
<script>
    var classifyQuery;
    var classifyOptsModel = {
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
        $('#classifySearch').linkbutton({
            onClick: function () {
                debugger;
                var startDate = $('#classify-startDate').datebox('getText');
                var endDate = $('#classify-endDate').datebox('getText');
                var period = $('#classify-period').combobox('getValue');
                var institution = $('#classify-organ').combobox('getValue');

                classifyQuery = {
                    startDate: startDate,
                    endDate: endDate,
                    period: period,
                    institution: institution,
                    instoreType: 'HD_SIIP_001_007'//设置类型为采购
                };
                classifySearch(classifyQuery);
            }
        })
    });


    function classifySearch(query) {
        $.post(ctx + '/manage/classifyData', query, function (result) {
            var startDate = $('#classify-startDate').datebox('getText'), endDate = $('#classify-endDate').datebox('getText'),
                    period = $('#classify-period').combobox('getText') || '天';
            var title = '药品采购汇总';
            var subTitle = '   周期:' + period;
            classifyOptsModel.title.text = title;//xAxis.data,series.data
            classifyOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            var xdata = [], serieDatas = [], legendData = [], dataList = [], compareResult;
            for (var i = 0; i < result.length; i++) {
                legendData.push(result[i].drugType);
                dataList.push(result[i].data);
            }
            compareResult = generateData(dataList, query);
            serieDatas = compareResult.serieDatas;
            xdata = compareResult.xdata;

            classifyOptsModel.legend.data = legendData;
            classifyOptsModel.xAxis[0].data = xdata;
            classifyOptsModel.series =[];
            for (var j = 0; j < result.length; j++) {
                classifyOptsModel.series.push({
                    "name": result[j].drugType,
                    "type": "line",
                    "data": serieDatas[j].data,
                    rawData: serieDatas[j].rawData
                })
            }

            //todo
            var classifyChart = require('echarts').init($('.chart-container.classify')[0], echartTheme);
            classifyChart.setOption(classifyOptsModel);
        }, 'json');
    }


</script>
</body>
</html>
