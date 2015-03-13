<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮件已发送 - 商站宝</title>
<script type="text/javascript" src="${root}/view/js/minipage/common/findPwd.js"></script>
<style type="text/css">
.nbtn{
	border:none;
	height:47px; 
	width:120px; 
	background-image:url(/view/images/button_u12.png);
	font-size: 16px;
	color: #FFFFFF;
	cursor: pointer;
}
</style>
</head>
<body>
<body style="text-align:center; background-image:url(/view/images/bg.jpg);">
<input type="hidden" value="${userLogName}" class="email">
<div style="margin:0 auto; width:500px; padding-top:100px;">
  <div><span style="font-weight: 200; font-size: 28px; color: #0099CC; float:left;">找回密码</span><a href="${root }/view/pages/mini/front/login.jsp" style="font-weight: 200; margin-top:12px; font-size: 16px; color: #0099CC; float:right;text-decoration: none;">返回登录—></a></div>
  <div style="padding-top:40px;">
    <hr style="width:500px; height:1px; border:none;border-top:1px solid #0099CC;"/>
  </div>
 <div align="left" style="margin-top:20px;font-weight: 700; font-size: 20px; color: #6B6B6B;">
 	邮件已发送
 </div>
 <div align="left" style="margin-top:20px;font-weight: 200; font-size: 16px; color: #6B6B6B;">已向你的邮箱<b>${userLogName}</b>发送了一封重设密码的邮件，请根据邮件的提示去重新设置密码。</div>
    <div style="float:left;font-weight: 200;font-size: 16px;color: #0099CC;margin-top: 50px;">
    如果没有收到邮件，请点击下面按钮重新发送
     <input type="button" class="nbtn emailBtn"  style="margin-left: 46px;"  value="重发邮件"  onclick="emailBtn()" />
    </div>

</div>
</body>
</html>
