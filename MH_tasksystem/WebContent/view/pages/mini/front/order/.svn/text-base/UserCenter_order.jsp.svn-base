<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单管理 - 商站宝</title>
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<style type="text/css">
  *{margin:0;padding:0;}
  /****订单弹出框*****/
table,tr,td{
font: 14px "Hevetica Neve",Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;
}
 </style>
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript"  src="${root }/view/js/minipage/front/order/order.js"></script>
</head>
<body>
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
        <form action="" id="orderFrom" method="post">
        <div class="UserCenter_Right"  >
         <c:if test="${orderList!='[]'}">
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
      	<c:if test="${orderstate==1}">
        <h1>未付款订单</h1>
        </c:if>
        <c:if test="${orderstate==3}">
         <h1>已完成款订单</h1>
        </c:if>
        <span class="orderstateClass">
        <a href="/order/key/orderList?menuNum=5" <c:if test="${orderstate==1}">style="color:#09F;"</c:if>>未付款</a><label>|</label>
        <a href="/order/key/orderList?menuNum=5&orderData.state=3" <c:if test="${orderstate==3}">style="color:#09F;"</c:if>>已付款</a>
        </span>
      </div>
      <div class="widget-content">
          <table class="table">
            <thead>
              <tr>
              	<th width="20px;"><input type="checkbox"  id="checkBoxAll" name="ckboxs"></th>
                <th width="140px;">订单号 </th>
                <th>购买服务</th>
                <th width="50">规格</th>
                <th width="30">单价</th>
                <th width="30">数量</th>
                <th width="30">总额</th>
                <th>操作</th>
              </tr>
            </thead>
             <tbody>
            
            <c:forEach var="order" items="${orderList}" varStatus="i">
	              <tr>
	              	<td rowspan=" ${order.productNum }">
	              	<input type="checkbox" value="${order.id}" id="checkBoxOrderId" name="orderIds" class="checkOrderId">
	              	</td>
	                <td rowspan=" ${order.productNum }" style="width: 140px;"><span class="font_EN">${order.code }</span></td>
		              <c:forEach var="orderProduct" items="${order.orderProductDatas}" begin="0" end="0">
		                <c:if test="${orderProduct.productName==null || orderProduct.productName=='' }">
		                <td style="width: 120px;"></td>
		                </c:if>
		                <c:if test="${orderProduct.productName!=null && orderProduct.productName!='' }">
		                <td style="width: 120px;">${orderProduct.productName }</td>
		                </c:if>
		                <td>${orderProduct.productConfigName }</td>
		                <td><span class="font_EN">${orderProduct.unitPrice/orderProduct.amount }</span></td>
		                <td>${orderProduct.amount }</td>
		             </c:forEach>
	                <td rowspan=" ${order.productNum }"><span class="font_EN">${order.price }</span></td>
	              	<td rowspan=" ${order.productNum }" style="width: 160px;">
	              	<c:if test="${orderstate==1}">
	              		<c:if test="${order.payType==0}"><a href="###" style="font-size: 14px;color: #6E6C6C;">线下付款</a></c:if>
	              	</c:if>
	              		<c:if test="${order.payType!=0}"> <a href="#" class="font_blue" name="zhifu" id="bt${i.index }" data="${order.id }">支付</a></c:if>
	              	  	<a href="${root }/order/key/findOrderView?orderData.id=${order.id}" class="font_blue" target="_blank">详情</a>
	              	  	<a href="#" class="font_blue "  style="margin-left: 5px;" onclick="deleteOrderByID('${order.id}')"><font style="font-size: 13px" >删除</font></a>
	              	</td>
	              </tr>
	      		  <c:forEach var="orderProduct" items="${order.orderProductDatas}" begin="1">
	              <tr>
	                <td>${orderProduct.productName }</td>
	                <td>${orderProduct.productConfigName }</td>
	                <td><span class="font_EN">${orderProduct.unitPrice/orderProduct.amount }</span></td> 
	                <td>${orderProduct.amount }</td>
	              </tr>
      			 </c:forEach>
            </c:forEach>
             <tr>
	              <td colspan="10">
	                 <a href="#" class="btn_blue deleteOrderByID"  style="margin-left: 5px;background: #B6AFAF;float: right;" ><font style="font-size: 13px" >删除</font></a>
	              	<c:if test="${orderstate==1}">
	               	 <a href="#" class="btn_blue" id="bt" data="${order.id }" style="float: right;">支付</a>
	                </c:if>
	              </td>
              </tr>
          		  </tbody>
        	  </table>
        	    <page:PageRoll/>
    	  </div>
      </div>
      </c:if>
      <c:if test="${orderList=='[]'}">
       <div class="UserCenter_Right"  >
     	 <div class="DataStatistics_box">
		<h1>还未生成订单</h1>
      </div>
      </div>
      </c:if>
   </div>
