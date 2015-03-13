<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html xmlns:ext="http://extjs.com/docs">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<style>
body {
	margin:0 auto;
	background:#eaeaea;
}
</style>
</head>
<frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
  	<frame  src="${root }/frame/key/backtop" name="frame_top" id="frame_top" scrolling="no" noresize="noresize" />
  	<frameset cols="191,6,*" name="frame_menu_set" id="frame_menu_set" frameborder="no" border="0" framespacing="0">
    <frame src="${root }/frame/key/menu" name="frame_left" id="frame_left" scrolling="yes" noresize="noresize" />
    <frame src="${root }/ctrlback.html" name="frame_ctrl" id="frame_ctrl" scrolling="no" noresize="noresize" />
    <frame src="${root }/client_manage/key/searchAllClient" name="frame_main" id="frame_main" style="background:#fff" scrolling="auto" />
</frameset></frameset>
</html>