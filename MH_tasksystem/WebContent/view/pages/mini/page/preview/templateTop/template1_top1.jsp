<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/ifrma.css" />
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<style>
body {
	margin: 0 auto;
	background: #000;
	font-size: 12px;
	color: #fff;
}
</style>
<script type="text/javascript">
	//获取pageid
	function getpageid() {
		var url = window.location.search;
		var str = url.substring(1);
		return unescape(str.split("=")[1]);
	}
	//跳转到电脑预览图
	function topc() {
		$("#pc").removeClass();
		$("#pad").removeClass();
		$("#phone").removeClass();
		$("#pc").addClass("Btn_red");
		$("#pad").addClass("Btn_next");
		$("#phone").addClass("Btn_next");
		parent.frames['frame_main'].document.location = root
				+ "/page_manage/key/getPageDataById?id=" + getpageid();
		
	}
	//跳转到平板预览图
	function topad() {
		$("#pc").removeClass();
		$("#pad").removeClass();
		$("#phone").removeClass();
		$("#pc").addClass("Btn_next");
		$("#pad").addClass("Btn_red");
		$("#phone").addClass("Btn_next");
		parent.frames['frame_main'].document.location = root
				+ "/view/pages/mini/page/preview/right/pad.jsp?id=" + getpageid();
	}
	//跳转到手机预览图
	function tophone() {
		$("#pc").removeClass();
		$("#pad").removeClass();
		$("#phone").removeClass();
		$("#pc").addClass("Btn_next");
		$("#pad").addClass("Btn_next");
		$("#phone").addClass("Btn_red");
		parent.frames['frame_main'].document.location = root
			+ "/view/pages/mini/page/preview/right/phone.jsp?id=" + getpageid();
	}
</script>
</head>

<body>
	<div id="frame_top">
		<h1>商站宝</h1>
		<div class="FormBtn">
			<div style="float: left; margin: 8px 15px 0 0;">
				<a href="###" id="pc" onclick="topc()" class="Btn_red">电脑</a>
			</div>
			<div style="float: left; margin: 8px 15px 0 0;">
				<a href="###" id="pad" onclick="topad()" class="Btn_next">平板</a>
			</div>
			<div style="float: left; margin: 8px 15px 0 0;">
				<a href="###" id="phone" onclick="tophone()" class="Btn_next">手机</a>
			</div>
		</div>
		<h1 style="margin-top: 5px; float: right;">
			<a href="javascript:window.parent.turnFirstHtml()" target="_parent"
				style="color: #fff; text-decoration: none; font-size: 14px;">返回首页
			</a>
		</h1>
	</div>
</body>
</html>
