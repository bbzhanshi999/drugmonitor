<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>疫苗采购入库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">疫苗采购入库统计</span></header>
    <div class="form-line wide">
        <label for="vaccineIn-startDate">开始日期:</label>
        <input class="easyui-datebox" id="vaccineIn-startDate" data-options="formatter:myformatter,
        parser:myparser,
        onSelect:startDateOnSelect,
        value:myformatter(new Date())" style="width:100px">
        <label for="vaccineIn-endDate">结束日期:</label>
        <input class="easyui-datebox" id="vaccineIn-endDate"
               data-options="formatter:myformatter,parser:myparser,value:myformatter(new Date())" style="width:100px">
        <label for="vaccineIn-period">统计周期:</label>
        <select class="easyui-combobox" id="vaccineIn-period" data-options="value:'yyyy/mm/dd'" style="width:60px;">
            <option value="yyyy">年</option>
            <option value="yyyy/Q">季度</option>
            <option value="yyyy/mm">月</option>
            <option value="yyyy/mm/dd">日</option>
        </select>
    </div>
    <div class="form-line wide">
        <label for="vaccineIn-organ">医院:</label>
        <input class="easyui-combobox" id="vaccineIn-organ" style="width:100px;" data-options="
                    url:'${ctx}/dataPermission/getAllOrganizations',
                    method:'get',
                    valueField:'id',
                    textField:'organName',
                    panelHeight:'auto'">
        <span class="interval" style="width: 60px"></span>
        <a href="#" id="vaccineInSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container vaccineIn"></div>
</div>
<script>
    var vaccineInQuery;
    var vaccineInOptsModel = {
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
        $('#vaccineInSearch').linkbutton({
            onClick:function(){
                var startDate  = $('#vaccineIn-startDate').datebox('getText');
                var endDate  = $('#vaccineIn-endDate').datebox('getText');
                var institution = $('#vaccineIn-organ').combobox('getValue');
                var period = $('#vaccineIn-period').combobox('getValue');
                vaccineInQuery = {
                    startDate:startDate,
                    endDate:endDate,
                    instoreType:'HD_SIIP_001_007',
                    period:period,
                    institution:institution,
                    vaccine:'1'};
                vaccineInSearch(vaccineInQuery);
            }
        })
    });

    function vaccineInShowDetail(param){
        var query = vaccineInOptsModel.series[param.seriesIndex].rawData[param.dataIndex],option = {};
        option.data = query;
        //option.url = '${ctx}/erp/vaccineInDetail/page';
        option.title = '疫苗采购入库明细';
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
         url: '${ctx}/erp/vaccineInDetail',
         data: query,
         dataType: 'json',
         cache: false,
         success: function (result) {
         console.log(result);
         }
         });*/
    }

    function vaccineInSearch(query){
        $.post(ctx + '/erp/instoreData', query, function (result) {
            var startDate  = $('#vaccineIn-startDate').datebox('getText');
            var endDate  = $('#vaccineIn-endDate').datebox('getText');
            var institution = $('#vaccineIn-organ').combobox('getText')||'全区';
            var period = $('#vaccineIn-period').combobox('getText')||'天';
            var series = [],xdata = [],rawData=[],title,subTitle;

            title = '疫苗采购入库统计';
            subTitle = '机构:'+institution+'   周期:'+period;
            vaccineInOptsModel.title.text = title;//xAxis.data,series.data
            vaccineInOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].period);
                rawData.push($.extend({},{index:result[x].period},query));
            }
            vaccineInOptsModel.xAxis[0].data = xdata;
            vaccineInOptsModel.series[0].rawData = rawData;
            vaccineInOptsModel.series[0].data = series;
            var vaccineInChart  =require('echarts').init($('.chart-container.vaccineIn')[0],echartTheme);
            vaccineInChart.setOption(vaccineInOptsModel);
            vaccineInChart.on(ecConfig.EVENT.CLICK, vaccineInShowDetail);
        }, 'json');
    }



</script>
</body>
</html>
