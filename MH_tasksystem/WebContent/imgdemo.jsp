<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>demo</title>
    <link rel="stylesheet" type="text/css" href="${root }/view/css/jquery.imagecropper.css" />
    <script type="text/javascript" src="${root }/view/js/ui.core.js"></script>
    <script type="text/javascript" src="${root }/view/js/ui.draggable.js"></script>
    <script type="text/javascript" src="${root }/view/js/jquery.imagecropper.js"></script>
    <script type="text/javascript">

        $(document).ready(function() {
            
        });
        
       	function loadJT(){
       		var imageCropper = $('#imgBackground').imageCropper({
                callbacks: {
                    dragging: updateStatus,
                    zoomed: updateStatus
                },
				//图片相对于截取框是否居中
				center: false,
				//截取框与图片的相对位置
				left: 0, top: 0,
				//截取框的大小
				width: 400, height: 400,
				//工作区大小
				cropWorkAreaSize: { width: 400, height: 800 },
				//截取框相对于工作区的位置
				cropFrameRect: { center: false, top: 200, left: 0 },
				//缩放范围
				zoom: { min: 0, max: 10, step: 0.1 }
            });
            updateStatus();

            $('#btnCropImage').click(function() {
                $('#imgCroppedImage').attr('src', root+'/image_cut/key/creatImage?p=' + imageCropper.settings.imagePath + '&z=' + imageCropper.settings.zoomLevel + '&y1=' + imageCropper.settings.top + '&x1=' + imageCropper.settings.left + '&w=' + imageCropper.settings.width + '&h=' + imageCropper.settings.height + '&' + Math.random());
                $('#imgCroppedImage').css('display', 'block');
            });

            $('#btnResetSettings').click(function() {
                imageCropper.settings.imagePath = $('#txtImgPath').val();
                imageCropper.settings.zoomLevel = parseFloat($('#txtZoomLevel').val());
                imageCropper.settings.left = parseInt($('#txtLeft').val());
                imageCropper.settings.top = parseInt($('#txtTop').val());
                imageCropper.settings.width = parseInt($('#txtWidth').val());
                imageCropper.settings.height = parseInt($('#txtHeight').val());
                imageCropper.reset();
            });

            function updateStatus() {
                $('#txtImgPath').val(imageCropper.settings.imagePath);
                $('#txtZoomLevel').val(imageCropper.settings.zoomLevel);
                $('#txtLeft').val(imageCropper.settings.left);
                $('#txtTop').val(imageCropper.settings.top);
                $('#txtWidth').val(imageCropper.settings.width);
                $('#txtHeight').val(imageCropper.settings.height);
            }
       	}
    </script>

</head>
<body>
    <div style="float: left;">
        <img id="imgBackground" src="${root }/view/images/cs.jpg" />
    </div>
    <div style="float: left; margin-left: 10px;">
        <div>
            <table>
                <tr>
                    <td>
                        image path:
                    </td>
                    <td>
                        <input type="text" value="" id="txtImgPath" />
                    </td>
                </tr>
                <tr>
                    <td>
                        zoom level:
                    </td>
                    <td>
                        <input type="text" value="" id="txtZoomLevel" />
                    </td>
                </tr>
                <tr>
                    <td>
                        left:
                    </td>
                    <td>
                        <input type="text" value="" id="txtLeft" />
                    </td>
                </tr>
                <tr>
                    <td>
                        top:
                    </td>
                    <td>
                        <input type="text" value="" id="txtTop" />
                    </td>
                </tr>
                <tr>
                    <td>
                        width:
                    </td>
                    <td>
                        <input type="text" value="" id="txtWidth" />
                    </td>
                </tr>
                <tr>
                    <td>
                        height:
                    </td>
                    <td>
                        <input type="text" value="" id="txtHeight" />
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <input type="button" onclick="loadJT()" value="Crop Image" id="" />
            <img id="imgCroppedImage" src="" style="display: none;" />
        </div>
    </div>
	<div style="clear:both"></div>
</body>
</html>
