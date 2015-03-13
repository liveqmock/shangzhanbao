<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/org/orgIndex.js"></script>
<body class="easyui-layout" >
	<div region="west" iconCls="icon-reload" title="机构" split="true" style="width:180px;">
		<div class="easyui-tree" id="orgTree"></div>
	</div>
	<div region="center"  style="overflow:hidden;">
		<iframe id="viewOrg" name="viewOrg" frameborder="0"  scrolling="auto" width="100%" height="100%"></iframe>
	</div>
</body>