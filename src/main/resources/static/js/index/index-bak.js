
var distacneH = 124;
var distacneW = 80;
var width = (window.innerWidth - distacneW) / 8 * 7 + "px";
var rightWidth = (window.innerWidth - distacneW) / 8 + 40 + "px";
var height = window.innerHeight - distacneH;

console.log("height:" + height);
console.log($(window).width());

$(".box").css({
    "width": width,
    "height": height,
    "display": "inline"
});


$(".rightBox").css({
    "width": rightWidth,
    "height": height,
    "display": "inline"
});

var xDate = [];

//折线图数据
var chartData = {
    xDate: "",
    watch: "",
    star: "",
    issues: "",
    fork: ""
};

var myChart1 = echarts.init(document.getElementsByClassName('box')[0]);
var myChart2 = echarts.init(document.getElementsByClassName('rightBox')[0]);


window.onload = function() {
    getData();
}

window.onresize = function() {

    console.log("height:" + window.innerHeight);
    console.log("width:" + window.innerWidth);

    var width = (window.innerWidth - distacneW) / 8 * 7 + "px";
    var rightWidth = (window.innerWidth - distacneW) / 8 + 40 + "px";
    var height = window.innerHeight - distacneH + "px";

    console.log(height);
    console.log(width);

    $(".box").css({
        "width": width,
        "height": height,
        "display": "inline"
    });

    $(".rightBox").css({
        "width": rightWidth,
        "height": height,
        "display": "inline"
    });

    console.log(chartData);

    drawLineChart(chartData.watch, chartData.star, chartData.issues, chartData.fork);

    myChart1.resize();
    myChart2.resize();
};


