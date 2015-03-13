<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.itour.etip.pub.frame.FrmUser"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
FrmUser user = FrmUser.getUser();
%>
<html xmlns:ext="http://extjs.com/docs">
<head>
<link rel="stylesheet" type="text/css" href="./view/easyUI/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./view/easyUI/css/icon.css">
<link rel="stylesheet" type="text/css" href="./view/css/task/menu.css">
<script type="text/javascript" src="./view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="./view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<title>民航任务管理系统</title>
<script>
var root = "${root}";
var allFunctions = "<s:property value='#session.LOGINUSER.functions' />";
</script>
<script>

	/**执行任务--到tree页面*/
	function todoTask( taskInfoID ) {
		parent.frames["childIframe"].window.todoTask( taskInfoID );
	}

	/**查看未读信息的任务详情**/
	function lookupNotReadTaskInfo(taskInfoID ,messageID) {
		todoTask(taskInfoID);//跳转到任务详情页面
		parent.frames["headFrame"].window.disposeUserCollectMessageReminderByID( messageID );//更新信息状态:设置为只读
	}

	/**更新未读信息*/
	function updataNotReadMessage() {
		parent.frames["headFrame"].window.updataNotReadMessage();
	}
	
	/**window**/
	function closeIframeWindow() {
		$('#otherInfoIframeWindow').window('close');
	}
	function openIframeWindow() {
		$('#otherInfoIframeWindow').window('open');
	}
	/**show message***/
	function showMessage(message,options) {
		if( !options ){
			options = new Object();
		}
		options.msg = message;
		if( !options.title){
			options.title = "提示信息";
		}
		if( !options.timeout ){
			options.timeout = "3000";
		}
		$.messager.show( options );
	}
	/**设置窗口属性
	 * @参数 title 标题
	 * @参数 options Set panel size and do layout. The options object contains following properties:
	 *width: the new panel width
	 *height: the new panel height
	 *left: the new panel left position
	 *top: the new panel top position
	 * **/
	function setWindowAttr( title ,options) {
			try{
				options.left = (document.body.clientWidth-options.width)/2;
				options.top = (document.body.clientHeight-options.height)/2;
			}catch(e){
			}
			$('#otherInfoIframeWindow').window('setTitle',title);
			$('#otherInfoIframeWindow').window('resize',options);
	}
 /**设置window信息*/
	function setWindowSrc(url) {
		if( url ){
			$('#otherInfoIframe').attr("src",url);
		} 
	}
	/**关闭窗口信息清空*/
	$(function(){
		/*iframe窗口关闭事件*/
		$('#otherInfoIframeWindow').window({     
			onBeforeClose:function(){  
			   // 列表重新加载数据
				$('#otherInfoIframe').attr("src","#");  
		    }   
		})
		$('#headFrame').attr("src", root + "/head.jsp");  
	});
</script>
</head>ssssssssssssss
<body class="easyui-layout" style="margin: 0px;padding: 0px;" >
	<div region="north" style="margin:0px;height:50px;overflow:hidden;border:0;"  >
		<iframe id="headFrame" name="headFrame" style="width:100%;height:100%;" 
			border="0"  scrolling="no"></iframe>
	</div> 
	<div region="center" style="margin:0px;overflow: hidden">
		<iframe id="childIframe" name="childIframe" src="${root }/index_Frist.jsp" style="width:100%;height:100%;" 
		border="0" scrolling="yes" modal =true ></iframe>
	</div> 
	 <!--  接收其他页面的窗口 --> 
		<div  id="otherInfoIframeWindow"  class="easyui-window" iconCls="icon-add" closed="true" 
  				style="padding: 10px;width: 570px;height:365;" modal =true
  					maximizable="false" minimizable="false" collapsible="false" >
       		 <iframe id="otherInfoIframe" name="taskInfoIframe" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
 		</div>
</body>
</html>
