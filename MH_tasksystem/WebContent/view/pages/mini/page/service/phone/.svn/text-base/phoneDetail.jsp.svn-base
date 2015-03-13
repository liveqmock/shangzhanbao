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
<title>拨打销售电话</title>
<script type="text/javascript">
	/**
	 *修改销售电话
	 **/
	function editPhone(){
		var phone = $("#phone").val();
		var id = $("#id").val();
		var pageId = $("#pageid").val();
		var oldPhone = $("#phone").attr("oldPhone");
		if(!isphone(phone)){//判断电话是否合法
			alert("电话输入错误！");
			return;
		}
		$.ajax({		
			type : "POST",
			url : root + '/product_manage/key/editProductPagePhone',
			data : "pageProductData.id="+id+"&pageId="+pageId+"&phone="+phone+"&oldPhone="+oldPhone,
			success : function() {
				location.reload();
			}
		});
	}
	/**
	 * 启用电话服务
	 **/
	function enablePhone(){
		var phone = $("#phone").val();
		var id = $("#id").val();
		var pageId = $("#pageid").val();
		$.ajax({		
			type : "POST",
			url : root + '/product_manage/key/updateProductPagePhone',
			data : "pageProductData.id="+id+"&pageId="+pageId+"&phone="+phone,
			success : function() {
				location.reload();
			}
		});
	}
	/*判断输入是否为合法的电话号码，匹配固定电话或小灵通*/
	function isphone(inpurStr){
//		var partten = /^(1[3,5,8,7]{1}[\d]{9})|(((400)([\s]{0,}|[-, ])(\d{3})([\s]{0,}|[-, ])(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{3,7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;
//		var partten =/^\d+$/;
//		if(partten.test(inpurStr)){
			return true;
//		}else{
//			return false;
//		}
	}
</script>
</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>
		<div class="UserCenter_Right">
		
		  <div class="mesTi">
		     <div class="h1Div"> <h1>
		  ${pageName}
		    <c:if test="${pageName==''}">未设置名称</c:if>
		     </h1></div>
		   <a href="${root }/page_manage/key/getAllPaga?menuNum=1"> <img alt="" src="${root}/view/images/product/u53.png"></a>
		    </div>
		    
		    <div class="mesmain" style="height: 300px;">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/view/images/product/image_u31.png">
			  </div>
			  <div  class="mes_mright">
			  	<h1>拨打销售电话</h1>
			  	<p>有效期：永久</p>
			  	<input type="text" style="display: none;" id="pageid" value="${pageProductData.pageId }"/>
				<input type="text" style="display: none;" id="id" value="${pageProductData.id }"/>
			  	<c:if test="${messtatus==1}">
			  	<div class="hbtn" style="float: left;">已启用 </div>
			  	<div style="float: left;line-height: 27px;height: 27px;margin-left: 5%;"><a href="${root }/product_manage/key/getAllProduct?menuNum=3" style="text-decoration: none;">服务管理</a></div>
			 	<div style="clear: left;padding-top: 20px;">
			 	   <div class="inputDiv">
			 		<input type="text" style="width: 250px; height: 33px; font-size: 18px;border: solid #0099CC 1px; " name="phoneNum" oldPhone="${phoneNum }" id="phone" value="${phoneNum }" />
			  		</div>
			  		<div class="btnDiv">
			  		<input onclick="editPhone()" type="button"  value="保存" />
			  		</div>
			  	</div>
			  	</c:if>
			  	
			  	<c:if test="${messtatus==0}">
			  	<div class="hbtn">已停用</div>
			  	<div style="clear: left;padding-top: 20px;">
			 	   <div class="inputDiv">
			 		<input type="text" style="width: 250px; height: 33px; font-size: 18px;border: solid #0099CC 1px; " name="phoneNum" oldPhone="${phoneNum }" id="phone" value="${phoneNum }" />
			  		</div>
			  		<div class="btnhDiv">
			  		<input onclick="enablePhone()"  value="启 用" />
			  		</div>
			  	</div>
			  	</c:if>
			  	</div>
			  </div>
			  
		</div>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>