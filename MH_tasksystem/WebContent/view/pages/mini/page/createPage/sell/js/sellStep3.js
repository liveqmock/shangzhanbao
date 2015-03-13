$(function() {
	if(!$("[id=phone]", parent.frames['frame_main'].document).is(":hidden")){
		//若模板得电话号码处于显示状态，则将修改营销动作页面得电话号码默认选中
		$("#step_phone").closest("div").prev().find("input[type=checkbox]").attr("checked",'checked')
		//获取页面id
		var pageid = $("#id").val();// pageId
		//获取服务id
		var productId = $("#step_phone").closest("div").prev().find("input[type=checkbox]").attr("data");
		// 获取电话号码
		var telVal = $("[id=phone]", parent.frames['frame_main'].document).html();
		var addUrl = root + "/page_manage/key/ajaxAddProduct"// 添加服务的地址
		var price = $("#step_phone").closest("div").prev().find("input[type=checkbox]").attr("data1");// 服务价格
		var name = $("#step_phone").closest("div").prev().find("input[type=checkbox]").attr("data2");// 服务名称
		var pageStatus = $("#status").val();
		$("#TelAndMsg").empty();
		$("[id=edit_bg_div]",parent.frames['frame_main'].document).each(function(){
			$(this).remove();
		});
		$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
			$(this).hide();
		});
		var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
		$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productContent' value='" + telVal + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productPrice' value='" + price + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productName' value='" + name + "'/>");
		$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
		$("#TelAndMsg").append("<input name='pageData.status'>" + pageStatus + "'/>")
		$("#TelAndMsg").attr("action", addUrl);
		ajaxSubmit(document.getElementById("TelAndMsg"),function(data) {});
	}
	//创建第三步执行
	//判断库中是否存在在线购买
	if($("#sellForm").attr("data")=="3"){
		$.ajax({
			type : 'POST',
			url : root+"/page_manage/key/goumaiProduct?pageData.id="+$("#id").val(),
			dataType : "json",
			success : function(data) {
			  if(data=="1"){
				  getComp($("#imgIdent").prev("input"));//查询购买主键  并且替换数据
			  }else{
				  deleteGoodsRemoveDiv();   //删除相关信息
			  	}
			}
		});
		//页面留言div存在   则把留言复选框勾上
		$("[type=checkbox]").each(function(){
			if($("[id=messageBoardDiv]", parent.frames['frame_main'].document).html()!="" && $("[id=messageBoardDiv]", parent.frames['frame_main'].document).html()!=undefined){
				if($(this).attr("producttype")=="1"){
					$(this).attr("checked",true);
				}
			}
			//在线客服
			if($("[id=previewPro]", parent.frames['frame_main'].document).html()!="" && $("[id=previewPro]", parent.frames['frame_main'].document).html()!=undefined){
				if($(this).attr("producttype")=="5"){
					$(this).attr("checked",true);
				}
			}
		});
		
			
	}
		
	userId = $("#userId").val();
	if ($("[id=phone]", parent.frames['frame_main'].document).css("display") == "block") {
		$("#step_phone").show();
		var phone_num = trim($("#phone", parent.frames['frame_main'].document).text().replace("删除", "").replace("修改", ""));
		// 给电话赋初值
		$("#step_phone").val(phone_num);
		$("#step_phoneDiv").show();
	}

	$("#step_phone").blur(function() {
		getPhone($(this));
		var productId = $(this).closest("div").prev().find("input[type=checkbox]").attr("data");// 服务ID
		var pageid = $("#id").val();// pageId
		var productcontent = null;// 服务内容
		var pageStatus = null;// page状态
		productcontent = $(this).closest("div").prev().find("input[type=checkbox]").attr("data3");
		if (productcontent == null || productcontent == "") {
			productcontent = "400-000-0000";
			$(this).val("400-000-0000");
			$("[id=phone]", parent.frames['frame_main'].document).css("display", "block");
			$("[id=phone]", parent.frames['frame_main'].document).html(trim($(this).val()));
		}
		pageStatus = $("#status").val();
		var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
		$("#TelAndMsg").empty();
		var editTel = root + "/page_manage/key/ajaxEditTel";
		$("#TelAndMsg").find("#content").text(htmlinfo);
		$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
		$("#TelAndMsg").append("<input type='text' name='pageProductData.productContent' value='" + productcontent + "'/>");
		$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
		$("#TelAndMsg").append("<input name='pageData.status'>" + pageStatus + "'/>")
		$("#TelAndMsg").attr("action", editTel);
		ajaxSubmit(document.getElementById("TelAndMsg"), function(data) { });
	});

	$("#step_phone").mousedown(function() {
		getCheck($(this).closest("div").prev().find("input[type=checkbox]"), 'div_phone');// 电话号码
	});
	
	// 判断服务当前page拥有的服务是否在订单中存在
	$("input[class=ckProduct]:checked").each(function() {
		if ($(this).attr("checked")) {
			var productId = $(this).attr("data");// 服务ID
			var pageid = $("#id").val();// pageId
			$.ajax({
				type : "POST",
				url : root + '/order/key/getOrderState',
				data : 'orderProductData.pageId=' + pageid + '&orderProductData.productId=' + productId,
				success : function(data) {
					if (data == 0) {
						$("input[data='" + productId + "']").attr( "data3", "1");
					}
				}
			});
		}
	});

	
	
	/**
	 * 选择服务时触发的事件
	 */
	$(".ckProduct").live("change", function() {
		var flag = "";
		var productId = $(this).attr("data");// 服务ID
		var price = $(this).attr("data1");// 服务价格
		var name = $(this).attr("data2");// 服务名称
		var pageid = $("#id").val();// pageId
		var productcontent = null;// 服务内容
		var pageStatus = null;// page状态
		var addUrl = root + "/page_manage/key/ajaxAddProduct"// 添加服务的地址
		var delUrl = root + "/page_manage/key/ajaxDelProduct"// 删除服务的地址
		// 添加需要付费的服务时需要加的弹窗
		var addPayPrice = "<div class='clear'></div><div id='payPrice" + productId + "' class='DispalyDiv'><span>" + name + "</span>" + "<span><strongclass='font_Money'>￥" + price + "</strong> 元/年/坐席</span>" + "</div>"
		if ($(this).attr("data3") == 1) { // 如果此服务已经生成订单 不能移除
			$(this).attr("checked", "checked");
			$(this).attr("clcik", test); // 添加弹出div事件
			return;
		}
		if ($(this).attr("checked")) {// 若check被选中
			$('#exportCsv').unbind("change");
			if ($(this).attr("data1") == "") {// 免费服务
				if ($(this).attr("producttype") == "1") {
					addMessageBoard();// 客户留言
				} else if ($(this).attr("producttype") == "2") {
					$("#step_phoneDiv").show();
					showPhone($(this));// 电话号码
				}else if ($(this).attr("producttype") == "6") {   //在线购买
					  $(this).removeAttr("checked");
					  $(this).attr("disabled",true);   //在查询出服务之前把复选框禁用
						getComp($(this));  //调用查询购买的方法
				}
				
			} else {// 非免费服务
				$("#zaixiankefu").parent("span").parent("p").append(addPayPrice);
			}
			if ($(this).attr("producttype") == "2") {// 判断是否为电话号码  若为电话号码则暂时不执行ajax方法 等用户填写电话号码后再保存
				$("#step_phone").val("400-000-0000");
				$("[id=phone]", parent.frames['frame_main'].document).html($("step_phone").val());
				getPhone($(this));
				productcontent = $(this).closest("div").prev() .find("input[type=checkbox]").attr("data3");
				if (productcontent == null || productcontent == "") {
					productcontent = "400-000-0000";
					$(this).val("400-000-0000");
					$("[id=phone]", parent.frames['frame_main'].document) .css("display", "block");
					$("[id=phone]", parent.frames['frame_main'].document) .html($("#step_phone").val());
				}
				pageStatus = $("#status").val();
				$("#TelAndMsg").empty();
				var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
				$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productContent' value='" + productcontent + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productPrice' value='" + price + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productName' value='" + name + "'/>");
				$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
				$("#TelAndMsg").append("<input name='pageData.status'>" + pageStatus + "'/>")
				$("#TelAndMsg").attr("action", addUrl);
				ajaxSubmit(document.getElementById("TelAndMsg"),function(data) {});
			}else if($(this).attr("producttype") == "5"){
				var zaixianHtml = "<div id=\"previewPro\" style=\"position: fixed;top:40%;left:90%; right: 20;z-index:1000;\">" +
						"<img src=\""+root+"/view/images/pages/zaixian.jpg\"/></div>"
				$("body", parent.frames['frame_main'].document).append(zaixianHtml);
				pageStatus = $("#status").val();
				$("#TelAndMsg").empty();
				var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
				$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productContent' value='" + productcontent + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productPrice' value='" + price + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productName' value='" + name + "'/>");
				$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
				$("#TelAndMsg").append("<input name='pageData.status'>" + pageStatus + "'/>")
				$("#TelAndMsg").attr("action", addUrl);
				ajaxSubmit(document.getElementById("TelAndMsg"), function(data) { });
			} else {
				pageStatus = $("#status").val();
				$("#TelAndMsg").empty();
				var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
				$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productContent' value='" + productcontent + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productPrice' value='" + price + "'/>");
				$("#TelAndMsg").append("<input type='text' name='pageProductData.productName' value='" + name + "'/>");
				$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
				$("#TelAndMsg").append("<input name='pageData.status'>" + pageStatus + "'/>")
				$("#TelAndMsg").attr("action", addUrl);
				ajaxSubmit(document.getElementById("TelAndMsg"), function(data) { });
			}
		} else {// check未选中 取消服务
			if ($(this).attr("data1") == "") {// 免费服务
				if ($(this).attr("producttype") == "1") {
					removeMessageBoard();
				} else if ($(this).attr("producttype") == "2") {
					showPhone($(this));
				}else if($(this).attr("producttype") == "6"){
					$("#imgIdent").prev("input").attr("checked","checked");  //在数据库未删除服务之前，复选框不去掉勾选
					$(this).attr("disabled",true); //在数据库未删除服务之前，复选框禁用
					$(".FormBtn").show();  //我写完了按钮显示
					deleteGoodsPage();   //删除相关信息
				}
			} else if($(this).attr("producttype") == "5"){
				$("#previewPro", parent.frames['frame_main'].document).remove();
				$(".DispalyDiv").remove();
			} else {
				$("#payPrice" + productId).remove();
			}
			var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
			$("#TelAndMsg").empty();
			$("#TelAndMsg").find("#content").text(htmlinfo);
			$("#TelAndMsg").append("<input type='text' name='pageData.id' value='" + pageid + "'/>");
			$("#TelAndMsg").append("<input type='text' name='pageProductData.pageId' value='" + pageid + "'/>");
			$("#TelAndMsg").append("<input type='text' name='pageProductData.productId' value='" + productId + "'/>");
			$("#TelAndMsg").append("<textarea id='content' name='content'>" + htmlinfo + "</textarea>")
			if(pageid!="" && productId!=""){
				$("#TelAndMsg").attr("action", delUrl);
				ajaxSubmit(document.getElementById("TelAndMsg"), function(data) { });
			}
		}
	});
	
});

