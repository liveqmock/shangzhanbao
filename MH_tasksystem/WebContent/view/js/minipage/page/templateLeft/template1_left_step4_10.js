
//获取right页面
var mainframe = parent.frames['frame_main'].document;

//子页面跳转锚点
function gotoAnchor(url) {
	parent.frames['frame_main'].window.clickOpen(url);
}

function uploadPhoto(){
	$("input[name='uploadImg']").each(function(i){
		var componentid = "b664e9cc203e0a1642e05d60b055eb65";
		var name = "图片"+(i+1)+"配图";
		var type = "pc";
		var memo = "";
		selectPictrue($(this),"div8_image"+(i+1),5,componentid,name,type,memo)
	});
}

//判断选择的图片是否符合系统要求的方法
function selectPictrue(fileInput,imgid,size,componentid,name,type,memo){
	var filePath = fileInput.val();//获取选择文件路径
	var fileExt = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();//获取文件后缀名 
	if (!checkFileExt(fileExt)){//判断选择的文件是否为图片文件
		alert("您上传的文件不是图片,请重新选择！");  
		return false;  
	}
	if(size != 0){
		if (fileInput[0].files && fileInput[0].files[0]) { //谷歌浏览器判断文件大小
		var fileSize = toDecimal(fileInput[0].files[0].size/1024/1024);
          	if(fileSize > size){
          		alert('你选择的文件大小为' + fileSize + 'M，请选择小于'+size+'M的图片！');
			return false;
		}
      } else {//IE浏览器判断文件大小
          fileInput[0].select();
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
	imgupload(fileInput.attr("id"),imgid,"/file",componentid,name,type,memo);//调用上传图片的方法
}

function imgupload(uploadImg,imgid,filePath,componentid,name,type,memo){
	$.ajaxFileUpload({
		url:root+'/component_thumbnail/key/addComponentThumbnail?filePath='+filePath+'&componentid='+componentid+'&name='+name+'&type='+type+'&memo='+memo,//用于文件上传的服务器端请求地址
		secureuri:false,//一般设置为false
		fileElementId:uploadImg,//文件上传空间的id属性  <input type="file" id="file" name="file" />
		dataType: 'text',//返回值类型 一般设置为json
		success: function (data, status){//服务器成功响应处理函数
			mainframe.getElementById(imgid).src=root+filePath+"/"+data;
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

