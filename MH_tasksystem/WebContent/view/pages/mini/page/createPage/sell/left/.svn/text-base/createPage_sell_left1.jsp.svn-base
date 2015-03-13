<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>第一步，设计广告语 - 商站宝</title>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css" />
<script defer="defer" type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/sell.js"></script>
<script defer="defer"  type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/sellStep3.js"></script>
<style>
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
}
</style>
<script defer="defer" type="text/javascript">
	$(function() {
		subSomething();
	});
	
	function subSomething() {
		setTimeout(function() {
			if (parent.frames['frame_main'].document.readyState == "complete") { // 当页面加载状态为完全结束时进入
				$("[class=Btn_next]", parent.frames['frame_left'].document).each(function(){
					$(this).removeAttr("disabled");
				});
				$(".Btn_tiao", parent.frames['frame_left'].document).removeAttr("disabled");
				parent.frames['frame_main'].addCoverPlate(1);
			} else {
				subSomething();
			}
		}, 200);
	}
</script>
</head>
<body>
	<div id="Frma_Left_top">编辑卖点引导<span>1/3</span></div>
	<div class="clear"></div>
	<div id="Frma_Left_Starp1">
		<h1>第一步</h1>
		<div class="">
			<h1 style="line-height: 20px;margin-top: 50px;font-family: '微软雅黑 Bold', '微软雅黑';font-weight: 700;font-size: 14px;color: #FFFFFF;height: 200px;"> 
			 &nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 此处请在右侧编辑栏填写最核心的广告语、产品简介及图片。原则是“简单、好记、易口口相传。”
			<br/>
			<br/>
			<br/>
			 &nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  例如：“怕上火，喝王老吉”；“海飞丝去屑实力派”</h1>
			<div class="clear"></div>
			<div class="FormBtn">
				<div >
					<input type="button" onclick="getsubmit()" class="Btn_tiao" disabled="disabled" value="跳过，直接填写细节" />
					<input type="button" onclick="saveInfo('2')" class="Btn_next" disabled="disabled" value="下一步" />
				</div>
			</div>
		</div>
	</div>
	<div id="form_div" style="display: none;">
		<form action="${root }/page_manage/key/addPageData" method="post"
			id="sellForm" name="sellForm" data="1">
			<input type="text" id="id" name="pageData.id" value="${id }" />
			<input type="text" id="pageImg" name="pageData.pageImg" value=""/>
			<input type="text" id="templateid" name="templateid" value="${templateid }" />
			<input type="text" id="status" name="pageData.status" value="3" /> 
			<input type="text" id="type" name="pageData.createType" value="0" />
			<input type="text" id="isdelete" name="pageData.isdelete" value="1" />
			<textarea id="content" name="content"></textarea>
			<input type="text" id="userID" name="userData.id" value="">
		</form>
	</div>
</body>
</html>
