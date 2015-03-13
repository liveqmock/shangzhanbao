<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>订单提交成功</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<style type="text/css">
  *{margin:0;padding:0;}
  /****订单弹出框*****/
 .orderMsg{ position:fixed;_position: absolute;_top: expression(documentElement.scrollTop + 340 + "px"); background:#fbddb1; border:1px solid #f1b04e; width:474px; height:242px;top: 50%;left: 50%;margin: -200px 0 0 -250px; overflow:hidden; z-index:99999; font-size:14px; color:#000; display:none;}
#orderMsg .orderMsg_BG {
	width:460px;
	height:228px;
	border:1px solid #f1b04e;
	background:#fff;
	margin:6px
}
#orderMsg .orderMsg_BG h1 {
	width:450px;
	height:40px;
	line-height:40px;
	color:#333;
	border-bottom:2px solid #fbddb1;
	margin:5px;
}
#orderMsg .orderMsg_BG h1 font {
	float:left;
	font-size:16px;
	margin:0 0 0 5px;
}
#orderMsg .orderMsg_BG h1 span {
	font-size:12px;
	float:right;
	color:#F60;
	margin:5px 0 0 0;
}
#orderMsg .orderMsg_BG h1 span strong {
	font-size:14px;
}
#orderMsg .orderMsg_BG .orderMsg_BGDiv{
	width:100px;
	float:left;
	margin:40px 0 0 80px;


}
#orderMsg .orderMsg_BG .orderMsg_BGDiv h2{
	font-size:14px;
}
#orderMsg .orderMsg_BG .orderMsg_BGDiv p{
	width:150px;
}
#orderMsg .orderMsg_BG .orderMsg_BGDiv p a{
	color:#09F;
	text-decoration:none;
}
#orderMsg .orderMsg_BG .orderMsg_BGDiv p a:hover{
	color:#09F;
	text-decoration:underline;
}
 </style>
</head>

<body>
${alipayForm }
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
      <div class="menu-hd"><a href="${root }/page_manage/key/getAllPaga?menuNum=1">我的page</a></div>
      <div class="menu-hd"><span class="icon_cat"></span><a href="${root }/shopping_cart/key/getAll?sign=1">购物车</a><span class="font_red">0</span></div>
    </div>
    <header>
      <div id="logo" class="grid_1"><img alt="商站宝" src="${root }/view/images/logo/logo.jpg" style="width: 123px;height: 65px;"></div>
      <div class="OrderForm_top"><img src="${root }/images/mini/images/order_2.png"></div>
    </header>
  </div>
</div>


<div class="content" style="height: 100%">
  <div class="OrderForm" style="height:500px">
    <div class="OrderForm_titleTab"><span class="icon_right"></span>
      <h1>订单已提交！</h1>
    </div>
    <div class="OrderForm_Tab1"><p><span>订单号：${code }</span><span style="margin-left:10px;"><a href="${root }/order/key/findOrderView?orderData.id=${orderId}" class="font_blue" target="_blank">查看</a></span></p><div class="OrderForm_Tab1_right"><span class="OrderForm_Money" style="float:left">￥:${price }元</span><span><a href="#" id="bt" class="OrderForm_btn1">去付款</a></span></div></div>
    <div class="OrderForm_Tab1"><p><span>联系人信息：</span><span>王贇 &nbsp18611854121  &nbspservice@91dzsw.com</span></p></div>
  </div>
</div>
<div class="clear"></div>

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
	         	document.forms['alipaysubmit'].target="_blank";
	        	document.forms['alipaysubmit'].submit();
	        }
	 
	         	document.getElementById(closeID).onclick = function(){
	             _CalF.$(conID).style.display = "none";
	             that.removeDiv();          
	         }
	     }
	 
	 }
	
	 var bt = new popup("bt","orderMsg","close");
</script>

 <%@include file="/mini_end.jsp"%>
</body>
</html>

