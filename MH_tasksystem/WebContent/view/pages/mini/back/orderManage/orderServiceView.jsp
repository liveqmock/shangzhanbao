<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>订单详情</title>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/spBack.css" />
</head>
<body style="background-color: white;">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/order_manage/key/getAllOrder" target="frame_main">订单管理</a> 
<b style="font-family: 'Helvetica Light', 'Helvetica';">>></b>
<a href="${root}/order_manage/key/findAllOrderDatebyOrderId?orderData.id=${orderData.id }" target="frame_main">订单详情</a> 
</span> </div>
<div class="content"  style="margin-top: -100px;">
  <div class="OrderForm">
  <div class="OrderForm_Tab6_font">
      <h1>订单状态：</h1>
      <span>${orderstate[order.state] }</span></div>
    <div class="OrderForm_Tab6">
      <table class="table">
        <thead>
          <tr>
            <th width="130">产品或服务 </th>
            <th width="125">规格</th>
            <th width="125">单价/元</th>
            <th width="125">数量</th>
            <th width="125">小计</th>
            <th>服务状态</th>
         <!--    <th>操作</th> -->
          </tr>
        </thead>
        <tbody>
        <c:forEach var="orderProduct" items="${orderData.orderProductDatas}">
          <tr>
            <td><span class="font_blue">${orderProduct.productName }</span></td>
            <td>${orderProduct.productConfigName }</td>
            <td><span class="font_EN">${orderProduct.unitPrice/orderProduct.amount }</span></td>
            <td><span class="font_EN">${orderProduct.amount }</span></td>
            <td><span class="font_EN">${orderProduct.unitPrice }</span></td>
            <td><span class="OrderForm_Tab6_td" >${orderproductstate[orderProduct.state] }</span></td>
     <!--        <td><span><a href="#" class="btn_gray">认证信息</a></span></td> -->
          </tr>
       	</c:forEach>
        </tbody>
      </table>
    </div>
    <div class="OrderForm_Tab6_order">订单金额：<span>${orderData.price}元</span></div>
  </div>
  <div class="OrderForm">
    <div class="OrderForm_Tab6_font">
      <h1>订单信息</h1>
    </div>
    <div class="OrderForm_Tab6_list">
      <p> <span>订单编号：<font class="font_EN">${orderData.code}</font> </span> 
      <span>生成时间：<font class="font_EN"><fmt:formatDate value='${orderData.createTime }' pattern="yyyy-MM-dd HH:mm:ss" /></font></span>
      <span>付款时间：<font class="font_EN"><fmt:formatDate value='${orderData.payTime }' pattern="yyyy-MM-dd HH:mm:ss" /></font></span></p>
      <p> <span>联系人姓名：<font class="font_EN">${orderData.userName}</font></span> <span>联系人电话：<font class="font_EN">${orderData.userMobile}</font>
      </span> <span>联系人邮箱：<font class="font_EN">${orderData.userMail}</font></span> </p>
    </div>
    
     <div class="OrderForm_Tab6_line"></div>
     <div class="OrderForm_Tab6_font">
      <h1>发票信息</h1>
    </div>
    <div class="OrderForm_Tab6_fapPiao">
       <c:if test="${!empty orderData.invoiceData.invoiceTitle}">
    <p><span>发票抬头：</span>${orderData.invoiceData.invoiceTitle}</p>
    <p><span>发票类型：</span>服务费</p>
	<p><span>邮寄地址：</span>${orderData.invoiceData.address}</p>  
	<p><span>收  件  人：</span>${orderData.invoiceData.addresseeName}</p>
	<p><span>收件人电话：</span>${orderData.invoiceData.addresseeMoble}</p>
    </c:if>
    
     <c:if test="${empty orderData.invoiceData.invoiceTitle}"> 未填写发票信息 </c:if>
    </div>
    
    <c:if test="${!empty orderData.businessUserData}">
    <div class="OrderForm_Tab6_line"></div>
    <div class="OrderForm_Tab6_font">
      <h1>用户认证信息</h1>
    </div>
	    <div class="OrderForm_Tab6_fapPiao">
	    <p><span>公司名称：</span>${orderData.businessUserData.companyChName }</p>
	    <p><span>网站名称：</span>${orderData.businessUserData.webName }</p>
	    <p><span>网站域名：</span>${orderData.businessUserData.domainName }</p>
	    <p><span>网站备案号：</span>${orderData.businessUserData.icp }</p>
	    <p><span>备案时间：</span><fmt:formatDate value="${orderData.businessUserData.icpTime }" type="date"/></p>
	    <p><span>IP地址：</span>${orderData.businessUserData.ipAddr }</p>
	    <p><span>联系人：</span>${orderData.businessUserData.linkManName}</p>
	    <p><span>手机：</span>${orderData.businessUserData.linkManMoble}</p>
	    <p><span>座机：</span>${orderData.businessUserData.hrPhone}</p>
	    <p><span>邮箱： </span>${orderData.businessUserData.linkManMail}</p>
	    <p><span>工商注册号： </span>${orderData.businessUserData.gszch}</p>
	    <p><span>住所：  </span>${orderData.businessUserData.addr}</p>
	    <p><span>法定代表人： </span>${orderData.businessUserData.fddbr}</p>
	    <p><span>注册资本：  </span>${orderData.businessUserData.zczb}</p>
	    <p><span>公司类型：  </span>${orderData.businessUserData.gslx}</p>
	    <p><span>营业期限：  </span><fmt:formatDate value="${orderData.businessUserData.yyqxBegin}" type="date"/>
                             <c:if test="${orderData.businessUserData.yyqxBegin!=null}"> 至 </c:if>
                             <fmt:formatDate value="${orderData.businessUserData.yyqxEnd}" type="date"/></p>
	    <p><span>经营范围：  </span>${orderData.businessUserData.jyfw}</p>     
	         
		    <div class="clear"></div>
  		</div>
  	</c:if>
    
  </div>
</div>
<div class="clear"></div>
</body>
</html>


