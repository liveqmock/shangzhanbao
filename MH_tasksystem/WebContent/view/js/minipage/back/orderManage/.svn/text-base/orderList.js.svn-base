/**
 * 分类标签，根据状态值来查询订单null是全部、1是线下、2是已付款
 * @param state
 * @return
 */
function showOrder(state){
	$("#state").val(state);
	var form = $("#orderForm");
	form.action = root+"/order_manage/key/getAllOrder";
	form.submit();
}

/**
 * 订单操作，改变订单状态，标记已收款
 * @param state
 * @return
 */
function updateOrderState(orderid,state){
	if (confirm("你确定已经收到线下付款了吗?")){
		$.ajax({
			type :"post",
			async:false,
			url : root+"/order_manage/key/ajaxUpdateOrderState?orderData.id="+orderid+"&orderData.state="+state,
			dataType : "text",
			success : function(data){
				showOrder(state);
			}
		});
	}
}

/**
 * 订单操作，改变订单服务中间表状态
 * @param state
 * @return
 */
function updateOpState(orderproductid,state){
	var orderState = $("#state").val();
	if (confirm("你确定服务已经开通了吗?")){
		$.ajax({
			type :"post",
			async:false,
			url : root+"/order_manage/key/ajaxUpdateOpState?orderProductData.id="+orderproductid+"&orderProductData.state="+state,
			dataType : "text",
			success : function(data){
				showOrder(orderState);
			}
		});
	}
}