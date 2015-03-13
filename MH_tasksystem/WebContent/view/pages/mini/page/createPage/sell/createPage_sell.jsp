<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:if test="${step==1}">
<title>第一步，设计广告语 - 商站宝</title>
</c:if>
<c:if test="${step==2}">
<title>第二步，描述产品优势 - 商站宝</title>
</c:if>
<c:if test="${step==3}">
<title>第三步，营销动作 - 商站宝</title>
</c:if>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css" />
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<style type="text/css">
.rc_box1,.rc_box2,.rc_box3 {
	display: inline-block;
	*display: inline;
	*zoom: 1;
	position: relative;
	border-style: solid;
	border-color: #ddd;
}

.rc_box2,.rc_box3 {
	border-width: 0 1px;
	*left: -2px;
	background-color: #f3f3f3;
}

.rc_box1 {
	border-width: 1px;
	line-height: 1.5;
}

.rc_box2 {
	margin: 0 -2px;
}

.rc_box3 {
	width: 500px;
	margin: 1px -2px;
	padding: 0 6px;
}

.lov1,.lov2 {
	position: absolute;
	top: 20px;
	overflow: hidden;
	width: 0;
	height: 0;
	border-top: 20px dotted transparent;
	border-bottom: 20px dotted transparent;
	border-right: 20px solid transparent;
}

.lov1 {
	left: -23px;
	border-right-color: #ddd;
}

.lov2 {
	left: -22px;
	border-right-color: #f3f3f3;
}
</style>
<script type="text/javascript" src="${root }/view/pages/mini/page/createPage/sell/js/main-sell.js"></script>
<script type="text/javascript" src="${root }/view/pages/mini/page/edit/js/main_edit.js"></script>
</head>
<body style="overflow-x: hidden; overflow-y: hidden;">
	<a href="###" id="selectDiv" style="display: none;">留言详情</a>
	<div id="top"
		style="position: absolute; top: 0px; left: 0px; height: 50px;">
		<iframe
			src="${root }/view/pages/mini/page/createPage/sell/top/createPage_sell_top.jsp"
			name="frame_top" id="frame_top" frameborder="no" border="0"
			scrolling="no" height="100%" width="100%"></iframe>
	</div>
	<div id="main" style="position: absolute; top: 50px; left: 0px;">
		<div id="left" style="float: left; width: 300px; height: 100%">
		<input type="hidden"  class="zhi" value="${step}">
		<c:if test="${step==1 }">
			<iframe src="${root }/page_manage/key/tostepLeft1?templateid=${templateid}" name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="auto" height="100%" width="100%" ></iframe>
	
		</c:if>
		<c:if test="${step==2 }">
			<iframe src="${root }/page_manage/key/tostepLeft2?templateid=${templateid}&pageid=${pageid}" name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="auto" height="100%" width="100%"></iframe>
	
		</c:if>
		<c:if test="${step==3 }">
			<iframe src="${root }/page_manage/key/tostepLeft3?templateid=${templateid}&pageid=${pageid}" name="frame_left" id="frame_left" frameborder="no" border="0" scrolling="auto" height="100%" width="100%"></iframe>
	
		</c:if>
		</div>
		<div id="right" style="margin-left: 300px; height: 100%;">
			<iframe src="${root}${url }" name="frame_main" id="frame_main"
				frameborder="no" border="0" scrolling="auto" height="100%"
				width="100%"></iframe>
		</div>
	</div>
	<div id="selectBox" style="position: absolute; display: none;">
		<div class="rc_box1">
			<div class="rc_box2">
				<div class="rc_box3">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td><span onclick="closeBox()"
								style="width: 22px; height: 22px; float: right; cursor: pointer;"><span
									style="width: 8px;height: 7px;overflow: hidden;float: right;cursor: pointer;background: url(${root }/view/images/bombBox/gnbimgs.gif) no-repeat;display: inline;margin: 5px 0 0 0;"></span></span></span></td>
						</tr>
						<tr>
							<td>
								<div id="selectmsg"></div>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="lov1"></div>
			<div class="lov2"></div>
		</div>
	</div>
	<!-- 此隐藏域 影藏的是帮客户创建page过程中需要影藏的客户id -->
	<input type="hidden" id="userId_1" value="${userData.id }">
</body>
</html>
