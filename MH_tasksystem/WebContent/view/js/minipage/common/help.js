
	function mesAddHelp(){		
		//判断不能为空
		$(".helploadMsgContent").val();
		var con=$(".helploadMsgContent").val();
		if(con==""){
			$("#helplabMes").html("留言内容不能为空。");
			 $("#helplabMes").show();
			return ;
		}else{
			$("#helplabMes").hide();
		}
		$(".userlogin").val();
		var name=$(".name").val();
		var userlogin=$(".userlogin").val();
		if(userlogin!=""){
			var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
			 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			 if (filter.test(userlogin) || teger.exec(userlogin)){
				 $("#helplabMes").html("");
				 $("#helplabMes").hide();
			 }else{
				 $("#helplabMes").html("输入的邮箱或手机号码格式不正确。");
				 $("#helplabMes").show();
				 return false;
			 }
			}
		
		
		$.ajax({
			type:"POST",
			url:root+"/message/key/addMessageData",
			data:"messageData.contenu="+con+"&messageData.userName="+userlogin+"&messageData.uName="+name,
			success:function(data){
				if(data!=1){
					return;
				}else{
					$(".msgDivstyle").show();
					
		}
			}
		})
	}
	
	
	function shuaxin(){
		$(".msgDivstyle").hide();
		window.location.reload();
	}
	
	function emilandphoneCheck(){	
		$(".userlogin").val();
		var userlogin=$(".userlogin").val();
		if(userlogin!=""){
		var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
		 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		 if (filter.test(userlogin) || teger.exec(userlogin)){
			 $("#helplabMes").html("");
			 $("#helplabMes").hide();
		 }else{
			 $("#helplabMes").html("输入的邮箱或手机号码格式不正确。");
			 $("#helplabMes").show();
			 return false;
		 }
		}
	
	}
	