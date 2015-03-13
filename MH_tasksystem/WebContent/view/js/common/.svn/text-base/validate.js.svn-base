//网页输入校验工具
//version：2.0
//作者：何大勇
//时间：2012-10-10
//需要依赖：jquery   jquery.scrollTo.js bootstrap-tooltip.js
//支持校验类型：不为空、数字、非数字、邮箱、最大长度、最小长度、起始字符、终止字符、AJAX验证




//错误数量
var errors = 0;
var errorsArray ;
//显示错误信息
//obj  校验失败的控件对象
//msg  错误信息
function showErr(obj,msg){
	if(obj.attr('id')==null){
		setId(obj);
	}

	if(errorsArray.indexOf(obj.attr("id")+",")==-1){
		errorsArray += obj.attr("id") + ",";
	}
	//假设页面中不存在与当前控件"name"属性相同的控件的时候，隐藏之前的错误提示
//	hideErr(obj);
//	var offset = obj.offset();
//	var left = offset.left+obj.width()+10;
//	var div = document.createElement('<div id="errDiv'+obj.prop("validateId")+'" style="z-index:2000;position: absolute;left:'+left+'px;top:'+offset.top+'px;color:black;width:">');
//	var img = document.createElement('<img id="errImg'+obj.prop("validateId")+'" src="/rdfweb/mysoftlife/view/images/flag.png" style="z-index:3000;left:'+left+'px;top:'+(offset.top+5)+'px;width:10px;height:13px;position:absolute;">');
//	var span = document.createElement('<span id="errSpan'+obj.prop("validateId")+'" style="z-index:2000;padding:5px;margin-left:-5px;border:1px solid #92c85a;left:'+(left+14)+'px;top:'+offset.top+'px;background-color:#f5fcee;font-size:9pt;position:absolute;">');
//	span.innerHTML=msg;
//	document.body.appendChild(div);
//	document.body.appendChild(img);
//	document.body.appendChild(span);
//	var span = $("<span>").html(msg);
	obj.attr("data-original-title",msg);
	obj.attr("tooltip-type","live");
	obj.tooltip("live");
	//页面会自动找到控件，显示在最顶端
	//让滚动条上移200像素，使控件靠近屏幕中央
	obj.css("border-color","red");
	obj.mouseover();
}

//隐藏错误信息
//obj  校验失败的控件对象
function hideErr(obj){
	if(errorsArray.indexOf(obj.attr("id")+",")>-1){
		if(obj.attr("ajaxFlag")!=null){
			return;
		}
		errorsArray = errorsArray.replace(obj.attr("id")+",","");
		obj.tooltip("destroy");
		obj.css("border-color","");
	}
	var inputs = obj.find("input[type=text],input[type=password],textarea");
	for ( var i = 0; i < inputs.length; i++) {
		hideErr($(inputs[i]));
	}
//	var validateId = obj.attr("validateId");
//	$("#err"+validateId).remove();
}

$(function(){
	getValidate();
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-tooltip.css">').appendTo($(document.body));
});

//给当前页面绑定验证函数
function getValidate(){
	//初始化参数
	errorsArray = "";
//	$("input[type=text],input[type=password],textarea").live("keyup",function(){
//		boundProp($(this));
//	});
//	$("input[type=text],input[type=password],textarea").live("blur",function(){
//		boundProp($(this));
//		boundAjax($(this));
//	});
	var inputs = $("input[type=text],input[type=password],textarea");
	for(var i=0;i<inputs.length;i++){
		setId($(inputs[i]));
	}
//	$("input[type=text],input[type=password],textarea").live("keyup",function(){
//		$(this).tooltip("destroy");
//		$(this).css("border-color","");
//		boundProp($(this));
//	});
	$("input[type=text],input[type=password],textarea").live("keyup",function(){
		boundAjax($(this));
		boundProp($(this));
		if($(this).attr("select")!=null){
			$(this).val("");
			setProp($(this),"select",$(this).val()=="",$(this).attr("select"),"您还未选择数据！");
		}
	});
//	$("input[type=text],input[type=password],textarea").live("keyup",function(event){
//		if($(this).attr("select")!=null){
//			$(this).val("");
//			setProp($(this),"select",$(this).val()=="",$(this).attr("select"),"您还未选择数据！");
//		}
//	});
}


