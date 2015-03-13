<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/message/messageList.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#timeStar').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#timeEnd').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />

<title>客户管理</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
<form action="${root }/message/key/getAll?messageData.status=2" class="well form-search"  id="disForm" method="post">
<div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
	<span><a href="${root }/message/key/getAll?messageData.status=2" target="frame_main">留言管理</a> </span> </div>
 	 <div id="ContentDiv">
  	  <div class="User_TopSearch">
		<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td style="width: 70px">留言标题:</td>
				<td><input style="width: 150px" type="text" name="messageData.title" value="${param['messageData.title'] }"></td>
				<td style="width: 70px">创建时间:</td>
				<td>
				<input id="timeStar" style="width: 150px" name="messageData.createTime" value="${param['messageData.createTime'] }" type="text" />
				至
				<input name="messageData.examinerTime" style="width: 150px" id="timeEnd" value="${param['messageData.examinerTime'] }" type="text" /></td>
				<td>
				<input type="submit" value="" class="Btn_TopSearch">
				</td>
			</tr>
		</table>
		</div>
	</div>
</div>

        <div id="ContentDiv">
    <div class="nTab"> 
        <div class="TabTitle">
        	<input type="hidden" name="messageData.status" value="${messageData.status }"/>
     	   	<ul id="myTab00">
	           <li class=${messageData.status==2?"active":"normal" } value="2">全部留言</li> 
	           <li class=${messageData.status==0?"active":"normal" }  value="0">已查看</li> 
	           <li class=${messageData.status==1?"active":"normal" } value="1">未查看</li> 
			</ul>
      	</div>
 	</div>
	<div class="TabContent">
		<div class="hm_content">
    		<table  width="100%" border="0" cellspacing="1" cellpadding="1">
	        	<tr>
	        		<td>留言编号</td>
	        		<td>留言标题</td>
	        		<td>留言用户</td>
	        		<td>留言时间</td>
	        		<td>留言状态</td>
	        		<td>操作</td>
	        	</tr>
	        	<c:forEach items="${list }" var="message" varStatus="status">
	        	<tr>
	        	<td>${status.index+1 }</td>
	        	<td>${message.title }</td>
	        	<td>${message.userName }</td>
	        	<td>${message.createTime }</td>
	        	<td>
	        	<c:if test="${message.status==1 }">未查看</c:if>
	        	<c:if test="${message.status==0}">已查看</c:if>
	        	</td>
	        	<td><a href="${root }/message/key/getMessageDate?messageData.id=${message.id}" class="green">查看详情</a>|
	        	<a href="###" class="red deleteMessage"  data="${message.id}">删除</a></td>
	        	</tr>
	        	</c:forEach>

        	</table>
      <page:PageRoll/> 
        </div>
        </div>
        </div>
        </form>
</body>
</html>