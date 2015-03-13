<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<title>Page管理</title>
<style>
 .TabTitle {
	width:100%;
	clear: both;
	height: 28px;
	overflow: hidden;
	border-bottom:4px solid #1386fe;
}
.TabTitle.active {
	background:url(../../../images/images_crb1.jpg) no-repeat left bottom;
	color:#fff;
	font-weight:bold;
	cursor:default;
}
.TabTitle li {
	float: left;
	width: 100px;
	height:28px;
	line-height:28px;
	cursor: pointer;
	padding: 0px;
	list-style-type: none;
	text-align:center;
	font-size:12px;
	color:#333;
	margin:0 3px 0 0;
}
.TabTitle ul {
	margin:0 0 0 18px;
	padding:0;
}
</style>
<script type="text/javascript">
jQuery(function () {
    // 时间设置
    jQuery('#time').datetimepicker({
        timeFormat: "HH:mm:ss",
        dateFormat: "yy-mm-dd"
    });
 // 时间设置
    jQuery('#time2').datetimepicker({
        timeFormat: "HH:mm:ss",
        dateFormat: "yy-mm-dd"
    });
    // 时间设置
    jQuery('#time3').datetimepicker({
        timeFormat: "HH:mm:ss",
        dateFormat: "yy-mm-dd"
    });
    // 时间设置
    jQuery('#time4   ').datetimepicker({
        timeFormat: "HH:mm:ss",
        dateFormat: "yy-mm-dd"
    });
});
</script>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
	<form action="${root }/accesstatistics/key/getAllPageCount" class="well form-search"  id="disForm" method="post">
<div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/accesstatistics/key/getAllPageCount" target="frame_main">流量统计</a> </span> </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
		<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
		
				<tr>
				<td style="width: 40px">域名:</td>
				<td style="width: 140px;"><input style="width: 90px" type="text" name="pageHelpData.pageDomain" value="${param['pageHelpData.pageDomain'] }"></td>
				<td style="width: 80px">page名称:</td>
				<td style="width: 140px;"><input style="width: 120px" type="text" name="pageHelpData.pageName" value="${param['pageHelpData.pageName'] }"></td>
				<tr>
				<td style="width: 100px">独立/二级:</td>
				<td><input type="radio"   name="pageHelpData.pageType" value="1" /> 独立域名
				&nbsp
				<input type="radio"  name="pageHelpData.pageType" value="2"/>二级域名
				</td>
				<tr>
				<td style="width: 70px">创建时间:</td>
				<td><input id="time" style="width: 120px" type="text" name="pageHelpData.createStartTime" value="${param['pageHelpData.createStartTime'] }">
				至<input style="width: 120px" id="time2" type="text" name="pageHelpData.createEndTime" value="${param['pageHelpData.createEndTime'] }"></td>
				<td style="width: 70px">发布时间:</td>
				<td><input id="time3" style="width: 120px" type="text" name="pageHelpData.StartTime" value="${param['pageHelpData.StartTime'] }">
				至<input style="width: 120px" id="time4" type="text" name="pageHelpData.EndTime" value="${param['pageHelpData.EndTime'] }"></td>
			</tr>
			<tr>
			
			<td colspan="8"><div style="margin:0 0 0 20px" align="right"> <input type="submit" value="" class="Btn_TopSearch"></div></td>
			</tr>
		</table>

	</div>
	</div>
	</div>
	

		<div align="right" style="margin-right: 10px;margin-top: 5px;">	
	<span >排序：<a href="${root }/accesstatistics/key/getAllPageCount?count=${count eq 1?1:0 }" target="frame_main">按访问量</a> </span>
	</div>
  <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabTitle">
     		   <ul id="myTab00">
           <li class="active" value="4">全部</li> 
		      </ul>
      </div>
        <div class="TabContent">
   			 <div class="hm_content">
		  	<table  width="100%" border="0" cellspacing="1" cellpadding="1">
		        	<tr>
		        		<td>&nbsp;</td>
		        		<td>编号</td>
		        		<td>page名称</td>
		        		<td>page域名</td>
		        		<td>状态</td>
		        		<td>创建时间</td>
		        		<td>访问量</td>
		        		<td>操作</td>
		        	</tr>
		        	  <c:forEach var="acc" items="${list}" varStatus="status">
		    
		        	<tr>
		        		<td>
		        		
		        		</td>
		        		<td>${status.index+1 }</td>
						<td>${acc.pageData.name }</td>
			
		        		<td>  <a href="${path}${acc.pageData.pageInfoExtra.domain }" target="_black" style="text-decoration: none;color: blue;">${path}${acc.pageData.pageInfoExtra.domain }</a></td>
		        		<td>
		        		 <c:if test="${acc.pageData.status==0 }">暂存</c:if>
		        		<c:if test="${acc.pageData.status==1 }">已发布</c:if>
		        		<c:if test="${acc.pageData.status==2 }">禁用</c:if>
		        		<c:if test="${acc.pageData.status==3 }">编辑中</c:if>
		        		<c:if test="${acc.pageData.status==4 }">启用</c:if> 
		        		 </td>
		        		<td>
		        		 <fmt:formatDate value="${acc.pageData.createTime }" type="date"/>
		        		</td>
		        		<td>${acc.lLL }</td>
		        		<td>&nbsp;</td> 
		        	</tr>
		
		     	 </c:forEach>
		        </table>
					<page:PageRoll/>
  				</div>
  		 </div>
   	</div>
 </div>
			</form>

     
      
   
</body>
</html>