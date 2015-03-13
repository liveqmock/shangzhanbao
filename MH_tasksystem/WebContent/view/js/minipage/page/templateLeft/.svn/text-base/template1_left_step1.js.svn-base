

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
		slogan.innerHTML = "<"+fontinfo+">"+$(info).val()+"</"+fontinfo+">";
	}else{
		$(info).val("用一句话说明产品的核心卖点");
	}
	$(slogan).css("border","");
}

//子页面跳转锚点
function gotoAnchor(info,url) {
	$(info).val("");
	parent.frames['frame_main'].window.clickOpen(url);
}

//提交数据
function getsubmit(step){
	var url = root + "/page_template_info/key/batchAdd";
	if($("#slogan").val()=="用一句话说明产品的核心卖点"){
		alert("请输入产品的核心卖点！");
	}else{
		//拼接json字符串
		var dataJson = "[{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'产品标语','content':'"
			+ $("#slogan").val()
			+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'}]";
		ajaxUtil(url + "?dataJson=" + encodeURIComponent(dataJson), null,function msg(request, status, error) {
			window.location.href=root+"/view/pages/mini/page/templateLeft/template1_left_step2.jsp";
		},function errorMsg(request, status, error){
			alert("添加信息失败，请重试！");
		});
	}
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



