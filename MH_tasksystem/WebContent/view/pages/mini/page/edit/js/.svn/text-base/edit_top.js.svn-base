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
 * 预览page
 */
function yl() {
	parent.isleavaeSava = false;
	$("#fb").attr("disabled","disabled");
	$("#zc").attr("disabled","disabled");
	$("#yl").attr("disabled","disabled");
	$(".zancun").attr("disabled","disabled");
	$(".turnFirstHtml").attr("disabled","disabled");
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$("#edtit" ,parent.frames['frame_main'].document).hide();
	$("#goodsRight" ,parent.frames['frame_main'].document).hide();
	parent.frames['frame_left'].bc();
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#form").attr("target", "_top");
	$("#form").attr("action", root + "/page_manage/key/getTemplateYulan?id="+$("#id").val());
	$("#form").submit();
}
/**
 * 发布方法
 */
function fb(){
	parent.isleavaeSava = false;
	$("#fb").attr("disabled","disabled");
	$("#zc").attr("disabled","disabled");
	$("#yl").attr("disabled","disabled");
	$(".zancun").attr("disabled","disabled");
	$(".turnFirstHtml").attr("disabled","disabled");
	
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#edtit" ,parent.frames['frame_main'].document).hide();
	$("#goodsRight" ,parent.frames['frame_main'].document).hide();
	
	// 发布之前查询是否有使用购买服务和收款账号
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/ajaxisExitReceivableAccount?pageData.id＝'+$("#pageId").val(),
		data : 'pageData.id='+ $("#pageId").val(),
		success : function(data){
			// 若用户存在收款账号，则让发布页面  反之提示用户需要添加收款账号
			if(data == "existence"){
				var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
				$("#content").val(htmlinfo);
				parent.frames['frame_left'].bc();
				$("#form").attr("target", "_top");
				if($("#pageName").val()==""){
					$("#form").attr("action", root + "/page_manage/key/updatePageData");
					$("#form").submit();
				} else {
					$("#form").attr("action", root + "/page_manage/key/createPageHtml");
					ajaxSubmit(document.getElementById("form"), function(data) {
						if(data!=""){
							var obj = eval('(' + data + ')'); 
							var addFbHtml1="";
							for(var i = 0; i < obj.length; i++){
								 addFbHtml1 =addFbHtml1+
									"<tr><td align='center'><input type='text' value='"+obj[i].name+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'></td>"+
									"<td align='center'><input type='text' value='"+obj[i].productConfig+"'	readonly='readonly' size='11'	style='background: transparent; border: none; text-align: center;'></td>"+
									"<td align='center'>"+
									"<span class='font_EN'>"+
									"<input id='' type='text' size='8' value='"+obj[i].price+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'>"+
									"</span></td></tr>";
							}
							var addFbHtml = "<div >"+
								"<table border=\"0\" class=\"edit_publish_bug_div_table\">"+
								"<tr><td>"+
								"<font style=\"width: 550px;\">你选择了收费服务，它需要收费后才能使用</font>"+
								"</td></tr>"+
								"<table border=\"1\" cellspacing=\"0\" class='edit_publish_bug_div_table_in_table' >"+
								"<tr style=\"background-color: #aaaaaa;\">"+
								"<td align=\"center\">服务名称</td>"+
								"<td align=\"center\">规格</td>"+
								"<td align=\"center\">价格</td></tr>"+addFbHtml1+
								"</table>"+
								"<tr align='center'><input type='button' class='pb_buyProduct_Btn' value='暂存，稍后付款' onclick='toGuanLi()'>"+
								"<input type='button' value='去支付' id='' class='pb_buyProduct_Btn1' onclick='turnPayForAction();'></tr></table></div>";
							window.parent.fabu(addFbHtml,'620','250');
							$("#fb").removeAttr("disabled");
							$("#zc").removeAttr("disabled");
							$("#yl").removeAttr("disabled");
							$(".zancun").removeAttr("disabled");
							$(".turnFirstHtml").removeAttr("disabled");
							parent.isleavaeSava = true;
						}else{
						var pageId=$("#pageId").val();
						var domain=$("#pagePath").val()+$("#pageLink").val();
						var pageName=$("#pageName").val();
						$.ajax({
							type : "POST",
							url : root + '/page_manage/key/sharePage',
							data : 'pageData.id=' + pageId,
							success : function(data1) {
								if(data1!=0){
									var imgUrl=data1.substring(0,data1.indexOf('&'));   //截取出二维码大图地址
									var img=root+imgUrl;   //大图完整路径
									var url1=root+"/page_manage/key/toWeixin?ImgUrl="+img+"&domain="+domain+"&pageName="+pageName;
									var addFbHtml = "<div style='width: 597px;height: 570px;'>" +
											"<div class='weixinDivTop'>手机分享，用微信扫一扫</div>" +
											"<div class='weixinDivTop_img'>" +
											"<img  src='"+img+"' >" +
										    "<p class='weixinDivTop_p '><a href='"+url1+"' target='_blank'>怎么分享？</a></p>" +
										    "</div>" +
										    "<div class='wexinDiv_hr'></div>" +
										    "<div class='weixininput'>" +
										    "<a   onclick=\"toGuanLi()\"  href='###'>进入管理页面</a>" +
										    "<a   " +
										    " href='"+$("#pagePath").val()+$("#pageLink").val()+"'  target='_blank'>访问商站</a></div></div> <input type='hidden'  value='"+img+"'  class='imgUrl'>";
									window.parent.fabuSuccess(addFbHtml,'597','580');
									$("#fb").removeAttr("disabled");
									$("#zc").removeAttr("disabled");
									$("#yl").removeAttr("disabled");
									$(".zancun").removeAttr("disabled");
									$(".turnFirstHtml").removeAttr("disabled");
									parent.isleavaeSava = true;
								}else{
									return false;
								}
							}
						});
						}
						});
					}
			}else{
				// 定义弹出提示层
				var toAddReceivableHtml = "<div id=\"addReceivable\" style=\"position:fixed;z-index:10;top:30%;right:30%;width: 520px;height: 165;background-color: gray;\">" +
										  "<img style=\"width: 89px;height: 92px;text-align: center;float: left;margin-left: 55px;margin-top: 45px;\" src=\"" + root + "/images/mini/purchase/buy/image_u289.png\">" +
										  "<div style=\"padding-top: 73px;padding-left:200px;\">" +
										  "<span style=\"font-family:'微软雅黑Regular','微软雅黑';font-size: 16px;color: #FFF;\">请补充收款账号，以免影响收款。</span><br>" +
										  "</div></div>";
				$("body",parent.frames['frame_main'].document).append(toAddReceivableHtml);
				var h=parent.document.documentElement.clientHeight;
				var w=parent.document.documentElement.clientWidth;
				var div="<div style='background-color: rgba(0,0,70,.1);position:fixed;border:0px solid;z-index:4;left:0;top:0;width:"+w+"px;height:"+h+"px;'></div>";
				$("body",parent.document).append(div);
				setTimeout(function(){
					$("#addReceivable",parent.frames['frame_main'].document).remove();
					parent.frames['frame_left'].bc();
					var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
					$("#content").val(htmlinfo);
					$("#form").attr("target", "_top");
					if($("#pageName").val()==""){
						$("#form").attr("action", root + "/page_manage/key/updatePageData");
						$("#form").submit();
					} else {
						$("#form").attr("action", root + "/page_manage/key/createPageHtml");
						ajaxSubmit(document.getElementById("form"), function(data) {
							if(data!=""){
								var obj = eval('(' + data + ')'); 
								var addFbHtml1="";
								for(var i = 0; i < obj.length; i++){
									 addFbHtml1 =addFbHtml1+
										"<tr><td align='center'><input type='text' value='"+obj[i].name+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'></td>"+
										"<td align='center'><input type='text' value='"+obj[i].productConfig+"'	readonly='readonly' size='11'	style='background: transparent; border: none; text-align: center;'></td>"+
										"<td align='center'>"+
										"<span class='font_EN'>"+
										"<input id='' type='text' size='8' value='"+obj[i].price+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'>"+
										"</span></td></tr>";
								}
								var addFbHtml = "<div >"+
									"<table border=\"0\" class=\"edit_publish_bug_div_table\">"+
									"<tr><td>"+
									"<font style=\"width: 550px;\">你选择了收费服务，它需要收费后才能使用</font>"+
									"</td></tr>"+
									"<table border=\"1\" cellspacing=\"0\" class='edit_publish_bug_div_table_in_table' >"+
									"<tr style=\"background-color: #aaaaaa;\">"+
									"<td align=\"center\">服务名称</td>"+
									"<td align=\"center\">规格</td>"+
									"<td align=\"center\">价格</td></tr>"+addFbHtml1+
									"</table>"+
									"<tr align='center'><input type='button' class='pb_buyProduct_Btn' value='暂存，稍后付款' onclick='toGuanLi()'>"+
									"<input type='button' value='去支付' id='' class='pb_buyProduct_Btn1' onclick='turnPayForAction();'></tr></table></div>";
								window.parent.fabu(addFbHtml,'620','250');
								$("#fb").removeAttr("disabled");
								$("#zc").removeAttr("disabled");
								$("#yl").removeAttr("disabled");
								$(".zancun").removeAttr("disabled");
								$(".turnFirstHtml").removeAttr("disabled");
								parent.isleavaeSava = true;
							}else{
							var pageId=$("#pageId").val();
							var domain=$("#pagePath").val()+$("#pageLink").val();
							var pageName=$("#pageName").val();
							$.ajax({
								type : "POST",
								url : root + '/page_manage/key/sharePage',
								data : 'pageData.id=' + pageId,
								success : function(data1) {
									if(data1!=0){
										var imgUrl=data1.substring(0,data1.indexOf('&'));   //截取出二维码大图地址
										var img=root+imgUrl;   //大图完整路径
										var url1=root+"/page_manage/key/toWeixin?ImgUrl="+img+"&domain="+domain+"&pageName="+pageName;
										var addFbHtml = "<div style='width: 597px;height: 570px;'>" +
												"<div class='weixinDivTop'>手机分享，用微信扫一扫</div>" +
												"<div class='weixinDivTop_img'>" +
												"<img  src='"+img+"' >" +
											    "<p class='weixinDivTop_p '><a href='"+url1+"' target='_blank'>怎么分享？</a></p>" +
											    "</div>" +
											    "<div class='wexinDiv_hr'></div>" +
											    "<div class='weixininput'>" +
											    "<a   onclick=\"toGuanLi()\"  href='###'>进入管理页面</a>" +
											    "<a   " +
											    " href='"+$("#pagePath").val()+$("#pageLink").val()+"'  target='_blank'>访问商站</a></div></div> <input type='hidden'  value='"+img+"'  class='imgUrl'>";
										window.parent.fabuSuccess(addFbHtml,'597','580');
										$("#fb").removeAttr("disabled");
										$("#zc").removeAttr("disabled");
										$("#yl").removeAttr("disabled");
										$(".zancun").removeAttr("disabled");
										$(".turnFirstHtml").removeAttr("disabled");
										parent.isleavaeSava = true;
									}else{
										return false;
									}
								}
							});
								}
							});
						}
				},2500);
			}
		}
	});
}

