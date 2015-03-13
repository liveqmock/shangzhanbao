<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%-- <%@include file="/user_info.jsp"%> --%>
<html>
<head>
 <link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/user/ctn/userEdit.js"></script> 
</head>

<body>
 <div class="wrapbg_gp">
  <div class="current">当前位置：
 <span>修改管理员</span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form id="userForm" method="post">
        <input type="hidden" name="userData.id" id="userid" value="${userData.id}" />
		<input type="hidden" name="userData.createtime" value="${userData.createTime}"/>
		<input type="hidden" name="userData.userState" value="${userData.userState}"/>
		<input type="hidden" name="userData.passWord" value="${userData.passWord }"/>
		<input type="hidden" name="userData.userType" value="${userData.userType }"/>
		<input type="hidden" name="userData.addType" value="${userData.addType }"/>
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
          <tr>
            <td width="80">管理员名称： </td>
            <td>
	            <input type="text" name="userData.userName" id="name"  size="40" class="input_bor" 
				 data-placement="right" max="16" min="6" notnum="不能是纯数字!" notnull="管理员名称不能为空!"
				 value="${userData.userName}"/><font color="#FF0000">*</font>
            </td>
          </tr>
          <tr>
            <td>登录账号：</td>
            <td>
	            <input type="text" name="userData.loginMail" id="mail" size="40" class="input_bor" 
				data-placement="right" notnull="登录邮箱不能为空!" email="邮箱格式不正确!"
				value="${userData.loginMail}"/><font color="#FF0000">*</font>
            </td>
          </tr>
          <!--
          <tr>
            <td><font color="#FF0000">*</font>登录密码：</td>
            <td>
	            <input type="text" name="userData.passWord" id="password" size="41" class="input_bor"
				data-placement="right" notnull="密码不能为空!" max="16" min="6" 
				value=""/>
            </td>
          </tr>
           -->
           <tr>
            <td>手机号码：</td>
            <td>
	            <input type="text" name="userData.loginMoble" id="mobile" size="40" class="input_bor" 
				num="只能是数字!" max="11" min="11" data-placement="right" notnull="手机号码不能为空!"
				value="${userData.loginMoble}"/><font color="#FF0000">*</font>
            </td>
          </tr>
          <tr>
            <td valign="top">角色：</td>
            <td>
            <!--<div class="User_Div">
                <ul>
	                <c:forEach var="role" items="${roleList}"  >
			 		<input name="userRoleS"  value="${role.id}" type="checkbox"
			 			<c:forEach var="userRole" items="${userRoleList}">
			 				<c:if test="${role.id == userRole}">checked</c:if>
			 			</c:forEach>
			 		/>
			 		${role.rolename}
				    </c:forEach>
                </ul>
              </div>
              -->
              
              <div class="User_Div">
                <c:forEach var="role" items="${roleList}"  >
               		 <ul class="userUl" style="width: 120px;height: 30px;">
				 		<li 
				 		<c:forEach var="userRole" items="${userRoleList}">
				 			<c:if test="${role.id == userRole}">class='crub'</c:if>
				 		</c:forEach>
				 		>
	                     <a href="###" >${role.rolename}</a>
	                    </li>
	                    <input type="hidden" class="roleArray" value="${role.id}"/>
               		 </ul>
			  	</c:forEach>
              </div>
              
              
            </td>
          </tr>
          <tr>
                <td colspan="2">&nbsp;</td>
            </tr>
          <tr>
            <td valign="top">标签：</td>
            <td>
                <div class="User_Div" >
                     <textarea rows="5" cols="50" name="userData.remark" id="remark" max="300">${userData.remark }</textarea>
                </div>
            </td>
          </tr>
        </table>
        </form>
        <form action="" id="pwdForm">
        <div id="pwdDiv" style="display:none;margin-top: 20px;">
         <table width="100%" border="0" >
          <tr>
            <td colspan="2"><div class="line" style="margin:20px 0;"></div></td>
          </tr>
         <tr>
            <td width="80"><font color="#FF0000">*</font>新密码： </td>
            <td>
	            <input type="text" name="newPwd" id="newPwd" size="40" class="input_bor" 
				data-placement="right" notnull="新密码不能为空!"  max="16" min="6"
				value=""/>
            </td>
          </tr>
           <tr>
            <td colspan="2"><div class="line" style="margin:20px 0;"></div></td>
          </tr>
         </table>
        </div>
        </form>
        <div class="Btn_tab">
          <div class="btn_red" style="margin:0 10px; float:left"><a href="###" class="saveEditUser" style="color: blue;">保存</a></div>
          <div class="btn_hui" style="margin:0 10px; float:left"><a href="###" class="cancel" style="color: blue;">取消</a></div>
        	<div class="btn_red" style="margin:0 10px; float:left;"><a href="###" id="resetPwd" style="color: blue;">重置密码</a></div>
        	<div class="btn_hui" style="margin:0 10px; float:left"><a href="###" id="unresetPwd" style="color: blue;">取消重置密码</a></div>
        </div>
      
      <div class="clear"></div>
    </div>
  </div>
</div> 
</body>
</html>
