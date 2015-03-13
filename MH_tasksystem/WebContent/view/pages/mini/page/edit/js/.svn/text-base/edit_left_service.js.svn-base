function test() {
	var addFbHtml = "<div style='margin-top:30px;font-size:17px;margin-left:35px;'>请先删除该服务的相关订单!"
			+ "</div>"
	window.parent.test(addFbHtml, '400', '200');
}
/**
 * 查看客户留言详情
 */
function selectInfo() {
	window.parent.selectBox();
}
/**
 * 保存的方法
 */
function bc() {
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	$("#previewPro",parent.frames['frame_main'].document).remove();// 移除在线客服预览效果
	$("[id=edit_bg_div]",parent.frames['frame_main'].document).each(function(){
		$(this).remove();
	});
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#editform").submit();
}