//判断选择的图片是否符合系统要求的方法
function selectPictrue(fileInput,size){
	var filePath = fileInput.value;//获取选择文件路径
	var fileExt = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();//获取文件后缀名 
	if (!checkFileExt(fileExt)){//判断选择的文件是否为图片文件
		alert("您上传的文件不是图片,请重新选择！");  
		return false;  
	}
	if(size != 0){
		if (fileInput.files && fileInput.files[0]) { //谷歌浏览器判断文件大小
		var fileSize = toDecimal(fileInput.files[0].size/1024/1024);
            	if(fileSize > size){
            		alert('你选择的文件大小为' + fileSize + 'M，请选择小于'+size+'M的图片！');
			return false;
		}
        } else {//IE浏览器判断文件大小
            fileInput.select();  
            var url = document.selection.createRange().text;  
            try {  
                var fso = new ActiveXObject("Scripting.FileSystemObject");  
            } catch (e) {  
                alert('如果你用的是ie 请将安全级别调低！');  
            }  
            var fileSize = toDecimal(fso.GetFile(url).size/1024/1024);
            if(fileSize > size){
            	alert('你选择的文件大小为' + fileSize + 'M，请选择小于'+size+'M的图片！');
				return false;
			}
        }
	}
	document.getElementById("filePath").value = fileInput.value;
	imgupload(fileInput.id,"/file");//调用上传图片的方法
	}

	function imgupload(uploadImg,filePath){
		$.ajaxFileUpload({
			url:root+'/page_template_info/key/uploadPhoto?filePath='+filePath,//用于文件上传的服务器端请求地址
			secureuri:false,//一般设置为false
			fileElementId:uploadImg,//文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType: 'text',//返回值类型 一般设置为json
			success: function (data, status){//服务器成功响应处理函数
				iframeinfo.getElementById("logoImage").src=root+filePath+"/"+data;
			}
		});
	}
	function checkFileExt(ext){  
        if (!ext.match(/.jpg|.gif|.png|.bmp/i)) {  
            return false;  
        }  
        return true;  
    }
	//保留两位小数   
    //功能：将浮点数四舍五入，取小数点后2位  
    function toDecimal(x) {  
    	var f = parseFloat(x);  
    	if (isNaN(f)) {  
			return;  
    	}  
		f = Math.round(x*100)/100;  
		return f;  
	}
	//没有图片时设置logo
	function selectLogo(){
		alert("点击没有logo事件")
	}