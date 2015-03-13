$(function(){
	
	//修改支付宝账号
	$("#editReceivableAccount").live("click",function(){
		// 获取用户输入收款账号
		var receivableAccount = $("#receivableAccount").val();
		// 数据校验
		if(receivableAccount == "" || receivableAccount == null){
			$(".error").html("请输入收款账号");
			$(".error").show();
			return;
		}else{
			// 电话号码正则表达式
			var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
			// 邮箱正则表达式
			var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!filter.test(receivableAccount)){
				if(!teger.test(receivableAccount)){
						$(".error").html("收款账号格式不正确");
						$(".error").show();
						return;
					}
				}
			}
			$.ajax({
				type : "POST",
				url : root + "/user/key/ajaxEditReceivableAccount?userData.receivableAccount="+receivableAccount,
				success : function(data){
					if(data == "1"){
						window.location.href = root + "/user/key/getUserInfos";
					}else{
						$(".error").html("产生未知错误，修改失败。请重新修改");
						$(".error").show();
					}
				}
			});
		});
	
	
	
})