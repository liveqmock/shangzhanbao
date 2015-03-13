
/**
 * 角色配置管理 修改页面 js
 * @author jmj
 */
$(function(){
	updateRole();
	cancel();
	
	//初始化选择父级复选框
	$("input[name=parentcbx]").each(function(){
		var cbox = $(this).closest("div").next().find("input[name=soncbx]");
		var cboxs = $(this).closest("div").next().find("input[name=soncbx]:checked");
		if(cbox.length==cboxs.length&&cbox.length!=0){
			$(this).attr("checked","true");
		}
	});
	
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
 * 修改权限(角色)信息 
 */
function updateRole(){
	$(".updateRole").click(function(){
		//权限修改是否选择
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
		//权限修改div隐藏
		if($(".operateAuthority").is(":hidden")){
			if($("input[name=soncbx]:checked").length<=0){
				if(confirm("确定操作权限为空吗?")){
				}else{
					return;
				}
			}
		}
		if($(".searchAuthority").is(":hidden")){
			if($("input[name=searchcbx]:checked").length<=0){
				if(confirm("确定查询权限为空吗?")){
				}else{
					return;
				}
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
		
		if(!checkEditRole()){
			$.ajax({
				type : "POST",
				url : root + '/role/key/updateRole',
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
 * 修改角色--验证角色是否已存在
 */
function checkEditRole(){
	var json = '{"rolename":"'+ $('#rolename').val()+'","id":"'+$('#roleid').val()+'"}';
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

