<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<title>添加服务</title>
<link rel="stylesheet" media="screen,projection" type="text/css" href="${root}/view/css/ctn.css" />
<script type="text/javascript" src="${root }/view/js/timepicker/jquery-ui-1.9.1.custom.js"></script>
<script type="text/javascript" src="${root }/view/js/timepicker/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script charset="utf-8" src="${root}/view/js/kindeditor-master/kindeditor.js"></script>
<script type="text/javascript" src="${root}/view/js/ctn/common/upload-img.js"></script>
<script type="text/javascript" src="${root}/view/js/common/select.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/product/productEdit.js"></script>
<script type="text/javascript" src="${root }/view/js/common/datepicker.js"></script>

  
</head>
<body>
<div class="wrapbg_gp">
<%--   --%>
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a> <b>>></b> 
  <span><a href="${root }/product/key/getAllProduct" target="frame_main">服务产品管理</a></span> <b>>></b> 
  <span> <a href="#" >服务添加</a></span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
	<form id="productForm" method="post">
		<table id="mytable1" width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
				<input type="hidden" value="${productData.id}" name="${productData.id}" id="pId">
				<input type="hidden" value="${productData.name}"  class="getProductName">
			<tr>
			
				<td width="80" >服务名称：</td>
			
				<td><input type="text" name="productData.name" value="${productData.name}" trim="" class="input_bor "  size="30" maxLength="60"  notnull="服务名称不能为空"  max="60" readonly="readonly"/><font color="red">*</font></td>
			</tr>
			
				<tr>
                <td colspan="2">&nbsp;</td>
            </tr>
			<tr>
				<td>价格</td>
				<td>
				       <input style="width: 179px;" type="text" id="price" data-placement="top" name="productData.price" value="${productData.price}"  class="input_bor" size="10" max="8"  num="填写小数或整数"/><font color="red">*</font>
				      
				 </td>
			</tr>	 
			
			<tr>
				<td>年限</td>
				<td>
				       <input  style="width: 179px;" type="text" id="yearNum" data-placement="top" name="productData.yearNum" value="${productData.yearNum}"  class="input_bor"  notnull="年限不能为空" num="填写小数或整数" onblur="formatTime()"/><font color="red">*</font>
				     
				 </td>
			</tr>	 
			
			
			<tr>
				<td>到期时间</td>
				<td> 
				 <input type="text" style="width: 179px;" name="productData.overTime"  value="<fmt:formatDate value="${productData.overTime}" type="date"/> "  class="datepickers" size="20" notnull="时间不能为空"  readonly="readonly"/><font color="red">*</font>
				</td>
			</tr>
			
			
		
			<tr>
				<td><input type="hidden" id="person" value="" />
				       <input type="hidden" id="tell" value="" /> 
				       <input type="hidden" id="mail" value="" />
				</td>
				<td>
				      <div class="btn_red" style="margin:0 10px; float:left"><a href="###" id="finish" >完 成</a></div>
                    
                      <div class="btn_hui" style="margin:0 10px; float:left"><a href="javascript:history.go(-1)"  >取消</a></div>
				 </td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	<div class="clear"></div>
	     <br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>