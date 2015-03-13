$(function(){
	/**
	 * 点击让客户自己设置密码
	 */
	$("#setPassword").click(function(){
		var setPwd = $("#setPwd").val();
		
		if(setPwd == "true"){
			$("#setPwd").val("false");
		}else{
			$("#setPwd").val("true");
		}
	});
	
	/**
	 * 后台添加客户
	 */
	$(".addClient").live("click",function(){
		if(!checkSub($("#addClient"))){
			return;
		}
		// 定义url地址
		var url = root + "/client_manage/key/ajaxAddClient";
		$.ajax({
			type : 'POST',
			url : url,
			data:$(this).closest('#addClient').serialize(),
			dataType : "text",
			success : function(data) {
				if(data == "success"){
					alert("添加成功");
					window.location.href = root + "/client_manage/key/searchAllClient";
				}else if(data == "fail"){
					alert("添加失败");
				}else{
					alert("系统异常。请联系维护人员");
				}
			}
		});
	});
})
