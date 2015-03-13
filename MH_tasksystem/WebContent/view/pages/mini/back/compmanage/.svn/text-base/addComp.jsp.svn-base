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
<script type="text/javascript" src="${root}/view/js/minipage/back/compmanage/addComp.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<style type="text/css">
.input-medium{
	width: 200px;
	}
	.td1{
	width: 20%;
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
<span><a href="${root }/comp_manage/key/add" target="frame_main" style="color: #2b6db4 ;">添加组件</a> </span>
</div>
  <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
	<form  id="addComp" method="post" enctype="multipart/form-data" onsubmit="return checkSub($(this))"  >
		<table style="width: 90%;margin-left: 20px;" id="aaaa">
			<tr>
				<td class="td1">组件名称：</td>
				<td><input class="input-medium" style="height: 30px;"   name="componentData.name" type="text" placeholder="请输入组件名称名称" notnull="不能为空"/></td>
			</tr>
			<tr>
				<td class="td1">组件类型：</td>
				<td><select name="componentData.type" id="compType">
			 <s:iterator id="yy" value="#session.compType"> 	 			
			<option value="<s:property value="#yy.key"/>"><s:property value="#yy.value"/>	</option>
			</s:iterator>
		
			</select>
			
			</td>
			
			</tr>
			<tr style="height: 35px;">
			<td></td>
			<td><lable class='error' style='display:none;margin-left: 0px;'></lable></td>
			<tr>
			
			</tr>
			<tr>
				<td class="td1">组件价格：</td>
				<td><input class="input-medium" style="height: 30px;" name="componentData.price" type="text" placeholder="请输入组件价格"/></td>
			</tr>
			<tr>
				<td class="td1">组件html源码：</td>
				<td><textarea name="componentData.clob" class="clob" style="width: 657px;margin: 0px 0px 10px;height: 236px;resize: none;"></textarea></td>
			</tr>
			<!-- <tr class="tr_0" >
				<td>组件css源码：</td>
				<td>
				<textarea  id="css_0" rows="6" cols="4"  name="classHelp"  onchange="onchanges('0')" class='cons' notnull="不能为空"> </textarea>
				<input type='hidden'  name='componentClassData.Ident' value="0" >
				</td>
				<td>样式风格&nbsp;&nbsp;&nbsp;</td>
				<td><input class="input-medium" style="height: 30px;" name="componentClassData.classType" type="text" placeholder="请输入样式风格" notnull="不能为空" id="type_0" /></td>
			</tr>
			<tr class="addtr0" style="height: 40px;">
				<td></td>
				<td><button type="button" class="yulan" onclick="yulan('0')">预览</button> <button type="button"  onclick="add('0')">增加</button> 
				<input type='hidden' value='1' id='classId' name='componentClassData.id'>
				</td>
			</tr> -->
			<tr>
				<td>&nbsp</td>
				<td>&nbsp</td>
			</tr>
			<tr>
				<td class="td1">组件是否可重复出现：</td>
				<td><select name="componentData.multable" id="compResue">
				
			 <s:iterator id="yy" value="#session.compResue">
			 <s:if test="#yy.key==0">
			 	<option value="0"><s:property value="#yy.value"/>	</option>
			 </s:if>
			  <s:if test="#yy.key==1">
			 	<option value="Y"><s:property value="#yy.value"/>	</option>
			 </s:if>
			  <s:if test="#yy.key==2">
			 	<option value="N"><s:property value="#yy.value"/>	</option>
			 </s:if>
			</s:iterator>
			</select>
			
			</td>
			</tr>
			
			<tr style="height: 35px;">
			<td></td>
			<td><lable class='error1' style="display:none;margin-left:0px;"></lable></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>创建Page组件html页面源码：</td> -->
<!-- 				<td> -->
<!-- 					<textarea name="componentData.stepCode" class="stepClob1" rows="6" cols="4"></textarea> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>&nbsp</td> -->
<!-- 				<td>&nbsp</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>修改Page组件html页面源码：</td> -->
<!-- 				<td><textarea name="componentData.editCode" class="editClob1" rows="6" cols="4"></textarea></td> -->
<!-- 			</tr> -->
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="td1">修改page的html类型</td>
				<td>&nbsp;  </td>
				
			</tr>
			 <s:iterator id="ed" value="#session.editcode">
			 <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td> 
					  <s:if test="#ed.key==0">
					  <input type="checkbox" value="input"  name="componentData.editcode" class="checkEditCode" data="<s:property value="#ed.key"/>"/>
					 <lable style="margin-left:10px;"> <s:property value="#ed.value"/> 
					 <input type="text"  style="display: none;margin-left: 20px;height: 30px;" class="inputEditCode_<s:property value="#ed.key"/>" ></lable>
			 	      </s:if>
			 	       <s:if test="#ed.key==1">
					  <input type="checkbox" value="textarea" name="componentData.editcode" class="checkEditCode" data="<s:property value="#ed.key"/>"/>
					  <lable style="margin-left:10px;"> <s:property value="#ed.value"/> 
					  <input type="text"  style="display: none;margin-left: 20px;height: 30px;" class="inputEditCode_<s:property value="#ed.key"/>"></lable>
			 	      </s:if>
			 	       <s:if test="#ed.key==2">
					  <input type="checkbox" value="img" name="componentData.editcode" class="checkEditCode" data="<s:property value="#ed.key"/>"/>
					  <lable style="margin-left:10px;" > <s:property value="#ed.value"/>
					    <input type="text"  style="display: none;margin-left: 20px; height: 30px;" class="inputEditCode_<s:property value="#ed.key"/>"></lable>
					  
			 	      </s:if>
			 	      
			 	        <s:if test="#ed.key==3">
					  <input type="checkbox" value="navigation" name="componentData.editcode" class="checkEditCode" data="<s:property value="#ed.key"/>"/>
					  <lable style="margin-left:10px;" > <s:property value="#ed.value"/>
					    <input type="text"  style="display: none;margin-left: 20px; height: 30px;" class="inputEditCode_<s:property value="#ed.key"/>"></lable>
					  
			 	      </s:if>
			 	      </td>
			</tr>
			</s:iterator>
			<tr>
				<td class="td1">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="td1">模板风格</td>
				<td>
				<select name="componentData.cssType" id="cssType">
			 <s:iterator id="cs" value="#session.csstype">
			<option value="<s:property value="#cs.key"/>"><s:property value="#cs.value"/>	</option>
			</s:iterator>
			</select>
				</td>
			</tr>
			
			<tr style="height: 35px;">
				<td class="td1">&nbsp;</td>
				<td><lable class='error3' style='display:none;margin-left:0px;'></lable></td>
			</tr>
			<tr>
			<td class="td1">是否换背景图</td>
			<td>
			<select  name="componentData.uploadbgimg" id="uploadbgimg">
			<option value="2"  selected="selected">请选择</option>
			<option value="0">修改</option>
			<option value="1">不修改</option>
			</select>
			
			</td>
			</tr>
			<tr style="height: 35px;">
				<td class="td1">&nbsp;</td>
				<td><lable class='error2' style='display:none;margin-left:0px;'></lable></td>
			</tr>
			<tr>
			<td class="td1"> 主键布局样式名称</td>
			<td><input class="input-medium"  style="height: 30px;" name="componentData.cssId" type="text" placeholder="请输入主键布局样式名称" /></td>
			</tr>
			<tr>
				<td class="td1">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="td1">导航锚点名称</td>
			<td><input class="input-medium" style="height: 30px;" name="componentData.navId" type="text" placeholder="请输入导航锚点名称" /></td>
			</tr>
		</table>
		<a  class="btn_tianjia" id="add" style="margin-left: 20px;margin-bottom: 50px;">添加</a>
	</form>
	
	
	<div style=" display:none;width:100%;min-width:550px;clear:both;width: 550px;height:auto!important;margin-left: 750px;margin-top: -750px; box-shadow:2px 2px 30px #909090; position: absolute;" class="DataStatistics_1Title showDiv" >
	<a style="float: right;font-size: 25px;display: block;text-decoration: none;width: 30px;height: 40px;color: #000000;" class="close">x</a>	
	<div class="showClob" style=" display:none;width:100%;min-width:540px;clear:both;width: 540px;height:auto!important;"></div>
	</div>
</body>
</html>