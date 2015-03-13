<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/templateShop/css/ifrma.css"/>
<title>Insert title here</title>
<style>
body{
	margin:0 auto;
	background:#000;
	font-size:12px;
	color:#fff;
}

</style>

</head>

<body>
<div id="frame_top"><h1>MiniPage</h1><h2><img src="${root }/images/mini/templateShop/images/frame_top_t1.jpg" width="367" height="27">
 </h2>
<h1 style="margin-top: 5px;float: right;">
<c:if test="${frmUser.etipUserID!=null && frmUser.etipUserID!=''}">
<a href="#" style="color:#fff;text-decoration: none;font-size: 14px;line-height: 40px;" onclick="if(confirm('您确定退出么？')) window.parent.location.href='${root }/j_spring_security_logout'">退出</a>
</c:if>
<c:if test="${frmUser.etipUserID==null}">
<a href="${root }/view/pages/mini/front/login.jsp" target="_parent" style="color:#fff;text-decoration: none;font-size: 14px;line-height: 40px;">
登录
</a>
</c:if>
<a href="${root }/frame/key/sp" target="_parent" style="color:#fff;text-decoration: none;font-size: 14px;">返回首页 </a></h1>
<div style="background-color: red;"></div>
</div>
</body>
</html>
