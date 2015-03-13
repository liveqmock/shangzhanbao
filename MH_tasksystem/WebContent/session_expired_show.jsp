<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>您的登录状态已注销</title>
<script type="text/javascript">
function init(){
	window.location="${pageContext.request.contextPath}/view/pages/mini/front/login.jsp";
}
</script>
</head>
<body onload="init()">
<!-- 	<h1>您的登录状态已注销。</h1> -->
<!-- 	<h3>您的账号已在其他地方登录，系统已注销您的登录状态。</h3> -->
<%-- 	<h3><a href="${pageContext.request.contextPath}/view/pages/mini/front/login.jsp">重新登录</a></h3> --%>
</body>
</html>