/**
 * 添加延迟加载js
 */
function addLazy(){
	$("img",parent.frames['frame_main'].document).each(function(){
		$(this).attr("data-original",$(this).attr("src"));
		$(this).attr("src","");
	});
	$("#lazyJs",parent.frames['frame_main'].document).attr("src","/view/js/jquery/jquery.lazyload.js");
	$("#loadTemplateJs",parent.frames['frame_main'].document).attr("src","/js/template/loadTemplate.js");
}

/**
 * 暂存方法
 */
function zc(){
	parent.isleavaeSava = false;
	$("[class=Btn_1]", parent.frames['frame_top'].document).each(function(){
		$(this).attr("disabled","disabled");
	});
	$(".zancun", parent.frames['frame_top'].document).attr("disabled","disabled");
	$(".turnFirstHtml", parent.frames['frame_top'].document).attr("disabled","disabled");
	
	parent.frames['frame_left'].bc();
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#status").val("0");
	$("#form").attr("action",root+"/page_manage/key/zancun");
	ajaxSubmit(document.getElementById("form"), function(data){
		window.parent.zancun();
	});
}
/**
 *  返回首页 方法
 */
function turnFirstHtml(){
	$("#edtit" ,parent.frames['frame_main'].document).hide();
	$("#goodsRight" ,parent.frames['frame_main'].document).hide();
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	var url = root+"/page_manage/key/ajaxFindPageDataById?pageData.id="+$("#id").val();
	$.ajax({
		type : 'POST',
		cache:false,
		url : url,
		dataType : "text",
		success : function(data) {
			if(data=='1'){
				$("#status").val("1");
				$("#form").attr("action",root+"/page_manage/key/createPageHtml");
			}else{
				$("#status").val("0");
				$("#form").attr("action",root+"/page_manage/key/zancun");
			}
	}
	});
	//$("#status").val("0");
	$("#form").attr("action",root+"/page_manage/key/zancun");
	window.parent.turnFirstHtml();
}
/**
 * 修改服务信息
 * @returns
 */
