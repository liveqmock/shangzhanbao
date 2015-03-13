<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
             <%@include file="/mini_top.jsp"%>
    <%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	long sDate = System.currentTimeMillis();//第二个时间值
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<script type="text/javascript" src="${root}/view/js/minipage/front/tempmanage/ownTempList.js"></script>
<title>模板管理 - 商站宝</title>
</head>
<body>

<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 

  
  <div class="UserCenter_Right"  >
	 <form action="" method="post">
	 <c:if test="${!empty templateDatas}">
		    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>可用模板</h1>
      </div>
		      <div class="widget-content">
		        <table class="table">
		          <thead>
		            <tr>
		              <th width="51"></th>
		              <th width="150">模板名称 </th>
		              <th width="110">价格</th>
		              <th width="190">有效期</th>
		              <th width="160">商站名称</th>
		              <th width="90">操作</th>
		            </tr>
		          </thead>
		          <tbody>
		          <c:forEach var="templateData" items="${templateDatas }" varStatus="i">
		            <tr>
		              <td height="71">
		              	  <span class="" style="width:32px;height:32px;float:right;overflow:hidden;padding:0;margin-right:2px;">
		              	    <img src="${root }/images/mini/images/muban.png" style="width: 100%;height: auto;">
		                  </span>
		              </td>
		              <td><span class="span6"><a href="${root }/temp_manage/key/ajaxSearchTempById?id=${templateData.id }" target="_blank" date="${templateData.id}" class="font_blue">  ${templateData.name }
		           
		            
		              </a></span></td>
		              <td width="90"><span class="font_EN">
		              <c:if test="${templateData.price==null || templateData.price=='' || templateData.price=='0'}">
		              	免费
		              </c:if>
		              <c:if test="${templateData.price!=null && templateData.price!='' && templateData.price!='0'}">
		              	${templateData.price }元/年
		              	</c:if></span></td>
		              
		              <td><span class="font_EN">
		              <c:if test="${templateData.price!=null && templateData.price!='' && templateData.price!='0'}">
		              <fmt:formatDate value="${templateData.ownTempData.ownTime }"  pattern='yyyy.MM.dd' type="date"/>-<fmt:formatDate value="${templateData.ownTempData.expireTime }"  pattern='yyyy.MM.dd' type="date"/>
		              </c:if>
		               <c:if test="${templateData.price==null || templateData.price == '0' || templateData.price == ''}">
		              	永久
		              	</c:if>
		              </span></td>
		              <td><span class="span6">
		            <c:if test="${templateData.pageHelpData.pageName!=null }">
		              <a href="${templateData.domain }?a=<%=new Date()%>" target="_blank" class="font_blue" style="margin-left: 10px;">${templateData.pageHelpData.pageName}</a>
		              </c:if>
		            <c:if test="${templateData.pageHelpData.pageName==null || templateData.pageHelpData.pageName == ''}"><a style="color: red;"> 未设置名称</a></c:if>
		              </span></td>
		             <td><span class="span2">
		             	<c:set var="date" value="${templateData.ownTempData.expireTimeMs }"></c:set>
						<c:set var="sDate" value="<%=sDate%>"></c:set>
						<c:if test="${templateData.price!=null && templateData.price!='' && templateData.price!='0'}">
							<c:if test="${date-sDate>=0}">
							 <c:if test="${templateData.domain!=''}">
								<a href="${templateData.domain }?a=<%=new Date()%>" target="_blank">查看商站</a>
								</c:if>
								<!-- 域名空的时候，且，page的状态为编辑中，就去编辑页面 -->
						 		<c:if test="${templateData.domain==''}">
								 <a href="${root }/page_manage/key/toedit?id=${templateData.pageId}" target="_blank">修改</a>
								</c:if> 
							</c:if>
							<c:if test="${date-sDate<0 }">
								<a href="###">续费</a>
							</c:if>
						</c:if>
						<c:if test="${templateData.price==null || templateData.price=='' || templateData.price=='0'}">
						 <c:if test="${templateData.domain!=''}">
							<a href="${templateData.domain }?a=<%=new Date()%>" target="_blank">查看商站</a>
						</c:if>		
							<!-- 域名空的时候，且，page的状态为编辑中或者暂存，就去编辑页面 -->
							<c:if test="${templateData.domain==''}">
								 <a href="${root }/page_manage/key/toedit?id=${templateData.pageId}" target="_blank">修改</a>
								 </c:if>
						</c:if>
		             </span></td>
		            </tr>
		            </c:forEach>
		            <tr><td colspan="6" height="40"><div style="float:right"> <page:PageRoll/></div></td></tr>
		          </tbody>
		        </table>
		      </div>
		    </div>
 						  </c:if>
					</form>
					    <c:if test="${empty templateDatas}">
							    <div class="DataStatistics_box">
				        		<h1>还没有可用模板!</h1>
				      	 		<div style="margin:10px 0 0 10px"></div>
				     		</div>
					    </c:if>
   <!--  <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>已到期模板</h1>
      </div>
      <div class="widget-content">
      <form action="">
        <table class="table">
          <thead>
            <tr>
              <th width="85"></th>
              <th width="120">服务名称 </th>
              <th width="100">价格</th>
              <th width="170">有效期</th>
              <th width="200">使用PAGE</th>
              <th width="90">操作</th>
            </tr>
          </thead>
          <tbody> -->
