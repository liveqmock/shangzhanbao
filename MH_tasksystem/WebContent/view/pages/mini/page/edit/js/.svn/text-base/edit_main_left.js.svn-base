$(function() {
	subSomething();
	// jquery ui 拖拽效果
	$( "#navigate_div" ).sortable({
		axis: "y",// 只让纵向拖拽
		revert: true,// 产生动画效果
		items:"li.navListh3:not(.noSortable)",//首页不让拖动
		start: function(event, ui){
			var item = ui.item;
			item.css("background-color", "#364859");
			var placeholder = ui.placeholder;
			placeholder.css("height","45px");
		},
		stop: function(event, ui){
			var $node = ui.item,
				$targetNode = $node.prev();
			$node.css("background-color", "");
			var mainDoc = parent.frames['frame_main'].document;
			//移动导航
			var pointId = $node.find(">a[id]").attr("id").substr(5),
				targetPointId = $targetNode.find(">a[id]").attr("id").substr(5);
			var fmLi = $("#" + pointId, mainDoc).parents("li"),
				targetFmLi = $("#" + targetPointId, mainDoc).parents("li");
			targetFmLi.after(fmLi);
			//移动wraper
			var navStr = fmLi.find(">a[onclick]").attr("onclick").replace(/(getMaodian\('|'\))/g, ""),
				targetNavStr = targetFmLi.find(">a[onclick]").attr("onclick").replace(/(getMaodian\('|'\))/g, "");
			var wraper = $(".wraper a[id='"+navStr+"']", mainDoc).parents(".wraper"),
				targetWraper = $(".wraper a[id='"+targetNavStr+"']", mainDoc).parents(".wraper");
			if($(".wraper a[id='"+targetNavStr+"']", mainDoc).parents(".wraper").next(".wraper").length > 0){
				if($(".wraper a[id='"+targetNavStr+"']", mainDoc).parents(".wraper").next(".wraper").find("a[id^='nav']").length>0 ){
					console.log(targetWraper.html());
					console.log(wraper.html());
					targetWraper.after(wraper);
				}else{
					targetWraper = $(".wraper a[id='"+targetNavStr+"']", mainDoc).parents(".wraper").next(".wraper");
					targetWraper.after(wraper);
				}
			}else{
				targetWraper.after(wraper);
			}
			
			
		}
	});
    $( "#navigate_div" ).disableSelection();
	
});

function subSomething() {
	setTimeout(function() {
		if (parent.frames['frame_main'].document.readyState == "complete") { // 当页面加载状态为完全结束时进入
			addNavigate();
			parent.frames['frame_main'].addCoverPlate(4);
		} else {
			subSomething();
		}
	}, 200);
}
/**
 * 添加导航信息
 */
function addNavigate() {
	if ($("ul", parent.frames['frame_main'].document).find("[id*=_navigate]").length == 0) {
		subSomething();
	}
	$("ul", parent.frames['frame_main'].document).find("[id*=_navigate]").each(function() {
		if($(this).is(":hidden") == false){
			var deleteHtml = "&nbsp;<a href=\"###\" onclick=\"deleteNavigate('"
			+ $(this).attr("id")+ "')\"  style=\"color: #fff;font-size: 14px;margin-left:5px\" id=\"Btn_delete\">删除</a>";
			var homeClass = "";
			if($(this).attr("id")=="first_navigate"){
				deleteHtml="";
				homeClass = " noSortable";
			}
			var img=root+"/view/images/editli.jpg";
			var addnav = "<li class=\"navListh3"+homeClass+"\" style=\"border-bottom:1px solid rgb(61,81,100);line-height:40px;width: 300px;height: 40px;overflow: hidden;margin-left:10px;\">" 
			+ "<img src='"+img+"' style=\"display: block;float: left;margin-top: 14px;\">" +
			  "<a style=\"color: #fff;font-size: 14px;display: block;float: left;max-width: 50%;height: 40px;overflow: hidden;\" href=\"###\" id=\"edit_"+ $(this).attr("id")
			+ "\" onclick=\"clickNavigate('"+ $(this).attr("id")+ "')\">"+ $(this).text()
			+ "</a><span style=\"float:right;margin-right:20px;\">"
			+ "&nbsp;&nbsp;<a href=\"###\" onclick=\"editNavigate('"
			+ $(this).attr("id")+ "')\" style=\"color: #fff;font-size: 14px;\" id=\"Btn_edit\">修改</a>"+deleteHtml+"<a style=\"margin-left:10px;color: #fff;font-size: 14px;text-decoration:none;\"><</a></span>"
			+ "</li>";
			$("#navigate_div").append(addnav);
		} else {
			$("#delete_div").show();
			var addnav = "<li style=\"border-bottom:1px solid rgb(61,81,100);background: rgb(51,68,84);line-height:40px;width: 300px;height: 40px;overflow: hidden;margin-left:10px;\">" +
					"<a style=\"color: #fff;font-size: 14px;\" href=\"###\" id=\"edit_"+ $(this).attr("id")
			+ "\" onclick=\"clickNavigate('"+ $(this).attr("id")+ "')\">"+ $(this).text()
			+ "</a><span style=\"float:right;margin-right: 20px;\">"
			+ "&nbsp;&nbsp;<a href=\"###\"style=\"color: #fff;font-size: 14px;\" onclick=\"regainNavigate('"
			+ $(this).attr("id")+ "')\" id=\"Btn_regain\">恢复</a>" +
					"<a style=\"margin-left:10px;color: #fff;font-size: 14px;text-decoration:none;\"><</a></span></li>"
			$("#delete_navigate_div").append(addnav);
		}
	});
}

/**
 * 删除（隐藏）组件域和导航
 * @param obj
 */
