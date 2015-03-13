<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/pageManager/pageManagerView.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />

<link rel="stylesheet" href="${root}/view/css/jquery-ui.css">
<script src="${root}/view/js/util/jquery-ui.js"></script>


<style type="text/css">
.viewTa tr td{
 width: 140px;
 height: 30px;
}
.spanDiv {
margin-left: 10px;
background-color: #999999;
width: 140px;
height: 30px;
margin-top: 18px;
text-align: center;
} 
.spanDiv a{
line-height: 30px;
color: #fff;
text-decoration: none;
}
.tdClass{
  font-size: 14px;
  font-weight: bold;
  width: 120px;
}
.tdClassN{
  font-size: 14px;
 
}

</style>
<title>Page信息</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<a href="###" id="myBankOpDiv" style="display:none;">启用</a>
<a href="###" id="myqiDiv" style="display:none;">启用成功</a>
<a href="###" id="myDisDiv" style="display:none;">禁用</a>
<a href="###" id="myDiv" style="display:none;">停用成功</a>
<div  id="selDis" style="display: none;">${sel}</div>
<input  type="hidden" value="" id="changDis">
  <div class="current">当前位置：
   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/page_manager/key/getAll?pageHelpData.pageState=6" target="frame_main">Page管理</a>  <b>>></b><a href="/page_manager/key/getPageView?pageHelpData.pageId=${page.id}" target="frame_main">Page详情</a>  </span> </div>
  <div id="ContentDiv">
  </div>
<!--   <div id="dialog" title="Basic dialog">
  <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div> -->
  <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
