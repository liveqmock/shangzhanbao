<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE>
<html>
<head>
<title>支付成功</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<style>
/*支付成功*/
.es {
	width: 80%;
	height: 100%;
	margin: 0 auto;
}

.div9 {
	width: 100%;
	height: 40px;
}

.div9 img {
	width: 33px;
	height: 33px;
	float: left;
}

.div9 div {
	font-weight: 700;
	font-size: 16px;
	color: rgb(102, 102, 102);
	float: left;
	line-height: 35px;
	margin-left: 3%;
}

.div10 {
	clear: left;
	font-weight: 400;
	font-size: 14px;
	line-height: 20px;
	color: rgb(102, 102, 102);
	margin-top: 2%;
}

.div11 {
	margin-top: 3%;
}

.div11 span {
	background-color: #FF0000;
	width: 200px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	display: block;
	font-weight: 700;
	font-size: 14px;
	color: rgb(255, 255, 255);
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	cursor: pointer;
}

.div11 span:hover {
	background-color:#FF6600;
	width: 200px;
	height: 40px;
}
</style>
</head>
<body onload="ini();">
<!--支付成功-->
<div  style="height: 60px;width: 100%"></div>
	<div class="success es">
		<div class="container clearfix " style="width: 100%">
	   <div class="div9">
	     <img src="../../../../../../images/mini/purchase/goumai/u0.png" /><div>支付成功</div>
	   </div>
	   <div class="div10">
	   <div>.恭喜您，成功获得新的宝贝。</div>
		<div>.如果您有任何问题您都可以通过客服电话联系我们，谢谢！<a style="color:red;text-decoration: none;" href="###" id="backPage_a">返回页面</a >查看联系方式。</div>
		</div>
		<div class="div11">
		 <span ba><a href="" id="backPage" style="color: white;text-decoration: none;">返回购买页面</a></span>
		</div>
		</div>
	</div> 
	<%
		String out_trade_no = request.getParameter("out_trade_no"); 
		String trade_status = request.getParameter("trade_status"); 
		out.println("<input type='hidden' id='out_trade_no' value='"+out_trade_no+"'>");
		out.println("<input type='hidden' id='trade_status' value='"+trade_status+"'>");
		String redjson=request.getParameter("extra_common_param"); 
		out.println("<input type='hidden' id='redjson' value='"+redjson+"'>");
	 %>
	
</body>
<script type="text/javascript">
function ini(){
	var url = root + "/order_manager/key/paySuccessWithOrderChangeState?conSumerOrderData.orderCode="
			+document.getElementById("out_trade_no").value+"&conSumerOrderData.state=1"
			;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			$("#backPage").attr("href",data);
			$("#backPage_a").attr("href",data);
			//红包的使用
			 var redjson=document.getElementById("redjson").value;
			if(redjson!=""){
				 var str = redjson.split("_");
				 var rid=str[0];
				 var cid=str[1];
				 var sid=str[2];
				  if(rid!="" && cid!="" && sid!=""){
					$.ajax({
					    async: false, 
					    url: redPackageroot+"/siims/vmaque/snatchPackage/goumaiUpdateSaveSnatchPackageUserData.jspx", 
					    type: "GET", 
					    dataType: 'jsonp', 
					    //jsonp的值自定义,如果使用jsoncallback,那么服务器端,要返回一个jsoncallback的值对应的对象. 
					    jsonp: 'jsoncallback', 
					    //要传递的参数,没有传参时，也一定要写上 
					   data:"snatchPackageUserData.collarPackageUserId="+cid+"&snatchPackageUserData.redpackageId="+rid+"&snatchPackageUserData.id="+sid,
					    timeout: 5000, 
					    //返回Json类型 
					    contentType: "application/json;utf-8", 
					    //服务器段返回的对象包含name,data属性. 
					    success: function (result) { 
					    	},
					    error: function (jqXHR, textStatus, errorThrown) { 
					    } 
					})
				}
			}
		}
	});
}
</script>
</html>
