$(function(){
	 fl="";
	//复选框点击事件
		$(".checkEditCode").click(function(){
			var code=$(this).attr("data")
			if($(this).attr("checked")){
				$(".inputEditCode_"+code).attr("notnull","不能为空");
				$(".inputEditCode_"+code).attr("name","componentData.editcon");
				$(".inputEditCode_"+code).show();
			}else{
				$(".inputEditCode_"+code).removeAttr("notnull");
				$(".inputEditCode_"+code).hide(); 
				$(".inputEditCode_"+code).removeAttr("name");
			}
		})
	
	$("#add").click(function(){
	    if($("#compType").val()==0){
	    	$(".error").html("组件类型未选择！")
	    	$(".error").show();
	    	return false;	
	    }else{
	    	$(".error").html("")
	    	$(".error").hide();
	    }
	    if($("#compResue").val()==0){
	    	$(".error1").html("组件是否可重复出现未选择！")
	    	$(".error1").show();
	    	return false;	
	    }else{
	    	$(".error1").html("")
	    	$(".error1").hide();
	    }
	    if($("#uploadbgimg").val()==2){
	    	$(".error2").html("是否修改背景未选择！")
	    	$(".error2").show();
	    	return false;	
	    }else{
	    	$(".error2").html("")
	    	$(".error2").hide();
	    }
	    if($("#cssType").val()==0){
	    	$(".error3").html("模板风格未选择！")
	    	$(".error3").show();
	    	return false;	
	    }else{
	    	$(".error3").html("")
	    	$(".error3").hide();
	    }
	    
	    
		var flag=0;
		var img=$("#filePC");
		if (img == null || img.val() == "") {
			flag = 2;
		}			
	    if(flag==2){
	    	alert("预览图不能为空");
	    	return false;	   
		}
		if(!checkSub($("#addComp"))){
			return;
		}
		
		$(".error").hide();
		$(".error1").hide();
		 $.ajax({
				type :"post",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				url : root+"/comp_manage/key/addComp",
				data : $("#addComp").serialize(),
				dataType : "text",
				success : function(data){
					if(data=="1"){
						window.location.href=root+"/comp_manage/key/searchComponent";
					}else{
						return;
					}
				 }
			});
		
	})

		
	 
	   
})

