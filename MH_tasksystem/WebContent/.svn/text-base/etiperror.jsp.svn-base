<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ page import="com.opensymphony.xwork2.interceptor.ExceptionHolder" %>
<%
  //此页面要获取例外详细信息，可如何能够获取exception信息呢？
  com.opensymphony.xwork2.ognl.OgnlValueStack  stack = (com.opensymphony.xwork2.ognl.OgnlValueStack)request.getAttribute("struts.valueStack");
  ExceptionHolder holder= (ExceptionHolder)stack.pop();
  Exception ex = holder.getException();
  String exStack=holder.getExceptionStack();
  String errorName ="未知系统异常";
  String exMessage;
  
  if(ex instanceof com.itour.etip.pub.kit.exception.ETIPException){
	  //系统已知的例外
	  com.itour.etip.pub.kit.exception.ETIPException vwpEx =(com.itour.etip.pub.kit.exception.ETIPException)ex;
	  exMessage =vwpEx.getMessage(); 
	  errorName = vwpEx.getErrorName();
  }else{
	  exMessage = ex.getMessage();
  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
<title>1111</title>
</head>
<body style="text-align: center;">
<%-- <center><%=errorName%></center> --%>
<%-- <%=exMessage%> --%>
<%-- <%=exStack%> --%>
对不起，出错了！
<a href="javascript:history.go(-1);">返回</a>

</body>
</html>