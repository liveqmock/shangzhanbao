<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/clientmanage/showAllClient.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
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

<title>客户管理</title>
</head>
<body><body style="height:100%;border-top:1px solid #D5D5D5;">
<a href="###" style="display: none;" id="sendEmailDiv">发送email</a>
<form action="" class="clientForm" method="post">
<div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/client_manage/key/searchAllClient" target="frame_main">客户管理</a> </span> 
</div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
	<table class="table" width="100%" border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td style="width: 70px">登录账号:</td>
				<td><input style="width: 120px" type="text" name="userData.loginMail" value="${param['userData.loginMail'] }"></td>
				<td style="width: 70px">注册时间:</td>
				<td><input id="time" style="width: 120px" name="userData.createTime" type="text" value="${param['userData.createTime'] }">
				至<input name="userData.modifyTime" style="width: 120px" id="time2" type="text" value="${param['userData.modifyTime'] }"></td>
				<!-- <td style="width: 70px">发布权限:</td>
				<td><input type="radio" name="userData.buyPubNum" value="1"/> 有购买发布权限
				&nbsp;
				<input type="radio" name="userData.buyPubNum" value="0"/>没有购买发布权限 -->
				<td style="width: 70px">发布权限:</td>
				<td><input type="radio" name="userData.buyPubNum" value="1"/> 有购买发布权限
				&nbsp;
				<input type="radio" name="userData.buyPubNum" value="0"/>没有购买发布权限
				
				</td>
				<td><input type="submit"  value="" class="Btn_TopSearch" /></td>
			</tr>
		</table>
		</div>
	</div>
</div>
		
	  	  <div class="" align="right" style="margin-right: 10px;margin-top: 5px;">
	  	   <span>排序：</span>&nbsp;&nbsp;&nbsp;&nbsp;
       <span><a href="${root}/client_manage/key/searchAllClient?type=createTime&sortTime=${sortTime eq 1?1:0 }">按注册时间</a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span><a href="${root}/client_manage/key/searchAllClient?type=pcount&sortpc=${sortpc eq 1?1:0 }">按Page数</a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span><a href="${root}/client_manage/key/searchAllClient?type=scount&sortsc=${sortsc eq 1?1:0 }">按发布Page数</a> </span>
      	</div>


        <div id="ContentDiv">
     <div class="nTab"> 
        <div class="TabTitle">
     		   <ul id="myTab00">
       
          	 <li class="active" value="0"  >全部</li> 

		      </ul>
      </div>
 </div>
      <div class="TabContent">
   			 <div class="hm_content">
     
    		 <table  width="100%" border="0" cellspacing="1" cellpadding="1">
        	<tr>
        		<td>编号</td>
        		<td>登录账号</td>
        		<td>注册时间</td>
        		<!-- <td>是否实名</td> -->
        		<td>Page数</td>
        		<td>发布Page数</td>
        		<td>购买发布权限</td>
        		<td>操作</td>
        	</tr>
        	<c:forEach var="userData" items="${userDatas }" varStatus="i">
				<tr>
					<td>
					<input type="hidden" class="userId" value="${userData.id }"/>
					<c:if test="${userData.addType == 2 }">
					<input type="checkbox" name="clientId" value="${userData.id }"/>
					</c:if>
					${i.index+1 }
					</td>
					<td>${userData.loginMail }</td>
					<td>${userData.createTime }</td>
					<%-- <td>${userData.userState }</td> --%>
					<td>${userData.pageNum }</td>
					<td>${userData.pubPageNum }</td>
					<td>
					<c:if test="${userData.buyPubNum == null || userData.buyPubNum == ''}">
						0
					</c:if>
					<c:if test="${userData.buyPubNum != null || userData.buyPubNum != ''}">
						${userData.buyPubNum}
					</c:if>
					</td>
					<td><div class="editdiv"><a href="###" class="editClient">修改</a></div>
					<div class="adddiv"><a href="###" class="updateClient" data="${userData.id}">保存</a></div>
					<div class=""><a href="###" class="sendEmail" data="${userData.id}">重置密码</a></div>
					<a href="${root }/client_manage/key/searchClientById?userData.id=${userData.id}">查看详情</a></td>
				</tr>
			</c:forEach>
        </table>
        <page:PageRoll/>
        </div>
        </div>
        
        </form>
        <a class="btn_tianjia" href="${root }/view/pages/mini/back/clientmanage/addClient.jsp">新增</a>&nbsp <a class="delClient btn_tianjia" href="###">删除</a>
</body>
</html>