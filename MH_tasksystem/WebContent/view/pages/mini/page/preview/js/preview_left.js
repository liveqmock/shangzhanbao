function toedit(id){
	top.location=root+"/page_manage/key/toedit?id="+id+"&pageName="+$("#pageName").val()+"&pageLink="+$("#pageLink").val()+"&pageData.status="+$("#status").val();
}

// 将form转为AJAX提交
function ajaxSubmit(frm, fn) {
    var dataPara = getFormJson(frm);
    $.ajax({
        url: frm.action,
        type: frm.method,
        data: dataPara,
        success: fn
    });
}

// 将form中的值转换为键值对。
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
 * 发布方法
 */
function fb(){
	$("[class=Btn_next]").each(function(){
		$(this).attr("disabled","disabled");
	});
	
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	
	$("#form").attr("target", "_top");
	if($("#pageName").val()==""){
		$("#form").attr("action", root + "/page_manage/key/updatePageData");
		$("#form").submit();
	} else {
		$("#form").attr("action", root + "/page_manage/key/createPageHtml");
		ajaxSubmit(document.getElementById("form"), function(data) {
			$("[class=Btn_next]").each(function(){
				$(this).removeAttr("disabled");
			});
			if(data!=""){
				var obj = eval('(' + data + ')'); 
				var addFbHtml1="";
				for(var i = 0; i < obj.length; i++){
					 addFbHtml1 =addFbHtml1+
						"<tr><td align='center'><input type='text' value='"+obj[i].name+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'></td>"+
						"<td align='center'><input type='text' value='"+obj[i].productConfig+"'	readonly='readonly' size='11'	style='background: transparent; border: none; text-align: center;'></td>"+
						"<td align='center'>"+
						"<span class='font_EN'>"+
						"<input id='' type='text' size='8' value='"+obj[i].price+"' readonly='readonly' style='background: transparent; border: none; text-align: center;'>"+
						"</span></td></tr>";
				}
				var addFbHtml = "<div >"+
					"<table border=\"0\" class=\"edit_publish_bug_div_table\">"+
					"<tr><td>"+
					"<font style=\"width: 550px;\">你选择了收费服务，它需要收费后才能使用</font>"+
					"</td></tr>"+
					"<table border=\"1\" cellspacing=\"0\" class='edit_publish_bug_div_table_in_table' >"+
					"<tr style=\"background-color: #aaaaaa;\">"+
					"<td align=\"center\">服务名称</td>"+
					"<td align=\"center\">规格</td>"+
					"<td align=\"center\">价格</td></tr>"+addFbHtml1+
					"</table>"+
					"<tr align='center'><input type='button' value='暂存，稍后付款' class='pb_buyProduct_Btn' onclick='toGuanLi()' >"+
					"<input type='button' value='去支付' id='' class='pb_buyProduct_Btn1'  onclick='turnPayForAction();'></tr></table></div>";
				window.parent.fabu(addFbHtml,'620','250');
			}else{
				var pageId=$("#id").val();
				var domain=$("#pagePath").val()+$("#pageLink").val();
				var pageName=$("#pageName").val();
				$.ajax({
					type : "POST",
					url : root + '/page_manage/key/sharePage',
					data : 'pageData.id=' + pageId,
					success : function(data1) {
						if(data1!=0){
							var imgUrl=data1.substring(0,data1.indexOf('&'));   //截取出二维码大图地址
							var img=root+imgUrl;   //大图完整路径
							var url1=root+"/page_manage/key/toWeixin?ImgUrl="+img+"&domain="+domain+"&pageName="+pageName;
							var addFbHtml = "<div style='width: 597px;height: 570px;'>" +
									"<div class='weixinDivTop'>手机分享，用微信扫一扫</div>" +
									"<div class='weixinDivTop_img'>" +
									"<img  src='"+img+"' >" +
								    "<p class='weixinDivTop_p '><a href='"+url1+"' target='_blank'>怎么分享？</a></p>" +
								    "</div>" +
								    "<div class='wexinDiv_hr'></div>" +
								    "<div class='weixininput'>" +
								    "<a   onclick=\"toGuanLi()\"  href='###'>进入管理页面</a>" +
								    "<a   " +
								    " href='"+$("#pagePath").val()+$("#pageLink").val()+"' target='_blank' >访问商站</a></div></div> <input type='hidden'  value='"+img+"'  class='imgUrl'>";
							window.parent.fabu(addFbHtml,'597','580');
						}else{
							return false;
						}
					}
				});
			}
		});
	}
}	
/**
 * 暂存方法
 */
function zc(){
	$("[class=Btn_next]").each(function(){
		$(this).attr("disabled","disabled");
	});
	$("[copy=copyComp]",parent.frames['frame_main'].document).each(function(){
		$(this).hide();
	});
	$("#status").val("0");
	$("#form").attr("action",root+"/page_manage/key/zancun");
	ajaxSubmit(document.getElementById("form"), function(data){
		window.parent.zancun();
		$("[class=Btn_next]").each(function(){
			$(this).removeAttr("disabled");
		});
	});
}
