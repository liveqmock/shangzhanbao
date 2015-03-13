<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="${root }/view/css/jquery.Jcrop.css" rel="stylesheet" />
    <script src="${root }/view/js/jquery/jquery.Jcrop.min.js"></script>
    <script src="${root }/view/js/jquery/imageCropperUpload.js"></script>
    <script>
        function checkImg () {

            var btn = $("#Button1");

            btn.cropperUpload({
                url: root +"/image_cut/key/creatImage",
                fileSuffixs: ["jpg", "png", "bmp"],
                errorText: "{0}",
                onComplete: function (msg) {
                    $("#testimg").attr("src", msg);
                },
                cropperParam: {//Jcrop参数设置，除onChange和onSelect不要使用，其他属性都可用
                    maxSize: [100, 100],//不要小于50，如maxSize:[40,24]
                    minSize: [70, 70],//不要小于50，如minSize:[40,24]
                    bgColor: "black",
                    bgOpacity: .4,
                    allowResize: false,
                    allowSelect: false,
                    animationDelay:50
                },
                perviewImageElementId: "fileList", //设置预览图片的元素id  
                perviewImgStyle: { border: '1px solid #ebebeb' }//设置预览图片的样式  
            });

            var upload = btn.data("uploadFileData");

            $("#files").click(function () {
                upload.submitUpload();
            });
        }
    </script>
</head>
<body>
    <div style="float:left">
    		<input type="button" value="加载..." onclick="checkImg()" />
            <input id="Button1" type="button" value="选择图片" />
            <input id="files" type="button" value="上传图片" />
            <div id="fileList" style="margin-top: 10px; padding-top:10px; border-top:1px solid #C0C0C0;font-size: 13px; ">  
            </div>  
    </div> 
    
    <div id="testdiv" style="">
        <img alt="" src="" id="testimg"/>
    </div> 
</body>
</html>