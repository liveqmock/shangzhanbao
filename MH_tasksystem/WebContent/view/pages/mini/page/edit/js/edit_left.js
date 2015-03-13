var jietuObj;

var oldimg = "[";
var divnum;
$(function(){
	divnum = $("#divnum").val();
	if(divnum != "0"){
		$("[id=component_num]").each(function(){
			$(this).text(divnum);
		});
		$(".FormTab").find("[id^=edit_]").each(function(){
			$(this).attr("id",$(this).attr("id")+divnum);
		});
	}
	$('input').each(function(){
		if($("form[name=sellForm]").length>0){
			return false;
		}
		if($("form[name=addGoodsNmae]").length>0){
			return false;
		}
		// 判断当前文本框是否属于form_div表单。
		if( $(this).parent().attr("name")!="editform" &&  $(this).parent().attr("name")!="" 
			&&  $(this).parent().attr("name")!=undefined  &&   $(this).parent().attr("name")!=null){
			console.log($(this).parent().attr("name"));
			var this_id = $(this).attr("id");
			if(this_id!="divnum" && this_id!="viewfile"){
				if($(this).attr("type") == "button"){
					return true;
				}
				if($(this).attr("type") == "file"){// 如果是图片
					oldimg = oldimg + "{'imgid':'"+this_id.replace("edit_","")+"','oldvalue':'"+$("#"+this_id.replace("edit_",""),parent.frames["frame_main"].document).attr("data-original")+"'},";
					return true;
				}
				if($(this).attr("isre") == "false"){
					return true;
				}
				
				if($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).attr("href")!=undefined){
					$(this).val(trim($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).attr("href")));
				}else{
					// 给文本框赋初值
					$(this).val(trim($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).text()));
				}
				$(this).attr("oldValue",trim($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).html()));
				$(this).attr("onfocusin","jumpAnchor(this)");
				$(this).attr("onblur","losesFocus(this)");
			}
		}
	});
	oldimg=oldimg.substring(0,oldimg.length-1);
	oldimg = "{'img':"+oldimg+"]}";
	$('textarea').each(function(){
		if($("form[name=sellForm]").length>0){
			return false;
		}
		if($("form[name=addGoodsNmae]").length>0){
			return false;
		}
		// 判断当前文本框是否属于form_div表单。
		if($(this).parent().attr("name")!="editform"){
			var this_id = $(this).attr("id");
			// 给文本域赋初值
			$(this).val(trim($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).html().replace(/(<br>)/g, "\r\n")));
			$(this).attr("oldValue",trim($("#"+this_id.replace("edit_",""),parent.frames['frame_main'].document).html()));
			$(this).attr("onfocusin","jumpAnchor(this)");
			$(this).attr("onblur","losesFocus(this)");
		}
	});
	$("#Btn_upload").attr("onclick","selectImg(this)");// 上传事件
	$("#edit_cancel").attr("onclick","my_cancel()");// 取消事件
	$("#edit_baocun").attr("onclick","bc()");// 保存方法
	$("#edit_more").attr("onclick","addComponent()");// 添加更多
	$("#Btn_back").attr("onclick","uploadBack()");// 上传背景图片
	$("#delete_bg").attr("onclick","deleteBgImg()");// 清除背景
	$("#nologo").attr("onclick","nologo()");
	
	$('#jietuDiv').css('height',getScrollTop());
	$(window).resize(function() {
		$('#jietuDiv').css('height',getScrollTop());
		if(!$(".font_caijan").is(":hidden")) {
			closeJietu();
			showJietu();
		} 
	});
});

/********************
* 取窗口滚动条高度
******************/
function getScrollTop(){
	return Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
}

