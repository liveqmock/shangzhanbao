<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
	<title>商站宝</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	
	<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/view/css/mini/index/login.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/view/ext22/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/view/ext22/ext-all.js"></script>


</head>

<body onload="ini()">
<div id="LoginDiv">
<div class="nTab">
  <div class="TabTitle">
    <ul id="myTab00">
      <li class="active" onclick="nTabs(this,0);">用户登录</li>
    </ul>
  </div>
  <div class="TabContent">
    <div id="myTab00_Content0">
      <form action="${pageContext.request.contextPath }/j_spring_security_check" id="loginForm" method="post">
        <table border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td width="100" align="right">用户名：</td>
            <td><input id="uname" name="j_username" type="text" class="input" style="width:150px"/></td>
          </tr>
          <tr>
            <td align="right">密码：</td>
            <td><input id="pass" name="j_password" type="password" class="input" style="width:150px"/></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input name="" type="button" class="Login_btn01" value="登录" onclick="checkUser()"/>
               <input name="" type="reset" class="Login_btn01" value="注册" onclick="reg()"/>
             </td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  </div>
</div>
</body>
</html>


<script language="javascript">
	function ini(){
		if(window.parent.location.href!=location.href){
			window.parent.location.href=location.href;
		}
		if(document.getElementById('uname').value==""){
			document.getElementById('uname').focus();
		}else{
			document.getElementById('pass').focus();
		}
	}

	document.onkeydown = function(evt){
		var evt = window.event?window.event:evt;
		if(evt.keyCode==13){
			
			var msg = "";
			var name = document.getElementById('uname').value;
			var pwd = document.getElementById('pass').value;
			if(name==""){
				document.getElementById('uname').focus();
				//return true;
			}
			if(pwd==""){
				document.getElementById('newpass').focus();
				//return true;
			}
			if((name!="") && (pwd=="")){
				document.getElementById('pass').focus();
				//return true;
			}
			if((name=="") && (pwd!="")){
			//	msg = "请输入用户名！";
				document.getElementById('uname').focus();
				//return true;
			}
			
			if(document.getElementById('uname').value!="" && document.getElementById('pass').value!='' ){
				checkUser();
			}
		}
	}


//检查用户密码
function checkUser(){

		var name = document.getElementById('uname').value;
		var pwd = document.getElementById('pass').value;
		if(name==""){
			document.getElementById('uname').focus();
			alert("请输入用户名！");
			return true;
		}
		if(pwd==""){
			document.getElementById('pass').focus();
			alert("请输入密码！");
			return true;
		}
		if((name=="") && (pwd!="")){
		//	msg = "请输入用户名！";
			alert("请输入用户名和密码！");
			return true;
		}

	var uname = Ext.fly('uname').dom.value;
	var pass = Ext.fly('pass').dom.value;

	var url = '${pageContext.request.contextPath}/user_login/key/userLogin';
	var requestConfig = {
		url : url,
		params : "account="+uname+"&password="+pass ,
		success : function(response, options) {
			var result = Ext.util.JSON.decode(response.responseText);
			if(result.resultCode == "1"){
				document.getElementById("loginForm").submit();
			}else if(result.resultCode == "5"){
				alert("系统异常,请联管理员!");
			}else{
				alert("您输入的用户名不可用或者密码不正确,请重新输入!");
				document.getElementById('uname').focus();
			}
			result = null;
		}
	};
	Ext.Ajax.request(requestConfig);
}
function reg(){
	window.location.href = root + "/register.jsp";
}
function goback(){
	window.location.href = root + "/product_manage_center_service/key/productCenterHome";
}

</script>