<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车 - 商站宝</title>
<script type="text/javascript" src="${root }/view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
  src="${root }/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript"
	src="${root }/view/js/minipage/front/order/topshopcart.js"></script>
<script type="text/javascript" src="${root }/view/js/jquery.cookie.js"></script>
</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>

		
		<div class="DataStatistics_1Title" style="margin-left: 30px">
			   <h1>购物车</h1>
			   <!--<span  id="totalCount"  class="Order_Pay" style=" display: ;  margin-top: 2px;">
			   <a href="#" class="hrefshopAll" onclick="shoppingCartDivAll()">全部结算</a></span>--></div>
		
		<!-- 官方发布权限 -->
		<c:if test="${productList!='[]'}">
			<c:forEach var="product" items="${productList}" varStatus="i">
				<div class="bingordersDiv UserCenter_Right" id="officialorderTable0">
					<div class="DataStatistics_1">
						<div class="widget-content">
								<table class="table" id="officialTable">
									<thead>
										<tr>
											<th width="170">购买服务</th>
											<th width="180">规格</th>
											<th width="80">单价</th>
											<th width="90">数量</th>
											<!--<th width="80">小计</th>-->
											<th width="80">操作</th>
										</tr>
									</thead>
									<tbody>
									<input type="hidden" value="${product.id }" name="productId${page.id }"/>
										<tr id="officialTr${i.index+1 }">
											<td><input type="text" value="${product.name }"
												name="orderProductDatas[${i.index }].productName" readonly="readonly"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><input type="text" value="${product.productConfig }"
												name="orderProductDatas[${i.index }].productConfigName"
												readonly="readonly" size="11"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><span class="font_EN"><input type="text"
													size="3" id="unitPrice${i.index}" value="${product.price }"
													name="orderProductDatas[${i.index }].unitPrice" readonly="readonly"
													style="background: transparent; border: none; text-align: center;"></span></td>
											<td>
												<div class="inputTab">
													<span class="inputTab_left" onclick="reduceNum('${product.id}','${i.index}');">-</span> <input
														id="amount${i.index}" name="orderProductDatas[${i.index }].amount"
														type="text"
														onkeyup="changeNum('${product.id}','${i.index}');"
														class="inputTab_input" value="${product.shoppingCartData.num}">
													<span class="inputTab_right" onclick="addNum('${product.id}','${i.index}');">+</span>
												</div>
											</td>
											<!--<td><span class="font_EN"> <input
													id="countPrice${i.index}" type="text" size="8"
													value="${product.shoppingCartData.num * product.price }"
													name="orderData.price" readonly="readonly"
													style="background: transparent; border: none; text-align: center;">
											</span></td>-->
											<td><a href="#" data1="${product.id }" data2=""
												class="deleteProduct font_blue">删除</a></td>
										</tr>
									</tbody>
								</table>
								<input type="hidden" name="pageData.id"
									value="${product.pageId }" />
						</div>
					</div>
					<div class="Order_Btndiv">
						<span id="ordermoney" class="Order_Money">￥:${product.price} 元</span><span class="Order_Pay"><a href="#"
							onclick="topayqx('${i.index}');" >去结算</a></span>
					</div>
				</div>
				</c:forEach>
			</c:if>
		<!-- 已绑定域名，已有page名称 -->
			<c:if test="${productOwnDomain!='[]'}">
			<c:forEach var="page" items="${productOwnDomain}" varStatus="j">
				<div class="bingordersDiv UserCenter_Right" id="bingorderTable${j.index}">
					<c:if test="${page.name!=null &&  page.name!='' && page.pageInfoExtra!=null}">
					<div style="margin-bottom:10px"><span style="font-size: 20px;">${page.name } </span>&nbsp;&nbsp;
					<a href="${page.pageInfoExtra.domain }" target="_blank" style="color:blue">${page.pageInfoExtra.domain }</a></div>
					</c:if>
					<c:if test="${(page.name==null ||  page.name=='') && page.pageInfoExtra==null}">
					<div>
						<span style="font-size: 20px">未设置名称</span>&nbsp;&nbsp;<a href="#"
						onclick="showtowDomainDiv('${page.id }'); ">去设置</a>
					</div>
					</c:if>
					<div class="DataStatistics_1">
						<div class="widget-content">
							<form action="<%-- ${root }/shop_cart/key/sumPrice --%>"
								id="bingOrder${j.index }" method="post">
								<table class="table" id="btable">
									<thead>
										<tr>
											<th width="170">购买服务</th>
											<th width="180">规格</th>
											<th width="80">单价</th>
											<th width="80">操作</th>
										</tr>
									</thead>
									<tbody>
									<c:set var="orderPrice" value="0"></c:set>
									<c:forEach var="product" items="${page.listProduct}" varStatus="i">
									<c:if test="${product.sign!=1 }">
										<tr id="btr">
										<c:set var="orderPrice" value="${product.price+orderPrice }"></c:set>
												<input type="hidden" value="${product.id }"
												name="productId${page.id }"/>
											<td><input type="text" value="${product.name }"
												name="orderProductDatas[${i.index }].productName" readonly="readonly"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><input type="text" value="${product.productConfig }"
												size="11" name="orderProductDatas[${i.index }].productConfigName"
												readonly="readonly"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><span class="font_EN"><input type="text" class="price"
													value="${product.price }" name="orderProductDatas[${i.index }].unitPrice"
													readonly="readonly"
													style="background: transparent; border: none; text-align: center;"></span></td>
											<td><a href="#" data1="${product.id}" data2="${page.id}" 
												class="deleteProduct font_blue">删除</a></td>
											<c:if test="${i.index== 0 }">
												<input type="hidden" name="pageData.id"
													value="${page.id }" />
											</c:if>
											<input type="hidden"
											id="bamount" name="orderProductDatas[${i.index }].amount" value="1" />
										</tr>
										</c:if>
										</c:forEach>
									</tbody>
								</table>
								 <input id="orderPriceNum" type="hidden" name="orderData.price"
									value="${orderPrice}" />
							</form>
						</div>
					</div>
					<div class="Order_Btndiv">
						<span id="bordermoney" class="Order_Money">￥:${orderPrice}元</span><span class="Order_Pay"> <a href="#"
						onclick="topay('${page.id }')">去结算</a></span>
					</div>
				</div>
				
				</c:forEach>
			</c:if>
		
		<c:if test="${productList=='[]' && productOwnDomain=='[]'}">
					<div class="UserCenter_Right">
						<div class="DataStatistics_box">
			        		<h1>购物车为空 </h1>
			     		</div>
			        		
		     		</div>
		</c:if>
		<!-- 除去以上的其他服务 -->
		<div class="UserCenter_Right" style="display: none;" id="orderTable">
			<div style="float: right; margin-right: 10px">可以后续选择使用在哪个Page上</div>
			<div class="DataStatistics_1">
				<div class="widget-content">
					<form action="${root }/shop_cart/key/sumPrice" id="otherOrderfrom"
						method="post">
						<table class="table" id="otable">
							<thead>
								<tr>
									<th width="170">购买服务</th>
									<th width="180">规格</th>
									<th width="80">单价</th>
									<th width="90">数量</th>
									<th width="80">小计</th>
									<th width="80">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${productList}" varStatus="i">
									<c:if
										test="${product.sign!=1 && product.domain==null &&  product.pageId ==null}">
										<tr id="otr${i.index }">
											<td><input type="text" id="uproductname${i.index }"
												value="${product.name }" name="orderProductData.productName"
												readonly="readonly"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><input type="text"
												id="uproductconfigname${i.index }"
												value="${product.productConfig }"
												name="orderProductData.productConfigName"
												readonly="readonly" size="11"
												style="background: transparent; border: none; text-align: center;"></td>
											<td><span class="font_EN"> <input
													id="uunitPrice${i.index}" name="orderProductData.unitPrice"
													type="text" value="${product.price }" size="11"
													readonly="readonly"
													style="background: transparent; border: none; text-align: center;" /></span></td>
											<td><div class="inputTab">
													<span class="inputTab_left"
														onclick="addOtherNum('${product.id}','${i.index}');">+</span>
													<input id="uuamount${i.index}"
														name="orderProductData.amount" type="text"
														onkeyup="changePageNum('${product.id}','${i.index}');"
														class="inputTab_input" value="${product.goodNum}">
													<span class="inputTab_right"
														onclick="reduceOtherNum('${product.id}','${i.index}');">-</span>
												</div></td>
											<td><span name="uuprice" id="uuprice${i.index}"
												class="font_EN"> <input type="text"
													title="uuprice${i.index}" id="orderprice${i.index}"
													name="orderData.price" size="3"
													value="${product.goodNum*product.price }"
													style="background: transparent; border: none; text-align: center;" />
											</span></td>
											<td><a href="#"
												onclick="deleteProduct('${product.id}','otable','otr${i.index }','otherTotalprice')"
												class="font_blue">删除</a></td>
										</tr>
										<input type="hidden" name="pageData.id"
											value="${product.pageId }" />
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="Order_Btndiv">
				<span class="Order_Money" id="otherTotalprice">￥:0.0元</span><span
					class="Order_Pay"> <a href="#" onclick="otherOrderSubmit();">去结算</a></span>
			</div>
		</div>
	</div>


	<!-- 设置域名悬浮窗 -->
	<div id="divdomain"
		style="top:25%;margin-left:25%; width: 775px; height: 320px; position: absolute; display: none; background-color: #F0F0F0;border-radius:10px;box-shadow: 2px 2px 30px #909090;">
			<div onclick="javascript:$('#divdomain').fadeToggle(500); "
				style="left: 750px; top: 10px; width: 30px; height: 20px; position: absolute; cursor: pointer;">
				<font size="3" color="black">x</font>
			</div>
			<div style="margin-top: 30px;margin-left: 20px;">
				<font style="font-size: 24px; font-family: 'Heiti SC Light', 'Heiti SC';font-weight: 200;color: #333333;">设置</font>
			</div>
			<div style="margin-top: 30px;margin-left: 20px;">
				<font style="font-size: 14px; font-family: 'Heiti SC Light', 'Heiti SC';font-weight: 200;color: #333333;">商站名称:</font> 
			</div>
			<div style="margin-top: 10px;margin-left: 20px;">
				<input type="text" id="pageName" style="width: 250px; height: 30px;" />
			</div>
			<div style="margin-top: 30px;margin-left: 20px;">
			<font style="font-size: 14px; font-family: 'Heiti SC Light', 'Heiti SC';font-weight: 200;color: #333333;">访问网址:</font><span
					id="domainName" style="font-size: 14px; font-family: 'Heiti SC Light', 'Heiti SC';font-weight: 200;color: #333333;">${path}</span> 
			</div>
				<div style="margin-top: 10px;margin-left: 20px;">
				<input type="text" id="lastName"
					style="width: 250px; height: 30px;" />
				</div>
			<div style="width: 250px;height: 40px;text-align:center;background-color:#0099CC;margin-top: 30px;margin-left: 20px;" onclick="saveTwoDomain('${i.index}')">
				<p><span style="font-family:'Heiti SC Light', 'Heiti SC';font-weight:200;line-height:40px;font-size: 14px">
          	<a style="color:#FFF;text-decoration: none;" href="###">提交</a>
          	</span></p>
			
			</div>
			<div style="max-height: 240px;margin-right: 50px;float: right;margin-top: -210px;max-width: 350px;">
				<img src="" id="pageImg">
			</div>
	</div>

	<div style="display: none;">
		<c:forEach var="product" items="${productList}" varStatus="i">
			<c:if
				test="${product.sign!=1 && product.domain==null &&  product.pageId ==null}">
				<table>
					<tr>
						<td><input type="checkbox" name="checkother"
							checked="checked" value="${product.id}" date="${i.index}" /></td>
					</tr>
				</table>
			</c:if>
		</c:forEach>
	</div>

<%@include file="/mini_end.jsp"%>
	
</body>
</html>
