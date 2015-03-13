
/**
 * 用户配置管理 列表页面 js
 * @author hy
 */
$(function(){

	
	$(".edit").click(function(){
	    var t_this = $(this);
	   var list=$(t_this).parent().parent().find("td:lt(3)");
	   $.each(list,function(i,obj){
		   if(i!=0){
		  if(i==1){
	      $(obj).html("<input type='text'  style='width: 180px;height: 25px;text-align: center;' value='"+$(obj).text()+"' name='userData.loginMail' email='邮箱格式不正确!'/> ");
		  }
		  if(i==2){
		      $(obj).html("<input type='text'  style='width: 180px;height: 25px;text-align: center;' value='"+$(obj).text()+"' name='userData.userName' min='6' notnum='不能是纯数字!'/>");
			
			  }
		 
		   }
	   });
	   var num = $(this).attr("data");
	   $(this).closest("tr").find(".newId").attr("id","id_"+num);
	  $(this).closest("tr").find("#save_"+num).removeClass('edits');
	  $(this).closest("tr").find("#update_"+num).addClass('edits');
	 
	});
	
});

/*
 * 保存修改信息
 */
function saveEditUser(num){
	var userid=$("#id_"+num).val();
	//查找input
	var mailTD = $("#mail_"+num);
	var nameTD = $("#name_"+num);
	//span
	var mailsp = $("#spmail_"+num);
	var namesp = $("#spname"+num);
	//a标签
	var update_a = $("#update_"+num);
	var save_a = $("#save_"+num);
	//判断邮箱
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	var mailval = mailTD.find("input").val();
	var nameval = nameTD.find("input").val();
	var json = '{"mail":"'+ mailval +'","id":"'+ userid +'"}';
		var url = root + "/user/key/checkAccount";
		var data = "json=" + json;
		var flag = false;
		var num = getAsyncAjax(url, data);
		if(num > 0){
			alert("此账户已存在！")
			return;
		}
				
	
		if(mailval!="" && nameval!=""){
		    if(filter.test(mailval)){
				$.ajax( {
					type : "POST",
					url : root + '/user/key/editUsers',
					data : "id="+userid+"&loginMail="+mailval+"&userName="+nameval,
					success : function(id) {
						mailTD.find("input").hide();
						mailTD.html("<span>"+mailval+"</span>");
						nameTD.find("input").hide();
						nameTD.html("<span>"+nameval+"</span>");
					
						update_a.removeClass('edits');
						save_a.addClass('edits');
						 
					}
				});
				return true;
		    }{
		    	alert("邮箱格式不正确!");
		    	 return false;
		    }
	}else{
		alert("账号或者姓名不能为空");
	}
/*}	*/
};


/*
 * 修改用户--验证账户是否已存在
 */
function checkAccount_update(){
	var json = '{"mail":"'+ $('#mail').val() 
			+'","id":"'+ $("#userid").val() +'","mobile":"'+$("#mobile").val()+'"}';
	var url = root + "/user/key/checkAccount";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num > 0){
		flag = true;
	}
	return flag;
}
/*
 * 获取同步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		dataType : "text",
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}
/*是否重置密码*/
function updatePwd(id){
	/*var pwdDiv = $("#pwdDiv");
	pwdDiv.show();*/
	new bombBox('sendEmailDiv', 'sendEmailDiv', {
		title : '提示',
		content : "<div class='editpage_zancun_div'>重置密码后，会发送邮件给客户重新设置密码，客户原密码将不能使用，是否确认重置密码？。</div><div class='editpage_zancun_div_in_div'><button class='editpage_zancun_div_in_div_calBtn'>取消</button><input type='button' class='editpage_zancun_div_in_div_sureBtn' onclick='sendmail(\""+id+"\")' value='确认' /></div>",
		width : '480',
		height : '200',
		top : '',
		left : '',
		fixed : 'fixed',
		close : 'close'
	});
	$("#sendEmailDiv").click();
	
}
function  closedDiv(){
	 $("#pwdDiv").hide();
}
/**/
function divhide(id){
 if(confirm('确定要对选定的数据进行操作吗？')){
	 $.ajax( {
			type : "POST",
			url : root + '/user/key/email',
			data : "userData.id="+id,
			success : function(id) {
				 alert("发送成功")
				 var pwdDiv = $("#pwdDiv");
					pwdDiv.hide();
			}
		});
	 
 }
}
function sendmail(id){
	var url = root + "/client_manage/key/clientManageResertPassword?userData.id="+id;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			if(data=='1'){
				$("#sendEmailDiv").remove();
				alert("邮件发送成功");
			}else if(data=='0'){
				$("#sendEmailDiv").remove();
				alert("邮件发送失败");
			}else if(data=='2'){
				$("#sendEmailDiv").remove();
				alert("此用户未注册邮箱号");
			}
		}
	});
	
}
