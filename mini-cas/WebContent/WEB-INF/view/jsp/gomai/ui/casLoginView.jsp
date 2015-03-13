<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<title>登录 - 商站宝</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/mini/minicss.css" />" media="all"/>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery1.4.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery1.8.5-ui.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/cas.js" />"></script>
<style type="text/css">
.ahover a:hover{width:100%;text-decoration:none;padding:0 0 0 0;color: rgb(0, 153, 255);}
.ahover a{width:100%;text-decoration:none;padding:0 0 0 0;color: #797979}

</style>
</head>
<%
	// 获取cas系统所登陆成功的账号
	String myUserName = request.getParameter("j_username");
	String myPassword = request.getParameter("j_password");
%>
<body>

<div style="margin:0 auto; padding-top:150px; width:400px;">
    <div style="height:75px; width:auto;">
      <div style="margin-left:108px;float:left;">
      	<img id="logo" height="70px" width="160px" src="<c:url value="/css/mini/images/logo.jpg" />" />
      </div>
      <div>
        
      </div>
    </div>
    
    
     <form:form method="post" id="loginForm" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true" onload="ini()">
    	<div class="login_box_msg">
    		<form:errors path="*" id="msg"  cssClass="errors"  element="div" />
    		<div id="errors" style = "margin-bottom: 10px;display: none;color: red; margin-left: 35px;border: 1px solid #ff8080;float: left;line-height: 20px;height: 20px;padding: 2px 10px 2px 23px;background: url(/mini-cas/css/mini/images/error.png) no-repeat 3px center #fff2f2;font-size: 14px;"></div>
    	</div>
	  	
	  <p style="padding-top:20px;">
	  	<form:input cssClass="required" value="<%=myUserName %>" style="height:45px; width:331px; border:solid 1px #0099CC; background-color:#FFFFFF;" placeholder="登录邮箱或者手机号码" cssErrorClass="error" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true" />
	  </p>
	  <p style="padding-top:15px;">
	  	<form:input type="password" value="<%=myPassword %>" cssClass="required" style="height:45px; width:331px; border:solid 1px #0099CC; background-color:#FFFFFF;" placeholder="密码"  cssErrorClass="error" id="password" size="25" tabindex="1" accesskey="${passwordAccessKey}" path="password" autocomplete="false" htmlEscape="true" />
	  </p>
	  <p style="padding-top:15px;">
	  	<input type="hidden" name="lt" value="${loginTicket}" />
		<input type="hidden" name="execution" value="${flowExecutionKey}" />
		<input type="hidden" name="_eventId" value="submit" />
	    <input id="loginButton" type="button" value="登录" onclick="checkUser()" style="border:none;height:47px; width:331px; background-color:#0099CC;font-size: 16px;color: #FFFFFF;cursor: pointer;" />
	  </p>
	  <p> 
		  <span style="float:left;margin-top:11px; margin-left:30px;font-weight: 200;color: #797979; font-size:13px;">
		  	<input id="chkRememberPass" type="checkbox" />记住密码
		  </span> 
		  <span class="ahover"  style="float:right; margin-top:15px; margin-right:30px;font-weight: 200; font-size:13px;">
		  <a href="http://192.168.4.32:8080/view/pages/mini/commonality/Find_Password.jsp"  >忘记密码</a></span>
	  </p>
	  <p>
  		<hr style="margin-top:70px;width:400px; height:1px; border:none;border-top:1px solid #0099CC;"/>
  	 </p>
  <p ><span style="font-weight: 200;font-size: 16px;color: #434343;">还没有账号？</span><span class="ahover" style="font-weight: 200;font-size: 16px;color: rgb(0, 153, 255);" onclick="reg();">
  <a href="###"  onclick="reg()" class="btn_200gray" style="color: rgb(0, 153, 255);"> 免费注册—></a>
 </span></p>
   </form:form>           
</div>


</body>
<script type="text/javascript">
$(function(){
	if($("#msg").html() != "" && $("#msg").html() != null){
		document.getElementById('username').focus();
		$("#errors").html($("#msg").html());
		$("#errors").show();
		clearDisableButtion("loginButton");
		return;
	}
	var name = document.getElementById('username').value;
	var pwd = document.getElementById('password').value;
 	if(name != ""  && pwd != ""){
 	 	$("#loginButton").click();
 	}
})
document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==27){ // 按 Esc 
        //要做的事情
      }
    if(e && e.keyCode==113){ // 按 F2 
         //要做的事情
       }            
     if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	$("#loginButton").click();
    }
}

