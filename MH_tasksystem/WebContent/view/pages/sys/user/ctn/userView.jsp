<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%-- <%@include file="/user_info.jsp"%> --%>
<html>
<head>
 <link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/user/ctn/userAdd.js"></script> 
</head>

<body>
 <div class="wrapbg_gp">
  <div class="current">当前位置：<a >主页</a><b>>></b> 
  <span><a >管理员管理</a></span> <b>>></b> <span>管理员详情</span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form id="userForm" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
          <tr>
            <td width="80">管理员名称： </td>
            <td>
	            <input type="text"  size="40" class="input_bor" 
				 value="${userData.userName}" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td>登录账号：</td>
            <td>
	            <input type="text" size="40" class="input_bor" 
				value="${userData.loginMail}" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td>登录密码：</td>
            <td>
	            <input type="text"  size="41" class="input_bor"
				value="****" readonly="readonly"/>
            </td>
          </tr>
           <tr>
            <td>手机号码：</td>
            <td>
	            <input type="text"  size="40" class="input_bor" 
				value="${userData.loginMoble}" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td valign="top">角色：</td>
            <td><div class="User_Div">
                <ul>
                 <c:forEach var="role" items="${roleList}" >
		  			<c:if test="${role.rolename != '系统管理员'}">
		  			 <li>${role.rolename}&nbsp;&nbsp;</li>
		  			</c:if>
				 </c:forEach>
                </ul>
              </div>
            </td>
          </tr>
          <tr>
            <td valign="top">标签：</td>
            <td><div class="User_Div">
               <textarea rows="5" cols="60" max="300" readonly="readonly">${userData.remark }</textarea>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2"><div class="line" style="margin:20px 0;"></div></td>
          </tr>
        </table>
        <div class="Btn_tab">
          <div class="btn_hui" style="margin:0 10px; float:left"><a href="###" class="cancel">关闭</a></div>
        </div>
      </form>
      <div class="clear"></div>
    </div>
  </div> 
</div>
</body>
</html>
