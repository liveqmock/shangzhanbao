<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>第二步，描述产品优势 - 商站宝</title>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css" />
<script defer="defer" type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/sell.js"></script>
<script defer="defer"  type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/sellStep2.js"></script>

<style>
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
}

.deleteHref{
	font:12px Hevetica Neve,Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;margin-right:5px;float:right;color:#746D6D; text-decoration: none;
}
.deleteHref:hover {
	font:12px Hevetica Neve,Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;margin-right:5px;float:right;color:#746D6D; text-decoration: underline;
}
</style>
<script type="text/javascript">
$(function() {
	window.parent.closeBox();
	$("#showBox").click(function(){
		if($("#selectBox",parent.document).is(":hidden")){
			var msgBox = "<div style='margin:0 auto;width:450px;'>"+
			"<font class='createPage_tipInFo_Font'>产品优势是客户购买这款产品的理由。请记住一个原则：<font style='color: #FF3300;'>从客户的角度出发</font>。另外多个优势之间最好有一定的内在联系。</font><br/>"+
			"<div><br/>";
			window.parent.showBox(this,msgBox);
		}else{
			window.parent.closeBox();
		}
	});
	subSomething();
});

function subSomething() {
	setTimeout(function() {
		if (parent.frames['frame_main'].document.readyState == "complete") { // 当页面加载状态为完全结束时进入
			$("[class=Btn_next]", parent.frames['frame_left'].document).each(function(){
				$(this).removeAttr("disabled");
			});
			$(".Btn_buys", parent.frames['frame_left'].document).removeAttr("disabled");
			parent.frames['frame_main'].addCoverPlate(2);
		} else {
			subSomething();
		}
	}, 200);
}
</script>
</head>
<body>
	<div id="Frma_Left_top">编辑卖点引导<span>2/3</span></div>
	<div class="clear"></div>
	<div id="Frma_Left_Starp1">
		<h1 style=" height: 60px;line-height: 30px;">
		<span style=" display: block; float: left; ">第二步</span>
		<input type="button" onclick="javascript:addComponentRight()" class="Btn_next" disabled="disabled" style="float: left;margin-left: 125px;font-weight: 600;" value="增加优势" />
		</h1>
		<div class="">
			<h1 style="line-height: 20px;height: 130px;margin-top: 60px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			此处请在右侧编辑栏填写最核心的优势。该优势下具体的配图及文字描述请在编辑卖点引导结束后填写。</h1>
			<div class="clear"></div>
			<div class="FormBtn">
				<div style="float: left">
					<input type="button" onclick="javascript:window.history.back(-1)" class="Btn_buys" disabled="disabled" value="返回" />
				</div>
				<div style="float: right">
					<input type="button" onclick="getSubmit()" class="Btn_next" disabled="disabled" value="下一步" />
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="ff8080814618b95b014618bffb67001f" id="componentId"/>
	<div id="form_div" style="display: none;">
		<form action="${root }/page_manage/key/editPageData" method="post"
			id="sellForm" name="sellForm" data="2">
			<input type="text" id="id" name="pageData.id" value="${pageid }" /> <input
				type="text" id="templateid" name="templateid" value="${templateid }" />
			<input type="text" id="status" name="pageData.status" value="3" /> <input
				type="text" id="type" name="pageData.createType" value="0" /> <input
				type="text" id="isdelete" name="pageData.isdelete" value="1" />
			<textarea id="content" name="content">
			</textarea>
		</form>
	</div>
</body>
</html>