$(function() {
	var winWidth = getWidth();// 获取窗口宽度
	var winHeight = getHeight();// 获取窗口高度
	// 给各div辅长宽
	$("#top").css("width", winWidth);
	$("#main").css("width", winWidth);
//	if($("#thistype").val()=='init'){
//		$("#main").css("height", winHeight-110);
//	} else {
		$("#main").css("height", winHeight-50);
//	}
	$(window).resize(function() {
		winWidth = $(this).width();
		winHeight = $(this).height();
		// 给各div辅长宽
		$("#top").css("width", winWidth);
		$("#main").css("width", winWidth);
//		if($("#thistype").val()=='init'){
//			$("#main").css("height", winHeight-110);
//		} else {
			$("#main").css("height", winHeight-50);
//		}
	});
	if($("#thistype").val()=='init'){
		selectDivBox();
	}
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
/**
 * 将form转为AJAX提交
 * @param frm
 * @param fn
 */
function ajaxSubmit(frm, fn) {
	var dataPara = getFormJson(frm);
	$.ajax({
		url : frm.action,
		type : frm.method,
		data : dataPara,
		success : fn
	});
}
/**
 * 将form中的值转换为键值对。
 * @param frm
 * @returns 
 */
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
 * 进入修改页面弹出框
 */
function selectDivBox(){
	var msgBox = "<div style='margin-top:30px;'><div style='margin:0 auto;width:350;'><font style='font:15px Hevetica Neve,Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;line-height: 22px;'>你的核心卖点已完成！<br/>下面可以开始修改详细内容了。<br/><font style='color: #706D6D;'>(鼠标移入相应区域，即可修改该区域的图片和描述)</font>";
	msgBox = msgBox + "</font></div></div>";
	msgBox = msgBox + "<center><input type=\"button\" style=\"border:1px solid #00a0b1;margin-top: 20px;background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;width:360px;height:40px;cursor:pointer;font-size:15px;\" onclick=\"closeSelectBox()\" value=\"开始修改\" /></center>";
	new bombBox('selectBtn', 'selectBox', {
		title : '恭喜你！',
		content : msgBox,
		width : '400',
		height : '220',
		top : '',
		left : '',
		fixed : '',
		close : 'close'
	});
	$("#selectBtn").click();
}

/**
 * 查看在线客户详情弹出框
 */
function selectBox(){
	var msgBox = "<br/br/><center><div style='width:95%;height:95%;background:#FFFFFF;'><iframe src='"
	+root+"/view/pages/mini/page/createPage/select/message.html'"+
	" frameborder='no' border='1' scrolling='auto' height='100%' width='100%'></iframe></div></center>";
	new bombBox('selectDiv', 'selectDivBox', {
		title : '在线咨询产品介绍',
		content : msgBox,
		width : getWidth()*0.7+'',
		height : getHeight()*0.8+'',
		top : '',
		left : '',
		fixed : '',
		close : 'close'
	});
	$("#selectDiv").click();
}
/**
 * 关闭进入修改页面弹出框
 * 
 */
function closeSelectBox(){
	$("#selectBox").remove();
}
/**
 * 暂存方法弹出框
 */
function zancun(){
	new bombBox('zancun', 'box', {
		title : '暂存成功',
		content : '<div class="editpage_zancun_div">暂存的微站只有你自己能访问，你可以在管理页面进行修改和发布。</div><div class="editpage_zancun_div_in_div"><button class="editpage_zancun_div_in_div_calBtn">继续修改</button><input type="button" class="editpage_zancun_div_in_div_sureBtn" onclick="goguanli()" value="管理微站" /></div>',
		width : '480',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("[class=Btn_1]", parent.frames['frame_top'].document).each(function(){
		$(this).removeAttr("disabled");
	});
	$(".zancun", parent.frames['frame_top'].document).removeAttr("disabled");
	$(".turnFirstHtml", parent.frames['frame_top'].document).removeAttr("disabled");
	$("#zancun").click();
}
/**
 * 点击返回首页，提示是否保留修改
 */
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
 * 保留修改html
 */
function tijiaoHtml(){
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content",parent.frames['frame_top'].document).val(htmlinfo);
	ajaxSubmit(parent.frames['frame_top'].document.getElementById("form"), function(data){
		isleavaeSava = false;
		top.location.href=root+"/page_manage/key/getAllPaga";
	});
}

/**
 * 等待弹出div
 */
function waitDiv(){
	new bombBox('waitDiv', 'waitDivbox', {
		title : '正在上传，请稍后...',
		content : '<center><img src="'+root+'/view/images/bombBox/40.gif" width="37" height="37" /></center>',
		width : '300',
		height : '100',
		top : '',
		left : '',
		fixed : '',
		close : ''
	});
	$("#waitDiv").click();
}

/**
 *  修改page时候 如果已经勾选了付费服务 则提示不让修改
 */
function showIsPayDiv(){
	new bombBox('showIsPayDiv', 'closetIsPay', {
		title : '提示',
		content : '<div style="margin-top:30px;font-size:15px;">收费服务已经加入购物车，无法取消，请进入购物车删除！。</div><div style="margin-top:30px;text-align:center;"><button style="margin-left:15px;border:0px;background:#666666;color:#FFFFFF;width:100px;height:30px;">取消</button></div>',
		width : '400',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#showIsPayDiv").click();
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





/**
 * 发布窗口弹出框
 * @param content
 * 弹出框内容
 * @param w
 * 弹出框宽
 * @param h
 * 弹出框高
 */
function test(content,w,h){
	
	new bombBox('service', 'serviceDiv', {
		title : '',
		content : content,
		width : w,
		height : h,
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#service").click();
}




/**
 * 文字logo
 * @param content
 * 弹出框内容
 * @param w
 * 弹出框宽
 * @param h
 * 弹出框高
 */
function fontlogo(content,w,h){
	new bombBox('fontlogo', 'fontlogobox', {
		title : '文字logo',
		content : content,
		width : w,
		height : h,
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#fontlogo").click();
}

/**
 * 文字Logo确定按钮事件
 */
function logoOk() {
	var logoInput = $("#logoFont");
	// 获取文本框的值
	var logoText = logoInput.val();
	// 获取文本框中文字的字体
	var typeface = logoInput.css("font-family");
	// 获取文本框中文字的颜色
	var fontColor = $("#color").val();
	// 获取文本框中文字的粗细
	var fontSize = logoInput.css("font-weight");
	// 拼装html
	var logoHtml = "<font id=\"logoImagefont\" style=\"font-size:30px;color:"
			+ fontColor + ";font-family:" + typeface + ";font-weight:"
			+ fontSize + "\">" + logoText + "</font>";
	// 隐藏原来的图片
	$("#logoImage", parent.frames['frame_main'].document).hide();
	$("#logoImagefont", parent.frames['frame_main'].document).remove();
	// 修改logo
	$("#logoImage", parent.frames['frame_main'].document).after(logoHtml);
	$("#fontlogobox").remove();
}
/***
 * 跳转到管理页面
 */
function goguanli(){
	top.location.href=root+"/page_manage/key/getAllPaga";
}
/**
 * 跳转到管理页面
 */
function toGuanLi(){
	isleavaeSava = false;
	var s = $("#id",parent.frames['frame_top'].document).val();
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
}
/**
 * 跳转到page页面
 */
function toPage(pageLink){
	window.open (pageLink);
}
function turnPayForAction(){
	window.location.href=root+"/shopping_cart/key/getAll?sign=1";
}
function noSavePage(){
	window.location.href=root+"/frame/key/toIndex";
}
/**
 * 暂存方法弹出框
 */
function Goodserror(){
	new bombBox('goodserrorDiv', 'goodserrorType', {
		title : '信息提示',
		content : '<div class="editpage_zancun_div" style="font-size:18px;">你的商品信息未保存</div>',
		width : '480',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#goodserrorDiv").click();
}

