<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.itour.etip.pub.kit.security.EtipSecurityUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<%
  	String rootPath =   request.getContextPath();
  	String username = EtipSecurityUtil.getUserName();
  	if(username != null){
  		out.println("当前登录用户为：");
  		out.println(username);
  		out.println("<br>");
  	  String userrole = EtipSecurityUtil.getUserRole();
	    out.println("当前登录用户角色：");
	    if(userrole != null)
	  	    out.println(userrole);
	    out.println("<br>");
  	}
  	out.println(request.getRemoteHost());
  	
	%>
<html>
 <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ETIP 403 error</title>
您没有被授权访问当前商站资源<br>
<a href="https://sso.etip.com:7443/cas/logout?url=http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/">注销</a><br>
<br>
	</head>
  <body>
 
  </body>
</html> 