/**
 * ajax提交表单
 */
function ajaxSubmit(frm, fn) {
    var dataPara = getFormJson(frm);
    $.ajax({
        url: frm.action,
        type: frm.method,
        dataType: "text", 
        data: dataPara,
        success: fn
    });
}

/**
 * 将form中的值转换为键值对
 */
function getFormJson(frm) {
    var o = {};
    var a = $(frm).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
}

/**
 * main页面锚点跳转的方法，同时添加border边框
 * 
 * @param divid
 *            需要跳转到的div的id;
 */
function jumpAnchor(divid) {
	// 跳转锚点
	var scroll = $("#" + divid, parent.frames['frame_main'].document);
	var scroll_offset = scroll.offset();
	$("body,html", parent.frames['frame_main'].document).animate({
		scrollTop : scroll_offset.top - 400
	}, 1000);
	if($(divid).attr("type") == "file" && $("#" + divid, parent.frames['frame_main'].document).text()==""){
		$("#" + divid, parent.frames['frame_main'].document).css("height", "20px");
	}
	// 添加border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "2px solid red")
	.css("background","#FC9")
	.css("-moz-border-radius","15px")
	.css("-webkit-border-radius","15px")
	.css("border-radius","15px");
	 if($("#"+divid).attr("type")!="file"){
		 if($("#step_" + divid).val()=="建议只用一句话" || $("#step_" + divid).val().indexOf("优势")>=0){
			 //清空内容
			 $("#step_" + divid).val('');
		 }
	 }
}

/**
 * 失去焦点时触发的事件
 * 
 * @param info
 *            失去焦点的控件对象
 */
function losesFocus(info) {
	var infoid = $(info).attr("id");
	//获取该对象控制的main页面对应对象id
	var divid = infoid.replace("step_","");
	// 清除border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "")
	.css("height","")
	.css("background","")
	.css("-moz-border-radius","")
	.css("-webkit-border-radius","")
	.css("border-radius","");
	if($(info).val()==""){
		$(info).val($(info).attr("oldval")+"");
		$(info).val("");
		return;
	}
	//把修改的信息添加到main页面中
	$("#" + divid, parent.frames['frame_main'].document).html($(info).val().replace(/\n|\r|(\r\n)|(\u0085)|(\u2028)|(\u2029)/g, "<br/>"));
	
}

/**
 * 禁用按钮
 */
function disableButton(){
	$(".Btn_next").attr("disabled","disabled");
	$(".Btn_tiao").attr("disabled","disabled");
	$(".Btn_buy").attr("disabled","disabled");
	$(".Btn_buys").attr("disabled","disabled");
}

/**
 * 把页面数据存入数据库
 */
function saveInfo(num){
	disableButton();
	$(".up_update", parent.frames['frame_main'].document).remove();// 移除上移虚线边框
	$(".down_update", parent.frames['frame_main'].document).remove();// 移除下移虚线边框
	$(".del_update", parent.frames['frame_main'].document).remove();// 移除删除虚线边框
	$(".createCoverPlate", parent.frames['frame_main'].document).remove();// 移除所有蒙板
	$(".showline_Img", parent.frames['frame_main'].document).remove();// 移除虚线边框和按钮
	$(".showline_banner", parent.frames['frame_main'].document).remove();
	$("div[class^='line_'],div[class*=' line_']",parent.frames['frame_main'].document).css({border : '0px'});
	$(".update",parent.frames['frame_main'].document).css({border : '0px'});
	//获取main页面所有html代码
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#userID").val(parent.document.getElementById("userId_1").value)
	$("#content").val(htmlinfo);
	ajaxSubmit(document.getElementById("sellForm"), function(data){
		top.location.href = root + "/page_manage/key/toCreatePage?id="+$("#templateid").val()
		+"&userData.id="+$("#userID").val()+"&step=2&pageid="+data;
	});
	
}


