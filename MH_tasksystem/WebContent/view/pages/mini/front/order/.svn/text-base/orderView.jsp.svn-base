<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>订单详情 - 商站宝</title>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<!--<link rel="stylesheet" href="css/UserCenter.css" />
<link rel="stylesheet" type="text/css" href="css/css.css">
<link rel="stylesheet" type="text/css" href="css/grid.css">
--></head>
<body>

<div class="content">
  <div class="OrderForm">
  <div class="OrderForm_Tab6_font">
      <h1>订单状态：</h1>
      <span>${orderstate[orderData.state]}</span></div>
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
            <td><span class="OrderForm_Tab6_td" >
              <c:if  test="${orderproductstate[orderProduct.state]!=null }">
           		 ${orderproductstate[orderProduct.state] }
           	  </c:if>
           	      <c:if  test="${orderproductstate[orderProduct.state]==null }">-</c:if>
            </span>
             <c:if  test="${orderProduct.productName eq '实名网站认证' }">
           	 <span><a href="#" class="btn_gray">认证信息</a></span>
            </c:if>
            </td>
          </tr>
       	</c:forEach>
        </tbody>
      </table>
    </div>
    <div class="OrderForm_Tab6_order">订单金额：<span>${orderData.price}元</span>
    <c:if test="${orderData.pageData.name!=null}">
    <span style="margin-left: 20px;">服务所属商站:<a href="${path}${orderData.pageData.pageInfoExtra.domain}" target="_blank" style="color: #26B5CE;">${orderData.pageData.name}</a></span>
    </c:if>
    </div>
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
<%@include file="/mini_end.jsp"%>
</body>
</html>

