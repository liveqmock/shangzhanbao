var jcrop_api, boundx, boundy, xsize, ysize,uploadData,imgWidth,imgHeight;
var initDemo = function(obj) {
	xsize = obj.parent().width(), ysize = obj.parent().height();
	console.log('init', [ xsize, ysize ]);
	$('#target').Jcrop({
		allowSelect : false,
		onChange : updatePreview,
		onSelect : updatePreview,
		setSelect : [ 0, 0, xsize, ysize ],
		aspectRatio : xsize / ysize,
		boxWidth : 500,
		boxHeight : 400
	}, function() {
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		jcrop_api = this;
	});
	function updatePreview(c) {
		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;
			
			var le;
			if(imgWidth/500>imgHeight/400){
				le=imgWidth/500;
			}else{
				le=imgHeight/400;
			}
			if(le<1){
				le=1;
			}
			
			uploadData = {
				top : parseInt(Math.round(c.x)*le),
				left : parseInt(Math.round(c.y)*le),
				width : parseInt(Math.round(c.w)*le),
				height : parseInt(Math.round(c.h)*le),
				cut : true
			};
		}
	}
	;
};

/**
 * 从 file 域获取 本地图片 url
 */
function getFileUrl(sourceId) {
	var url;
//	if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
//		url = document.getElementById(sourceId).value;
//	} else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
//		url = window.URL
//				.createObjectURL(document.getElementById(sourceId).files
//						.item(0));
//	} else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
		url = window.URL
				.createObjectURL(document.getElementById(sourceId).files
						.item(0));
//	}
	return url;
}

/**
 * 将本地图片 显示到浏览器上
 */
function preImg(sourceId, targetId, imgId) {
	var url = getFileUrl(sourceId);
	var imgPre = document.getElementById(targetId);
	imgPre.src = url;

	var newImg = new Image(); // 新建一个图片对象
	
	$(newImg).attr("src" , url); // 将图片的src属性赋值给新建图片对象的src
	
	newImg.onload = function() {
		imgWidth = newImg.width;
		imgHeight = newImg.height;
		if(imgWidth > 500 || imgHeight > 400){
			if(imgWidth/500 > imgHeight/400){
				$("#"+targetId).css({
					width : '500px',
					height : parseInt(imgHeight/(imgWidth/500))+'px'
				});
			} else {
				$("#"+targetId).css({
					width : parseInt(imgWidth/(imgHeight/400))+'px',
					height : '400px'
				});
			}
		}
		if (jcrop_api == undefined || jcrop_api == "" || jcrop_api == null) {
			initDemo($("#" + imgId));
		} else {
			jcrop_api.setImage(url);
			jcrop_api.setOptions({
				setSelect : [ 0, 0, xsize, ysize ],
				aspectRatio : xsize / ysize
			});
		}
	}
	$("#viewfile").val($("#" + sourceId).val());
}


function cutBox(clickid,obj) {
	var msg = "<div id=\"uploadDivBox\"><div class=\"uploadImg\">"
			+ "<div class=\"upload_div\" style=\"padding-bottom: 5;\"><div class=\"line\">"
			+ "<span class=\"span\"> <input name=\"\" type=\"text\" id=\"viewfile\" class=\"inputstyle\" /></span>"
			+ "<label for=\"unload\" class=\"file_btn\">浏览</label>"
			+ "<input type=\"file\" onchange=\"preImg(this.id,'target','"
			+ obj
			+ "')\" accept=\"image/jpeg,image/png\" class=\"file\" name=\"uploadImg\" id=\"imgOne\" />"
			+ "</div></div><div id=\"imageDiv\">"
			+ "<p><img src=\"\" id=\"target\" /></p></div></div></div>"
			+ "<div class=\"btn_div\">"
			+ "<input type=\"button\" onclick=\"noCut('"
			+ obj
			+ "')\" class=\"upload_btn_nocut\" value=\"上传\" />"
			+ "<input type=\"button\" onclick=\"uploadImg('"
			+ obj
			+ "')\" class=\"upload_btn_ok\" value=\"截图\" />"
			+ "<input type=\"button\" onclick=\"closeUploadBox()\" class=\"upload_btn_cancel\" value=\"取消\" />"
			+ "</div>";

	new bombBox('' + clickid, 'uploadImgBox', {
		title : '上传图片',
		content : msg,
		width : '600',
		height : '560',
		top : '',
		left : '',
		fixed : '',
		close : ''
	});
}

/**
 * 点击取消按钮，关闭上传图片弹框
 */
function closeUploadBox() {
	$("#uploadImgBox").remove();
	jcrop_api = null;
}

/**
 * 点击上传按钮
 */
