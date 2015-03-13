<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/baseHead.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet"	type="text/css" />
<link href="${root }/view/css/bootstrap.css" rel="stylesheet" type="text/css" />
<title>分享到微信 - 商站宝</title>
</head>
<body>
	<div class="head"></div>
	<div class="content" style="padding-top: 0px;">
		<div class="UserCenter_Right" style="margin-right:10%;">
		<div class="weixintop">
		<img alt="商站宝" src="${root}/view/images/logo/logo.jpg" style="width: 127px;height: 36px;padding-top: 8px;padding-left: 30px;">
		</div>
			<div class="mesmain" style="height: 228px;">
				<div class="wexinDiv1">
				<h1>分享到微信</h1>
				<span>用微信“扫一扫”右侧的二维码，即可分享到好友圈中。</span>
				<p>【${pageName}】</p>
				<a href="${domain}" target="_blank">【${domain}】</a>
				</div>
				<div class="wexinDiv2">
				<img alt="" src="${root}${ImgUrl}">
				</div>
			</div>
			<div class="weixinbtm"></div>

			<div class="DataStatistics_1 UserCenter_RightOn" style="margin-top: -23px;">
				<h1 style="font-family: 'Heiti SC Medium', 'Heiti SC';font-weight: 700;font-size: 18px;color: #333333;padding: 4%;">操作步骤:</h1>
				<div class="ul_div">
				<span>1. 找到微信下方的“发现”，并点击</span>
				<img alt="" src="${root}/view/images/zing/u19.png">
				</div>
				<div class="ul_div">
				<span>2. 再点击“扫一扫”</span>
				<img alt="" src="${root}/view/images/zing/u25.png">
				</div>
				
				<div class="ul_div">
				<span>3. 对准二维码，扫描</span>
				<img alt="" src="${root}/view/images/zing/u31.png">
				</div>
				<div class="ul_div">
				<span>4. 点击右上角“分享”</span>
				<img alt="" src="${root}/view/images/zing/u33.png">
				</div>
				
				
				<div class="ul_div">
				<span>5. 点击“分享到朋友圈”</span>
				<img alt="" src="${root}/view/images/zing/u35.png">
				</div>
				<div class="ul_div">
				<span>6. 分享成功</span>
				<div>
				<img alt="" src="${root}/view/images/zing/u43.png" style="width: 38px;height: 38px;padding-top: 70%;padding-left: 15%;float: left;">
				<p style="float: left;">分享成功!</p>
				</div>
				</div>
				
			
			</div>
		</div>
	</div>
</body>
</html>