/***
 * 依赖jQuery包和c.css
 */
/*****************创建进度提示信息**************************/
var seconds=1;
var intervalID=0;  
var content = "请等待,正在获取数据!";
function Progress(){}//声明进度Progress对象
var progress = new Progress();
//显示div
Progress.prototype.show=function(){
	seconds=1;//每次初始化
	progress.createDiv();
};
//创建div
Progress.prototype.createDiv=function(){
	var boardDiv="<div id='loading'>"+content+"</div>";
	$(document.body).append(boardDiv);
	intervalID=window.setInterval("progress.setContent()",1000); //每隔1秒调用一次setContent函数
	};
	
//秒数加一
Progress.prototype.setContent=function(){
	$("div#loading").text(content+" "+(seconds++));
};
//删除div
Progress.prototype.hide=function(){
window.clearInterval(intervalID);   //清除Interval
$("div#loading").remove();
};
/*******************************************/