function deleteNavigate(obj){
	$("[id="+obj+"]",parent.frames['frame_main'].document).each(function() {
		if($(this).hasClass("navName")){
			$(this).hide();
		}else{
			$(this).parents(".wraper").hide();
		}
	});
	parent.frames['frame_left'].location.reload(true);
}

/**
 * 恢复已删除的导航和组件域
 * @param obj
 */
function regainNavigate(obj){
	$("[id="+obj+"]",parent.frames['frame_main'].document).each(function() {
		$(this).show();
		$(this).parents(".wraper").show();
		$("#"+obj).click();
	});
	parent.frames['frame_left'].location.reload(true);
}

/**
 * 显示或隐藏导航
 */
function showHideNavigate(navigateid){
	if($("[id="+navigateid+"]",parent.frames['frame_main'].document).is(":hidden")){
		$("[id="+navigateid+"]",parent.frames['frame_main'].document).each(function() {$(this).show();});
		$("#showHide_"+navigateid).text("删除");
	} else {
		$("[id="+navigateid+"]",parent.frames['frame_main'].document).each(function() {$(this).hide();});
		$("#showHide_"+navigateid).text("恢复");
	}
	bc();// 保存页面
}
/**
 * 点击导航按钮
 */
function clickNavigate(navigateid) {
	$("#" + navigateid, parent.frames['frame_main'].document).click();
}
/**
 * 修改导航
 */
function editNavigate(navigateid) {
	// 获取导航html
	var oldhtml = getOuterHtml($("#edit_" + navigateid).parent()).replace(
			new RegExp("'", "g"), "@").replace(new RegExp('"', "g"), "γ");
	// 获取导航名
	var oldtext = $("#edit_" + navigateid).text();
	// 把原位置换为文本框的html
	var newhtml = "<div style=\"margin-left: 10px;\"><input type=\"text\" oldhtml=\""+ oldhtml+ "\" oldtext=\""+ oldtext
			+ "\" style=\"width:150px;\" class=\"input_bg\" id=\"edit_"+ navigateid
			+ "\" onfocusin=\"jumpAnchor(this)\" onblur=\"loseNavigate(this)\" value=\""+ oldtext
			+ "\" /><a href=\"#\" style=\"margin-left:5px;\" class=\"blueLine\" onclick=\"navigateOk(\'"+ navigateid
			+ "\')\">确定</a><a href=\"#\" style=\"margin-left:5px;\" class=\"blueLine\" onclick=\"navigateCancel('"
			+ navigateid + "')\">取消</a></div>"
	$("#edit_" + navigateid).parent().after(newhtml);
	$("#edit_" + navigateid).parent().remove();
}
/**
 * 修改导航取消
 * 
 * @param navigateid
 */
function navigateCancel(navigateid) {
	// 清除border边框
	$("#" + navigateid, parent.frames['frame_main'].document).css("border", "").css("height", "").css("background", "").css("-moz-border-radius","").css("-webkit-border-radius", "").css("border-radius","");
	var oldhtml = $("#edit_" + navigateid).attr("oldhtml").replace(new RegExp("γ", "g"), '\"').replace(new RegExp("@", "g"), "'");
	$("#edit_" + navigateid).parent().after(oldhtml);
	$("#edit_" + navigateid).parent().remove();
}

/**
 * 修改导航确定
 * 
 * @param navigateid
 */
function navigateOk(navigateid) {
	losesFocus($("#edit_" + navigateid));
	var newText = $("#edit_" + navigateid).val();
	var oldhtml = $("#edit_" + navigateid).attr("oldhtml").replace(new RegExp("γ", "g"), '\"').replace(new RegExp("@", "g"), "'");
	$("#edit_" + navigateid).parent().after("" + oldhtml);
	$("#edit_" + navigateid).parent().remove();
	$("#edit_" + navigateid).text(newText);
	$("[id=" + navigateid + "]", parent.frames['frame_main'].document).each(function() {
		  if(navigateid!="buy_navigate"){   //当不是购买id的时候执行
		$(this).text(newText);
		  }
	});
	bc();// 保存页面
}
/**
 * 修改导航失去焦点
 * 
 * @param info
 */
function loseNavigate(info) {
	var infoid = $(info).attr("id");
	// 获取该对象控制的main页面对应对象id
	var divid = infoid.replace("edit_", "");
	// 清除border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "").css("height", "").css("background", "").css("-moz-border-radius", "").css("-webkit-border-radius", "").css("border-radius", "");
	if ($(info).val() == "") {
		return;
	}
}
// 获取元素本身html
function getOuterHtml(obj) {
	var box = $('<div></div>');
	for ( var i = 0; i < obj.length; i++) {
		box.append($(obj[i]).clone());
	}
	return box.html();
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
	var divid = infoid.replace("edit_", "");
	clickNavigate('' + divid);
	if ($(divid).attr("type") == "file"&& $("#" + divid, parent.frames['frame_main'].document).text() == "") {
		$("#" + divid, parent.frames['frame_main'].document).css("height","20px");
	}
	// 添加border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border","2px solid red").css("background", "#FC9").css("-moz-border-radius", "15px").css("-webkit-border-radius", "15px").css("border-radius", "15px");
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
	var divid = infoid.replace("edit_", "");
	// 清除border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "").css("height", "").css("background", "").css("-moz-border-radius", "").css("-webkit-border-radius", "").css("border-radius", "");
	if ($(info).val() == "") {
		return;
	}
	if ($(info).attr("type") != "file") {
		// 把修改的信息添加到main页面中
		$("#" + divid, parent.frames['frame_main'].document).html($(info).val());
	}
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
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("[id=edit_bg_div]", parent.frames['frame_main'].document).each(function() {
		$(this).remove();
	});
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#editform").submit();
}
