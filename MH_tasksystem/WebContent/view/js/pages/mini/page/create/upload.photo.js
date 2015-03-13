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
	}
	function checkFileExt(ext){  
        if (!ext.match(/.jpg|.png/i)) {  
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