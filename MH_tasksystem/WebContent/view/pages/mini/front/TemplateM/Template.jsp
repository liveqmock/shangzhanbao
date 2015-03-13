<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MiniPage</title>
</head>
<frameset rows="50,60,*" cols="*" id="frame_top_set" frameborder="no" border="0" framespacing="0">
	<frame  src="${root }/page_manage/key/top" name="frame_top" id="frame_top" scrolling="no" noresize="noresize" />
	<frame  src="TemplateTitle/template1_Title3.jsp" name="frame_Title" id="frame_Title" scrolling="no" noresize="noresize" />
	<frameset cols="300,*" name="frame_menu_set" id="frame_menu_set" frameborder="no" border="0" framespacing="0">
	<frame src="TemplateLeft/template1_left_step_shop.jsp" name="frame_left" id="frame_left" scrolling="yes" noresize="noresize" />
	<frame src="${root }/temp_manage/key/searchOpenTemp?templateData.status=OPEN" name="frame_main" id="frame_main" style="background:#eeeeee" scrolling="yes" />
<noframes></noframes>
</noframes>