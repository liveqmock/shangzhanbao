<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改登陆账号 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root }/view/css/centerCss.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/purchase/sysUser/editLoginAccount.js"></script>
</head>
<body>
<form action="" id="eidtLoginAccountForm" method="post">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
  <div class="UserCenter_Right"  >
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>修改登陆账号</h1>
      </div>
      <div class="error" style="margin-top:20px;margin-left:130px;display:none;position: absolute;margin-top: 50px;"></div>
      <div style="height: 370px">
      <div style="margin-top: 75px;margin-left: -23px;">
       <div class="control-group">
          <label class="control-label" style="font-size: 14px">当前账号：</label>
          <div class="controls">
          	<label class="control-label" style="font-size: 14px;text-align: left;">${userLogAccount }</label>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">登陆密码：</label>
          <div class="controls">
          	<input style="border:1px solid #09C;-webkit-box-shadow: 0 0 0px 1000px white inset;width: 225px" id="loginPwd" type="password"  name="userData.passWord" class="input_23bor" size="30"/>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">新的账号：</label>
          <div class="controls">
          	<input style="border:1px solid #09C;-webkit-box-shadow: 0 0 0px 1000px white inset;width: 225px" id="loginAccount" type="text"  name="userData.loginMail" class="input_23bor" size="30"/>
		  </div>
        </div>
        <div class="control-group">
          <span ><a  style="margin-left: 280px;margin-top: 10px;" href="#" class="btn_blue" id="eidtLoginAccount">保存</a></span>
        </div>
      </div> 
      </div>
     </div>
     </div>
    </div>
    <%@include file="/mini_end.jsp"%>
   </form>
</body>
</html>