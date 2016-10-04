<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>药品配送统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">药品配送统计</span></header>
    <div class="form-line wide">
        <label for="distributeDrugDrugName">药品名称:</label>
        <select id="distributeDrugDrugName" style="width: 90px"></select>
        <label for="distributeDrugYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="distributeDrugYear" id="distributeDrugYear" style="width: 60px"/>
        <label for="distributeDrugSeason">季度:</label>
        <select id="distributeDrugSeason" style="width: 60px"></select>
        <label for="distributeDrugMonth">月份:</label>
        <select id="distributeDrugMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="distributeDrugSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container distributeDrug amount" style="width: 45%;height:80%"></div>
    <div class="chart-container distributeDrug count" style="width: 45%;height:80%"></div>
</div>
<script>
    var distributeDrugAmountOptsModel = {
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
    var distributeDrugCountOptsModel = {
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
        $('#distributeDrugDrugName').combobox({
            valueField: 'drugName',
            textField: 'drugName',
            url:'${ctx}/distribute/getDrugNames',
            prompt:'药品名'
        });

        $('#distributeDrugMonth').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'月份'
        });

        $('#distributeDrugSeason').combobox({
            valueField: 'label',
            textField: 'value',
            prompt:'季度',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#distributeDrugMonth').combobox('loadData', [{
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
                            $('#distributeDrugMonth').combobox('loadData', [{
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
                            $('#distributeDrugMonth').combobox('loadData', [{
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
                            $('#distributeDrugMonth').combobox('loadData', [{
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
                            $('#distributeDrugMonth').combobox('loadData', [{
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

        $('#distributeDrugSeason').combobox('loadData',[{
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
        $('#distributeDrugSeason').combobox('setValue','${initSeason}');
        $('#distributeDrugMonth').combobox('setValue','${initMonth}');

        $('#distributeDrugSearch').linkbutton({
            onClick:function(){
                var drugName = $('#distributeDrugDrugName').combobox('getValue');
                var year  = $('#distributeDrugYear').numberspinner('getValue');
                var season = $('#distributeDrugSeason').combobox('getValue');
                var month = $('#distributeDrugMonth').combobox('getValue');
                distributeDrugSearch(year,season,month,drugName);
            }
        })
    });

    function distributeDrugSearch(year,season,month,drugName){
        $.post(ctx + '/distribute/drugData', {year: year,season:season,month:month,drugName:drugName}, function (result) {
            debugger;
            var amountSeries = [], lengendData = [],countSeries=[],subTitle;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                subTitle=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                subTitle=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                subTitle=year+'年度统计';
            }
            distributeDrugAmountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            distributeDrugCountOptsModel.title.subtext = subTitle;//xAxis.data,series.data
            if(drugName){
                distributeDrugAmountOptsModel.title.text ='药品配送金额统计'+'('+drugName+')';
                distributeDrugCountOptsModel.title.text ='药品配送数量统计'+'('+drugName+')';
            }else{
                distributeDrugAmountOptsModel.title.text ='药品配送金额统计(汇总)';
                distributeDrugCountOptsModel.title.text ='药品配送数量统计(汇总)';
            }
            for(var x= 0;x<result.length;x++){
                amountSeries.push({value:result[x].amount,name:result[x].area});
                lengendData.push(result[x].area);
                countSeries.push({value:result[x].count,name:result[x].area});
            }
            distributeDrugAmountOptsModel.legend.data = lengendData;
            distributeDrugCountOptsModel.legend.data = lengendData;
            distributeDrugAmountOptsModel.series[0].data = amountSeries;
            distributeDrugCountOptsModel.series[0].data = countSeries;
            var distributeDrugAmountChart  =require('echarts').init($('.chart-container.distributeDrug.amount')[0],echartTheme);
            distributeDrugAmountChart.setOption(distributeDrugAmountOptsModel);
            var distributeDrugCountChart  =require('echarts').init($('.chart-container.distributeDrug.count')[0],echartTheme);
            distributeDrugCountChart.setOption(distributeDrugCountOptsModel);

            /*var ecConfig = require('echarts/config');
             distributeDrugChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    distributeDrugSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
