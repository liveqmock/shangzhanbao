<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改收款账号 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root }/view/css/centerCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/purchase/sysUser/editReceivableAccount.js"></script>
</head>
<body>
<form action="" id="editReceivableAccountForm" method="post">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
  <div class="UserCenter_Right"  >
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>修改收款账号</h1>
      </div>
      <div class="error" style="margin-top:20px;margin-left:100px;display:none;"></div>
      <div style="height: 290px">
      <div style="margin-top: 75px;margin-left: -23px;">
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">收款方式：</label>
          <div class="controls">
          	<div style="width: 225px;height: 30px;background-color: #f2f2f2;margin-top: 5px;">
          		<img style="width: 73px;height: 22px;margin-top:4px;margin-left: 20px" alt="" src="${root }/view/images/pages/uapliy.png">
          		<div style="background:url(${root}/view/images/pages/rectangle_u58.png);width:22px;height:22px;float:right;margin-top:1.5%;margin-right:5%;">
          			<img style="width: 14px;height: 14px;text-align: center;margin-left: 4px;margin-top: 4px;" src="${root }/view/images/pages/rectangle_u60.png">
          		</div>
          	</div>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">收款账号：</label>
          <div class="controls">
          	<input style="border:1px solid #09C;-webkit-box-shadow: 0 0 0px 1000px white inset;width: 225px" id="receivableAccount" value="${userData.receivableAccount }" type="text" class="input_23bor" size="30"/>
		  </div>
        </div>
        <div class="control-group">
          <span ><a  style="margin-left: 280px;margin-top: 10px;" href="#" class="btn_blue" id="editReceivableAccount">保存</a></span>
        </div>
      </div> 
      </div>
     </div>
     </div>
    </div>
    <%@include file="/mini_end.jsp"%>
   </form>
</body>
</html>