/**
 * 发布权限管理 js
 * @see
 * @author 林海鹏
 */

$(function(){
	/**
	 * 初始化读取 赠送天数
	 */
	window.onload = function() {
			$.ajax({
				type : 'POST',
				cache:false,
				url : root+"/give/key/changeTryDays",
				dataType : "text",
				success : function(data) {
				var someDiv = $('#trydays');
				someDiv.html(data);
				}
			});
		}
	
	//设置复选框,,全选 与 非选中状态
	$("#deuser").click(function() {
		if($(this).attr("checked")=="checked"){
			$('input[name="allcbx"]').attr("checked","true");
		}else{
			$('input[name="allcbx"]').removeAttr("checked");
		}
	});
	
	
	//时间模糊查询
	$('#buttonSearch').live("click",function(){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		
		if(startTime==""){
			alert("请输入开始时间")
			return;
		}
		if(endTime==""){
			alert("请输入结束时间")
			return;
		}
		window.location.href=root + "/user_info/key/statistics?startTime="+startTime+"&endTime="+endTime;
	});
	
	$('#change').live("click",function(){
		var div = $('#trydays'); 
		var button = $(this); 
		var txt = button.text(); 
		if(txt=='修改'){
			button.html("保存");
			var input = $("<input type='text' id='inputval' onkeyup='this.value=this.value.replace(/\D/g,'')' style='width:30px;' value='" + div.text() + "'/>"); 
			div.html(input);
		}else{
			var days = $("#inputval").val();
		
			 if (days.match(/\D/g,'')){
				    alert('只能输入数字！')
				     $("#inputval").focus();
				    return false;
				  }
			$.ajax({
				type : 'POST',
				cache: false,
				url : root+"/give/key/changefileContect?num="+days,
				dataType : "text",
				success : function(data) {
				div.html(data);
				button.html("修改");
			}
			});
		}
	});
});


	/**
	 * 发送暂存的赠送权限
	 */
	function sendData(num) {
		var createTime = $("#createTime"+num).val();
		var condition = $("#condition"+num).val();
		var creatorId = $("#creatorId"+num).val();
		var json = '{"createTime":"'+createTime+'","condition":"'+condition+'","creatorId":"'+creatorId+'"}';
		var url =root + "/give/key/sendGive?json="+encodeURIComponent(json);
		$.ajax({
			type : 'POST',
			cache: false,
			url : url,
			dataType : "text",
			success : function(data) {
			if(data=='success'){
				window.location.href=root + "/give/key/findGiveList";
			}
		}
		});
	};
	
	
	/**
	 * 删除暂存的赠送权限
	 */
	function deleteData(num) {
		var createTime = $("#createTime"+num).val();
		var condition = $("#condition"+num).val();
		var creatorId = $("#creatorId"+num).val();
		var json = '{"createTime":"'+createTime+'","condition":"'+condition+'","creatorId":"'+creatorId+'"}';
		var url =root + "/give/key/deleteGive?json="+encodeURIComponent(json);
		$.ajax({
			type : 'POST',
			cache: false,
			url : url,
			dataType : "text",
			success : function(data) {
			if(data=='success'){
				
				window.location.href=root + "/give/key/findGiveList?give=n";
			}
		}
		});
	};
	
	
	/**
	 * 查看消息
	 * @param message
	 * @return
	 */
	function findMessage(message,i){
		if(message==""){
			message="无消息内容！";
		}
		$("#messagediv"+i).html(message);
		$("#div"+i).fadeIn(1000);
	}

	
	
