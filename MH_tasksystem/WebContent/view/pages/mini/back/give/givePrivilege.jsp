<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${root}/view/css/ctn.css" />
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/pages/mini/privilege/give.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#starttime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#endtime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
    <script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#startUseTime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#endUseTime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
    <script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery('#startpaytime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
         // 时间设置
            jQuery('#endpaytime').datetimepicker({
                timeFormat: "HH:mm:ss",
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
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
    <a href="${root }/give/key/givePrivilege" target="frame_main" >赠送权限</a>
   </span> </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
    <font size="3">1. 请选择赠送目标客户(1/3)</font>
     <form action="" id="giveUserinfo" method="post">
         <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td width="80" align="left">邮箱、手机：</td>
            <td width="80"><input name="giveUserInfoData.loginmail" value="${giveUserInfoData.loginmail }" type="text"  style="width: 120px" class="input_blue" size="23" /></td>
            <td width="80" align="left">注册时间：</td>
            <td ><input id="starttime" name= "giveTimeData.starttime" value="${starttime }" style="width: 120px" type="text">至<input style="width: 120px" id="endtime" value="${endtime }" name="giveTimeData.endtime" type="text"></td>
            <td  align="left">购买发布权限：</td>
            <td >有<input type="radio"  name="giveUserInfoData.isprivilege" value="1"/>没有<input type="radio"  name="giveUserInfoData.isprivilege" value="0"/></td>
            </tr>
          	 <tr>
            <td width="80" align="left">Page域名：</td>
            <td ><input name="giveUserInfoData.domain" value="${giveUserInfoData.domain }" style="width: 120px" type="text" class="input_blue" size="23" /></td>
            <td width="80" align="left">公司名称：</td>
            <td ><input name="giveUserInfoData.username" value="${giveUserInfoData.username }"  style="width: 120px" type="text" class="input_blue" size="23" /></td>
            <td  align="left">联系人姓名：</td>
            <td ><input name="giveUserInfoData.personame" value="${giveUserInfoData.personame }" type="text" style="width: 120px" class="input_blue" size="23" /></td>
            </tr>
              <tr>
            <td width="230" align="left">使用了什么模板（模板名称、模板编号：)</td>
            <td width="120"><input name="giveUserInfoData.sn" value="${giveUserInfoData.sn }" style="width: 120px" type="text" class="input_blue" size="23" /></td>
            <td width="100" align="left">使用该模板时间：</td>
            <td ><input id="startUseTime" name="giveTimeData.startUseTime" value="${startUseTime }" style="width: 120px" type="text">至<input style="width: 120px" value="${endUseTime }" name="giveTimeData.endUseTime" id="endUseTime" type="text"></td>
            </tr>
            <tr>
            <td width="230" height="15" align="left">购买了什么服务</td>
            <td width="230" height="15"><s:select headerValue="--请选择服务--" headerKey="" list="list_product"
					 listKey="id" listValue="name" name="giveUserInfoData.services" theme="simple"/>
            
            
            </td>
            <td width="100" align="left">购买时间：</td>
            <td ><input id="startpaytime" name="giveTimeData.startpaytime" value="${startpaytime }" style="width: 120px" type="text">至<input style="width: 120px" value="${endpaytime}" name="giveTimeData.endpaytime" id="endpaytime" type="text"></td>
            <td ><a class="btn_tianjia" style="float: right" id="buttonSearch" onclick="findByConditions()" href="#">查询结果</a></td>
            </tr>
        </table>
              </form>
    </div>
        <form action="" method="post">
        <font size="3">2. 确认目标客户(2/3)</font>      <div style="float: right">
        排序：<a style="background-color: #F0F0F0;" href="###">按page数</a>
        &nbsp;&nbsp;<a style="background-color: #F0F0F0;" href="${root}/give/key/givePrivilege?giveUserInfoData.queryType=pageNum">发布page数</a>
        &nbsp;&nbsp;<a style="background-color: #F0F0F0;" href="${root}/give/key/givePrivilege?giveUserInfoData.queryType=pageNum">认证page数</a>
        &nbsp;&nbsp;<a style="background-color: #F0F0F0;" href="${root}/give/key/givePrivilege?giveUserInfoData.queryType=payprivilege">购买发布权限数</a></div>
      <br><br>
      <div>
          <div class="hm_content">
     			 <table width="100%" border="0" id="giveTable" cellspacing="1" cellpaddiung="1">
      			<tr>
        		<td><input type="checkbox" style="width: 20"  id="deuser" /></td>
        		<td id="">编号</td>
        		<td>登入账号</td>
        		<td>page数</td>
        		<td>发布page数</td>
        		<td>认证page数</td>
        		<td>注册时间</td>
        		<%--<td>购买发布权限数</td>
        		 <c:if test="${giveUserInfoData.domain!=null}">
        		<td >Page域名</td>
        		</c:if>
        		<c:if test="${giveUserInfoData.username!=null}">
        		<td >公司名称</td>
        		</c:if>
        		<c:if test="${giveUserInfoData.personame!=null}">
        		<td >联系人姓名</td>
        		</c:if>
        		<c:if test="${giveUserInfoData.sn!=null}">
        		<td >模板编号</td>
        		</c:if>
        		<c:if test="${giveUserInfoData.name!=null}">
        		<td >模板名称</td>
        		</c:if>
        		<c:if test="${giveTimeData.startUseTime!=null || giveTimeData.endUseTime!=null}">
        		<td >使用该模板时间</td>
        		</c:if>
        		<c:if test="${giveUserInfoData.services!=null}">
        		<td >购买了什么服务</td>
        		</c:if>
        		<c:if test="${giveTimeData.endpaytime!=null || giveTimeData.startpaytime!=null}">
        		<td >购买时间</td>
        		</c:if> --%>
        	</tr>
        	<c:forEach var="giveUserInfo" items="${giveUserInfolist}" varStatus="i">
        	<tr>
			<!--        	<input type="hidden" id="userid" />-->
        	<td><input type="checkbox" style="width: 20" name="allcbx" value="${giveUserInfo.id }" onclick="countUser();" /></td>
        	<td>${i.index+1 }</td>
        	<td>${giveUserInfo.loginmail }${giveUserInfo.loginmoble }</td><!-- 登入账号 -->
        	<td>${giveUserInfo.pageNum }</td><!-- page数 -->
        	<td>${giveUserInfo.releaseNum }</td><!-- 发布page数 -->
        	<td></td><!-- 认证page数 -->
        	<td>${giveUserInfo.createtime}</td><!-- 注册时间 -->
        	<%-- <td >${giveUserInfo.payprivilege }</td><!-- 购买发布权限数 -->
        	<c:if test="${giveUserInfoData.domain!=null}"><td >${giveUserInfo.domain }</td></c:if><!-- Page域名 -->
        	<c:if test="${giveUserInfoData.username!=null}"><td >${giveUserInfo.username }</td></c:if><!-- 公司名称 -->
        	<c:if test="${giveUserInfoData.personame!=null}"><td ></td></c:if><!-- 联系人姓名 -->
        	<c:if test="${giveUserInfoData.sn!=null}"><td >${giveUserInfo.sn }</td></c:if><!-- 模板编号 -->
        	<c:if test="${giveUserInfoData.sn!=null}"><td >${giveUserInfo.name }</td></c:if><!-- 模板名称 -->
        	<c:if test="${giveUserInfoData.name!=null}"><td >${giveUserInfo.name }</td></c:if><!-- 使用该模板时间 -->
        	<c:if test="${giveTimeData.startUseTime!=null || giveTimeData.endUseTime!=null}"><td >${giveUserInfo.useTime }</td></c:if><!-- 购买了什么服务 -->
        	<c:if test="${giveTimeData.startUseTime!=null || giveTimeData.endUseTime!=null}"><td ></td></c:if><!--  -->
        	<c:if test="${giveTimeData.endpaytime!=null || giveTimeData.startpaytime!=null}"><td >${giveUserInfo.payTime }</td></c:if><!-- 购买时间 -->
        	 --%>
        	
        	</tr>
        	</c:forEach>
        </table>
        <div style="float: right;"><page:PageRoll/></div>
        <br><br><br><br>
         <font style="font-size: 18px;float: left;">已选择<span id="countUserNum">0</span>个客户 </font>
        </div>
    	 <div style="width:1300px;height:1px;margin:1px auto;padding:0px;background-color:black;overflow:hidden;"></div>
       <div style="height: 5px"></div>
       <div style="height: 5px"></div>
        <font size="3">3. 请选择赠送数量（3/3)</font>
          <table>
          <tr height="50">
          <td><font size="3">每个客户各
          <input id="giveNumval" style="width: 30px" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">个</font></td>
          </tr>
          <tr></tr>
          <tr>
          <td>
          <textarea rows="9"  id="message" cols="39" placeholder="输入赠送消息、赠送理由（赠送消息将消息发送至客户，最多250个字）" ></textarea>
          </tr>
          </table>
           <a class="btn_tianjia" href="###" onclick="savePrivilege('2');">暂存</a>
        &nbsp;<a class="btn_tianjia" href="###" onclick="savePrivilege('1');">确认赠送</a>
        
        </div>
        </form>
       
</body>
</html>