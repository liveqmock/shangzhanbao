/**
 * 用户配置管理 修改页面 js
 * @author jmj
 */
$(function(){
	saveEditUser();
	cancel();
	
	//角色选择面板增减样式
	$(".userUl").click(function(){
		var ob = $(this).find("li");
		if(ob.hasClass("crub")){
			ob.removeClass("crub");
		}else{
			ob.addClass("crub");
		}
	});
	
	//响应重置密码
	$("#resetPwd").click(function(){
		$("#pwdDiv").show();
	});
	//响应取消重置密码
	$("#unresetPwd").click(function(){
		$("#pwdDiv").hide();
		$("#newPwd").val("");
	});
});



/*
 * 保存修改信息
 */
function saveEditUser(){
		$(".saveEditUser").click(function(){
			
			if(!checkSub($("#userForm"))){
				return;
			}
			//判断是否选择密码重置
			if($("#pwdDiv").is(":visible")){
				if(!checkSub($("#pwdForm"))){
					return;
				}
			}
			
			/*if(!$(".userUl").find("li").hasClass("crub")){
				alert("请选择角色!");
				return;
			}else{
				//判断角色选中
				var ul = $(".userUl");
				for ( var i = 0; i < ul.length; i++) {
					if($(ul[i]).find("li").hasClass("crub")){
						$(ul[i]).find(".roleArray").attr("name","userRoleS");
					}else{
						$(ul[i]).find(".roleArray").attr("name","");
					}
				}
			}*/
			
			if(!checkAccount_update()){
				$.ajax( {
					type : "POST",
					url : root + '/user/key/editUsers',
					data : $('#userForm').serialize(),
					success : function(id) {
						window.location.href=root+"/user/key/getUserInfos?id="+id;
					}
				});
			}else{
				$.messager.alert("消息提示", "该用户已存在", "warning");
			}
		});
}
/*
 * 修改用户--验证账户是否已存在
 */
function checkAccount_update(){
	var json = '{"mail":"'+ $('#mail').val() 
			+'","id":"'+ $("#userid").val() +'","mobile":"'+$("#mobile").val()+'"}';
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
 * 关闭当前页并返回列表页面
 */
function cancel(){
	$(".cancel").click(function(){
		window.location.href=root+"/user/key/getUsersInfos";
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



