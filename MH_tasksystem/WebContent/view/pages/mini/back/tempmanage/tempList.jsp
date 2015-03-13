<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/tempmanage/tempList.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript">
	var searchType = "${param['searchType']}";
</script>
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
        });
    </script>
<title>模板管理</title>
</head>

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
<body style="height:100%;border-top:1px solid #D5D5D5;">
		<form action="${root }/temp_manage/key/searchAllToAdmin" class="well form-search" method="post" id="tempFrom"> 
<div class="wrapbg_gp">
  <div class="current">当前位置：
   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main">模板管理</a> </span> </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
		<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td style="width: 70px">模板编号:</td>
				<td><input style="width: 120px" type="text" name="templateData.sn"      value="${param['templateData.sn'] }"></td>
				<td style="width: 70px">上传人:</td>
				<td>
					<input style="width: 120px" type="text" name="templateData.uploadingName" value="${param['templateData.uploadingName'] }">
				</td>
				<td style="width: 70px">上传时间:</td>
				<td><input id="time" style="width: 120px" type="text" name="templateData.openTime"  value="${param['templateData.openTime'] }">
				至<input style="width: 120px" id="time2" type="text" name="templateData.closeTime"  value="${param['templateData.closeTime'] }"></td>
				<td>
				<input  type="submit" value="" class="Btn_TopSearch" />
				</td>
			</tr>
		</table>
<!-- 	</form> -->
			</div>
		</div>
		</div>
	
	  	  <div class="" align="right" style="margin-right: 10px;margin-top: 5px;">
	  	   <span>排序：</span>&nbsp;&nbsp;&nbsp;&nbsp;
       <span><a  href="${root}/temp_manage/key/searchAllToAdmin?type=uploadingtime&sortTime=${sortTime eq 1?1:0 }&templateData.status=1">按上传时间</a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span><a href="${root}/temp_manage/key/searchAllToAdmin?type=pcount&sortPage=${sortPage eq 1?1:0 }&templateData.status=1">按创建Page数</a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span><a href="${root}/temp_manage/key/searchAllToAdmin?type=Openpcount&sortUse=${sortUse eq 1?1:0 }&templateData.status=1">按使用Page数</a> </span>
      	</div>
      	
     

  <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabTitle">
     		   <input type="hidden" name="templateData.status" value="${templateData.status}" class="state">
     		   <ul id="myTab00">
       		 <li 
       		 <c:if test="${templateData.status==1 }">class="active"</c:if>
       		 <c:if test="${templateData.status!=1 }">class="normal"</c:if>
       	 		value="1"  >全部</li> 
          	 <li 
          	 <c:if test="${templateData.status==2}">	class="active"</c:if>
          	  <c:if test="${templateData.status !=2}">	class="normal"</c:if>
          	  value="2"  >已启用模板</li> 
          	 <li <c:if test="${templateData.status==3}">class="active"	</c:if>
          	  <c:if test="${templateData.status !=3}">class="normal"</c:if>
          	   value="3"  >未启用模板</li> 

		      </ul>
      </div>
 </div>
      <div class="TabContent">
   			 <div class="hm_content">
 

		 <table  width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
			<td></td>
				<td>编号</td>
				<td>模板编号</td>
				<td>模板名称</td>
				<td>上传时间</td>
				<td>上传人</td>
				<td>状态</td>
				<td>创建的page数</td>
				<td>正在使用的page数</td>
				<td>操作</td>
			</tr>
			<c:forEach var="templateData" items="${templateHelpDatas}" varStatus="i">
		
			<tr>
				<c:if test="${templateData.sumTemp==0}">
				<td>
				<c:if test="${templateData.status eq 'CLOSED'}">	
				<input type="checkbox" value="${templateData.id}"  class="checkId" id="tempIds" name="tempIds">
				</c:if>
				&nbsp;
				</td>
				</c:if>
				<c:if test="${templateData.sumTemp!=0}">
				<td>
				&nbsp;
				</td>
				</c:if>
				<td>${i.index+1 }</td>
				<td>${templateData.sn }</td>
				<td>${templateData.name }</td>
				<td><fmt:formatDate value="${templateData.uploadingTime }" type="date"/></td>
				<td>${templateData.uploadingName }</td>
				<td>${templateData.status }</td>
				<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${templateData.sumTemp}</td>
				<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${templateData.sumOpenTemp }</td>
				<td>
					<input type="hidden" value="${templateData.id }" class="tempId_${i.index+1}" />
					<c:if test="${templateData.sumTemp==0 }">
				<c:if test="${templateData.status eq 'CLOSED'}">				
				<%-- 	<a href="${root}/temp_manage/key/updateTempState?templateData.id=${templateData.id}&templateData.status=OPEN" class="btn btn-primary" data="11111">启用</a> --%>
						<a href="##"  id="closedTemp" onclick="openTemp('${i.index+1}')" class="green">启用</a>|
					</c:if>
					<c:if test="${templateData.status eq 'OPEN'}">
					<%-- <a href="${root}/temp_manage/key/updateTempState?templateData.id=${templateData.id}&templateData.status=CLOSED" class="btn btn-primary">停用</a> --%>
					<a href="##"  id="closedTemp" onclick="closedTemp('${i.index+1}')" class="green">停用</a>|
					</c:if>
					</c:if>
					<a href="${root}/temp_manage/key/getTemplateDataView?templateData.id=${templateData.id}" class="blue">查看详情</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<page:PageRoll/>
					<span><a href="${root }/back_temp_manage/key/searchComponentAndPic?componentData.type=1" class="uploadTemp btn_tianjia">新增</a>&nbsp<a href="###" class="btn_tianjia" id="deleteTemp">删除</a></span>
						</div>
					</div>
				</div>
	</form>
	
	

</body>
</html>