function showPhone(info) {
	if ($(info).attr("checked") == "checked") {// 当复选框被选中时
		$("#step_phone").show();
	} else {
		$("#step_phone").hide();
		$("#step_phone").val("");
		$("[id=phone]", parent.frames['frame_main'].document).css("display", "none");
		$("[id=phone]", parent.frames['frame_main'].document).html("");
		$(info).closest("div").prev().find("input[type=checkbox]").attr("data3", "");
	}
}

// 添加销售电话和其他服务样式
function getCheck(info) {
	var scroll = $("#phone", parent.frames['frame_main'].document);
	var scroll_offset = scroll.offset();
	$("body,html", parent.frames['frame_main'].document).animate({
		scrollTop : scroll_offset.top - 400
	}, 1000);
	if ($(info).attr("checked") == "checked") {// 当复选框被选中时
		$("[id=phone]", parent.frames['frame_main'].document).css("display","block");
		$("[id=phone]", parent.frames['frame_main'].document).css("border",
				"2px solid red").css("background", "#FC9").css(
				"-moz-border-radius", "15px").css("-webkit-border-radius",
				"15px").css("border-radius", "15px");
	} else {
		$("[id=phone]", parent.frames['frame_main'].document).css("display", "none");
		$("[id=phone]", parent.frames['frame_main'].document).css("border", "").css("background", "").css("-moz-border-radius", "").css("-webkit-border-radius", "").css("border-radius", "");
		$("#step_phone").val("");
		$("[id=phone]", parent.frames['frame_main'].document).html("");
		$("[id=phone]", parent.frames['frame_main'].document).css("display", "none");
		$(info).closest("div").prev().find("input[type=checkbox]").attr("data3", "");
	}
}

