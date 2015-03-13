<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"    src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap-modal.js"></script>
<script type="text/javascript"	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/front/template/Template.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/compmanage/compList.js"></script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<link href="${root }/view/css/mini/templateShop/css/backTemplate.css" rel="stylesheet" type="text/css" />
<title>组件管理</title>
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
</head>
<body>
<div class="current" >当前位置：
 <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }${root }/comp_manage/key/searchComponent" target="frame_main">组件管理</a></span> </div>
<form action="${root }/comp_manage/key/searchComponent" method="post">
<div class="wrapbg_gp">
  <div id="ContentDiv">
    <div class="User_TopSearch">
			<input type="hidden" name="searchType" value="1">
			<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td style="width: 70px">模板风格:</td>
					<td>
						<select name="componentData.cssType"  style="width:150px;"  >
						  <s:iterator id="cs" value="#session.csstype">
						<option value="<s:property value="#cs.key"/>"><s:property value="#cs.value"/>	</option>
						</s:iterator>
						</select>
					</td>
					<td style="width: 70px">创建时间:</td>
					<td><input id="time" style="width: 120px" type="text" name="componentData.createTime" value="${param['componentData.createTime']}">至
					<input style="width: 120px" id="time2" type="text" name="componentData.modifyTime" value="${param['componentData.modifyTime']}"></td>
					<td>
					<input  type="submit" value="" class="Btn_TopSearch" />
					</td>
				</tr>
			</table>
	</div>
</div>
</div>



	
	  <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabContent">
   			 <div class="hm_content">
		 		 <table  width="100%" border="0" cellspacing="1" cellpadding="1">
		        	<tr>
		        		<td>编号</td>
		        		<td>组件类型</td>
		        		<td>组件名称</td>
		        		<td>组件价格</td>
		        		<td>创建时间</td>
		        		<td>操作</td>
		        	</tr>
		        	 <c:forEach var="componentData" items="${componentDatas }" varStatus="i">
		        	 <tr>
		        	 	<td  <c:if test="${fn:length(componentData.classDatas) eq '0'}">
		        	 style="background-color: #AAAAAA;"
		        	 </c:if>
		        	 >${i.index+1 }</td>
		        	   	<td
		        	   	 <c:if test="${fn:length(componentData.classDatas) eq '0'}">
		        	 style="background-color: #AAAAAA;"
		        	 </c:if>
		        	   	>
		        	   	<c:if test="${componentData.type==1 }">模板框架组件</c:if>
		        		<c:if test="${componentData.type==2 }">导航组件</c:if>
		        		<c:if test="${componentData.type==3 }">banner组件</c:if>
		        		<c:if test="${componentData.type==4 }">理由组件</c:if>
		        		<c:if test="${componentData.type==5 }">普通组件</c:if>
		        		<c:if test="${componentData.type==6 }">导航锚点</c:if>
		        	   	${componentData.type }</td>
		        	 	<td
		        	 	 <c:if test="${fn:length(componentData.classDatas) eq '0'}">
		        	 style="background-color: #AAAAAA;"
		        	 </c:if>
		        	 	>${componentData.name }</td>
		        	 	<td
		        	 	 <c:if test="${fn:length(componentData.classDatas) eq '0'}">
		        	 style="background-color: #AAAAAA;"
		        	 </c:if>
		        	 	>${componentData.price }</td>
		        	 	<td
		        	 	 <c:if test="${fn:length(componentData.classDatas) eq '0'}">
		        	 style="background-color: #AAAAAA;"
		        	 </c:if>
		        	 	> <fmt:formatDate value="${componentData.createTime }" type="date"/></td>
		        	 	<td>
		        		 <a href="${root }/component_class/key/toAddComClass?componentData.id=${componentData.id}" class="green" >添加样式风格</a>
		        	 	 <a href="${root}/comp_manage/key/getComponentByid?componentData.id=${componentData.id}" data="${componentData.id}" class="blue updateCom" style="color: #06c;">修改</a>
		        	 	 <a href="###" data="${componentData.id}" class="green deleteCom" style="color: red;">删除</a>
		        	 	</td>
		        	 </tr>
		        	 </c:forEach>
		        </table>
		<page:PageRoll/>
  				 </div>
  		 </div>
   </div>
   </div>
	</form>
	
	<a href="${root }/comp_manage/key/add" class="btn_tianjia" id="addTemp"  style="margin-bottom: 50px;margin-left: 20px;">添加组件</a>
</body>
</html>