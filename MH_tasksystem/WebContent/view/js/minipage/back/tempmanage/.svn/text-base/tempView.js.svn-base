$(function(){
	  
	  // 删除 模板
	  $('#deleteTemp').click(function(){
		var tempId=$("#tempId").val();

			  if(confirm('您确定删除吗')){
					 $.ajax({
			 				type :"post",
			 				url : root+"/temp_manage/key/delete",
			 				data : "tempIds="+tempId,
			 				dataType : "text",
			 				success : function(data){
			 					alert("删除成功");
			 					window.location.href=root+"/temp_manage/key/searchAllToAdmin?templateData.status=1";
			 				 }
			 			});
			  }
	
	  });
	  
	  /**
	   * 显示隐藏的修改div
	   */
	  $('#showUpdateDiv').click(function(){
		  $("#tempDiV").show();
	  });
	  /**
	   * 隐藏的修改div
	   */
	  $('#closedDiV').click(function(){
		  $("#tempDiV").hide();
	  });
	  
	  /**
		 * 保存修改的模板信息
		 */
		$("#sub").click(function () {
			var tempId=$("#tempId").val();
	 		var name=$("#name").val();
	 		var des=$("#memo").val();
	 		var price=$("#price").val();
	 		var patrn=/^([1-9]([0-9,])*(\.[0-9]+)?)$/;
			if(name!= "" && des!="" && price!=""){		
				  if(patrn.test(price)){
					$.ajax( {
						type : "POST",
						url : root + '/temp_manage/key/updateTemp',
						async: false,
						dataType:"text",
						data : "id="+tempId+"&templateData.name="+name+"&templateData.memo="+des+"&templateData.price="+price,					
						success : function(date) {
							
							window.location.href=root+"/temp_manage/key/getTemplateDataView?templateData.id="+tempId;
						},
						error:function(date){
							alert(date);
						}
					});
					return  true;
				  }else{
					  alert("价格只能是数字！")
					  return false;
				  }
			}else{
			alert("修改的内容不能为空！");
		return false;
		}
			
	 		});
		
		
		
		 /* *//**
		   * 电脑预览图
		   *//*
		  $('#cImg').click(function(){
			  $("#cImgDiv").show();
		  });
		  *//**
		   * 平板预览图
		   *//*
		  $('#fImg').click(function(){
			  $("#fImgDiv").show();
		  });
		  *//**
		   * 手机预览图
		   *//*
		  $('#pImg').click(function(){
			  $("#pImgDiv").show();
		  });*/
})
function cimg(){
	 $("#cImgDiv").show();
	
}
function cimgOut(){
	 $("#cImgDiv").hide();
	
}
function fimg(){
	 $("#fImgDiv").show();
	
}
function fimgOut(){
	 $("#fImgDiv").hide();
	
}function pimg(){
	 $("#pImgDiv").show();
	
}
function pimgOut(){
	 $("#pImgDiv").hide();
	
}
/**
 * 停用  模板
 * @param num
 */
function closedTemp(){
	
	var tempId=$("#tempId").val();
	 if(confirm('你确认要停用吗？')){
	$.ajax( {
		type : "POST",
		url : root + '/temp_manage/key/updateTempState',
		data : "templateData.id="+tempId+"&templateData.status=CLOSED",
		success : function(id) {
			alert("停用成功")
			window.location.href=root+"/temp_manage/key/getTemplateDataView?templateData.id="+tempId;
			 
		}
	});
	 }
}
/**
 * 启用模板
 * @param num
 */
function openTemp(){
	
	var tempId=$("#tempId").val();
	 if(confirm('你确认要启用吗？')){
	$.ajax( {
		type : "POST",
		url : root + '/temp_manage/key/updateTempState',
		data : "templateData.id="+tempId+"&templateData.status=OPEN",
		success : function(id) {
			alert("启用成功")
			window.location.href=root+"/temp_manage/key/getTemplateDataView?templateData.id="+tempId;
			 
		}
		});
	 }

}