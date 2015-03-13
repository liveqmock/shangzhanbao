<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/mini_top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet"
	type="text/css" />
<link href="${root }/view/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
	
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<title>商品订单管理</title>
<style type="text/css">
	.noreadtr{
		font-weight: bold;
		color:red;
	}
	.msg{
		color: blue;
	}
	.btn_sel{
		margin-left:5px;
		font-size: 13px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #D7D7D7;
		width:53px;
		height:20px;
	}
	.btn_cl{
		margin-left:5px;
		font-size: 13px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #FF0000;
		width:53px;
		height:20px;
	}
	.deliverGoods{
		background:#B5B5B5;
		width:605px;
		height:339px;
		margin-top: 20px;
	}
	.deliverGoods_groud{
		width:221px;
		height:136px;
		background:url(${root}/view/images/buy/u203.png) 221px 136px;
		position:relative;
		left:25px;
		top:25px; 
		float:left;
	}
	.deliverGoods_div{
		background:#0099FF;
		width: 65px;
		height: 19px; 
		position:relative;
		left:10px; 
		top:-10px;
		-webkit-border-radius: 30px;
		-moz-border-radius: 30px;
		font-family:'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		font-size: 13px;
		text-align:center;
		line-height:19px;
	}
	.goodsName{
		margin-left:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 16px;
		color: #333333;
	}
	.goodsConfig{
		margin-left:10px; 
		margin-top:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #666666; 
		font-size:13px;
	}
	.goodsNum_div{
		margin-left:10px; 
		margin-top:10px;
	}
	.goodsNum{
		background-color: #E4E4E4;
		width: 46px;
	}
	.goodsPrice{
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 16px;
		color: #FF0000;
	}
	.customer_div{
		width:338px; 
		height:136px; 
		background:url(${root}/view/images/buy/u211.png) 338px 136px;
		position:relative; 
		left:26px; 
		top:25px; 
		float:left;
	}
	.customer_info{
		margin-left:10px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #333333; 
		width:313px; 
		line-height:25px;
	}
	.logistics_div{
		width:558px; 
		height:143px; 
		background:url(${root}/view/images/buy/u232.png) 558px 143px;
		position:relative; 
		left:25px; 
		top:40px; 
		float:left;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #333333;
	}
	.logistics_company{
		margin-left:10px; 
		margin-top:5px;
	}
	.logistics_number{
		margin-left:10px; 
		margin-top:10px;
	}
	.logistics_number_text{
		border:#FF0000 2px solid; 
		width:325px; 
		height:28px;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
	}
	.logistics_number_btn{
		border:none; 
		background:#FF0000;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		font-size: 14px;
		color: #FFFFFF; 
		width:70px; 
		height: 30px;
		float:right;
		margin-right: 25px;
	}
	.closeBox_btn{
		width:88px;
		height:30px;
		font-family: 'Heiti SC Light', 'Heiti SC';
		font-weight: 200;
		color: #FFFFFF;
		border: none;
		background: #999999;
		float: right;
		margin-right: 20px;
	}
