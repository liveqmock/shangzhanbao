/**
 * 用户配置管理 增加页面 js
 * @author jmj
 */
$(function(){
	saveAddUser();
	cancel();
	saveAddUserAgain();
	
	//判断角色选中
	$(".roles").click(function(){
		//先判断选中样式是否已存在
		if($(this).hasClass("crub")){
			$(this).removeClass("crub");//去除样式
			$(this).closest("ul").find(".roleArray").attr("name","");
		}else{
			$(this).addClass("crub");//添加样式
			$(this).closest("ul").find(".roleArray").attr("name","userRoleS");
		}
	});
	
});

/**
 * 保存增加
 */
function saveAddUser(){
	$(".saveAddUser").click(function(){
			if(!checkSub($("#userForm"))){
				return;
			}
		
			/*if(!$(".roles").hasClass("crub")){
				alert("请选择角色!");
				return;
			}*/
			
			if(!checkAccount_add()){
				$.ajax( {
					type : "POST",
					url : root + '/user/key/addUsers?type=add',
					dataType:"text",
					data : $('#userForm').serialize(),
					success : function(num) {
						window.location.href=root+"/user/key/getUsersInfo";
					}
				});
			}else{
				alert("该用户已存在");
			}
	});
}

/*
 * 新增用户--验证账户是否已存在
 */
function checkAccount_add(){
	var json = '{"mail":"'+ $('#mail').val() +'"}';
	var url = root + "/user/key/checkAccount";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num > 0){
		flag = true;
	}
	return flag;
}
/**
 * 关闭当前页并返回列表页面(取消按钮)
 */
function cancel(){
	$(".cancel").click(function(){
		window.location.href=root+"/user/key/getUsersInfo";
	});
}
/*
 * 获取同步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		dataType : "text",
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}

