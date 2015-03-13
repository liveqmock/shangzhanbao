<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"	src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js"	type="text/javascript"></script>
<script type="text/javascript"	src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js"	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"	href="${root }/view/css/jquery-ui-timepicker.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${root}/view/css/jquery-ui.css">
<script src="${root}/view/js/util/jquery-ui.js"></script>
<title>Page管理</title>
<style>
.TabTitle {
	width: 100%;
	clear: both;
	height: 28px;
	overflow: hidden;
	border-bottom: 4px solid #1386fe;
}

.TabTitle.active {
	background: url(../../../images/images_crb1.jpg) no-repeat left bottom;
	color: #fff;
	font-weight: bold;
	cursor: default;
}

.TabTitle li {
	float: left;
	width: 100px;
	height: 28px;
	line-height: 28px;
	cursor: pointer;
	padding: 0px;
	list-style-type: none;
	text-align: center;
	font-size: 12px;
	color: #333;
	margin: 0 3px 0 0;
}

.TabTitle ul {
	margin: 0 0 0 18px;
	padding: 0;
}
</style>
<script type="text/javascript">
	//提交表单
	function submitForm(obj){
		if(obj=='5'){
			$(".active").click();
		}else{
			$("#state").val(obj);
			$("#disForm").submit();
		}
	}
</script>
</head>
<body style="height: 100%; border-top: 1px solid #D5D5D5;">
	<form action="${root }/order_manager/key/tobackOrderManager"
		class="well form-search" id="disForm" method="post">
		<div class="wrapbg_gp">
			<div class="current">
				当前位置： <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b> <span><a href="${root }/order_manager/key/tobackOrderManager" target="frame_main">商站订单统计</a></span>
			</div>
			<div id="ContentDiv">
				<div class="User_TopSearch">
					<table class="table" width="100%" border="0" cellspacing="1"
						cellpadding="1">
						<tr>
							<td style="width: 40px">客户姓名:</td>
							<td style="width: 140px;"><input style="width: 90px"
								type="text" name="conSumerOrderData.conSumerUserData.userName"
								value="${conSumerOrderData.conSumerUserData.userName }"></td>
							<td style="width: 80px">客户电话:</td>
							<td style="width: 140px;"><input style="width: 120px"
								type="text" name="conSumerOrderData.conSumerUserData.userMobile"
								value="${conSumerOrderData.conSumerUserData.userMobile }"></td>
							<td style="width: 70px">企业登陆账号:</td>
							<td style="width: 140px;"><input style="width: 90px"
								type="text" name="loginAccount"
								value="${userData.loginMoble }"><input
								type="hidden" id="state" name="state"
								value=""></td>
						<tr>
						<tr>
							<td colspan="8">
								<div style="margin:0 0 0 20px;padding-right: 50px;" align="right">
									<input type="button" onclick="submitForm('5')" value="" class="Btn_TopSearch">
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="ContentDiv">
			<div class="nTab">
				<div class="TabTitle">
					<ul id="myTab00">
						<li onclick="submitForm('')" value="5" class=${state==null||state==''?"active":"normal" }>所有订单</li>
						<li onclick="submitForm('1')" value="1" class=${state=='1'?"active":"normal" }>待发货</li>
						<li onclick="submitForm('0')" value="0" class=${state=='0'?"active":"normal" }>未付款</li>
						<li onclick="submitForm('2')" value="2" class=${state=='2'?"active":"normal" }>已发货</li>
						<li onclick="submitForm('4')" value="4" class=${state=='4'?"active":"normal" }>交易取消</li>
					</ul>
				</div>
				<div class="TabContent">
					<div class="hm_content">
						<table width="100%" border="0" cellspacing="1" cellpadding="1">
							<tr>
								<td>&nbsp;</td>
								<td>商品名称</td>
								<td>规格</td>
								<td>数量</td>
								<td>价格</td>
								<td>客户姓名</td>
								<td>电话</td>
								<td>地址</td>
								<c:if test="${state!='0'}"><td>付款时间</td></c:if>
								<td>订单状态</td>
								<td>操作</td>
							</tr>
							<c:forEach var="omData" items="${listOrder}" varStatus="status">
							<tr>
								<td></td>
								<td>
									${omData.goodsInfoData.goodsName }
								</td>
								<td>
									${omData.commodityConfigData.configName }
								</td>
								<td>
									${omData.goodsNum }
								</td>
								<td>
									${omData.conSumerOrderData.price }
								</td>
								<td>
									${omData.conSumerOrderData.conSumerUserData.userName }
								</td>
								<td>
									${omData.conSumerOrderData.conSumerUserData.userMobile }
								</td>
								<td>
									${omData.conSumerOrderData.conSumerUserData.userAddress }
								</td>
								<c:if test="${state!='0'}">
								<td>
									<c:if test="${omData.conSumerOrderData.payTime==null || omData.conSumerOrderData.payTime==''}">
									未付款
									</c:if>
									${omData.conSumerOrderData.payTime}
								</td>
								</c:if>
								<td>
								<c:if test="${omData.conSumerOrderData.state==0 }">
									未付款
								</c:if>
								<c:if test="${omData.conSumerOrderData.state==1 }">
									待发货
								</c:if>
								<c:if test="${omData.conSumerOrderData.state==2 }">
									已发货
								</c:if>
								<c:if test="${omData.conSumerOrderData.state==3 }">
									已完成
								</c:if>
								<c:if test="${omData.conSumerOrderData.state==4 }">
									交易取消
								</c:if>
								</td>
								<td>
									<a href="${root }/order_manager/key/tobackOrderManagerInfo?id=${omData.id }" class="green" style="color: #06c;">查看详情</a>
								</td>
							</tr>
							</c:forEach>
						</table>
						<page:PageRoll/>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>