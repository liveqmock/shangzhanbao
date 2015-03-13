$(function(){
	
	//修改登陆账号
	$("#eidtLoginAccount").live("click",function(){
		// 获取用户输入的密码
		var userPwd = $("#loginPwd").val();
		// 获取用户输入的新账号
		var newLoginAccount = $("#loginAccount").val();
		// 数据校验
		if(userPwd == "" || userPwd == null){
			$(".error").html("请输入用户密码");
			$(".error").show();
			return;
		}else if(newLoginAccount == "" || newLoginAccount == null){
			$(".error").html("请输入新账号");
			$(".error").show();
			return;
		}else{
			// 电话号码正则表达式
			var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
			// 邮箱正则表达式
			var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!filter.test(newLoginAccount)){
				if(!teger.test(newLoginAccount)){
						$(".error").html("账号格式不正确");
						$(".error").show();
						return;
				}
			}
		}
			$.ajax({
				type : "POST",
				url : root + "/user/key/ajaxCheckUser?userData.loginMail="+newLoginAccount,
				success : function(data){
					if(data == "0"){
						$.ajax({
							type : "POST",
							url : root + "/user/key/ajaxEditLoginAccount",
							data : $('#eidtLoginAccountForm').serialize(),
							success : function(data){
								// 修改成功，跳转到账号管理列表
								if(data == "2"){
									alert('密码修改成功，将退出到首页重新登录？')
									window.parent.location.href=root+"/j_spring_security_logout";
									// 密码不匹配，修改失败 
								}else if(data == "1"){
									$(".error").html("密码有误");
									$(".error").show();
									return;
									// 系统未知异常
								}else{
									$(".error").html("产生未知错误，修改失败。请重新修改");
									$(".error").show();
									return;
								}
							}
						});
					}else{
						$(".error").html("您输入的账号名已被占用");
						$(".error").show();
						return;
					}
				}
			});
		});
})