<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript">
//此js是修改父页面下拉滚动条影藏
$(window.parent.document).find("#iframeHeight").load(function(){
	var main = $(window.parent.document).find("#iframeHeight");
	var thisheight = $(document).height()+30;
	main.height(thisheight);
	});
</script>
</head>
<body>

</body>
</html>