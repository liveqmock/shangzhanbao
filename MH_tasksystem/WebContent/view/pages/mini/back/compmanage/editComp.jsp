<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/compmanage/editComp.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<style type="text/css">
.input-medium{
	width: 200px;
	}
	.td1{
	width: 20%;
	}
</style>
<title>修改组件</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<div class="current" style="color: #0044BB ;">当前位置：
<span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/comp_manage/key/searchComponent" target="frame_main">组件管理</a> </span><b>>></b>
<span><a href="${root}/comp_manage/key/getComponentByid?componentData.id=${componentData.id}" target="frame_main" style="color: #0044BB ;">修改组件</a> </span>
</div>
  <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
	<form  id="addComp" method="post"  onsubmit="return checkSub($(this))"  >
		<table style="width: 90%;margin-left: 20px;">
		<input type="hidden" value="${componentData.id}" id="comId" >
			<tr>
				<td class="td1">组件名称：</td>
				<td><input class="input-medium" style="height: 30px;" name="componentData.name" type="text" placeholder="请输入组件名称名称" notnull="不能为空"  value="${componentData.name}"/></td>
			</tr>
			<tr>
				<td class="td1">组件类型：</td>
				<td><select name="componentData.type" id="compType">
			 <s:iterator id="yy" value="#session.compType"> 
			 <s:if test="#yy.key==0">
			 	<option value="<s:property value="#yy.key"/>"  <c:if test="${componentData.type==0 }">selected="selected"</c:if> ><s:property value="#yy.value"/>	</option>
			 </s:if>
			  <s:if test="#yy.key==1">
			 	<option value="<s:property value="#yy.key"/>"  <c:if test="${componentData.type==1 }">selected="selected"</c:if> ><s:property value="#yy.value"/>	</option>
			 </s:if>
			  <s:if test="#yy.key==2">
			 	<option value="<s:property value="#yy.key"/>"  <c:if test="${componentData.type==2 }">selected="selected"</c:if> ><s:property value="#yy.value"/>	</option>
			 </s:if>
			  <s:if test="#yy.key==3">
			 	<option value="<s:property value="#yy.key"/>"  <c:if test="${componentData.type==3 }">selected="selected"</c:if> ><s:property value="#yy.value"/>	</option>
			 </s:if>
			</s:iterator>
		
			</select>
			</td>
			</tr>
			<tr style="height: 35px;">
			<td></td>
			<td><lable class='error' style='display:none;'></lable></td>
			</tr>
			<tr>
				<td class="td1">组件价格：</td>
				<td><input class="input-medium" style="height: 30px;" name="componentData.price" type="text" placeholder="请输入组件价格" value='${componentData.price}'/></td>
			</tr>
			<tr>
				<td class="td1">组件html源码：</td>
				<td><textarea name="componentData.clob" class="clob" style="width: 657px;margin: 0px 0px 10px;height: 236px;resize: none;">${componentData.clob}</textarea>
				</td>
			</tr>
			<c:forEach var="comClass" items="${componentData.classDatas}" varStatus="i">
			<tr>
				<td class="td1">样式风格&nbsp;&nbsp;&nbsp;</td>
				<td style="text-align: left;font-weight: bold;"><span style="float: left;line-height: 40px;margin-right:20px;">${comClass.classType}</span>
				<a  href="###"  class="btn_tianjia delete" style="margin-top: 10px;" data="${comClass.id}" >删除</a>
					<a  href="${root}/component_class/key/toeditComClass?componentClassData.id=${comClass.id}&componentClassData.componentid=${componentData.id}"  class="btn_tianjia update" style="margin-top: 10px;" data="${comClass.id}" >修改</a></td>
			</tr>
			</c:forEach>
			
			<tr style="height: 20px;">
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="td1">组件是否可重复出现：</td>
				<td><select name="componentData.multable" id="compResue">
				
			 <s:iterator id="yy" value="#session.compResue">
			 <s:if test="#yy.key==0">
			
			 	<option value="0" 
			 	 <c:if test="${componentData.multable==0 }">selected="selected"</c:if>
			 	 ><s:property value="#yy.value"/>	</option>
			 	
			 </s:if>
			  <s:if test="#yy.key==1">
			 	<option value="Y"  	 <c:if test="${componentData.multable eq 'Y' }">selected="selected"</c:if>><s:property value="#yy.value"/>	</option>
			 	</s:if>
			  <s:if test="#yy.key==2">
			 	<option value="N"  <c:if test="${componentData.multable eq 'N' }">selected="selected"</c:if>><s:property value="#yy.value"/>	</option>
			 	</s:if>
			</s:iterator>
			</select>
			</td>
			</tr>
			<tr style="height: 35px;">
			<td></td>
			<td><lable class='error1' style='display:none;margin-left: 0px;'></lable></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<!-- <tr>
				<td>修改page的html类型</td>
				<td>&nbsp;  </td>
				
			</tr> -->
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="td1">模板风格</td>
				<td>
				<select name="componentData.cssType" id="cssType">
			 <s:iterator id="cs" value="#session.csstype">
			 <s:if test="#cs.key==0">
			 	<option value="0" <c:if test="${componentData.cssType==0 }">selected="selected"</c:if> ><s:property value="#cs.value"/>	</option>
			 </s:if>
			  <s:if test="#cs.key==1">
			 	<option value="1" <c:if test="${componentData.cssType==1 }">selected="selected"</c:if>><s:property value="#cs.value"/>	</option>
			 </s:if>
			  <s:if test="#cs.key==2">
			 	<option value="2" <c:if test="${componentData.cssType==2}">selected="selected"</c:if>><s:property value="#cs.value"/>	</option>
			 </s:if>
			  <s:if test="#cs.key==3">
			 	<option value="3" <c:if test="${componentData.cssType==3}">selected="selected"</c:if>><s:property value="#cs.value"/>	</option>
			 </s:if>
			</s:iterator>
			</select>
				</td>
			</tr>
			<tr style="height: 35px;">
			<td></td>
			<td><lable class='error3' style='display:none;margin-left: 0px;'></lable></td>
			</tr>
			<tr>
			<td class="td1">是否换背景图</td>
			<td>
			<select  name="componentData.uploadbgimg" id="uploadbgimg">
			<option value="2"  <c:if test="${componentData.uploadbgimg==2 }">selected="selected"</c:if>>请选择</option>
			<option value="0" <c:if test="${componentData.uploadbgimg==0 }">selected="selected"</c:if>>修改</option>
			<option value="1" <c:if test="${componentData.uploadbgimg==1 }">selected="selected"</c:if>>不修改</option>
			</select>
			<lable class='error2' style='display:none;margin-left: 0px;'></lable>
			</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="td1">主键布局样式名称</td>
			<td><input class="input-medium"  style="height: 30px;" name="componentData.cssId" type="text" placeholder="请输入主键布局样式名称" value="${componentData.cssId }"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="td1">导航锚点名称</td>
			<td><input class="input-medium" style="height: 30px;" name="componentData.navId" type="text" placeholder="请输入导航锚点名称" value="${componentData.navId }"/></td>
			</tr>
		</table>
		<a  class="btn_tianjia" id="edit" data="${componentData.id}" style="margin-left: 20px;margin-bottom: 50px;">修改</a>
	</form>
			
</body>
</html>