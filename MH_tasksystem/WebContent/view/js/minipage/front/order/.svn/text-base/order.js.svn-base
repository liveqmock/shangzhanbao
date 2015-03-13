$(function(){
	//设置复选框,,全选 与 非选中状态
	$("#deuser").click(function() {
		if($(this).attr("checked")=="checked"){
			$('input[name="orderselect"]').attr("checked","true");
		}else{
			$('input[name="orderselect"]').removeAttr("checked");
		}
	});
	
	//批量删除订单数据
	  $('.deleteOrderByID').click(function(){
		  var num=0;
			 $("input[id=checkBoxOrderId]:checked").each(function(){
					if($(this).attr("checked")){
						num+=1;
					}
				});
			if(num==0){
				 alert('请选择数据');
			}else{
			if(confirm("确认删除?")){
				var url = root+'/order/key/deleteOrderByID';
				$.ajax({
					type:'POST',
					url:url,
					dataType:'text',
					data : $("#orderFrom").serialize(),
					success:function(data){
						alert("删除成功!");
						window.location.href=root+"/order/key/orderList?menuNum=5";
					}
				})
			} 
		}
	  });
	  //复选框  全选/全部选
	  $('#checkBoxAll').click(function(){
		  if($("input[name='ckboxs']").attr("checked")){
			    $("input[id=checkBoxOrderId]").each(function(){
			    	$(this).attr("checked",true);
			    });
		  }else{
			  $("input[id=checkBoxOrderId]").each(function(){
			    	$(this).attr("checked",false);
			    });
		  }
	  });
		
	  //单个选择
	  $("#checkBoxOrderId").click(function(){
		  var len = 0;
		  var checkBoxLen = $(".checkOrderId");
		  $("input[id=checkBoxOrderId]:checked").each(function(){
			  if($(this).attr("checked")){
				  len+=1;
			  }
		  });
		  if(checkBoxLen.length==len){
			  $("input[id=checkBoxAll]").attr("checked",true);
		  }else{
			  $("input[id=checkBoxAll]").attr("checked",false);
		  }
	});
});


/**
 * 确认支付返回成功的时候调用,主要是更新page服务中间表
 * @return
 */
function payforOrder(){
	var checked = $("input[name='orderselect']:checked");//判断复选框是否选中
	if(checked.length==0){
		alert("至少选择一条记录!");
	}else{
		var ids = new Array();
		var pageProductids = new Array();
		$("input[name^='orderselect']:checked").each(function(i,item){
			ids.push( $(item).attr("value"));//订单的id
			pageProductids.push($(item).attr("date"));//page中间表的id
		  });
		ids.join(",");
		pageProductids.join(",");
		var url = root+"/order/key/payForOrder?ids="+ids+"&pageProductIds="+pageProductids;
		$.ajax({
			type : "POST",
			data : $("input[name='orderselect']:checked").closest("form").serialize(),
			url : url,
			async : false,
			success : function(msg){
			window.location.href=root+"/order/key/orderList";
			}
		})
		
		
	}
}
/**
 * 删除订单下的小商品
 * @param id
 * @return
 */
function deleteProduct(id,orderid){
	if(confirm("确认删除?")){
		var url = root+'/order/key/deleteProduct?id='+id+"&orderid="+orderid;
		$.ajax({
			type:'POST',
			url:url,
			dataType:'text',
			success:function(data){
			if(data=='success'){
				alert("删除成功!");
				window.location.href=root+"/order/key/orderList";
			}
			}
		})
	}
}
/**
 * 删除mini_page,MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
 */
function deleteOrderByID(orderId){
	if(confirm("确认删除?")){
		var url = root+'/order/key/deleteOrderByID?orderIds='+orderId;
		$.ajax({
			type:'POST',
			url:url,
			dataType:'text',
			data : $("#orderFrom").serialize(),
			success:function(data){
				alert("删除成功!");
				window.location.href=root+"/order/key/orderList?menuNum=5";
				}
			})
		} 
}
/**
 * 已经完成订单删除方法
 */
function onlyDeleteOrderByID(orderId){
	if(confirm("确认删除?")){
		var url = root+'/order/key/deleteOnlyOrderByID?orderData.id='+orderId;
		$.ajax({
			type:'POST',
			url:url,
			dataType:'text',
			success:function(data){
				alert("删除成功!");
				window.location.href=root+"/order/key/orderList?menuNum=5";
			}
		})
	}
}
/**
 * 批量删除订单
 * @return
 */
function deleteOrder(){
	var checked = $("input[name='orderselect']:checked");//判断复选框是否选中
	var ids = new Array();
	for ( var i = 0; i < checked.length; i++) {
		ids.push(checked[i].value);
	}
	ids=ids.join(",")
	if(checked.length==0){
		alert("至少选择一条记录!");
		return;
	}else if(confirm("确认删除?")){
		var ids = new Array();
		var pageProductids = new Array();
		$("input[name^='orderselect']:checked").each(function(i,item){
			ids.push( $(item).attr("value"));//订单的id
			pageProductids.push($(item).attr("date"));//page中间表的id
		  });
		ids.join(",");
		pageProductids.join(",");
		
		var url = root+'/order/key/deleteOrder?ids='+ids+"&pageProductids="+pageProductids;
		$.ajax({
			type:'POST',
			url:url,
			dataType:'text',
			success:function(data){
			if(data=='success'){
				alert("删除成功!");
				window.location.href=root+"/order/key/orderList";
			}
			}
		})
	}
}


/*
 * 获取异步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}
//弹出填写实名认证信息
function openPageproduct(orderId,ordeProduct,pageId){
	 $("#fileDiv").show();
	 $(".BuorderId").val(orderId);
	 $(".BuorderProductId").val(ordeProduct);
	 $(".BupageId").val(pageId);
	
}
/*关闭填写实名认证信息div*/
function  closedfile(){
	 $("#fileDiv").hide();
}
