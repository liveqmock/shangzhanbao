$(function() {

	var B = setInterval(function(){
		 $("#loginMail").val(""); 
	     $("#password").val("");
	},10);
	
	$('#loginMail').focus(function(){//获取用户名焦点
		clearInterval(B);
    });
	
	$('#password').focus(function(){//获取密码焦点
		clearInterval(B);
    });
	

	$(".vari_code_img").attr("src", root + "/verification_code?" + new Date());

	var msg = "<div style=\"margin-top:20px;\">"
			+ "<textarea rows=\"27\" readonly=\"readonly\" style=\"margin-top: 10px; width:640px; resize: none; margin-left: 10px; font-size: 14px;\">"
			+ "在您购买和使用①产品名称（下文简称“本产品”）前，请认真阅读本协议。用户须同意本协议，方可购买和使用本产品。\n"
			+ "\n1服务内容\n"
			+ "1.1本产品提供②服务内容服务，其中的部分服务为收费服务。\n"
			+ "1.2在本产品使用过程中，可能会涉及与本产品整合的第三方产品。当涉及到的第三方产品展示了相应的产品说明时，您须要仔细阅读并认可后，才能使用这些第三方产品。本产品提供方对不受控制的产品不承担责任。\n"
			+ "\n2内容发布\n"
			+ "2.1在使用本产品时，用户可以按其需求和喜好添加和发布内容。但所添加和发布的内容必须符合中华人民共和国法律法规的规定，并不侵害其他人的利益。用户对其在本产品中添加和发布的内容承担责任。\n"
			+ "2.2产品提供方有权判断用户添加和发布的内容是否违反本条款，并对违反的相关部分或全部内容做删除或屏蔽处理。\n"
			+ "\n3素材版权\n"
			+ "本产品为了方便用户使用而提供的图片、文字、模板等，其版权归于本站或本站的设计师、素材提供方。用户仅被授权在本产品中使用这些素材。在获得各自版权所有人的明确许可前，用户不得在本产品以外的地方使用这些素材。\n"
			+ "\n4免责声明\n"
			+ "用户明确同意自行承担其使用本产品所存在的风险。在适用法律允许的最大范围内，对因使用或不能使用本产品所产生的损害及风险，包括但不限于直接或间接的个人损害、商业赢利的丧失、贸易中断、商业信息的丢失或任何其它经济损失，服务提供方不承担任何责任。\n"
			+ "对于因电信系统或互联网网络故障、计算机故障或病毒、信息损坏或丢失、计算机系统问题或其它任何不可抗力原因而产生损失，服务提供方不承担任何责任。\n"
			+ "用户违反本条款并对服务提供方造成损害的，服务提供方有权采取包括但不限于停止提供服务、限制使用、法律追究等措施。\n"
			+ "如因系统维护或升级的需要而必须暂停网络服务，服务提供方将尽可能事先发布通告。\n"
			+ "\n5条款修改\n"
			+ "服务提供方有权随时修改本条款的相关内容。如果用户不同意服务提供方对本条款相关内容所做的修改，有权停止使用本产品。如果用户继续使用本产品，则视为接受本条款相关内容所做的修改。本条款的更新修改及最终解释权归服务提供方所有。\n"
			+ "</textarea></div>"
			+ "<div style=\"margin-right: 10px; margin: 20px 0 0 200px; float: left; width: 350px;\">"
			+ "<div><a href=\"###\" id=\"cancel\" onclick=\"cancel()\" class=\"agreementgray\">不同意</a></div>"
			+ "<div><a href=\"###\" id=\"confirmAgree\" onclick=\"confirmAgree()\" class=\"agreementred\">已阅读并同意该协议</a></div>"
			+ "</div>";
	new bombBox('reService', 'reServicebox', {
		title : '用户协议',
		content : msg,
		width : 680,
		height : 600,
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
})

/**
 * 服务条款不同意按钮事件
 */
function cancel(){
	$(".recbox").attr("checked", false);
	$("#reServicebox").remove();
}

/**
 * 服务条款同意按钮事件
 */
function confirmAgree(){
	$(".recbox").attr("checked", true);
	$("#reServicebox").remove();
}

function reg(obj) {
	disabledButton("registerBtn");
	$(obj).unbind();
	$('#loginMail').attr('name', 'userData.loginMail');
	$('#password').attr('name', 'userData.passWord');
	if (!checkSub($("#myform"))) {
		clearDisableButtion("registerBtn");
		return;
	}
	if (!$(".recbox").attr("checked")) {
		$(".errorDivNmae").html("请同意协议！");
		$(".errorDivNmae").show();
		clearDisableButtion("registerBtn");
		return;
	}
	 if($("#code").val()=="请输入校验码"){
		 $(".error").html("请输入验证码。");
		 $(".error").show();
		 clearDisableButtion("registerBtn");
		 return;
	 }
	if($("#code").val()==""){
		$(".error").html("请输入验证码。");
		$(".error").show();
		clearDisableButtion("registerBtn");
		return;
	}
	
	$.ajax( {
		type : "POST",
		url : root + '/user/key/ajaxCheckUser',
		data : "userData.loginMail="+$("#loginMail").val(),
		success : function(date) {
			if(date==1){		
				$(".error").html("该用户已经存在。");
				$(".error").show();
				clearDisableButtion("registerBtn");
				this.obj.bind();
			}else{
				$.ajax({
					type : 'POST',
					obj : $(obj),
					url : root + "/user/key/register",
					data : $("#myform").serialize(),
					dataType : "text",
					success : function(data) {
						if (data == "0") {
							$(".error").html("");
							$(".error").hide();
							var userName = $(".register_btn").closest("form").find("input[name='userData.loginMail']").val();
							var password = $(".register_btn").closest("form").find("input[name='userData.passWord']").val().replace(/\+/g, '%2B');
							window.location.href=casdomain+"/login?service="+sysLoginDomain+"&j_username="+userName+"&j_password="+password+""; 
						} else if (data == "2") {
							$(".error").html("该用户已经存在。");
							$(".error").show();
							clearDisableButtion("registerBtn");
							this.obj.bind();
						} else if (data == "1") {
							$(".error").html("您填写的验证码错误。");
							$(".error").show();
							clearDisableButtion("registerBtn");
							this.obj.bind();
							$(".vari_code_img").attr("src",root + "/verification_code?" + new Date());
						}
					}
				});
			}
		}
	})


};
/**
 * 快速注册方法
 * 
 * @param obj
 */
function disabledButton(id){
	$("#"+id).attr('disabled',"true");
	$("#"+id).css('background-color','#BBB8B8');
	$("#"+id).attr('value','注册中...');
}
/**
 * 启用登陆按钮
 */
function clearDisableButtion(id){
	$("#"+id).removeAttr("disabled"); 
	$("#"+id).css('background-color','#0099CC');
	$("#"+id).attr('value','注册');
}
function changeCode() {
	$(".vari_code_img").attr("src", root + "/verification_code?" + new Date());
}
function showAgreementJsp(){
	window.open(root+"/userAgreement.jsp");
}
function ajaxCheckUser(){
  
}

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==27){ // 按 Esc 
        //要做的事情
      }
    if(e && e.keyCode==113){ // 按 F2 
         //要做的事情
       }            
     if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	 reg(this);
    }
}