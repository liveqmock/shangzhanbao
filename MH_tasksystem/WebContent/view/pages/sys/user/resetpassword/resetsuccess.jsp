<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设置成功</title>
<script type="text/javascript">
	$(document).ready(function(){
		$('#u5').mouseover(function(){
			 $("#u5").css("background-color","#009ABE");
	       }).mouseout(function(){
				$("#u5").css("background-color","#0099CC");
	     });
		
		$("#u5").on("click",function(){
			window.location.href =  root + "/j_spring_security_check?j_username="+$("#hiddenloginMail").val()+"&j_password="+$("#hiddenpassWord").val();
		});
	});
</script>
</head>

<body style="background-color:#E2E2E2;width:100%;">
      <!-- Image (图片) -->
      <div style="margin-top:10%;margin-left:46%">
        <img id="u0_img" class="img" style="width: 75px;height: 75px;" src="${root }/view/pages/sys/user/resetpassword/image_u0.png"/>
      </div>
        
        <div style="margin-left:45%;margin-top: 40px;">
          <p><span style="color:#0099CC;font-size:28px;">设置成功</span></p>
        </div>
       <div style="margin-left:44.5%;padding-top:4px;">
          <p><span>你的新密码已经生效</span></p>
        </div>
        <div id="u5" class="text" style="width:331px;height:47px;text-align:center;background-color:#0099CC;margin-left:39%;margin-top:50px;">
          <p><span style="font-family:'Heiti SC Light', 'Heiti SC';font-weight:200;line-height:40px">
          	<a style="color:#FFF;text-decoration: none;" href="###">进入商站宝</a>
          	</span></p>
        </div>

  </body>
  <input type="hidden" id="hiddenloginMail" value="${userData.loginMail }">
   <input type="hidden" id="hiddenpassWord" value="${userData.passWord }">
</html>