function edit_service(){
	parent.frames['frame_left'].location.href = root +"/page_manage/key/toeditService?pageid="+$("#id").val();
}


/**
 * 左侧跳转到修改页面
 * @param thisinfo
 */
function toedit(thisinfo) {
	var comInfo = $(thisinfo).parents(".update");// 组件信息
	var comId = comInfo.find(".component").val();// 获取组件id
	var divnum = "";
	var this_id = comInfo.find("[id]").attr("id");
	if (this_id != null && this_id != "") {
		divnum = getNum(this_id);
	}
	if($(thisinfo).parents(".update").attr("id") != "phone"){
		parent.frames['frame_left'].location.href = root
				+ "/component/key/toeditLeft?componentid=" + comId + "&divNum="
				+ divnum + "&pageid=" + $("#id").val();
	} else {
		parent.frames['frame_left'].location.href = root +"/page_manage/key/toeditService?pageid="+$("#id").val();
	}
}
/**
 * 解决mouseover与mouserout事件不停切换的问题（问题不是由冒泡产生的）
 * @param e
 * @param target
 * @returns {Boolean}
 */
function checkHover(e, target) {
	if (getEvent(e).type == "mouseover") {
		return !contains(target, getEvent(e).relatedTarget
				|| getEvent(e).fromElement)
				&& !((getEvent(e).relatedTarget || getEvent(e).fromElement) === target);
	} else {
		return !contains(target, getEvent(e).relatedTarget
				|| getEvent(e).toElement)
				&& !((getEvent(e).relatedTarget || getEvent(e).toElement) === target);
	}
}
/**
 * 
 * @param parentNode
 * @param childNode
 * @returns
 */
