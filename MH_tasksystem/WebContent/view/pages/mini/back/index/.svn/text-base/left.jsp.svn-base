<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${root }/view/css/frame.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root }/view/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${root }/view/js/minipage/front/order/shopcart.js"></script>
<style>
html {
	overflow-x: hidden;
	overflow-y: hidden;
}


</style>
<script type="text/javascript">
$(function(){
	$("#changeMenu li a").bind("click",function(){
		$("#changeMenu li.curb").removeClass("curb");
		$(this).closest('li').addClass("curb");
	});
});
</script>
</head>

<body style="border-top:1px solid #D5D5D5;background:#e9f2f8;">
<div class="left_nav">
  <ul id="changeMenu">
    <li menuNum="1" class="curb"><a href="${root }/client_manage/key/searchAllClient" target="frame_main">客户管理</a></li>
    <li menuNum="2"><a href="${root }/page_manager/key/getAll?pageHelpData.pageState=6" target="frame_main">Page管理</a></li>
    <li menuNum="3"><a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main">模板管理</a></li>
    <li menuNum="4"><a href="${root }/comp_manage/key/searchComponent" target="frame_main">组件管理</a></li>
    <li menuNum="5"><a href="${root }/user_info/key/statistics" target="frame_main">发布权限管理</a></li>
    <li menuNum="6"><a href="${root }/user/key/getUsersInfo" target="frame_main">管理员管理</a></li>
    <li menuNum="7"><a href="${root }/product/key/getAllProduct?productData.status=1" target="frame_main">服务管理</a></li>
    <li menuNum="8"><a href="${root }/order_manage/key/getAllOrder" target="frame_main">订单管理</a></li>
    <li menuNum="9"><a href="${root }/message/key/getAll?messageData.status=2" target="frame_main">留言管理</a></li>
    <li menuNum="10"><a href="${root }/accesstatistics/key/getAllPageCount" target="frame_main">流量统计</a></li>
    <li menuNum="11"><a href="${root }/help_manager/key/queryHelpArticleTypeNum" target="frame_main">帮助内容管理</a></li>
    <li menuNum="12"><a href="${root }/order_manager/key/tobackOrderManager" target="frame_main">商站订单统计</a></li>
    <li menuNum="13"><a href="${root }/account_manager/key/searchAllAccount" target="frame_main">计费管理</a></li>
  </ul>
</div>
</body>
</html>

