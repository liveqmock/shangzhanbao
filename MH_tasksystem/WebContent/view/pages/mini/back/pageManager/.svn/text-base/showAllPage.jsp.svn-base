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
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${root}/view/css/jquery-ui.css">
  <script src="${root}/view/js/util/jquery-ui.js"></script>
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
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
	<form action="${root }/page_manager/key/getAll?pageHelpData.pageState=6" class="well form-search"  id="disForm" method="post">
<div class="wrapbg_gp">
  <div class="current">当前位置：
   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/page_manager/key/getAll?pageHelpData.pageState=6" target="frame_main">Page管理</a> </span> </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
		<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
		
			<tr>
				<td style="width: 40px">域名:</td>
				<td style="width: 140px;"><input style="width: 90px" type="text" name="pageHelpData.pageDomain" value="${param['pageHelpData.pageDomain'] }"></td>
				<td style="width: 80px">page名称:</td>
				<td style="width: 140px;"><input style="width: 120px" type="text" name="pageHelpData.pageName" value="${param['pageHelpData.pageName'] }"></td>
			 	<td style="width: 70px">公司名称:</td>
				<td style="width: 140px;" ><input style="width: 90px" type="text"  name="pageHelpData.company" value="${param['pageHelpData.company'] }"></td>
					<tr>
				<td style="width: 100px">独立/二级:</td>
				<td><input type="radio"   name="pageHelpData.pageType" value="1" /> 独立域名
				&nbsp
				<input type="radio"  name="pageHelpData.pageType" value="2"/>二级域名
				</td>
			
				<!-- <tr>
				<td style="width: 70px">是否认证:</td>
				<td><input type="radio" name="ss" value=""/> 已认证
				&nbsp
				<input type="radio" name="ss" value="二级域名"/>未认证
				</td>
				<td style="width: 70px">独立账号:</td>
				<td><input style="width: 120px" type="text" name="pageHelpData.loginMail" value=""></td>
				</tr> -->
				<tr>
				<td style="width: 70px">创建时间:</td>
				<td><input id="time" style="width: 120px" type="text" name="pageHelpData.createStartTime" value="${param['pageHelpData.createStartTime'] }">
				至<input style="width: 120px" id="time2" type="text" name="pageHelpData.createEndTime" value="${param['pageHelpData.createEndTime'] }"></td>
				<td style="width: 70px">发布时间:</td>
				<td><input id="time3" style="width: 120px" type="text" name="pageHelpData.StartTime" value="${param['pageHelpData.StartTime'] }">
				至<input style="width: 120px" id="time4" type="text" name="pageHelpData.EndTime" value="${param['pageHelpData.EndTime'] }"></td>
			</tr>
			<tr>
			
			<td colspan="8"><div style="margin:0 0 0 20px;padding-right: 50px;" align="right"> <input type="submit" value="" class="Btn_TopSearch"></div></td>
			</tr>
		</table>

	</div>
	</div>
	</div>
	
	<!-- 禁用div -->
		<div id="dialog-message" title="禁用">
	       <div style="display: none;" id="pwdDiv" onclick="" >
			<table>
			<tr>
				<td>
					<div style="margin-top: 30px;">
						<select style="width:140px;" name="pageData.disabledType" id="disabledType">
							 <s:iterator id="yy" value="#session.disabledType"> 	 			
								<option value="<s:property value="#yy.key"/>"><s:property value="#yy.value"/></option>
							 </s:iterator>
						</select>
					</div>
				</td>
				<td>
					<div style="margin-top: 20px;margin-left: 20px;"><textarea  rows="7" cols="40" style="resize:none;" name="pageData.disabledReason" id="disabledReason"></textarea>
					</div>  
				</td>
			</tr>
		
			</table>
			<!-- </form> -->
			</div>
			</div>
		<div align="right" style="margin-right: 10px;margin-top: 5px;">	
	<span >排序：<a href="${root }/page_manager/key/getAll?sortTime=${sortTime eq 1?1:0 }" target="frame_main">按创建时间</a> </span>
	</div>
  <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabTitle">
        	<input type="hidden" name="pageHelpData.pageState" value="${pageHelpData.pageState}" class="state">
     		   <ul id="myTab00">
           <li class=${pageHelpData.pageState==6?"active":"normal" } value="6">全部</li> 
           <li class=${pageHelpData.pageState==1?"active":"normal" } value="1">发布Page</li> 
	       <li  class=${pageHelpData.pageState==0?"active":"normal" } value="0">暂存Page</li>
		   <li class=${pageHelpData.pageState==2?"active":"normal" } value="2">已禁用Page</li>
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
        		<td>登录账号</td>
        		<td>操作</td>
        	</tr>
        	  <c:forEach var="page" items="${pageDatas}" varStatus="status">
    
        	<tr>
        		<td>
        		<c:if test="${page.status==1}">
        		<input type="checkbox"  value="${page.id}"  name="ids" class="clPageIds"> 
        		</c:if>
        		</td>
        		<td>${status.index+1 }</td>
				<td>${page.name }</td>
	
        		<td >
        		<c:if test="${page.pageInfoExtra.domain != ''}">
        		<a href="${path}${page.pageInfoExtra.domain }" style="color: #2b6db4;text-decoration: none;" target="_blank">${path}${page.pageInfoExtra.domain }</a></c:if>
        		</td>
        		<td>
        		<c:if test="${page.status==0 }">暂存</c:if>
        		<c:if test="${page.status==1 }">已发布</c:if>
        		<c:if test="${page.status==2 }">禁用</c:if>
        		<c:if test="${page.status==3 }">编辑中</c:if>
        		<c:if test="${page.status==4 }">启用</c:if>
        		 </td>
        		<td>
        		 <fmt:formatDate value="${page.createTime }" type="date"/>
        		</td>
        		<td>${page.userData.loginMail }</td>
        		<td>
        	
           		<c:if test="${page.status==1 }">
        		<a href="###" class="  showDiv"  data="${page.id}" >禁用</a>|
        		</c:if>
        		<%-- <c:if test="${page.status==2 ||page.status==0}">
        			<a href="###" class="startPageState"  data="${page.id}"  data1="${page.hasShop}"  data2="${page.hasOrder}"  data3="${page.name }" data4="${page.pageInfoExtra.domain }" data5="${page.pageInfoExtra.domain }">发布</a>|
        		</c:if> --%>
        		<a href="/page_manager/key/getPageView?pageHelpData.pageId=${page.id}" class="green" style="color: #06c;">查看详情</a>
        		</td> 
        	</tr>

        </c:forEach>
        </table>
		<page:PageRoll/>
        <a href="###" class="btn_tianjia  deletePage">删除</a>
  				 </div>
  		 </div>
   </div>
   </div>
			</form>

     
      
   
</body>
</html>