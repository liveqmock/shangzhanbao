<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/mini_top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet"
	type="text/css" />
<link href="${root }/view/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<title>${pageProductData.productName }</title>
<script type="text/javascript">
	$(".jiesuan").live("click",function(){
	  window.location.href=root+"/shopping_cart/key/getAll?sign=1";
 	 })
   $(".zhifu").live("click",function(){
	  window.location.href=root+"/order/key/orderList?menuNum=5";
 	 })
</script>

</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>
		<div class="UserCenter_Right">
			<div class="mesTi">
		     <div class="h1Div"> <h1 style="min-width: 500px">${pageName}  <c:if test="${pageName==''}">未设置名称</c:if></h1></div>
		   <a href="${root }/page_manage/key/getAllPaga?menuNum=1"> <img alt="" src="${root}/view/images/product/u53.png"></a>
		    </div>
		    	<c:if test="${pageProductData.status==1 || pageProductData.status==0}">
		     <div class="mesmain" style="height: 280px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u39.png">
			  </div>
			  <div  class="mes_mright">
			  <h1>在线咨询</h1>
				  <div class="zuoxi">
	        	<span style="float: left;margin-left: 0;"> 坐席数：三个坐席</span>
	        	<p style="clear: left;margin-top: 3%;font-weight: 200;font-size: 14px;color: #666666;">
				  有效期：<fmt:formatDate value="${pageProductData.expireTime }" type="date" />
			  	</p>
			  	<c:if test="${pageProductData.status==0 }"><div class="hbtn" style="float: left;">已停用 </div></c:if>
			  	<c:if test="${pageProductData.status==1 }"><div class="hbtn" style="float: left;">已启用 </div></c:if>
			  	<div style="float: left;line-height: 27px;height: 27px;margin-left: 5%;"><a href="${root }/product_manage/key/getAllProduct?menuNum=3" style="text-decoration: none;">服务管理</a></div>
	       	 </div>
			  </div>
			  </div>
		</c:if>
		<!-- 已开通 -->
			<c:if test="${pageProductData.status==3 }">
			 <div class="mesmain" style="height: 280px;margin-top: 20px;margin-bottom: 50px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u39.png">
			  </div>
			  <div  class="mes_mright">
			  <h1>在线咨询</h1>
				  <div class="zuoxi">
	        	<span style="float: left;margin-left: 0;"> 坐席数：三个坐席</span>
		        	<div style="clear: left;padding-top: 5%;">
		        	<div class="hbtn" style="float: left;">已开通 </div>
		        	</div>
	       		 </div>
			</div>
		 </div>
	</c:if>
	
	<!-- 未开通 -->
			<c:if test="${pageProductData.status==2}">
			 <div class="mesmain" style="height: 280px;margin-top: 20px;margin-bottom: 50px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u39.png">
			  </div>
			  <div  class="mes_mright">
			  <h1>在线咨询</h1>
				  <div class="zuoxi">
	        	<span style="float: left;margin-left: 0;"> 坐席数：三个坐席</span>
		        	<div style="clear: left;padding-top: 5%;">
		        	<div class="hbtn" style="float: left;">待开通 </div>
		        	</div>
	       		 </div>
			</div>
		 </div>
	</c:if>
		
		<!-- 未结算 -->
		<c:if test="${pageProductData.productPrice==1 }">
		 <div class="mesmain" style="height: 280px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u39.png">
			  </div>
			  <div  class="mes_mright">
			  <h1>在线咨询</h1>
				  <div class="zuoxi">
	        	<span style="float: left;margin-left: 0;"> 坐席数：三个坐席</span>
		        	<div style="clear: left;padding-top: 5%;">
		        	<div class="hbtn" style="float: left;">未结算 </div>
		        	<div class="zuoxihbtn jiesuan">结算</div>
		        	</div>
	       	 </div>
		</div>
	 </div>
	</c:if>
	
		<!-- 未付款 -->
		<c:if test="${pageProductData.noPayState==1 }">
		 <div class="mesmain" style="height: 280px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u39.png">
			  </div>
			  <div  class="mes_mright">
			  <h1>在线咨询</h1>
				  <div class="zuoxi">
	        	<span style="float: left;margin-left: 0;"> 坐席数：三个坐席</span>
		        	<div style="clear: left;padding-top: 5%;">
		        	<div class="hbtn" style="float: left;">未付款 </div>
		        	<div class="zuoxihbtn zhifu">支付</div>
		        	</div>
	       	 </div>
		</div>
	 </div>
	</c:if>
		</div>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>