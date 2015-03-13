<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.HashMap"%>
    <%@page import="java.util.Map"%>
    <%@page import="java.util.Iterator"%>
    <%
    	Object oldurl = request.getSession().getAttribute("oldurl");//获取登录前被拦截的路径，为空则进入首页
    	Map<String,String> map = (HashMap)request.getSession().getAttribute("paramsmap");//获取被拦截的路径的参数
    	String params = "?1=1";//拼写参数的字符串
    	if(map!=null && map.entrySet()!=null){//循环拼写参数
    		Iterator it = map.entrySet().iterator();
	    	while(it.hasNext()){
	    		Map.Entry entry = (Map.Entry)it.next();
	    		String key = entry.getKey().toString();
	    		String value = entry.getValue().toString();
	    		params+=("&"+key+"="+value);
	    	}
    	}
    	request.getSession().removeAttribute("oldurl");//在session里面移除路径
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商站宝</title>
<script type="text/javascript">
function init(){
	if(<%=oldurl!=null %>){
		window.location="${pageContext.request.contextPath}<%=oldurl  %><%=params %>";
	}else{
		window.location="${pageContext.request.contextPath}/check_user";
	}
}
</script>
</head>
<body onload="init()">
</body>
</html>