<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<script type="text/javascript" src="${root }/view/pages/mini/page/preview/js/preview_main.js"></script>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css">
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
</head>
<body style="overflow-x:hidden;overflow-y:hidden;">
	<div id="top" style="position:absolute;top:0px;left:0px;height: 50px;">
	<a href="###" style="display: none;" id="fabu">发布</a>
	<a href="###" style="display: none;" id="zancun">暂存</a>
	<a href="###" style="display: none;" id="turnFirstHtml">返回首页</a>	
		<iframe
			src="${root }/view/pages/mini/page/preview/templateTop/template1_top1.jsp?pageid=${pageid}"
			name="frame_top" id="frame_top" frameborder="no" border="0" scrolling="no" height="100%"
			width="100%"></iframe>
	</div>
	<div id="main" style="position:absolute;top:50px;left:0px;">
		<div id="left" style="float: left; width: 100px; height: 100%">
			<iframe src="${root }/page_manage/key/topreviewLeft?id=${pageid}&pageName=${pageName}&pageLink=${pageLink}&pageData.status=${status }"
				name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="no" height="100%"
				width="100%"></iframe>
		</div>
		<div id="right" style="margin-left: 100px; height: 100%;">
			<iframe src="${root}/page_manage/key/getPageDataById?id=${pageid}" name="frame_main" id="frame_main" frameborder="no" border="0" scrolling="auto" height="100%"
				width="100%"></iframe>
		</div>
	</div>
</body>
</html>