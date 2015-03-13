<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/pages/mini/privilege/privilege.js"></script>
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
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<title>客户管理</title>
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
<body>
<div class="current" style="color: #0044BB ;">当前位置：
<span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
   <span><a href="${root }/user_info/key/statistics" target="frame_main">发布权限管理</a> <b>>></b>
    <a href="${root }/give/key/findGiveList?give=1" target="frame_main" >查看赠送的记录</a>
   </span> </div>
   <div id="ContentDiv">
 <div class="nTab"> 
        <div class="TabTitle">
     		   <ul id="myTab00">
            <li 
             <c:if test="${give == 1}">class="active" </c:if>
              <c:if test="${give == 2}">style="border: 1px solid #979797;border-bottom: none;"</c:if>
              value="1" >
             <a 
             <c:if test="${give == 2}">style="text-decoration: none;color: black;"</c:if>
             href="${root }/give/key/findGiveList?give=1" >已送</a></li>
       <li  
        	
            <c:if test="${give == 2}">class="active" </c:if>
             <c:if test="${give == 1}">style="border: 1px solid #979797;border-bottom: none;"</c:if>
        	value="2">
        <a 
         <c:if test="${give == 1}">style="text-decoration: none;color: black;"</c:if>
        href="${root }/give/key/findGiveList?give=2">暂存</a></li> 
		    </ul>
      </div>
 </div>
    

        <form action="${root }/give/key/findGiveList" method="post">
        <div class="TabContent">
   			 <div class="hm_content">
       <table width="100%" border="0" cellspacing="1" cellpadding="1">
        	<tr>
        		<td>编号</td>
        		<td>赠送时间</td>
        		<td>客户数</td>
        		<td>客户查询条件</td>
        		<td>每个客户赠送个数</td>
        		<td>赠送总数</td>
        		<td>操作人</td>
        		<td>赠送消息</td>
        		<c:if test="${giveSign=='n'}">
        		<td>操作</td>
        		</c:if>
        	</tr>
        	<c:forEach	 var="c" items="${privilegeList}" varStatus="i">
   	     	<tr>
        		<td >${i.index+1 }</td>
        		<td ><fmt:formatDate value="${c.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        		<td>${c.userNum }</td>
        		<td >${c.condition}</td>
        		<td>${c.giveNum}</td>
        		<td>${c.totalNum }</td>
        		<td >${c.creatorName }</td>
        		<td align="center"><a href="###" onclick="findMessage('${c.message }','${i.index}')"  align="center">查看</a></td>
        		<c:if test="${c.give=='n'}">
        		<td><a href="###" id="deletegive${i.index }" onclick="deleteData('${i.index }')" class="btn_tianjia">删除</a><a href="###" class="btn_tianjia" onclick="sendData('${i.index }')">发送</a></td>
        		</c:if>
        	</tr>
        	<input type="hidden" id="message${i.index }" value="${c.message}"/>
        	<input type="hidden" id="createTime${i.index }" value="${c.createTime}"/>
        	<input type="hidden" id="condition${i.index }" value="${c.condition}"/>
        	<input type="hidden" id="creatorId${i.index }" value="${c.creatorId }"/>
     	 	
     	 	<div id="div${i.index}"	style="left: 580px; top: 120px; width: 480px; height: 300px; position: absolute; display: none; background-color: #F0F0F0;">
			<center>
			<div onclick="javascript:$('#div${i.index}').fadeToggle(500); "
				style="left: 450px; top: 0px; width: 30px; height: 20px; position: absolute; background-color: blue; cursor: pointer;"><font
				size="3" color="white">x</font>
			</div>
			<div id="messagediv${i.index}" style="width: 480px"></div>
			</center>
			</div>
        	</c:forEach>
        </table>
         <page:PageRoll/>
         </div>
         </div>
        </form>
    </div>    
    
</body>
</html>