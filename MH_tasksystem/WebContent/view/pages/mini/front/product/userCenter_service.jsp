<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>服务管理 - 商站宝</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"	src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript"	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/product/productList.js" ></script>

<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<style type="text/css">
.bustd{
font-weight:600;
}
.font_hei{
	font: 15px "Hevetica Neve",Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;
	color: #333;
}
</style>
</head>
<body>

<div class="head"></div>
<a href="###" id="myOpDiv" style="display:none;">启用</a>
<a href="###" id="myDisDiv" style="display:none;">禁用</a>
<a href="###" id="myOpDisDiv" style="display:none;">是否禁用</a>
<a href="###" id="myDiv" style="display:none;">停用成功</a>
<a href="###" id="myqiDiv" style="display:none;">启用成功</a>
<div class="content">
<%@include file="/left.jsp"%> 
<form action="${root }/product_manage/key/getAllProduct?menuNum=3" method="post">
	<div class="UserCenter_Right"  style="float: ;margin-left: 30px;">
  		<input type="hidden" class="productId" name="pageProductData.id">
    	<input type="hidden" class="pageId" >
    	<input type="hidden" class="pageProductId">
 		<c:if test="${list!='[]'}">
    	<div class="DataStatistics_1">
      		<div class="DataStatistics_1Title">
        		<h1>可用服务</h1>
      		</div>
      		<div class="widget-content" >
        		<table class="table">
          			<thead>
            			<tr>
              				<th>商站名称</th>
              				<th width="55">logo</th>
              				<th>服务名称 </th>
             				<th width="160">有效期</th>
               				<th width="190">操作</th>
            			</tr>
          			</thead>
          			<tbody>
             		<c:forEach var="pageProductData" items="${list }" varStatus="status">
          			<c:set value="0" var="sum" />
          			<c:forEach var="data" items="${list }" varStatus="s">
          				<c:if test="${data.pageId == list[status.index].pageId}">
          				<c:set value="${sum+1 }" var="sum" />
          				</c:if>
          			</c:forEach>
               		<c:if test="${pageProductData.decide==1}">
		            	<tr>
		            		<c:if test="${status.index == 0}">
		            		<td rowspan="${sum }">
		              			<span class="font_hei" >
		              			<c:if test="${pageProductData.pageData.pageInfoExtra.domain != null && pageProductData.pageData.pageInfoExtra.domain!=''}">
		              			<a class="font_hei" style="word-wrap: break-word;width: 100px;display: block;margin: 0 auto;" target="_blank" href="${path}${pageProductData.pageData.pageInfoExtra.domain }?a=<%=new Date()%>">${pageProductData.pageData.name }</a>
		             			</c:if>
		              			<c:if test="${pageProductData.pageData.name==null }"><lable style="color: red;"> 未设置名称</lable></c:if>
		              			</span>
		              		</td>
		              		</c:if>
		            		<c:if test="${status.index > 0 && pageProductData.pageData.id != list[status.index-1].pageData.id}">
		            		<td rowspan="${sum }" >
		              			<span class="font_hei" >
		              			<c:if test="${pageProductData.pageData.pageInfoExtra.domain != null && pageProductData.pageData.pageInfoExtra.domain!=''}">
		              			<a class="font_hei" target="_blank"style="word-wrap: break-word;width: 100px;display: block;margin: 0 auto;" href="${path}${pageProductData.pageData.pageInfoExtra.domain }?a=<%=new Date()%>">${pageProductData.pageData.name }</a>
		             			</c:if>
		              			<c:if test="${pageProductData.pageData.name==null }"><lable style="color: red;"> 未设置名称</lable></c:if>
		              			</span>
		              		</td>
		              		</c:if>
		              		<td>
		              			<span class="" style="width:35px;height:35px;float:right;overflow:hidden;padding:1px;padding:0;margin-right:7px;">
		              			<c:if test="${pageProductData.productData!=null && pageProductData.productData.image!=null && pageProductData.productData.image!='' }">
		              			<c:if test="${pageProductData.productData.type==1 }">
		              			<img alt="" src="${root }/images/mini/images/message1.png" style="width: 100%; height: auto;"/> 
		              			</c:if>
		              			<c:if test="${pageProductData.productData.type==2 }">
		              			<img alt="" src="${root }/images/mini/images/Incoming-Call1.png" style="width: 100%; height: auto;"/> 
		              			</c:if>
		              			<c:if test="${pageProductData.productData.type==5 }">
		              			<img alt="" src="${root }/images/mini/images/talk991.png" style="width: 100%; height: auto;"/> 
		              			</c:if>
		              			<c:if test="${pageProductData.productData.type==6 }">
		              			<img alt="" src="${root }/images/mini/purchase/buy/buy_meitu_3.jpg" style="width: 100%; height: auto;"/> 
		              			</c:if>
		              			</c:if>
		              			<c:if test="${pageProductData.productData==null || pageProductData.productData.image==null || pageProductData.productData.image=='' }">
		              			<img alt="" src="${root }/view/model/images/zanwu.jpg" style="width: 100%; height: auto;"/>
		              			</c:if>
		              			</span>
		              		</td>
		              		<td>
		              			<span class="span6">${pageProductData.productName }</span>
		              		</td>
		              		<td>
		              			<span class="font_EN">
		              			<c:if test="${pageProductData.productData.price == null || pageProductData.productData.price == '' || pageProductData.productData.price == 0}">
		              			永久
		              			</c:if>
		             			<c:if test="${pageProductData.productData.price != null && pageProductData.productData.price != '' && pageProductData.productData.price != 0}">
		              			<fmt:formatDate value="${pageProductData.createTime}" pattern="yyyy.MM.dd"/>
		              			-
		               			<fmt:formatDate value="${pageProductData.expireTime}" pattern="yyyy.MM.dd"/>
		              			</c:if>
		             			</span>
		             		</td>
		              		<!-- 正常使用 -->
		              		<td id="shiyongzhong${i.index }" style="display: ${pageProductData.decide==1 && pageProductData.status==1?'black':'none'}"><span class="span3" style="width:30px;"></span><span class="span1"><a style="text-decoration: none;" href="#">使用中</a></span>
		                 		<span id="tingyong${i.index }" style="display: ${pageProductData.status==1?'black':'none'}" class="span4">
		                 		<a href="###" onclick="extraUpdate('${pageProductData.id}','${pageProductData.count}','${pageProductData.productData.type}', '${pageProductData.pageData.id }','${pageProductData.pageData.pageInfoExtra.domain }','${status.index}' )" class=" font_blue">停用</a>
		                 		</span>
							</td>
							<!-- 30天到期 -->
							<td id="xufei${i.index }" style="display: ${pageProductData.decide==3 && pageProductData.status==1?'black':'none'}">
								<span class="span3" style="width:30px;">30天到期</span>
								<span class="span2">
									<a href="#">续费</a>
								</span>
		                        <span id="tingyongxufei${i.index }" style="display: ${pageProductData.status==1?'black':'none'}" class="span4">
		                        	<a href="###" onclick="extraUpdate('${pageProductData.id}','${pageProductData.count}','${pageProductData.productData.type}, '${pageProductData.pageData.id } ','${pageProductData.pageData.pageInfoExtra.domain }','${status.index}')" class=" font_blue">停用</a>
		                        </span>
		              		</td>
							<!-- 启用 -->
							<td id="qiyong${i.index }" style="display: ${pageProductData.status==0 || pageProductData.status==3?'black':'none'}">
								<span class="span3" style="width:30px;"></span>
								<span class="span2"> 
		                        	<a href="#" class=" font_blue" onclick="openPageproduct('${pageProductData.id}','${pageProductData.productData.type}','${pageProductData.pageId }','${pageProductData.productData.name}','${pageProductData.pageData.pageInfoExtra.domain }','${status.index}')">启用</a>
		                        </span>
		                 	</td>
							<!-- 等待开通 -->	
							<td id="dengdaikaitong${i.index }" style="display: ${pageProductData.status==2?'black':'none'}"> 
								<span class="span3" style="width:30px;"></span>
								<span class="span1">
									<a href="#">等待开通</a>
								</span>
							</td>
            			</tr>
            		</c:if>
           			</c:forEach>
          			</tbody>
       			</table>
      		</div>
      		<page:PageRoll  />
    	</div>
    	</c:if>
     	<c:if test="${list == '[]'}">
      	<div class="DataStatistics_box" style="margin-bottom: 20px;">
        	<h1> 您还没有选用服务 !</h1>
      	</div>
   		</c:if> 
	</div>
</form>
</div>
<div class="footer"></div>
<input  type="hidden" value="" id="pageProductDataId">
<input  type="hidden" value="" id="pageIdDiv">
<input  type="hidden" value="" id="changDis">
<div  id="selDis" style="display: none;">${sel}</div>
<input type="hidden"  id="padomain" value="">
<%@include file="/mini_end.jsp"%>
</body>
</html>