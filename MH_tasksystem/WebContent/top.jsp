<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${root }/view/css/frame.css" rel="stylesheet" type="text/css" />
<style>
body{
	background:url(${root}/images/operating/top_bg.jpg) repeat-x left top;
	margin:0 auto;
	font-size:12px;
	
}
</style>
</head>

<body>
<div id="Top_Left"></div><div id="Top_Right">您好，${frmUser.etipUserEmail }. 欢迎登录！今天是<script language="JavaScript" type="text/JavaScript">
				var day="";
				var month="";
				var ampm="";
				var ampmhour="";
				var myweekday="";
				var year="";
				mydate=new Date();
				myweekday=mydate.getDay();
				mymonth=mydate.getMonth()+1;
				myday=mydate.getDate();
				myyear=mydate.getYear();
				year=(myyear>200)? myyear : 1900+myyear;
				if(myweekday==0)
				weekday=" 星期日 ";
				else if(myweekday==1)
				weekday=" 星期一 ";
				else if(myweekday==2)
				weekday=" 星期二 ";
				else if(myweekday==3)
				weekday=" 星期三 ";
				else if(myweekday==4)
				weekday=" 星期四 ";
				else if(myweekday==5)
				weekday=" 星期五 ";
				else if(myweekday==6)
				weekday=" 星期六 ";
				document.write(year+"年"+mymonth+"月"+myday+"日 "+weekday);
			  </script><a href="###" onclick="if(confirm('您确定退出么？')) window.parent.location.href='${root }/j_spring_security_logout'">退出</a></div>
</body>
</html>
