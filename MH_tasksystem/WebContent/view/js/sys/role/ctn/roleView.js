
/**
 * 角色配置管理 详情页面 js
 * @author jmj
 */
$(function(){
	cancel();
});

/*
 *取消操作 
 */
function cancel(){
	$(".cancel").click(function(){
		window.location.href=root+"/role/key/queryAllRolesInfo";
	});
}


