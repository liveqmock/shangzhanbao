
/**
 * 角色配置管理 增加页面 js
 * @author jmj
 */
$(function(){
	saveAddRole();
	cancel();
	
	//添加操作权限
	$(".addOperateAuthority").click(function(){
		if($(".operateAuthority").is(":visible")){
			$(".operateAuthority").hide();
		}else{
			$(".operateAuthority").show();
		}
	});
	//添加查询权限
	$(".addSearchAuthority").click(function(){
		if($(".searchAuthority").is(":visible")){
			$(".searchAuthority").hide();
		}else{
			$(".searchAuthority").show();
		}
	});
	//权限操作-复选框
	$("input[name=parentcbx]").click(function(){
		var box = $(this).closest("div").next().find("input[name=soncbx]");
		if($(this).attr("checked")=='checked'){
			box.attr("checked","true");
		}else{
			box.removeAttr("checked");
		}
	});
	
});

/*
 * 保存信息
 */
function saveAddRole() {
	$(".saveAddRole").click(function(){
		//权限添加是否选择
		if($(".operateAuthority").is(":visible")){
			if($("input[name=soncbx]:checked").length<=0){
				alert("请选择操作权限!");
				return;
			}
		}
		if($(".searchAuthority").is(":visible")){
			if($("input[name=searchcbx]:checked").length<=0){
				alert("请选择查询权限!");
				return;
			}
		}
		//设置资源id值
		var i = 0;
		$("input[name=soncbx]:checked,input[name=searchcbx]:checked").each(function(){
			$(this).closest("div").find(".sonResourceId").attr("name","roleResDatasList["+i+"].resId");
			i++;
		});
	
		
		if(!checkSub($("#roleForm"))){
			return;
		}
		if(!checkAddRole()){
			$.ajax({
				type : "POST",
				url : root + '/role/key/saveRole',
				data : $('#roleForm').serialize(), 
				success : function(roleid){
					window.location.href=root+"/role/key/viewRoleInfo?id="+roleid;
				}
			})
		}else{
			alert("该角色已存在!");
		}
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

