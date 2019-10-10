console.log("hello world...");

var line = document.getElementById("line");
var lineChart = echarts.init(line);

var pie = document.getElementById("pie");
var pieChart = echarts.init(pie);

var colors = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83',  '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3']



var lineOption = {
    title: {
        text: 'Github Indicator'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['Watch','Star','Fork','Issues']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: []
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'Watch',
            type:'line',
            smooth: true,
            data:[]
        },
        {
            name:'Star',
            type:'line',
            smooth: true,
            data:[]
        },
        {
            name:'Fork',
            type:'line',
            smooth: true,
            data:[]
        },
        {
            name:'Issues',
            type:'line',
            smooth: true,
            data:[]
        }
    ]
};

var pieOption = {
    backgroundColor: '#ffffff',

    title: {
        text: 'Customized Pie',
        left: 'center',
        top: 20,
        textStyle: {
            color: 'red'
        }
    },

    tooltip : {
        trigger: 'item',
        formatter: "{b} : {c}"
    },

    visualMap: {
        show: false,
        min: 80,
        max: 600,
        inRange: {
            colorLightness: [0, 1]
        }
    },
    series : [
        {
            name:'Watch',
            type:'pie',
            radius : '20%',
            center: ['25%', '50%'],
            data:[
                
                {value:400, name:'Watch'}
            ].sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',
            label: {
                normal: {
                    textStyle: {
                        color: 'rgba(f, 0, 0, 0.8)'
                    }
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: 'rgba(0, 0, 0, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            itemStyle: {
                normal: {
                    color: '#c23531',
                    shadowBlur: 150,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        },
        {
            name:'Star',
            type:'pie',
            radius : '20%',
            center: ['45%', '50%'],
            data:[
                
                {value:400, name:'Star'}
            ].sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',
            label: {
                normal: {
                    textStyle: {
                        color: 'rgba(f, 0, 0, 0.8)'
                    }
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: 'rgba(0, 0, 0, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            itemStyle: {
                normal: {
                    color: '#2f4554',
                    shadowBlur: 150,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        },
         {
            name:'Fork',
            type:'pie',
            radius : '20%',
            center: ['65%', '50%'],
            data:[
                
                {value:400, name:'Fork'}
            ].sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',
            label: {
                normal: {
                    textStyle: {
                        color: 'rgba(f, 0, 0, 0.8)'
                    }
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: 'rgba(0, 0, 0, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            itemStyle: {
                normal: {
                    color: '#61a0a8',
                    shadowBlur: 150,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        },
         {
            name:'Issues',
            type:'pie',
            radius : '20%',
            center: ['85%', '50%'],
            data:[
                
                {value:400, name:'Issues'}
            ].sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',
            label: {
                normal: {
                    textStyle: {
                        color: 'rgba(f, 0, 0, 0.8)'
                    }
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: 'rgba(0, 0, 0, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            itemStyle: {
                normal: {
                    color: '#d48265',
                    shadowBlur: 150,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        }
    ]
};

$(document).ready(function(){ 
    console.log("初始化方法进入"); 

    setDefaultDate();
    doQuery();
}); 

function getData(userId, projectName, startDate, endDate) {

    /* 正式请求---开始 */
    var reqUrl = "github/" + userId + "/" + projectName + "/" + startDate + "/" + endDate;

    var title = startDate + " ~ " + endDate + "  " + userId + "'s  " + projectName;

    $.ajax({
        type:"GET",
        url:reqUrl,
        success: function(data){

            if(data && "success" === data.code ){
                var responseData = data.data;

                if(responseData == null){
                    console.log("responseData is null");
                    return;
                }
                setLineData(responseData);
                setPieData(responseData, title);
            }else{
                // 
                console.log("get data error, response " + data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
                console.log("error msg: " + errorThrown);
        }
    });

}

function setLineData(responseData){

    // set xAxis data
    lineOption.xAxis.data = responseData.xdate;

    // set yAxis data
    lineOption.series[0].data = responseData.watch.data;  
    lineOption.series[1].data = responseData.star.data;
    lineOption.series[2].data = responseData.fork.data;
    lineOption.series[3].data = responseData.issues.data;
    
    lineChart.setOption(lineOption, true);

}


function setPieData(responseData, title){

    // set pie data
    pieOption.series[0].data[0].value = responseData.watch.total;  
    pieOption.series[1].data[0].value = responseData.star.total;
    pieOption.series[2].data[0].value = responseData.fork.total;
    pieOption.series[3].data[0].value = responseData.issues.total;
    
    pieOption.title.text = title;
    pieChart.setOption(pieOption, true);

}


function doQuery(){
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    console.log("startDate:" + startDate);
    console.log("endDate:" + endDate);

    if(startDate == "" || endDate ==""){
        alert("Please choice the query date");
        return;
    }

    getData("taosdata", "TDengine", startDate, endDate);

}

function setDefaultDate(){

    var today = new Date();
    var startDate = formatTime(addDay(today, -7)).replace(/-/g, "");
    var endDate = formatTime(today).replace(/-/g, "");

    document.getElementById("startDate").value = startDate;
    document.getElementById("endDate").value = endDate;
}

function formatTime(date) {
    var year = date.getFullYear();
    var month = date.getMonth()+1, month = month < 10 ? '0' + month : month;
    var day = date.getDate(), day =day < 10 ? '0' + day : day;
    return year + '-' + month + '-' + day;
}

function addDay(currentDate, days){
    var tmp = new Date(currentDate);
    tmp.setDate(tmp.getDate() + days);//注意是Date
    return tmp;
}