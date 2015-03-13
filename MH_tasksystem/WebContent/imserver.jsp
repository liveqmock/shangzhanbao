<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	/*来电弹屏的国度页面，经过applet和etip框架通讯，通知etip打开多任务窗口，需要把主叫号、被叫号、工号传递到etip多任务窗口*/
	String url = java.net.URLDecoder.decode(request.getQueryString() == null?"":request.getQueryString());
	String[] bb = url.split("&");
	java.util.Map<String,String> map = new java.util.HashMap<String,String>();
	for(String item : bb){
		String[] aa = item.split("=");
		if(aa.length == 2){
			map.put(aa[0], aa[1]);
		}
	}
	//	
	String dnis = map.get("dnis");//被叫号
	String num = map.get("ani");//主叫号
	String workNO = map.get("aid");//工号

	//处理没有值的情况
	if(num == null)	num="13910726139";
	if(dnis == null)dnis = "4008168168";
	if(workNO==null) workNO="";

	
%>
<html>
  <head>
    <title>来电弹屏</title>
	<style>
		td,input{font-size:9pt; font-family:Verdana, Arial, Helvetica, sans-serif,"宋体"}
	</style>

	<script language="javascript">

function AppletMsg() {
	this.requestid = "";
	this.num = "";
	this.dnis = "";
	this.workNO = "";
}


function encodeMessage(message) {
	var node;
	var subnode;
	var xmldoc = new ActiveXObject("MSXML2.DOMDOCUMENT");
	xmldoc.async = false;
	xmldoc.loadXML("<?xml version=\"1.0\"  encoding=\"GBK\"?><MESSAGE version=\"CMBCC/1.0\"></MESSAGE>");
	node = xmldoc.createElement("REQUESTID");
	node.appendChild(xmldoc.createTextNode(message.requestid));
	xmldoc.documentElement.appendChild(node);
	node = xmldoc.createElement("DATA");
	subnode = xmldoc.createElement("num");
	subnode.appendChild(xmldoc.createTextNode(message.num));
	node.appendChild(subnode);
	subnode = xmldoc.createElement("dnis");
	subnode.appendChild(xmldoc.createTextNode(message.dnis));
	node.appendChild(subnode);
	subnode = xmldoc.createElement("workNO");
	subnode.appendChild(xmldoc.createTextNode(message.workNO));
	node.appendChild(subnode);
	xmldoc.documentElement.appendChild(node);
	var msg = xmldoc.xml;
	//以下做什么呢？
	msg = msg.replace(new RegExp("'","gm"),"%27");
	msg = msg.replace(new RegExp("\"","gm"),"%22");
	msg = msg.replace(new RegExp("\n","gm"),"\\n");
	msg = msg.replace(new RegExp("\r","gm"),"\\r");

	return msg;
}

function decodeMessage(xml) {
	xml = xml.replace(new RegExp("%27","gm"),"'");
	xml = xml.replace(new RegExp("%22","gm"),"\"");
	xml = xml.replace(new RegExp("\\n","gm"),"\n");
	xml = xml.replace(new RegExp("\\r","gm"),"\r");
	
	var node;
	var message;
	var xmldoc = new ActiveXObject("MSXML2.DOMDOCUMENT");
	xmldoc.async = false;
	xmldoc.loadXML(xml);
	node = xmldoc.documentElement.selectSingleNode("/MESSAGE/REQUESTID");
	var requestid = node.text;
	message = new AppletMsg();
	message.requestid = requestid;
	node = xmldoc.documentElement.selectSingleNode("/MESSAGE/DATA/num");
	message.num = node.text;
	node = xmldoc.documentElement.selectSingleNode("/MESSAGE/DATA/dnis");
	message.dnis = node.text;
	node = xmldoc.documentElement.selectSingleNode("/MESSAGE/DATA/workNO");
	message.workNO = node.text;
	return message;
}

		//接收来自于etip的消息，关闭窗口
		function receiveMsgFromEtip(xml) {
		    //alert("calledByApplet:"+xml);
			var message = decodeMessage(xml);
			document.msg.requestid.value = message.requestid;
			document.msg.num.value = message.num;
			document.msg.dnis.value = message.dnis;
			document.msg.workNO.value = message.workNO;
			//以下关闭窗口
			 if(document.all)  {   
                  if(parseFloat(window.navigator.appVersion.substr(window.navigator.appVersion.indexOf("MSIE")+5,   3))   <   5.5)   {   
                          var   str     =   '<object   id=meizzMax   classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'   
                                  str   +=   '<param   name="Command"   value="Close"></object>';   
                          document.body.insertAdjacentHTML("beforeEnd",   str);   
                          document.all.meizzClose.Click();   
                  }   
                  else {   
                          window.opener   =   "meizz";   
                          window.close();   
                  }   
	          }   
		      else {
				  window.close();   
			  }
    	}
		//发送消息到ETIP平台，窗口需要收到消息时才关闭
		function sendMsgToEtip() {
		    var requestid;
			var message;
			message = new AppletMsg();
			message.requestid = document.msg.requestid.value;
			message.num = document.msg.num.value;
			message.dnis = document.msg.dnis.value;
			message.workNO = document.msg.workNO.value;
			xmlString = encodeMessage(message);
			imclient.sendMessage(xmlString);
		}
	</script>
  </head>
  
  <body>
    <form name=msg method="post">
	  <!--以下参数给弹屏使用-->
	  <input type=hidden name="requestid" id="requestid"  value=101/>
	  <input type=hidden name=dnis id="dnis" value="<%=dnis%>"/>
	  <input type=hidden name=num id="num" value="<%=num%>"/>
	  <input type=hidden name=workNO id="workNO" value="<%=workNO%>"/>
	<!--以下参数给-->
	 <table width="600" cellpadding="0"  cellspacing="0" align="center" border="1">
	  <tr height=22pt>
	    <td colspan=2 align=center><%=workNO%>你好</td>
	  </tr>
	  <tr height=22pt>
	    <td>&nbsp;&nbsp;<%=num%>呼叫<%=dnis%>,系统正在处理...</td>
	  </tr>
	  <!--
	  <tr height=22pt>
	    <td colspan=2><input type=button onclick="CallApplet()" value=Submit></td>
	  </tr>
	  -->
	</table>
	</form>

	
	<applet name="imclient" 
	        codebase="." 
	        archive="log4j-1.2.12.jar,commons-logging-1.0.4.jar,crsimclient.jar" 
		    code="com.cmb.cc.imclient.CRSIMClient"	width="0" height="0" hspace="0" vspace="0">
		<param name="tcpLocalPort" value="9010"/>//作为etip端口
		<param name="tcpRemotePort" value="9011"/>//作为弹屏端口
		<param name="javaScriptFunc" value="receiveMsgFromEtip"/>
	</applet>
  </body>
</html>

	
	<script language="javascript">
		//在页面加载完成后，发送请求
		sendMsgToEtip();
	</script>