/**
\ * 图片上传
 * @author wendong
 */
$.fn.extend({
	uplaodImg:function(){
		$(this).click(function(){
			var iframe = $("iframe.imgUploadFrame");
			if(iframe.length==0){
				iframe = $("<iframe class='imgUploadFrame' name='imgUploadFrame' id='imgUploadFrame' style='display:none'></iframe>").appendTo($(document.body));
			}
			var form = $("form.imgUploadForm");
			if(form.length==0){
				form = $("<form target='imgUploadFrame' class='imgUploadForm' action='"+root+"/upload_img/key/toTemp' method='post' enctype='multipart/form-data' style='display:none;'></form>").appendTo($(document.body));
			}
			form.empty();
			var file = cloeset($(this),"input[type=file]");
			if(file==null|| file.val()==""){
				alert("请选择图片！");
				return;
			}
			if(!file.val().match(/.jpg|.gif|.png|.bmp/i)){
                alert('图片类型必须是: .jpg, .gif, .bmp, .png !');
                return;
			}
			file.after(file.clone());//copy一个上传控件
			file.appendTo(form);
			form.submit();
			file.remove();
		});	
	}
});

function callback(flag,url){
	var erro=$("#upload").closest("tr").find(".imgurl:first").val();
	if(erro == "error.jpg"){
		$("#upload").closest("tr").find(".imgurl:first").closest('div').remove();
	}
	$("#upload").before("<div><img style='float:left;height:60px;width:60px;margin:5px 0 5px 5px;' class='delImg' title='点击撤除' src='"+root+"/down_img?img_temp/"+url+"'/><input type='hidden' class='imgurl' value='"+url+"'/></div>");//上传成功后在div中显示出预览图
}

$(".delImg").live("click",function(){
	$(this).closest('div').remove();//点击撤除图片后撤除放置图片的DIV
});

function cloeset(obj,selector){
	var result;
	while(!obj.is("body")){
		result = obj.find(selector);
		if(result.length!=0){
			return result;
		}
		obj = obj.parent();
	}
	return null;
}