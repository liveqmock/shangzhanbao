

//获取right页面
var mainframe = parent.frames['frame_main'].document;

//给添加的信息处添加边框
function initBorder(info){
	var slogan = mainframe.getElementById(info);
	$(slogan).css("border","2px solid red");
}

//给标语和卖点辅值
function getSlogan(info,divid,fontinfo){
	var slogan = mainframe.getElementById(divid);
	if($(info).val()!=""){
		slogan.innerHTML = "<h3>"+$(info).val()+"</h3>";
	}else{
		$(info).val(fontinfo);
	}
	$(slogan).css("border","");
}

//子页面跳转锚点
function gotoAnchor(info,url) {
	$(info).val("");
	parent.frames['frame_main'].window.clickOpen(url);
}

//提交数据
function getsubmit(){
	var url = root + "/page_template_info/key/batchAdd";
	if($("#reason1").val() == "第一个理由"){
		alert("请输入第一个理由！");
		return;
	}
	if($("#reason2").val() == "第二个理由"){
		alert("请输入第二个理由！");
		return;
	}
	if($("#reason3").val() == "第三个理由"){
		alert("请输入第三个理由！");
		return;
	}
	if($("#reason4").val() == "第四个理由"){
		alert("请输入第四个理由！");
		return;
	}
	//拼接json字符串
	var dataJson = "[{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第一个理由','content':'" + $("#reason1").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第二个理由','content':'" + $("#reason2").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第三个理由','content':'" + $("#reason3").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第四个理由','content':'" + $("#reason4").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'}]";
	ajaxUtil(url + "?dataJson=" + encodeURIComponent(dataJson), null,function msg(request, status, error) {
		window.location.href=root+"/view/pages/mini/page/templateLeft/template1_left_step3.jsp";
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