function boundProp(obj){

	if(obj.val()==null || obj.val() == ""){
		//不为空
		if(setProp(obj,"notnull",obj.val()=="",obj.attr("notnull"),"不能为空！")) return;
	}else{
		
		//只能输入英文
		if(setProp(obj,"eng",!eng(obj.val()),obj.attr("eng"),"只能是英文")) return;
		
		if(setProp(obj,"engOrDigit",!engOrDigit(obj.val()),obj.attr("engOrDigit"),"域名不合法！")) return;
		//不为纯数字
		if(setProp(obj,"notnum",isDigit(obj.val()),obj.attr("notnum"),"不能是纯数字！")) return;
		//只能是数字
		if(setProp(obj,"num",!isDigit(obj.val()),obj.attr("num"),"只能是数字！")) return;
		//只能是正整数
		if(setProp(obj,"integer",!isInteger(obj.val()),obj.attr("integer"),"只能是正整数")) return;
		//起始字符校验
		if(setProp(obj,"startwith",obj.val().indexOf(obj.attr("startwith"))!=0,"只能以"+obj.attr("startwith")+"开头！","")) return;
		//终止字符校验
		if(setProp(obj,"endwith",obj.val().indexOf(obj.attr("endwith"))!=obj.val().length,"只能以"+obj.attr("endwith")+"结尾！")) return;
		//验证邮箱地址和手机格式
		if(setProp(obj,"emailOrTel",!checkMailOrPhome(obj.val()),obj.attr("emailOrTel"),"邮箱或手机格式不正确！")) return;
		//邮箱地址
		if(setProp(obj,"email",!checkMail(obj.val()),obj.attr("email"),"邮箱格式不正确！")) return;
		//特殊字符校验
		if(setProp(obj,"checkScharacters",!checkScharacters(obj.val()),obj.attr("checkScharacters"),"不能输入特殊字符！")) return;
		//电话格式
		if(setProp(obj,"tel",!isTel(obj.val()),obj.attr("tel"),"号码格式不正确！")) return;
		//字母开头
		if(setProp(obj,"letterStart",!letterStart(obj.val()),obj.attr("letterStart"),"只能以字母开头！")) return;
		//密码参照校验
		if(setProp(obj,"refer",obj.val()!=$("#"+obj.attr("refer")).val(),"两次密码不一致！","")) return;
		//最大长度
		if(setProp(obj,"max",lengthOf(obj.val())>eval(obj.attr("max")),"最多输入"+obj.attr("max")+"个字符","")) return;
		//max暂时信息提示
		if(setProp(obj,"max2",lengthOf(obj.val())>eval(obj.attr("max2")),"字符过长","")) return;
		//最小长度
		if(setProp(obj,"min",lengthOf(obj.val())>0&&lengthOf(obj.val())<eval(obj.attr("min")),"最少输入"+obj.attr("min")+"个字符","")) return;
		
		
		if(setProp(obj,"url",isURL(obj.val()),obj.attr("url"),"您输入的网址有误！")) return;
		//
		if(setProp(obj,"select",obj.val()=="",obj.attr("select"),"您还未选择数据！")) return;
		//以上判断都通过，即隐藏错误信息
	}
	
	hideErr(obj);

	
}
function boundAjax(obj){
	boundProp(obj);
	if(obj.attr("ajax")==null || obj.val()==""){
		return;
	}
	
	if(errorsArray.indexOf(obj.attr("id")+",")!=-1 && obj.attr("ajaxFlag")==null){
		return;
	}
	
	var str = obj.val();
	var params;
	if(obj.attr("ajax")!=null) {
		params = obj.attr("ajax").split(",");
		//校验地址
		var url = params[0],
		//后台接受参数的名字
			keywordName = params[1],
		//后台判定通过回传的字符串
			correctStr = params[2],
		//验证失败的提示语句
			msg = params[3];
		$.ajax({
			url:url,
			data:keywordName+"="+obj.val(),
			form:obj.closest("form"),
			dataType:"text",
			obj:obj,
			success:function(data){
				if(setProp(this.obj,"ajax",data!=correctStr,msg,"校验失败，已存在！")) return;
				this.obj.removeAttr("ajaxFlag");
				hideErr(this.obj);
			}
		});
		obj.attr("ajaxFlag","true");
//		showErr(obj,"正在验证数据，请稍后。。。");
	}
}

