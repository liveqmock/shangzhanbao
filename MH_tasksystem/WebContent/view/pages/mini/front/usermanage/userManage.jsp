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
<script type="text/javascript" src="${root}/view/js/minipage/front/userManage/userManage.js"></script>
<title>账号管理</title>
</head>
<body>
	<h4>账号管理</h4>
	<hr>
	 <form action="" id="editPass" method="post" onsubmit="return checkSub($(this))">
	 	 <table border="0" cellspacing="1" cellpadding="1">
	 	 	 <tr> 
	 	 	    <td style="text-align:right; width:110px"><strong>修改密码</strong></td>
                <td></td>
             </tr>
             
             <tr>
			   <td style="text-align:right; width:110px">用户名：</td>
			    <td>${userData.loginMail }</td>
		    </tr>
	 		 <tr>
	 			<td style="text-align:right; width:110px">旧密码：</td>
	 			<td><input type="text" notnull="请输入旧密码" id="oldPword"  class="input_23bor oldPass" size="30"/></td>
	 		</tr>
	 		<tr>
	 			<td style="text-align:right; width:110px">新密码：</td>
	 			<td><input id="onePass" type="password" notnull="请输入新密码" min="6" max="16"  name="userData.passWord" class="input_23bor newPass" size="30"/></td>
	 		</tr>
	 		<tr>
	 			<td style="text-align:right; width:110px">再次输入新密码：</td>
	 			<td><input type="password" notnull="请重新输入新密码" refer="onePass" class="input_23bor" size="30"/>
	 			</td>
	 		</tr> 		
	 		<tr>
	 			<td style="text-align:right; width:110px">验证码：</td>
	 			<td>
	 				<input type="text" name="variCode" class="input_23bor"/>
	 				<img title="看不清，换一张" alt="验证码" src="${root }/verification_code" class="vari-code-img">
	 			</td>
	 		</tr> <tr>
                <td colspan="2" style="height:10px; overflow:hidden"></td>
              </tr>
                 	<tr>
              	<td></td>
                <td><a href="###" class="btn_122Red" id="eidt">确 定</a></td>
              </tr>
	 	</table>
	</form>
</body>
</html>