// 添加销售电话
function getPhone(info) {
	var scroll = $("#phone", parent.frames['frame_main'].document);
	var scroll_offset = scroll.offset();
	$("body,html", parent.frames['frame_main'].document).animate({
		scrollTop : scroll_offset.top - 400
	}, 1000);
	if (trim($(info).val())) {
		$(info).closest("div").prev().find("input[type=checkbox]").attr("data3", $(info).val());
		$("[id=phone]", parent.frames['frame_main'].document).html(trim($(info).val()));
		$("[id=phone]", parent.frames['frame_main'].document).css("border", "").css("background", "").css("-moz-border-radius", "").css(
						"-webkit-border-radius", "").css("border-radius", "");
	} else {
		$("[id=phone]", parent.frames['frame_main'].document).css("border", "").css("background", "").css("-moz-border-radius", "").css(
						"-webkit-border-radius", "").css("border-radius", "");
		$("[id=phone]", parent.frames['frame_main'].document).html("");
		$(info).closest("div").prev().find("input[type=checkbox]").attr("data3", "");
	}
}


// 将form转为AJAX提交
function ajaxSubmit(frm, fn) {
	if(frm!=null){
	var dataPara = getFormJson(frm);
	 $.ajax({
		url : frm.action,
		type : frm.method,
		data : dataPara,
		success : fn
	 });
	}
}

