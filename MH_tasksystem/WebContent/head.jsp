<%@ page language="java"  pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<%@include file="/baseHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
<link rel="stylesheet" type="text/css" href="./view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./view/easyUI/css/icon.css">
<script type="text/javascript" src="./view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<title>综合报表平台</title>
<%FrmUser user = FrmUser.getUser(); %>
</head>
<style type="text/css">
#head {
	float:left;
	width:100%;
	height:51px;
	line-height:normal;
	background:url(${root}/images/head.png) no-repeat left top;
	border-bottom:0px solid #6597cc;
}
#head span {
	float:left;
	margin:0px;
	padding:0px 0px 0px 4px;
	text-decoration:none;
}
#tabsF {
	float:left;
	width:100%;
	background:#EEEEEE;
	background:url(url(${root}/view/css1/tab1.png) repeat -x;
	line-height:normal;
	border-bottom:1px solid #6597cc;
}
#tabsF .right {
	float: right;
}
#tabsF ul {
	margin:0px;
	padding:0px 0px 0px 10px;
	list-style:none;
}
#tabsF li {
	display:inline;
	padding:0px;
}
#tabsF a {
	cursor :hand;
	float:left;
	background:url("${root}/view/css1/tableftF.gif") no-repeat left top;
	margin:0;
	padding:0px 0 0 4px;
	text-decoration:none;
}
#tabsF a span {
	float:left;
	display:block;
	background:url("${root}/view/css1/tabrightF.gif") no-repeat right top;
	padding:5px 15px 4px px;
	color:#666;
}
#tabsF a:hover {
	background-position:0% -42px;
}
#tabsF a:hover span {
	background-position:100% -42px;
}
#tabsF #current a {
	background-position:0% -42px;
}
#tabsF #current a span {
	background-position:100% -42px;
}
body {
   font:14px Tahoma;
   background-color: #fff;
   padding-top:0px;
   margin-top: 0px;
   margin-right: 0px;
   margin-bottom: 0px;
   margin-left: 0px;
   color: #375391;
   text-decoration: none;
   text-align:center;
   background:url('view/css1/tab2.jpg') repeat -x;
}

</style>
<script language="JavaScript">
<!--
function Logout() {
	if(confirm("确定退出！"))
		//window.location.href= '${root}/j_spring_security_logout';
		//window.frames( "LogoutFrame" ).navigate( "${root}/j_spring_security_logout" );
		parent.location.href= '${root}/toindex.jsp';
}
function linkto(liObj,url){
	liObj.id=current;
	linkForm.action=url;
	linkForm.submit();
}
-->
</script>
<%
String test=request.getParameter("test");
if(test==null)
	test="FirstPage";
%>
<body style="margin: 0px;padding: 0px">
	<div region="north" style="height:50px;background-image: url(${root}/view/images/bg2.png);background-repeat: repeat -y;">
		<div align="left" style="height:50px;float:left;"><img src="${root}/view/images/logo.png"/></div>
		 <div style="float:right;margin-top: 20px;margin-right: 10px;height:40px">
		 &nbsp;&nbsp;登录用户：<%=user.chinseName%> | <a href="###"  onclick="Logout()">注销</a>
		 </div>
	</div>
	</body>
</html>