function nologo(){
	var addLogoFontHtml = "<div style='background:#FFFFFF;width:490px;margin-left:25px;border-radius:6px;'>"+
	"<p style='height:10px;'></p>"+
  "<p style='margin-left:15px;line-height: 40px;'>如果您还没有设计网站的logo，我们建议您先用文字描述来代替logo，等到以后有了正式的logo时，再来换掉。</p>"+
  "<p style='margin-left:15px;margin-right:15px;'>"+
    "<input id='logoFont' style='font-family:SimSun; color:#FF0000; width:200px;' value=''/>"+
  "</p>"+
  "<div style='margin-left:15px;float:left;'>"+
    "<input name='button' type='button' style='height:27px; width:60px; background:#666666; border:0px; color:#FFFFFF; font-size:12px; cursor:pointer;' onclick='boldFont()' value='加粗' />"+
  "</div>"+
  "<div style='margin-left:20px;float:left;width:25px; height:25px; background:#FF0000; border:1px solid #000000; cursor:pointer;' onclick='coloropen(event)' id='inputcolor' > </div>"+
  "<div style='float:left;'>"+
    "<select name='select' id='fontselect' style='margin-left:20px;float:left;width:100px; height:26px;' onchange='changeFont(this)'>"+
      "<option selected='selected' value='SimSun'>宋体</option>"+
      "<option value='SimHei'>黑体</option>"+
      "<option value='Microsoft YaHei'>微软雅黑</option>"+
      "<option value='KaiTi'>楷体</option>"+
    "</select>"+
  "</div>"+
  "<p>&nbsp;</p>"+
  "<div style='float:left;'>"+
    "<input type='text' style='display:none;margin-left:2px;float:left;width:100px; height:25px;' name='color' id='color' onclick='coloropen(event)' value='#FF0000'/>"+
  "</div>"+
  "<div id='colorpane' style='position:absolute; margin-top:25px;z-index:999;display:none;'></div>"+
  "</div>"+
  "<p>"+
    "<input type='button' style='height:30px;margin-left:10%; width:80%; background: linear-gradient(rgb(0, 160, 177) 0%, rgb(0, 130, 153) 100%); color: rgb(255, 255, 255); border:0px; font-size:15px; cursor:pointer;' onclick='logoOk()' value='确定' />"+
  "</p>";
	window.parent.fontlogo(addLogoFontHtml,"550","400")
	window.parent.initcolor();
}
/**
 * main页面锚点跳转的方法，
 * 
 * @param divid
 *            需要跳转到的div的id;
 */
function jumpAnchor(info) {
	var infoid = $(info).attr("id");
	// 获取该对象控制的main页面对应对象id
	var divid = infoid.replace("edit_","");
	if(divid.indexOf("bgimg") < 0){
		var scroll_offset = $("#" + divid, parent.frames['frame_main'].document).offset();
		$("body,html", parent.frames['frame_main'].document).animate({
			scrollTop : scroll_offset.top - 400
		}, 1000);
		// 添加border边框
		$("#" + divid, parent.frames['frame_main'].document).css("border", "2px solid red")
		.css("background","#FC9")
		.css("-moz-border-radius","15px")
		.css("-webkit-border-radius","15px")
		.css("border-radius","15px");
	}
}
/**
 * 清除背景图片
 * 
 * @param bgImgId
 * @returns
 */
function deleteBgImg(){
	var bgImgId = $("[id*=_bgimg]").attr("id");
	$("[id^="+bgImgId.replace("edit_","").replace("_bgimg","")+"]",parent.frames['frame_main'].document).parents(".wraper").css("background","");
}
/**
 * 失去焦点时触发的事件
 * 
 * @param info
 *            失去焦点的控件对象
 */
