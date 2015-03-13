<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head><title>角色配置</title></head>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<script type="text/javascript" src="${root}/view/js/sys/role/ctn/configRoleUser.js"></script>
<script type="text/javascript">
var roleID = '<%=request.getParameter("roleID")%>';
</script>
<style type="text/css">
body{
	background-color: white;
	font-size: 12px;
}
.leftDIV{
	overflow-y: auto;
	overFlow-x:hidden;
	height:350px;
	width:280px;
	border-width:1px;
	border-color: rgb(30,180,210);
	border-style: solid;
}
.leftTableStyle{
	align:center;
	width:300px;
	background-color: rgb(230,240,255);
	font-size: 12px
}
.rightDIV{
	overflow-y: auto;
	overFlow-x:hidden;
	height:350px;
	width:280px;
	border-width:1px;
	border-color: rgb(30,180,210);
	border-style: solid;
}
.rightTableStyle{
	align:center;
	width:300px;
	background-color: rgb(230,240,255);
	font-size: 12px
}
.userTable{
	width:58%;
	BORDER-COLLAPSE:collapse;
	cellpadding:5;
	align:left;
	font-size:12px;
</style>
<body>
	<table class="userTable" border="1" borderColor=#A4CDF2>
		<tr height="10px">
			<th width="37%">没有此角色用户</th>
			<th width="26%"></th>
			<th width="37%">已有此角色用户</th>
		</tr>
		<tr height="270px">
		<td>
			<div class="leftDIV">
				<table id="leftTable" class="leftTableStyle" >
				</table>
			</div>
		</td>
		<td>
			<table align="center">
				<tr style="height:35px"></tr>
				<tr style="height:50px">
					<td>
						<input type="button" value="&gt" id="setToRight" style="height:25px;width:60px" 
							title="增加选定的用户" class="userLTR"/>
					</td>
				</tr>
				<tr style="height:50px">
					<td>
						<input type="button" value="&gt&gt" id="setToRightAll" style="height:25px;width:60px" 
							title="增加全部用户" class="userLTRAll"/>
					</td>
				</tr>
				<tr style="height:50px">
					<td>
						<input type="button" value="&lt" id="setToLeft" style="height:25px;width:60px" 
							title="取消选定的用户" class="userRTL"/>
					</td>
				</tr>
				<tr style="height:50px">
					<td>
						<input type="button" value="&lt&lt" id="setToLeftAll" style="height:25px;width:60px" 
							title="取消全部用户" class="userRTLAll"/>
					</td>
				</tr>
				<tr style="height:35px"></tr>
			</table>
		</td>
		<td>
			<div class="rightDIV">
				<table id="rightTable" class="rightTableStyle">
				</table>
			</div>
		</td>
	</tr>
	<tr height="50px" align="center">
		<td colspan="3">
			<table align="center">
				<tr>
				<td width="208px" align="center">
					<input type="button" value="确认提交" class="saveAuthorizeUser"/>
					<input type="button" value="取消" class="cancel"/>
				</td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
</body>
</html>