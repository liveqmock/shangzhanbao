$(function () {
	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	if(starttime==undefined || endtime==undefined){
		starttime = '';
		endtime = '';
	}
	dataAnalysis(starttime,endtime);
});


/**
 * 用户自定义时间查询
 * @return
 */
function findByTime(){
	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	dataAnalysis(starttime,endtime);
} 

function dataAnalysis(starttime,endtime){
	var url = root+"/accesstatistics/key/dataAnalysis?starttime="+starttime+"&endtime="+endtime;
	$.ajax({
		type : 'POST',
		cache:false,
		url : url,
		dataType : "text",
		success : function(data) {
		var chardata = eval("("+data+")");
		highcharts(chardata);//一周数据趋势
		$("#visitNum").html(chardata[2].yestervisitNum);//昨日访客数
		$("#viewNum").html(chardata[3].yesterdayviewNum);//昨日浏览数
		}
	});

}




//一周浏览量趋势图
function highcharts(chardata){
	$('#oneweekcharts').highcharts({
        title: {
            text: '',
            x: -20 //center
        },
        credits:{ enabled: true, href: "#", text: '' //去掉右下角的 官方链接
        },
        subtitle: {
            text: chardata[0].weektitle,
            x: -20
        },
        xAxis: {
            categories:chardata[0].xName,tickInterval:getTickInterval(chardata[0].start,chardata[0].end)
        },
        yAxis: {
            title: {
                text: chardata[0].week
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {shared : false,//显示所有数据
			crosshairs : true,//垂直线下提示框
			headerFormat: '<span style="font-size:12px">{point.key}</span><table style="width: 80px">',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.0f}次</b></td></tr>',
            footerFormat: '</table>',
            useHTML: true},
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: chardata[0].weekview,
            data:chardata[0].wmap
        },{
            name: chardata[0].weekvisit,
            data:chardata[0].vmap
        }]
    });
}


/**
 * 获取heighcharts的横坐标间隔
 * @param {date} start 开始时间
 * @param {date} end 结束时间
 * @param {object} reg 分段规则，如果不传则按默认规则
 * @return {int}  返回时间隔
 * 备注：1*4=1小时，其中1是指15分钟间隔。
 * 
 */
function getTickInterval(start,end,reg){
		var tick= reg || {"1-2":1*4,"3-5":1*4*12,"6-10":1*4*24,"11-15":1*4*24*3,"16-21":1*4*24*5,"22-~":1*4*24*7};//规则修改key值即可
		var m = ((end - start)/1000/3600/24)+1;
		for (var k in tick) {
			var ts = k.split("-");
			if(m >= ts[0] && ts[1]=="~") {
				return tick[k];
			}
			if(m >= ts[0] && m<=ts[1]) {
				return tick[k];
			}
		}
		return 1*4;
}


















