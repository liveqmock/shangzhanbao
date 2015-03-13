

var num = 1;

//获取right页面
var mainframe = parent.frames['frame_main'].document;

function addCase(){
	$("#caselj"+num).blur();
	num = num + 1;
	var addcase="<p><strong>案例"
		+num+"</strong></p><label> <input type=\"file\" name=\"uploadImg\" onblur='gotoAnchor('div9_image"
		+num+"')\" accept=\"image/jpeg,image/png,image/gif\" id=\"casephoto"
		+num+"\" /></label><div style=\"margin-top: 10px\"><a href=\"javascript:selectPictrue($('#casephoto"
		+num+"'),'div9_image"+num+"',5)\" class=\"Btn_Upload\">上传</a></div><div style=\"margin: 10px 0 0 0; float: left\"><p>案例"
		+num+"链接：</p><input type=\"text\" id=\"caselj"+num+<%--  --%><%--  --%>"\" onblur=\"getSlogan(this,'href"+num+"')\"  class=\"input_bg\" value=\"http://www.\" style=\"width: 205px\"></div>";
	$("#case").append(addcase);
	var mycase= mainframe.getElementById("case");
	$(mycase).append("<a name='div9_image"+num+"'><div class='one_two'><a  id='href"+num+"' href='http://www.google.com.hk'><img id='div9_image"+num+"' src='images/images_logo1.jpg'></a></div></a>");
}

//给标语和卖点辅值
function getSlogan(info,divid){
	var slogan = mainframe.getElementById(divid);
	if(check($(info).val())){
		$(slogan).attr("href",$(info).val());
	}else if ($(info).val() == "http://www."){
		$(slogan).attr("href","#");
	}else {
		alert("请输入合法的网址!")
	}
}

//子页面跳转锚点
function gotoAnchor(url) {
	parent.frames['frame_main'].window.clickOpen(url);
}

//提交数据
function getsubmit(){
		//拼接json字符串
	var dataJson = "[{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第一个理由','content':'" + $("#reason1").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第二个理由','content':'" + $("#reason2").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第三个理由','content':'" + $("#reason3").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'},"
		+ "{'componentid':'b664e9cc203e0a1642e05d60b055eb65','name':'第四个理由','content':'" + $("#reason4").val() 
		+ "','taxis':'1','pageTemplateid':'40288104444ec71001444ec916dd0001','version':'1'}]";
	ajaxUtil(url + "?dataJson=" + encodeURIComponent(dataJson), null,function msg(request, status, error) {
		window.location.href=root+"/view/pages/mini/page/templateLeft/template1_left_step3.jsp";
	},function errorMsg(request, status, error){
		alert("添加信息失败，请重试！");
	});
}

//ajax访问后台
function ajaxUtil(url,data,backMethod,errorMethod){
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : url, //与此php页面沟通 
		dataType:'json',//从php返回的值以 JSON方式 解释 
		data: data, //发给后台的数据有两项Json串
		success: backMethod,
		error:errorMethod
	});
}

//判断选择的图片是否符合系统要求的方法
function selectPictrue(fileInput,imgid,size){
	var filePath = fileInput.val();//获取选择文件路径
	var fileExt = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();//获取文件后缀名 
	if (!checkFileExt(fileExt)){//判断选择的文件是否为图片文件
		alert("您上传的文件不是图片,请重新选择！");  
		return;  
	}
	if(size != 0){
		if (fileInput[0].files && fileInput[0].files[0]) { //谷歌浏览器判断文件大小
		var fileSize = toDecimal(fileInput[0].files[0].size/1024/1024);
          	if(fileSize > size){
          		alert('你选择的文件大小为' + fileSize + 'M，请选择小于'+size+'M的图片！');
			return;
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
				return;
			}
      }
	}
	imgupload(fileInput.attr("id"),imgid,"/file");//调用上传图片的方法
}

function imgupload(uploadImg,imgid,filePath){
	var componentid = "b664e9cc203e0a1642e05d60b055eb65";
	var name = "客服案例"+num+"配图";
	var type = "pc";
	var memo = "";
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

//判断网址是否合法
function check(str_url){ 
	var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        var re=new RegExp(strRegex);
        //re.test()
        if (re.test(str_url)){
            return (true);
        }else{
            return (false);
        }
}