</style>
<script type="text/javascript">
	/**
 	 * 发货弹框
 	 */
	function deliverGoods(goodsName,configName,goodsNum,price,orderId,createTime,userName,userMobile,userAddress){
		
		var htmlText="<div class='deliverGoods'>"
			+"<div class='deliverGoods_groud'>"
			+"<div class='deliverGoods_div'>商品</div>"
			+"<div class='customer_info'>名称："+goodsName+"</div>"
			+"<div class='customer_info'>规格："+configName+"</div>"
			+"<div class='customer_info'>数量："+goodsNum
			+"&nbsp;&nbsp;价格：<span class='goodsPrice'>￥"+price+"</span></div>"
			+"<div class='customer_info'>"+new Date(createTime).format('yyyy-MM-dd hh:mm:ss')+"</div></div>"
			+"<div class='customer_div'>"
			+"<div class='deliverGoods_div'>客户</div>"
			+"<div class='customer_info'>"
			+"收 货 人："+userName+"<br/>"
			+"手机号码："+userMobile+"<br/>"
			+"收货地址："+userAddress+"</div></div>"
			+"<div class='logistics_div'>"
			+"<div class='deliverGoods_div' style='background: #FF0000;'>发货</div>"
			+"<div class='logistics_company'>物流公司："
			+"<select style='width: 158px;height: 21px;' id='logistics_type'>"
			+"<option selected='' value='请选择'>请选择</option>"
			+"<option value='顺丰'>顺丰</option>"
			+"<option value='韵达'>韵达</option>"
			+"<option value='申通'>申通</option>"
			+"<option value='中通'>中通</option>"
			+"<option value='圆通'>圆通</option>"
			+"<option value='EMS'>EMS</option>"
			+"</select></div>"
			+"<div class='logistics_number'>物流单号："
			+"<input type='hidden' id='orderId' value='"+orderId+"' />"
			+"<input type='text' id='logistics_number' class='logistics_number_text' />"
			+"<input type='button' class='logistics_number_btn' onclick='deliver()' value='确认发货' />"
			+"</div><div style='margin-left: 10px;margin-top: 10px;color: #FF0000;font-size: 13px;line-height: 30px;'>"
			+"*物流单号方便用户查询时使用，不填写也可确认发货，请保留快递单据。<input type='button' value='返回' onclick='removeBox()' class='logistics_number_btn' style='background:#B5B5B5;' /></div></div></div>";
		
		new bombBox('deliverGoodsBtn', 'deliverGoodsBox', {
			title : '发货详情',
			content : htmlText,
			width : '610',
			height : '400',
			top : '',
			left : '',
			fixed : '',
			close : 'close'
		});
		$("#deliverGoodsBtn").click();
	}
	
	/**
	 * 确认发货
	 */
	function deliver(){
		//获取订单编号
		var orderId = $("#orderId").val();
		//获取快递公司
		var logistics_type = encodeURI(encodeURI($("#logistics_type").val()));
		//获取快递单号
		var logistics_number = $("#logistics_number").val();
		
		$.ajax({
	        type : 'POST',
	        cache:false,
	        url : root+'/order_manager/key/updateConsumerOrder?conSumerOrderData.id='
	        		+orderId+'&conSumerOrderData.logisticsCompany='+logistics_type+'&conSumerOrderData.logisticsNumber='+logistics_number,
	        dataType : "text",
	        success : function(data) {
	        	location.reload();
	        }
		});
	}
	
	/**
	 * 关闭弹窗
	 */
	function removeBox(){
		$("#deliverGoodsBox").remove();
	}
	
	/**
	 * 已发货查看弹框
	 */
	function deliverGoodsInfo(goodsName,configName,goodsNum,price,createTime,userName,userMobile,userAddress,logisticsCompany,logisticsNumber,deliverTime){
		
		if(logisticsNumber==''){
			logisticsNumber='未填写';
		}
		
		var htmlText="<div class='deliverGoods'>"
			+"<div class='deliverGoods_groud'>"
			+"<div class='deliverGoods_div'>商品</div>"
			+"<div class='customer_info'>名称："+goodsName+"</div>"
			+"<div class='customer_info'>规格："+configName+"</div>"
			+"<div class='customer_info'>数量："+goodsNum
			+"&nbsp;&nbsp;价格：<span class='goodsPrice'>￥"+price+"</span></div>"
			+"<div class='customer_info'>"+new Date(createTime).format('yyyy-MM-dd hh:mm:ss')+"</div></div>"
			+"<div class='customer_div'>"
			+"<div class='deliverGoods_div'>客户</div>"
			+"<div class='customer_info'>"
			+"收 货 人："+userName+"<br/>"
			+"手机号码："+userMobile+"<br/>"
			+"收货地址："+userAddress+"</div></div>"
			+"<div class='logistics_div'>"
			+"<div class='deliverGoods_div' style='background: #FF0000;'>发货</div>"
			+"<div class='logistics_company'>已发货</div>"
			+"<div style='margin-left:10px;'>物流公司："+logisticsCompany+"</div>"
			+"<div style='margin-left:10px;'>物流单号："+logisticsNumber+"</div>"
			+"<div style='margin-left:10px;'>发货时间："+new Date(deliverTime).format('yyyy-MM-dd hh:mm:ss')+"</div>"
			+"<input type='button' onclick='removeBox()' class='closeBox_btn' value='好的' /></div></div>";
		
		new bombBox('deliverGoodsBtn', 'deliverGoodsBox', {
			title : '发货详情',
			content : htmlText,
			width : '610',
			height : '400',
			top : '',
			left : '',
			fixed : '',
			close : 'close'
		});
		$("#deliverGoodsBtn").click();
	}
	
	/**
	 * 未发货查看弹框
	 */
	function nopayment(goodsName,configName,goodsNum,price,createTime,userName,userMobile,userAddress){
		var htmlText="<div class='deliverGoods'>"
			+"<div class='deliverGoods_groud'>"
			+"<div class='deliverGoods_div'>商品</div>"
			+"<div class='customer_info'>名称："+goodsName+"</div>"
			+"<div class='customer_info'>规格："+configName+"</div>"
			+"<div class='customer_info'>数量："+goodsNum
			+"&nbsp;&nbsp;价格：<span class='goodsPrice'>￥"+price+"</span></div>"
			+"<div class='customer_info'>"+new Date(createTime).format('yyyy-MM-dd hh:mm:ss')+"</div></div>"
			+"<div class='customer_div'>"
			+"<div class='deliverGoods_div'>客户</div>"
			+"<div class='customer_info'>"
			+"收 货 人："+userName+"<br/>"
			+"手机号码："+userMobile+"<br/>"
			+"收货地址："+userAddress+"</div></div>"
			+"<div class='logistics_div'>"
			+"<div class='deliverGoods_div' style='background: #FF0000;'>发货</div>"
			+"<div class='logistics_company'>客户未付款，暂不能发货。</div>"
			+"<div class='logistics_number'>我们在下单3小时后通知客户赶紧付款，超过24小时客户仍未付款，系统将自动取消订单。</div>"
			+"<input type='button' onclick='removeBox()' class='closeBox_btn' value='好的' /></div></div>";
		
		new bombBox('deliverGoodsBtn', 'deliverGoodsBox', {
			title : '发货详情',
			content : htmlText,
			width : '610',
			height : '400',
			top : '',
			left : '',
			fixed : '',
			close : 'close'
		});
		$("#deliverGoodsBtn").click();
	}
	
	Date.prototype.format = function(format){ 
		var o = { 
			"M+" : this.getMonth()+1, //month 
			"d+" : this.getDate(), //day 
			"h+" : this.getHours(), //hour 
			"m+" : this.getMinutes(), //minute 
			"s+" : this.getSeconds(), //second 
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
			"S" : this.getMilliseconds() //millisecond 
		} 

		if(/(y+)/.test(format)) { 
			format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		} 

		for(var k in o) { 
			if(new RegExp("("+ k +")").test(format)) { 
				format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
			} 
		} 
		return format; 
	} 
