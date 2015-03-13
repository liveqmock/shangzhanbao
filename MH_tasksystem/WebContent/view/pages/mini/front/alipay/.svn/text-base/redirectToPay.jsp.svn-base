<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>正在提交。。。</title>
<script type="text/javascript">
	function ini(){
		setTimeout(function(){
			var type = document.getElementById("type").value;
			if(type == 0){
				window.location.href="${pageContext.request.contextPath}/alipay/key/offlinePay?code=${code}&price=${price}&orderId=${orderId}";
			}else{
				//window.location.href="${pageContext.request.contextPath}/product_virtual/key/onlinePay?orderProductId=${orderProductId}";
				window.location.href="${pageContext.request.contextPath}/alipay/key/toAlipay?orderId=${orderId}&code=${code}";
			}
		},50)
	}

</script>
</head>
<body onload="ini()">
	<input type="hidden" value="${type}" id="type">
	<h1>正在跳转。。。</h1>
</body>
</html>
