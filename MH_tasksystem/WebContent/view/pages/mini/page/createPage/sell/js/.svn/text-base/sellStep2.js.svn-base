var reasonNum = 1;
//添加更多理由按钮
var addBtn = "<br/><div class=\"addReason\"><a href=\"javascript:addReason()\" class=\"Btn_more\">增加</a></div>";
//$(function(){
//	subSomething();
//});
////判断主页面是否加载完成
//function subSomething() {
//	setTimeout(function() {
//		if (parent.frames['frame_main'].document.readyState == "complete") { //当页面加载状态为完全结束时进入
//			loadReason();
//		} else {
//			subSomething();
//		}
//	}, 200);
//}
function loadReason(){
	//加载理由编辑信息
	$("[id^=reason_title]",parent.frames['frame_main'].document).each(function(i){
		//在左侧页面追加信息
		var reason_title = "<div><textarea type=\"text\" id=\"step_reason_title"
		+reasonNum+"\" class=\"\" onfocusin=\"jumpAnchor('reason_title"
		+reasonNum+"')\" onblur=\"losesFocus(this)\" oldval=\"优势"+reasonNum+"\" style=\"width: 218px\" >优势"+reasonNum+"</textarea><br/><a href=\"###\" id=\"delete_reason_title"+reasonNum+"\" class=\"deleteHref\" onclick=\"deleteReason(this)\">删除</a> </div>";
		$(".FormTab").append(reason_title);
		//$("#step_reason_title"+reasonNum).val(trim($(this).html().replace(/(<br>)/g, "\r\n")));
		//修改主页面理由id
		$(this).parents(".update").find("[id^=reason_],[name^=reason_]").each(function(){
			var this_id = $(this).attr("id");
			var this_name = $(this).attr("name");
			if(this_id != undefined && this_id != ""){
				this_id = this_id.replace(/[\d]/g,"");
				if(this_id.indexOf("reason_") >= 0){
					$(this).attr("id",this_id +reasonNum);
				}
			}
			if(this_name != undefined && this_name != ""){
				this_name = this_nume.replace(/[\d]/g,"");
				if(this_name.indexOf("reason_")>=0){
					$(this).attr("name",this_name + reasonNum);
				}
			}
		});
		reasonNum = reasonNum + 1;
	});
	//判断还有多少个理由
	var renum = $("[id^=reason_title]",parent.frames['frame_main'].document).length;
	if(renum == 1){
		$("[id^=delete_reason_title]").hide();
	}
	//在主页面添加理由div层
	if($("#slide1",parent.frames['frame_main'].document).find(".update").length>1){
		reasonId1 = $("#slide1",parent.frames['frame_main'].document).find(".update:eq(0)").find(".component").val();
		reasonId2 = $("#slide1",parent.frames['frame_main'].document).find(".update:eq(1)").find(".component").val();
	} else {
		reasonId1 = $("#slide1",parent.frames['frame_main'].document).find(".update:eq(0)").find(".component").val();
		reasonId2 = reasonId1;
	}
	$(".FormTab").append(addBtn);
	//理由组件数量多加了一个 在这儿减去一个 保证之后添加的数量显示正常  by冯鑫
	reasonNum = reasonNum - 1;
}
/**
 * 删除理由
 */
function deleteReason(reasonObj){
	if(confirm("确定删除吗？")){
		$(reasonObj).parent().remove();//删除左侧元素
		$("#"+$(reasonObj).attr("id").replace('delete_',''),parent.frames['frame_main'].document).parents(".update").remove();//删除主页面元素
		//判断还有多少个理由
		var renum = $("[id^=reason_title]",parent.frames['frame_main'].document).length;
		if(renum == 1){
			$("[id^=delete_reason_title]").hide();
		}
	}
	reasonNum =reasonNum-1;
}
var componentRight = "";
var componentLeft = "";
//添加更多理由事件
function addReason(){
	//组件html代码id
	var componentId =$("#componentId").val();
	//理由组件成对出现 
	if(reasonNum%2==0){ 
		//组件数据库id
		var comId = $("[id^="+componentId+"]:eq(0)",parent.frames['frame_main'].document).parents(".update").find("[type='hidden']").attr('value');
	}else{ 
		//组件数据库id
		var comId = $("[id^="+componentId+"]:eq(1)",parent.frames['frame_main'].document).parents(".update").find("[type='hidden']").attr('value');
	} 
	
	//获取组件html代码，代码中只有组件update内部代码
	var url = root + "/back_temp_manage/key/ajaxSearchUseComponentById?componentData.id="+comId;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			addComponentRight(comId,data);
			addComponentLeft(data);
		}
	});
	reasonNum = reasonNum + 1;
	var renum = $("[id^=step_reason_title]").length;
	if(renum > 1){
		$("[id^=delete_reason_title]").each(function(){
			$(this).show();
		});
	}
}

