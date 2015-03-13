$(function(){
	/* 修改密码 */
	$("#eidt").live('click',function(){
		$('#oldPword').attr('name','userData.userName');
		var url=root + "/user/key/ajaxEditPassWord";
		var form = $(this).closest('form');
		if(!$("#oldPword").val()){
			$(".error").html("当前密码不能为空！");
			$(".error").show();
			return;
		}
		if(!$("#onePass").val()){
			$(".error").html("新密码不能为空！");
			$(".error").show();
			return;
		}
		if(!$("#newPassword").val()){
			$(".error").html("请填写确认密码！");
			$(".error").show();
			return;
		}
		if(!($("#onePass").val()==$("#newPassword").val())){
			$(".error").html("两次填写的密码不一致！");
			$(".error").show();
			return;
		}
		$.ajax({
			type : 'POST',
			url : url,
			dataType : "text",
			data:$(this).closest('form').serialize(),
			success : function(data) {
				if(data=="success"){
					$("#showDiv").hide();
					$("#hideDiv").show();
						
					$(".error").html("");
					$(".error").hide();
					if(confirm('密码修改成功，将退出到首页重新登录？')){
						window.parent.location.href=root+"/j_spring_security_logout";
					}
				}else if(data=="-1"){
					$(".error").html("验证码输入错误！");
					$(".error").show();
					$(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
				}else if(data=="fail"){
					$(".error").html("输入的旧密码不正确");
					$(".error").show();
					$(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
				}else if(data=="unknows"){
					$(".error").html("产生未知错误，修改失败。请重新修改");
					$(".error").show();
				}else{
					$(".error").html("");
					$(".error").hide();
				}
			}
		});
	});
	
	$("[id^=edit]").each(function(){
		if(getNum($(this).attr("id"))!=null && getNum($(this).attr("id"))!=""){
			hiddenItem(getNum($(this).attr("id")));
		}
	});
});



/**
 * 
 * @param num
 * 要产生多少个随机数
 * @param from
 * 产生随机数的最小值
 * @param to
 * 产生随机数的最大值
 * 
 */
function createRandom(num ,from ,to ) {
	var arr=[];
	for(var i=from;i<=to;i++) {
		arr.push(i);
	}
	arr.sort(function(){
		return 0.5-Math.random();
	});
	arr.length=num;
	return arr;
}
//刷新验证码;
function changeCode(){
	$(".vari-code-img").attr("src",root+"/verification_code?"+new Date());
}
/**
 * 添加支付类型
 */
function addpaytype(){
	var listSize = parseInt($("#listSize").val())+1;

	var helpArticleCate = JSON.parse($("#helpArticleCate").val());
	var option="";
	for(var i=0; i< helpArticleCate.length; i++){
		option = option+"<option value=\""+helpArticleCate[i].key+"\">"+helpArticleCate[i].value+"</option>"
	}
	var html="<div class=\"paytypeDiv\" id=\"paytypeDiv"+listSize+"\">" +
			"<div><div style=\"float: left;color: red; font-size: 14px; \" id=\"errorHtml"+listSize+"\"></div>" +
			"<div><a href=\"###\" onclick='editPayType("+listSize+")' style=\"display:none;\" id='edit"+listSize+"'>"+
			"<img alt=\"编辑\" src=\" "+root+"/images/mini/images/u70_1.png\" ></a></div></div><div>"+
			"<input type=\"hidden\" id=\"accountNumberDataId"+listSize+"\" value=\"\">"+
			"<span class=\"zhifuspan\">收款方式：</span><span><select id=\"accountType"+listSize+"\" class=\"zhifuselect\">" +option +
			"</select><label  class=\"zhifulabel\" style=\"display:none\"></label></span></div>" +
			"<div><span class=\"zhifuspan\">收款账号：</span><span><input type=\"text\" id=\"receivableAccount"+listSize+"\" value=\"\" class=\"zhifuinput\">" +
			"<label class=\"zhifulabel\" style=\"display:none\"></label></span></div>" +
			"<div class=\"divbtn\" id=\"divbtn"+listSize+"\" style=\"height: 45px;padding-top: 5px;\">" +
			"<a href=\"###\" class=\"deletepay\" id='delete"+listSize+"' onclick='deletePayType(this)'>删除</a>"+
			"<a href=\"###\" id='complete"+listSize+"' onclick='complete("+listSize+")' class=\"addpay\">完成</a>" +
			"</div></div>";
	$(".paytypeDiv_add").before(html);
	$("#listSize").val(parseInt(listSize)+1);
}
/**
 * 支付方式编辑
 * @param con
 */
function editPayType(size){
	showItem(size);
}
/**
 * 把select  和input 显示  相应的label隐藏
 */
function showItem(size){
	$("#accountType"+size).show();
	$("#accountType"+size).next("label").hide();
	
	$("#receivableAccount"+size).show();
	$("#receivableAccount"+size).next("label").hide();
	//按钮显示
	$("#divbtn"+size).show();
	$("#edit"+size).hide();
}
/**
 * 把select  和input 隐藏起来  相应的label显示
 */
function hiddenItem(size){
	$("#accountType"+size).hide();
	$("#accountType"+size).next("label").html($("#accountType"+size).find("option:selected").text());
	$("#accountType"+size).next("label").show();
	
	$("#receivableAccount"+size).hide();
	$("#receivableAccount"+size).next("label").html($("#receivableAccount"+size).val());
	$("#receivableAccount"+size).next("label").show();
	
	$("#divbtn"+size).hide();
	$("#edit"+size).show();
}
/**
 * 点击收款账号完成按钮
 */
function complete(size){
	//获取收款账号
	var receivableAccount = $("#receivableAccount"+size).val();
	//获取收款账号id
	var accountNumberDataId = $("#accountNumberDataId"+size).val();
	//获取账号类型
	var accountType = $("#accountType"+size).val();
	//获取用户id
	var userId = $("#userId"+size).val();
	
	if(receivableAccount == "") {
		$("#errorHtml"+size).text("*收款账号不能为空！")
		return;
	}
	
	var url;
	//通过收款账号id判断是添加还是修改
	if(accountNumberDataId==""){
		url=root+"/account_number/key/addAccountNumberData?accountNumberData.receivableAccount="+receivableAccount+"&accountNumberData.accountType="+accountType;//添加
	} else {
		url=root+"/account_number/key/editAccountNumberData?accountNumberData.userId="+userId+"&accountNumberData.id="+accountNumberDataId+"&accountNumberData.receivableAccount="+receivableAccount+"&accountNumberData.accountType="+accountType;//修改
	}
	
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			  if(data!="1"){
			var evalObj = eval("("+data+")");
			$("#accountType"+size).val(evalObj.accountType);
			$("#accountNumberDataId"+size).val(evalObj.id);
			$("#receivableAccount"+size).val(evalObj.receivableAccount);
			$("#errorHtml"+size).text("");
			hiddenItem(size);
			  }else{
				  alert("当前支付方式已存在！")
			  }
		}
	});
	
}

/**
 * 获取字符串中的数字
 * @param text
 * @returns
 */
function getNum(text){
	var value = text.replace(/[^0-9]/ig,""); 
	return value;
}

/**
 * 支付方式删除
 * @param con
 * @returns
 */
function deletePayType(con){
	var id=$(con).attr("id");
	var size = getNum(id);
	//获取收款账号id
	var accountNumberDataId = $("#accountNumberDataId"+size).val();
	if(accountNumberDataId!=""){
		var url = url=root+"/account_number/key/deleteAccountNumberData?accountNumberData.id="+accountNumberDataId;
		$.ajax({
			type : 'POST',
			url : url,
			dataType : "text",
			success : function(data) {
				$("#"+id).parent("div").parent("div").remove();
			}
		});
	} else {
		$("#"+id).parent("div").parent("div").remove();
	}
}