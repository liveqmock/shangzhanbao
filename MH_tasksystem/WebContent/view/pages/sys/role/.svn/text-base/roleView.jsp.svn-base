<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css">
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>

<table style="width:100%;BORDER-COLLAPSE: collapse;margin:0px" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<tr>
		<td width="120" align="center">角色名称:</td>
		<td>${roleData.rolename}</td>
	</tr>
	<tr>
		<td width="120" align="center">角色描述:</td>
		<td>${roleData.description}</td>
	</tr>
	<tr>
		<td width="120" align="center">创建者:</td>
		<td>${roleData.creatorUserName}</td>
	</tr>
		<tr>
		<td width="120" align="center">创建时间:</td>
		<td><fmt:formatDate value='${roleData.createdate}' pattern='yyyy-MM-dd'/></td>
	</tr>
	<tr>
	<td width="120" align="center">继承关系:</td>
		<td></td>
	</tr>
	<tr>
		<td width="120" align="center">记录状态:</td>
		<td>
			<s:if test="%{roleData.status=='NORMAL'}" >可用</s:if>
			<s:else >注销</s:else>
        </td> 
	</tr>
</table>