<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	jQuery(function() {
		// 时间设置
		jQuery('#time').datetimepicker({
			timeFormat : "HH:mm:ss",
			dateFormat : "yy-mm-dd"
		});
		// 时间设置
		jQuery('#time2').datetimepicker({
			timeFormat : "HH:mm:ss",
			dateFormat : "yy-mm-dd"
		});
	});
	function clickAccount(obj){
		window.location.href = root+"/account_manager/key/searchAllAccount?state="+$(obj).val();
	}
	//点击转账按钮
	function accountPrice(price,obj){
		if(confirm("确定转账￥："+price+"元？")){
			window.location.href = root+"/account_manager/key/searchAllAccount?state=3&orderId="+obj;
		}
	}
	//点击修改按钮
	function editProportion(){
		$("#proportion_lab").hide();
		$("#editProportion").hide();
		$("#proportion_inp").show();
		$("#baocunProportion").show();
	}
	//点击保存按钮
	function baocunProportion(){
		var proportion = $("#proportion_inp").val();
		if (!isNaN(proportion)){
		   if(proportion>=100){
			   alert("请输入小于100的数字！");
		   } else {
			   $.ajax({
					type : 'POST',
					cache: false,
					url :  root+"/account_manager/key/changeYieldContect?num="+proportion,
					dataType : "text",
					success : function(data) {
						window.location.href = root+"/account_manager/key/searchAllAccount?state=2";
					}
				});
		   }
		} else {
			alert("请输入数字!");
		}
	}
</script>
<title>计费管理</title>
</head>
<body>
<body style="height: 100%; border-top: 1px solid #D5D5D5;">
	<form action="" class="accoutForm" method="post">
		<div class="wrapbg_gp">
			<div class="current">
				当前位置： <span><a href="${root}/frame/key/oprating"
					target="_parent">首页</a></span><b>>></b> <span><a
					href="${root }/account_manager/key/searchAllAccount"
					target="frame_main">计费管理</a> </span>
			</div>
			<div id="ContentDiv">
				<div class="User_TopSearch">
					<table class="table" width="100%" border="0" cellspacing="1"
						cellpadding="1">
						<tr>
							<td>
								<B>手续费：</B>比例为
								<label id="proportion_lab">${proportion }</label>
								<input style="display: none; width: 50px;" type="text" id="proportion_inp" value="${proportion }">
								<a style="margin-left: 30px;" id="editProportion" href="javascript:editProportion()">修改</a>
								<a style="display: none;" id="baocunProportion" href="javascript:baocunProportion()">保存</a>
							</td>
						</tr>
						<tr><td>备注：每单订单金额*<label id="proportion_lab">${proportion }</label>%</td></tr>
					</table>
				</div>
			</div>
		</div>
		<div id="ContentDiv">
			<div class="nTab">
				<div class="TabTitle">
					<ul id="myTab00">
						<li class=${state==2?"active":"normal" } onclick="clickAccount(this)" value="2">待处理</li>
						<li class=${state==3?"active":"normal" } onclick="clickAccount(this)" value="3">已处理</li>
					</ul>
				</div>
			</div>
			<div class="TabContent">
				<div class="hm_content">
					<table width="100%" border="0" cellspacing="1" cellpadding="1">
						<tr>
							<td width="18"></td>
							<td>收款方式</td>
							<td>收款账号</td>
							<td>订单付款时间</td>
							<c:if test="${state==3}">
							<td>转账时间</td>
							</c:if>
							<td>订单金额</td>
							<td>转账金额</td>
							<td>操作${state==2?"":"人"}</td>
						</tr>
						<c:forEach var="account" items="${accountList }" varStatus="i">
							<tr>
								<td></td>
								<td>${account.conSumerOrderData.payType==1?"支付宝":"微信" }</td>
								<td>${account.conSumerOrderData.pageData.userData.receivableAccount }</td>
								<td><fmt:formatDate value="${account.conSumerOrderData.payTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<c:if test="${state==3}">
								<td><fmt:formatDate value="${account.conSumerOrderData.transferTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								</c:if>
								<td><a href="${root }/order_manager/key/tobackOrderManagerInfo?id=${account.id }">￥${account.conSumerOrderData.price }</a></td>
								<td>${account.conSumerOrderData.price*(1-proportion/100) }</td>
								<td>
								<c:if test="${state==2}">
								<a href="javascript:accountPrice('${account.conSumerOrderData.price*(1-proportion/100) }','${account.conSumerOrderData.id }')">转账</a>
								</c:if>
								<c:if test="${state==3}">
								${account.conSumerOrderData.transferPeople }
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<page:PageRoll />
				</div>
			</div>
		</div>
	</form>
	<div style="margin-left: 20px;">
		订单总金额：${allPrice }<br/>
		需转账金额：${allPrice*(1-proportion/100) }<br/>
		剩余金额：${allPrice*(proportion/100) }
	</div>
</body>
</html>