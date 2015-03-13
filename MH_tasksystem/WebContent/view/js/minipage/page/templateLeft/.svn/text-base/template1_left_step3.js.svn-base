

//获取right页面
var mainframe = parent.frames['frame_main'].document;


//添加销售电话和其他服务样式
function getCheck(info,id){
	var divinfo=mainframe.getElementById(id);
	if($(info).attr("checked")=="checked"){//当复选框被选中时
		$(divinfo).css("display","block");
		$(divinfo).css("border","2px solid red");
		$("#p_phone").css("display","block");
		if(!isphone($(info).val())){
			$("#phone").val("");
		}
	}else{
		$(divinfo).css("display","none");
		$(divinfo).css("border","");
		$("#p_phone").css("display","none");
		$("#phone").val("请输入您的销售电话，如400-123-123");
	}
}

//添加销售电话
function getPhone(info){
	var divinfo=mainframe.getElementById("div_phone");
	if(isphone($(info).val())){
		if($(info).val()!=""){
			divinfo.innerHTML="<p>咨询电话："+$(info).val()+"</p>"
			$(divinfo).css("border","");
		}else{
			$(divinfo).val("请输入您的销售电话，如400-123-123");
		}
	}
}

/*判断输入是否为合法的电话号码，匹配固定电话或小灵通*/
function isphone(inpurStr){
	var partten = /^(1[3,5,8,7]{1}[\d]{9})|(((400)-(\d{3})-(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{3,7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;
	if(partten.test(inpurStr)){
		return true;
	}else{
		return false;
	}
}

//子页面跳转锚点
function gotoAnchor(info,url) {
	$(info).val("");
	parent.frames['frame_main'].window.clickOpen(url);
}


//提交数据
function getsubmit(){
	var url = root + "/page_template_info/key/batchAdd";
	if($("#chephone").attr("checked") == "checked" && !isphone($("#phone").val())){
		alert("请输入您的销售电话，如400-123-123！");
		return;
	}
	//拼接json字符串
	var dataJson = "[{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'销售电话','content':'" + $("#phone").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'}]";
	ajaxUtil(url + "?dataJson=" + encodeURIComponent(dataJson), null,function msg(request, status, error) {
		window.location.href=root+"/view/pages/mini/page/templateLeft/template1_left_step4_1.jsp";
		window.parent.frame_Title.location.replace(root+"/view/pages/mini/page/templateTitle/template1_Title2.html");
		window.parent.frame_top.location.replace(root+"/view/pages/mini/page/templateTop/template1_top2.html");
	},function errorMsg(request, status, error){
		alert("添加信息失败，请重试！");
	});
}

//ajax访问后台
function ajaxUtil(url,data,backMethod,errorMethod){
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : url, //与此php页面沟通 
		dataType:'json',//从php返回的值以 JSON方式 解释 
		data: data, //发给后台的数据有两项Json串
		success: backMethod,
		error:errorMethod
	});
}