</script>
</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>
		<input type="button" id="deliverGoodsBtn" style="display: none;"/>
		<div class="UserCenter_Right">
			<div class="mesTi">
		    <div class="h1Div">
		    	<h1>
		     		${pageName}
		     		<c:if test="${pageName==''}">未设置名称</c:if>
		     	</h1>
		    </div>
		   	<a href="${root }/page_manage/key/getAllPaga?menuNum=1"> <img alt="" src="${root}/view/images/product/u53.png"></a>
		</div>
		<div class="mesmain">
			<div class="mes_mleft" style="height:1px;float: none;">
				<img alt=""  src="${root }/images/mini/purchase/buy/buy_meitu_3.jpg">
			</div>
			<div class="mes_mright" style="margin-left: 250px;">
				<h1>${pageName}
		     		<c:if test="${pageName==''}">未设置名称</c:if>
		     	</h1>
			  	<p>
			  		<c:if test="${pageUrl!=''}"><a href="${path }${pageUrl}" target="_Blank">${path }${pageUrl}</a></c:if>
		     		<c:if test="${pageUrl==''}">未设置链接</c:if>
		     	</p>
			</div>
			<div class="mes_mright" style="margin-left: 250px;font-family: 'Arial Normal', 'Arial';font-weight: 400;font-style: normal; font-size: 16px;">
				订单总数：<lable style="color: #0099CC;">${orderNumMap.type0+orderNumMap.type1+orderNumMap.type2}</lable>&nbsp;&nbsp;&nbsp;待发货：<lable style="color: #0099CC;">${orderNumMap.type1 }</lable>&nbsp;&nbsp;&nbsp;未付款：<lable style="color: #0099CC;">${orderNumMap.type0 }</lable>&nbsp;&nbsp;&nbsp;已发货：<lable style="color: #0099CC;">${orderNumMap.type2 }</lable>
			</div>
		</div>
			<div class="DataStatistics_1">
				<div class="DataStatistics_1Title">
					<h1>我的订单</h1>
					<div>
						<span><a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageid }&state=1" class="${state!=1?'msg':'' }">待发货</a></span>
						<span><a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageid }&state=0" class="${state!=0?'msg':'' }">未付款</a></span>
						<span><a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageid }&state=2" class="${state!=2?'msg':'' }">已发货</a></span>
						<span><a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageid }" class="${state!=null?'msg':'' }">所有订单</a></span>
					</div>
				</div>
				<div class="widget-content">
					<form action="" method="post">
						<table class="table">
							<thead>
								<tr>
									<th width="150">商品名称</th>
									<th width="100">规格</th>
									<th width="100">数量</th>
									<th width="100">价格</th>
									<th width="150">客户姓名</th>
									<th width="150">电话</th>
									<th width="150">地址</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="omData" items="${listOrderManager}">
									<tr id="${omData.id}">
										<td width="150">
											<span id="goodsName" style="color: #0099CC;">${omData.goodsInfoData.goodsName }</span>
										</td>
										<td width="100">
											<span id="configName">${omData.commodityConfigData.configName }</span>
										</td>
										<td width="100">
											<span id="goodsNum">${omData.goodsNum }</span>
										</td>
										<td width="100">
											<span id="price">${omData.conSumerOrderData.price }</span>
										</td>
										<td width="150">
											<span id="userName">${omData.conSumerOrderData.conSumerUserData.userName }</span>
										</td>
										<td width="150">
											<span id="userMobile">${omData.conSumerOrderData.conSumerUserData.userMobile }</span>
										</td>
										<td width="150" title="${omData.conSumerOrderData.conSumerUserData.userAddress }">
											<div id="userAddress" style="color: #0099CC;">${fn:substring(omData.conSumerOrderData.conSumerUserData.userAddress,0, fn:indexOf(omData.conSumerOrderData.conSumerUserData.userAddress,"市")+1)}</div>
										</td>
										<!-- <td width="250">
											<span>${fn:substring(pmData.demand, 0, 8)}...</span>
										</td> -->
										<td width="150">
										<c:if test="${omData.conSumerOrderData.state==0 }">
											未付款
											<span class="span2"><input class="btn_sel" onclick="nopayment('${omData.goodsInfoData.goodsName}','${omData.commodityConfigData.configName}','${omData.goodsNum}','${omData.conSumerOrderData.price}','${omData.conSumerOrderData.createTime}','${omData.conSumerOrderData.conSumerUserData.userName }','${omData.conSumerOrderData.conSumerUserData.userMobile }','${omData.conSumerOrderData.conSumerUserData.userAddress }')" type="button" value="查看" /></span>
										</c:if>
										<c:if test="${omData.conSumerOrderData.state==1 }">
											<span class="span2">待发货<input class="btn_cl" onclick="deliverGoods('${omData.goodsInfoData.goodsName}','${omData.commodityConfigData.configName}','${omData.goodsNum}','${omData.conSumerOrderData.price}','${omData.conSumerOrderData.id}','${omData.conSumerOrderData.createTime}','${omData.conSumerOrderData.conSumerUserData.userName }','${omData.conSumerOrderData.conSumerUserData.userMobile }','${omData.conSumerOrderData.conSumerUserData.userAddress }')" type="button" value="处理" /></span>
										</c:if>
										<c:if test="${omData.conSumerOrderData.state==2 }">
											<span class="span2">已发货<input class="btn_sel" onclick="deliverGoodsInfo('${omData.goodsInfoData.goodsName}','${omData.commodityConfigData.configName}','${omData.goodsNum}','${omData.conSumerOrderData.price}','${omData.conSumerOrderData.createTime}','${omData.conSumerOrderData.conSumerUserData.userName }','${omData.conSumerOrderData.conSumerUserData.userMobile }','${omData.conSumerOrderData.conSumerUserData.userAddress }','${omData.conSumerOrderData.logisticsCompany}','${omData.conSumerOrderData.logisticsNumber}','${omData.conSumerOrderData.deliverTime}')" type="button" value="查看" /></span>
										</c:if>
										<c:if test="${omData.conSumerOrderData.state==3 }">
											<span class="span2">已完成<input class="btn_sel" onclick="deliverGoodsInfo('${omData.goodsInfoData.goodsName}','${omData.commodityConfigData.configName}','${omData.goodsNum}','${omData.conSumerOrderData.price}','${omData.conSumerOrderData.createTime}','${omData.conSumerOrderData.conSumerUserData.userName }','${omData.conSumerOrderData.conSumerUserData.userMobile }','${omData.conSumerOrderData.conSumerUserData.userAddress }','${omData.conSumerOrderData.logisticsCompany}','${omData.conSumerOrderData.logisticsNumber}','${omData.conSumerOrderData.deliverTime}')" type="button" value="查看" /></span>
										</c:if>
										</td>
									</tr>
								</c:forEach>
								<tr><td colspan="8" height="40"><div style="float:right"> <page:PageRoll/></div></td></tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			</div>
		</div>
</body>
</html>