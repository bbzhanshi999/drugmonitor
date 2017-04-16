<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>医院处方发药明细</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">医院处方发药明细</span></header>
    <div class="form-line wide">
        <label for="presDetail-startDate">开始日期:</label>
        <input class="easyui-datebox" id="presDetail-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="presDetail-endDate">结束日期:</label>
        <input class="easyui-datebox" id="presDetail-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="presDetail-period">统计周期:</label>
        <select class="easyui-combobox" id="presDetail-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="presDetail-organ">医院:</label>
        <input class="easyui-combobox" id="presDetail-organ" style="width:200px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    multiple:true,
                    multiline:true,
                    panelHeight:'auto'">
        <label for="presDetail-type">处方类型:</label>
        <input class="easyui-combobox" id="presDetail-type" style="width:100px;" data-options="
                    url:'${ctx}/system/getDicts?type=prescriptionType',
                    method:'get',
                    valueField:'key',
                    textField:'value',
                    panelHeight:'auto'">
        <label for="presDetail-drugName">药品名称:</label>
        <input class="easyui-textbox" id="presDetail-drugName" style="width:100px">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="presDetailSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container presDetail"></div>
</div>
<script>
    var presDetailQuery;
    var presDetailOptsModel = {
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
        $('#presDetailSearch').linkbutton({
            onClick: function () {
                debugger;
                var startDate = $('#presDetail-startDate').datebox('getText');
                var endDate = $('#presDetail-endDate').datebox('getText');
                var period = $('#presDetail-period').combobox('getValue');
                var institution = $('#presDetail-organ').combobox('getValues').join(",");
                var drugName = $('#presDetail-drugName').combobox('getText');
                var presDetailType = $('#presDetail-type').combobox('getValue');

                presDetailQuery = {
                    startDate: startDate,
                    endDate: endDate,
                    period: period,
                    drugName:drugName,
                    institution: institution,
                    prescriptionType: presDetailType
                };
                presDetailSearch(presDetailQuery);
            }
        })
    });


    function presDetailSearch(query) {
        $.post(ctx + '/manage/prescriptionData', query, function (result) {
            var startDate = $('#presDetail-startDate').datebox('getText'), endDate = $('#presDetail-endDate').datebox('getText'),
                    period = $('#presDetail-period').combobox('getText') || '天',prescriptionType = $('#presDetail-type').combobox('getText'),
                    drugName = $('#presDetail-drugName').combobox('getText') || '所有';
            var title = '医院处方发药明细';
            var subTitle = '   周期:' + period+'    处方类型:'+prescriptionType+'    药品:'+drugName;
            presDetailOptsModel.title.text = title;//xAxis.data,series.data
            presDetailOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            var xdata = [], serieDatas = [], legendData = [], dataList = [], compareResult;
            for (var i = 0; i < result.length; i++) {
                legendData.push(result[i].institution);
                dataList.push(result[i].data);
            }
            compareResult = generateData(dataList, query);
            serieDatas = compareResult.serieDatas;
            xdata = compareResult.xdata;

            presDetailOptsModel.legend.data = legendData;
            presDetailOptsModel.xAxis[0].data = xdata;
            presDetailOptsModel.series =[];
            for (var j = 0; j < result.length; j++) {
                presDetailOptsModel.series.push({
                    "name": result[j].institution,
                    "type": "line",
                    "data": serieDatas[j].data,
                    rawData: serieDatas[j].rawData
                })
            }


            var presDetailChart = require('echarts').init($('.chart-container.presDetail')[0], echartTheme);
            presDetailChart.setOption(presDetailOptsModel);
        }, 'json');
    }


</script>
</body>
</html>
