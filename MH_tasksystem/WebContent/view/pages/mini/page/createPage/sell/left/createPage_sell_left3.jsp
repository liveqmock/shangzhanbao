<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>第三步，营销动作 - 商站宝</title>
<link rel="stylesheet" type="text/css"
	href="${root }/view/pages/mini/page/css/frma_left.css" />
<script defer="defer"  type="text/javascript" src="${root }/view/js/jquery.cookie.js"></script>
<script defer="defer"  type="text/javascript" src="${root}/view/pages/mini/page/createPage/sell/js/sell.js"></script>
<script defer="defer"  type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/sellStep3.js"></script>
<script defer="defer"  type="text/javascript"	src="${root}/view/pages/mini/page/createPage/sell/js/createPageSellleft3.js"></script>
<script type="text/javascript"	src="${root}/view/js/product/ajaxfileupload.js"></script>
<script type="text/javascript"	src="${root}/view/pages/mini/page/edit/js/edit_left.js"></script>
<script type="text/javascript"	src="${root}/view/js/uploadBtn/upload.btn.js"></script>
<style>
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
	height: auto;
}
</style>
</head>
<body>
	<input type="hidden" id="userId" value="<%=FrmUser.getUser().etipUserID %>"/>
	<div id="Frma_Left_top">编辑卖点引导<span>3/3</span></div>
	<div class="clear"></div>
	<div id="Frma_Left_Starp1">
		<h1>第三步</h1>
		<h1 style="line-height: 150%;height: auto;padding-bottom: 20px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp营销动作是客户浏览页面后的操作，是整个页面的关键。设想一下客户对你的产品感兴趣，却联系不到你，那这个客户就流失了。所以，我们的原则是：至少要有一个营销动作。</h1>
		<div class="Frma_Left_Starp1_tab" style="background:none;">
			<h2 style="color: white;width: 88%;">请选择营销动作：</h2>
			<div class="FormTab" style="color: white;">
				<form action="" method="post">
				<c:forEach var="li" items="${productDatas }" varStatus="i">
						<p>
						<span> 
						<input type="checkbox" data="${li.id }" producttype="${li.type}" data1="${li.price }" data3  data2="${li.name }" class="ckProduct"  data4="create" value="checkbox"/>
						<c:if test="${li.type == '1'}">
						<img width="20px" height="20px" src="${root }/images/mini/images/message1.png"/>
						</c:if>
						<c:if test="${li.type == '2' }">
						<img width="20px" height="20px" src="${root }/images/mini/images/Incoming-Call1.png"/>
						</c:if>
						<c:if test="${li.type == '5' }">
						<img width="20px" height="20px" src="${root }/images/mini/images/talk991.png" id="zaixiankefu"/>
						</c:if>
						<c:if test="${li.type == '6' }">
						<img width="20px" height="20px" src="${root }/images/mini/purchase/buy/buy_meitu_3.jpg" id="imgIdent"/>
						</c:if>
						<input type="hidden" class="productId" value="${li.id }"/>
						<input type="hidden" class="price" value="${li.price }"/>
						<input type="hidden" class="productName" value="${li.name }"/>
						</span><font>${li.name }
						<c:if test="${li.price!='' && li.price!=0 && li.price!=null}">
							(需购买)
							<input type="hidden" class="productPrice" value="${li.price }"/>
						</c:if>
						<!-- 在线客户查看详情 -->
						<c:if test="${li.type == '5' }">
							<a href="###" onclick="selectInfo()" style="color:#D7796F;text-decoration: none;">查看详情<img style="width:16px;height: 16px;" src="${root}/view/model/images/u70.png"></a>
						</c:if>
						<c:if test="${li.type == '6' }">
							<%-- <a href="###" onclick="paydivShow()" style="color:#D7796F;text-decoration: none;" id="playDiv_href">添加收款账号<img style="width:16px;height: 16px;" src="${root}/view/model/images/u70.png"></a> --%>
						</c:if>
						</font>
						</p>
						<c:if test="${li.type == '2' }">
						<div style="margin: -10px 0 5px 0; float: left;display:none " id="step_phoneDiv">
						<input type="text" id="step_phone" class="input_bg" placeholder="请输入您的咨询电话，如400-000-0000" value="" style="width: 205px" />
						</div>
						</c:if>
					</c:forEach>
					<p id="pay" style="display: none;line-height: 20px;width: 220px;color: rgb(181, 80, 80);">
					*请及时在“账号管理”中添加收款账号，以免影响收款。
					</p>
				</form>
			</div>
			<div class="clear"></div>
			<div class="FormBtn">
				<div style="float: left">
					<input type="button" onclick="getSubmit2()" class="Btn_buy" style="background: #B4B4B4" disabled="disabled" value="返回" />
				</div>
				<div style="float: right">
					<input type="button" onclick="getsubmit()" class="Btn_next playDivhide" disabled="disabled" value="我写完了" />
				</div>
			</div>
		</div>
	</div>
	<div id="form_div" style="display: none;">
		<form action="${root }/page_manage/key/zancun" method="post"
			id="sellForm" name="sellForm" target="_top"  data="3">
			<input type="text" id="id" name="pageData.id" value="${pageid }" /> <input
				type="text" id="templateid" name="templateid" value="${templateid }" />
			<input type="text" id="status" name="pageData.status" value="3" /> <input
				type="text" id="type" name="pageData.createType" value="0" /> <input
				type="text" id="isdelete" name="pageData.isdelete" value="1" />
				<!-- 此隐藏域 影藏的是帮客户创建page过程中需要影藏的客户id -->
				<input type="hidden" id="userDataId" name="userData.id" value="">
			<textarea id="content" name="content"></textarea>
		</form>
		<form id="TelAndMsg" action="${root }/page_manage/key/ajaxAddProduct" method="post" target="_top"></form>
	</div>
</body>
</html>

							