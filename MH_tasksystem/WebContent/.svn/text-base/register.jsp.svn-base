<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/minicss.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/register.js"></script>
</head>
<body >
	<div style="margin:0 auto; padding-top:100px; width:400px;">
	  <div  class="S1Div">
	    <div  class="imgDiv" style="margin-left: 105px;">
	            <img  src="/view/images/logo/logo.jpg" style="width: 180px;height: 70px;"/>
	            </div>
	    <div class="S2Div">
	    </div>
	  </div>
 			 <div class="error"	style="margin-left: 34px;margin-top: 30px; display: none;"></div>
			<form id="myform" action="" method="post" onsubmit="return checkSub($(this))">
	 	 <p  class="resp">
	 	 <input name="userData.userType" type="hidden"	class="input_bor" size="30" value="2" /> 
	   	 <input name="userData.userState" type="hidden" class="input_bor" size="30" value="1" /> 
	   	 <input name="userData.addType"	type="hidden" class="input_bor" size="30" value="1" />
		 <input id="loginMail" autocomplete="off"  placeholder="请输入邮箱或手机号码" type="text"	class="input_bg1" size="40" max="50" min="6" notnull="请输入邮箱或手机号码"
		 emailOrTel="邮箱或手机格式不正确" ajax="${root }/user/key/ajaxCheckUser,userData.loginMail,0,您输入的用户名已被占用" style="-webkit-box-shadow: 0 0 0px 1000px white inset;"/>
	 	 </p>
		  <p class="resp1">
		  <input id="password" type="password" class="input_bg1" size="40" max="16" notnull="请设置一个密码" placeholder="请输入密码"  style="-webkit-box-shadow: 0 0 0px 1000px white inse;"/>
		  </p>
 		  <p class="resp1">
   		  <input name="" notnull="请输入确认密码" placeholder="请再次输入密码" refer="password" type="password" class="input_bg1" size="40" />
  		  </p>
 		  <p class="resp1">
 			 <div class="inDiv">
 			 <input name="varicode" id="code" type="text"  placeholder="请输入校验码" class="input_bg1" size="20" />
  			 </div>
  			<div  class="resp1_div">
  			<img  title="看不清，换一张" class="vari_code_img" alt="验证码" src="${root }/verification_code" class="vari-code-img" onclick="changeCode()">
 			</div>
  			<div  class="aDiv" style="margin-top: 10px;">
  			<a onclick="changeCode()" href="###" class="changeImg" >看不清?换一张</a>
			</div>
 		 </p>
		  <p style="margin-top:90px;">
		   <input id="registerBtn" type="button" value="注册" class="register_btn btn_200gray" onclick="reg(this)">
		  </p>
  		<p> 
 		 <span style="float:left; margin-left:30px;font-weight: 200;color: #797979; font-size:13px;">
 	 	 <input type="checkbox" class="recbox"  checked="checked">我同意商站宝的
		 <label style="cursor:pointer" id="reService">《用户协议》</label>
		  <label style="cursor:pointer" class="errorDivNmae"></label>
 		 </span>
 		 </p>
	  <p style="padding-top:20px;">
	  <hr />
	  </p>
  	  <p class="fotP"><span>我已有账号，</span><a href="${root }/view/pages/mini/front/login.jsp" style="">立即登录—></a> </p>
	</form>
 </div>
</body>
</html>
