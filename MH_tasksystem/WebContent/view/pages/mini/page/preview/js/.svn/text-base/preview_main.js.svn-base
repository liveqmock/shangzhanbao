$(function() {
	var winWidth = getWidth();// 获取窗口宽度
	var winHeight = getHeight();// 获取窗口高度
	// 给各div辅长宽
	$("#top").css("width", winWidth);
	$("#main").css("width", winWidth);
	$("#main").css("height", winHeight - 50);
	$(window).resize(function() {
		winWidth = $(this).width();
		winHeight = $(this).height();
		// 给各div辅长宽
		$("#top").css("width", winWidth);
		$("#main").css("width", winWidth);
		$("#main").css("height", winHeight - 50);
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
function ajaxSubmit(frm, fn) {
	var dataPara = getFormJson(frm);
	$.ajax({
		url : frm.action,
		type : frm.method,
		data : dataPara,
		success : fn
	});
}
function getFormJson(frm) {
	var o = {};
	var a = $(frm).serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});

	return o;
}
/**
 * 暂存方法弹出框
 */
function zancun(){
	new bombBox('zancun', 'box', {
		title : '暂存成功',
		content : '<div class="editpage_zancun_div">暂存的商站只有你自己能访问，你可以在管理页面进行修改和发布。</div><div class="editpage_zancun_div_in_div"><button class="editpage_zancun_div_in_div_calBtn">继续修改</button><input type="button" class="editpage_zancun_div_in_div_sureBtn" onclick="goguanli()" value="管理网页" /></div>',
		width : '480',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#zancun").click();
}
/**
 * 发布窗口弹出框
 * @param content
 * 弹出框内容
 * @param w
 * 弹出框宽
 * @param h
 * 弹出框高
 */
function fabu(content,w,h){
	new bombBox('fabu', 'fabubox', {
		title : '发布提醒',
		content : content,
		width : w,
		height : h,
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#fabu").click();
}
function fabuSuccess(content,w,h){
	new bombBox('fabu', 'fabubox', {
		title : '发布成功',
		content : content,
		width : w,
		height : h,
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#fabu").click();
}


/***
 * 跳转到管理页面
 */
function goguanli(){
	top.location.href=root+"/page_manage/key/getAllPaga";
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
 * 弹出div窗口
 * 
 * @param title
 *            窗口的标题
 * @param msg
 *            窗口中的内容（html代码）
 * @param w
 *            窗口宽度
 * @param h
 *            窗口高度
 */
function alertWin(title, msg, w, h) {
	var titleheight = "80px"; // 提示窗口标题高度
	var bordercolor = "#666699"; // 提示窗口的边框颜色
	var titlecolor = "#FFFFFF"; // 提示窗口的标题颜色
	var titlebgcolor = "#334454"; // 提示窗口的标题背景色
	var bgcolor = "#FFFFFF"; // 提示内容的背景色

	var iWidth = getWidth();
	var iHeight = getHeight();
	var bgObj = document.createElement("div");
	bgObj.style.cssText = "position:absolute;left:0px;top:0px;width:"
			+ iWidth
			+ "px;height:"
			+ iHeight
			+ "px;filter:Alpha(Opacity=30);opacity:0.3;background-color:#000000;z-index:101;";
	document.body.appendChild(bgObj);
	$(bgObj).attr("id", "bgDiv");

	var msgObj = document.createElement("div");
	msgObj.style.cssText = "position:absolute;font:15px '宋体';top:"
			+ (iHeight - h) / 2 + "px;left:" + (iWidth - w) / 2 + "px;width:"
			+ w + "px;height:" + h + "px;text-align:center;border:1px solid "
			+ bordercolor + ";background-color:" + bgcolor
			+ ";padding:1px;line-height:22px;z-index:102;";
	document.body.appendChild(msgObj);
	$(msgObj).attr("id", "msgDiv");
	var table = document.createElement("table");
	msgObj.appendChild(table);
	table.style.cssText = "margin:0px;border:0px;cellspacing:0; cellpadding:0;padding:0px;";
	table.cellSpacing = 0;
	var tr = table.insertRow(-1);
	var titleBar = tr.insertCell(-1);
	titleBar.style.cssText = "width:100%;height:"
			+ titleheight
			+ "px;text-align:left;padding:8px 0px;margin:0px;font:bold 16pt '宋体';color:"
			+ titlecolor + ";border:0px solid " + bordercolor
			+ ";background-color:" + titlebgcolor;
	titleBar.style.paddingLeft = "10px";
	titleBar.innerHTML = title;
	var moveX = 0;
	var moveY = 0;
	var moveTop = 0;
	var moveLeft = 0;
	var moveable = false;
	var closeBtn = tr.insertCell(-1);
	closeBtn.style.cssText = "cursor:pointer; padding:2px;background-color:"
			+ titlebgcolor;
	closeBtn.innerHTML = "<span style=\"font-size:15pt;float:right;color:&quot;\">×</span>";
	// 移除窗口事件
	closeBtn.onclick = function() {
		document.body.removeChild(bgObj);
		document.body.removeChild(msgObj);
	}
	var msgBox = table.insertRow(-1).insertCell(-1);
	msgBox.style.cssText = "padding:10px;";
	msgBox.colSpan = 2;
	msgBox.innerHTML = msg;
	// 获得事件Event对象，用于兼容IE和FireFox
	function getEvent() {
		return window.event || arguments.callee.caller.arguments[0];
	}
}
/**
 * 跳转到管理页面
 */
function toGuanLi() {
	var s = $("#id",parent.frames['frame_left'].document).val();
	//alert(s);
	var url = root+"/page_manage/key/zanCunChangeSate?pageData.id="+s;
	$.ajax({
		type : 'POST',
		cache:false,
		url : url,
		dataType : "text",
		success : function(data) {
			top.location.href=root+"/page_manage/key/getAllPaga";
	}
	});
	//top.location.href = root + "/page_manage/key/getAllPaga";
}
function turnFirstHtml(){
	new bombBox('turnFirstHtml', 'box', {
		title : '提示',
		content : '<div class="editpage_zancun_div">你即将跳出修改页面，是否保存当前内容？</div><div class="editpage_zancun_div_in_div"><input type="button" class="editpage_backBtn" onclick="noSavePage()" value="不保存" /><input type="button" class="editpage_sure_btn" onclick="tijiaoHtml()" value="保存" /></div>',
		width : '390',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#turnFirstHtml").click();
}
/**
 * 跳转到page页面
 */
function toPage(pageLink) {
	top.location.href = pageLink;
}
function turnPayForAction(){
	window.location.href=root+"/shopping_cart/key/getAll?sign=1";
}
function noSavePage(){
	window.location.href=root+"/frame/key/toIndex";
}
function tijiaoHtml(){
	ajaxSubmit(parent.frames['frame_left'].document.getElementById("form"), function(data){
		top.location.href=root+"/page_manage/key/getAllPaga";
	});
}