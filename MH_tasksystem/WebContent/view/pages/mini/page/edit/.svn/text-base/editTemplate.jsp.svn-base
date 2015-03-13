<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>完善内容 - 商站宝</title>
<script type="text/javascript" src="${root }/view/pages/mini/page/edit/js/main_edit.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/ifrma.css">
<script type="text/javascript">
var isleavaeSava = true;
window.onbeforeunload = function(){
	if(isleavaeSava){
		frame_left.leaveSava();
		return;
	}
}
</script>
</head>
<body style="overflow-x:hidden;overflow-y:hidden;">
	<div id="top" style="position:absolute;top:0px;left:0px;height: 50px;">	
		<a href="###" style="display: none;" id="fabu">发布</a>
		<a href="###" style="display: none;" id="zancun">暂存</a>
		<a href="###" style="display: none;" id="turnFirstHtml">返回首页</a>	
		<a href="###" style="display: none;" id="fontlogo">文字logo</a>	
		<a href="###" style="display: none;" id="service">服务</a>	
		<a href="###" style="display: none;" id="goodserrorDiv">商品</a>
		<a href="###" id="showIsPayDiv" style="display: none;"></a>
		<a href="###" id="waitDiv" style="display: none;">等待</a>
		<a href="###" id="selectBtn" style="display:none;">提示</a>
		<a href="###" id="selectDiv" style="display: none;">留言详情</a>
		<a href="###" id="jtselectDiv" style="display: none;">截图信息</a>
		<input type="hidden" id="thistype" value="${thistype}" />
		<iframe
			src="${root }/page_manage/key/toeditTop?id=${pageid}&pageName=${pageName}&pageLink=${pageLink}&pageData.status=${status }&thistype=${thistype}"
			name="frame_top" id="frame_top" frameborder="no" border="0" scrolling="no" height="100%"
			width="100%"></iframe>
	</div>
	<div id="main" style="position:absolute;top:50px;left:0px;">
		<div id="left" style="float: left; width: 300px; height: 100%">
			<iframe src="${root }/page_manage/key/toeditLeft?id=${pageid}"
				name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="aotu" height="100%"
				width="100%"></iframe>
		</div>
		<div id="right" style="margin-left: 300px; height: 100%;">
			<iframe src="${root}/page_manage/key/getPageDataById?id=${pageid}" name="frame_main" id="frame_main" frameborder="no" border="0" scrolling="auto" height="100%"
				width="100%"></iframe>
		</div>
	</div>
</body>
<input type="hidden" value="${userData.id }">
</html>
