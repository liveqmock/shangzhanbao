/**
 * 订单操作 的js
 * @author jmj
 * @date 2013-8-30
 */
$(function(){
	
	var url = root+"/shopping_cart/key/getCount";
 	$.ajax({
 		type : "POST",
		url : url,
		async : false,
 		success : function(msg){
			$("#goodsnum").html(msg);
		}
 	});
	
	$(".orderUserMail").val($("#morenAtten").find("span").eq(2).html());
	$(".orderUserTel").val($("#morenAtten").find("span").eq(1).html());
	$(".orderUserName").val($("#morenAtten").find("span").eq(0).html());
	/**
	 * 作者：文东
	 * 时间：2014/05／14
	 * 添加新的联系人
	 */
	$(".userNewAddress").click(function(){
		var item = $('input[class=userNewAddress][checked]').val();
		$("#moreAttenUl  li").css("backgroundColor","");
		$("#moreAttenUl  li").find("#UpOldAtten").hide();
		$("#moreAttenUl  li").find("#DelOldAtten").hide();
		$('.oldAttenLi').mouseover(function(){
			$(this).css("backgroundColor","orange");
			$(this).find("#UpOldAtten").show();
			$(this).find("#DelOldAtten").show();
		}).mouseout(function(){
			$(this).css("backgroundColor","");
			$(this).find("#UpOldAtten").hide();
			$(this).find("#DelOldAtten").hide();
		});
		$("#addNewAttenDiv").slideDown();
		
	})
	$(".editAtten").click(function(){
		var morenAtten = $("#morenAtten").is(":hidden");//是否隐藏
		var moreAtten = $("#moreAtten").is(":hidden");
		var addNewAttenDiv = $("#addNewAttenDiv").is(":hidden");
		if(morenAtten){
			$("#morenAtten").show();
			$("#moreAtten").hide();
		}else if(moreAtten){
			$("#moreAtten").show();
			$("#morenAtten").hide();
		}
		$(".editAttenSpan").hide();
		$(".saveAttenSpan").show();
		$("#moreAttenUl  li").each(function() {
	        if($(this).find('.userOldAtten').attr("checked")=="checked"){
	        	$(this).css("backgroundColor","orange");
	        	$(this).find("#UpOldAtten").show();
	    		$(this).find("#DelOldAtten").show();
	    		$(this).off("mouseout")
	        }else{
	        	$(this).css("backgroundColor","");
	    		$(this).find("#UpOldAtten").hide();
	    		$(this).find("#DelOldAtten").hide();
	    		$(this).mouseout(function(){
	    			$(this).css("backgroundColor","");
	    			$(this).find("#UpOldAtten").hide();
	    			$(this).find("#DelOldAtten").hide();
	    		});
	        }
	   });
	})
	
	$(".saveAttenSpan").click(function(){
		var radioVal = $("input[name='atten']:checked").val();
		if(radioVal!="0" && radioVal!=null && radioVal!=""){
			$("#morenAtten").find("span").eq(0).html($("input[name='atten']:checked").attr("attname"));
			$("#morenAtten").find("span").eq(1).html($("input[name='atten']:checked").attr("atttel"));
			$("#morenAtten").find("span").eq(2).html($("input[name='atten']:checked").attr("attemail"));
			$(".orderUserMail").val($("input[name='atten']:checked").attr("attemail"));
			$(".orderUserTel").val($("input[name='atten']:checked").attr("atttel"));
			$(".orderUserName").val($("input[name='atten']:checked").attr("attname"));
			$("#morenAtten").show();
			$("#moreAtten").hide();
			$(".editAttenSpan").show();
			$(".saveAttenSpan").hide();
		}else{
			alert("请选择联系人");
		}
	})
	
	$(".saveNewAtten").click(function(){
		var inputs = $(this).closest(".linkManInfoOutDiv").find("input[type=text]");
		for ( var i = 0; i < inputs.length; i++) {
			boundProp($(inputs[i]));
		}
		if($(this).closest(".linkManInfoOutDiv").find(".tooltip").length>0){
			return;
		}
		var userName = escape(escape($("#username").val()));// 用户名
		var userName2 =$("#username").val();// 用户名
		var userTel = $("#userphone").val();// 用户联系电话
		var email = $("#usermail").val();// 用户邮箱
		var id = $("#attenId").val();// 用户联系人id
		var url = root+"/order/key/ajaxAddOrderAtten?attenInfoData.attenName="+userName+"&attenInfoData.attenTel="+userTel+"&attenInfoData.attenEmail="+email+"&attenInfoData.id="+id;
		$.ajax({
			type:"post",
			url:url,
		    username:userName2,
		    userTel:userTel,
		    email:email,
		    id:id,
			success:function(data){
				if(data != "1"){
				$("#attenId").val("");
				$("#username").val("");
				$("#userphone").val("");
				$("#usermail").val("");
				var ulSize = $("#moreAttenUl").find("li").length-1;//获取ul长度
				//定义html
				var liHtml = "<li class=\"oldAttenLi\" style=\"height: 20px;margin-top:10px;width: 650px;line-height:20px;background-color:orange\"><b style=\"margin-left: 10px\">" +
						"<input class=\"userOldAtten\" type=\"radio\" checked=\"checked\" " +
						"name=\"atten\" attId=\""+data+"\" attname=\""+this.username+"\" atttel=\""+this.userTel+"\" attemail=\""+this.email+"\" value=\""+ulSize+1+"\"/><span style=\"margin-left:3px\">"+this.username+"</span></b>" +
						"<span style=\"margin-left:50px\">"+this.userTel+"</span></b><span style=\"margin-left:50px\">"+this.email+"</span>" +
						"<span id=\"UpOldAtten\" style=\"margin-left:30px\">" +
						"<a class=\"editOldAtten\" href=\"###\">编辑</a></span>" +
						"<span id=\"delOldAtten\" style=\"margin-left:2px\"><a class=\"delOldAtten\" href=\"###\">删除</a></span></li>";
					//在ul倒数第二个li之后拼接html
					$("#moreAttenUl").find("li").eq(ulSize).before(liHtml);
					$("#addNewAttenDiv").hide(200);
					$("#morenAtten").find("span").eq(0).html(this.username);
					$("#morenAtten").find("span").eq(1).html(this.userTel);
					$("#morenAtten").find("span").eq(2).html(this.email);
					$(".orderUserMail").val(this.email);
					$(".orderUserTel").val(this.userTel);
					$(".orderUserName").val(this.username);
					$("#morenAtten").show();
					$("#moreAtten").hide();
					$(".editAttenSpan").show();
					$(".saveAttenSpan").hide();
					$(document).on('click', '.userOldAtten', function(){
						$("#addNewAttenDiv").hide(200);
					});
					$(document).on('mouseover','.oldAttenLi', function(){
						$(this).css("backgroundColor","orange");
						$(this).find("#UpOldAtten").show();
						$(this).find("#DelOldAtten").show();
					});
					$(document).on('click','.editOldAtten', function(){
						var attenId = $(this).closest("li").find('.userOldAtten').attr("attid");
						var attenname = $(this).closest("li").find('.userOldAtten').attr("attname");
						var attentel = $(this).closest("li").find('.userOldAtten').attr("atttel");
						var attenemail = $(this).closest("li").find('.userOldAtten').attr("attemail");
						$(this).closest("li").find('.userOldAtten').attr("checked","checked");
						$("#attenId").val(attenId);
						$("#username").val(attenname);
						$("#userphone").val(attentel);
						$("#usermail").val(attenemail);
						$("#addNewAttenDiv").show();
					});
					$(document).on('click','.oldAttenLi', function(){
						$(this).find('.userOldAtten').attr("checked","checked");
						$("#moreAttenUl  li").each(function() {
					        if($(this).find('.userOldAtten').attr("checked")=="checked"){
					        	$(this).css("backgroundColor","orange");
					        	$(this).find("#UpOldAtten").show();
					    		$(this).find("#DelOldAtten").show();
					    		$(this).off("mouseout")
					        }else{
					        	$(this).css("backgroundColor","");
					    		$(this).find("#UpOldAtten").hide();
					    		$(this).find("#DelOldAtten").hide();
					    		$(this).mouseout(function(){
					    			$(this).css("backgroundColor","");
					    			$(this).find("#UpOldAtten").hide();
					    			$(this).find("#DelOldAtten").hide();
					    		});
					        }
					   });
					});
					$(document).on('click','.delOldAtten', function(){
						var attenId = $(this).closest("li").find('.userOldAtten').attr("attid");
						var obj = $(this).closest("li");
						var url = root+"/order/key/ajaxDelAttenInfo?attenInfoData.id="+attenId;
						$.ajax({
							type:"post",
							url:url,
							obj:obj,
							dataType:"text",
							success:function(data){
								$("#attenId").val("");
								$("#username").val("");
								$("#userphone").val("");
								$("#usermail").val("");
								$("#addNewAttenDiv").hide();
								$(this.obj).remove();
							}
						});
					});
				}else{
					$("input[name='atten']:checked").closest("li").find('.userOldAtten').attr("attid",this.id);
					$("input[name='atten']:checked").closest("li").find('.userOldAtten').attr("attname",this.username);
					$("input[name='atten']:checked").closest("li").find('.userOldAtten').attr("atttel",this.userTel);
					$("input[name='atten']:checked").closest("li").find('.userOldAtten').attr("attemail",this.email);
					$("input[name='atten']:checked").closest("li").find("span").eq(0).html(this.username2);
					$("input[name='atten']:checked").closest("li").find("span").eq(1).html(this.userTel);
					$("input[name='atten']:checked").closest("li").find("span").eq(2).html(this.email);
					$("#addNewAttenDiv").hide(200);
					$("#morenAtten").find("span").eq(0).html(this.username);
					$("#morenAtten").find("span").eq(1).html(this.userTel);
					$("#morenAtten").find("span").eq(2).html(this.email);
					$(".orderUserMail").val(this.email);
					$(".orderUserTel").val(this.userTel);
					$(".orderUserName").val(this.username);
					$("#linkManInfoDiv").find("input").val("");
					$("#morenAtten").show();
					$("#moreAtten").hide();
					$(".editAttenSpan").show();
					$(".saveAttenSpan").hide();
				}
			}
		});
	})
	
	
	$(".userOldAtten").click(function(){
		$("#addNewAttenDiv").hide(200);
	})
	

	$('.oldAttenLi').mouseover(function(){
		$(this).css("backgroundColor","orange");
		$(this).find("#UpOldAtten").show();
		$(this).find("#DelOldAtten").show();
	}).mouseout(function(){
		$(this).css("backgroundColor","");
		$(this).find("#UpOldAtten").hide();
		$(this).find("#DelOldAtten").hide();
	});
	
	$('.oldAttenLi').click(function(){
		$(this).find('.userOldAtten').attr("checked","checked");
		$("#moreAttenUl  li").each(function() {
	        if($(this).find('.userOldAtten').attr("checked")=="checked"){
	        	$(this).css("backgroundColor","orange");
	        	$(this).find("#UpOldAtten").show();
	    		$(this).find("#DelOldAtten").show();
	    		$(this).off("mouseout")
	        }else{
	        	$(this).css("backgroundColor","");
	    		$(this).find("#UpOldAtten").hide();
	    		$(this).find("#DelOldAtten").hide();
	    		$(this).mouseout(function(){
	    			$(this).css("backgroundColor","");
	    			$(this).find("#UpOldAtten").hide();
	    			$(this).find("#DelOldAtten").hide();
	    		});
	        }
	   });
	})
		
	
	$(".editOldAtten").click(function(){
		var attenId = $(this).closest("li").find('.userOldAtten').attr("attid");
		var attenname = $(this).closest("li").find('.userOldAtten').attr("attname");
		var attentel = $(this).closest("li").find('.userOldAtten').attr("atttel");
		var attenemail = $(this).closest("li").find('.userOldAtten').attr("attemail");
		$(this).closest("li").find('.userOldAtten').attr("checked","checked");
		$("#attenId").val(attenId);
		$("#username").val(attenname);
		$("#userphone").val(attentel);
		$("#usermail").val(attenemail);
		$("#addNewAttenDiv").show();
	})
	
	$(".delOldAtten").click(function(){
		var attenId = $(this).closest("li").find('.userOldAtten').attr("attid");
		var obj = $(this).closest("li");
		var url = root+"/order/key/ajaxDelAttenInfo?attenInfoData.id="+attenId;
		$.ajax({
			type:"post",
			url:url,
			obj:obj,
			dataType:"text",
			success:function(data){
				$("#attenId").val("");
				$("#username").val("");
				$("#userphone").val("");
				$("#usermail").val("");
				$("#addNewAttenDiv").hide();
				$(this.obj).remove();
			}
		});
	})
	
	
	//保存支付方式
	$("#savePayMethodBtn").click(function(){
		//验证支付方式信息
		var s = $("input[name=orderData.payType]:checked").val();
		$("#payMethodDiv").hide();
		//获取选中的radio按
		if(s == 1){
			$("#savePayMethodDiv1").show();
		}else{
			$("#savePayMethodDiv3").show();
		}
	});
	
	//点击修改(显示选择支付方式div)
	$(".showPayMehtodDiv").click(function(){
		$("#payMethodDiv").show();
		$("#savePayMethodDiv1").hide();
		$("#savePayMethodDiv2").hide();
		$("#savePayMethodDiv3").hide();
	});
	
//	//保存联系人信息
//	$("#saveLinkManInfoBtn").click(function(){
//		//验证联系人信息
//		var inputs = $(this).closest(".linkManInfoOutDiv").find("input[type=text]");
//		for ( var i = 0; i < inputs.length; i++) {
//			boundProp($(inputs[i]));
//		}
//		if($(this).closest(".linkManInfoOutDiv").find(".tooltip").length>0){
//			return;
//		}
//		var url = root+"/order/key/ajaxAddOrderAtten?attenInfoData.attenName="+$("#username").val()+"&attenInfoData.attenTel="+$("#userphone").val()+"&attenInfoData.attenMail="+$("#usermail").val();
//		$.ajax({
//			tyep:"post",
//			url:url,
//			dataType:"text",
//			success:function(data){
//				
//			}
//		});
//		$("#usernamehidden").text($("#username").val());
//		$("#userphonehidden").text($("#userphone").val());
//		$("#usermailhidden").text($("#usermail").val());
//		$("#linkManInfoDiv").hide();
//		$("#saveLinkManInfoDiv").show();
//	});
	
	//点击修改(显示联系人信息div)
	$(".showLinkManInfoDiv").click(function(){
		$("#saveLinkManInfoDiv").hide();
		$("#linkManInfoDiv").show();
	});
	
	//索要发票
	$(".demandInvoice").click(function(){
		$("#invoiceP").hide();
		$("#invoiceDiv").show();
/*		$("#invoicephone").val($("#userphonehidden").text());
		$("#invoicename").val($("#usernamehidden").text());*/
	});
	//不要发票
	$(".noDemandInvoice").click(function(){
		$("#invoiceP").show();
		$("#invoiceDiv").hide();
	});
	
	
	//保存发票信息
	$("#saveInvoiceBtn").click(function(){
		//验证发票信息
		var inputs = $(this).closest(".invoiceDivOutDiv").find("input[type=text]");
		for ( var i = 0; i < inputs.length; i++) {
			boundProp($(inputs[i]));
		}
		if($(this).closest(".invoiceDivOutDiv").find(".tooltip").length>0){
			return;
		}
		//获取下拉框选中的发票内容
		var con=$("#invoiceContent").find("option:selected").text();
		$("#invoicetitlehide").html($("#invoicetitle").val());
		$("#invoicecontenthide").html(con);
		$("#invoiceaddresshide").html($("#invoiceaddress").val());
		$("#invoicenamehide").html($("#invoicename").val());
		$("#invoicephonehide").html($("#invoicephone").val());
		
		$("#invoiceP").hide();
		$("#invoiceDiv").hide();
		$("#fapiaoDiv").hide();
		$("#saveInvoiceDiv").show();
	});
	
	//点击修改(显示发票信息div)
	$(".showInvoiceP").click(function(){
		$("#saveInvoiceDiv").hide();
		$("#invoiceDiv").show();
		$("#fapiaoDiv").show();
	});
	
	//删除订单中信息
	$(".deleteOrder").click(function(){
		$(this).closest('tr').remove();
		ChangeTotalPrice();
			
	});
	
	//返回购物车
	$(".backShoppingCart").click(function(){
		showMyShoppingCart();
	});
})	

	  

		//提交订单
	var sign_sub = 0;
	function subOrder(sign){
		
		
		//判断支付方式是否选则并保存
		if($("#payMethodDiv").is(":visible")){
			alert("请选择支付方式并保存!");
			return;
		}
		
		if($(".orderUserTel").val()=="" || $(".orderUserTel").val==null){
			if($(".linkManInfoOutDiv").is(":visible")){
				alert("请选择联系人信息并保存!");
				return;
			}
		}else{
			$("#username").removeAttr("notnull");
			$("#userphone").removeAttr("notnull");
			$("#usermail").removeAttr("notnull");
			$("#username").removeAttr("max");
			$("#userphone").removeAttr("tel");
			$("#usermail").removeAttr("email");
		}
		
		//判断发票信息是否填写并保存
		if($("#invoiceDiv").is(":visible")){
			alert("请填写发票信息并保存!");
			return;
		}
		//验证发票信息是否填写
		if(!($("#invoiceDiv").is(":visible"))){
			$("#invoicetitle").removeAttr("notnull");
			$("#invoiceaddress").removeAttr("notnull");
			$("#invoicename").removeAttr("notnull");
			$("#invoicephone").removeAttr("notnull");
			$("#invoicephone").removeAttr("num");
			$("#invoicephone").removeAttr("min");
		}
		if(!checkSub($("#orderForm"))){
			return;
		}
		
		if(sign_sub==0){
			$("#submitOrder").replaceWith("正在提交中...");
			if(sign==0){
				$("#orderForm").attr("action", root+"/order/key/saveOrderqx");
			}else{
				$("#orderForm").attr("action", root+"/order/key/saveOrder");
			}
			$("#orderForm").submit();
			sign_sub++;
		}
		
	}
	
	//验证数字
	function checkNum(obj,num){
//		var r = /^[1-9][0-9][0-9]$/;//正整数
		var reg = /^\+?[1-9][0-9]*$/;
		var r = new RegExp(reg); 
		
		var errordiv = $(".numErrorDiv");
		
		if(errordiv.is(":visible")){
			errordiv.hide();
		}
		if(isNaN(num)||num==0||!r.test(num)){
			obj.val("1");
			return true;
		}
		if(num>100){//库存量为100
			errordiv.show();
			return false;
		}else{
			errordiv.hide();
			return true;
		}
	}
	
	
	/*计算总价*/
	function ChangeTotalPrice(){
		 var vTotalMoney=0;//总金额的初始值为0;               
	      var vTable=$("#shoppingInfo");//得到表格的jquery对象    
	      var vTotal= vTable.find(".initTotal");//得到总金额对象
	      var vtxtAfters=vTable.find(".hiddenOneTotal");//得到所有计算好的费用对象;
	      //使用jQuery的each函数遍历每行费用对象,累加成总金额
	      vtxtAfters.each(function(){
	  			var one = $(this).closest("tr").find(".hiddenOneTotal").val();
	  			vTotalMoney += parseFloat(one);
	  		})
	  		$(".hiddenTotal").val(vTotalMoney);
	        var newTalMoney = $(".hiddenTotal").val();
	  		vTotal.html("￥"+newTalMoney+"元"); //将总费用显示到对应文本框对象中   
		
	}
	

	/**
	 * 获取url传递过来的参数
	 * @param name
	 * @returns
	 */
	function getQueryString(name){
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	    var r = window.location.search.substr(1).match(reg);
	    if (r != null)
	        return unescape(r[2]);
	    return null;    
	}

	
	function useroldatten(){  
		$("#addNewAttenDiv").hide(200);
    }
