<%@page import="com.itour.etip.pub.frame.ETIPResultSet"%>
<%@page import="java.util.List"%>
<%@page import="com.itour.etip.pub.frame.SpringContextHelper"%>
<%@page import="com.itour.etip.pub.frame.JdbcDao"%>
<%@page import="org.jasig.cas.client.util.AssertionHolder"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<title>登录 - 商站宝</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/minicss.css"/>
<style type="text/css">
.ahover a:hover{width:100%;text-decoration:none;padding:0 0 0 0;color: rgb(0, 153, 255);}
.ahover a{width:100%;text-decoration:none;padding:0 0 0 0;color: #797979}

</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/view/ext22/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/view/ext22/ext-all.js"></script>
</head>
<%
	// 获取cas系统所登陆成功的账号
	String myUserName = AssertionHolder.getAssertion().getPrincipal().getName();
	myUserName = new String(myUserName.getBytes(),"UTF-8");
	String password = "";
	// 根据账号查询密码
	String sql = " select password from ctn_sysuser where loginmail=? or loginmoble=? ";
	JdbcDao dao = (JdbcDao)SpringContextHelper.getBean("jdbc");
	List resultSet = dao.queryForList(sql, new Object[]{myUserName,myUserName});
		if(resultSet!=null && resultSet.size()!=0){
			ETIPResultSet passowrd = (ETIPResultSet)resultSet.get(0);
			password = (String) passowrd.get("PASSWORD");
		}

%>
<body style="text-align:center; background-image:url(/img/bg_404.jpg);display: none;" onload="ini()">
<div style="margin:0 auto; padding-top:150px; width:400px;">
    <div style="height:75px; width:auto;">
      <div style="margin-left:108px;float:left;">
      	<img height="70px" width="160px" src="/view/images/logo/logo.jpg" />
      </div>
      <div>
        
      </div>
    </div>
    
    <div class="error" style="margin-top: 5px;display: none;color: red; margin-left: 35px;"></div>
    <form action="${pageContext.request.contextPath }/j_spring_security_check" id="loginForm" method="post" >
	  <p style="padding-top:20px;">
	    <input type="text" id="uname" value="<%=myUserName %>" autocomplete="off" name="j_username" style="height:45px; width:331px; border:solid 1px #0099CC; background-color:#FFFFFF;" placeholder="登录邮箱或者手机号码" />
	  </p>
	  <p style="padding-top:15px;">
	    <input type="password" id="pass" value="<%=password %>" name="j_password" style="height:45px; width:331px; border:solid 1px #0099CC; background-color:#FFFFFF;" placeholder="密码" />
	  </p>
	  <p style="padding-top:15px;">
	    <input id="loginButton" type="button" value="登录" onclick="checkUser()" style="border:none;height:47px; width:331px; background-color:#0099CC;font-size: 16px;color: #FFFFFF;cursor: pointer;" />
	  </p>
	  <p> 
		  <span style="float:left;margin-top:11px; margin-left:30px;font-weight: 200;color: #797979; font-size:13px;">
		  	<input id="chkRememberPass" type="checkbox" />记住密码
		  </span> 
		  <span class="ahover"  style="float:right; margin-top:15px; margin-right:30px;font-weight: 200; font-size:13px;">
		  <a href="${root }/view/pages/mini/commonality/Find_Password.jsp"  >忘记密码</a></span>
	  </p>
	  <p>
  <hr style="margin-top:70px;width:400px; height:1px; border:none;border-top:1px solid #0099CC;"/>
  </p>
  <p ><span style="font-weight: 200;font-size: 16px;color: #434343;">还没有账号？</span><span class="ahover" style="font-weight: 200;font-size: 16px;color: rgb(0, 153, 255);" onclick="reg();">
  <a href="###"  onclick="reg()" class="btn_200gray" style="color: rgb(0, 153, 255);"> 免费注册—></a>
 </span></p>
  </form>
</div>


</body>
<script type="text/javascript">


function ini(){
 	$("#loginButton").click();
}


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
    	 checkUser();
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
	disabledButton("loginButton");
	//获取验证码
// 	var code = document.getElementById('variCode').value;
	var name = document.getElementById('uname').value;
	var pwd = document.getElementById('pass').value;
	if(name==""){
		document.getElementById('uname').focus();
		$(".error").html("请输入用户名！");
		$(".error").show();
		clearDisableButtion("loginButton");
		return true;
	}
	if(pwd==""){
		document.getElementById('pass').focus();
		$(".error").html("请输入密码！");
		$(".error").show();
		clearDisableButtion("loginButton");
		return true;
	}
	if((name=="") && (pwd!="")){
		$(".error").html("请输入用户名！");
		$(".error").show();
		clearDisableButtion("loginButton");
		return true;
	}
// 	if(code==""){
// 		document.getElementById('variCode').focus();
// 		alert("请输入验证码");
// 		return true;
// 	}
    if(document.getElementById("chkRememberPass").checked){  
        //添加cookie  
        addCookie("userName",name,7,"/");  
        addCookie("userPass",pwd,7,"/");  
    }else{
    	addCookie("userName","",0,"/");
    	addCookie("userPass","",0,"/");
    }  
var uname = Ext.fly('uname').dom.value;
var pass = Ext.fly('pass').dom.value.replace(/\+/g, '%2B');
// var code = Ext.fly('variCode').dom.value;
var url = '${pageContext.request.contextPath}/user_login/key/userLogin';
var requestConfig = {
	url : url,
	params : "account="+uname+"&password="+pass ,
	success : function(response, options) {
		var result = Ext.util.JSON.decode(response.responseText);
		if(result.resultCode == "1"){
			$(".error").html("");
			$(".error").hide();
			document.getElementById("loginForm").submit();
		}else if(result.resultCode == "5"){
			$(".error").html("系统异常,请联管理员");
			$(".error").show();
			clearDisableButtion("loginButton");
		}else if(result.resultCode == "-1"){
			$(".error").html("验证码输入错误");
			$(".error").show();
			clearDisableButtion("loginButton");
		}else{
			$(".error").html("您输入的用户名不可用或者密码不正确,请重新输入!");
			$(".error").show();
			document.getElementById('uname').focus();
			clearDisableButtion("loginButton");

		}
		result = null;
	}
};
Ext.Ajax.request(requestConfig);
}
function reg(){
window.location.href = root + "/register.jsp";
}

function changeCode(){
// $(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
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
 function findPassword(){
	 location.href=root+"/view/pages/mini/commonality/Find_Password.jsp";
 }
</script>
</html>