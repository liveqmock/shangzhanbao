$(function() {
	var winWidth = getWidth();// 获取窗口宽度
	var winHeight = getHeight();// 获取窗口高度
	// 给各div辅长宽
	$("#top").css("width", winWidth);
	$("#title").css("width", winWidth);
	$("#main").css("width", winWidth);
	// $("#main").css("height", winHeight-110);
	$("#main").css("height", winHeight - 50);
	$(window).resize(resize);
	function resize() {
		winWidth = $(this).width();
		winHeight = $(this).height();
		// 给各div辅长宽
		$("#top").css("width", winWidth);
		$("#title").css("width", winWidth);
		$("#main").css("width", winWidth);
//		if($("#thistype").val()=='init'){
//			$("#main").css("height", winHeight-110);
//		} else {
			$("#main").css("height", winHeight-50);
//		}
	}
	resize();
	
});

/**
 * 显示提示标语框
 */
function showBox(obj, msg) {
	var oftop = 0;
	if ($("#title").length > 0) {
		oftop = obj.offsetTop + 110;
	} else {
		oftop = obj.offsetTop + 50;
	}
	$("#selectmsg").html(msg);
	$("#selectBox").css("top", oftop - 32);
	$("#selectBox").css("left", obj.offsetLeft + 44);
	$("#selectBox").show(500);
}
/**
 * 隐藏提示标语
 */
function closeBox() {
	$("#selectBox").hide(500);
}
/**
 * 获取窗口高度
 */
function getHeight() {
	var winHeight = 0;
	// 获取窗口高度
	if (window.innerHeight) {
		winHeight = window.innerHeight;
	} else if ((document.body) && (document.body.clientHeight)) {
		winHeight = document.body.clientHeight;
	}
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientHeight) {
		winHeight = document.documentElement.clientHeight;
	}
	return winHeight;
}
/**
 * 获取窗口宽度
 */
function getWidth() {
	var winWidth = 0;
	// 获取窗口宽度
	if (window.innerWidth) {
		winWidth = window.innerWidth;
	} else if ((document.body) && (document.body.clientWidth)) {
		winWidth = document.body.clientWidth;
	}
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientWidth) {
		winWidth = document.documentElement.clientWidth;
	}
	return winWidth;
}
/**
 * 查看在线客户详情弹出框
 */
function selectBox() {
	var msgBox = "<br/br/><center><div style='width:95%;height:95%;background:#FFFFFF;'><iframe src='"
			+ root
			+ "/view/pages/mini/page/createPage/select/message.html'"
			+ " frameborder='no' border='1' scrolling='auto' height='100%' width='100%'></iframe></div></center>";
	new bombBox('selectDiv', 'selectDivBox', {
		title : '在线咨询介绍',
		content : msgBox,
		width : getWidth() * 0.7 + '',
		height : getHeight() * 0.8 + '',
		top : '',
		left : '',
		fixed : '',
		close : 'close'
	});
	$("#selectDiv").click();
}