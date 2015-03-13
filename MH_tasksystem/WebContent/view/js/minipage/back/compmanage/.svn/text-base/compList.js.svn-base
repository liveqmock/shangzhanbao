$(function(){
	//删除组件
	
	$(".deleteCom").click(function(){
		var comId=$(this).attr("data");  //组件id
		if(confirm("确认删除组件？删除该组件无法恢复")){
		$.ajax({
				type : "POST",
				url:root+"/comp_manage/key/deleteComponents",
				data:'componentData.id='+comId,
				success : function(data) {
					if(data==1){
						alert("删除成功！")
						window.location.href=root+"/comp_manage/key/searchComponent";
					}else{
						return ;
					}
				}
				
			})
		}
	})
	
	
})