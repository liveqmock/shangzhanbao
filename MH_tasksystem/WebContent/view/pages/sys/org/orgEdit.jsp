<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/bodyandh3.css"></link>
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/easyUI/js/easyui-validator.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgList.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgIndex.js"></script>
<body>
	<table><tr>
		<td colspan="1"><h3>编辑机构</h3></td>
	</tr></table>
<form action="#" id="orgForm">
<input type="hidden" name="orgData.id" id="orgData.id"  value="${orgData.id}" />
<input type="hidden" name="orgData.parentid" id="orgData.parentid" value="${orgData.parentid}" />
<input type="hidden" name="orgData.creator" value="${orgData.creator}"/>
<input type="hidden" name="orgData.createtime" value="${orgData.createtime}"/>
<table width="98%" style="BORDER-COLLAPSE: collapse" borderColor=#A4CDF2 cellpadding="5" border="1" align="center">
	<c:if test="%{null!=orgData.parentid && ''!=orgData.parentid }"> 
	<tr>
		<td width="120">上级机构</td>
   		<td colspan="3" >
    		<input style="width: 95%" type="text" id="orgData.parentName" value="${orgData.parentName}"  readonly>
		</td>
  	</tr>
	</c:if>
	<tr>
		<td width="120">机构名称<font color="#FF0000">(*)</font></td>
		<td width="374" >
			<input style="width: 92%" type="text" name="orgData.orgnamedefault" id="orgData.orgnamedefault"
				required="true"  missingMessage="必填" class="easyui-validatebox"	value="${orgData.orgnamedefault}">
		</td>
		<td width="120" >机构简称<font color="#FF0000">(*)</font></td>
		<td width="350" ><input style="width: 92%" type="text" name="orgData.orgshortname" id="orgData.orgshortname" value="${orgData.orgshortname}"></td>
	</tr>
	<tr>
		<td width="120" >机构中文名称<font color="#FF0000">(*)</font></td>
		<td><input style="width: 92%" type="text" name="orgData.orgname_cn" id="orgData.orgname_cn" value="${orgData.orgname_cn}"></td>
		<td width="120" >机构英文名称</td>
		<td>
			<input style="width: 92%" type="text" name="orgData.orgname_us" id="orgData.orgname_us" 
				class="easyui-validatebox" validType="english" value="${orgData.orgname_us}">
		</td>
	</tr>
	<tr>
		<td width="120" >联系人</td>
		<td><input style="width: 92%" type="text" name="orgData.linkman" id="orgData.linkman" value="${orgData.linkman}"></td>
		<td width="120" >联系电话</td>
		<td>
			<input style="width: 92%" type="text" name="orgData.telephone" id="orgData.telephone" 
				 class="easyui-validatebox" validType="phoneOrMobile"	value="${orgData.telephone}">
		</td>
	</tr>
	<tr>
		<td width="120" >联系地址</td>
	   	<td colspan="3"><input style="width: 97%" type="text" name="orgData.address" id="orgData.address" value="${orgData.address}"></td>
	</tr>
	<tr>
		<td width="120">传真号码</td>
	   	<td>
			<input style="width: 92%" type="text" name="orgData.fax" id="orgData.fax" 
	   			class="easyui-validatebox" validType="faxno" value="${orgData.fax}">
		</td>
		<td width="120" >邮政编码</td>
		<td>
			<input style="width: 92%" type="text" name="orgData.postcode" id="orgData.postcode" 
	   		   class="easyui-validatebox" validType="zip"	value="${orgData.postcode}" />
	   	</td>
    </tr>
	<tr>
		<td width="120">机构排序</td>
		<td><input style="width: 92%" type="text" name="orgData.taxis" id="orgData.taxis" value="${orgData.taxis}"></td>
		<td width="120" >记录状态</td>
		<td><input style="width: 92%" type="text" name="orgData.rowstatus" id="orgData.rowstatus" value="${orgData.rowstatus}"></td>
    </tr>
	<tr>
		<td width="120" >备注</td>
		<td colspan="3"><textarea style="width: 100%" rows="5" cols="60" name="orgData.remark" id="orgData.remark">${orgData.remark}</textarea></td>
	</tr>
	<tr>
		<td width="120" >部门主管</td>
		<td>
			<select name="orgData.deptManagerID" id="orgData.deptManagerID">
				<option value=''>请选择</option>
			 	<c:forEach var="systemRole" items="${roleList}"  >
			 		<c:if test="${systemRole.rolename!='系统管理员'}">
			 			<c:if test="${systemRole.id==orgData.deptManagerID}">
			 				<option value='${systemRole.id }' selected="selected">${systemRole.rolename}</option>
			 			</c:if>
			 			<c:if test="${systemRole.id!=orgData.deptManagerID}">
			 				<option value='${systemRole.id }'>${systemRole.rolename}</option>
			 			</c:if>
			 		</c:if> 
			    </c:forEach>
			</select>
			<input id="deptManagerID" type="hidden" value="${orgData.deptManagerID}" />
		</td>
		<td width="120" align="left">部门分管</td>
		<td>
			<select name="orgData.deptDeputyManagerID" id="orgData.deptDeputyManagerID">
				<option value=''>请选择</option>
			 	<c:forEach var="systemRole" items="${roleList}"  >
			 		<c:if test="${systemRole.rolename!='系统管理员'}">
			 			<c:if test="${systemRole.id==orgData.deptDeputyManagerID}">
			 				<option value='${systemRole.id }' selected="selected">${systemRole.rolename}</option>
			 			</c:if>
			 			<c:if test="${systemRole.id!=orgData.deptDeputyManagerID}">
			 				<option value='${systemRole.id }'>${systemRole.rolename}</option>
			 			</c:if>
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
				<option value="1" <s:if test="%{orgData.catalog==1}">selected="selected"</s:if>>职能部门</option>
				<option value="2" <s:if test="%{orgData.catalog==2}">selected="selected"</s:if>>业务部门</option>
			</select>
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td align="center" colspan="4">
		<a class="easyui-linkbutton" iconCls="icon-save" href="javascript:void(0);" onClick="updateOrgInfo()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-no" href="javascript:void(0);" onClick="javascript:history.go(-1);">返回</a></td>
	</tr>
</table>
</form>
</body>