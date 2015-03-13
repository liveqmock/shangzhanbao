<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css" />
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script defer="defer" type="text/javascript" src="${root }/view/js/jquery.cookie.js"></script>
<script defer="defer" type="text/javascript" src="${root}/view/pages/mini/page/createPage/sell/js/sell.js"></script>
<script defer="defer" type="text/javascript" src="${root}/view/pages/mini/page/createPage/sell/js/sellStep3.js"></script>
<script type="text/javascript" src="${root }/view/pages/mini/page/edit/js/edit_left_service.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css" />
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/templateShop/css/frma_left.css">
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css" />
<script type="text/javascript"	src="${root}/view/js/product/ajaxfileupload.js"></script>
<script type="text/javascript"	src="${root}/view/pages/mini/page/edit/js/edit_left.js"></script>
<script type="text/javascript"	src="${root}/view/js/uploadBtn/upload.btn.js"></script>
<script type="text/javascript" src="${root }/view/pages/mini/page/edit/js/edit_main_left.js" defer="true"></script>
<style>
html { overflow-x:hidden; }
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	color: #ffffff;
	border-top: 1px solid #3d5164;
}
</style>
<script type="text/javascript">
$(function(){
	if($("#imgIdent").prev("input").attr("checked")=="checked"){
		$("#pay").show();
	}
})
</script>
</head>
<body>
	<a href="###" id="serviceId" style="display: none;">服务</a>
	<div style="position:absolute;left:0px;top:0px;width:100%;height: 50px;">
		<div style="float: left; background:#1AB1AA; height:50px;line-height:50px; width:50%; text-align: center;">		
		<h2><a href="${root }/page_manage/key/toeditLeft?id=${id}" style="color:#fff">修改内容</a></h2>
		</div>
		<div  style="float: left; background:#636F80; height:50px;line-height:50px; width:50%; text-align: center;">
		<h2><a href="javascript:parent.frames['frame_top'].edit_service()" style="color:#fff">修改营销动作</a></h2>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<input type="hidden" id="userId"
			value="<%=FrmUser.getUser().etipUserID%>" />
		<div id="Frma_Left_Starp1">
			<div class="Frma_Left_Starp1_tab">
				<div class="FormTab">
					<form action="" method="post">
						<c:forEach var="li" items="${productDatas }" varStatus="i">
							<p>
								<span> <input type="checkbox" data="${li.id }"
									<c:if test="${li.isPay==0 }">checked="checked"</c:if>
									producttype="${li.type}" data1="${li.price }" data3
									data2="${li.name }" data4="edit" class="ckProduct" value="checkbox" /> <c:if
										test="${li.type == '1'}">
										<img width="20px" height="20px"
											src="${root }/images/mini/images/message1.png" />
									</c:if> <c:if test="${li.type == '2' }">
										<img width="20px" height="20px"
											src="${root }/images/mini/images/Incoming-Call1.png" />
									</c:if> <c:if test="${li.type == '5' }">
										<img width="20px" height="20px"
											src="${root }/images/mini/images/talk991.png"  id="zaixiankefu"/>
									</c:if>
									<c:if test="${li.type == '6' }">
									<img width="20px" height="20px" src="${root }/images/mini/purchase/buy/buy_meitu_3.jpg" id="imgIdent"/>
									</c:if>
									<input type="hidden" class="productId" value="${li.id }" /> <input
									type="hidden" class="price" value="${li.price }" /> <input
									type="hidden" class="productName" value="${li.name }" />
								</span><font>${li.name } <c:if
										test="${li.price!='' && li.price!=0 && li.price!=null}">(需购买)
							<input type="hidden" class="productPrice" value="${li.price }" />
									</c:if> 
									<!-- 在线客户查看详情 --> 
									<c:if test="${li.type == '5' }">
								<a href="###" onclick="selectInfo()" style="color:#D7796F;text-decoration: none;">查看详情<img style="width:16px;height: 16px;" src="${root}/view/model/images/u70.png"></a>
								</c:if>
								<c:if test="${li.type == '6' }">
								</c:if>
						</font>
							</p>
							<c:if test="${li.type == '2' }">
								<div style="margin: -10px 0 5px 0; float: left; display: none"
									id="step_phoneDiv">
									<input type="text" id="step_phone" class="input_bg"
										placeholder="请输入您的咨询电话，如400-123-1230" value=""
										style="width: 205px" />
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
					<div style="float: right">
						<a href="javascript:savePageProductAndConent()" id="bc" class="Btn_next playDivhide">保存</a>
					</div>
				</div>
			</div>
		</div>
		<div id="form_div" style="display: none;">
			<form action="${root }/page_manage/key/baocun" method="post"
				id="editform" name="editform">
				<input type="text" id="id" name="pageData.id" value="${id }" />
				<input type="text" id="pageImg" name="pageData.pageImg" value=""/>
				<textarea id="content" name="content">
			</textarea>
			</form>
			<form id="TelAndMsg" action="" method="post" target="_top"></form>
		</div>
	</div>
	<input type="hidden" id="temp_left" name="pageData.id" value="temp_service" />
	</body>
</html>
