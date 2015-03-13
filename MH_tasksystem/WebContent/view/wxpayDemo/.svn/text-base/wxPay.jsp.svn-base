<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微信支付Demo</title>
</head>
<script language="javascript">
	function init(){
		$.ajax({
			type : "POST",
			url : root + '/to_wx_pay/key/wxPay',
			dataTyep: "text",
			success : function(data) {
				console.log(data)
			}
		});
	}
</script>
<body onload="init()">
	
</body>
</html>