<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/templateShop/css/ifrma.css"/>
<title>Insert title here</title>
<style>
body {
	margin:0 auto;
	background:url(../../../../../../images/mini/templateShop/images/Titlebg.jpg) repeat-x left top;
	font-size:12px;
	color:#fff;
	}

</style>

<style>
body {
	margin:0 auto;
	background:url(../images/Titlebg.jpg) repeat-x left top;
	font-size:12px;
	color:#fff;
	}

</style>
</head>
<script>
function set_left(){
	var frame_menu_set = window.top.document.getElementById("frame_top_set");
		frame_menu_set.rows = "54,0,*";
		
}
</script>
<body>
<div id="frame_Title" style="margin-bottom: 20px;">
  <h1>选择模板：</h1>
  <p>模板决定了着陆页的样式和布局，先选择一个模板，然后开始编辑内容。没关系，如果你不喜欢模板，随时可以更换。
  模板决定了着陆页的样式和布局，先选择一个模板，然后开始编辑内容。没关系，如果你不喜欢模板，随时可以更换。</p>
  <h2 onClick="set_left()">X</h2>
</div >
</body>
</html>