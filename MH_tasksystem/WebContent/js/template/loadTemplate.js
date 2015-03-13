jQuery(document).ready(function($) {
	if (window.location.pathname.indexOf("/pagehtml/") >= 0 && window.location.pathname.indexOf(".html") > 0) {
		var url = $("#objectRoot").val() + "/page/key/searchByPageInfoExtraData?pageInfoExtraData.domain=" + window.location.pathname.substring(window.location.pathname.lastIndexOf("/") + 1);
		$.ajax({
			type : 'POST',
			cache : false,
			url : url,
			dataType : "text",
			success : function(data) {
				document.title = data;
			}
		});
	}
	$("img").lazyload({
		placeholder : "http://img.miletu.com/images/lazy-grey.gif",
		effect : "fadeIn"
	});
});
function loadJT(imgObj, imgId, imgWidth, imgHeight, mainHeight, imgTop, oldImg) {
	var imgidObj = $("#" + imgId);
	var imageCropper = imgidObj.imageCropper({
		// 图片相对于截取框是否居中
		center : false,
		// 截取框与图片的相对位置
		left : 0,
		top : 0,
		// 截取框的大小
		width : imgWidth,
		height : imgHeight,
		// 工作区大小
		cropWorkAreaSize : {
			width : imgWidth,
			height : mainHeight
		},
		// 截取框相对于工作区的位置
		cropFrameRect : {
			center : false,
			top : imgTop,
			left : 0
		},
		// 缩放范围
		zoom : {
			min : -2,
			max : 2.3,
			step : 0.1
		},
		oldImg : oldImg
	});

	$('#caijian_baocun', parent.frames['frame_left'].document).unbind("click");
	$('#caijian_baocun', parent.frames['frame_left'].document).click(function() {
		if (imageCropper.settings.initial) {
			parent.frames['frame_left'].caijian_baocun(imgObj,
							imageCropper.settings.imagePath,
							imageCropper.settings.zoom.max
									* imageCropper.settings.zoomLevel,
							imageCropper.settings.top,
							imageCropper.settings.left,
							imageCropper.settings.width,
							imageCropper.settings.height);
		} else {
			parent.frames['frame_left'].caijian_baocun(imgObj,
							imageCropper.settings.imagePath,
							imageCropper.settings.zoomLevel,
							imageCropper.settings.top,
							imageCropper.settings.left,
							imageCropper.settings.width,
							imageCropper.settings.height);
		}
	});
}
