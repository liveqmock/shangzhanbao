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
<input type="hidden" name="userData.id" id="id" value="${userData.id}" />
<input type="hidden" name="userData.creator" value="${userData.creator}"/>
<input type="hidden" name="userData.password" value="${userData.password}" />
<input type="hidden" name="userData.create_time" value="${userData.create_time}"/>
<table width="98%" style="BORDER-COLLAPSE: collapse" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<tr>
		<td width="120">用户名<font color="#FF0000">(*)</font></td>
		<td width="410">
			<input type="text" name="userData.account" id="account" required="true"
               value="${userData.account}" missingMessage="必填" class="easyui-validatebox" style="width:80%" />
        </td>
		<td width="120">用户名称<font color="#FF0000">(*)</font></td>
	    <td width="410">
	    	<input type="text" name="userData.name" id="userData.name" required="true"
	           value="${userData.name}" missingMessage="必填" class="easyui-validatebox" style="width:80%" />
	    </td>
	</tr>
	<tr>
		<td width="120">电话号码</td>
    	<td width="410">
    		<input type="text" name="userData.telephone" id="userData.telephone" style="width:80%"
    	  		value="${userData.telephone}" class="easyui-validatebox" validType="phone" />
    	</td>
		<td width="120">手机号码</td>
		<td width="410">
			<input type="text" name="userData.mobile" id="userData.mobile" style="width:80%"
				value="${userData.mobile}" class="easyui-validatebox" validType="mobile" />
		</td>
	</tr>
	<tr>
		<td width="120">Email地址</td>
		<td width="410">
			<input type="text" name="userData.email" id="userData.email" style="width:80%"
				value="${userData.email}" class="easyui-validatebox" validType="email" />
		</td>
		<td width="120">用户状态</td>
		<td width="410">
        	<select name="userData.user_status" id="userData.user_status" style="width:80%">
                <option value="normal"
                  <c:if test="%{userData.user_status='normal'}">selected="selected"</c:if>	>正常
                </option>
                <option value="locked"
                  <c:if test="%{userData.user_status='locked'}">selected="selected"</c:if>	>锁定</option>
            </select>
        </td>
	</tr>
	<tr>
		<td width="120">所在机构<font color="#FF0000">(*)</font></td>
		<td>
            <select name="userData.org_id" id="userData.org_id" style="width:80%"
                class="easyui-validatebox"  required="true" missingMessage="必选" >
                <option value="">请选择</option>
                <c:forEach var="org" items="${orgList}"  >
		 			<option value="${org.id}" 
		 			   <c:if test="${userData.org_id==org.id}">selected="selected"</c:if> >${org.orgnamedefault}
		 			</option>
		   		</c:forEach>
            </select>
		</td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td width="120">角色<font color="#FF0000">(*)</font></td>
		<td colspan="3">
			<c:forEach var="role" items="${roleList}"  >
		 		<input name="userRoleS"  value="${role.id}" type="checkbox"
		 			<c:forEach var="userRole" items="${userRoleList}">
		 				<c:if test="${role.id == userRole}">checked</c:if>
		 			</c:forEach>
		 		/>${role.rolename}
		    </c:forEach>
		</td>
	</tr>
	<tr>
		<td width="120">备注</td>
		<td colspan="3">
		<textarea rows="5" cols="45"name="userData.remark" id="userData.remark"  style="width: 90%"></textarea>
	</tr>
	<tr>
		<td align="center" colspan="4">
		<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0);" onClick="saveEditUser()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-no" href="javascript:void(0);" onClick="cancel()">取消</a></td>
	</tr>
</table>
</form>
</body>
</html>