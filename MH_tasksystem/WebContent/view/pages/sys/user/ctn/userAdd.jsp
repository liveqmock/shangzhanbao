<%@ page language="java" pageEncoding="utf-8"%>
 <%@include file="/baseHead.jsp"%>
<%-- <%@include file="/user_info.jsp"%>  --%>
<html>
<head>
 <link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/user/ctn/userAdd.js"></script> 
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<title>添加管理员</title>
</head>

<body>
 <div class="wrapbg_gp">
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
    <span><a href="${root }/user/key/getUsersInfo"  target="frame_main">管理员管理</a></span>
    <b>>></b> <span><a href="${root}/user/key/intoAddUserPages" target="frame_main">新增管理员</a></span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form id="userForm" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
        
          <tr>
            <td>登录邮箱：</td>
            <td>
	            <input type="text" name="userData.loginMail" id="mail" size="40" class="input_bor" 
				data-placement="right" notnull="登录邮箱不能为空!" email="邮箱格式不正确!"/><font color="#FF0000">*</font>
            </td>
          </tr>
          <tr>
            <td>密码：</td>
            <td>
	            <input type="password"  id="olpassword" size="40" class="input_bor"
				data-placement="right" notnull="密码不能为空!" max="16" min="6" /><font color="#FF0000">*</font>
            </td>
       </tr>
           <tr>
            <td style="width: 100px;">再次输入密码：</td>
            <td>
	            <input type="password" name="userData.passWord" id="password" size="40" class="input_bor" refer="olpassword"
				data-placement="right" notnull="密码不能为空!" max="16" min="6" /><font color="#FF0000">*</font>
            </td>
       </tr>
          <tr>
            <td width="80">姓名： </td>
            <td>
	            <input type="text" name="userData.userName" id="name"  size="40" class="input_bor" 
				 data-placement="right" max="16" min="2" notnum="不能是纯数字!" notnull="管理员名称不能为空!"/><font color="#FF0000">*</font>
            </td>
          </tr>
          <tr>
            <td colspan="2"><div class="line" style="margin:20px 0;"></div></td>
          </tr>
          <tr>
          <td> <div class="btnlan"  ><a href="###" class="saveAddUser" >完 成</a></div></td>
          <td> <div class="btnhui"  style="margin-left: 20px;"><a href="###" class="cancel" >取消</a></div></td>
          </tr>
        </table>
      </form>
      <div class="clear"></div>
    </div>
  </div>
</div>

</body>
</html>
