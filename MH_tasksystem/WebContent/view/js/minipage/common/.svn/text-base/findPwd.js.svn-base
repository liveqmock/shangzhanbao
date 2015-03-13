
	function pwdCheck(){		
		 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		 if($(".email").val()==""){
				$(".error").html("邮箱不能为空！");
				 $(".error").show();
				return false;
			}
		 if (!filter.test($(".email").val()) ){
			 $(".error").html("输入的邮箱格式不正确。");
			 $(".error").show();
			 return false;
		 }
		$.ajax({
			type:"POST",
			url:root+"/user/key/ajaxCheckUser",
			data:"userData.loginMail="+$(".email").val(),
			success:function(data){
				if(data==0){
					$(".error").html("该邮箱不存在");
					 $(".error").show();
					return;
				}else{
					$(".error").html("");
					 $(".error").hide();
				}
			}
		})
	}
	
		
	function emailBtn(){
		var email=$(".email").val();
		if(email==""){
			$(".error").html("邮箱不能为空！");
			 $(".error").show();
			return false;
		}
			$.ajax({
				type:"POST",
				url:root+"/user/key/checkUserId",
				data:"userData.loginMail="+$(".email").val(),
				success:function(data){
					if(data==1){
						/*$(".error").html("该邮箱不存在");
						 $(".error").show();*/
						return false;
					}else{
						$.ajax({
							type:"POST",
							url:root+"/client_manage/key/clientManageResertPassword?userData.id="+data,
							data:"userData.loginMail="+$(".email").val(),
							success:function(data1){
								if(data1==1){
									window.location.href=root+"/user/key/topFindPwdSu?userData.loginMail="+$(".email").val();
								}else{
									return;
								}
							}
							
						})
						
					}
				}
				
			})
			
		}
		
		
	
