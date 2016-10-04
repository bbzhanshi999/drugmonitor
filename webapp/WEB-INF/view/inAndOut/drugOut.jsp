<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>出库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">c出库信息汇总统计</span></header>
    <div class="form-line wide">
        <label for="drugOutDrugName">药品名称:</label>
        <select id="drugOutDrugName" style="width: 90px"></select>
        <label for="drugOutYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="drugOutYear" id="drugOutYear" style="width: 60px"/>
        <label for="drugOutSeason">季度:</label>
        <select id="drugOutSeason" style="width: 60px"></select>
        <label for="drugOutMonth">月份:</label>
        <select id="drugOutMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="drugOutSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container drugOut amount" style="width: 45%;height:80%"></div>
    <div class="chart-container drugOut count" style="width: 45%;height:80%"></div>
</div>
<script>
    var drugOutAmountOptsModel = {
        title : {
            text: '',
            /*待修改*/
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c}万元 ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            /*待修改*/
            data:[]
        },

        calculable : true,
        series : [
            {
                name:'占有率',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                /*待修改*/
                data:[]
            }
        ]
    };
    var drugOutCountOptsModel = {
        title : {
            text: '',
            /*待修改*/
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            /*待修改*/
            data:[]
        },

        calculable : true,
        series : [
            {
                name:'占有率',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                /*待修改*/
                data:[]
            }
        ]
    };
    $(document).ready(function () {
        $('#drugOutDrugName').combobox({
            valueField: 'drugName',
            textField: 'drugName',
            url:'${ctx}/inAndOut/getDrugNames',
            prompt:'药品名'
        });

        $('#drugOutMonth').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'月份'
        });

        $('#drugOutSeason').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'季度',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#drugOutMonth').combobox('loadData', [{
                                label: '1',
                                value: '1'
                            }, {
                                label: '2',
                                value: '2'
                            }, {
                                label: '3',
                                value: '3'
                            }]).combobox('clear');
                            break;
                        case 2:
                            $('#drugOutMonth').combobox('loadData', [{
                                label: '4',
                                value: '4'
                            }, {
                                label: '5',
                                value: '5'
                            }, {
                                label: '6',
                                value: '6'
                            }]).combobox('clear');
                            break;
                        case 3:
                            $('#drugOutMonth').combobox('loadData', [{
                                label: '7',
                                value: '7'
                            }, {
                                label: '8',
                                value: '8'
                            }, {
                                label: '9',
                                value: '9'
                            }]).combobox('clear');
                            break;
                        case 4:
                            $('#drugOutMonth').combobox('loadData', [{
                                label: '10',
                                value: '10'
                            }, {
                                label: '11',
                                value: '11'
                            }, {
                                label: '12',
                                value: '12'
                            }]).combobox('clear');
                            break;
                        default:
                            $('#drugOutMonth').combobox('loadData', [{
                                label: '1',
                                value: '1'
                            }, {
                                label: '2',
                                value: '2'
                            }, {
                                label: '3',
                                value: '3'
                            }, {
                                label: '4',
                                value: '4'
                            }, {
                                label: '5',
                                value: '5'
                            }, {
                                label: '6',
                                value: '6'
                            }, {
                                label: '7',
                                value: '7'
                            }, {
                                label: '8',
                                value: '8'
                            }, {
                                label: '9',
                                value: '9'
                            }, {
                                label: '10',
                                value: '10'
                            }, {
                                label: '11',
                                value: '11'
                            }, {
                                label: '12',
                                value: '12'
                            }]).combobox('clear');
                            break;
                    }
                }
            }
        });

        $('#drugOutSeason').combobox('loadData',[{
            label: '1',
            value: '1'
        }, {
            label: '2',
            value: '2'
        }, {
            label: '3',
            value: '3'
        }, {
            label: '4',
            value: '4'
        }]);
        $('#drugOutSeason').combobox('setValue','${initSeason}');
        $('#drugOutMonth').combobox('setValue','${initMonth}');

        $('#drugOutSearch').linkbutton({
            onClick:function(){
                var drugName = $('#drugOutDrugName').combobox('getValue');
                var year  = $('#drugOutYear').numberspinner('getValue');
                var season = $('#drugOutSeason').combobox('getValue');
                var month = $('#drugOutMonth').combobox('getValue');
                drugOutSearch(year,season,month,drugName);
            }
        })
    });

    function drugOutSearch(year,season,month,drugName){
        $.post(ctx + '/inAndOut/outData', {year: year,season:season,month:month,drugName:drugName}, function (result) {
            debugger;
            var amountSeries = [], lengendData = [],countSeries=[],subTitle;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                subTitle=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                subTitle=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                subTitle=year+'年度统计';
            }
            drugOutAmountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            drugOutCountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if(drugName){
                drugOutAmountOptsModel.title.text ='药品入金额统计'+'('+drugName+')';
                drugOutCountOptsModel.title.text ='药品入数量统计'+'('+drugName+')';
            }else{
                drugOutAmountOptsModel.title.text ='药品入金额统计(汇总)';
                drugOutCountOptsModel.title.text ='药品入金额统计(汇总)';
            }
            for(var x= 0;x<result.length;x++){
                amountSeries.push({value:result[x].amount,name:result[x].area});
                lengendData.push(result[x].area);
                countSeries.push({value:result[x].count,name:result[x].area});
            }
            drugOutAmountOptsModel.legend.data = lengendData;
            drugOutCountOptsModel.legend.data = lengendData;
            drugOutAmountOptsModel.series[0].data = amountSeries;
            drugOutCountOptsModel.series[0].data = countSeries;
            var drugOutAmountChart  =require('echarts').init($('.chart-container.drugOut.amount')[0],echartTheme);
            drugOutAmountChart.setOption(drugOutAmountOptsModel);
            var drugOutCountChart  =require('echarts').init($('.chart-container.drugOut.count')[0],echartTheme);
            drugOutCountChart.setOption(drugOutCountOptsModel);

            /*var ecConfig = require('echarts/config');
             drugOutChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    drugOutSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
