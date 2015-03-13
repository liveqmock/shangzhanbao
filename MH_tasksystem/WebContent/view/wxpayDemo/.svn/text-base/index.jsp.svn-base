<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String appId = request.getParameter("appid");
String timeStamp = request.getParameter("timeStamp");
String nonceStr = request.getParameter("nonceStr");
String packageValue = request.getParameter("package");
String paySign = request.getParameter("sign");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>zhifu</title>
</head>
<body>
<div>
	<br><br><br><br><br><br><br>
  			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="微信支付" onclick="callpay()"></div>
  			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="<%=appId%>" onclick="callpay()"></div>
			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="<%=timeStamp%>" onclick="callpay()"></div>
			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="<%=nonceStr%>" onclick="callpay()"></div>
			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="<%=packageValue%>" onclick="callpay()"></div>
			<div style="text-align:center;size:30px;"><input type="button" style="width:200px;height:80px;" value="<%=paySign%>" onclick="callpay()"></div>
</div>
</body>
<script type="text/javascript">
  	function callpay(){
  		alert(1111);
		 WeixinJSBridge.invoke('getBrandWCPayRequest',{
  		 "appId" : "<%=appId%>","timeStamp" : "<%=timeStamp%>", "nonceStr" : "<%=nonceStr%>", "package" : "<%=packageValue%>","signType" : "MD5", "paySign" : "<%=paySign%>" 
   			},function(res){
				WeixinJSBridge.log(res.err_msg);
// 				alert(res.err_code + res.err_desc + res.err_msg);
	            if(res.err_msg == "get_brand_wcpay_request:ok"){  
	                alert("微信支付成功!");  
	            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
	                alert("用户取消支付!");  
	            }else{  
	               alert("支付失败!");  
	            }  
			})
		}
  </script>
</html>