/**
 * 禁用登陆按钮
 */
function disabledButton(id){
	$("#"+id).attr('disabled',"true");
	$("#"+id).css('background-color','#BBB8B8');
	$("#"+id).attr('value','登录中');
}
/**
 * 启用登陆按钮
 */
function clearDisableButtion(id){
	$("#"+id).removeAttr("disabled"); 
	$("#"+id).css('background-color','#0099CC');
	$("#"+id).attr('value','登录');
}

//检查用户密码
function checkUser(){
	num = 1;
	console.log(window.location.href);
	num = num + 1;
	console.log(num);
	disabledButton("loginButton");
	var name = document.getElementById('username').value;
	var pwd = document.getElementById('password').value;
	if(name==""){
		document.getElementById('username').focus();
		$("#errors").html("请输入用户名！");
		$("#errors").show();
		clearDisableButtion("loginButton");
		return true;
	}
	if(pwd==""){
		document.getElementById('password').focus();
		$("#errors").html("请输入密码！");
		$("#errors").show();
		clearDisableButtion("loginButton");
		return true;
	}
	if((name=="") && (pwd!="")){
		$("#errors").html("请输入用户名！");
		$("#errors").show();
		clearDisableButtion("loginButton");
		return true;
	}
    if(document.getElementById("chkRememberPass").checked){  
        //添加cookie  
        addCookie("userName",name,7,"/");  
        addCookie("userPass",pwd,7,"/");  
    }else{
    	addCookie("userName","",0,"/");
    	addCookie("userPass","",0,"/");
    }
    $("#loginForm").submit();
}
function addCookie(name,value,days,path){   /**添加设置cookie**/  
    var name = escape(name);  
    var value = escape(value);  
    var expires = new Date();  
    expires.setTime(expires.getTime() + days * 3600000 * 24);  
    //path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用  
    path = path == "" ? "" : ";path=" + path;  
    //GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC  
    //参数days只能是数字型  
    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();  
    document.cookie = name + "=" + value + _expires + path;  
}  
function getCookieValue(name){  /**获取cookie的值，根据cookie的键获取值**/  
    //用处理字符串的方式查找到key对应value  
    var name = escape(name);  
    //读cookie属性，这将返回文档的所有cookie  
    var allcookies = document.cookie;         
    //查找名为name的cookie的开始位置  
    name += "=";  
    var pos = allcookies.indexOf(name);      
    //如果找到了具有该名字的cookie，那么提取并使用它的值  
    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败  
        var start = pos + name.length;                  //cookie值开始的位置  
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie  
        var value = allcookies.substring(start,end); //提取cookie的值  
        return (value);                           //对它解码        
    }else{  //搜索失败，返回空字符串  
        return "";  
    }  
}  
function deleteCookie(name){   /**根据cookie的键，删除cookie，其实就是设置其失效**/  
	 var exp = new Date(); 
	    exp.setTime(exp.getTime() - 1); 
	    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString(); 
	    var cval=getCookieValue("userName");
	    if(cval == name && cval!=null && cval!=""){
	    	document.cookie= name + "=" + "" + _expires + path; 
	    }
	        
}  
function reg(){
	window.location.href = "http://192.168.4.32:8080/register.jsp";
}
</script>
</html>