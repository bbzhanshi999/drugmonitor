<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>入库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">入库信息汇总统计</span></header>
    <div class="form-line wide">
        <label for="drugInDrugName">药品名称:</label>
        <select id="drugInDrugName" style="width: 90px"></select>
        <label for="drugInYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="drugInYear" id="drugInYear" style="width: 60px"/>
        <label for="drugInSeason">季度:</label>
        <select id="drugInSeason" style="width: 60px"></select>
        <label for="drugInMonth">月份:</label>
        <select id="drugInMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="drugInSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container drugIn amount" style="width: 45%;height:80%"></div>
    <div class="chart-container drugIn count" style="width: 45%;height:80%"></div>
</div>
<script>
    var drugInAmountOptsModel = {
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
    var drugInCountOptsModel = {
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
        $('#drugInDrugName').combobox({
            valueField: 'drugName',
            textField: 'drugName',
            url:'${ctx}/inAndOut/getDrugNames',
            prompt:'药品名'
        });

        $('#drugInMonth').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'月份'
        });

        $('#drugInSeason').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'季度',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#drugInMonth').combobox('loadData', [{
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
                            $('#drugInMonth').combobox('loadData', [{
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
                            $('#drugInMonth').combobox('loadData', [{
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
                            $('#drugInMonth').combobox('loadData', [{
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
                            $('#drugInMonth').combobox('loadData', [{
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

        $('#drugInSeason').combobox('loadData',[{
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
        $('#drugInSeason').combobox('setValue','${initSeason}');
        $('#drugInMonth').combobox('setValue','${initMonth}');

        $('#drugInSearch').linkbutton({
            onClick:function(){
                var drugName = $('#drugInDrugName').combobox('getValue');
                var year  = $('#drugInYear').numberspinner('getValue');
                var season = $('#drugInSeason').combobox('getValue');
                var month = $('#drugInMonth').combobox('getValue');
                drugInSearch(year,season,month,drugName);
            }
        })
    });

    function drugInSearch(year,season,month,drugName){
        $.post(ctx + '/inAndOut/inData', {year: year,season:season,month:month,drugName:drugName}, function (result) {
            debugger;
            var amountSeries = [], lengendData = [],countSeries=[],subTitle;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                subTitle=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                subTitle=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                subTitle=year+'年度统计';
            }
            drugInAmountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            drugInCountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if(drugName){
                drugInAmountOptsModel.title.text ='药品入金额统计'+'('+drugName+')';
                drugInCountOptsModel.title.text ='药品入数量统计'+'('+drugName+')';
            }else{
                drugInAmountOptsModel.title.text ='药品入金额统计(汇总)';
                drugInCountOptsModel.title.text ='药品入金额统计(汇总)';
            }
            for(var x= 0;x<result.length;x++){
                amountSeries.push({value:result[x].amount,name:result[x].area});
                lengendData.push(result[x].area);
                countSeries.push({value:result[x].count,name:result[x].area});
            }
            drugInAmountOptsModel.legend.data = lengendData;
            drugInCountOptsModel.legend.data = lengendData;
            drugInAmountOptsModel.series[0].data = amountSeries;
            drugInCountOptsModel.series[0].data = countSeries;
            var drugInAmountChart  =require('echarts').init($('.chart-container.drugIn.amount')[0],echartTheme);
            drugInAmountChart.setOption(drugInAmountOptsModel);
            var drugInCountChart  =require('echarts').init($('.chart-container.drugIn.count')[0],echartTheme);
            drugInCountChart.setOption(drugInCountOptsModel);

            /*var ecConfig = require('echarts/config');
             drugInChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    drugInSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
