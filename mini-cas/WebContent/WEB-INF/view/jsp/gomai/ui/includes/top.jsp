<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<title>商站宝</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<link rel="stylesheet" href="<c:url value="/css/gomai/login.css" />" media="all"/>
	<spring:theme code="standard.custom.css.file" var="customCssFile" />
	<link type="text/css" rel="stylesheet" href="<c:url value="${customCssFile}" />" />
    <script type="text/javascript" src="<c:url value="/js/jquery/jquery1.4.2.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery/jquery1.8.5-ui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/js/cas.js" />"></script>
    <style type="text/css">
	    #msg {width:110px; height:30px;margin-right: 5px; vertical-align:middle;display:table-cell;}
		#msg h2 { font-size: 1.4em; margin-bottom: 0.5em; }
		#msg.errors { border: 1px dotted #BB0000; color: #BB0000; padding-left: 100px;background: url(./css/gomai/images/error.png) no-repeat 20px center;  }
		#msg.success { border: 1px dotted #390; color: #390; padding-left: 100px; background: url(./css/gomai/images/confirm.png) no-repeat 20px center; }
		#msg.info { border: 1px dotted #008; color: #008; padding-left: 100px; background: url(./css/gomai/images/info.png) no-repeat 20px center; }
    </style>
</head>