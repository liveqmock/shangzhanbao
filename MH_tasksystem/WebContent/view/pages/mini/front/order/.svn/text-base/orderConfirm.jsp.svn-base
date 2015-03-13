<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>提交订单 - 商站宝</title>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/order/orderConfirm.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
</head>
<body>
<div class="Header">
  <div class="container clearfix">
    <div id="Top_nav">
      <div class="login">
      <input type="hidden" id="etipUserEmail" value="${frmUser.etipUserEmail}"/>
      <c:if test="${frmUser.etipUserEmail!=null &&  frmUser.etipUserEmail != ''}">
      		Hi, ${frmUser.etipUserEmail }
      </c:if>
      </div>
      <div class="menu-hd">
      	<c:if test="${frmUser.etipUserEmail==null ||  frmUser.etipUserEmail == ''}">
      	<a href="${root }/view/pages/mini/front/login.jsp" >登录</a>
      	</c:if>
      	<c:if test="${frmUser.etipUserEmail!=null &&  frmUser.etipUserEmail != ''}">
      	<a href="#" onclick=" window.parent.location.href='${root }/j_spring_security_logout'" >退出</a>
      	</c:if>
      </div>
      <div class="menu-hd"><a href="${root }/frame/key/toIndex">返回首页</a></div>
      <div class="menu-hd"><a href="${root }/page_manage/key/getAllPaga?menuNum=1">我的商站</a></div>
      <div class="menu-hd"><span class="icon_cat"></span><a href="${root }/shopping_cart/key/getAll?sign=1">购物车</a><span id="goodsnum" class="font_red"></span></div>
    </div>
    <header>
      <div id="logo" class="grid_1">
      	<img alt="商站宝" src="${root }/view/images/logo/logo.jpg" style="width: 123px;height: 65px;">
      </div>
      <div class="OrderForm_top"><img src="${root }/images/mini/images/order_1.png"></div>
    </header>
  </div>
