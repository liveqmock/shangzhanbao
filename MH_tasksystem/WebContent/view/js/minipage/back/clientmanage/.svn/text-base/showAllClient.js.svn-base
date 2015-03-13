

$(function(){
	
	//初始化隐藏保存按钮
	$(".adddiv").hide();
	
	/**
	 * 后台删除客户
	 */
	$(".delClient").live("click",function(){
		var url = root + "/client_manage/key/ajaxDelClient";
		var num = 0;
		$("input[name='clientId']:checked").each(function() {
			if($(this).attr("checked")){
				num += 1;
			}
		});
		if(num == 0){
			alert("请选择需要删除的客户");
		}else{
			if(confirm('确定撤除该客户信息?')){
				$.ajax({
					url:url,
					type:'POST',
					data:$(".clientForm").serialize(),
					dataType:'text',
					success:function(data){
						if(data == "success"){
							alert("删除成功");
							window.location.href = root + "/client_manage/key/searchAllClient";
						}else if(data == "fail"){
							alert("删除失败");
						}else{
							alert("系统异常。请联系维护人员");
						}
					}
				});
			}
		}
	});
	
	/**
	 * 修改客户信息
	 */
	$(".editClient").live("click",function(){
		var loginMail = $(this).closest("tr").children().eq(1).html();
		$(this).closest('tr').children().eq(1).html("<input class='loginMail' type = 'text' value='"+ loginMail + "' name='userData.loginMail'/>");
		//初始化隐藏保存按钮
		$(this).closest('tr').children().eq(6).find(".adddiv").show();
		$(this).closest('tr').children().eq(6).find(".editdiv").hide();
		
	});
	/**
	 * 重置密码
	 */
	$(".sendEmail").live("click",function(){
		var id = $(this).attr("data");
		new bombBox('sendEmailDiv', 'sendEmailID', {
			title : '提示',
			content : "<div class='editpage_zancun_div'>重置密码后，会发送邮件给客户重新设置密码，客户原密码将不能使用，是否确认重置密码？。</div><div class='editpage_zancun_div_in_div'><button class='editpage_zancun_div_in_div_calBtn'>取消</button><input type='button' class='editpage_zancun_div_in_div_sureBtn' onclick='sendmail(\""+id+"\")' value='确认' /></div>",
			width : '480',
			height : '200',
			top : '',
			left : '',
			fixed : 'fixed',
			close : 'close'
		});
		$("#sendEmailDiv").click();
	});
	
	/**
	 * 保存客户信息
	 */
	$(".updateClient").live("click",function(){
		var loginMail = $(".loginMail").val();
		var id = $(this).attr("data");
		if(loginMail==''){
			alert("登陆账号不能为空！");
			return;
		}
		
			var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
			 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			 if (filter.test(loginMail) || teger.exec(loginMail)){
			 }else{
				 alert("输入的邮箱或手机号码格式不正确!");
				 return false;
			 }
			 
			 var json = '{"mail":"'+ loginMail +'","id":"'+ id +'"}';
				var url = root + "/user/key/checkAccount";
				var data = "json=" + json;
				var flag = false;
				var num = getAsyncAjax(url, data);
				if(num > 0){
					alert("此账户已存在！")
					return;
				}
			
		// 定义url地址
		var url = root + "/client_manage/key/ajaxEditClient";
		$.ajax({
			type : 'POST',
			obj:$(this).closest("tr"),
			id : id,
			url : url,
			loginmail : loginMail,
			data : {
				loginmail : loginMail,
				id : id
			},
			dataType : "text",
			success : function(data) {
				if (data == "success") {
					alert("修改成功");
					/*this.obj.children().eq(1).find("input[name='loginMail']").hide();
					this.obj.children().eq(1).html(this.loginmail);*/
					window.location.href = root + "/client_manage/key/searchAllClient";
				} else if (data == "fail") {
					alert("修改失败");
				} else {
					alert("系统异常。请联系维护人员");
				}
			}
		});
	});
})
function sendmail(id){
	var url = root + "/client_manage/key/clientManageResertPassword?userData.id="+id;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			if(data=='1'){
				$("#sendEmailID").remove();
				alert("邮件发送成功");
			}else if(data=='0'){
				$("#sendEmailID").remove();
				alert("邮件发送失败");
			}else if(data=='2'){
				$("#sendEmailID").remove();
				alert("此用户未注册邮箱号");
			}
		}
	});
	
}

/*
 * 修改用户--验证账户是否已存在
 */
function checkAccount_update(){
	var json = '{"mail":"'+ $('#mail').val() 
			+'","id":"'+ $("#userid").val() +'","mobile":"'+$("#mobile").val()+'"}';
	var url = root + "/user/key/checkAccount";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num > 0){
		flag = true;
	}
	return flag;
}
/*
 * 获取同步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		dataType : "text",
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}