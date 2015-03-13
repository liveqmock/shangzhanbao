$(function() {
    //初始化隐藏保存按钮
	$("#addDiv").hide();
	
	/**
	 * 点击修改按钮事件
	 */
	$(".editClient").live(
			"click",
			function() {
				$("#lableLogin").html("");
				var loginMail = $("#inLogin").attr("value")
				$("#inLogin").before(
						"<input class='loginMail' type = 'text' value='"
								+ loginMail + "' name='userData.loginMail'/>");
				$("#lablePass").html("");
				var passWord = $("#inPass").attr("value");
				$("#inPass").before(
						"<input class='passWord' type = 'password' value='"
								+ passWord + "' name='userData.passWord'/>");
				$("#editDiv").hide();
				$("#addDiv").show();
			});
	
	/**
	 * 保存修改后的信息
	 */
	$(".addClient").live(
			"click",
			function() {
				var loginMail = $(".loginMail").val();
				var passWord = $(".passWord").val();
				var id = $("#userId").val();
				
				var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
				 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				 if (filter.test(loginMail) || teger.exec(loginMail)){
				 }else{
					 alert("输入的邮箱或手机号码格式不正确!");
					 return false;
				 }
				 var json = '{"mail":"'+ loginMail +'","id":"'+ id +'"}';
					var url = root + "/user/key/checkAccount";
					var data = "json=" + json;
					var flag = false;
					var num = getAsyncAjax(url, data);
					if(num > 0){
						alert("此账户已存在！")
						return;
					}
				// 定义url地址
				var url = root + "/client_manage/key/ajaxEditClient";
				$.ajax({
					type : 'POST',
					id : id,
					url : url,
					data : {
						loginmail : loginMail,
						password : passWord,
						id : id
					},
					dataType : "text",
					success : function(data) {
						if (data == "success") {
							alert("修改成功");
							window.location.href = root
									+ "/client_manage/key/searchClientById?userData.id="+id;
						} else if (data == "fail") {
							alert("修改失败");
						} else {
							alert("系统异常。请联系维护人员");
						}
					}
				});
			});
});

function createPage(){
	var id = $("#userId").val();
	var url = root+"/temp_manage/key/searchOpenTemp?templateData.esc=all&templateData.status=OPEN&userData.id="+id;
	window.open(url, "_blank"); 
}
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