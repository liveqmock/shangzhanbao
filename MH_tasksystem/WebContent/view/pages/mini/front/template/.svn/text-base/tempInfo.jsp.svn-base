<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看模板 - 商站宝</title>
<script type="text/javascript">
	$(function() {
		var winWidth = getWidth();//获取窗口宽度
		var winHeight = getHeight();//获取窗口高度
		//给各div辅长宽
		$("#top").css("width", winWidth);
		$("#main").css("width", winWidth);
		$("#main").css("height", winHeight-50);
		
		$(window).resize(function() {
			var winWidth = getWidth();//获取窗口宽度
			var winHeight = getHeight();//获取窗口高度
			//给各div辅长宽
			$("#top").css("width", winWidth);
			$("#main").css("width", winWidth);
			$("#main").css("height", winHeight-50);
		});
		
	});
	/**
	 * 获取窗口高度
	 */
	function getHeight() {
		var winHeight = 0;
		//获取窗口高度 
		if (window.innerHeight) {
			winHeight = window.innerHeight;
		} else if ((document.body) && (document.body.clientHeight)) {
			winHeight = document.body.clientHeight;
		}
		//通过深入Document内部对body进行检测，获取窗口大小 
		if (document.documentElement && document.documentElement.clientHeight) {
			winHeight = document.documentElement.clientHeight;
		}
		return winHeight;
	}
	/**
	 * 获取窗口宽度
	 */
	function getWidth() {
		var winWidth = 0;
		//获取窗口宽度 
		if (window.innerWidth) {
			winWidth = window.innerWidth;
		} else if ((document.body) && (document.body.clientWidth)) {
			winWidth = document.body.clientWidth;
		}
		//通过深入Document内部对body进行检测，获取窗口大小 
		if (document.documentElement && document.documentElement.clientWidth) {
			winWidth = document.documentElement.clientWidth;
		}
		return winWidth;
	}
	
	function turnCreateHtmlPage(){
		
		var s = "${root }/page_manage/key/toCreatePage?id="+document.getElementById('tempId').value;
		alert(s);
		window.location.href="${root }/page_manage/key/toCreatePage?id="+document.getElementById('tempId').value;
	}
</script>
</head>
<body style="overflow-x:hidden;overflow-y:hidden;">
<form id="turnCreateHtmlPage" action="${root }/page_manage/key/toCreatePage" method="post">
	<div id="top" style="position:absolute;top:0px;left:0px;height: 50px;">
		<iframe
			src="${root }/view/pages/mini/front/template/temptop.jsp"
			name="frame_top" id="frame_top" frameborder="no" border="0" scrolling="no" height="100%"
			width="100%"></iframe>
	</div>
	<div id="main" style="position:absolute;top:50px;left:0px;">
		<div id="right" style="height: 100%;">
			<iframe src="${root}${template }" name="frame_main" id="frame_main"  frameborder="no" border="0" scrolling="auto" height="100%"
				width="100%"></iframe>
		</div>
	</div>
	<input id="path" type="hidden" value="${template }"/>
		<input id="tempId" name="id" type="hidden" value="${tempId}"/>
		<input id="userId" name="userData.id" type="hidden" value="${userData.id}">
</form>	
</body>
</html>
