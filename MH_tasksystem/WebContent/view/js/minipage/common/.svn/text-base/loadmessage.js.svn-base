/**
 *  作者：文东
 *  时间：2014/05/13
 *  用于minipage前端客户向minipage留言，提供改进建议
 */
$(function(){
		
	$("#msgImg").show();
	
	$('.navContent li a').mouseover(function(){
		if($(this).closest("li").attr("class")=="select"){
			return;
		}
		$(this).css("color","#0099CC");
	 }).mouseout(function(){
		if($(this).closest("li").attr("class")=="select"){
			return;
	  	}
		$(this).css("color","#000000");
	 });

	 var etipUserEmail = $("#etipUserEmail").val();
	 
	 if(etipUserEmail!=null && etipUserEmail!=""){	
		var userMailBegin = etipUserEmail.replace(/@(\S*)/,"");
		var userMailSize = parseInt(userMailBegin.length);
		var url = root+"/shopping_cart/key/getCount";
		if(etipUserEmail.indexOf("@")>0){
			if(userMailSize>13){
				$("#loginUserName").html("Hi:<font>"+userMailBegin.substring(0,10)+"...</font>");
			}else{
				$("#loginUserName").html("Hi:"+userMailBegin);
			}
		}else{
			if(userMailSize>13){
				$("#loginUserName").html("Hi:<font>"+userMailBegin.substring(0,10)+"...</font>");
			}else{
				$("#loginUserName").html("Hi:"+userMailBegin);
			}
		}
		$.ajax({
		 	type : "POST",
			url : url,
			async : false,
		 	success : function(msg){
				$("#goodsnum").html(msg);
			}
		});
		//设置隐藏菜单的位置
		//1.获取用户信息菜单的位置
		var toleft=$(".navUser").position().left;
		var totop=$(".navUser").position().top;
		$(".navMenu").css("left",toleft+0);
		$(".navMenu").css("top",totop+46);
	 }
		
	 //屏幕改变大小事件
	 $(window).resize(function() {
		if(etipUserEmail!=null && etipUserEmail!=""){
			var toleft=$(".navUser").position().left;
			var totop=$(".navUser").position().top;
			$(".navMenu").css("left",toleft+0);
			$(".navMenu").css("top",totop+46);
		}
	 });
	 
	 /**
	  *  作者：文东
	  *  时间：2014/05/13
	  *  前端留言板入口  初始化留言div
	  */
	 $(".addMsgImg").live("click",function(){
		if($("#msgdiv").is(":hidden")){
			$("#msgdiv").slideToggle(500);//窗帘效果的切换,点一下收,点一下开
			$(".loadMsgContent").val("如，我觉得帮助信息要是能更多一点就好了。");// 初始化记载提示信息
			$(".loadMsgContent").css("color","#CDCDCD");//提示信息字体颜色
		}else{
			if($(".loadMsgCont").find("p").html()=="提交成功"){
				divShow();
			}else{
				$("#msgdiv").slideToggle(500);//窗帘效果的切换,点一下收,点一下开
				$(".loadMsgContent").val("如，我觉得帮助信息要是能更多一点就好了。");// 初始化记载提示信息
				$(".loadMsgContent").css("color","#CDCDCD");//提示信息字体颜色
			}
		}
	 })
		
	 	/**
		 *  作者：文东
		 *  时间：2014/05/13
		 *  关闭留言板div
		 */
		$(".closeLoadMsg").live("click",function(){
			$("#msgdiv").slideToggle(500);//窗帘效果的切换,点一下收,点一下开
			 divShow();
		})
		
		/**
		 *  作者：文东
		 *  时间：2014/05/13
		 *  留言内容获取焦点事件
		 */
		$(".loadMsgContent").focus(function(){
				if($(this).val() == "如，我觉得帮助信息要是能更多一点就好了。"){
					$(this).val("");
					$(this).css("color","");
				}
		})
		
		/**
		 *  作者：文东
		 *  时间：2014/05/13
		 *  留言内容失去焦点事件
		 */
		$(".loadMsgContent").blur(function(){
				if($(this).val() == ""){
					$(".loadMsgContent").val("如，我觉得帮助信息要是能更多一点就好了。");// 初始化记载提示信息
					$(".loadMsgContent").css("color","#CDCDCD");//提示信息字体颜色
				}
		})
		
		//留言添加事件
		$(".mesAdd").click(function(){
			//清空初始化加载提示信息
			if($(".loadMsgContent").val() == "如，我觉得帮助信息要是能更多一点就好了。"){
				$(".loadMsgContent").val("");
				$(".loadMsgContent").css("color","");
			}
			//判断不能为空
			var con=$(".loadMsgContent").val();
			if(con==""){
				$("#labMes").html("留言内容不能为空。");
				return ;
			}
			$.ajax({
				type:"POST",
				url:root+"/message/key/addMessageData",
				data:"messageData.contenu="+con,
				success:function(data){
					$("#box3_id").removeAttr("class");
					$("#box3_id").attr("class","rc_box4");
					$(".ov1").css("top","227");
					$(".ov2").css("top","225");
					$(".ov1").css("left","67%");
					$(".ov2").css("left","67%");
					$(".meslable").html("&nbsp;");
					$(".loadMsgCont").html("<p style='font-size:18px;font-weight: bold;padding-left:10px;'>提交成功</p>" +
							"<p style='font-weight: bold;text-align: center;padding-left:10px;margin-top:30px;'>已收到反馈，感谢你的支持！</p>");
					$(".loadMsgfoot").html("");
				}
			})
		})
})

	function divShow(){
		$("#msgImg").html("");
			var divhtml="<div id=\"msgdiv\" style=\"display:none;position:relative;height400px;right:0px; bottom:50px;\">" +
	        "<div class=\"rc_box1\">" +
	        "<div class=\"rc_box2\">" +
	        "<div class=\"rc_box3\" id='box3_id'><div class=\"loadMsgTop\"><lable class='meslable'>商站宝改进建议</lable><span class=\"closeLoadMsg\">" +
	        "<img src=\""+root+"/view/pages/mini/page/images/Delete-32.png\"/></span></div>" +
	        "<div class=\"loadMsgCont\"><textarea class=\"loadMsgContent\"></textarea><lable id='labMes' style='margin-top:5px;margin-left:7px;color:red;font-size:12px;'></lable></div>" +
	        "<div class=\"loadMsgfoot\"><span></span>" +
	        "<input type=\"button\" class=\"btn20 mesAdd\" value=\"提交\"/></div></div></div>" +
	        "<div class=\"ov1\"></div><div class=\"ov2\"></div></div></div>"+
		      "<div style=\"position: absolute;bottom: 0; right: 20;height:40px;width:40px\"><img style=\"height:40px;width:40px\" class=\"addMsgImg\" src=\""+root+"/view/images/pages/u0.png\"/></div></div>";	
			$("#msgImg").html(divhtml);

			$(document).on('focus','.loadMsgContent', function(){
				if($(this).val() == "如，我觉得帮助信息要是能更多一点就好了。"){
					$(this).val("");
					$(this).css("color","");
				}
			})
			
			$(".mesAdd").on( "click", function() {
				//清空初始化加载提示信息
				if($(".loadMsgContent").val() == "如，我觉得帮助信息要是能更多一点就好了。"){
					$(".loadMsgContent").val("");
					$(".loadMsgContent").css("color","");
				}
				//判断不能为空
				var con=$(".loadMsgContent").val();
				if(con==""){
					$("#labMes").html("留言内容不能为空。");
					return ;
				}
				$.ajax({
					type:"POST",
					url:root+"/message/key/addMessageData",
					data:"messageData.contenu="+con,
					success:function(data){
						$("#box3_id").removeAttr("class");
						$("#box3_id").attr("class","rc_box4");
						$(".ov1").css("top","230");
						$(".ov2").css("top","225");
						$(".ov1").css("left","60%");
						$(".ov2").css("left","60%");
						$(".meslable").html("&nbsp;");
						$(".loadMsgCont").html("<p style='font-size:18px;font-weight: bold;padding-left:10px;'>提交成功</p>" +
								"<p style='font-weight: bold;text-align: center;padding-left:10px;margin-top:30px;'>已收到反馈，感谢你的支持！</p>");
						$(".loadMsgfoot").html("");
					}
				})
			})

		}

 function showMenu(){
 	var etipUserEmail = $("#etipUserEmail").val();
 	if(etipUserEmail!=null && etipUserEmail!=""){
 		$(".navMenu").show();
 	}
 }
 function hidenMenu(){
 	var etipUserEmail = $("#etipUserEmail").val();
 	if(etipUserEmail!=null && etipUserEmail!=""){
 		$(".navMenu").hide();
 	}
 }
 function login(){
	 location.href=root+"/view/pages/mini/front/login.jsp";
 }
 function register(){
	 location.href=root+"/register.jsp";
 }