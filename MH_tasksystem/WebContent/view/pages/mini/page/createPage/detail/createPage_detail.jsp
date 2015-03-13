<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<script type="text/javascript" src="${root }/view/pages/mini/page/createPage/detail/js/main_detail.js"></script>
<script type="text/javascript" src="${root }/view/pages/mini/js/nologo.js"></script>
</head>
<body style="overflow-x:hidden;overflow-y:hidden;">
	<div id="top" style="position:absolute;top:0px;left:0px;height: 50px;">
		<iframe
			src="${root }/view/pages/mini/page/createPage/detail/top/createPage_detail_top.jsp"
			name="frame_top" id="frame_top" frameborder="no" border="0" scrolling="no" height="100%"
			width="100%"></iframe>
	</div>
	<div id="title" style="position:absolute;top:50px;left:0px;height: 40px;">
		<iframe
			src="${root }/view/pages/mini/page/createPage/detail/title/createPage_detail_title.html"
			name="frame_Title" id="frame_Title" frameborder="no" border="0" scrolling="no" height="100%"
			width="100%"></iframe>
	</div>
	<div id="main" style="position:absolute;top:90px;left:0px;">
		<div id="left" style="float: left; width: 300px; height: 100%">
			<iframe
				src="${root }/component/key/getComponent?templateid=${templateid}&id=${pageid}"
				name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="yes" height="100%"
				width="100%"></iframe>
		</div>
		<div id="right" style="margin-left: 300px; height: 100%;">
			<iframe src="${root}${url }" name="frame_main" id="frame_main"  frameborder="no" border="0" scrolling="yes" height="100%"
				width="100%"></iframe>
		</div>
	</div>
</body>
</html>
