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
<script type="text/javascript" src="${root}/view/js/minipage/pageManager/pageManagerList.js"></script>
<script type="text/javascript">
       
    </script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<title>模板详情Page数据显示</title>
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
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a> <b>>></b>
<span><a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main">模板管理</a> </span> </div>
  
   
	
	
	
  <div id="ContentDiv">
    <div class="nTab"> 
<!--         <div class="TabTitle">
     		   <ul id="myTab00">
       
           <li class="active" value="0"  >全部</li> 
           <li class="normal" value="2"  >发布Page</li> 
	       <li class="normal" value="1"   >暂存Page</li>
		   <li class="normal" value="3" >已禁用Page</li>
		      </ul>
      </div> -->
        <div class="TabContent">
   			 <div class="hm_content">
  <table  width="100%" border="0" cellspacing="1" cellpadding="1">
        	<tr>
        		<td>编号</td>        		
        		<td>page名称</td>
        		<td>状态</td>
        		<td>创建时间</td>
        	
        	</tr>
        	  <c:forEach var="page" items="${pageDatas}" varStatus="status">
        <c:if test="${(page.status==1 ||page.status==0) && page.isDelete==1}">
        	<tr>
        		<td>${i.index+1 }</td>
        		<td>${page.name }</td>
        		<td>${page.status }</td>
        		<td>
        		 <fmt:formatDate value="${page.createTime }" type="date"/>
        		</td>
        	</tr>
        	</c:if>
        </c:forEach>
        </table>

  				 </div>
  		 </div>
   </div>
   </div>


      
   
</body>
</html>