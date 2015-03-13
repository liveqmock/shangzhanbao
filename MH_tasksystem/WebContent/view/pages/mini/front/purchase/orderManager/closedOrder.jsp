<%
	// 获取订单取消的结果
	String result = (String)request.getAttribute("result");
	response.getWriter().write(result);
%>
