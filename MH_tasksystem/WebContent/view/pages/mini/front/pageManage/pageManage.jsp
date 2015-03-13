<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${root}/view/css/ctn.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>



<script type="text/javascript" src="${root}/view/js/minipage/front/pageManage/pageManage.js" type="text/javascript"></script>
<title>page管理</title>
</head>
<body>
        
       	
 
 
 
        <form action="${root }/page_manage/key/getAllPaga" method="post">
           <table class="table table-striped">
                <tr>
                   <td> <a href="${root }/page_manage/key/getAllPaga">全部page</a><br></td>
                    <td> <a href="${root }/page_manage/key/getAllPaga?pageData.status=0">暂存page</a></td>
                     <td><a href="${root }/page_manage/key/getAllPaga?pageData.status=1">已发布page</a></td>
                </tr>
            </table>
            
           <table class="table table-striped">
            <c:forEach var="pageData" items="${pageDataList}">
	       		<tr id="${pageData.id}">
	        		<td width="150"><%-- ${pageData.id} --%></td>
	        		<td width="150">${pageData.name}</td>
	        		<c:if test="${pageData.use==1 && pageData.state==0}">
	        		<td>试用</td>
	        		</c:if>
	        		<c:if test="${pageData.use==0}">
	        		<td>过期</td>
	        		</c:if>
	        		
	        		<td width="150">
	        		    <c:forEach items="${pageData.pageInfoExtraData}" var="ExtraData">
	        		         <c:if test="${ExtraData.status=='OPEN'}">
	        		           ${ExtraData.domain}
	        		         </c:if> 
	        		    </c:forEach>
	        		</td>
	        		<td width="150">
	        		          <c:forEach items="${pageData.pageInfoExtraData}" var="ExtraData">
	        		               <c:if test="${ExtraData.status=='OPEN'}">
	        		               <a href="###" onclick="extraUpdate('${ExtraData.id}','${ExtraData.pageId}','${ExtraData.type}','${ExtraData.domain}','${pageData.name}')">设置</a><br>
	        		               </c:if>
	        		          </c:forEach>
	        		          <c:if test="${pageData.state==0}">
	        		          <a href="###" onclick="shengjiQuanXian('${pageData.id}')">升级发布权限</a><br>
	        		          </c:if>
	        		          <c:if test="${pageData.use==1}">
	        		          <a href="###" onclick="xuFeiQuanXian('${pageData.id}')">续费</a><br>
	        		          </c:if>
	        		          <a href="###" onclick="">编辑page</a><br> 
	        		           <c:if test="${pageData.status!=1}">
	        		          <a href="###" >发布</a><br>
	        		          </c:if>
	        		          <c:if test="${pageData.status!=1}">
	        		          <a href="###" onclick="publishPage('${pageData.id}')">发布page</a><br> 
	        		          </c:if> 
	        		          <a href="###" onclick="deletePaga('${pageData.id}')">删除</a><br>
	        		          <a href="###" onclick="duliYuMing('${pageData.id}')">独立域名</a><br>
	        		</td>
	        	</tr>
	        	<tr id="${pageData.id}">
	        		<td width="150"><img src="${root }${pageData.templateThumbnailData.path}"/><br>${pageData.templateData.name}</td>
	        		 
                    <td width="150">
	        		   <c:forEach items="${pageData.pageServiceDataList}" var="service">
	        		           ${service.name}
	        		   </c:forEach>
	        		</td>
	        	</tr>
          </c:forEach>
        </table>
        <table class="table table-striped">
                
          <c:forEach var="pageData" items="${pageDataList}">
	       		
          </c:forEach>
        </table>
        <page:PageRoll/>
        </form>
         <!-- 独立域名不存在弹出层 -->
         <div  style="background-color: #DDDDDD;display:none;width: 500px;height: 300px;position: absolute;margin-top: -240px;margin-left: 500px;" class="domainDiv">
			<table>
			<tr style="height: 8px;"></tr>
			<tr><td><h3>绑定独立域名</h3></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>1. 请先去域名服务提供商申请一个独立域名</td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>2. 如果你已申请或者有备用域名，请在下面输入域名：</td></tr>
			<tr></tr>
			<tr><td> <input type="text" value="" id="didomain" name="" style="width: 400px;height: 40px;margin-left: 50px;"> </td></tr>
			<tr></tr>
			<tr><td> <input type="button" value="提交" onclick="submitDuLiYuMing()" style="width: 400px;height: 40px;margin-left: 50px;background-color: #444444;"> </td></tr>
			<tr></tr>
			<tr><td> <h5>推荐域名服务提供商：</h5> </td></tr>
			<tr></tr>
			<tr><td> <a href="##">百度</a> &nbsp; &nbsp; &nbsp; <a href="##">谷歌</a></td></tr>
			</table>
		 </div>
		
		 <!-- 独立域名存在弹出层 -->
		 <div  style="background-color: #DDDDDD;display:none;width: 500px;height: 300px;position: absolute;margin-top: -250px;margin-left: 500px;" class="domainYesDiv">
			<table>
			<tr style="height: 8px;"></tr>
			<tr><td><h1>独立域名</h1></td></tr>
			<tr></tr>
			<tr></tr>
			<tr style="height: 8px;"></tr>
			<tr><td><h3>该商站已绑定独立域名</h3></td></tr>
			<tr style="height: 8px;"></tr>
			<tr></tr>
			<tr></tr>
			<tr><td> <input type="button" value="检查绑定情况" id="" style="width: 400px;height: 40px;margin-left: 50px;background-color: #444444;"> </td></tr>
			<tr></tr>
			</table>
		</div>
		
		
		 <!--设置 独立域名弹出层 -->
         <div  style="background-color: #DDDDDD;display:none;width: 500px;height: 300px;position: absolute;margin-top: -240px;margin-left: 350px;" class="SZDLdomainDiv">
			<table>
			<tr style="height: 8px;"></tr>
			<tr><td><h1>独立域名设置</h1></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>page名称:<input type="text" value="" id="pageNameDlym" name="" style="width: 300px;height: 40px;margin-left: 50px;"></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>独立域名: <span id="dlym" style="margin-left: 50px;"></span> </td></tr>
			<tr></tr>
			<tr><td>  </td></tr>
			<tr></tr>
			<tr><td> <input type="button" value="提交" onclick="submitSZDLYU()" style="width: 50px;height: 40px;margin-left: 150px;background-color: #444444;"> </td></tr>
			<tr></tr>
			</table>
		 </div>
		 
		 
		 
		 <!--设置 二级域名弹出层 -->
         <div  style="background-color: #DDDDDD;display:none;width: 500px;height: 300px;position: absolute;margin-top: -240px;margin-left: 350px;" class="SZEJdomainDiv">
			<table>
			<tr style="height: 8px;"></tr>
			<tr><td><h1>二级域名设置</h1></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>page名称:<input type="text" value="" id="pageNameEjym" name="" style="width: 300px;height: 40px;margin-left: 50px;"></td></tr>
			<tr style="height: 8px;"></tr>
			<tr>
			<td>二级域名：<span id="ejym" style="margin-left: 50px;"></span>
			     <input type="hidden" id="helpYm" name="" value="" style="width: 100px;height: 40px;">
			</td></tr>
			<tr></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr></tr>
			<tr><td> <input type="button" value="提    ----交" onclick="submitEjYuMing()" style="height: 40px;margin-left: 150px;background-color: #444444;"> </td></tr>
			<tr></tr>
			</table>
		 </div>
		 <input type="hidden" id="repageId" value="">
</body>
</html>