<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css">
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/easyUI/js/easyui-validator.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/role/roleInfo.js"></script>
<form id="roleForm">
<table style="width:90%;BORDER-COLLAPSE:collapse;margin:0px" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<tr>
		<td width="150">角色名称<font color="#FF0000">(*)</font></td>
		<td>
           <input name="roleData.rolename" id="roleData.rolename" class="easyui-validatebox" 
             type="text" required="true" missingMessage="必填" validType="maxLength[50]" style="width:98%;" />
        </td>
	</tr>
	<tr>
		<td width="150">角色描述:</td>
		<td>
			<input type="text" name="roleData.description" id="roleData.description" style="width:98%;" />
		</td>
	</tr>
	<tr>
	<td width="150">继承关系:</td>
		<td>
			<select id="roleData.extend" name="roleData.extend" width="98%" disabled="disabled" > 
				<option value="">无</option>
			</select>
	   	</td>
	</tr>
		<tr>
		<td width="150">记录状态:</td>
		<td>
        	 <select id="roleData.status" name="roleData.status" width="98%"> 
                    <option value="NORMAL"  >可用</option>
                    <option value="DELETED">不可用</option>
              </select>
        </td>
	</tr>
	<tr>
		<td align="center" colspan="3">
		<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0);" onclick="saveRole()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-no" href="javascript:void(0);" onclick="closeWindow()">取消</a></td>
	</tr>
</table>
</form>