function getData() {

    /* 正式请求---开始 */
    var reqUrl = "github/taosdata/TDengine/20190915/20190917";

    $.ajax({
        type:"GET",
        url:reqUrl,
        success: function(data){
            chartData = {
                xDate: data.data.xDate,
                watch: data.data.watch.data,
                star:  data.data.star.data,
                issues:  data.data.issues.data,
                fork:  data.data.fork.data
            };

            console.log("ajax resp " + data);

            console.log("======= before draw ============");

            drawLineChart(data.data.watch.data, data.data.star.data, data.data.issues.data, data.data.fork.data);
            drawPieChart(data.data.watch.total, data.data.star.total, data.data.issues.total, data.data.fork.total);
            
            console.log("======= after draw ============");
        },
        error: function (jqXHR, textStatus, errorThrown) {
                console.log("error msg: "

}


//直角坐标系内绘图网格
function makeGrid(top, height, opt) {
    return echarts.util.merge({
            left: 70,
            right: 60,
            top: top,
            height: height
            },
            opt || {},
            true
        );
}

function makeXAxis(gridIndex, opt) {
    //避免X轴数据显示过于频繁
    axisLabelFlag = false;
    //  if (gridIndex % 2 == 0) {
    //      axisLabelFlag = true;
    //  }
    if (gridIndex == 3) {
        axisLabelFlag = true;
    }

    return echarts.util.merge({
                type: 'category',
                gridIndex: gridIndex,
                //统一时间轴数据
                data: xDate,
                axisLabel: {
                    show: axisLabelFlag,
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                },
            },
            opt || {},
            true
            );
}

//Y轴生成器
function makeYAxis(gridIndex, opt) {
    return echarts.util.merge({
            type: 'value',
            nameLocation: 'middle',
            nameGap: '40',
            gridIndex: gridIndex,
            nameTextStyle: {
                color: '#fff'
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: 'white'
                }
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: 'rgba(255,255,255,0.3)'
                }
            },
            axisLabel: {}
        },
        opt || {},
        true
        );
}

//数据生成器
function makeGridData(xAxisIndex, yAxisIndex, chartType, chartName, chartData, opt) {
    return echarts.util.merge({
                type: chartType,
                name: chartName,
                xAxisIndex: xAxisIndex,
                yAxisIndex: yAxisIndex,
                data: chartData,
            },
            opt || {},
            true
        );
}

function drawLineChart(watch, star, issues, fork) {
var distanceTop = 20;
var Watch = watch;
var Star = star;
var Issues = issues;
var Fork = fork;
console.log(Watch);
console.log(Star);
console.log(Issues);
console.log(Fork);
var overviewChartID = 'overview-chart';
var overviewTitle = ''; //标题
var overviewSubTitle = echarts.format.formatTime('yyyy年MM月dd', new Date());

//图表定位
var chartGridTop = 40;
var chartGridHeight = (window.innerHeight - distacneH - distanceTop * 8)/4;

//时间轴
//SELECT WMSYS.WM_CONCAT('"'||TO_CHAR(TRUNC(SYSDATE, 'MM') + ROWNUM - 1, 'YYYY-MM-DD')||'"') DBTIME FROM DUAL CONNECT BY ROWNUM <= 30;
//表格数据
//SELECT WMSYS.WM_CONCAT(TRUNC(DBMS_RANDOM.VALUE(5, 60), 2)) DBTIME FROM DUAL CONNECT BY ROWNUM <= 30;

// 		var myChartOne = echarts.init(document.getElementById('NestingChart'));
var option1 = {
    animation: false,
    //标题组件，包含主标题和副标题
    title: {
        x: 'center',
        text: overviewTitle,
        //      subtext: overviewSubTitle,
        //      padding: 0,
    },
    tooltip: {
        //移动端展示方式
        trigger: 'axis',
        transitionDuration: 0,
        confine: true,
        bordeRadius: 4,
        borderWidth: 1,
        borderColor: '#333',
        backgroundColor: 'rgba(255,255,255,0.9)',
        textStyle: {
            fontSize: 12,
            color: '#333'
        }
    },

    //坐标轴指示器（axisPointer）的全局公用设置
    axisPointer: {
        type: 'shadow',
        link: {
            xAxisIndex: 'all'
        }
    },
    //直角坐标系内绘图网格
    grid: [
        makeGrid(chartGridTop, chartGridHeight),
        makeGrid(chartGridTop + (chartGridHeight + distanceTop), chartGridHeight),
        makeGrid(chartGridTop + (chartGridHeight + distanceTop) * 2, chartGridHeight),
        makeGrid(chartGridTop + (chartGridHeight + distanceTop) * 3, chartGridHeight),
    ],
    legend: {
        data: ['Watch', 'Star', 'Issues', 'Fork'],
        top: 0,
        textStyle: {
            color: "#fff"
        },
        //				icon: 'roundRect',
    },
    xAxis: [makeXAxis(0), makeXAxis(1), makeXAxis(2), makeXAxis(3)],
    yAxis: [makeYAxis(0, {
        name: 'Watch',
        //  splitLine: {show: false},//去除网格线
    }),

    makeYAxis(1, {
        name: 'Star',
    }), 
    makeYAxis(2, {
        name: 'Issues',

    }), 
    makeYAxis(3, {
        name: 'Fork',

    })

    ],
    
    //dataZoom 组件 用于区域缩放
    
        dataZoom: [{
        type: 'slider',
        xAxisIndex: [0, 1, 2, 3],
        realtime: true,
        //移动端展示方式
        bottom: 0,
        textStyle: {
            color: '#fff'
        },
        height: 20
    }],
        

    //每个系列通过 type 决定自己的图表类型
    series: [

    makeGridData(0, 0, 'line', 'Watch', Watch, {
        stack: 'DBTIME',
        smooth: true,
        color: '#FFC125'
    }),

    makeGridData(1, 1, 'line', 'Star', Star, {
        stack: 'DBTIME',
        smooth: true,
        color: '#63B8FF'
    }),

    makeGridData(2, 2, 'line', 'Issues', Issues, {
        smooth: true,
        color: '#BA55D3'
    }),
    makeGridData(3, 3, 'line', 'Fork', Fork, {
        smooth: true,
        color: '#3CD37A'
    }), ]

};
myChart1.setOption(option1);
}

function drawPieChart(watch, star, issues, fork) {
option2 = {
    series: [{
        name: 'Watch',
        type: 'pie',
        radius: ['45%', '50%'],
        center: ['40%', '15%'],
        startAngle: 225,
        color: [new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
            offset: 0,
            color: '#FDFF5C'
        },
        {
            offset: 1,
            color: '#FFDB5C'
        }]), "transparent"],
        labelLine: {
            normal: {
                show: false
            }
        },
        label: {
            normal: {
                position: 'center'
            }
        },
        data: [{
            value: 75,
            name: 'Watch总数',
            label: {
                normal: {
                    formatter: 'Watch总数',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        },
        {
            value: 25,
            name: '%',
            label: {
                normal: {
                    formatter: '\n\n\n' + watch,
                    textStyle: {
                        color: '#DA6400',
                        fontSize: 16

                    }
                }
            }
        },
        {
            value: 0,
            name: '%',
            label: {
                normal: {
                    formatter: '',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        }]
    },
    {
        name: 'Star',
        type: 'pie',
        radius: ['45%', '50%'],
        center: ['40%', '38%'],
        startAngle: 225,
        color: [new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
            offset: 0,
            color: '#9FE6B8'
        },
        {
            offset: 1,
            color: '#32C5E9'
        }]), "transparent"],
        labelLine: {
            normal: {
                show: false
            }
        },
        label: {
            normal: {
                position: 'center'
            }
        },
        data: [{
            value: 75,
            name: 'Star总数',
            label: {
                normal: {
                    formatter: 'Star总数',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        },
        {
            value: 25,
            name: '%',
            label: {
                normal: {
                    formatter: '\n\n\n'+star,
                    textStyle: {
                        color: '#DA6400',
                        fontSize: 16

                    }
                }
            }
        },
        {
            value: 0,
            name: '%',
            label: {
                normal: {
                    formatter: '',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        }]
    },
    {
        name: 'Fork',
        type: 'pie',
        radius: ['45%', '50%'],
        center: ['40%', '61%'],
        startAngle: 225,
        labelLine: {
            normal: {
                show: false
            }
        },
        label: {
            normal: {
                position: 'center'
            }
        },
        data: [{
            value: 75,
            "itemStyle": {
                "normal": {
                    "color": new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        "offset": 0,
                        "color": '#B474D4'
                    },
                    {
                        "offset": 1,
                        "color": '#BC71D5'
                    }]),
                }
            },
            name: 'Fork总数',
            label: {
                normal: {
                    formatter: 'Issues总数',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        },
        {
            value: 25,
            name: '%',
            label: {
                normal: {
                    formatter: '\n\n\n' + issues,
                    textStyle: {
                        color: '#DA6400',
                        fontSize: 16

                    }
                }
            }
        },
        {
            value: 0,
            name: '%',
            label: {
                normal: {
                    formatter: '',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        }]
    },
    {
        name: 'Fork',
        type: 'pie',
        radius: ['45%', '50%'],
        center: ['40%', '84%'],
        startAngle: 225,
        labelLine: {
            normal: {
                show: false
            }
        },
        label: {
            normal: {
                position: 'center'
            }
        },
        data: [{
            value: 75,
            "itemStyle": {
                "normal": {
                    "color": new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        "offset": 0,
                        "color": '#3CD37A'
                    },
                    {
                        "offset": 1,
                        "color": '#00C79D'
                    }]),
                }
            },
            name: 'Fork总数',
            label: {
                normal: {
                    formatter: 'Fork总数',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        },
        {
            value: 25,
            name: '%',
            label: {
                normal: {
                    formatter: '\n\n\n' + fork,
                    textStyle: {
                        color: '#DA6400',
                        fontSize: 16

                    }
                }
            }
        },
        {
            value: 0,
            name: '%',
            label: {
                normal: {
                    formatter: '',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12

                    }
                }
            }
        }]
    }]
};
myChart2.setOption(option2);
}