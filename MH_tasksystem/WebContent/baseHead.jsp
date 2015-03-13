<%@page pageEncoding="UTF-8"%>
<%@page import="com.itour.etip.pub.frame.FrmUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	//jsp 清除缓存
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="pageRoll" value="${pageRoll}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	var root = "${root}";
	var casdomain = "http://192.168.5.55:9997/mini-cas";
	var sysLoginDomain = "http%3A%2F%2F192.168.5.55%3A8080%2Fview%2Fpages%2Fmini%2Ffront%2Flogin.jsp";
	var redPackageroot = "http://192.168.5.55:8088";
</script>
