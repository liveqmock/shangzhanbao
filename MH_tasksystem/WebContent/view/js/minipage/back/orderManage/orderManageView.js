$(function(){
	//导出认证信息
	$("#daochu").live('click',function(){
		var orderProductId=$("#orderId").val();
	    var a = document.getElementById("daochu");  
	  	a.href=root+"/order_manage_excel/key/getOrderDetail?orderData.id="+orderProductId;
	  	
	  });
})