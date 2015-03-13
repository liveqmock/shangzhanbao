<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@include file="/mini_top.jsp"%>
<%
    String domainName = "http://" + request.getRemoteHost() + "/";
			//domainName = request.getServerName();
%>

<html>
<script type="text/javascript">
	var url = window.location.protocol + "//" + window.location.hostname;
</script>
<head>
<style type="text/css">
.tooltip-inner{
text-indent:0em;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布，设置商站名称 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link rel="stylesheet" type="text/css"	href="${root }/view/css/jquery-ui-timepicker.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"	src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript"	src="${root}/view/js/common/bootstrap-tooltip.js"></script>

<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/page/domain/pageInfoExtra.js"></script>
</head>
<body>
<a href="###" id="publicSuccess" style="display:none;">设置</a>
	<div class="content">
		<article class="SucceedD">
			<section>
				<h1>设置商站名称！</h1>
<!-- 				<p>但是，它还没有名称和访问网址，不妨现在给它个名称和访问网址吧，你推广和给客户看的时候都要用到的。</p> -->
			</section>
			<form class="SucceedD_form" id="fengxin" method="post">
				<input type="hidden" value="${id}" id="domainId" /> 
				<input type="hidden" value="" id="noPayProductID" /> 
				<input type="hidden" value="${pageid}" id="pageId" /> <input
					type="hidden" value="${param.company}" id="company" />
					<!--此page是否有未付款标示 -->
				<input type="hidden" value="${noPayState}" id="noPayState">
				<p class="personalp" >
				<c:if test="${empty pageDataName}" >
					<strong>商站名称</strong>：<input id="pageName" class="input_bg1" value="${pageDataName}"  style="width:420px" type="text" max="60" notnull="请填写微站名称" />
						 
				</c:if>
				<c:if test="${!empty pageDataName}">
					<strong>商站名称</strong>：<input id="pageName" class="input_bg1" value="${pageDataName}"  style="width:420px" type="text" disabled="disabled" />
				</c:if>
				
				</p>
				<p class="personalp" >
				<c:if test="${empty pageDatadomain}">
					<strong>访问网址</strong>：<span class="font_EN" id="domainName"  >${path}</span><input
						id="lastName" type="text" class="input_bg1"  style="width:200px" 
						value="${pageDatadomain}"  max="16" engOrDigit="域名不合法" notnull="请填写访问网址" ajax="${root }/page/key/checkDomainIsUse,pageDatadomain,0,您输入的域名已被占用"/><span>.html</span>
				</c:if>
				<c:if test="${!empty pageDatadomain}">
					<strong>访问网址</strong>：<span class="font_EN" id="domainName" >${path}</span><input  style="width:200px"
						id="lastName" type="text" class="input_bg1" disabled="disabled"
						value="${pageDatadomain}"  />
				</c:if>
				</p>
				<span style="margin-left: 325px;"><font style="color:#666">可输入字母和数字，一旦设置成功，</font><font style="color:#FF0000;">不可修改</font></span>

				<p class="personalp">
					<font><input type="button" onclick="saveTwoDomain()" class="sur_submit_Btn" value="确定" /></font>
				</p>
			</form>
<!-- 			<h2>如果你想绑定独立域名，可以在管理页面的“域名管理”进行绑定。我们给你先设定一个二级域名，因为绑定独立域名需要7-20天的时间，在这期间，你可以用二级域名来推广和访问。</h2> -->
		</article>
	</div>
	<div class="clear"></div>
	<div class="footer"></div>

	<div class="page_pb_success_div" id="makeSuccess">
		<font>设置成功!</font>
		<div class="page_pb_success_div_in_div">
			<div
				style="left: 30px; top: 10px; width: 480px; height: 100px; position: absolute;font-size:15px;">
				<div id="wangyeName" style="margin-left: 0px;"></div>
				<div id="pageaddress"></div>
			</div>
		</div>
		<div class="page_pb_success_div_in_div_tip">
			OK，你已经将网页发布到互联网上，所有网民都可以访问到你的商站了。快去推广吧！</div>
		<div class="page_pb_success_div_in_div_managerBtn" >
			<a class="page_pb_success_div_in_div_Btn" href="${root}/mini_index.jsp" target="_parent"
				>进入管理页面</a>
		</div>
		<div class="page_pb_success_div_in_div_managerBtn2">
			<a class="page_pb_success_div_in_div_Btn" style="background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;"  href="#" onclick="visitPage()"
				>访问商站</a>
		</div>
	</div>
	
	
	<div class="DataStatistics_1Title" id="makeError"
		style="left: 360px; top: 180px; display: none; position: absolute; width: 580px; height: 300px; box-shadow: 2px 2px 30px #909090;">
		<center>
			<!-- <div onclick="javascript:$('#makeSuccess').fadeToggle(500);" style="left: 550px; top: 0px; width: 30px; height: 20px; position: absolute; background-color: #; cursor: pointer;float: ;"><font style="font-size: 12px;" color="#000">关闭</font></div> -->
		</center>
		<font
			style="font-size: 22px; left: 30px; top: 20px; position: absolute;">您有如下服务未付款，请先付款！</font>
		<div class="DataStatistics_1"
			style="left: 50px; top: 80px; width: 480px; height: 100px; position: absolute;">
			<div
				style="left: 80px; top: 10px; width: 480px; height: 100px; position: absolute;font-size: 15px;">
				<div id="wangyeName1"></div>
			</div>
		</div>
		<!-- <div
			style="left: 50px; top: 180px; width: 480px; height: 100px; position: absolute;">
			OK，你已经将网页发布到互联网上，所有网民都可以访问到你的网页了。快去推广吧！</div> -->
		<div
			style="left: 40px; top: 240px; width: 380px; height: 60px; position: absolute;">
			<a class="btn_gray" href="#" onclick="turnPayForAction();"
				style="width: 200px; height: 30px">马上付款</a>
		</div>
		<div
			style="left: 340px; top: 240px; width: 380px; height: 60px; position: absolute;">
			<a class="btn_gray" href="#" onclick="closeDIV();" 
				style="width: 200px; height: 30px">返回</a>
		</div>
	</div>
	
	
	
	<div class="page_publish_bug_div" id="shoppingCartDivPage">
			<!-- <a href="#" onclick="shoppingCartDivPageClosed()" style="float: right; margin-top: -10px;"></a> -->
			<table class="page_publish_bug_div_table" style="margin-top: 20px;">
				<tr >
					<td>
						<font class="page_publish_bug_div_tip" style="margin-left: 20px;">发布提醒</font>
					</td>
				</tr>
				
				<tr class="page_publish_bug_div_table_tr"></tr>
				<tr >
				<td>
					<font class="page_publish_bug_div_tip_info" style="margin-left: 20px;">你选择了收费服务，它需要收费后才能使用</font>
					</td>
				</tr>
				<tr class="page_publish_bug_div_table_tr"></tr>
				<tr>
					<td>
						<div  style="width: 500px;">
						<div>
							<table border="1" style="margin-left: 20px;width: 550px;">
								<tr style="background-color: #aaaaaa;">
									<td align="center">服务名称</td>
									<td align="center">规格</td>
									<td align="center">价格</td>
								</tr>
								
				<c:forEach var="product" items="${noPayProductList}" varStatus="i">
		
				<input type="hidden" value="${product.id }"/>
					<tr id="officialTr${i.index+1 }">
						
						<td align="center"><input type="text" value="${product.name }" readonly="readonly"
							style="background: transparent; border: none; text-align: center;"></td>
						<td align="center"><input type="text" value="${product.productConfig }"
							readonly="readonly" size="11"
							style="background: transparent; border: none; text-align: center;"></td>
						<td align="center"><span class="font_EN"> <input
								id="countPrice${i.index}" type="text" size="8"
								value="${product.price }"
								 readonly="readonly"
								style="background: transparent; border: none; text-align: center;">
						</span></td>
					
					</tr>
					</c:forEach>
							</table>
						</div>
						</div>	
					</td>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<td><input type="button" value="暂存，稍后付款" onclick="closeDIV();" class="page_publish_bug_div_button_sure">
					
					<td><input type="button" value="去支付" id="" class="page_publish_bug_div_button_cancl" onclick="turnPayForAction();">
					</td>
				</tr>
				<tr class="page_publish_bug_div_table_tr"></tr>
				<tr >
			<td>
			<font class="page_publish_bug_div_end_info" style="margin-left: 20px;">如果你完全想免费试用，可以先选择免费服务，免费服务有:拨打销售电话、客户留言。</font><br>
			<font class="page_publish_bug_div_end_info" style="margin-left: 20px;">可以再编辑page中修改“营销动作”</font>
			</td>
				</tr>
				<tr></tr>
			</table>
	</div>	
</body>
</html>