/**
 * 添加主页面信息
 */
function addComponentRight(){
	/**追加到主页面**/
	var componentId;
	var num = $("#reason_img1",parent.frames['frame_main'].document).parent("div").parent(".update").parent("#slide1").find("button").prev().parent().find(".update").length;
	//理由组件成对出现 
	if(num%2==0){ 
		//组件数据库id
		componentId=$("#reason_img1",parent.frames['frame_main'].document).parent("div").next("div").next("input").val();
	}else{ 
		componentId=$("#reason_img2",parent.frames['frame_main'].document).parent("div").next("input").val();
	} 
	//添加按钮
	var data=$("#reason_img1",parent.frames['frame_main'].document).parent("div").parent(".update").parent("#slide1").find("button");
	//调用模板内部js（temp.js或者newTemp.js）中添加组件的方法
	parent.frames['frame_main'].copyComp(componentId,data);
	 //页面滚动修改购买主键位置
    var scroll_offset = $("#reason_div", parent.frames['frame_main'].document).parent("div").parent("div").offset();
    var a=(num)*250;
    var scroll_offset = $("#reason_div", parent.frames['frame_main'].document).parent("div").parent("div").offset();
    var b=a+scroll_offset.top;  //高度
    $("body,html", parent.frames['frame_main'].document).stop();
    $("body,html", parent.frames['frame_main'].document).animate({
      scrollTop : b - 135
    }, 1000);
}

/**
 * 追加左侧编辑页面信息
 */
function addComponentLeft(data){
	//组件数据库格式为：“reason_titlexxxxxxxx”reason_title_num是获取到组件后面数字串。by冯鑫
	var reason_title_num = data.substring(data.indexOf("reason_title")+12,data.indexOf("reason_title")+13+12);
	//在左侧页面添加编辑理由文本框
	var reason_title = "<div><textarea type=\"text\" id=\"step_reason_title"
	+reason_title_num+"\" class=\"\" onfocusin=\"jumpAnchor('reason_title"
	+reason_title_num+"')\" onblur=\"losesFocus(this)\" oldval=\"优势"+reasonNum+"\"  style=\"width: 218px\" >优势"+reasonNum+"</textarea><br/><a href=\"###\" id=\"delete_reason_title"+reason_title_num+"\" class=\"deleteHref\" onclick=\"deleteReason(this)\">删除</a> </div>";
	$(".addReason").before(reason_title);
}
function submitComponent(componentid){
	//修改page组件中间表信息
	$.ajax({
        url: root + "/page_component/key/updateAll",
        type: "post",
        dataType: "text", 
        data: "data.pageid="+$("#id").val()+"&id1="+reasonId1+"&id2="+reasonId2,
        success: function(){
        	//添加page组件中间表信息
        	$.ajax({
                url: root + "/page_component/key/addPageComponent",
                type: "post",
                dataType: "text", 
                data: "data.pageid="+$("#id").val()+"&data.componentid="+componentid+"&id1="+reasonId1+"&id2="+reasonId2,
                success: function(){
                }
            });
        }
	});
}
//获取元素本身html
function getOuterHtml(obj) {
    var box = $('<div></div>');
    for (var i = 0; i < obj.length; i ++) {
        box.append($(obj[i]).clone());
    }
    return box.html();
}
//重新加载main页面
function loadMain(){
	var pageId = $("#id").val();//获取pageId
	$.ajax({
		type: "post", 
		url:root+"/page_manage/key/getPageDataById?id="+pageId,
		async:false,
	 	dataType: "text", 
       	success: function (data) { 
       		if(data!=null && data != ""){
       			parent.frames['frame_main'].location.href=root+data;//重新加载主页面
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { 
            alert(errorThrown); 
        } 
	});
}
//提交信息
function getSubmit(){
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	//获取main页面所有html代码
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	ajaxSubmit(document.getElementById("sellForm"), function(data){
		top.location.href = root + "/page_manage/key/toCreatePage?id="+$("#templateid").val()
		+"&userData.id="+$("#userID").val()+"&step=3&pageid="+data;
	});
}
//去除空格的方法
function trim(str){   
//    str = str.replace(/^(\s|\u00A0)+/,'');   
//    for(var i=str.length-1; i>=0; i--){   
//        if(/\S/.test(str.charAt(i))){   
//            str = str.substring(0, i+1);   
//            break;   
//        }   
//    }   
    return str;   
}