// 将form中的值转换为键值对。
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
this.put = function(key, value) {
	if (this.data[key] == null) {
		this.keys.push(key);
	}
	this.data[key] = value;
};
/**
 * 禁用按钮
 */
function disableButton(){
	$(".Btn_next").attr("disabled","disabled");
	$(".Btn_tiao").attr("disabled","disabled");
	$(".Btn_buy").attr("disabled","disabled");
	$(".Btn_buys").attr("disabled","disabled");
}

/**
 * 创建PAGE时，第三步点击我写完了，提交表单信息
 */
function getsubmit() {
	disableButton();
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	 $("#newaddGoodsconfig", parent.frames['frame_main'].document).hide();
	// 获取main页面所有html代码
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	console.log(htmlinfo)
	var checked = $("input[type=checkbox]:checked");// 判断复选框是否选中
	//此id为帮客户创建page功能中所需要的客户id  勿删  冯
	$("#userDataId").val($("#userId_1", parent.frames['frame_top'].document).val());
	var pageProductDatas = new Array();
	var str = "";
		for ( var i = 0; i < checked.length; i++) {
			if ($(checked[i]).attr("data1") == "") {
				var id = $(checked[i]).attr("data");
				var name = $(checked[i]).attr("data2");
				var content = $(checked[i]).attr("data3");
				str = str + "&pageProductData.productId=" + id
						+ "&pageProductData.productName=" + name
						+ "&pageProductData.productContent=" + content;
						
			}
		}
	$("#content").text(htmlinfo);
			ajaxSubmit(document.getElementById("sellForm"), function(data) {
				top.location.href = root + "/page_manage/key/toedit?id="+ $("#id").val()+ str + "&thistype=init";
		    });
	}
	