function contains(parentNode, childNode) {
	if (parent.frames['frame_main'].document.readyState == "complete") {
		if (parentNode.contains) {
			return parentNode != childNode && parentNode.contains(childNode);
		} else {
			return !!(parentNode.compareDocumentPosition(childNode) & 16);
		}
	}
}
/**
 * 取得当前window对象的事件
 * @param e
 * @returns {Boolean}
 */
function getEvent(e) {
	return e || window.event;
}
/**
 * 取得字符串中的数字
 * @param text‰
 * @returns
 */
function getNum(text) {
	var value = text.replace(/[^0-9]/ig, "");
	if (value == null || value == "") {
		return 0;
	}
	return value;
}


function ajaxCheckAcount(pageid){
	// 发布之前查询是否有使用购买服务和收款账号
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/ajaxisExitReceivableAccount?pageData.id＝'+pageid,
		data : 'pageData.id='+ pageid,
		success : function(data){
			$("#fb").removeAttr("disabled");
			$("#zc").removeAttr("disabled");
			$("#yl").removeAttr("disabled");
			$(".zancun").removeAttr("disabled");
			$(".turnFirstHtml").removeAttr("disabled");
			// 若用户存在收款账号，则让发布页面  反之提示用户需要添加收款账号
			if(data == "existence"){
				return true;
			}else{
				return false;
			}
		}
	})
}