<!--  </div> -->
	<table class="viewTa"   style="margin-left:20px;">
		<tr>
			<td class="tdClass">page名称:</td>
			<td class="tdClassN">${page.name}</td>
		</tr>
		<tr>
			<td class="tdClass">page域名:</td>
			<td class="tdClassN"> 
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${ pageinfo.status  eq'OPEN'}">
			<a  href="${pagePath}${pageinfo.domain}" target="_blank">${pagePath}${pageinfo.domain}</a>
			</c:if>			
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="tdClass">绑定时间时间:</td>
			<td class="tdClassN">
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${pageinfo.status  eq 'OPEN'}">
			
			<fmt:formatDate value="${pageinfo.bindingTime}"/>
			</c:if>			
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="tdClass">二级域名:</td>
			<td class="tdClassN"> 
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${pageinfo.type==2 && pageinfo.status  eq'OPEN'}">
			<a  href="${pagePath}${pageinfo.domain}" target="_blank">${pagePath}${pageinfo.domain}</a>
			</c:if>			
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="tdClass">创建时间:</td>
			<td class="tdClassN"> <fmt:formatDate value="${page.createTime}" type="date"/></td>
		</tr>
		<tr></tr>
		<tr>
			<td class="tdClass">当前模板:</td>
			<td class="tdClassN"><a  href="${root }/temp_manage/key/ajaxSearchTempById?id=${page.pageTemplateData.templateData.id}" target="top">${page.pageTemplateData.templateData.name}</a></td>
		</tr>
		<tr>
			<td class="tdClass">使用服务:</td>
			<td class="tdClassN">
			<c:forEach var="product" items="${page.pageProductDatas }">
			${product.productName }&nbsp;
			</c:forEach>
			</td>
		</tr> 
		<tr></tr>
		<tr>
			<td class="tdClass" >发布状态:</td>
			<td class="tdClassN">
			
			<c:if test="${page.status==0}">暂存</c:if>
			<c:if test="${page.status==1}">已发布</c:if>
			<c:if test="${page.status==2}">禁用</c:if>
			</td>
		</tr>
			<tr>
			<td class="tdClass">发布时间:</td>
			<td class="tdClassN"><fmt:formatDate value="${page.publishTime}" type="date"/></td>
		</tr>
		
			<tr>
			<td class="tdClass">发布权限有效期:</td>
			
			<td width="200px;"  style="width: 200px;"> 
			<c:if test="${page.status==1}">
			 	<c:if test="${page.publishTime!=null }">
					<fmt:formatDate value="${page.publishTime }" type="date"/>
					至
					<fmt:formatDate value="${page.endTime }" type="date"/>
				 </c:if> 
			</c:if>
			<c:if test="${page.status==0||page.status==2}">
			无
			</c:if>
			 </td>
		</tr>
		<!-- <tr>
			<td class="tdClass">认证状态:</td>
			<td class="tdClassN"></td>
		</tr> 
		<tr>
			<td class="tdClass">认证时间:</td>
			<td class="tdClassN"></td>
		</tr>  -->
		<tr>
			<td class="tdClass">独立域名:</td>
			<td class="tdClassN"> 
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${pageinfo.type==1 && pageinfo.status  eq'OPEN' }">
			${pageinfo.domain}
			</c:if>			
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="tdClass">绑定时间:</td>
			<td class="tdClassN">
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${pageinfo.type==1  && pageinfo.status  eq'OPEN'}">
			<fmt:formatDate value="${pageinfo.bindingTime}" type="date"/>
			</c:if>			
			</c:forEach>
			</td>
		</tr>
		</table>
		
		
		<!-- 禁用div -->
		<div id="dialog-message" title="禁用">
	       <div style="display: none"  class="DataStatistics_1Title" id="pwdDiv" >
			<form  id="disForm" method="post">
			<table>
			<tr>
			<td>
			<div style="margin-top: 20px;">
			<select style="width:140px;" name="pageData.disabledType" id="disabledType">
			 <s:iterator id="yy" value="#session.disabledType"> 	 			
			<option value="<s:property value="#yy.key"/>"><s:property value="#yy.value"/>	</option>
			</s:iterator>
		
			</select>
			</div>
			</td>
			<td><div style="margin-top: px;margin-left: 20px; "><textarea rows="7" cols="12"  style="resize:none;" name="pageData.disabledReason" id="disabledReason"></textarea></div>  </td>
			</tr>
			</table>
			</form>
			</div>
			</div>
			
			<!-- 隐藏域 -->
			<input type="hidden"   value="${page.id}"   name="pageid" id="pageid"> 
			<input type="hidden"   value="${page.ymId}" name="pageProductId" id="pageProductId"> 
			<!-- 禁用div -->
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
			<c:if test="${pageinfo.type==1  && pageinfo.status  eq'OPEN'}">
			<input type="hidden"   value="${pageinfo.id}"  name="pageInfoId" id="pageInfoId"> 
			</c:if>	
			</c:forEach>
			<!-- 解绑域名 -->
			<div style="margin-top:-300px;;margin-left:350px;width: 450px;height:250px;display:none ;box-shadow:2px 2px 30px #909090; position: absolute;" id="daDiv" class="DataStatistics_1Title">
			
				<table>				
				<tr><td> 	
				<font style="font-size: 22px;left: 30px; top: 20px;position: absolute;" >解绑域名</font>
				</td></tr>
		
	 	<tr><td>
	 	<div class="DataStatistics_1"  style="left: 40px; top: 60px; width: 370px; height: 80px; position: absolute;">
		<div   style="left: 80px; top: 10px; width: 370px; height: 80px; position: absolute;">
					<p style="text-align: left;margin-left:-50px;margin-top: 5px;">请确认是否帮客户解除域名绑定,解绑后，独立</p>
					<p style="text-align: left;margin-left:-50px;margin-top: 5px;">域名将立即失效，是否确认解绑？</p>
					
		</div>
		</div>

		</td></tr>
			<tr > 
			<td><span class="spanDiv" style="margin-left:90px;color: #FFFFFF;margin-top: 150px;"><a href="###" class="dashide" style="">取消</a></span>
			<span class="spanDiv" style="color: #FFFFFF;margin-top: 150px;"><a href="###" class="dahuaPageInfoExtraInfo" >确定</a></span></td>
			<tr>
			</table>
			</div>
		
			<!-- 解绑域名 -->
			
			<!-- 绑定独立域名 -->
			<div id="dialog" title="绑定独立域名" >
					<div  style="display: none;" class="DataStatistics_1Title domainDiv" >
			<form action="" id="domainFrom" method="post">
				<table>				
		
	 	<tr><td>
	 	<div class="DataStatistics_1"  style="left: 50px; top: 60px; width: 420px; height: 140px; position: absolute;">
		<div   style="left: 80px; top: 10px; width: 420px; height: 140px; position: absolute;">
					<p style="text-align: left;margin-left:-50px;margin-top: 5px;">1. 请先去域名服务提供商申请一个独立域名</p>
					<p style="text-align: left;margin-left:-50px;margin-top: 5px;">2. 如果你已申请或者有备用域名，请在下面输入域名：</p>
					<input type="text" value="" id="domain" name="domain" style="width: 350px;height: 40px;margin-left: -50px;margin-top: 10px;"> 	
		</div>
		</div>

		</td></tr>
			<tr style="height: 8px;"></tr>
			<!-- <tr><td><h3>绑定独立域名</h3></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>1. 请先去域名服务提供商申请一个独立域名</td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>2. 如果你已申请或者有备用域名，请在下面输入域名：</td></tr>
			<tr></tr>
			<tr><td> <input type="text" value="" id="domain" name="domain" style="width: 400px;height: 40px;margin-left: 50px;"> </td></tr>
			<tr></tr>-->
			<tr><td> <input type="submit" value="提交" id="domainbound" style="width: 420px;height: 40px;margin-left: 50px;background-color: #444444;color: #ffffff;margin-top: 200px;"> </td></tr>
			<tr></tr> 
			<tr><td> <h5>推荐域名服务提供商：</h5> </td></tr>
			<tr></tr>
			<tr><td> <a href="www.net.cn" target="_blank">中国万网</a> &nbsp; &nbsp; &nbsp;
			 <a href="www.xinnet.com " target="_blank">新网</a></td></tr>
			</table>
			</form>
			</div>
			</div>
	
			
		
		 <div style="width: 980px;height:60px; filter: alpha(opacity=70); opacity: 0.7; background-color: #cccccc;border-style: solid;margin-left:15px;" >
			<span style="line-height: 60px;float: left;">管理员操作：</span>
		<%-- 	<c:if test="${page.status==2}">
				<span class="spanDiv"><a href="#"  class="startPageState" data="${page.id}">发布</a></span>
			</c:if> --%>
			<c:if test="${page.status==1}">
			<span class="spanDiv"><a href="#" class="showDiv"  data="${page.id}" style="text-align: center;">禁用</a></span>
			</c:if>
				<c:if test="${page.status==2}">
			<span class="spanDiv"><a href="#" class="startPageState"  data="${page.id}" data1="${page.status}">启用</a></span>
			</c:if>  
			<%-- <span class="spanDiv"><a href="">查看认证信息</a></span>--%>
		<%-- 	<span class="spanDiv"><a href="${root }/accesstatistics/key/backJumpToJsp?sign=week&pageDataId=${page.id}&pageDataName=${page.name}">查看数据</a></span> --%> 
			
		<!-- 	</ul> -->
		<%-- <c:if test="${page.userData.userType==1}">
			<span class="spanDiv"><a href="#" class="showPower"  data="${page.id}">授权</a></span>
		</c:if> --%>
		</div>
		<div style="width: 30px;"></div>
		 <div style="margin-left:15px;width: 980px;height:60px;margin-top:10px; filter: alpha(opacity=70); opacity: 0.7; background-color: #cccccc;border-style: solid;" >
		<span style="line-height: 60px; float: left;">page代运营：</span>
			
			<span class="spanDiv"><a href="${root }/page_manage/key/toedit?id=${page.id}"  target="_blank">编辑page</a></span>
