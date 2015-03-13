$(function(){
	
			$("#edit").click(function(){
				 var comid=$("#comId").val();
					    if($("#compType").val()==0){
					    	$(".error").html("组件类型未选择！")
					    	$(".error").show();
					    	return false;	
					    }
					    if($("#compResue").val()==0){
					    	$(".error1").html("组件是否可重复出现未选择！")
					    	$(".error1").show();
					    	return false;	
					    }
					    if($("#uploadbgimg").val()==2){
					    	$(".error2").html("是否修改背景未选择！")
					    	$(".error2").show();
					    	return false;	
					    }
					    if($("#cssType").val()==0){
					    	$(".error3").html("模板风格未选择！")
					    	$(".error3").show();
					    	return false;	
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
								url : root+"/comp_manage/key/editComponent?componentData.id="+comid,
								data : $("#addComp").serialize(),
								dataType : "text",
								success : function(data){
									if(data=="1"){
										alert("修改成功")
										window.location.href=root+"/comp_manage/key/getComponentByid?componentData.id="+comid;
									}else{
										return;
									}
								 }
							});
				
			});
	
	/**
	 * 删除
	 */
 $(".delete").click(function(){
		 var id=$(this).attr("data");
		 var comid=$("#comId").val();
		 $.ajax({
				type :"post",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				url : root+"/component_class/key/deleteComClass?componentClassData.id="+id,
				dataType : "text",
				success : function(data){
					if(data!="1"){
						return ;
					}else{
						alert("删除成功")
						window.location.href=root+"/comp_manage/key/getComponentByid?componentData.id="+comid;
					}
				 }
			});

 });
		
	})
		
	
