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
<script src="${root}/view/js/minipage/back/compmanage/addClassCon.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />

<link rel="stylesheet" href="${root}/view/css/jquery-ui.css">
<script src="${root}/view/js/util/jquery-ui.js"></script>
<style type="text/css">
.input-medium{
	width: 200px;
	}
	</style>
<title>添加组件</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<div id="style">

</div>

<div class="current" style="color: #2b6db4 ;">当前位置：
<span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/comp_manage/key/searchComponent" target="frame_main" style="color: #2b6db4 ;">组件管理</a></span> <b>>></b>
<span><a href="${root}/component_class/key/toeditComClass?componentClassData.id=${componentClassData.id}&componentClassData.componentid=${componentData.id}" target="frame_main" style="color: #2b6db4 ;">修改组件样式风格</a> </span>
</div>
  <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
	<form  id="addComp" method="post" enctype="multipart/form-data" onsubmit="return checkSub($(this))"  action="${root}/component_class/key/addComponentClassData">
		<table style="width: 1060px;margin-left: 20px;" >
		<input type="hidden" value="${componentData.id}"  name="componentClassData.componentid"/>
		<input type="hidden" value="${componentClassData.id}"  name="componentClassData.id"/>
		<input type="hidden" value="${componentData.id}"  name="componentData.id"/>
		<input type="hidden" value="1"  name="componentClassData.Ident"/>
			<tr>
				<td>组件html源码：</td>
				<td colspan="3"><textarea style="width: 810px;resize: none;" class="clob" rows="6" cols="4" disabled="disabled">${componentData.clob}</textarea></td>
			</tr>
			<tr style="height: 30px;">
			<td></td>
			<td><span>请安W3C标准来填写css源码</span></td>
			</tr>
			
			<tr style="height: 30px;">
			<td>请填写以下样式</td>
			<td style="width: 300px;"colspan="3">
			<c:forEach items="${componentData.classNameList }" var="name">
			<lable style="color:red;font-weight: bold;font-size:14px;">${name}</lable>
			</c:forEach>
			</td>
			</tr>
			 <tr >
				<td>组件css源码：</td>
				<td style="width: 330px;">
				<textarea   rows="6" cols="4"  name="componentClassData.pcclassCon"   class='conpc' notnull="不能为空">${componentClassData.pcclassCon } </textarea>
				<input type="hidden" value="${componentClassData.pcclassCon }" class="csshelp">
				</td>
				<td>
				<textarea   rows="6" cols="4"  name="componentClassData.ipadClassCon"   class='conip' notnull="不能为空">${componentClassData.ipadClassCon } </textarea>
				</td>
				<td>
				<textarea   rows="6" cols="4"  name="componentClassData.phoneClassCon"   class='conphone' notnull="不能为空">${componentClassData.phoneClassCon } </textarea>
				</td>
			</tr>
			 <tr >
				<td></td>
				<td>
				<span>电脑样式</span><a  class="btn_tianjia yulan" style="margin-left: 5px;margin-bottom: 50px;"  data="1">预览</a>
				</td>
				<td><span>平板样式</span><a  class="btn_tianjia yulan" style="margin-left: 5px;margin-bottom: 50px;" data="2">预览</a>
				</td>
				<td>
				<span>手机样式</span><a  class="btn_tianjia yulan" style="margin-left: 5px;margin-bottom: 50px;" data="3">预览</a>
				</td>
			</tr>
			<tr>
				<td>样式风格&nbsp;&nbsp;&nbsp;</td>
				<td><input class="input-medium"  value="${componentClassData.classType}" style="height: 30px;" name="componentClassData.classType" type="text" placeholder="请输入样式风格" notnull="不能为空" id="csstype" /></td>
			</tr>
			<tr>
			<td>样式预览图</td>
			<td><input type="file" name="filePC" id="filePC"/></td>
			</tr>
			
		</table>
		<a  class="btn_tianjia" id="add" style="margin-left: 20px;margin-bottom: 50px;">修改</a>
	</form>
		<div id="dialog-message" title="预览">
	       <div style="display:none; "  class="" id="pwdDiv" >
			</div>
			</div>
</body>
</html>