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
        <label for="instoreYear">年份:</label>
        <input class="easyui-numberspinner" prompt="年份" data-options="value:${initYear},
                min:2000,max:2199" name="instoreYear" id="instoreYear"  style="width: 60px"/>
        <label for="instoreSeason">季度:</label>
        <select id="instoreSeason" style="width: 60px"></select>
        <label for="instoreMonth">月份:</label>
        <select id="instoreMonth" style="width: 60px"></select>
        <span class="interval" style="width: 10px"></span>
        <a href="#" id="instoreSearch" style="width: 50px;">查询</a>
    </div>
    <div class="chart-container instore"></div>
</div>
<script>
    var instoreOptsModel = {
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
            data: ['入库总金额']
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
                "data": []
            }
        ]
    };
    $(document).ready(function () {
        $('#instoreMonth').combobox({
            valueField: 'label',
            textField: 'value'
        });

        $('#instoreSeason').combobox({
            valueField: 'label',
            textField: 'value',
            onSelect: function (record) {
                if (record && record.value) {
                    var val = parseInt(record.value);
                    switch (val) {
                        case 1:
                            $('#instoreMonth').combobox('loadData', [{
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
                            $('#instoreMonth').combobox('loadData', [{
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
                            $('#instoreMonth').combobox('loadData', [{
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
                            $('#instoreMonth').combobox('loadData', [{
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
                            $('#instoreMonth').combobox('loadData', [{
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

        $('#instoreSeason').combobox('loadData',[{
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
        $('#instoreSeason').combobox('setValue','${initSeason}');
        $('#instoreMonth').combobox('setValue','${initMonth}');

        $('#instoreSearch').linkbutton({
            onClick:function(){
                var year  = $('#instoreYear').numberspinner('getValue');
                var season = $('#instoreSeason').combobox('getValue');
                var month = $('#instoreMonth').combobox('getValue');
                instoreSearch(year,season,month);
            }
        })
    });

    function instoreSearch(year,season,month){
        $.post(ctx + '/erp/instoreData', {year: year,season:season,month:month}, function (result) {
            debugger;
            var series = [],xdata = [],title;
            if($.trim(year)&&$.trim(season)&&$.trim(month)){
                title=year+'年'+season+'季度'+month+'月统计';
            }else if($.trim(year)&&$.trim(season)&&!$.trim(month)){
                title=year+'年'+season+'季度统计';
            }else if($.trim(year)&&!$.trim(season)&&!$.trim(month)){
                title=year+'年度统计';
            }
            instoreOptsModel.title.text = title;//xAxis.data,series.data
            for(var x= 0;x<result.length;x++){
                series.push(result[x].amount);
                xdata.push(result[x].area);
            }
            instoreOptsModel.xAxis[0].data = xdata;
            instoreOptsModel.series[0].data = series;
            var instoreChart  =require('echarts').init($('.chart-container.instore')[0],echartTheme);
            instoreChart.setOption(instoreOptsModel);
            instoreChart.on(ecConfig.EVENT.CLICK, eConsole);
        }, 'json');
    }

    function instoreDetailByOrganization(param) {
        var mes = '【' + param.type + '】';
        if (typeof param.seriesIndex != 'undefined') {
            mes += '  seriesIndex : ' + param.seriesIndex;
            mes += '  dataIndex : ' + param.dataIndex;
        }
        console.log(param);
        console.log(mes);
    }

    instoreSearch('${initYear}','${initSeason}','${initMonth}');
</script>
</body>
</html>
