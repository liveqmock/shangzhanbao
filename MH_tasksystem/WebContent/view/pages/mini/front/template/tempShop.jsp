<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"	src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap-modal.js"></script>
<script type="text/javascript"	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/front/template/Template.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/front/template/tempShop.js"></script>
<link rel="stylesheet" type="text/css"	href="${root }/view/css/bootstrap.css" />
<link href="${root }/view/css/mini/templateShop/css/Template.css"	rel="stylesheet" type="text/css" />

<title>模板商店</title>
<style type="text/css">
.nTab {
	width:100%;
	padding:0;
	margin:0px auto;
	float:left;
}
.nTab .TabTitle {
	width:100%;
	clear: both;
	height: 28px;
	overflow: hidden;
	border-bottom:4px solid #1386fe;
}
.nTab .TabTitle ul {
	margin:0 0 0 18px;
	padding:0;
}
.nTab .TabTitle li {
	float: left;
	width: 100px;
	height:28px;
	line-height:28px;
	cursor: pointer;
	padding: 0px;
	list-style-type: none;
	text-align:center;
	font-size:12px;
	color:#333;
	margin:0 3px 0 0;
}
.nTab .TabTitle .active {
	background:url(../../images/operating/images_crb1.jpg) no-repeat left bottom;
	color:#fff;
	font-weight:bold;
	cursor:default;
}
.nTab .TabTitle .active a{
	color:#fff;
	text-decoration:none;
}
.nTab .TabTitle .active a:hover{
	color:#fff;
	text-decoration:none;
}
.nTab .TabTitle .normal {
	border:1px solid #979797;
	border-bottom:none
}

</style>
</head>
<body  >
	<form action="" method="post">
		<div id="main_shop">
			<c:forEach var="templateData" items="${templateDatas }" varStatus="i">
				<div class="pic">
					<img src="${root }${templateData.imgpath}">
					<div class="edit">
						<ul>
							<li>
								<h1>${templateData.name }</h1>
							</li>
							<li><font>设计师：</font><span>${templateData.creator }</span></li>
							<li><font>布局：</font><span>一栏</span></li>
							<li><font>价格：</font><span> <c:if
										test="${templateData.price==null }">
										<td>免费</td>
									</c:if> <c:if test="${templateData.price!=null }">
										<td>${templateData.price }</td>
									</c:if>
							</span></li>
							<li><font>支持设备：</font><span><img
									src="${root }/images/mini/templateShop/images/icon_0.png"
									width="167" height="51"></span></li>
							<li>使用数量：<span>19974 个Page使用了这个模板</span></li>
							<li>
								<p>
									<span class="btn_gray"><a href="###" class="searchTempInfo" data="${templateData.id }">查看详情</a></span><span
										class="btn_orange"><a href="${root }/page_manage/key/toCreatePage?id=${templateData.id }" target="_parent">使用</a></span>
								</p>
							</li>
						</ul>
					</div>
					<c:if test="${i.index !=0 && i.index%2 != 0 }">
						<br>
					</c:if>
				</div>
			</c:forEach>
		</div>

		<page:PageRoll />
	</form>
	<div id="dlg" class="modal modal-mslmgmt hide"
		style="width: 400px; height: 270px;">
		<div class="modal-header modal-header-mslmgmt">
		<a class="close" data-dismiss="modal"><i class="icon-remove">关闭</i></a>
		</div>
		<div class="nTab"> 
		<div class="TabTitle">
			<ul id="myTab00">
				<li class="active" style="background-color: green;" data-state="1"><a
					href="###" class="pc btn">电脑预览图</a></li>
				<li class="active" style="background-color: green;" data-state="2"><a
					href="###" class="pad btn">平板预览图</a></li>
				<li class="active" style="background-color: green;" data-state="3"><a
					href="###" class="phone btn">手机预览图</a></li>
			</ul>
		</div>
		<div>
			<div id="pcImg" class="pic">
				<img style="width: 400; height: 300" alt="" src="">
			</div>
			<div id="padImg" class="pic">
				<img style="width: 400; height: 300" alt="" src="">
			</div>
			<div id="phoneImg" class="pic">
				<img style="width: 400; height: 300" alt="" src="">
			</div>
		</div>
	</div>
	</div>
</body>
</html>