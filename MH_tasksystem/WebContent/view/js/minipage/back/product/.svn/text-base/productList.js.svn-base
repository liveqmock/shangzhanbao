$(function(){
	  // 删除 服务
	  $('#deleteProduct').click(function(){
		 var num = 0;
		 $("input[name=ids]:checked").each(function(){
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
			 				url : root+"/product/key/deleteProduct",
			 				data : $("#tempFrom").serialize(),
			 				dataType : "text",
			 				success : function(data){
			 					alert("删除成功");
			 					window.location.href=root+"/product/key/getAllProduct?productData.status=1";
			 				 }
			 			});
			  }
		 }
	  });
	  //复选框  全选/全部选
	  $('#ckboxs').click(function(){
		  if($("input[name='ckboxs']").attr("checked")){
			    $("input[name='ids']").attr("checked",true);
		  }else{
			  $("input[name='ids']").attr("checked",false);
		  }
	  });
	  var lis = $('#myTab00 li');
		for(var i=0;i<lis.length;i++){
			$(lis[i]).bind("click",function(){
				window.location.href=root+"/product/key/getAllProduct?productData.status="+this.value;
			})
		}
		//启用服务
		$("#openProduct").click(function(){
			
			var productId=$(this).attr("data");
			if(confirm("你确定要启用此服务？")){
				$.ajax({
					type:'post',
					url:root+'/product/key/openProduct',
					data:'productData.id='+productId,
					success:function(){
						alert("启用成功");
	 					window.location.href=root+"/product/key/getAllProduct?productData.status=1";
					}
				})
			}
		})
});
/*关闭服务*/
 function closedProduct(id){
			  if(confirm('您确定要关闭此服务吗')){
					 $.ajax({
			 				type :"post",
			 				url : root+"/product/key/closedProduct",
			 				data : "productData.id="+id,
			 				dataType : "text",
			 				success : function(data){
			 					alert("关闭成功");
			 					window.location.href=root+"/product/key/getAllProduct?productData.status=1";
			 				 }
			 			});
			  }
		
	  
 }

 
