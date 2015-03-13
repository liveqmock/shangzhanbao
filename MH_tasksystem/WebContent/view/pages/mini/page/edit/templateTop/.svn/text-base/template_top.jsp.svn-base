<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<link rel="stylesheet" type="text/css"
	href="${root }/view/pages/mini/page/css/ifrma.css">
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script defer="true" type="text/javascript"
	src="${root}/view/pages/mini/page/edit/js/edit_top.js"></script>
<style>
body {
	margin: 0 auto;
	background: #FAFAFA;
	font-size: 12px;
	color: #fff;
}

.Btn_1 {
	background: url(${root }/view/pages/mini/page/images/frame_btnbg.png)
		no-repeat -68px 0;
	border:none;
	width: 67px;
	height: 30px;
	margin: 10 10px;
	line-height: 30px;
	cursor:pointer;
	text-align: center;
	font-size: 12px;
	display: inline-block;
	color: #fff;
	overflow: hidden;
	text-decoration: none;
	float: right;
	margin-top: 2px;
}
.turnFirstHtml {
	color: #666666;
	font-size: 14px;
	text-decoration: none;
	height: 40px;
	cursor:pointer;
	line-height: 40px;
	font-weight: bold; 
	border: none;
	background: none;
}
</style>
</head>

<body>
	<div id="frame_top" style="margin-top: 10px;">
		<h1><img alt="商站宝" src="${root}/view/images/logo/logo.jpg" style="width: 86px;height: 45px;"></h1>
		<c:if test="${thistype=='init'}">
		<h2>
			<img src="${root }/view/pages/mini/page/images/frame_top_t3.jpg" width="367" height="27">
		</h2>
		</c:if>
		<input type="button" onclick="fb()" id="fb" class="Btn_1" disabled="disabled" value="发布" />
		<c:if test="${status != 1 }">
		<input type="button" onclick="zc()" id="zc" class="Btn_1 zancun" data="zancun" disabled="disabled" value="暂存" />
		</c:if>
		<input type="button" onclick="yl()" id="yl" class="Btn_1" disabled="disabled" value="预览" />
		<h1 style=" float: right;">
			<input type="button" onclick="turnFirstHtml()" class="turnFirstHtml" disabled="disabled" value="返回首页" />
		</h1>
	</div>
	<form action="page_manage/key/zancun" method="post" id="form"
		name="form" style="display: none;">
		<input type="text" id="id" name="pageData.id" value="${id }" /> <input
			type="text" id="templateid" name="templateid" value="${templateid }" />
		<input type="text" id="pageName" name="pageName" value="${pageName }"  />
		<input type="text" id="pageImg" name="pageData.pageImg" value=""/>
		<input type="text" id="pageLink" name="pageLink" value="${pageLink }"  />
		<input type="text" id="pagePath" name="pagePath" value="${pagePath }"  />
		<input type="text" id="status" name="pageData.status" value="${status}" />
		<input type="text" id="pageId" name="pageId" value="${id }"  />
		<textarea id="content" name="content">
		</textarea>
	</form>
</body>
</html>
