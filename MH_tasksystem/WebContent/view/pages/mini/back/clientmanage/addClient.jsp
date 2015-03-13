<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/clientmanage/addClient.js"></script>
<title>添加客户</title>
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
</head>
<body>
  <div class="current" style="margin-bottom: 20px;">当前位置：
   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/client_manage/key/searchAllClient" target="frame_main">客户管理</a>
<b>>></b> 
<a href="${root }/view/pages/mini/back/clientmanage/addClient.jsp" target="frame_main">添加客户</a>
</span> 
</div>
	<form action="" id="addClient" onsubmit="return checkSub($(this))" method="post">
		<table class="table" style="margin-left: 10px;">
			<tr>
				<td class="table_td">公司名称：</td>
				<td><input class="input-medium" id="companyName" type="text" name="" placeholder="请输入公司名称"/>
				<input class="input-medium" type="hidden" name="userData.userType" value="2"/>
				<input class="input-medium" type="hidden" name="userData.addType" value="2"/></td>
			</tr>
			<tr>
				<td class="table_td">联系人：</td>
				<td><input class="input-medium" type="text" name="userData.userName" placeholder="姓名" notnull="请填写用户姓名"/>&nbsp&nbsp
				</td>
			</tr>
			<tr>
				<td class="table_td">联系人手机号码：</td>
				<td>
				<input class="input-medium" type="text" name="userData.loginMoble" placeholder="手机"/>
				</td>
			</tr>
			<tr>
				<td class="table_td">联系人邮箱：</td>
				<td>
				<input class="input-medium" type="text" name="userData.loginMail" placeholder="邮箱" notnull="请填写用户登录邮箱" email="邮箱格式不正确" ajax="${root }/user/key/ajaxCheckUser,userData.loginMail,0,您输入的用户名已被占用"/>
				</td>
			</tr>
			<tr>
				<td class="table_td">登录密码：</td>
				<td><input class="input-medium" autocomplete="off" id="userPassword" type="password" name="userData.passWord"/>&nbsp
				<a class="btn btn_tianjia" id="setPassword" href="###" style="margin-left: 20px;font-size: 14px;font-size: 12px;margin-top: -10px;">让客户自己设置密码</a>
				<input type="hidden" id="setPwd" name="setPwd" value = "false" />
				</td>
			</tr>
			<tr><td colspan="2"><div class="line" style="margin:20px 0;"></div></td></tr>
			<tr>
				<td>
				<div class="btnlan">
				<a href="###" class="addClient " style="width: 200px;" >添加</a>
				</div>
				</td>
				<td>
				<div class="btnhui">
				<a  href="${root }/client_manage/key/searchAllClient">取消</a>
				</div>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>