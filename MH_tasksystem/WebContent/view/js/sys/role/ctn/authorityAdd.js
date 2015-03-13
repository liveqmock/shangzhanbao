
/**
 * 角色配置管理 增加页面 js
 * @author jmj
 */
$(function(){
	saveAddRole();
	cancel();
});

/*
 * 保存信息
 */
function saveAddRole() {
	$(".saveAddRole").click(function(){
		if(!checkSub($("#roleForm"))){
			return;
		}
		$.ajax({
			type : "POST",
			url : root + '/role/key/ajaxAddAuthority',
			data : $('#roleForm').serialize(), 
			success : function(roleid){
				alert("添加成功！");
			}
		});
	});
}
/*
 * 新增角色--验证角色是否已存在
 */
function checkAddRole(){
	var json = '{"rolename":"'+ $('#rolename').val() +'"}';
	var url = root + "/role/key/ajaxCheckRoleName";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num > 0){
		flag = true;
	}
	return flag;
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

/*
 *取消操作 
 */
function cancel(){
	$(".cancel").click(function(){
		window.location.href=root+"/role/key/queryAllRolesInfo";
	});
}

