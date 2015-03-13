<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>线下付款 - 商站宝</title>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/order/orderConfirm.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<!--<link rel="stylesheet" href="css/UserCenter.css" />
<link rel="stylesheet" type="text/css" href="css/css.css">
<link rel="stylesheet" type="text/css" href="css/grid.css">
--></head>
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
      <div id="logo" class="grid_1"><img alt="商站宝" src="${root }/view/images/logo/logo.jpg" style="width: 123px;height: 65px;"></div>
      <div class="OrderForm_top"><img src="${root }/images/mini/images/order_2.png	"></div>
    </header>
  </div>
</div>
<div class="content">
  <div class="OrderForm">
  <div class="OrderForm_titleTab"><span class="icon_right"></span>
      <h1>订单已提交！</h1>
    </div>
    <div class="OrderForm_Tab1">
      <p><span>订单号：${code }</span><span style="margin-left:10px;"><a href="${root }/order/key/findOrderView?orderData.id=${orderId}" class="font_blue" target="_blank">查看</a></span></p>
    </div>
    <div class="OrderForm_Tab1">
      <p><span>联系人信息：</span><span>王贇 &nbsp18611854121  &nbspservice@91dzsw.com</span></p>
    </div>
  </div>
  <div class="OrderForm">
    <div class="OrderForm_Tab3">应付金额： <span class="OrderForm_Money">￥:${price }元</span>(银行转账）</div>
    <div class="OrderForm_Tab4">
      <p><span>银    行    开   户   名：</span>博元森禾信息科技（北京）有限公司 </p>
      <p><span>开    户     银    行：</span>中国建设银行</p>
      <p><span>开户银行所在城市：</span>北京</p>
      <p><span>开户银行支行名称：</span>中国建设银行北京北三环支行</p>
      <p><span>公  司  对 公 账 户：</span>11001021200053009079 </p>
    </div>
    <div class="OrderForm_Tab4_img" ><img style="height: 389px;" src="${root }/images/mini/images/order_4.png"></div>
    <div class="OrderForm_Tab4_font" style="margin-top: 100px">
      <p>请注意填写订单号，若您填写了订单号，我们可以在收到款项后的24小时内确认收款并开通服务，否则需要1-5天；</p>
      <p>若款项汇出5个工作日内未帮您进行订单收款确认，请及时致电客服热线400-007-111</p>
    </div>
  </div>
</div>
<div class="clear"></div>
<%@include file="/mini_end.jsp"%>
</body>
</html>

