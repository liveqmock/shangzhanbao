<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>民航任务管理系统</title>
<style type="text/css">
body{
margin:0px;padding:0px
}
</style>
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${root}/view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="${root}/view/css/task/menu.css">
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
$(function(){
	centerDIVAnimate();
})
	
function centerDIVAnimate() {
	var winHeight = $(window).height();
	$("#centerDIV").animate({ height: winHeight+'px'}, 1);
}
</script>
<body class="easyui-layout">
	<div region="west" split="true" title="导航" style="width:160px;padding:1px;overflow:hidden;">
		<div class="easyui-accordion" fit="true" border="false" style="background: #17a;" >
			<div title="系统配置管理" style="overflow:auto;">
				<div id="navcontainer">
		            <ul id="navlist">
					<li><a id="current" href="${root}/view/pages/sys/org/orgIndex.jsp" target="content">机构配置管理</a></li>
					<!--<li><a id="current" href="${root}/view/pages/sys/org/ctn/orgIndex.jsp" target="content">机构配置管理2</a></li>-->
					<li><a href="${root }/user/key/getUsersInfo" target="content">管理员配置管理</a></li>
					<!--<li><a href="${root }/view/pages/sys/role/roleList.jsp" target="content">角色配置管理</a></li>-->
					<li><a href="${root }/role/key/queryAllRolesInfo" target="content">角色配置管理</a></li>
					<li><a href="${root }/service_provider/key/getAllSp?serviceProviderData.spState=1" target="content">服务商管理</a></li>
					<li><a href="${root }/product/key/getAllProduct?productData.productstate=2" target="content">服务产品管理</a></li>
					<li><a href="${root }/business_user/key/getAllBusinessUser" target="content">用户管理</a></li>
					<li><a href="${root }/order/key/orderList" target="content">订单管理</a></li>
					<li><a href="${root }/package/key/searchAllPackage" target="content">服务产品包管理</a></li>
				    <li><a href="${root }/view/pages/ctn/productManageCenter/productManageCenter.jsp" target="content">服务中心内容管理</a></li>
					<li><a href="${root }/view/pages/ctn/msgConfig/msg.jsp" target="content">消息设置</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div region="center" id="centerDIV">
		<iframe  name="content" id="content" frameborder="0" 
			scrolling="yes" width="100%\9" height="100%\9"  src="${root}/view/pages/ctn/portal/portal.jsp"></iframe>
		</div>
</body>
</html>