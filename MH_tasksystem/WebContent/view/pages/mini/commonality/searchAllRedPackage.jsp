<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商站宝--红包管理</title>

    <script type="text/javascript">   
    $(function(){
    	return;
    	var state = 0;
    	
        $("#iframepage").load(function(){
        	if(state == 1){
        		alert("name:"+this.contentWindow.name);
        	}else{
        		alert("name1:"+this.contentWindow);
        		state = 1;
            	this.contentWindow.location = "proxy.html";
        	}
        	var iframeHeight = $("#iframepage").contents().find("body").height();
        	 alert(iframeHeight); 
        	$("#iframepage").height(iframeHeight);
        });   
           
    });   
    
    function setIfmHeight(height){
    	$("#iframepage").height(height);
    } 
    </script>  

</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>
		<div id="redPackageListDiv" style="width: 80%;margin-left: 200px;">
			<iframe src="${requestScope.path }/siims/vmaque/redPackage/searchAllRedPackage.jspx?userId=${requestScope.userId}"
			name="iframepage"  id="iframepage" frameborder="no" border="0" scrolling="no" height="100%" width="100%"></iframe>
		</div>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>