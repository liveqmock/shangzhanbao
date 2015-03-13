/**
 * 用户配置管理 详情页面 js
 * @author jmj
 */
$(function(){
	cancel();
});

/**
 * 关闭当前页并返回列表页面
 */
function cancel(){
	$(".cancel").click(function(){
		window.location.href=root+"/user/key/getUsersInfo";
	});
}



