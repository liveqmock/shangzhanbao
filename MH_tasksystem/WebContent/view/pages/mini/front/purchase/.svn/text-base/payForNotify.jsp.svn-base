<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.mini.util.AlipayMgr"%><%
String ret = AlipayMgr.toReturn(request);
if(!"fail".equals(ret)){
	out.print("success");//成功接收支付宝发来的付款信息
	}else{
		out.print("fail");//出错
	}
%> 


