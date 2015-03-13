$(function(){
	
	
		
		//标记事件
		$(".edidMes").click(function(){
			var signeContenu=$(".signeContenu").val();
			var mesId=$(".mesId").val();
			 if(confirm('你确认要标记吗？')){
				 $.ajax({
					 type:"POST",
					 url:root+"/message/key/signeMessage",
					 data:"messageData.signeContenu="+signeContenu+"&messageData.id="+mesId,
					 success:function(data){
						 if(data!=1){
							 return;
						 }
						 alert("标记成功！");
						 window.location.href=root+"/message/key/getAll?messageData.status=2"
					 }
					 
				 })
			 }
			 
			
		});
})