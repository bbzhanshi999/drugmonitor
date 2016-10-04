<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>药品处方信息统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">药品处方信息统计</span></header>
    <div class="form-line wide">
        <label for="prescriptionDrugDrugName">药品名称:</label>
        <select id="prescriptionDrugDrugName" style="width: 90px"></select>
        <label for="prescriptionDrugYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="prescriptionDrugYear" id="prescriptionDrugYear" style="width: 60px"/>
        <label for="prescriptionDrugSeason">季度:</label>
        <select id="prescriptionDrugSeason" style="width: 60px"></select>
        <label for="prescriptionDrugMonth">月份:</label>
        <select id="prescriptionDrugMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="prescriptionDrugSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container prescriptionDrug amount" style="width: 45%;height:80%"></div>
    <div class="chart-container prescriptionDrug count" style="width: 45%;height:80%"></div>
</div>
<script>
    var prescriptionDrugAmountOptsModel = {
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
    var prescriptionDrugCountOptsModel = {
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
        $('#prescriptionDrugDrugName').combobox({
            valueField: 'drugName',
            textField: 'drugName',
            url:'${ctx}/prescription/getDrugNames',
            prompt:'药品名'
        });

        $('#prescriptionDrugMonth').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'月份'
        });

        $('#prescriptionDrugSeason').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'季度',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#prescriptionDrugMonth').combobox('loadData', [{
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
                            $('#prescriptionDrugMonth').combobox('loadData', [{
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
                            $('#prescriptionDrugMonth').combobox('loadData', [{
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
                            $('#prescriptionDrugMonth').combobox('loadData', [{
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
                            $('#prescriptionDrugMonth').combobox('loadData', [{
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

        $('#prescriptionDrugSeason').combobox('loadData',[{
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
        $('#prescriptionDrugSeason').combobox('setValue','${initSeason}');
        $('#prescriptionDrugMonth').combobox('setValue','${initMonth}');

        $('#prescriptionDrugSearch').linkbutton({
            onClick:function(){
                var drugName = $('#prescriptionDrugDrugName').combobox('getValue');
                var year  = $('#prescriptionDrugYear').numberspinner('getValue');
                var season = $('#prescriptionDrugSeason').combobox('getValue');
                var month = $('#prescriptionDrugMonth').combobox('getValue');
                prescriptionDrugSearch(year,season,month,drugName);
            }
        })
    });

    function prescriptionDrugSearch(year,season,month,drugName){
        $.post(ctx + '/prescription/drugData', {year: year,season:season,month:month,drugName:drugName}, function (result) {
            debugger;
            var amountSeries = [], lengendData = [],countSeries=[],subTitle;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                subTitle=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                subTitle=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                subTitle=year+'年度统计';
            }
            prescriptionDrugAmountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            prescriptionDrugCountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if(drugName){
                prescriptionDrugAmountOptsModel.title.text ='药品处方金额统计'+'('+drugName+')';
                prescriptionDrugCountOptsModel.title.text ='药品处方数量统计'+'('+drugName+')';
            }else{
                prescriptionDrugAmountOptsModel.title.text ='药品处方金额统计(汇总)';
                prescriptionDrugCountOptsModel.title.text ='药品处方数量统计(汇总)';
            }
            for(var x= 0;x<result.length;x++){
                amountSeries.push({value:result[x].amount,name:result[x].area});
                lengendData.push(result[x].area);
                countSeries.push({value:result[x].count,name:result[x].area});
            }
            prescriptionDrugAmountOptsModel.legend.data = lengendData;
            prescriptionDrugCountOptsModel.legend.data = lengendData;
            prescriptionDrugAmountOptsModel.series[0].data = amountSeries;
            prescriptionDrugCountOptsModel.series[0].data = countSeries;
            var prescriptionDrugAmountChart  =require('echarts').init($('.chart-container.prescriptionDrug.amount')[0],echartTheme);
            prescriptionDrugAmountChart.setOption(prescriptionDrugAmountOptsModel);
            var prescriptionDrugCountChart  =require('echarts').init($('.chart-container.prescriptionDrug.count')[0],echartTheme);
            prescriptionDrugCountChart.setOption(prescriptionDrugCountOptsModel);

            /*var ecConfig = require('echarts/config');
             prescriptionDrugChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    prescriptionDrugSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
