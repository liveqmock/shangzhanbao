$(function() {
	var winWidth = getWidth();// 获取窗口宽度
	var winHeight = getHeight();// 获取窗口高度
	// 给各div辅长宽
	$("#top").css("width", winWidth);
	$("#title").css("width", winWidth);
	$("#main").css("width", winWidth);
	$("#main").css("height", winHeight-90);
	$(window).resize(function() {
		winWidth = $(this).width();
		winHeight = $(this).height();
		// 给各div辅长宽
		$("#top").css("width", winWidth);
		$("#main").css("width", winWidth);
		$("#title").css("width", winWidth);
		if($("#title").length>0){
			$("#main").css("height", winHeight-90);
		} else {
			$("#main").css("height", winHeight-50);
		}
	});
});
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