</form>
</div>
<div class="footer"></div>
<div id="orderMsg" class="orderMsg" style="display: none;">
  <div class="orderMsg_BG">
    <h1><font>确认付款</font><span>客服支持电话：<strong>4006-365-010</strong></span></h1>
  <div class="orderMsg_BGDiv">
     <input type="button"
	onclick="window.location='${root }/order/key/orderList?menuNum=5' "
		value="支付成功"
		style="background-image: url('${root}/images/sc/button_u85_normal.png'); width: 110px; height: 33px; border: 0px; background-color: transparent;">
    </div>
    <div class="orderMsg_BGDiv">
  <input type="button"
		onclick="window.location='${root }/order/key/orderList?menuNum=5' "
		value="支付遇到问题"
		style="background-image: url('${root}/images/sc/button_u85_normal.png'); width: 110px; height: 33px; border: 0px; background-color: transparent;">
 </div>
  </div>
 
  </div>
<script type="text/javascript">

var _CalF = {   //便捷方法
	     $ : function(id){return document.getElementById(id)},
	     create : function(id){return document.createElement(id)},
	     append : function(id){return document.body.appendChild(id)},
	     remove : function(id){return document.body.removeChild(id)}
	 }
	 
	 function popup(openID,conID,closeID){
	     this.onclick(openID,conID,closeID);
	 }
	 
	 popup.prototype = {
	     
	     cssStyle : "width:100%;position:absolute;left:0;top:0;filter:alpha(opacity = 50);opacity:0.5;border:0;overflow:auto;",
	 
	     createShadowDiv : function(){   //背景遮罩
	         var shadowDiv = _CalF.create("div");
	         shadowDiv.id = "shadowDiv";
	         shadowDiv.style.cssText = this.cssStyle;
	         shadowDiv.style.height = document.body.scrollHeight + "px";
	         shadowDiv.style.backgroundColor = "#000"
	         shadowDiv.style.zindex = 100;
	         _CalF.append(shadowDiv);
	     },
	 
	     createIframe : function(){  //iframe
	         var iframe = _CalF.create("iframe");
	         iframe.id = "shadowIframe";
	         iframe.style.cssText = this.cssStyle;
	         iframe.style.height = document.body.scrollHeight + "px";
	         iframe.style.zindex = 99;
	         _CalF.append(iframe);
	     },
	 
	     removeDiv : function(){
	         _CalF.remove(_CalF.$("shadowDiv"));
	         _CalF.remove(_CalF.$("shadowIframe"));
	     },
	 
	 
		onclick : function(openID,conID,closeID){
	         var that = this;  
	 
	         _CalF.$(openID).onclick = function(){
	 
	             if(window.ActiveXObject){   //ie6
	                 if(!window.XMLHttpRequest){
	                    document.body.style.cssText = "_background-image: url(about:blank);_background-attachment: fixed;";
	                 }
	             } 
	 
	             that.createIframe();
	             that.createShadowDiv();
	             _CalF.$(conID).style.display = "block";

	             //ajax得到支付的form
	             $.ajax({
	     				dataType:'text',
	     				type:'post',
	     				async: false,
	     				data:'orderId='+$("#"+openID).attr('data'),
	     				url:root+'/alipay/key/ajaxGetAlipayForm',
	     				success:function(msg){
	     					var obj = $(msg).appendTo($(document.body));
	     					document.forms['alipaysubmit'].target="_blank";
	     		        	document.forms['alipaysubmit'].submit();
	     				}
	     			});
	        }
	 
	     }
	 
	 }
	 var names = document.getElementsByName("zhifu");
	 for(var i=0;i<names.length;i++){
		 new popup(names[i].attributes["id"].value,"orderMsg","close");
	 }
</script>
<%@include file="/mini_end.jsp"%>
</body>
</html>