function losesFocus(info) {
	var infoid = $(info).attr("id");
	// 获取该对象控制的main页面对应对象id
	var divid = infoid.replace("edit_","");
	if(divid.indexOf("bgimg") < 0){
		// 清除border边框
		$("#" + divid, parent.frames['frame_main'].document).css("border", "")
		.css("background","")
		.css("-moz-border-radius","")
		.css("-webkit-border-radius","")
		.css("border-radius","");
		if($(info).attr("type") != "file"){
			// 把修改的信息添加到main页面中
			if($("#" + divid, parent.frames['frame_main'].document).attr("href") == undefined){
				// 把修改的信息添加到main页面中
				$("#" + divid, parent.frames['frame_main'].document).html($(info).val().replace(/\n|\r|(\r\n)|(\u0085)|(\u2028)|(\u2029)/g, "<br/>"));
			} else {
				if(checkUrl($(info).val())){
					$("#" + divid, parent.frames['frame_main'].document).attr("href",$(info).val());
				}else{
					alert("请输入合法的客户案例链接地址！");
				}
			}
		}
	}
}

/**
 * 保留两位小数 功能：将浮点数四舍五入，取小数点后2位
 * 
 * @param x
 *            需要保留两位小数的数
 * @returns 保留两位小数后的数
 */
function toDecimal(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return;
	}
	f = Math.round(x * 100) / 100;
	return f;
}

/**
 * 点击取消按钮
 */
function my_cancel(){
	$("input,textarea").each(function(){
		if($(this).parent().attr("name")!="editform"){
			var oldvalue = $(this).attr("oldValue");
			if($(this).attr("id")!=undefined){
				if($(this).attr("type") == "file"){// 如果是图片
					var imgobj = eval('(' + oldimg + ')');
					for(var i = 0 ; i < imgobj.img.length; i++){
						$("#"+imgobj.img[i].imgid,parent.frames['frame_main'].document).attr("data-original",imgobj.img[i].oldvalue);
					}
				}else{
					$(this).val(oldvalue);
					$("#"+$(this).attr("id").replace("edit_",""),parent.frames['frame_main'].document).html(oldvalue);
				}
			}
		}
	});
	location.href = root+"/page_manage/key/toeditLeft?id="+$("#id").val();
}

/**
 * 去除空格的方法
 * 
 * @param str
 * @returns
 */
function trim(str){  
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
 * 离开页面保存方法
 */
function leaveSava(){
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$("[id=edit_bg_div]",parent.frames['frame_main'].document).each(function(){
		$(this).remove();
	});
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	ajaxSubmit(document.getElementById("editform"), function(data){
		top.location.reload();
	});
}

/**
 * 保存的方法
 */
function bc() {
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$("[id=edit_bg_div]",parent.frames['frame_main'].document).each(function(){
		$(this).remove();
	});
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#editform").submit();
}
/**
 * 判断网址是否合法
 * 
 * @param str_url
 *            需要验证的网址
 * @returns 是否合法
 */
function checkUrl(str_url) {
	if(str_url == ""){
		return true;
	}
	var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
			+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
			+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
			+ "|" // 允许IP和DOMAIN（域名）
			+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
			+ "[a-z]{2,6})" // first level domain- .com or .museum
			+ "(:[0-9]{1,4})?" // 端口- :80
			+ "((/?)|" // a slash isn't required if there is no file name
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re = new RegExp(strRegex);
	if (re.test(str_url)) {
		return true;
	} else {
		return false;
	}
}

function checkLink(obj){
	if($(obj).attr("checked")!="checked"){
		$("#edit_link"+divnum).val("");
		$("#edit_link"+divnum).attr("readonly","readonly");
	}else{
		$("#edit_link"+divnum).removeAttr("readonly");
		$("#edit_link"+divnum).val("http://");
	}
}
/**
 * 点击取消按钮
 * @param obj
 */
function linkCal(obj){
	$("#"+obj+divnum, parent.frames['frame_main'].document).parents(".update").children().attr("onclick","");
}

function linkOk(obj){
	var linkUrl = $("#edit_link"+divnum).val();
	if(!checkUrl(linkUrl)){
		alert("请输入合法的超链接!");
	}else{
		$("#"+obj+divnum, parent.frames['frame_main'].document).parents(".update").children().attr("onclick","window.open('"+linkUrl+"')");
		bc();
	}
}
