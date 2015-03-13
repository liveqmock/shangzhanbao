<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MiniPage</title>
<link rel="stylesheet" type="text/css" href="${root }/view/pages/mini/page/css/ifrma.css" />
<script type="text/javascript" src="${root }/view/pages/mini/page/createPage/sell/js/sell.js"></script>
<script type="text/javascript">
	function useTemp(){
		parent.document.getElementById('turnCreateHtmlPage').submit();
	}
</script>
<style>
body {
	margin: 0 auto;
	background: #FAFAFA;
	font-size: 12px;
	color: #fff;
}
</style>
</head>

<body>
	<div id="frame_top"  style="height: 50px;margin-bottom: 20px;">
		<h1><img alt="商站宝" src="${root}/view/images/logo/logo.jpg" style="width: 127px;height: 36px;padding-top: 8px;"></h1>
		<h2>
			
		</h2>
		<h1 style="float: right; margin-top: 10px;"><a  href="#"  style="float: right;line-height: 29px;color:#fff;font-size: 12px;background: none repeat scroll 0 0 #FF6600; width: 100px;height: 29px;text-align: center;text-decoration:none;" onclick="useTemp();">使用此模板 </a></h1>
	</div>
</body>
</html>
