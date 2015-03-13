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
<script type="text/javascript" src="${root}/view/js/sys/user/ctn/userList.js"></script>
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
<%-- <link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" /> --%>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>

<title>管理员管理</title>
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
.edits{
display: none;
}
</style>
</head>
<body>
<a href="###" style="display: none;" id="sendEmailDiv">发送email</a>
<div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/user/key/getUsersInfo" target="frame_main">管理员管理</a> </span> </div>
  <div id="ContentDiv">
   <%--  <div class="User_TopSearch">
      <form action="${root }/user/key/getUsersInfo" id="searchForm" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td width="80" align="right">管理员名称：</td>
            <td width="120"><input type="text" class="input_blue" size="20" name="userData.userName"/></td>
            <td width="100" align="right">手机号码：</td>
            <td width="120"><input type="text" class="input_blue" size="20" name="userData.loginMoble"/></td>
            <td width="80" align="right">邮箱：</td>
            <td width="120"><input type="text" class="input_blue" size="20" name="userData.loginMail"/></td>
            <td width="80" align="right">角色：</td>
            <td width="120">
            <select name="userData.roleid" class="input_blue">
            	<option value="">--请选择--</option>
            	<c:forEach var="roles" items="${roleList}">
  		          	<option value="${roles.id }">${roles.rolename }</option>
            	</c:forEach>
            </select>
            </td>
            <td><div style="margin:0 0 0 20px">
            	<input type="submit"  name="button" id="button" value="" class="Btn_TopSearch"/>
              </div>
            </td>
          </tr>
        </table>
      </form> --%>
    </div>
    
    <!-- 标题开始 -->
    
    <div class="TabContent">
   <%--    <div class="Btn_div">
        <div><a href="${root }/user/key/intoAddUserPage" class="btn_tianjia">添加管理员</a>
        <!--<a href="#" class="btn_tianjia" id="deleteUser">删除管理员</a>-->
        </div>
      </div> --%>
      <div class="hm_content">
         <form id="userForm" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1">
        	<tr>
        		<td>序号</td>
        		<td>账号</td>
        		<td>姓名</td>
        		<td>状态</td>
        		<td>操作</td>
        		
        	</tr>
        	  <c:forEach var="user" items="${userlist}" varStatus="status">
        	  <tr style="background: #fff;" align="center" class="tr_userlist">
				<td><span class="Number">${status.index+1+pageRoll.currentPage*pageRoll.pageSize }</span></td>
				<td id="mail_${status.index+1}"><span class="Number" id="spmail_${status.index+1}">${user.loginMail }</span></td>
				<td id="name_${status.index+1}"><span id="spname_${status.index+1}">${user.userName }</span></td>
				<td><span>
				<c:if test="${user.userState==1 }">启动</c:if>
				<c:if test="${user.userState==2 }">注销</c:if>
				</span></td>
				<td>
				<c:if test="${user.userState==1 }">
				<%-- <a  href="###" class="edit"  id="update_${status.index+1}" data="${status.index+1}">修改</a>
				<a  href="###"  onclick="saveEditUser('${status.index+1}')"  id="save_${status.index+1}" data="11111" class="edits">保存</a>&nbsp;&nbsp; --%>
		
			 
		
			<c:if test="${user.loginMail eq (frmUser.etipUserEmail) }">
					&nbsp;&nbsp;
					</c:if>
			<c:if test="${user.loginMail != (frmUser.etipUserEmail) }">
				<a href="${root }/user/key/updateUserState?userData.id=${user.id }">注销</a>&nbsp;&nbsp;
				<a  href="###" class="edit"  id="update_${status.index+1}" data="${status.index+1}">修改</a>
				<a  href="###"  onclick="saveEditUser('${status.index+1}')"  id="save_${status.index+1}" data="11111" class="edits">保存</a>&nbsp;&nbsp;
					</c:if>
					<input type="hidden" value="${user.id }" class="newId" />
				
				
				<div style="width: 200px;height:120px;display: none; filter: alpha(opacity=70); opacity: 0.7; background-color: #dddddd;position: absolute;" id="pwdDiv" onclick="">
			<a href="#"  onclick="closedDiv()" style="float: right;">关闭</a>
			<div style="margin-top: 40px;margin-left: 60px;"><input type="submit" name="updatesubmit" value="提交修改" class="submit" onclick="divhide('${user.id }')"/>s
			</div>
				</div>
				</c:if>
				<c:if test="${user.loginMail != (frmUser.etipUserEmail) }">
				<c:if test="${user.userState==2 }">
				<a href="${root }/user/key/updateUserStateStart?userData.id=${user.id }">重新启用</a>&nbsp;&nbsp;
				</c:if>
				</c:if>
				<a href="###"  onclick="updatePwd('${user.id }')">重置密码</a>
				</td>
				</tr>
			</c:forEach>
         <tr>
              <td colspan="8"><div class="statistical">管理员数量：<span>${pageRoll.totalRows }</span></div></td>
            </tr>
          </table>
      <page:PageRoll/>  
     <a  class="btn_tianjia" href="${root}/user/key/intoAddUserPages" style="margin-left: 20px;">增加</a>
        </form>
       
      			 </div>
     		  </div>
       </div>
      
</body>
</html>