/**
 * 将商品添加到购物车 任何商品
 * 
 * @param pid
 *            商品id
 * @param num
 *            购买数量
 * @return
 */
function addToShopingCart(pid, num, pageid, name) {
	$.ajax({
		type : "post",
		url : root + "/shopping_cart/key/addShoppingCartData",
		data : "shoppingCartData.pageId=" + pageid
				+ "&shoppingCartData.productId=" + pid
				+ "&shoppingCartData.num=" + num + "&productName=" + name,
		dataType : "text",
		success : function(data) {
			if (data == 1) {
				alert('加入成功!');
			} else {
				alert('加入失败!');
			}
		}
	});

}


/**
 * 添加留言板
 */
function addMessageBoard() {
	var messageBoardDiv = "<div id=\"messageBoard\" style=\"\"><iframe src=\""
			+ root
			+ "/page_messageboard/key/toPageMessageboard?pageid="
			+ $("#id").val()
			+ "\" name=\"frame_messageBoard\" id=\"frame_messageBoard\" frameborder=\"no\" border=\"0\" scrolling=\"no\" height=\"100%\" width=\"100%\"></iframe></div>";
	if ($("#messageBoard", parent.frames['frame_main'].document).html() == null) {
		// 在body最后添加留言板功能
		$("#messageBoardDiv",parent.frames['frame_main'].document).append(messageBoardDiv);
		var scroll = $("#messageBoard", parent.frames['frame_main'].document);
		var scroll_offset = scroll.offset();
		$("body,html", parent.frames['frame_main'].document).animate({
			scrollTop : scroll_offset.top - 400
		}, 1000);
	} else {
		$("#messageBoard", parent.frames['frame_main'].document).remove();
	}
}

/**
 * 删除留言板
 * 
 * @author 文东
 * 
 */
function removeMessageBoard() {
	$("#messageBoard", parent.frames['frame_main'].document).remove();
}

// 去除空格的方法
function trim(str) {
	  if(str!=""){
		  if(str!=null){
		str = str.replace(/^(\s|\u00A0)+/, '');
		for ( var i = str.length - 1; i >= 0; i--) {
			if (/\S/.test(str.charAt(i))) {
				str = str.substring(0, i + 1);
				break;
			}
		}
	}
}
	return str;
}

/**
 * 修改PAGE详情，修改营销动作点击保存按钮时，保存PAGE服务信息和PAGE页面
 */
