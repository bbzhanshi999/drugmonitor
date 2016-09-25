<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>出库统计</title>
</head>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="text-align: center">
    <header><i class='fa fa-user'></i>   出库信息汇总统计</header>
    <div class="chart-container year outstore" style="width: 500px;height:500px"></div>
    <div class="chart-container month outstore" style="width: 500px;height:500px"></div>
</div>
<script>
    require(
            [
                'echarts',
                'echarts/theme/helianthus',
                'echarts/chart/pie'
            ],
            function (ec,theme) {
                // 基于准备好的dom，初始化echarts图表
                var year = ec.init($('.chart-container.year.outstore')[0],theme);
                var month = ec.init($('.chart-container.month.outstore')[0],theme);

                var yearOpt = {
                    title : {
                        text: '出库年度统计',
                        subtext: '纯属虚构',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{b} : {c}万元 ({d}%)"
                    },
                    legend: {
                        orient : 'vertical',
                        x : 'left',
                        data:['2010年','2011年','2012年','2013年','2014年','2015年','2016年']
                    },

                    calculable : true,
                    series : [
                        {
                            name:'占有率',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value:335, name:'2010年'},
                                {value:310, name:'2011年'},
                                {value:234, name:'2012年'},
                                {value:135, name:'2013年'},
                                {value:1548, name:'2014年'},
                                {value:323, name:'2015年'},
                                {value:4444, name:'2016年'}
                            ]
                        }
                    ]
                };

                var option = {
                    title : {
                        text: '2015年月度统计',
                        subtext: '纯属虚构',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c}万元({d}%)"
                    },
                    legend: {
                        orient : 'vertical',
                        x : 'left',
                        data:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                    },
                    calculable : true,
                    series : [
                        {
                            name:'访问来源',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value:335, name:'1月'},
                                {value:310, name:'2月'},
                                {value:234, name:'3月'},
                                {value:135, name:'4月'},
                                {value:234, name:'5月'},
                                {value:1134.7, name:'6月'},
                                {value:432, name:'7月'},
                                {value:555, name:'8月'},
                                {value:666, name:'9月'},
                                {value:548, name:'10月'},
                                {value:999, name:'11月'},
                                {value:112, name:'12月'}
                            ]
                        }
                    ]
                };


                year.setOption(yearOpt);
                month.setOption(option);
            }
    );
</script>
</body>
</html>
