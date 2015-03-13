<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css"></link>
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/util/form2json.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgList.js"></script>
</head>
<body>
<h2 align="center">${orgData.orgnamedefault}</h2>
<input type="hidden" id="orgID" value="${orgData.id}">
<input type="hidden" id="orgName" value="${orgData.orgnamedefault}"/>
<table style="BORDER-COLLAPSE: collapse" width="98%" borderColor=#A4CDF2 cellpadding="10" border="1" align="center">
	<tr>
		<td width="120"  align="center">机构名称</td>
		<td width="300">${orgData.orgnamedefault}</td>
		<td width="120"  align="center">机构简称</td>
		<td>${orgData.orgshortname}</td>
	</tr>
	<tr>
		<td width="120" align="center">部门主管</td>
		<td width="300">${orgData.daptManagerName}</td>
		<td width="120" align="center">部门分管</td>
		<td>${orgData.deptDeputyManagerName}</td>
	</tr>
	<tr>
		<td width="120" align="center">机构中文名称</td>
		<td width="300">${orgData.orgname_cn}</td>
		<td width="120" align="center">机构英文名称</td>
		<td>${orgData.orgname_us}</td>
	</tr>
	<tr>
		<td width="120"  align="center">父机构名称</td>
		<td width="300">${orgData.parentName}</td>
		<td width="120" align="center">机构排序</td>
		<td>${orgData.taxis}</td>
	</tr>
	<tr>
		<td width="120" align="center">联系人</td>
		<td width="300">${orgData.linkman}</td>
		<td width="120" align="center">联系电话</td>
		<td>${orgData.telephone}</td>
	</tr>
	<tr>
		<td width="120" align="center">联系地址</td>
		<td width="300">${orgData.address}</td>
		<td width="120" align="center">邮政编码</td>
		<td>${orgData.postcode}</td>
	</tr>
	<tr>
		<td width="120"  align="center">传真号码</td>
		<td width="300">${orgData.fax}</td>
		<td width="120"  align="center">记录状态</td>
		<td>${orgData.rowstatus}</td>
	</tr>
	<tr>
		<td width="120" align="center">备注</td>
		<td colspan="3">${orgData.remark}</td>
	</tr>
	<tr>
		<td width="120" align="center">机构编号</td>
		<td width="300">${orgData.orgcode}</td>
		<td width="120" align="center">机构类型</td>
		<td>
			<s:if test="%{orgData.catalog==1}">职能部门</s:if>
			<s:elseif test="%{orgData.catalog==2}">业务部门</s:elseif>
			<s:else></s:else>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="7">
		<a class="easyui-linkbutton" iconCls="icon-add" href="javascript:void(0);" onClick="addChildOrg()">增加子机构</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" href="javascript:void(0);" onClick="editChildOrg()">编辑当前机构机构</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0);" onClick="delChildOrg()">删除</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>