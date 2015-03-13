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
<script type="text/javascript" src="${root}/view/js/minipage/back/product/productAdd.js"></script>
<script type="text/javascript" src="${root }/view/js/common/datepicker.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />

  
</head>
<body>
<div class="wrapbg_gp">
<%--   --%>
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
  <span><a href="${root }/product/key/getAllProduct?productData.status=1"  target="frame_main">服务管理</a></span> <b>>></b> 
  <span> <a href="${root}/view/pages/mini/back/product/productAdd.jsp"  target="frame_main" >服务添加</a></span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
	<form id="productForm" method="post" enctype="multipart/form-data">
		<table id="mytable1" width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
			
			<tr>
				<td width="80" >服务名称：</td>
				<td><input type="text" name="productData.name"  trim="" class="input_bor" size="30" maxLength="60"  notnull="服务名称不能为空"  max="60" /><font color="red">*</font></td>
			</tr>
			
				<tr>
                <td colspan="2">&nbsp;</td>
            </tr>
			<tr>
				<td>价格</td>
				<td>
				       <input style="width: 179px;" type="text" id="price" data-placement="top" name="productData.price" value="${productData.price}"  class="input_bor" size="10" max="8" notnull="价格不能为空" num="填写小数或整数"/><font color="red">*</font>
				      
				 </td>
			</tr>	 
			
			<tr>
				<td>年限</td>
				<td>
				       <input  style="width: 179px;" type="text" id="yearNum" data-placement="top" name="productData.yearNum" value="${productData.yearNum}"  class="input_bor"  notnull="年限不能为空" num="填写小数或整数" onBlur="formatTime()"/><font color="red">*</font>
				     
				 </td>
			</tr>	 
			
			
			<tr>
				<td>到期时间</td>
				<td> 
				 <input type="text" style="width: 179px;" name="productData.overTime"  value=""  class="datepickers" size="20" notnull="时间不能为空" readonly="readonly"/><font color="red">*</font>
				</td>
			</tr>

			<tr>
				<td>选择类型</td>
				<td> 
				<select name="productData.type" id="Type">
				<option value="0">请选择类型</option>
				<option value="1">talk99</option>
				<option value="2">在线质询</option>
				<option value="3">实名网站认证</option>
				<option value="4">在线客服</option>
				<option value="5">其他类型</option>
				<option value="6">购买</option>
				</select>
				</td>
			</tr>
			<tr>
			<td>服务图标</td>
					<td>
				<input style="width: 250px;height: 30px" type="file" name="fileMain" />
				</td>
			</tr>
		<tr style="height: 20px;"></tr>
			<tr>
				<td><input type="hidden" id="person" value="" />
				       <input type="hidden" id="tell" value="" /> 
				       <input type="hidden" id="mail" value="" />
				</td>
				<td>
				      <div class="btnlan" style="margin:0 10px; float:left"><a href="###" id="finish" >完 成</a></div>
                    
                      <div class="btnhui" style="margin:0 10px; float:left"><a href="javascript:history.go(-1)"  >取消</a></div>
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