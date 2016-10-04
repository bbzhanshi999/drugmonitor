<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>药品采购统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">药品采购统计</span></header>
    <div class="form-line wide">
        <label for="supplyDrugDrugName">药品名称:</label>
        <select id="supplyDrugDrugName" style="width: 90px"></select>
        <label for="supplyDrugYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="supplyDrugYear" id="supplyDrugYear" style="width: 60px"/>
        <label for="supplyDrugSeason">季度:</label>
        <select id="supplyDrugSeason" style="width: 60px"></select>
        <label for="supplyDrugMonth">月份:</label>
        <select id="supplyDrugMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="supplyDrugSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container supplyDrug amount" style="width: 45%;height:80%"></div>
    <div class="chart-container supplyDrug count" style="width: 45%;height:80%"></div>
</div>
<script>
    var supplyDrugAmountOptsModel = {
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
    var supplyDrugCountOptsModel = {
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
        $('#supplyDrugDrugName').combobox({
            valueField: 'drugName',
            textField: 'drugName',
            url:'${ctx}/supply/getDrugNames',
            prompt:'药品名'
        });

        $('#supplyDrugMonth').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'月份'
        });

        $('#supplyDrugSeason').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'季度',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#supplyDrugMonth').combobox('loadData', [{
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
                            $('#supplyDrugMonth').combobox('loadData', [{
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
                            $('#supplyDrugMonth').combobox('loadData', [{
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
                            $('#supplyDrugMonth').combobox('loadData', [{
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
                            $('#supplyDrugMonth').combobox('loadData', [{
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

        $('#supplyDrugSeason').combobox('loadData',[{
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
        $('#supplyDrugSeason').combobox('setValue','${initSeason}');
        $('#supplyDrugMonth').combobox('setValue','${initMonth}');

        $('#supplyDrugSearch').linkbutton({
            onClick:function(){
                var drugName = $('#supplyDrugDrugName').combobox('getValue');
                var year  = $('#supplyDrugYear').numberspinner('getValue');
                var season = $('#supplyDrugSeason').combobox('getValue');
                var month = $('#supplyDrugMonth').combobox('getValue');
                supplyDrugSearch(year,season,month,drugName);
            }
        })
    });

    function supplyDrugSearch(year,season,month,drugName){
        $.post(ctx + '/supply/drugData', {year: year,season:season,month:month,drugName:drugName}, function (result) {
            debugger;
            var amountSeries = [], lengendData = [],countSeries=[],subTitle;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                subTitle=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                subTitle=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                subTitle=year+'年度统计';
            }
            supplyDrugAmountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            supplyDrugCountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if(drugName){
                supplyDrugAmountOptsModel.title.text ='药品采购金额统计'+'('+drugName+')';
                supplyDrugCountOptsModel.title.text ='药品采购数量统计'+'('+drugName+')';
            }else{
                supplyDrugAmountOptsModel.title.text ='药品采购金额统计(汇总)';
                supplyDrugCountOptsModel.title.text ='药品采购数量统计(汇总)';
            }
            for(var x= 0;x<result.length;x++){
                amountSeries.push({value:result[x].amount,name:result[x].area});
                lengendData.push(result[x].area);
                countSeries.push({value:result[x].count,name:result[x].area});
            }
            supplyDrugAmountOptsModel.legend.data = lengendData;
            supplyDrugCountOptsModel.legend.data = lengendData;
            supplyDrugAmountOptsModel.series[0].data = amountSeries;
            supplyDrugCountOptsModel.series[0].data = countSeries;
            var supplyDrugAmountChart  =require('echarts').init($('.chart-container.supplyDrug.amount')[0],echartTheme);
            supplyDrugAmountChart.setOption(supplyDrugAmountOptsModel);
            var supplyDrugCountChart  =require('echarts').init($('.chart-container.supplyDrug.count')[0],echartTheme);
            supplyDrugCountChart.setOption(supplyDrugCountOptsModel);

            /*var ecConfig = require('echarts/config');
             supplyDrugChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    supplyDrugSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
