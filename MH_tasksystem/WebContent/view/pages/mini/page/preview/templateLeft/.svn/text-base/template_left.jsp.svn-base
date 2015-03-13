<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css">
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/pages/mini/page/preview/js/preview_left.js"></script>
<style>
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
}
</style>
</head>
<body>
	<br/>
	<div align="center">
		<p>
		<input type="button" onclick="toedit('${pageid}')" class="Btn_next" value="修改" />
		</p>
		<c:if test="${status != 1 }"><p><input type="button" onclick="zc()" class="Btn_next" value="暂存" /></p></c:if>
		<p><input type="button" onclick="fb()" class="Btn_next" value="发布" /></p>
	</div>
	<form action="${root }/page_manage/key/addPageDate" id="form" target="_top"  style="display: none;" method="post" name="structureForm">
		<input type="text" id="id" name="pageData.id" value="${pageid }" />
		<input type="text" id="status" name="pageData.status" value="${status}" />
		<input type="text" id="pageName" name="pageName" value="${pageName }"  />
		<input type="text" id="pageLink" name="pageLink" value="${pageLink }"  />
		<input type="text" id="pagePath" name="pagePath" value="${pagePath }"  />
		<input type="text" id="pageId" name="pageId" value="${id }" >
		<textarea id="content" name="content" ></textarea>
	</form>
</body>
</html>
