$(function(){
	setLeftSel();//填充左侧人员
	setRightSel();//填充右侧人员
});
/*
 * 关闭窗口
 */
function closeWindow() {
	parent.closeIframeWindow();
}
/*
 * 填充左侧人员 
 */
function setLeftSel(){
	var url = root + "/role/key/getUnauthorizedUser?roleID="+roleID;
	var userJSON = getAJax(url);
	var table = $('#leftTable');
	var size = userJSON.userInfo.length;
	var obj;
	for(var i=0; i<size; i++){
		obj = userJSON.userInfo[i];
		table.append("<tr style='height:15px' id='"+obj.id+"ll'><td id='"+obj.id+"l' onclick='clickLeft("+'"'+obj.id+'l"'+");' style='background-color: white'>"+obj.name+"</td></tr>");
	}
}

/*
 * 填充右侧人员
 */
function setRightSel(){
	var url = root + "/role/key/getAuthorizedUser?roleID="+roleID;
	var userJSON = getAJax(url);
	var table = $('#rightTable');
	var size = userJSON.userInfo.length;
	var obj;
	for(var i=0; i<size; i++){
		obj = userJSON.userInfo[i];
		table.append("<tr style='height:15px' id='"+obj.id+"rr'><td id='"+obj.id+"r' onclick='clickRight("+'"'+obj.id+'r"'+");' style='background-color: white'>"+obj.name+"</td></tr>");
	}
}

/*
 * 获取同步AJAX
 */
function getAJax(url){
	var userObj;
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		success : function(json){
			userObj = eval('('+json+')');
		}
	});
	return userObj;
}

/*
 * 保存所授权的人员
 */
function saveAuthorizeUser(){
	var tableObj = $('#rightTable tr');
	var ids = new Array();
	for(var i=0,size=tableObj.size(); i<size; i++){
		var id = (tableObj.eq(i).find("td").eq(0))[0].id;
		ids.push(id.substr(0, id.length-1));
	}
	ids = ids.join(",");
	$.ajax({
		type : "POST",
		url : root + "/user_role/key/saveAuthorizeUser",
		data : "ids="+ids+"&roleID="+roleID,
		success : function(message){
			top.showMessage(message);
			closeWindow();
		}
	})
}

//-----左侧与右侧填充样式，以及基本功能，复制即可。-----
var huancunidL = null;//左侧缓存id
var huancunidR = null;//右侧缓存id
var huancuntext = null;//缓存HTML
var saveids = [];

//左侧点击选中
function clickLeft(tdid){
	if(huancunidR !=null){
		$("#"+huancunidR).css("background-color","white");
		huancunidR = null;
	}
	if(huancunidL !=null){
		$("#"+huancunidL).css("background-color","white");
	}
	$("#"+tdid).css("background-color","rgb(30,180,210)");
	huancunidL = tdid;
	huancuntext = $("#"+tdid).text();
}
//右侧点击选中
function clickRight(tdid){
	if(huancunidL !=null){
		$("#"+huancunidL).css("background-color","white");
		huancunidL = null;
	}
	if(huancunidR !=null){
		$("#"+huancunidR).css("background-color","white");
	}
	$("#"+tdid).css("background-color","rgb(30,180,210)");
	huancunidR = tdid;
	huancuntext = $("#"+tdid).text();
}
//添加按钮 左侧消失 右侧添加
function userLTR(){
	if(huancunidL !=null){
		$("#"+huancunidL).remove();
		$("#"+huancunidL+"l").remove();
		var l = huancunidL.substring(0,huancunidL.length-1);
		var ltrID = l+"r";
		$("#rightTable").append("<tr style='height:15px' id='"+ltrID+"r'><td id='"+ltrID+"' onclick='clickRight("+'"'+ltrID+'"'+");' style='background-color: white'>"+huancuntext+"</td></tr>");
		//alert(s.substring(0,s.length-1));
		//alert(s.substr(s.length-1));
		huancunidL = null;
	}else{
		alert("请先选择要添加的用户");
		return;
	}
}
//取消按钮 左侧添加 右侧消失
function userRTL(){
	if(huancunidR !=null){
		$("#"+huancunidR).remove();
		$("#"+huancunidR+"r").remove();
		var r = huancunidR.substring(0,huancunidR.length-1);
		var rtlID = r+"l";
		$("#leftTable").append("<tr style='height:15px' id='"+rtlID+"l'><td id='"+rtlID+"' onclick='clickLeft("+'"'+rtlID+'"'+");' style='background-color: white'>"+huancuntext+"</td></tr>");
		//alert(s.substring(0,s.length-1));
		//alert(s.substr(s.length-1));
		huancunidR = null;
	}else{
		alert("请先选择要取消的用户");
		return;
	}
}

//取消
function setRoleCancel(){
	huancunidL = null;//左侧缓存id
	huancunidR = null;//右侧缓存id
	huancuntext = null;//缓存html
	$("#leftTable").find("td").each(function(){
		var thisid = this.id;
		$("#"+thisid).remove();
	});
	$("#leftTable").find("tr").each(function(){
		var thisid = this.id;
		$("#"+thisid).remove();
	});
	$("#rightTable").find("td").each(function(){
		var thisid = this.id;
		$("#"+thisid).remove();
	});
	$("#rightTable").find("tr").each(function(){
		var thisid = this.id;
		$("#"+thisid).remove();
	});
	$('#setTaskRole').window('close');
}
//全部添加
function userLTRAll(){
	var hastd = $("#leftTable").find("td").is("td");
	if(!hastd){
		alert("已全部选中");
		return;
	}
	$("#leftTable").find("td").each(function(){
		this.onclick();
		userLTR();
	});
}
//全部取消
function userRTLAll(){
	var hastd = $("#rightTable").find("td").is("td");
	if(!hastd){
		alert("已全部取消");
		return;
	}
	$("#rightTable").find("td").each(function(){
		this.onclick();
		userRTL();
	});
}