<%--            <c:forEach var="limitTemplate" items="${limitTemplates }" varStatus="i"> --%>
<!--             <tr> -->
<%--               <td><span class="span7"><img src="${root }${limitTemplate.esc}"></span></td> --%>
<%--               <td><span class="span6">${limitTemplate.name }</span></td> --%>
<!--               <td width="90"><span class="font_EN"> -->
<%--               <c:if test="${limitTemplate.price==null || limitTemplate.price==''}"> --%>
<!--               	0 -->
<%--               </c:if> --%>
<%--               <c:if test="${limitTemplate.price!=null }"> --%>
<%--               	${limitTemplate.price }元/年 --%>
<%--               </c:if></span></td> --%>
<!--               <td><span class="font_EN"> -->
<%--               <c:if test="${limitTemplate.price==null || limitTemplate.price==''}"> --%>
<%--               <fmt:formatDate value="${limitTemplate.ownTempData.ownTime }"  pattern='yyyy.MM.dd' type="date"/>-<fmt:formatDate value="${limitTemplate.ownTempData.expireTime }"  pattern='yyyy.MM.dd' type="date"/> --%>
<%--               </c:if> --%>
<%--                <c:if test="${limitTemplate.price!=null || limitTemplate.price == '0'}"> --%>
<!--               	免费 -->
<%--               	</c:if> --%>
<!--               </span></td> -->
<%--               <td><div class="span9"><a href="#" class="font_blue">${limitTemplate.domain }</a></div></td> --%>
<!--              <td><span class="span2"> -->
<%--              	<c:set var="date" value="${limitTemplate.ownTempData.expireTimeMs }"></c:set> --%>
<%-- 				<c:set var="sDate" value="<%=sDate%>"></c:set> --%>
<%-- 				<c:if test="${limitTemplate.price!=null && limitTemplate.price!=''}"> --%>
<%-- 					<c:if test="${date-sDate>=0}"> --%>
<!-- 						<a href="###">查看Page</a> -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${date-sDate<0 }"> --%>
<!-- 						<a href="###">续费</a> -->
<%-- 					</c:if> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${limitTemplate.price==null || limitTemplate.price==''}"> --%>
<%-- 					<a href="${limitTemplate.domain }" target="_blank">查看Page</a> --%>
<%-- 				</c:if> --%>
<!--              </span></td> -->
<!--             </tr> -->
<%--             </c:forEach> --%>
         <!--  </tbody>
        </table> -->
<!--         <div style="clear:both"></div> -->
<!--         	<div class="pagination"> -->
<!--         		<ul> -->
<%--         			<li><span>共 <font color="red"></font>${pageRoll2.totalRows }条记录</span></li> --%>
<%--         			<li><span>当前 <font color="red"></font><font color="red">${pageRoll2.currentPage+1}</font> 页</span></li></li> --%>
<!--         		</ul> -->
<%--         		<input type='hidden' name='pageRoll2.currentPage' class='pageRollHidden' value='0' data-value='${pageRoll2.currentPage }'> --%>
<!--         		<ul> -->
<%--         		<c:if test="${pageRoll2.currentPage>3 }"> --%>
<!--         			<li><a href='javascript:void(0)' onclick='$(this).closest("form").find("input.pageRollHidden").val(0);$(this).closest("form").submit();'></a></li> -->
<%--         		</c:if> --%>
<%--         		<c:if test="${pageRoll2.currentPage>=4 }"> --%>
<%--         			<c:if test="${pageRoll2.currentPage-3>1 }"> --%>
<!--         				<li><span>...</span></li> -->
<%--         			</c:if> --%>
<%--         		</c:if> --%>
       <!--  </form>
      </div>
    </div> -->
    <c:if test="${!empty recommendTemplates}">
	    <div class="DataStatistics_1">
		      <div class="DataStatistics_1Title">
		        <h1>推荐模板</h1>
		      </div>
		      <div class="DataStatistics_3">
		        <dl>
		        <c:forEach var="recommendTemplate" items="${recommendTemplates }" varStatus="i">
		          <dt><span><img src="${root }${recommendTemplate.imgpath}"></span><font>
		          <a href="${root }/temp_manage/key/ajaxSearchTempById?id=${recommendTemplate.id }&userData.id=${userData.id }" date="${recommendTemplate.id}" class="searchRecommend font_blue" target="_black">${recommendTemplate.name }</a></font></dt>
		          <c:if test="${i.index !=0 && i.index%2 != 0 }">
		          <br>
		          </c:if>
		          </c:forEach>
		        </dl>
		      </div>
	    </div>
	   </c:if>
  </div>
  </div>
<%@include file="/mini_end.jsp"%>

</body>
</html>