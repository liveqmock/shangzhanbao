<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function init(){
	setTimeout(function(){
		window.form.submit();
	},50)
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功，正在跳转...</title>
</head>
<body onload="init()">
	<form action="${sessionScope.targetURL }" method="post" name="form" id="form">
		<c:forEach items="${sessionScope.targetReqParam }" var="item">
				<input type="hidden" name="${fn:replace(item.key,'~','') }" value="${item.value }">
		</c:forEach>
	</form>
	
</body>
</html>