function uploadImg(imgId) {
	selectPictrue($("#imgOne"), 5, imgId, uploadData);
}

/**
 * 点击无需裁剪直接上传按钮
 */
function noCut(imgId) {
	uploadData = {
		cut : false
	};
	selectPictrue($("#imgOne"), 5, imgId, uploadData);
}

/**
 * 判断选择的图片是否符合系统要求的方法
 * 
 * @param fileInput
 *            上传文件对象
 * @param size
 *            上传文件限制的大小
 * @param filePath
 *            上传到服务器的路径
 * @param imgId
 *            如果是图片，更换图片的id
 * @param data
 *            和上传文件同时提交的数据,格式{name : 'name1',age : 'age1'}
 */
function selectPictrue(fileInput, size, imgId, data) {
	var filePath = fileInput.val();// 获取选择文件路径
	var fileExt = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();// 获取文件后缀名
	if (!checkFileImg(fileExt)) {// 判断选择的文件是否为图片文件
		alert("您上传的文件不是图片,请重新选择！");
		return;
	}
	if (size != 0) {
		if (fileInput[0].files && fileInput[0].files[0]) { // 谷歌浏览器判断文件大小
			var fileSize = toDecimal(fileInput[0].files[0].size / 1024 / 1024);
			if (fileSize > size) {
				alert('你选择的文件大小为' + fileSize + 'M，请选择小于' + size + 'M的图片！');
				return;
			}
		} else {// IE浏览器判断文件大小
			fileInput[0].select();
			var url = document.selection.createRange().text;
			try {
				var fso = new ActiveXObject("Scripting.FileSystemObject");
			} catch (e) {
				alert('如果你用的是ie 请将安全级别调低！');
				return;
			}
			var fileSize = toDecimal(fso.GetFile(url).size / 1024 / 1024);
			if (fileSize > size) {
				alert('你选择的文件大小为' + fileSize + 'M，请选择小于' + size + 'M的图片！');
				return;
			}
		}
	}
	imgupload(fileInput.attr("id"), imgId, data);// 调用上传图片的方法
}
/**
 * 上传文件的方法
 * 
 * @param uploadImg
 *            需要上传的文件控件的id
 * @param filePath
 *            上传到服务器的路径
 * @param imgId
 *            如果是图片，更换图片的id
 * @param data
 *            需要和上传一起提交的数据
 */
function imgupload(uploadImg, imgId, data) {
	$.ajaxFileUpload({
		url : '/upload_img/key/uploadImage',// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : uploadImg,// 文件上传空间的id属性 <input type="file" id="file"
									// name="file" />
		dataType : 'text',// 返回值类型 一般设置为json
		data : data,// 上传的其他数据
		async : false,
		success : function(dataimg, status) {// 服务器成功响应处理函数
			if (dataimg == "1") {
				alert("图片上传失败，请重新选择图片上传！");
			} else {
				  //购买图片入库
				if(imgId=="goodsImg"){
						var  url=indexRoot+"/goods_info/key/addGoodsInfo";
						//获取页面pageid
						var pageId = $("#id", parent.frames['frame_left'].document).val();
					  $.ajax({
							type:"POST",
							object:$(this),
							url:url,
							data:"pageGoodsInfoData.pageId="+pageId+"&goodsInfoData.id="+$("#goodsInfoDataId").val()+"&goodsInfoData.goodsImg="+dataimg,
							dataType : 'text',// 返回值类型 一般设置为json
							success : function(data) {
								 if(data!="1"){
									 var json=eval("(" + data + ")");
									 $("#goodsInfoDataId").val(json.goodsInfoId);  //商品id
										$("#" + imgId).attr("src", dataimg);
										closeUploadBox();
								}
							}
						})
				}else{
					if(imgId=="banner_img"){
						$("#pageImg", parent.frames['frame_left'].document).val(dataimg);
						$("#pageImg", parent.frames['frame_top'].document).val(dataimg);
					}
					$("#" + imgId).attr("src", dataimg);
					closeUploadBox();
				}
			}
		},
		error : function(dataimg, status) {
			alert("图片上传失败，请重新选择图片上传！");
		}
	});
}

/**
 * 判断上传的文件是否为图片
 * 
 * @param imgName
 *            文件名
 * @returns 是否为图片
 */
function checkFileImg(imgName) {
	if (!imgName.match(/.jpg|.png|.jpeg/i)) {
		return false;
	}
	return true;
}
/**
 * 保留两位小数 功能：将浮点数四舍五入，取小数点后2位
 * 
 * @param x
 *            需要保留两位小数的数
 * @returns 保留两位小数后的数
 */
function toDecimal(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return;
	}
	f = Math.round(x * 100) / 100;
	return f;
}