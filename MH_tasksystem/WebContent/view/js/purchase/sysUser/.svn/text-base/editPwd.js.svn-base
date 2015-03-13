$(function(){
	
	/* 修改密码 */
	$("#eidt").live('click',function(){
        $('#oldPword').attr('name','userData.userName');
		 var url=root + "/user/key/ajaxEditPassWord";
		 var form = $(this).closest('form');
		 /*if(!checkSub(form)){
				return;
		  } */
		 if(!$("#oldPword").val()){
			 $(".error").html("当前密码不能为空！");
			 $(".error").show();
			 return;
		 }
		 if(!$("#onePass").val()){
			 $(".error").html("新密码不能为空！");
			 $(".error").show();
			 return;
		 }
		 if(!$("#newPassword").val()){
			 $(".error").html("请填写确认密码！");
			 $(".error").show();
			 return;
		 }
		 if(!($("#onePass").val()==$("#newPassword").val())){
			 $(".error").html("两次填写的密码不一致！");
			 $(".error").show();
			 return;
		 }
		 $.ajax({
				type : 'POST',
				url : url,
				dataType : "text",
				data:$(this).closest('form').serialize(),
				success : function(data) {
					if(data=="success"){
						$("#showDiv").hide();
						$("#hideDiv").show();
						
						 $(".error").html("");
							$(".error").hide();
						if(confirm('密码修改成功，将退出到首页重新登录？')){
							window.parent.location.href=root+"/j_spring_security_logout";
						}
					}else if(data=="-1"){
						$(".error").html("验证码输入错误！");
						$(".error").show();
						$(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
					}else if(data=="fail"){
						$(".error").html("输入的旧密码不正确");
						$(".error").show();
						$(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
					}else if(data=="unknows"){
						$(".error").html("产生未知错误，修改失败。请重新修改");
						$(".error").show();
					}else{
					$(".error").html("");
					$(".error").hide();
					}
				}
			});
		
	});
	
})
