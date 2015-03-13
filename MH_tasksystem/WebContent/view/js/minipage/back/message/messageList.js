$(function(){
	
	//选项卡事件
	  var lis = $('#myTab00 li');
		for(var i=0;i<lis.length;i++){
			$(lis[i]).bind("click",function(){
				window.location.href=root+"/message/key/getAll?messageData.status="+this.value;
			})
		}
		
		//删除事件
		$(".deleteMessage").click(function(){
			messageId=$(this).attr("data");
			 if(confirm('你确认要删除吗？')){
				 $.ajax({
					 type:"POST",
					 url:root+"/message/key/deleteMessageData",
					 data:"messageData.id="+messageId,
					 success:function(data){
						 if(data!=1){
							 return;
						 }
						 alert("删除成功！");
						 window.location.href=root+"/message/key/getAll?messageData.status=2"
					 }
					 
				 })
			 }
			 
			
		});
})