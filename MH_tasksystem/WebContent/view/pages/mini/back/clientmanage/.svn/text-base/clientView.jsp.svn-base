<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/clientmanage/clientView.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<title>客户信息</title>
</head>
<body>
  <div class="current" style="margin-bottom: 20px;">当前位置：
   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/client_manage/key/searchAllClient" target="frame_main">客户管理</a>
<b>>></b> 
<a href="${root }/client_manage/key/searchClientById?userData.id=${userData.id}" target="frame_main">客户详情</a>
</span> 
</div>
	
	  <input id="userId" type="hidden" value="${userData.id }"/>
	<table class="table" id="addClientTable" style="margin-left: 10px;"> 
		<tr>
			<td class="table_td">登录账号:</td>
			<td><label id="lableLogin">${userData.loginMail }</label><input id="inLogin" type="hidden" value="${userData.loginMail }"/></td>
		</tr>
		<tr>
			<td class="table_td">密码:</td>
			<td><label id="lablePass">**********</label><input id="inPass" type="hidden" value="${userData.passWord }"/></td>
		</tr>
		<tr>
			<td class="table_td">注册时间:</td>
			<td>${userData.createTime }</td>
		</tr>
		<table class="tablepage" style=""  >
			<tr>
				<td style="background: #fff;">Page数</td>
				<td>发布Page数</td>
				<!-- <td>认证Page数</td> -->
				<td>未使用发布权限数</td>
			</tr>
			<tr>
				<td>${userData.pageNum }</td>
				<td>${userData.pubPageNum }</td>
				<!-- <td></td> -->
				<td>${userData.buyPubNum }</td>
			</tr>
		</table>
	</table>
	 <div id="editDiv" style="margin-left: 10px;"><a href="###" class="editClient btn_tianjia">修改</a></div>
	  <div id="addDiv" style="margin-left: 10px;"><a href="###" class="addClient btn_tianjia">保存</a></div>
	  <a href="#" onclick="createPage();" class="btn_tianjia"><font size="3" style="align:right;font-size: 12px;">帮他创建page</font></a>
</body>
</html>