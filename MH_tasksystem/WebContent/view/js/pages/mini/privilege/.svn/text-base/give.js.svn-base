/**
 * 赠送权限js
 * @see
 * @author 林海鹏
 */

$(function(){
	//设置复选框,,全选 与 非选中状态
	$("#deuser").click(function() {
		if($(this).attr("checked")=="checked"){
			$('input[name="allcbx"]').attr("checked","true");
			var checked = $("input[name='allcbx']:checked");//判断复选框是否选中
			$("#countUserNum").html(checked.length);// 控制已选择几个客户 
		}else{
			$('input[name="allcbx"]').removeAttr("checked");
			$("#countUserNum").html(0);//控制已选择几个客户 
		}
	});
});
/**
 * 已选择几个客户
 * @return
 */
function countUser(){
	var checked = $("input[name='allcbx']:checked");//判断复选框是否选中
	$("#countUserNum").html(checked.length);//控制已选择几个客户 
}


/**
 * 获取用户查询信息列表
 * @return
 */
function findByConditions(){
	var form = $("#giveUserinfo");
	form.action= root+'/give/key/givePrivilege';
	form.submit();
}




/**
 * 暂存或  确认赠送
 * @param ifgive
 * @return
 */
function savePrivilege(ifgive){
	var checked = $("input[name='allcbx']:checked");//判断复选框是否选中
	var ids = new Array();
	for ( var i = 0; i < checked.length; i++) {
		ids.push(checked[i].value);
	}
	ids=ids.join(",")
	if(checked.length==0){
		alert("至少选择一条记录!");
		return;
	}
	var giveNum = $("#giveNumval").val()
	if(""==giveNum){
		alert("请输入赠送个数!");
		return;
	}

	var messages = $("#message").val();
	var form = $("#giveUserinfo").serialize();
	var json = '{"ifgive":"'+ifgive+'","messages":"'+messages+'","giveNum":"'+giveNum+'"}';
	var param =encodeURIComponent(json);
	var url=root + "/give/key/addGivePrivilege?json="+param+"&ids="+ids;
	$.ajax({
		type : 'POST',
		cache: false,
		url : url,
		data : form,
		dataType : "text",
		success : function(data) {
			if(data=='success'){
				if(ifgive=='2'){
					window.location.href=root + "/give/key/findGiveList?give=2";
				}else{
					window.location.href=root + "/give/key/findGiveList";
				}
			}
		}
	});
}