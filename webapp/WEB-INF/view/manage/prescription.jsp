<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>医院处方发药汇总</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">医院处方发药汇总</span></header>
    <div class="form-line wide">
        <label for="prescription-startDate">开始日期:</label>
        <input class="easyui-datebox" id="prescription-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="prescription-endDate">结束日期:</label>
        <input class="easyui-datebox" id="prescription-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="prescription-period">统计周期:</label>
        <select class="easyui-combobox" id="prescription-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="prescription-organ">医院:</label>
        <input class="easyui-combobox" id="prescription-organ" style="width:200px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    multiple:true,
                    multiline:true,
                    panelHeight:'auto'">
        <label for="prescription-drugName">药品名称:</label>
        <input class="easyui-textbox" id="prescription-drugName" style="width:100px">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="prescriptionSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container prescription"></div>
</div>
<script>
    var prescriptionQuery;
    var prescriptionOptsModel = {
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
        $('#prescriptionSearch').linkbutton({
            onClick: function () {
                debugger;
                var startDate = $('#prescription-startDate').datebox('getText');
                var endDate = $('#prescription-endDate').datebox('getText');
                var period = $('#prescription-period').combobox('getValue');
                var institution = $('#prescription-organ').combobox('getValues').join(",");
                var drugName = $('#prescription-drugName').combobox('getText');

                prescriptionQuery = {
                    startDate: startDate,
                    endDate: endDate,
                    period: period,
                    drugName:drugName,
                    institution: institution,
                    prescriptionType: ''
                };
                prescriptionSearch(prescriptionQuery);
            }
        })
    });


    function prescriptionSearch(query) {
        $.post(ctx + '/manage/prescriptionData', query, function (result) {
            var drugName = $('#prescription-drugName').combobox('getText') || '所有',startDate = $('#prescription-startDate').datebox('getText'), endDate = $('#prescription-endDate').datebox('getText'),
                    period = $('#prescription-period').combobox('getText') || '天';
            var title = '医院处方发药汇总';
            var subTitle = '   周期:' + period+'    药品:'+drugName;
            prescriptionOptsModel.title.text = title;//xAxis.data,series.data
            prescriptionOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            var xdata = [], serieDatas = [], legendData = [], dataList = [], compareResult;
            for (var i = 0; i < result.length; i++) {
                legendData.push(result[i].institution);
                dataList.push(result[i].data);
            }
            compareResult = generateData(dataList, query);
            serieDatas = compareResult.serieDatas;
            xdata = compareResult.xdata;

            prescriptionOptsModel.legend.data = legendData;
            prescriptionOptsModel.xAxis[0].data = xdata;
            prescriptionOptsModel.series =[];
            for (var j = 0; j < result.length; j++) {
                prescriptionOptsModel.series.push({
                    "name": result[j].institution,
                    "type": "line",
                    "data": serieDatas[j].data,
                    rawData: serieDatas[j].rawData
                })
            }


            var prescriptionChart = require('echarts').init($('.chart-container.prescription')[0], echartTheme);
            prescriptionChart.setOption(prescriptionOptsModel);
        }, 'json');
    }


</script>
</body>
</html>