function savePageProductAndConent() {
	var fl=true;
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$("[id=edit_bg_div]", parent.frames['frame_main'].document).each(
			function() {
				$(this).remove();
			});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	console.log(htmlinfo);
	$("#content").val(htmlinfo);
	/* 文东修改 用来添加未添加的服务 */
	var checked = $("input[type=checkbox]:checked");// 判断复选框是否选中
	var pageProductDatas = new Array();
	var str = "";
	for ( var i = 0; i < checked.length; i++) {
		var pageId = $("#id").val();
		if ($(checked[i]).attr("data1") == "") {
			var id = $(checked[i]).attr("data");// 服务ID
			var name = $(checked[i]).attr("data2");// 服务名称
			var content = $(checked[i]).attr("data3");// 服务内容
			$("#editform").append("<input type='text' name='pageProductDatas[" + i + "].pageId' value='" + pageId + "'/>");
			$("#editform").append("<input type='text' name='pageProductDatas[" + i + "].productId' value='" + id + "'/>");
			$("#editform").append("<input type='text' name='pageProductDatas[" + i + "].productName' value='" + name + "'/>");
			$("#editform").append("<input type='text' name='pageProductDatas[" + i + "].productContent' value='" + content + "'/>");
		}
	}
	
		//如果左侧是在修改内容页面  就直接保存
		$("#editform").submit();
		
}
	/**
	 * 购买页面数据查询  与替换
	 */

	function clickgoumai(){
		//获取页面id
		var pageId = $("#id").val();// pageId
		//购买主键编号
		var sn= "_"+$("#compSn", parent.frames['frame_main'].document).val();
		$.ajax({
			type:"POST",
			url:root+"/goods_info/key/getGoodsInfo?pageGoodsInfoData.pageId="+pageId,
			dataType : 'text',// 返回值类型 一般设置为json
			success : function(data) {
				var json=eval("(" + data + ")");
				if(json.id!=""){
				var imgurl=root+json.goodsImg;
				if(json.goodsName==""){
					$("#goodsName", parent.frames['frame_main'].document).html("请输入商品名称（限定20字之内）");  //商品名称
				}else{
					$("#goodsName", parent.frames['frame_main'].document).html(json.goodsName);  //商品名称
				}
				if(json.goodsDes==""){
					$("#goodsDes", parent.frames['frame_main'].document).html("请输入商品描述（限定50字之内）");  //商品名称
				}else{
					$("#goodsDes", parent.frames['frame_main'].document).html(json.goodsDes);//商品描述
				}
				if(imgurl==""){
					$("#goodsImg", parent.frames['frame_main'].document).attr("src","/view/model/images/u94.png");
					$("#goodsImg", parent.frames['frame_main'].document).attr("data-original","/view/model/images/u94.png");
				}else{
					$("#goodsImg", parent.frames['frame_main'].document).attr("src",imgurl);
					$("#goodsImg", parent.frames['frame_main'].document).attr("data-original",imgurl);
				}
				if(json.promotion==""){
					$("#promotion", parent.frames['frame_main'].document).html("例如：购买数量满2赠1");
				}else{
					$("#promotion", parent.frames['frame_main'].document).html(json.promotion);
				}
				/*if(json.postage==""){
					$("#postage", parent.frames['frame_main'].document).html("例如：全国包邮");
				}else{
					$("#postage", parent.frames['frame_main'].document).html(json.postage);
				}*/
				if(json.goodsExpress==""){
					$("#goodsExpress", parent.frames['frame_main'].document).html("例如：全国包邮");
				}else{
					$("#goodsExpress", parent.frames['frame_main'].document).html(json.goodsExpress);
				}
				$("#goodsInfoDataId", parent.frames['frame_main'].document).val(json.id);//页面商品id  隐藏域
				var cons=json.configDatas;  //规格集合
				var goods_title="";
				var pinlei="";

				
				 if(cons.length>0){
					for(var i in cons){ 
							var span1="span1"+sn;   //选择样式
							var spantype="spantype"+sn;  //未选择样式
							//添加当前规格id
							var id=parent.frames['frame_main'].createRandom(1, 1, 999);
							var typeId="configType_"+id;  //规格spanid
							var configinputId="configinput_"+id;  //规格inputid
						 if(i==0){
							 //第一个表示已选择
							 pinlei +="<span class='"+span1+"'  id='"+typeId+"' title='"+cons[i].configName+"'  configTypeId='"+cons[i].id+"' onclick='clickConfigType("+typeId+")'>" 
							 +cons[i].configName+
							 "</span><input type=\"hidden\" value=\"\"  />"
							 $("#goodsPrice", parent.frames['frame_main'].document).html(cons[i].configPrice);
							 $("#name", parent.frames['frame_main'].document).val(cons[i].configName);
							 
						 }else{
							 pinlei +="<span class='"+spantype+"' title='"+cons[i].configName+"'  id='"+typeId+"' goodsId='"+json.id+"' configTypeId='"+cons[i].id+"' onclick='clickConfigType("+typeId+")'>" 
							 +cons[i].configName+
							 "</span><input type=\"hidden\" value=\"\"  />"
						 }
					}
					$("#addConfigType", parent.frames['frame_main'].document).before(pinlei);
					parent.frames['frame_main'].clickConfigTypeSelect(cons[0].id);  //品类切换方法
					$("#configTypeError", parent.frames['frame_main'].document).hide();
			  }else{
				  $("#configTypeError", parent.frames['frame_main'].document).show();
			  }
				$("#imgIdent").prev("input").attr("checked","checked");
				$("#imgIdent").prev("input").removeAttr("disabled");
			}else{
				$("#imgIdent").prev("input").attr("checked","checked");
				$("#imgIdent").prev("input").removeAttr("disabled");
			}
		}
	})
	$(".goodsRight", parent.frames['frame_main'].document).hide();
}
	/**
	 * 删除所有关当前page的商品信息
	 * 
	 */
	function deleteGoodsPage(){
		//获取页面id
		var pageId = $("#id").val();// pageId
		$.ajax({
			type:"post",
			dataType : 'text',// 返回值类型 一般设置为json
			url:root+"/goods_info/key/deletepageGoods?pageGoodsInfoData.pageId="+pageId,
			success : function(data) {
				deleteGoodsRemoveDiv();
			}
		})
	}
	/**
	 * 删除商品成功后的操作
	 */
	function deleteGoodsRemoveDiv(){
		 $("#goodsDiv", parent.frames['frame_main'].document).parent("div").remove();
		 $(".nav_goods", parent.frames['frame_main'].document).remove();//删掉页面相关的导航数据
		 $(".nav_buy", parent.frames['frame_main'].document).remove();//删除导航锚点
		 removejscssfile("/view/css/mini/css/goodsInfo.css","css");  //移除CSS
		$("#imgIdent").prev("input").removeAttr("checked");
		$("#imgIdent").prev("input").removeAttr("disabled");
		$("#pay").hide();
		$("#pay").hide();
	}
	
	
	
	/**
	 * 修改内容页面数据初始化
	 */
	function  updateCon(){
		//获取页面id
		var pageId = $("#PageId").val();// pageId
		window.location.href=root+"/page_manage/key/toeditLeft?id="+pageId;
	}
	/**
	 * 添加购买导航锚点
	 */
	function  nav_goods(){
		//获取页面id
		var buyModian = "buy_navigate";// pageId
		var nav="nav_buy";
		//避免页面出现重复数据
		$(".nav_buy", parent.frames['frame_main'].document).remove();
		 $(".navigate", parent.frames['frame_main'].document).append("<li class='"+nav+"'><a href='###' onclick=\"getMaodian('"+nav+"')\">" +
		 		"<lable id='"+buyModian+"' class='navName'>购买</lable></a></li>");
         $(".nav_goods", parent.frames['frame_main'].document).attr("id",nav);
         $(".nav_goods", parent.frames['frame_main'].document).append("<lable id=\""+buyModian+"\"></lable>");
	}
	/**
	 * 查询购买主键
	 */
	function selectComp(ch){
		var pageId = $("#id").val();// pageId
		$.ajax({
			type:"POST",
			dataType:"text",
			url:root+"/component/key/getCompData",
			success:function(data){
				if(data!="1"){
				var json=eval("(" + data + ")");
				$("#id").attr("data1",json.sn);
				 $("#goodsDiv", parent.frames['frame_main'].document).parent("div").remove();
				 $("#nav_buy", parent.frames['frame_main'].document).remove();
				 $(".nav_buy", parent.frames['frame_main'].document).remove();//删除导航锚点
				 $("#compSn", parent.frames['frame_main'].document).remove();
				var wapDiv="<div class=\"wraper\"   data='"+json.sn+"' id=\"goumaiwraper\" style=\"margin-bottom: 70px;\"><a id=\"\" class=\"nav_goods\"></a>"
				var wapendDiv="</div>"
				var con=wapDiv+json.code+wapendDiv;
				 $("#messageBoardDiv", parent.frames['frame_main'].document).before(con);
				 nav_goods();
				 $("body", parent.frames['frame_main'].document).append("<input type=\"hidden\" id=\"compSn\" value='"+json.sn+"'/> ");
				 clickgoumai();  //根据pageid  查询数据 替换页面购买的数据
				 // 移除虚线边框和图标
				 parent.frames['frame_main'].removeLine($("#goumaiwraper", parent.frames['frame_main'].document));
				 //添加虚线框
				 parent.frames['frame_main'].addLine($("#goumaiwraper", parent.frames['frame_main'].document));
				 //在页面为第三步时的操作
				  if($(ch).attr("data4")=="create"){
				 // 动态添加遮挡层
			     parent.frames['frame_main'].cc($("#slide1", parent.frames['frame_main'].document)); 
				 // 移除虚线边框和图标
				 parent.frames['frame_main'].removeLine($("#reason_div", parent.frames['frame_main'].document).parent("div"));
				 $("#reason_div", parent.frames['frame_main'].document).parent("div").find("div").css("border","none")
				  $("#reason_div", parent.frames['frame_main'].document).parent("div").find("div").find(".del_update").remove();
				  $("#reason_div", parent.frames['frame_main'].document).parent("div").find("div").find(".up_update").remove();
				  $("#reason_div", parent.frames['frame_main'].document).parent("div").find("div").find(".down_update").remove();
				  
				  }
				//页面滚动修改购买主键位置
				    var scroll_offset = $("#goumaiwraper", parent.frames['frame_main'].document).offset();
				    $("body,html", parent.frames['frame_main'].document).stop();
				    $("body,html", parent.frames['frame_main'].document).animate({
				      scrollTop : scroll_offset.top - 125
				    }, 1000);
					  $("#pay").show();  //填写收款账号提示
				}else{
					$("#imgIdent").prev("input").removeAttr("checked");
					return;
				}
			}
		})
	}
	/**
	 * 添加主键css和查询主键信息
	 */
	function  getComp(ch){
		var pageId = $("#id").val();// pageId
		 $.ajax({
				type :"post",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				url : root+"/page_manage/key/addGoodsInfoCss",
				data : $("#goodsInfoFrom", parent.frames['frame_main'].document).serialize(),
				dataType : "text",
				success : function(data){
					if(data=="1"){
						loadjscssfile();   //添加CSS
						selectComp(ch);//查询购买逐渐
					}else{
						$("#imgIdent").prev("input").removeAttr("checked");
						return;
					}
				 }
			});
	}
	

	/**
	 * 添加CSS文件
	 */
	function loadjscssfile(){
		var fileref=document.createElement("link");
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", "/view/css/mini/css/goodsInfo.css");
		 $("head", parent.frames['frame_main'].document).append(fileref);
		}
	/**
	 * 移除CSS文件
	 * @param filename
	 * @param filetype
	 */
	function removejscssfile(filename, filetype){
		var targetelement=(filetype=="js")? "script" : (filetype=="css")? "link" : "none"
		var targetattr=(filetype=="js")? "src" : (filetype=="css")? "href" : "none"
		var allsuspects=parent.frames['frame_main'].document.getElementsByTagName(targetelement)
		for (var i=allsuspects.length; i>=0; i--){
		if (allsuspects[i] && allsuspects[i].getAttribute(targetattr)!=null && allsuspects[i].getAttribute(targetattr).indexOf(filename)!=-1)
		   allsuspects[i].parentNode.removeChild(allsuspects[i])
		}
}
 
	/**
	 * 第三步的返回按钮
	 */
	function getSubmit2(){
		disableButton();
		var pageId = $("#id").val();// pageId
		$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
		$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
		$(".showline_banner", parent.frames['frame_main'].document).remove();
		$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
		//获取main页面所有html代码
		var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
		$("#userID").val(parent.document.getElementById("userId_1").value)
		$("#content").val(htmlinfo);
		ajaxSubmit(document.getElementById("sellForm"), function(data){
			top.location.href = root + "/page_manage/key/toCreatePage?id="+$("#templateid").val()
			+"&userData.id="+$("#userID").val()+"&step=2&pageid="+pageId;
		});
	}
	
	
