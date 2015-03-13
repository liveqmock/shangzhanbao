<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${root}/view/css/ctn.css" />
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/pages/mini/privilege/privilege.js"></script>
<script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#startTime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#endTime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<title>客户管理</title>
</head>
<body>
<div class="current" style="color: #0044BB ;">当前位置：
<span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/user_info/key/statistics" target="frame_main">发布权限管理</a> </span>
</div>
   <div class="wrapbg_gp">
   <div id="ContentDiv">
     <div class="User_TopSearch">
   		<%--<table class="table">
			<tr>
				<td width="30" align="right">时间:</td>
				<td><input id="startTime" value="${startTime }" style="width: 120px" type="text">至
				<input style="width: 120px" value="${endTime }" id="endTime" type="text">
					<input  type="button" value="" id="buttonSearch"  class="Btn_TopSearch" />
				</td>
			</tr>
		</table>--%>
      	</div>
      </div>
    </div> 
      	 <div class="hm_content">
        <form action="" method="post">
        <div style="margin-left: 10px;">
        	试用发布权限:<span id="trydays"></span>天&nbsp;&nbsp;<a href="###" id="change"  >修改</a>
        </div>
        <div style="margin-top: 15px;">
	    <table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
	         <tr>
	               <td width="500"><div class="td_redbg">试用权限总数</div></td>
	               <td width="500"><div class="td_redbg">正在试用数</div></td>
	               <td width="500"><div class="td_redbg">到期数</div></td>
	               <td width="500"><div class="td_redbg">升级为付费权限数 </div></td>
	                </tr>
	                <c:forEach var="userInfo" items="${userInfoList}">
	                <tr>
	                <td>${userInfo.tryPrivilege }</td>
	                <td>${userInfo.alreadyTryPrivilege }</td>
	                <td>${userInfo.expiretry}</td>
	                <td>${userInfo.alreadyUpgrade }</td>
	                </tr>
	                </c:forEach>
	        </table>
	         		 <table  width="100%" border="0" cellspacing="1" cellpadding="1">
	         <tr>
	                  <tr>
	                  <td width="500"><div class="td_redbg">付费权限总数</div></td>
	                  <td width="500"><div class="td_redbg">正在使用数</div></td>
	                  <td width="500"><div class="td_redbg">到期数</div></td>
	                  <td width="500"><div class="td_redbg">续费数 </div></td>
	                </tr>
	                  <c:forEach var="userInfo" items="${userInfoList}">
	                <tr>
	                <td>${userInfo.payment }</td>
	                <td>${userInfo.alreadyPayPrivilege }</td>
	                <td>${userInfo.overduePrivilege }</td>
	                <td>${userInfo.renew }</td>
	                </tr>
	                 </c:forEach>
	        </table>
        </div>
        </form>
         <div style="margin-left: 10px;">
         <a href="${root }/give/key/givePrivilege" class="btn_tianjia" >赠送权限</a>
         &nbsp;&nbsp;&nbsp;
         <div>
         	其中赠送总量：<span>${userInfoList[0].giveNum }</span>个&nbsp;
         <a href="${root }/give/key/findGiveList?give=1" class="btn_gray:hover" >查看赠送的记录</a>
         </div>
         </div>
        </div>
</body>
</html>