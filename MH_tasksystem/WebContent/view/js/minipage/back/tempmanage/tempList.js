$(function(){
	
	  // 删除 模板
	  $('#deleteTemp').click(function(){
		 var num = 0;
		 $("input[name=tempIds]:checked").each(function(){
				if($(this).attr("checked")){
					num+=1;
				}
			});
		 if(num ==0){
			 alert('请选择数据');
		 }else if(num>=1) {
			  if(confirm('您确定删除吗')){
					 $.ajax({
			 				type :"post",
			 				url : root+"/temp_manage/key/delete",
			 				data : $("#tempFrom").serialize(),
			 				dataType : "text",
			 				success : function(data){
			 					alert("删除成功");
			 					window.location.href=root+"/temp_manage/key/searchAllToAdmin?templateData.status=1";
			 				 }
			 			});
			  }
		 }
	  });
	  
	  var lis = $('#myTab00 li');
	 
		for(var i=0;i<lis.length;i++){
			$(lis[i]).bind("click",function(){
			
				window.location.href=root+"/temp_manage/key/searchAllToAdmin?templateData.status="+this.value;
			})
		}
	  
});

/**
 * 停用  模板
 * @param num
 */
function closedTemp(num){
	
	var tempId=$(".tempId_"+num).val();
	 if(confirm('你确认要停用吗？')){
	$.ajax( {
		type : "POST",
		url : root + '/temp_manage/key/updateTempState',
		data : "templateData.id="+tempId+"&templateData.status=CLOSED",
		success : function(id) {
			alert("停用成功")
			window.location.href=root+"/temp_manage/key/searchAllToAdmin?templateData.status=1";
			 
			}
		});
	 }

}
/**
 * 启用模板
 * @param num
 */
function openTemp(num){
	
	var tempId=$(".tempId_"+num).val();
	 if(confirm('你确认要启用吗？')){
	$.ajax( {
		type : "POST",
		url : root + '/temp_manage/key/updateTempState',
		data : "templateData.id="+tempId+"&templateData.status=OPEN",
		success : function(id) {
			alert("启用成功")
			window.location.href=root+"/temp_manage/key/searchAllToAdmin?templateData.status=1";
			 
		}
	});
	 }
}