//检查表单是否可提交
function checkSub(form,callback){
	//重新绑定页面校验，避免使用js动态添加控件的时候检测不到
//	getValidate();
	//遍历表单的输入框和输入域，检查表单是否所有输入都已合法
	form.attr("subFlag","true");
	checkForm(form);
	if(errorsArray.length==0){
		if(callback){
			callback();
			return false;
		}
		return true;
	}else{
		try{
			$.scrollTo($(".tooltip:first").prev(),500,{offset:-200});
		}catch(e){
			
			document.documentElement.scrollTop = document.documentElement.scrollTop - 200;
		}
		$(".tooltip:first").prev().focus();
		return false;
	}
}
//检查表单
function checkForm(form){
	//遍历
	var inputs = form.find("input[type=text],input[type=password],textarea");
	for ( var i = 0; i < inputs.length; i++) {
		boundProp($(inputs[i]));
	}
}
//设置监控属性
function setProp(obj,prop,flag,msg,defaultMsg){
	if(obj.attr(prop)!=null&&flag){
		if(msg==""){
			msg=defaultMsg;
		}
		showErr(obj,msg);
		return true;
	}
	return false;
}


//隐藏所有错误信息
function hideAllErr(){
	$(".tooltip").prev().tooltip("destroy");
	
}


//验证输入参数是否是数字
function isDigit(s) 
{ 
	var patrn=/^([1-9]([0-9,])*(\.[0-9]+)?)$/; 
	if (!patrn.exec(s)) return false ;
	return true ;
}
//只能输入英文
function eng(str){
	var filter = /^[a-zA-Z]+$/;
	if(!filter.exec(str)) return false;
	return true
}
function engOrDigit(s){
		
		
			var filter = /^(?!_)(?!-)[a-zA-Z_-]*[a-zA-Z0-9_-]+$/;
			 if(!filter.exec(s)) return false;
		
	 
	return true
}

//验证输入的参数是否是正整数
function isInteger(int){
	var teger=/^[0-9]*[1-9][0-9]*$/; 
	if(!teger.exec(int)) return false;
	return true
}

//验证输入的手机号码格式是否正确
function isTel(t){
	var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
	if(!teger.exec(t)) return false;
	return true
}

//验证手机或者邮箱
function checkMailOrPhome(mailTel) {
	var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 if (filter.test(mailTel) || teger.exec(mailTel)) return true;
	 else {
		 return false;
	 }
}

//验证邮箱
function checkMail(mail) {
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 if (filter.test(mail)) return true;
	 else {
		 return false;
	 }
}

//特殊字符校验
function checkScharacters(str) {
	var invalidChar=/^(([^\^\.<>%&',;=?$"':#@!~\]\[{}\\/`\|])*)$/;
	 if (invalidChar.test(str)) return true;
	 else {
		 return false;
	 }
}
//以字母开头
function letterStart(str){
	var filter  = /^[a-zA-z]/;
	if (filter.test(str)) return true;
	else {
		return false;
	}
}

function lengthOf(str){
	var strlen = 0; 
	for(var i = 0;i < str.length;i++)
	{
		if(str.charCodeAt(i) > 128){
			strlen += 2;
		}else{ 
			strlen++;
		}
	}
	return strlen;
}
function isURL(str_url){ 
	var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
	+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
	+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
	+ "|" // 允许IP和DOMAIN（域名） 
	+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.  
	+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名  
	+ "[a-z]{2,6})" // first level domain- .com or .museum  
	+ "(:[0-9]{1,4})?" // 端口- :80  
	+ "((/?)|" // a slash isn't required if there is no file name  
	+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
	var re=new RegExp(strRegex);  
	if (re.test(str_url)){ 
	     return (true);  
	}else{  
	   return (false);  
	}
}
function setId(obj){
	var id = obj.attr("id");
	if(id==null){
		do{
			id = parseInt(Math.random()*1000000);
		}while($("#"+id).length!=0);
		obj.attr("id",id);
	}
}