<%-- 			<span class="spanDiv"><a href="">部署可信网站</a></span> --%>
			<c:if test="${page.hasOrder==2 }">  <!-- 已付款 -->
			<span class="spanDiv">
			<!-- 启用 -->
			<c:if test="${page.pageStatusCredible!=1 }">
			<a href="###" onclick="opentalkDiv()" data="${page.id}">部署talk99</a>
			</c:if>
			<!-- 停用 -->
			<c:if test="${page.pageStatusCredible==1 }">
			<a href="###" onclick="extraUpdate()" data="${page.id}">停用talk99</a>
			</c:if>
			</span>
			</c:if>
			
			<c:if test="${ fn:length(page.pageInfoExtraData)==2}">
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
					<c:if test="${pageinfo.type==1 && pageinfo.status  eq 'OPEN'}">
			<span class="spanDiv"><a href="###" class="dashow">解绑域名</a></span>

			</c:if>		
			
			<c:if test="${pageinfo.type==2 && pageinfo.status  eq 'OPEN' }">
			<span class="spanDiv"><a href="###" class="boundshow">绑定域名</a></span>

			</c:if>			
			</c:forEach>
			</c:if>
			 <c:if test="${ fn:length(page.pageInfoExtraData)==1}"> 
			 
			<c:forEach var="pageinfo" items="${page.pageInfoExtraData }">
		
			<c:if test="${pageinfo.type==2}">
			<span class="spanDiv"><a href="###" class="boundshow">绑定域名</a></span>
			</c:if>			
			</c:forEach>
			</c:if>
			
		</div>
	 <div style="margin-top:-450px;margin-left:300px;width: 340px;height:230px;display:none; box-shadow:2px 2px 30px #909090;position: absolute;" id="PowerDiv" onclick="" class="DataStatistics_1Title ">
			<a href="#"  onclick="closedDiv()" style="float: right;margin-top: 2px;margin-right:10px;color: #000;">关闭</a>
		<form action="" id="PowerPage" method="post">
			<table>
			<tr>
				<td>
					<div style="margin-top: 30px;margin-left: 20px;">
						<%-- <select style="width:100px;" name="pageData.disabledType" id="disabledType">
							 <s:iterator id="yy" value="#session.disabledType"> 	 			
								<option value="<s:property value="#yy.key"/>"><s:property value="#yy.value"/></option>
							 </s:iterator>
						</select> --%>
						请输入授权的用户名称：
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="margin-top: 20px;margin-left: 20px;">
						<!-- <textarea rows="7" cols="30" style="resize:none;" name="pageData.disabledReason" id="disabledReason"> -->
					<input type="text" id="powerUserName" name="powerUserName" value="" notnull="请填写用户名" ajax="${root }/user/key/ajaxCheckUser,userData.loginMail,1,没有此用户">
					<!-- </textarea> -->
					</div>  
				</td>
			</tr>
			<tr>
				<td>
				<div style="margin-top: 5px;margin-left: 120px;"><input style="height: 30px;width:80px;" type="button" name="updatesubmit" value="提交修改" class="submit" onclick="poverPage('${page.id}');" /></div>
				</td>
			</tr>
			</table>
			</form>
			</div>
	
	
</body>
</html>