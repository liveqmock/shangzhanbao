<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />

<title>订单详情</title>
<style type="text/css">
.btn_sel{
		margin-left:5px;
		font-size: 13px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #D7D7D7;
		width:53px;
		height:20px;
	}
	.btn_cl{
		margin-left:5px;
		font-size: 13px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #FF0000;
		width:53px;
		height:20px;
	}
	.deliverGoods{
		margin:30px auto;
		width:605px;
		height:auto;
	}
	.deliverGoods_groud{
		width:221px;
		height:136px;
		background:url(${root}/view/images/buy/u203.png) 221px 136px;
		position:relative;
		left:25px;
		top:25px; 
		float:left;
	}
	.deliverGoods_div{
		background:#0099FF;
		width: 65px;
		height: 19px; 
		position:relative;
		left:10px; 
		top:-10px;
		-webkit-border-radius: 30px;
		-moz-border-radius: 30px;
		font-family:'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		font-size: 13px;
		text-align:center;
		line-height:19px;
	}
	.goodsName{
		margin-left:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 16px;
		color: #333333;
	}
	.goodsConfig{
		margin-left:10px; 
		margin-top:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #666666; 
		font-size:13px;
	}
	.goodsNum_div{
		margin-left:10px; 
		margin-top:10px;
	}
	.goodsNum{
		background-color: #E4E4E4;
		width: 46px;
	}
	.goodsPrice{
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 16px;
		color: #FF0000;
	}
	.customer_div{
		width:338px; 
		height:136px; 
		background:url(${root}/view/images/buy/u211.png) 338px 136px;
		position:relative; 
		left:26px; 
		top:25px; 
		float:left;
	}
	.customer_info{
		margin-left:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #333333; 
		width:313px; 
		line-height:25px;
	}
	.logistics_div{
		width:558px; 
		height:143px; 
		background:url(${root}/view/images/buy/u232.png) 558px 143px;
		position:relative; 
		left:25px; 
		top:40px; 
		float:left;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #333333;
	}
	.logistics_company{
		margin-left:10px; 
		margin-top:5px;
	}
	.logistics_number{
		margin-left:10px; 
		margin-top:10px;
	}
	.logistics_number_text{
		border:#FF0000 2px solid; 
		width:325px; 
		height:28px;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
	}
	.logistics_number_btn{
		border:none; 
		background:#FF0000;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #FFFFFF; 
		width:70px; 
		height: 30px;
		float:right;
		margin-right: 25px;
	}
	.closeBox_btn{
		width:88px;
		height:30px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #999999;
		float: right;
		margin-right: 20px;
	}
</style>
</head>
<body style="background:#B5B5B5; margin-top: -32px;">
<div class="current">当前位置：
	<span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
	<span><a href="${root }/order_manager/key/tobackOrderManager" target="frame_main">商站订单统计</a><b>>></b><a href="###" target="frame_main">订单详情	</a></span>
</div>
<div id="ContentDiv">
</div>
<div class='deliverGoods'>
	<div class='deliverGoods_groud'>
		<div class='deliverGoods_div'>商品</div>
		<div class='customer_info'>名称：${cogData.goodsInfoData.goodsName }</div>
		<div class='customer_info'>规格：${cogData.commodityConfigData.configName }</div>
		<div class='customer_info'>数量：${cogData.goodsNum }&nbsp;&nbsp;&nbsp;价格：<span class='goodsPrice'>￥${cogData.conSumerOrderData.price }</span></div>
		<div class='customer_info'></div>
	</div>
	<div class='customer_div'>
		<div class='deliverGoods_div'>客户</div>
		<div class='customer_info'>
			收 货 人：${cogData.conSumerOrderData.conSumerUserData.userName }<br/>
			手机号码：${cogData.conSumerOrderData.conSumerUserData.userMobile }<br/>
			收货地址：${cogData.conSumerOrderData.conSumerUserData.userAddress }
		</div>
	</div>
	<div class='logistics_div'>
		<div class='deliverGoods_div' style='background: #FF0000;'>发货</div>
		<div style='margin-left: 10px;margin-top: 10px;font-size: 13px;'>
		<c:if test="${cogData.conSumerOrderData.state==0 }">
			未付款
		</c:if>
		<c:if test="${cogData.conSumerOrderData.state==1 }">
			待发货
		</c:if>
		<c:if test="${cogData.conSumerOrderData.state==2 }">
			已发货<br/>
			物流公司：${cogData.conSumerOrderData.logisticsCompany}<br/>
			物流单号：${cogData.conSumerOrderData.logisticsNumber}<br/>
			发货时间：${cogData.conSumerOrderData.deliverTime}
		</c:if>
		<c:if test="${cogData.conSumerOrderData.state==4 }">
			交易取消<br/>
		</c:if>
		</div>
	</div>
	<div class='logistics_div' style="top:55px;">
		<div class='deliverGoods_div' style='background: #FF0000;'>企业</div>
		<div style='margin-left: 10px;margin-top: 10px;font-size: 13px;'>
			<div>
				登录账号：
				<c:if test="${cogData.conSumerOrderData.pageData.userData.loginMail==null || cogData.conSumerOrderData.pageData.userData.loginMail==''}">
				${cogData.conSumerOrderData.pageData.userData.loginMoble }
				</c:if>
				<c:if test="${cogData.conSumerOrderData.pageData.userData.loginMail!=null && cogData.conSumerOrderData.pageData.userData.loginMail!=''}">
				${cogData.conSumerOrderData.pageData.userData.loginMail }
				</c:if>
			</div>
			<div>商站地址：<a href="${path}${cogData.conSumerOrderData.pageData.pageInfoExtra.domain }" target="top">${path}${cogData.conSumerOrderData.pageData.pageInfoExtra.domain }</a></div>
			<div>收款方式：${cogData.conSumerOrderData.pageData.userData.accountType==0?'支付宝':'微信'}</div>
			<div>收款账号：${cogData.conSumerOrderData.pageData.userData.receivableAccount}</div>
		</div>
	</div>
</div>
</body>
</html>