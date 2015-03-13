<%@page import="com.mini.tempmanage.data.TemplateData"%>
<%@page import="java.util.List"%>
<%@page import="com.mini.front.tempmanage.facade.TempManageFacade"%>
<%@page import="javax.annotation.Resource"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/product/productList.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#time').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#time2').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
<title>服务管理</title>
</head>

<style>
 .TabTitle {
	width:100%;
	clear: both;
	height: 28px;
	overflow: hidden;
	border-bottom:4px solid #1386fe;
}
.TabTitle.active {
	background:url(../../../images/images_crb1.jpg) no-repeat left bottom;
	color:#fff;
	font-weight:bold;
	cursor:default;
}
.TabTitle li {
	float: left;
	width: 100px;
	height:28px;
	line-height:28px;
	cursor: pointer;
	padding: 0px;
	list-style-type: none;
	text-align:center;
	font-size:12px;
	color:#333;
	margin:0 3px 0 0;
}
.TabTitle ul {
	margin:0 0 0 18px;
	padding:0;
}
</style>
<body style="height:100%;border-top:1px solid #D5D5D5;">
		<form action="${root }/product/key/getAllProduct" class="well form-search" method="post" id="tempFrom">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
	<span><a href="${root }/product/key/getAllProduct?productData.status=1" target="frame_main">服务管理</a> </span> 
 </div>
<div class="wrapbg_gp">
  <div id="ContentDiv">
    <div class="User_TopSearch">
			<input type="hidden" name="searchType" value="1">
			<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td style="width: 70px">服务名称:</td>
					<td><input style="width: 120px" type="text" name="productData.name"   value="${param['productData.name']}"></td>
					<td style="width: 70px">创建时间:</td>
					<td><input id="time" style="width: 120px" type="text" name="productData.createTime" value="${param['productData.createTime']}">至
					<input style="width: 120px" id="time2" type="text" name="productData.overTime" value="${param['productData.overTime']}"></td>
					<td>
					<input  type="submit" value="" class="Btn_TopSearch" />
					</td>
				</tr>
			</table>
	</div>
</div>
</div>

	
	  	  <div class="" align="right" style="margin-right: 10px;margin-top: 5px;">
	  	   <span>排序：</span>&nbsp;&nbsp;&nbsp;&nbsp;
       <span><a  href="${root }/product/key/getAllProduct?sortTime=${sortTime eq 1?1:0 }">按上传时间</a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
      	</div>
      	
     

  <div id="ContentDiv">
    <div class="nTab"> 
    <input type="hidden" name="productData.status"  value="${productData.status}">
        <div class="TabTitle">
     		   <ul id="myTab00">
       		 <li 
       	 	 <c:if test="${productData.status==1 || productData.status==null}">class="active"</c:if>
       		 <c:if test="${productData.status!=1 }">class="normal"</c:if> 
       	 		value="1"  >全部</li> 
          	 <li 
            <c:if test="${productData.status==2}">	class="active"</c:if>
          	  <c:if test="${productData.status !=2}">class="normal"</c:if> 
          	  value="2"  >待开通</li> 
          	 <li 
          	  <c:if test="${productData.status==3}">class="active"	</c:if>
          	  <c:if test="${productData.status !=3}">class="normal"</c:if> 
          	   value="3"  >已开通</li> 
          	   	 <li 
          	  <c:if test="${productData.status==4}">class="active"	</c:if>
          	  <c:if test="${productData.status !=4}">class="normal"</c:if> 
          	   value="4"  >已关闭</li> 

		      </ul>
      </div>
 </div>
      <div class="TabContent">
   			 <div class="hm_content">
 
	<!-- <form action="" method="get" id="tempFrom"> -->
		 <table  width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
					<td width="40"><div class=""><input type="checkbox" name="ckboxs" id="ckboxs"  style="margin:9px 0 0 0"/></div></td>
				<td>编号</td>
				<td>服务名称</td>
				<td>创建时间</td>
				<td>状态</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
			<c:forEach var="productData" items="${list}" varStatus="i">
			<tr>
				<c:if test="${productData.status eq 'CLOSED' || productData.status eq 'WAIT'}">
				<td><input type="checkbox"  value="${productData.id}" class="cbox" name="ids">  </td>
				</c:if>
					<c:if test="${productData.status eq 'OPEN'}"><td>&nbsp; </td></c:if>
				
				<td>${i.index+1}</td>
				<td>${productData.name }</td>
				<td><fmt:formatDate value="${productData.createTime }" type="date"/> </td>
				<td>${productData.status }</td>
				<td> ${productData.price }</td>
				<td>
				<c:if test="${productData.status eq 'CLOSED' || productData.status eq 'WAIT'}">
				<a href="${root }/product/key/getProductDataView?productData.id=${productData.id}">修改</a>
				</c:if>
					<c:if test="${productData.status eq 'OPEN'}">
						<a href="##"  id="closedProduct" onclick="closedProduct('${productData.id}')">关闭</a>
					</c:if>
					<c:if test="${productData.status eq 'CLOSED'}">
						<a href="##"  id="openProduct"  data="${productData.id}">启用</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
		<page:PageRoll/>
						</div>
					</div>
				</div>
				
	
  <span><a href="${root}/view/pages/mini/back/product/productAdd.jsp" class="btn_tianjia" id="" >增加</a>&nbsp;<a href="###" class="btn_tianjia" id="deleteProduct">删除</a></span>  
	</form>
</body>
</html>