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
        <input class="easyui-numberspinner" prompt="年份" data-options="required:true,
                iconCls:'icon-calendar',
                value:${initYear},
                min:2000,max:2199" name="instore_year" id="instoreYear"/>
        <span class="interval" style="width: 92px"></span>
        <label for="instoreSeason">季度:</label>
        <select id="instoreSeason" style="width: 100px"></select>
        <span class="interval" style="width: 92px"></span>
        <label for="instoreMonth">月份:</label>
        <select id="instoreMonth" style="width: 100px"></select>
    </div>
    <div class="chart-container year instore"></div>
    <div class="chart-container season instore"></div>
    <div class="chart-container month instore"></div>
</div>
<script>
    $(document).ready(function () {
        $('#instoreSeason').combobox({
            valueField: 'label',
            textField: 'value',
            data: [{
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
            }],
            value: '${initSeason}'
        });
        $('#instoreMonth').combobox({
            valueField: 'label',
            textField: 'value',
            data: [{
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
            }],
            value: '${initMonth}'
        })
    });
</script>

<script>
    require(
            [
                'echarts',
                'echarts/theme/helianthus',
                'echarts/chart/bar'
            ],
            function (ec, theme) {
                // 基于准备好的dom，初始化echarts图表
                var year = ec.init($('.chart-container.year.instore')[0], theme);
                var season = ec.init($('.chart-container.season.instore')[0], theme);
                var month = ec.init($('.chart-container.month.instore')[0], theme);

                var yearOpt = {
                    tooltip: {         // Option config. Can be overwrited by series or data
                        //trigger: 'axis',
                        //show: true,   //default true
                        showDelay: 0,
                        hideDelay: 50,
                        transitionDuration: 0,
                        /* backgroundColor : 'rgba(255,0,255,0.7)',*/
                        /* borderColor : '#f50',*/
                        /* borderRadius : 8,
                         borderWidth: 1,
                         padding: 10,    // [5, 10, 15, 20]
                         position : function(p) {
                         // 位置回调
                         // console.log && console.log(p);
                         return [p[0] + 10, p[1] - 10];
                         },
                         textStyle : {
                         color: 'yellow',
                         decoration: 'none',
                         fontSize: 10
                         },*/
                        formatter: function (params) {
                            var res = params.name + '年：' + params.value + '万元';

                            return res;
                        }
                        //formatter: "Template formatter: <br/>{b}<br/>{a}:{c}<br/>{a1}:{c1}"
                    },
                    title: {
                        text: '年度统计'
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
                                interval: '0',    // {number}
                                /*rotate: 45,*/
                                margin: 4,
                                formatter: '{value}年',
                                textStyle: {
                                    color: 'grey',
                                    fontSize: 10
                                }
                            },
                            /*splitLine : {
                             show:true,
                             lineStyle: {
                             color: '#483d8b',
                             type: 'dashed',
                             width: 1
                             }
                             },*/
                            splitArea: {
                                show: true,
                                areaStyle: {
                                    color: ['rgba(144,238,144,0.3)', 'rgba(135,200,250,0.3)']
                                }
                            },
                            data: [
                                '2010', '2011', '2012', '2013', '2014', '2015', '2016'
                            ]
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            position: 'left',
                            /*
                             axisLine : {    // 轴线
                             show: true,
                             lineStyle: {
                             color: 'red',
                             type: 'dashed',
                             width: 2
                             }
                             },*/
                            /*axisTick : {    // 轴标记
                             show:true,
                             length: 10,
                             lineStyle: {
                             color: 'green',
                             type: 'solid',
                             width: 1
                             }
                             },*/
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
                            }/*,
                         splitArea : {
                         show: true,
                         areaStyle:{
                         color:['rgba(205,92,92,0.3)','rgba(255,215,0,0.3)']
                         }
                         }*/
                        }
                    ],
                    series: [
                        {
                            "name": "入库总金额",
                            "type": "bar",
                            "data": [140, 200, 232, 356, 434, 545, 677, 756]
                        }
                    ]
                };

                var seasonOpt = {
                    tooltip: {         // Option config. Can be overwrited by series or data
                        //trigger: 'axis',
                        //show: true,   //default true
                        showDelay: 0,
                        hideDelay: 50,
                        transitionDuration: 0,
                        /* backgroundColor : 'rgba(255,0,255,0.7)',*/
                        /* borderColor : '#f50',*/
                        /* borderRadius : 8,
                         borderWidth: 1,
                         padding: 10,    // [5, 10, 15, 20]
                         position : function(p) {
                         // 位置回调
                         // console.log && console.log(p);
                         return [p[0] + 10, p[1] - 10];
                         },
                         textStyle : {
                         color: 'yellow',
                         decoration: 'none',
                         fontSize: 10
                         },*/
                        formatter: function (params) {
                            var res = params.name + '季度：' + params.value + '万元';

                            return res;
                        }
                        //formatter: "Template formatter: <br/>{b}<br/>{a}:{c}<br/>{a1}:{c1}"
                    },
                    title: {
                        text: '2015年季度统计'
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
                                interval: '0',    // {number}
                                /*rotate: 45,*/
                                margin: 4,
                                formatter: '{value}季度',
                                textStyle: {
                                    color: 'grey',
                                    fontSize: 10
                                }
                            },
                            /*splitLine : {
                             show:true,
                             lineStyle: {
                             color: '#483d8b',
                             type: 'dashed',
                             width: 1
                             }
                             },*/
                            splitArea: {
                                show: true,
                                areaStyle: {
                                    color: ['rgba(144,238,144,0.3)', 'rgba(135,200,250,0.3)']
                                }
                            },
                            data: [
                                '一', '二', '三', '四'
                            ]
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            position: 'left',
                            /*
                             axisLine : {    // 轴线
                             show: true,
                             lineStyle: {
                             color: 'red',
                             type: 'dashed',
                             width: 2
                             }
                             },*/
                            /*axisTick : {    // 轴标记
                             show:true,
                             length: 10,
                             lineStyle: {
                             color: 'green',
                             type: 'solid',
                             width: 1
                             }
                             },*/
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
                            }/*,
                         splitArea : {
                         show: true,
                         areaStyle:{
                         color:['rgba(205,92,92,0.3)','rgba(255,215,0,0.3)']
                         }
                         }*/
                        }
                    ],
                    series: [
                        {
                            "name": "入库总金额",
                            "type": "bar",
                            "data": [90, 54, 100, 89]
                        }
                    ]
                };

                var monthOpt = {
                    tooltip: {         // Option config. Can be overwrited by series or data
                        //trigger: 'axis',
                        //show: true,   //default true
                        showDelay: 0,
                        hideDelay: 50,
                        transitionDuration: 0,
                        /* backgroundColor : 'rgba(255,0,255,0.7)',*/
                        /* borderColor : '#f50',*/
                        /* borderRadius : 8,
                         borderWidth: 1,
                         padding: 10,    // [5, 10, 15, 20]
                         position : function(p) {
                         // 位置回调
                         // console.log && console.log(p);
                         return [p[0] + 10, p[1] - 10];
                         },
                         textStyle : {
                         color: 'yellow',
                         decoration: 'none',
                         fontSize: 10
                         },*/
                        formatter: function (params) {
                            /* console.log(params);*/
                            var res = params.name + '月：' + params.value + '万元';

                            return res;
                        }
                        //formatter: "Template formatter: <br/>{b}<br/>{a}:{c}<br/>{a1}:{c1}"
                    },
                    title: {
                        text: '2015年月度统计'
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
                                interval: '0',    // {number}
                                /*rotate: 45,*/
                                margin: 4,
                                formatter: '{value}月',
                                textStyle: {
                                    color: 'grey',
                                    fontSize: 10
                                }
                            },
                            /*splitLine : {
                             show:true,
                             lineStyle: {
                             color: '#483d8b',
                             type: 'dashed',
                             width: 1
                             }
                             },*/
                            splitArea: {
                                show: true,
                                areaStyle: {
                                    color: ['rgba(144,238,144,0.3)', 'rgba(135,200,250,0.3)']
                                }
                            },
                            data: [
                                '1', '2', '3', '4', '5', '6',
                                /*{
                                 value:'6',
                                 textStyle: {
                                 color: 'red',
                                 fontSize: 30,
                                 fontStyle: 'normal',
                                 fontWeight: 'bold'
                                 }
                                 },*/
                                '7', '8', '9', '10', '11', '12'
                            ]
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            position: 'left',
                            /*
                             axisLine : {    // 轴线
                             show: true,
                             lineStyle: {
                             color: 'red',
                             type: 'dashed',
                             width: 2
                             }
                             },*/
                            /*axisTick : {    // 轴标记
                             show:true,
                             length: 10,
                             lineStyle: {
                             color: 'green',
                             type: 'solid',
                             width: 1
                             }
                             },*/
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
                            }/*,
                         splitArea : {
                         show: true,
                         areaStyle:{
                         color:['rgba(205,92,92,0.3)','rgba(255,215,0,0.3)']
                         }
                         }*/
                        }
                    ],
                    series: [
                        {
                            "name": "入库总金额",
                            "type": "bar",
                            "data": [5, 20, 40, 10, 10, 20, 15, 40, 20, 70, 77, 43]
                        }
                    ]
                };

                year.setOption(yearOpt);
                season.setOption(seasonOpt);
                month.setOption(monthOpt);

                var ecConfig = require('echarts/config');
                year.on(ecConfig.EVENT.CLICK, eConsole);
                /*   year.on(ecConfig.EVENT.HOVER,eConsole);*/
            }
    );
    function eConsole(param) {
        var mes = '【' + param.type + '】';
        if (typeof param.seriesIndex != 'undefined') {
            mes += '  seriesIndex : ' + param.seriesIndex;
            mes += '  dataIndex : ' + param.dataIndex;
        }
        console.log(param);
        console.log(mes);
    }
</script>
</body>
</html>