</div>
<div class="content">
  <div class="OrderForm">
  <form id="orderForm" method="post">
  <input type="hidden" name="orderData.state" value="0" /><!-- 未付款 -->
  <input type="hidden" class="orderUserName" name="orderData.userName" value="" />
  <input type="hidden" class="orderUserTel" name="orderData.userMobile" value="" />
  <input type="hidden" class="orderUserMail" name="orderData.userMail" value="" />
  	<div class="OrderForm_titleTab">
    	<h1>填写并核对订单信息</h1>
    </div>

    <div class="CentDiv_bor">
      <div class="CentDiv_title" style="text-align: left;">支付方式</div>
      <div class="CentDiv_zhifu" id="payMethodDiv">
        <ul>
          <li> <b>
              <input type="radio" name="orderData.payType" value="1" checked="checked"/>
	          支付宝</b> <span>为了保证及时处理订单，请您下单<font color="red">24小时内</font>付款 </span> </li>
	          <li> <b>
	            <input  type="radio" name="orderData.payType" value="0" />
	            线下转账</b> <span>通过任何一家银行向我们的账号转账，<font color="red">并注明订单号</font></span> </li>
        </ul>
        <div class="CentDiv_Btn">
	      <a id="savePayMethodBtn">保存支付方式</a>
	    </div>
      </div>
      <div class="clear"></div>
       <div id="savePayMethodDiv1" style="display: none;" class="CentDiv_zhifu">
			<div class="tishi"><p>
							支付宝：为了保证及时处理订单，请您下单<font color="red">24小时内</font>付款
			</p>
			<span><a href="javascript:;" class="showPayMehtodDiv blue">修改</a></span></div>
		</div>
		<div id="savePayMethodDiv3" style="display: none;" class="CentDiv_zhifu">
			<div class="tishi"><p>
				线下转账：通过任何一家银行向我们的账号转账，<font color="red">并注明订单号</font></p>
			<span><a href="javascript:;" class="showPayMehtodDiv blue">修改</a></span></div>
		</div> 
      
    </div>
    
    <div class="CentDiv_bor  linkManInfoOutDiv">
      <div class="CentDiv_title" style="text-align: left;">联系人信息
      <c:if test="${attenInfoDatas!='[]' }">
      	<div class="editAttenSpan" style="float:right;margin-right:800px;"><span class="editAtten"><a style="color:#cc0000;font-size:12px" href="###">[修改]</a></span></div>
      	<div class="saveAttenSpan" style="display:none;float:right;margin-right:800px;"><span class="saveAtten"><a style="color:#cc0000;font-size:12px" href="###">[保存]</a></span></div>
      </c:if>
      <c:if test="${attenInfoDatas=='[]' }">
      	<div class="editAttenSpan" style="display:none;float:right;margin-right:800px;"><span class="editAtten"><a style="color:#cc0000;font-size:12px" href="###">[修改]</a></span></div>
      	<div class="saveAttenSpan" style="float:right;margin-right:800px;"><span class="saveAtten"><a style="color:#cc0000;font-size:12px" href="###">[保存]</a></span></div>
      </c:if>
      </div>
    <c:if test="${attenInfoDatas=='[]' }">
      <div id="morenAtten" style="margin-left:50px;margin-top:-5px;font-size:12px;display:none">
    		<span></span><span style="margin-left:30px"></span>
    		<span style="margin-left:30px"></span>
    	</div>
    	<div id="moreAtten" style="margin-left:50px;margin-top:-5px">
    		<ul id="moreAttenUl" style="margin-top: 70px;font-size:12px">
    			<li style="height: 20px;margin-top:10px;width: 650px;line-height:20px;">
    				<b style="margin-left: 10px"><input class="userNewAddress" name="atten" checked="checked" type="radio" value="0"/>
	        			<span>使用新联系人</span>
	        		</b>
    			</li>
        	</ul>
        	<div class="CentDiv_zhifu" id="addNewAttenDiv" style="margin-left:20px;margin-top:20px">
		<div id="linkManInfoDiv">
			<table width="800" border="0" cellspacing="1" cellpadding="1">
			<input type="hidden" id="attenId" value="" />
				<tr>
					<td width="50">姓名：</td>
					<td>
						<input type="text" id="username"  class="input_bor"  value="${loginname }"
						notnull="姓名不能为空!" max="12" data-placement="right"/><font color="#FF0000">*</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>手机：</td>
					<td><input type="text" id="userphone"  class="input_bor"  value="${phone }"
						 tel="电话格式不正确" notnull="手机号码不能为空!" data-placement="right"/><font color="#FF0000">*</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" id="usermail"  class="input_bor"  value=""
					    notnull="邮箱不能为空!" email="邮箱格式不正确!" data-placement="right"/>
					    <font color="#FF0000">*</font>

					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3" style="">
					<div class="CentDiv_Btn">
						<a class="saveNewAtten">保存联系人信息</a>
					</div>
					</td>
				</tr>
			</table>
		</div>
		 <div class="clear"></div>
	</div>
	</div>
    </c:if>
    <c:if test="${attenInfoDatas!='[]' }">
    	<div id="morenAtten" style="margin-left:50px;margin-top:-5px;font-size:12px"">
    		<span>${attenInfoDatas[0].attenName}</span><span style="margin-left:30px">${attenInfoDatas[0].attenTel}</span>
    		<span style="margin-left:30px">${attenInfoDatas[0].attenEmail}</span>
    	</div>
    	<div id="moreAtten" style="margin-left:50px;margin-top:-5px;display:none">
    		<ul id="moreAttenUl" style="margin-top: 70px;font-size:12px">
    			<c:forEach var="atteninfoData" varStatus="i" items="${attenInfoDatas }">
    			<c:if test="${i.index=='0' }">
    			<li class="oldAttenLi" style="height: 20px;margin-top:10px;width: 650px;line-height:20px;background-color: orange"><b style="margin-left: 10px"><input class='userOldAtten' type="radio" name="atten" 
    				attid="${atteninfoData.id}" attname="${atteninfoData.attenName}" atttel="${atteninfoData.attenTel}" attemail="${atteninfoData.attenEmail}" checked="checked" value="${i.index+1 }"/>
	          		<span>${atteninfoData.attenName}</span></b> <span style="margin-left:30px">${atteninfoData.attenTel}</span>
	          		</b><span style="margin-left:30px">${atteninfoData.attenEmail}</span>
	          		<span id="UpOldAtten" style="margin-left:30px;display:none"><a class="editOldAtten" href="###">修改</a></span>
	          		<span id="delOldAtten" style="margin-left:2px;display:none"><a class="delOldAtten" href="###">删除</a></span>
	          	 </li>
    			</c:if>
    			<c:if test="${i.index!='0' }">
    			<li class="oldAttenLi" style="height: 20px;margin-top:10px;width: 650px;line-height:20px;"><b style="margin-left: 10px"><input class='userOldAtten' type="radio" name="atten" 
    				attid="${atteninfoData.id}" attname="${atteninfoData.attenName}" atttel="${atteninfoData.attenTel}" attemail="${atteninfoData.attenEmail}" value="${i.index+1 }"/>
	          		<span>${atteninfoData.attenName}</span></b> <span style="margin-left:30px">${atteninfoData.attenTel}</span>
	          		</b><span style="margin-left:30px">${atteninfoData.attenEmail}</span>
	          		<span id="UpOldAtten" style="margin-left:30px;display:none"><a class="editOldAtten" href="###">修改</a></span>
	          		<span id="delOldAtten" style="margin-left:2px;display:none"><a class="delOldAtten" href="###">删除</a></span>
	          	 </li>
	          	 </c:if>
    			</c:forEach>
    			<li style="height: 20px;margin-top:10px;width: 650px;line-height:20px;">
    				<b style="margin-left: 10px"><input class="userNewAddress" name="atten" type="radio" value="0"/>
	        			<span>使用新联系人</span>
	        		</b>
    			</li>
        	</ul>
        	<div class="CentDiv_zhifu" id="addNewAttenDiv" style="margin-left:20px;margin-top:20px;display:none">
        	<div id="linkManInfoDiv">
			<table width="800" border="0" cellspacing="1" cellpadding="1">
				<input type="hidden" id="attenId" value="" />
				<tr>
					<td width="50">姓名：</td>
					<td>
						<input type="text" id="username" class="input_bor"  value="${loginname }"
						notnull="姓名不能为空!" max="12" data-placement="right"/><font color="#FF0000">*</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>手机：</td>
					<td><input type="text" id="userphone" class="input_bor"  value="${phone }"
						 tel="电话格式不正确" notnull="手机号码不能为空!" data-placement="right"/><font color="#FF0000">*</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" id="usermail" class="input_bor"  value="${email }"
					    notnull="邮箱不能为空!" email="邮箱格式不正确!"  max="35" data-placement="right"/>
					    <font color="#FF0000">*</font>

					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3" style="">
					<div class="CentDiv_Btn">
						<a class="saveNewAtten">保存联系人信息</a>
					</div>
					</td>
				</tr>
			</table>
		</div>
		</div>
    	</div>
    	<div style="width: 100%;height: 20px"></div>

    </c:if>
    </div>
    
    
    
    
    
    <div class="CentDiv_bor invoiceDivOutDiv" style="text-align: left;">
      <div class="CentDiv_title">发票信息</div>
      <div id="fapiaoDiv" class="fapiaoDiv">
      	 <span><input type="radio"  name="orderData.needInvoice" value="1" checked="checked" class="blue noDemandInvoice">不开发票</span>
      	<span><input type="radio"  name="orderData.needInvoice" value="0"  class="blue demandInvoice">索要发票</span>
      </div>
      <div id="invoiceDiv" style="display: none;" class="CentDiv_zhifu">
			<table width="400" border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td width="80"><font color="#FF0000">*</font>发票抬头：</td>
					<td ><input type="text" id="invoicetitle" name="orderData.invoiceData.invoiceTitle" value="${invoiceData.invoiceTitle}" 
						class="input_bor" notnull="发票抬头不能为空!" data-placement="right"/>
					</td>
				</tr>
				<tr>
					<td>发票内容：</td>
						<td>
						<select style="width:100px;" name="orderData.invoiceData.invoiceContent" id="invoiceContent">
						 <s:iterator id="yy" value="#request.InvoiceType"> 	 			
						<option value="<s:property value="#yy.key"/>"><s:property value="#yy.value"/>	</option>
						</s:iterator>
						</select>		
						</td>
				</tr>
				<tr>
					<td><font color="#FF0000">*</font>邮寄地址：</td>
					<td><input type="text" id="invoiceaddress" name="orderData.invoiceData.address" class="input_bor" size="30"  
						notnull="邮寄地址不能为空!" data-placement="right"  value="${invoiceData.address}"/>
					</td>
				</tr>
				<tr>
					<td><font color="#FF0000">*</font>收件人姓名：</td>
					<td><input type="text" id="invoicename" name="orderData.invoiceData.addresseeName" class="input_bor" size="30" 
						notnull="收件人姓名不能为空!" data-placement="right" value="${invoiceData.addresseeName}"/>
					</td>
				</tr>
				<tr>
					<td><font color="#FF0000">*</font>收件人手机：</td>
					<td><input type="text" id="invoicephone" name="orderData.invoiceData.addresseeMoble" class="input_bor" size="30"  
						num="只能是数字!" max="11" min="11" data-placement="right" notnull="手机号码不能为空!"  value="${invoiceData.addresseeMoble}"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left">
					<div class="CentDiv_Btn">
						<a id="saveInvoiceBtn">保存发票信息</a>
					</div>
					</td>
				</tr>
			</table>
		</div>
		
		<div class="clear"></div>
		<div id="saveInvoiceDiv" style="display: none;" class="CentDiv_zhifu">
				<table width="400" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td width="80">发票抬头：</td>
						<td>
							<span id="invoicetitlehide"></span>
						</td>
					</tr>
					<tr>
						<td>发票内容：</td>
						<td>
							<span id="invoicecontenthide"></span>
						</td>
					</tr>
					<tr>
						<td>邮寄地址：</td>
						<td>
							<span id="invoiceaddresshide"></span>
						</td>
					</tr>
					<tr>
						<td>收件人姓名：</td>
						<td>
							<span id="invoicenamehide"></span>
						</td>
					</tr>
					<tr>
						<td>收件人手机：</td>
						<td>
							<span id="invoicephonehide"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="left">
							<a href="javascript:;" class="showInvoiceP blue">修改</a>
						</td>
					</tr>
				</table>
		</div>
    </div>
    
    <div class="CentDiv_bor" style="border-bottom:none">
      <div class="CentDiv_title">商品清单</div>
      <div class="OrderList">
        <table border="0" cellspacing="1" cellpadding="1">
          <tr >
           	<td class="td1" width="100">产品或服务</td>
            <td class="td1" width="80">规格</td>
            <td width="80" class="td1">单价</td>
            <td width="80" class="td1">数量</td>
            <td width="80" class="td1">小计</td>
           
          </tr>
          <!-- 如果paysign为0则表示是发布权限结算 -->
          <c:if test="${paySign==0}">
          	<c:forEach items="${productDatas}" var="product">
          	<tr>
         		<td>${product.name }</td>
	            <td>${product.productConfig }</td>
	            <td>${product.price }</td>
	            <td>${product.goodNum }</td>
	            <td>${product.price*product.goodNum }</td>
	            <c:set var="orderPrice" value="${orderPrice+(product.price*product.goodNum) }"></c:set>
	        </tr>
	        </c:forEach> 
          </c:if>
          <!-- 如果paysign为1则表示是page结算 -->
          <c:if test="${paySign==1}">
          	<c:forEach items="${productDatas}" var="product">
          	<input type="hidden" name="productIds" value="${product.id }" />
          	<tr>
	          	<td>${product.name }</td>
	            <td>${product.productConfig }</td>
	            <td>${product.price }</td>
	            <td>1</td><!-- page购买的服务都为1 -->
	            <td>${product.price*1 }</td>
	            <c:set var="orderPrice" value="${orderPrice+(product.price*1) }"></c:set>
	        </tr>
            </c:forEach> 
          </c:if>
          
      <tr>
        <td colspan="6"><strong style="float:right; margin:0 20px 0 0;">订单金额共计：
        <span class="fontRed_16px initTotal" style="margin:0 0 0 10px">￥<span id="orderPriceDiv">${orderPrice }</span>元</span></strong></td>
      </tr>
        </table>
          <div style="float:right">
          	<!-- 如果paysign为0则表示是发布权限结算 -->
            <c:if test="${paySign==0}">
	          	<input type="hidden" name="amount" value="${amount }" />
	        	<a href="###" class="btn_105Red" id="submitOrderqx" onclick="subOrder('${paySign}');">提交订单</a>
        	</c:if>
        	<!-- 如果paysign为1则表示是page结算 -->
        	<c:if test="${paySign==1}">
        		<input type="hidden" name="orderProductData.pageId" value="${orderProductData.pageId }" />
        		<a href="###" class="btn_105Red" id="submitOrder" onclick="subOrder('${paySign}');">提交订单</a>
        	</c:if>
        	</div>
		</div>
      </div>
      </form>
  </div>
</div>
<div class="clear"></div>
<div style="position:relative; bottom:0; right:0;width: 100%">
<%@include file="/mini_end.jsp"%>
</div>
</body>
<script type="text/javascript"
	src="${root}/view/js/minipage/common/loadmessage.js"></script>
</html>

