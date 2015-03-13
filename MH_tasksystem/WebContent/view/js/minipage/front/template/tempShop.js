$(function() {
	
	$(".searchTemp").live("click",function(){
	       var userId = $(this).attr("data2");
	       var tempId = $(this).attr("data");
	       var url = root + "/temp_manage/key/ajaxSearchTempById?id="+tempId+"&userData.id="+userId;
	       window.open(url,"_blank");
	});
	
	$(".userTemp").live("click",function(){
	       var userId = $(this).attr("data2");
	       var tempId = $(this).attr("data");
	       var url = root + "/page_manage/key/toCreatePage?id="+tempId+"&userData.id="+userId;
	       window.open(url,"_parent");
	});
	
	
	$(".temp").each(function(){
		$(this).hover(function(e){
			$(this).closest("div").css("border","3px solid #dfdfdf");
		},function(e){
			$(this).closest("div").css("border","");
		});
	});
	
	$(".tempInfo").hide();
	// tempImg 鼠标进入时显示模板信息
	$(".tempImg").mouseenter(function() {
		$(this).hide();
		$(this).closest("td").find(".tempInfo").show();
	});
	
	// 鼠标离开时隐藏模板信息。显示模板主浏览图
	$(".tempInfo").mouseleave(function() {
		$(this).closest("td").find(".tempImg").show();
		$(this).hide();
	});
	
	
	/**
	 * 点击电脑预览图事件
	 */
	$(".pc").live("click",function(){
		$("#pcImg").show();
		$("#padImg").hide();
		$("#phoneImg").hide();
	});
	
	/**
	 * 点击平板预览图事件
	 */
	$(".pad").live("click",function(){
		$("#pcImg").hide();
		$("#padImg").show();
		$("#phoneImg").hide();
	});
	
	/**
	 * 点击手机预览图事件
	 */
	$(".phone").live("click",function(){
		$("#pcImg").hide();
		$("#padImg").hide();
		$("#phoneImg").show();
	});
	
	
	
	/**
	 * 关闭查看详情
	 */
	$(".close").live("click",function(){
		$("#dlg").hide();
		$("#pcImg").hide();
		$("#padImg").hide();
		$("#phoneImg").hide();
	});
	
	$(".allTemp").live("click",function(){
		alert(111);
	});
	
})

	function hou(id){
	$("#btn_graytmp_"+id).addClass("btn_graytmpjs");
	
	}
	function out(id){
	$("#btn_graytmp_"+id).removeClass("btn_graytmpjs");
	
	}
	function hous(id){
	$("#shi_"+id).removeClass("btn_orange");
	$("#shi_"+id).addClass("btn_orangejs");
	$("#sa_"+id).addClass("btn_graytmpjsa");
	
		
	}
	function outs(id){
		$("#shi_"+id).removeClass("btn_orangejs");
		$("#shi_"+id).addClass("btn_orange");
		
	}