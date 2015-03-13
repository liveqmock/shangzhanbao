<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<script type="text/javascript"
	src="${root }/view/pages/mini/page/preview/js/preview_main.js"></script>
<style type="text/css">
#IphoneDiv{
	width:394px;
	height:769px;
	margin:50px auto;
	background:url(${root }/view/pages/mini/page/images/iphone.png) no-repeat;
}
#IphoneDiv .IpadDivContet{
	width:320px;
	height:480px;
	float:left;
	margin:147px 0 0 40px;
	background:red;
	overflow-x:hidden;
	overflow-y:auto;
	background:#fff;
}
</style>
<script type="text/javascript">
//获取pageid
function getpageid() {
	var url = window.location.search;
	var str = url.substring(1);
	return unescape(str.split("=")[1]);
}
$(function(){
	frame_main.location.href = root+"/page_manage/key/getPageDataById?id="+getpageid();
});
</script>
</head>
<body>
<div id="IphoneDiv">
<div class="IpadDivContet">
		<iframe src=""
			name="frame_main" id="frame_main"
			style="background: #eeeeee;"
			frameborder="no" border="0" height="100%" width="100%"></iframe>
	</div>
</div>
</body>
</html>