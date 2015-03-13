<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<script type="text/javascript"
	src="${root }/view/pages/mini/page/preview/js/preview_main.js"></script>
<style type="text/css">
#IpadDiv{
	width:997px;
	height:1276px;
	margin:50px auto;
	background:url(${root }/view/pages/mini/page/images/ipad.png) no-repeat;
}
#IpadDiv .IpadDivContet{
	width:768px;
	height:1025px;
	float:left;
	margin:127px 0 0 115px;
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
<div id="IpadDiv">
<div class="IpadDivContet">
		<iframe src=""
			name="frame_main" id="frame_main"
			style="background: #eeeeee;"
			frameborder="no" border="0" height="100%" width="100%"></iframe>
	</div>
</div>
</body>
</html>