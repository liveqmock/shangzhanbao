<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css"></link>
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/task/taskOrg/taskOrgInfo.js"></script>
<script type="text/javascript" src="${root}/view/easyUI/js/easyui-validator.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgList.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgIndex.js"></script>
<body>
<table>
<tr><td colspan="1"><h3>新增机构</h3></td></tr>
</table>
<form id="orgForm">
<input type="hidden" name="orgData.parentid" id="id" value="${orgData.id}" />
<table width="98%" style="BORDER-COLLAPSE: collapse" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<c:if test="${null!=orgData.id && ''!=orgData.id }"> 
	  <tr>
	   	<td width="120">上级机构</td>
	   	<td colspan="3" >
       		<input style="width: 95%" type="text" id="parentName" value="${orgData.orgnamedefault}" readonly>
       	</td>
      </tr>
	</c:if>
	 <tr>
		<td width="120">机构名称<font color="#FF0000">(*)</font></td>
		<td width="374" >
			<input style="width: 92%" type="text" name="orgData.orgnamedefault" id="orgData.orgnamedefault"
				required="true"  missingMessage="必填" class="easyui-validatebox"	>
		</td>
		<td width="120" >机构简称<font color="#FF0000">(*)</font></td>
		<td width="350" ><input style="width: 92%" type="text" name="orgData.orgshortname" id="orgData.orgshortname"></td>
	</tr>
	 <tr>
		<td width="120" >机构中文名称<font color="#FF0000">(*)</font></td>
      <td><input style="width: 92%" type="text" name="orgData.orgname_cn" id="orgData.orgname_cn" ></td>
		<td width="120" >机构英文名称</td>
		<td>
			<input style="width: 92%" type="text" name="orgData.orgname_us" id="orgData.orgname_us" 
				class="easyui-validatebox" validType="english" >
		</td>
	</tr>
	 <tr>
		<td width="120" >联系人</td>
      <td><input style="width: 92%" type="text" name="orgData.linkman" id="orgData.linkman" /></td>
		<td width="120" >联系电话</td>
		<td>
			<input style="width: 92%" type="text" name="orgData.telephone" id="orgData.telephone" 
				 class="easyui-validatebox" validType="phoneOrMobile"	/>
		</td>
	</tr>
	 <tr>
		<td width="120" >联系地址</td>
	   <td colspan="3"><input style="width: 95%" type="text" name="orgData.address" id="orgData.address" /></td>
	</tr>
	 <tr>
	   <td width="120">传真号码</td>
	   <td>
	   		<input style="width: 92%" type="text" name="orgData.fax" id="orgData.fax" 
	   			class="easyui-validatebox" validType="faxno" />
	   	</td>
	   <td width="120" >邮政编码</td>
	   <td>
	   		<input style="width: 92%" type="text" name="orgData.postcode" id="orgData.postcode" 
	   		   class="easyui-validatebox" validType="zip"	/>
	   	</td>
    </tr>
	 <tr>
	   <td width="120">机构排序</td>
	   <td><input style="width: 92%" type="text" name="orgData.taxis" id="orgData.taxis" /></td>
	   <td width="120" >记录状态</td>
	   <td><input style="width: 92%" type="text" name="orgData.rowstatus" id="orgData.rowstatus" /></td>
    </tr>
	 <tr>
		<td width="120" >备注</td>
	   <td colspan="3"><textarea style="width: 95%" rows="5" cols="60" name="orgData.remark" id="orgData.remark"></textarea></td>
	</tr>
	<tr>
		<td width="120" >部门主管</td>
		<td>
		  <select name="orgData.deptManagerID" id="orgData.deptManagerID" required="true" missingMessage="必选">
		  	<option value=''>请选择</option>
			 	<c:forEach var="systemRole" items="${roleList}"  >
			 		<c:if test="${systemRole.rolename!='系统管理员'}">
			 			<option value='${systemRole.id }'>${systemRole.rolename}</option>
			 		</c:if> 
			    </c:forEach>
		  </select>
			<input id="deptManagerID" type="hidden" value="${orgData.deptManagerID}" />
		</td>
		<td width="120" align="center">部门分管</td>
		<td>
			<select name="orgData.deptDeputyManagerID" id="orgData.deptDeputyManagerID">
				<option value=''>请选择</option>
			 	<c:forEach var="systemRole" items="${roleList}"  >
			 		<c:if test="${systemRole.rolename!='系统管理员'}">
			 			<option value='${systemRole.id }'>${systemRole.rolename}</option>
			 		</c:if> 
			    </c:forEach>
			</select>
			<input id="deptDeputyManagerID" type="hidden" value="${orgData.deptDeputyManagerID}" />
		</td>
	</tr>
		<tr>
		<td>机构类型</td>
		<td>
			<select name="orgData.catalog">
				<option value="1">职能部门</option>
				<option value="2">业务部门</option>
			</select>
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td align="center" colspan="4">
		<a class="easyui-linkbutton" iconCls="icon-save" href="javascript:void(0);" onClick="saveOrgInfo()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-no" href="javascript:void(0);" onClick="javascript:history.go(-1);">返回</a></td>
	</tr>
</table>
</form>
</body>