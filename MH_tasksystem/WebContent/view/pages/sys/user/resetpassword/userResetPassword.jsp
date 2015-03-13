<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设置新密码 - 商站宝</title>
<style type="text/css">
.tooltip-inner {
	text-indent: 0em;
}
.error{
border:1px solid #ff8080;
float:left;
color:#666;
line-height:20px;
height:20px;
padding:2px 10px 2px 23px;
background:url(/view/pages/sys/user/resetpassword/error.png) no-repeat 3px center #fff2f2;
font-size: 14px;
}
</style>
<script type="text/javascript">
	function reg(obj) {
		var pwd=$("#password").val();
		var npwd=$("#newpassword").val();
		 if(pwd==""){
			 $(".error").html("请输入密码。");
			 $(".error").show();
			 return false;
		 }
		 if(npwd==""){
			 $(".error").html("请输入确认密码。");
			 $(".error").show();
			 return false;
		 }
		 if(npwd.trim()==pwd.trim()){
		 }else{
			 $(".error").html("两次密码输入不一致。");
			 $(".error").show();
			 return false;
		 }
		$("#myform").submit();
	};
	
	$(document).ready(function(){
		$('#u9').mouseover(function(){
			 $("#u9").css("background-color","#009ABE");
	       }).mouseout(function(){
				$("#u9").css("background-color","#0099CC");
	      });
	});
</script>
</head>

<body style="background-color: #E2E2E2; width: 100%;">
	<div style="margin-top: 14%; margin-left: 35%;">
		<div id="u1" class="text">
			<p>
				<span style="color: #0099CC; font-size: 28px;">请设置新密码</span>
			</p>
		</div>
		<form id="myform" action="${root }/user/key/resetPassword"
			method="post">
			<input type="hidden" name="userid" value="${userid }">
			<div id="u5" class="text" style="margin-top: 75px;">
				<input id="password" style="width: 331px; height: 50px;"
					type="password" class="input_bg1" size="40" max="16"
					notnull="请输入密码" placeholder="请输入密码" />
			</div>
			<div id="u7" class="text" style="margin-top: 25px;">
				<input style="width: 331px; height: 50px;" name="pwd"
					notnull="请输入确认密码" placeholder="请输入确认密码" refer="password"
					type="password" class="input_bg1 npwd" size="40" id="newpassword"/>
			</div>
			<div class="error"	style="margin-top: 10px;display: none;"></div>
			<div id="u9"
				style="text-align: center; width: 335px; height: 50px; background-color: #0099CC;margin-top: 50px;"
				class="text" onclick="reg(this)">
				<p>
					<a href="###" class="register_btn"
						style="color: #FFF; line-height: 50px; text-decoration: none;">保存</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>


