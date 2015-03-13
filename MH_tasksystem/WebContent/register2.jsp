<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<style type="text/css">
.tooltip-inner {
	text-indent: 0em;
}
</style>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript"
	src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/register.js"></script>
</head>

<body>
	<div class="content">
		<article class="loginSucessful">
		<h1>新用户注册</h1>
		<div id="login_Tab_L">
			<div class="error"
				style="margin-left: 40px; margin-top: 5px; display: none;"></div>
			<form id="myform" action="" method="post"
				onsubmit="return checkSub($(this))">
				<p>
					<span>邮箱/手机号:</span> <input name="userData.userType" type="hidden"
						class="input_bor" size="30" value="2" /> 
						<input
						name="userData.userState" type="hidden" class="input_bor"
						size="30" value="1" /> <input name="userData.addType"
						type="hidden" class="input_bor" size="30" value="1" />
						 <input
						id="loginMail" placeholder="请输入邮箱或手机号码" type="text"
						class="input_bg1" size="40" max="50" min="6" notnull="请输入邮箱或手机号码"
						emailOrTel="邮箱或手机格式不正确"
						ajax="${root }/user/key/ajaxCheckUser,userData.loginMail,0,您输入的用户名已被占用" />
				</p>
				<p>
					<span>请输入密码:</span> <input id="password" type="password"
						class="input_bg1" size="40" max="16" notnull="请输入密码"
						placeholder="请输入密码" />
				</p>
				<p>
					<span>请再次输入密码:</span> <input name="" notnull="请输入确认密码"
						placeholder="请输入确认密码" refer="password" type="password"
						class="input_bg1" size="40" />
				</p>
				<p>
					<span>请输入验证码:</span> <input name="varicode" type="text"
						notnull="请输入验证码" placeholder="请输入验证码" class="input_bg1" size="20"
						style="width: 275px;" />
				</p>
				<p>
					<img
						style="height: 36px; width: 120px; border: 1px solid #ddd; padding: 2px;"
						title="看不清，换一张" class="vari_code_img" alt="验证码"
						src="${root }/verification_code" class="vari-code-img"
						onclick="changeCode()"> <a onclick="changeCode()" href="###"
						class="blue changeImg" style="line-height: 20px;">看不清，换一张</a>
				</p>

				<p>
					<input type="checkbox" class="recbox" style="margin-top: 10px;" checked="checked">
					<label style="float: left; margin-left: 0px;">同意协议</label>
					<label style="color: blue; cursor: pointer; float: left; margin-left: -20px;" id="reService">《用户协议》</label>
					<!-- <label style="color: blue; cursor: pointer; float: left; margin-left: -20px;" onclick="showAgreementJsp();">《用户协议》</label> -->
					<label class="errorDivNmae" style="margin-top: 5px; display: none;"></label>
				</p>
				<p>
					<a href="###" class="register_btn btn_200gray" onclick="reg(this)"
						style="font-size: 15px; background: linear-gradient(to bottom, #00a0b1 0%, #008299 100%); color: #FFFFFF; margin-left: 26px; width: 278px">注册</a>
				</p>
				<p>
					我已有账号，<a href="${root }/view/pages/mini/front/login.jsp"
						class="font_blue">现在登录</a>
				</p>
			</form>
		</div>
		<div class="clear"></div>
		</article>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>