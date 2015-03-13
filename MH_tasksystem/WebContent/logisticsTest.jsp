<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
<script type="text/javascript">
$(function(){
	$.ajax({
		async: false, 
	    url: "http://192.168.5.150:8081/logistics_infmation/key/queryLogistics?orderid=f611838e493ab36a01493c70189700f2", 
	    type: "GET", 
	    dataType: 'jsonp', 
	    //jsonp的值自定义,如果使用jsoncallback,那么服务器端,要返回一个jsoncallback的值对应的对象. 
	    jsonp: 'jsoncallback', 
	    //要传递的参数,没有传参时，也一定要写上 
	    data:"", 
	    timeout: 5000, 
	    //返回Json类型 
	    contentType: "application/json;utf-8", 
	    //服务器段返回的对象包含name,data属性. 
	    success: function (result) { 
	    	if(result.scuccess){
	    		//解析data
	    	} else {
	    		alert(result.message)
	    	}
	    }, 
	    error: function (jqXHR, textStatus, errorThrown) { 
	        alert("出现异常"); 
	    } 
	});
});
</script>
<title>物流接口测试</title>
</head>
<body>
</body>
</html>