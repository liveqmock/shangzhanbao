<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/orderManage/orderList.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#timeStar').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#timeEnd').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />

<title>客户管理</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<form id="orderForm" method="post">
<div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/order_manage/key/getAllOrder" target="frame_main">订单管理</a> </span> </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
	<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td style="width: 70px">订单编号:</td>
				<td><input style="width: 150px" type="text" name="orderData.code" value="${orderData.code }"></td>
				<td style="width: 70px">下单时间:</td>
				<td><input id="timeStar" style="width: 150px" name="orderData.createTime" value="<fmt:formatDate value='${orderData.createTime }' pattern="yyyy-MM-dd HH:mm:ss" />" type="text" />
				至<input name="orderData.modifyTime" style="width: 150px" id="timeEnd" value="<fmt:formatDate value='${orderData.modifyTime }' pattern="yyyy-MM-dd HH:mm:ss" />" type="text" /></td>
				<td>
				<input type="button"  onclick="showOrder('${orderData.state}');" class="Btn_TopSearch" />
				</td>
			</tr>
		</table>
		</div>
	</div>
</div>

        <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabTitle">
        	<input type="hidden" name="orderData.state" id="state" value="${orderData.state }" />
     	   	<ul id="myTab00">
	           <li class=${orderData.state==null?"active":"normal" } onclick="showOrder();">全部订单</li> 
	           <li class=${orderData.state==1?"active":"normal" } onclick="showOrder(1);">线下付款</li> 
	           <li class=${orderData.state==2?"active":"normal" } onclick="showOrder(2);">已付款</li> 
			</ul>
      	</div>
 	</div>
	<div class="TabContent">
		<div class="hm_content">
    		<table  width="100%" border="0" cellspacing="1" cellpadding="1">
	        	<tr>
	        		<td>订单编号</td>
	        		<td>订单服务</td>
	        		<td>订单金额</td>
	        		<td>用户名</td>
	        		<td>创建时间</td>
	        		<td>订单状态</td>
	        		<td>服务状态</td>
	        		<td>操作</td>
	        	</tr>
	        	<c:forEach var="order" items="${orderDatas }" varStatus="i">
	        		<input type="hidden" value="${orderData.id }"/>
	        		<input type="hidden" value="${orderData.sysUserId }"/>
					<tr>
						<td>${order.code }</td>
						<td>
						<c:forEach var="orderProduct" items="${order.orderProductDatas }" >
							${orderProduct.productName }<br/>
						</c:forEach>
						</td>
						<td>${order.price }</td>
						<td>${order.userName }</td>
						<td>${order.createTime }</td>
						<td>${orderstateType[order.state]}</td>
						<td>
						<c:forEach var="orderProduct" items="${order.orderProductDatas }" >
							${orderproductstate[orderProduct.state]}<br/>
						</c:forEach>
						</td>
						<td>
							<a href="${root}/order_manage/key/findAllOrderDatebyOrderId?orderData.id=${order.id }">详情</a>
							<c:if test="${order.state==1}">
							<a href="javascript:updateOrderState('${order.id }','2');">标记收款</a><br/>
							</c:if>
							<c:forEach var="orderProduct" items="${order.orderProductDatas }" >
								<c:if test="${order.state==2 && orderProduct.state==0}">
								<a href="javascript:updateOpState('${orderProduct.id }','1');">标记开通</a><br/>
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
        	</table>
        <page:PageRoll/>
        </div>
        </div>
        </div>
        </form>
</body>
</html>