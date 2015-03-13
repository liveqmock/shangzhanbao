<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html xmlns:ext="http://extjs.com/docs">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<script type="text/javascript">
	function init(){
		$.ajax({
			type : "POST",
			url : "http://localhost:8004/ws_services/MiniForWS/wsSysUserById?sysUserId=c4ca4238a0b923820dcc509a6f75849b",
			data : "",
			async : false,
			success : function(msg){
				json = msg;
				alert(json);
			}
		})
	}
</script>
</head>
<body>
<input type="button" onclick="init();" value="anniu"/>
<a href="http://localhost:8004/ws_services/MiniForWS/wsSysUserById?sysUserId=c4ca4238a0b923820dcc509a6f75849b">测试接口</a>
</body>
	
</html>