<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="${root}/view/pages/mini/page/edit/js/edit_left.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/templateShop/css/frma_left.css">
<style>
html { overflow-x:hidden; }
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
}
.show_div a:hover{width:100%;text-decoration:none;padding:0 0 0 0;}
.show_div a{width:100%;text-decoration:none;padding:0 0 0 0;}
</style>
<script type="text/javascript" src="${root }/view/js/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="${root }/view/pages/mini/page/edit/js/edit_main_left.js" defer="true"></script>
<script defer="defer"  type="text/javascript"
	src="${root}/view/pages/mini/page/createPage/sell/js/sellStep3.js"></script>
</head>
<body>
	<div style="position:absolute;left:0px;top:0px;width:100%;height: 50px;">
		<div style="float: left; background:#1AB1AA; height:50px;line-height:50px; width:50%; text-align: center;">		
		<h2><a href="${root }/page_manage/key/toeditLeft?id=${id}" style="color:#fff" >修改内容</a></h2>
		</div>
		<div  style="float: left; background:#636F80; height:50px;line-height:50px; width:50%; text-align: center;">
		<h2><a href="javascript:parent.frames['frame_top'].edit_service()" style="color:#fff">修改营销动作</a></h2>
		</div>
	</div>	<input type="hidden" id="PageId" name="pageData.id" value="${pageid }" />
			<input type="hidden" id="temp_left" name="pageData.id" value="temp_left" />
	<div style="margin-top: 50px; height:300px;">
		<div class="clear"></div>
		<div class="Frma_Left_Starp1_tab1">
			<ul style="list-style:none;background: rgb(51,68,84);" id="navigate_div">
			</ul>
		</div>
		<div class="Frma_Left_Starp1_tab1">
			<div id="delete_div" style="background: #1AB1AA;height:50px;font-size: 1.5em;font-weight: bold;line-height: 50px;display: none;">
				<img style="width: 35px;height: 40px;float: left;display: block;margin-left: 80px;margin-top:3px" alt="" src="${root}/view/images/edit/Trashcan.jpg">
				<div style="margin-left: 50px;">已删除组件</div>
				<ul style="list-style: square inside url('${root}/view/images/editli.jpg');background: rgb(51,68,84);" id="delete_navigate_div">
				</ul>
			</div>
		</div>
	</div>
	<form action="${root }/page_manage/key/baocun" method="post" id="editform"
		name="editform" style="display: none;">
		<input type="text" id="id" name="pageData.id" value="${pageid }" /> 
		<input type="text" id="pageImg" name="pageData.pageImg" value=""/>
		<textarea id="content" name="content">
		</textarea>
	</form>
</body>
</html>

