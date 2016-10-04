<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>中西药品采购统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><span class="tab-inside-title">中西药品采购统计</span></header>
    <div class="form-line wide">
        <label for="categorySupplyCategory">药品种类:</label>
        <select id="categorySupplyCategory" style="width: 90px"></select>
        <label for="categorySupplyYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="categorySupplyYear" id="categorySupplyYear" style="width: 60px"/>
        <label for="categorySupplySeason">季度:</label>
        <select id="categorySupplySeason" style="width: 60px"></select>
        <label for="categorySupplyMonth">月份:</label>
        <select id="categorySupplyMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="categorySupplySearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container categorySupply"></div>
</div>
<script>
    var categorySupplyOptsModel = {
        tooltip: {
            showDelay: 0,
            hideDelay: 50,
            transitionDuration: 0,
            formatter: function (params) {
                var res = params.name + '年：' + params.value + '万元';
                return res;
            }
        },
        /*待设置*/
        title: {
            text: ''
        },
        legend: {
            data: ['采购总金额']
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
                "name": "采购总金额",
                "type": "bar",
                /*待设置*/
                "data": []
            }
        ]
    };
    $(document).ready(function () {
        $('#categorySupplyCategory').combobox({
            valueField: 'label',
            textField: 'value',
            data:[{label:'中药',value:'中药'},{label:'西药',value:'西药'}],
            prompt:'药品种类'
        });

        $('#categorySupplyMonth').combobox({
            valueField: 'label',
            textField: 'value'
        });

        $('#categorySupplySeason').combobox({
            valueField: 'label',
            textField: 'value',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#categorySupplyMonth').combobox('loadData', [{
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
                            $('#categorySupplyMonth').combobox('loadData', [{
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
                            $('#categorySupplyMonth').combobox('loadData', [{
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
                            $('#categorySupplyMonth').combobox('loadData', [{
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
                            $('#categorySupplyMonth').combobox('loadData', [{
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

        $('#categorySupplySeason').combobox('loadData',[{
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
        $('#categorySupplySeason').combobox('setValue','${initSeason}');
        $('#categorySupplyMonth').combobox('setValue','${initMonth}');

        $('#categorySupplySearch').linkbutton({
            onClick:function(){
                var year  = $('#categorySupplyYear').numberspinner('getValue');
                var season = $('#categorySupplySeason').combobox('getValue');
                var month = $('#categorySupplyMonth').combobox('getValue');
                var category = $('#categorySupplyCategory').combobox('getValue');
                categorySupplySearch(year,season,month,category);
            }
        })
    });

    function categorySupplySearch(year,season,month,category){
        $.post(ctx + '/category/supplyData', {year: year,season:season,month:month,category:category}, function (result) {
            debugger;
            var series = [],xdata = [],title;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                title=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                title=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                title=year+'年度统计';
            }
            categorySupplyOptsModel.title.text = title;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].area);
            }
            categorySupplyOptsModel.xAxis[0].data = xdata;
            categorySupplyOptsModel.series[0].data = series;
            var categorySupplyChart  =require('echarts').init($('.chart-container.categorySupply')[0],echartTheme);
            categorySupplyChart.setOption(categorySupplyOptsModel);
            /*var ecConfig = require('echarts/config');
             categorySupplyChart.on(ecConfig.EVENT.CLICK, eConsole);*/
        }, 'json');
    }

    function eConsole(param) {
        var mes = '【' + param.type + '】';
        if (typeof param.seriesIndex != 'undefined') {
            mes += '  seriesIndex : ' + param.seriesIndex;
            mes += '  dataIndex : ' + param.dataIndex;
        }
        console.log(param);
        console.log(mes);
    }

    categorySupplySearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
