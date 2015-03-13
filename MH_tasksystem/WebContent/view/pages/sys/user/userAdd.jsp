<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<html>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css"></link>
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/user/userList.js"></script>
<script type="text/javascript" src="${root}/view/easyUI/js/easyui-validator.js"></script>
<body>
<form id="userForm">
<table width="98%" style="BORDER-COLLAPSE: collapse" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<tr>
		<td width="120">用户名<font color="#FF0000">(*)</font></td>
		<td width="410">
			<input type="text" name="userData.account" id="account" required="true"
                   missingMessage="必填" class="easyui-validatebox" style="width:80%" /></td>
		<td width="120">用户姓名<font color="#FF0000">(*)</font></td>
    	<td width="410">
    		<input type="text" name="userData.name" id="name" required="true"
                   missingMessage="必填" class="easyui-validatebox" style="width:80%" /></td>
	</tr>
	<tr>
		<td width="120">密码<font color="#FF0000">(*)</font></td>
    	<td width="410">
    		<input type="text" name="userData.password" id="password" style="width:80%"
    	  		required="true" missingMessage="必填" class="easyui-validatebox"/>
    	</td>
		<td width="120">电话号码</td>
    	<td width="410">
    		<input type="text" name="userData.telephone" id="telephone" style="width:80%"
    	  		class="easyui-validatebox" validType="phone" />
    	</td>
	</tr>
	<tr>
		<td width="120">手机号码</td>
		<td width="410">
			<input type="text" name="userData.mobile" id="mobile" style="width:80%"
				 class="easyui-validatebox" validType="mobile" />
		</td>
		<td width="120">用户状态</td>
		<td width="410">
        	<select name="userData.user_status" id="user_status" style="width:140">
                <option value="normal">正常</option>
                <option value="locked">锁定</option>
            </select>
        </td>
	</tr>
	<tr>
		<td width="120">所在机构<font color="#FF0000">(*)</font></td>
		<td>
            <select name="userData.org_id" id="org_id" style="width:80%"
                class="easyui-validatebox" required="true" missingMessage="必选" >
                <option value="">请选择</option>
                <c:forEach var="org" items="${orgList}"  >
		 			<option value="${org.id}">${org.orgnamedefault}</option>
		   		</c:forEach>
            </select>
		</td>
		<td width="120">Email地址</td>
		<td width="410">
			<input type="text" name="userData.email" id="email" style="width:80%"
				 class="easyui-validatebox" validType="email" />
		</td>
	</tr>
	<tr>
		<td width="120">角色<font color="#FF0000">(*)</font></td>
		<td colspan="3">
			<c:forEach var="role" items="${roleList}"  >
		 		<input name="userRoleS"  value="${role.id}" type="checkbox" />${role.rolename}
		    </c:forEach>
		</td>
	</tr>
	<tr>
		<td width="120">备注</td>
		<td colspan="3">
		<textarea rows="5" cols="45" name="userData.remark" id="remark" style="width:90%"></textarea>
	</tr>
	<tr>
		<td align="center" colspan="4">
		<a class="easyui-linkbutton" iconCls="icon-ok" href="#" onClick="saveTaskOper();return false;">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-no" href="#" onClick="cancel();return false;">取消</a></td>
	</tr>
</table>
</form>
</body>
</html>