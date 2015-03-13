//客户案例、图文集合和图片集合使用，用来计算组件个数（点击添加更多时使用）
var componentNum = 1;
//客户案例、图文集合和图片集合使用，用来获取主页面组件信息（点击添加更多时使用）
var componentRight = "";
//客户案例、图文集合和图片集合使用，用来获取页面左侧组件信息（点击添加更多时使用）
var componentLeft = "";

/**
 * main页面锚点跳转的方法，
 * 
 * @param divId
 *            需要跳转到的div的id;
 */
function jumpAnchor(info) {
	var infoid = $(info).attr("id");
	//获取该对象控制的main页面对应对象id
	var divid = infoid.replace("step_","");
	var scroll_offset = $("#" + divid, parent.frames['frame_main'].document).offset();
	$("body,html", parent.frames['frame_main'].document).animate({
		scrollTop : scroll_offset.top - 400
	}, 1000);
	// 添加border边框
	if($("#" + divid, parent.frames['frame_main'].document).attr("href")==undefined || $("#" + divid, parent.frames['frame_main'].document).attr("href")==""){
		if($(divid).attr("type") == "file" && $("#" + divid, parent.frames['frame_main'].document).text()==""){
			$("#" + divid, parent.frames['frame_main'].document).css("height", "20px");
		}
		$("#" + divid, parent.frames['frame_main'].document).css("border", "2px solid red")
		.css("background","#FC9")
		.css("-moz-border-radius","15px")
		.css("-webkit-border-radius","15px")
		.css("border-radius","15px");
	}
}

/**
 * 点击下一步按钮
 */
function nextStep(){
	//获取main页面所有html代码
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	var frominfo = $("#detailForm");
	frominfo.submit();
}

//将form转为AJAX提交
function ajaxSubmit(frm, fn) {
    var dataPara = getFormJson(frm);
    $.ajax({
        url: frm.action,
        type: frm.method,
        data: dataPara,
        success: fn
    });
}

//将form中的值转换为键值对。
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
 * 点击跳过按钮
 */
function skippedStep(){
	//获取main页面所有html代码
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	var frominfo = $("#detailForm");
	frominfo.submit();
}

/**
 * 预览页面
 */
function yl(){
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#detailForm").attr("target","_top")
	$("#detailForm").attr("action",root+"/page_manage/key/getTemplateYulan")
	$("#detailForm").submit();
}

/**
 * 暂存页面
 */
function zc(){
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#status").val("0");
	$("#detailForm").attr("action",root+"/page_manage/key/zancun")
	ajaxSubmit(document.getElementById("detailForm"), function(data){
		if(confirm("暂存商站只有你自己能访问，你可以在管理页面进行编辑和发布，是否进入管理页面？")){
			top.location.href=root+"/page_manage/key/getAllPaga";
		}
	});
}

/**
 * 点击返回上一步按钮
 */
function backStep(){
	window.history.go(-1);
}

/**
 * 失去焦点时触发的事件
 * 
 * @param info
 *            失去焦点的控件对象
 */
function losesFocus(info) {
	var infoid = $(info).attr("id");
	//获取该对象控制的main页面对应对象id
	var divid = infoid.replace("step_","");
	// 清除border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "")
	.css("height","")
	.css("background","")
	.css("-moz-border-radius","")
	.css("-webkit-border-radius","")
	.css("border-radius","");
	if($(info).attr("type") != "file"){
		if($("#" + divid, parent.frames['frame_main'].document).attr("href") == undefined){
			//把修改的信息添加到main页面中
			$("#" + divid, parent.frames['frame_main'].document).html($(info).val());
		} else {
			if(checkUrl($(info).val())){
				$("#" + divid, parent.frames['frame_main'].document).attr("href",$(info).val());
			}else{
				alert("请输入合法的客户案例链接地址！");
			}
		}
	}
}

/**
 * 点击发布按钮
 */
function fb() {
	var htmlinfo = parent.frames['frame_main'].document.documentElement.outerHTML;
	$("#content").val(htmlinfo);
	$("#status").val("1");
	$("#detailForm").attr("target","_top")
	$("#detailForm").attr("action",root+"/page_manage/key/tofb");
	$("#detailForm").submit();
}

function selectImg(btninfo){
	$("input[type=file]").each(function(){
		var imgid = $(this).attr("id").replace("step_","");
		if($(this).val()!=undefined && $(this).val()!=""){
			selectPictrue($(this),5,imgid,null);
		}
	});
	
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
		url :root+'/component_thumbnail/key/addComponentThumbnail',// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : uploadImg,// 文件上传空间的id属性 <input type="file" id="file"
		// name="file" />
		dataType : 'text',// 返回值类型 一般设置为json
		data : data,// 上传的其他数据
		success : function(dataimg, status) {// 服务器成功响应处理函数
			if (checkFileImg(dataimg)) {// 如果是图片文件
				$("#"+imgId, parent.frames['frame_main'].document).show();
				$("#"+imgId+"font", parent.frames['frame_main'].document).remove();
				parent.frames['frame_main'].document.getElementById(imgId).src = root + "/"
						+ dataimg;
			}
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
	if (!imgName.match(/.jpg|.gif|.png|.bmp/i)) {
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

/**
 * 点击添加更多按钮
 */
function addComponent(){
	addComponentRight();
	addComponentLeft();
	componentNum = componentNum + 1;
}

/**
 * 添加主页面信息
 */
function addComponentRight(){
	/**追加到主页面**/
	var componentId = $(".FormTab").find("input[id]:eq(0)").attr("id").replace(/[\d]/g,"").replace('step_',''); 
	//获取要追加的内容
	if(componentRight == undefined || componentRight==""){
		var rightcomp = $("#"+componentId,parent.frames['frame_main'].document).parents(".update");
		//修改id值
		$(rightcomp).find("[id],[name]").each(function(){
			if($(this).attr("id") != undefined && $(this).attr("id") != ""){
				$(this).attr("id",$(this).attr("id")+componentNum);
			}else if($(this).attr("name") != undefined && $(this).attr("name") != ""){
				$(this).attr("name",$(this).attr("name")+componentNum);
			}
		});
		componentRight = $("#"+componentId+componentNum,parent.frames['frame_main'].document).parents(".update").clone(true);
	}
	//修改添加的id
	$(componentRight).find("[id],[name]").each(function(){
		if($(this).attr("id") != undefined && $(this).attr("id") != ""){
			$(this).attr("id",$(this).attr("id").replace(componentNum+'',componentNum+1+''));
		}else if($(this).attr("name") != undefined && $(this).attr("name") != ""){
			$(this).attr("name",$(this).attr("name").replace(componentNum+'',componentNum+1+''));
		}
	});
	//追加html
	$("#"+componentId+componentNum,parent.frames['frame_main'].document).parents(".update").after(getOuterHtml(componentRight));
}

/**
 * 追加左侧编辑页面信息
 */
function addComponentLeft(){
	//在左侧页面添加编辑理由文本框
	if(componentLeft == undefined || componentLeft == ""){
		//修改id
		$(".FormTab").find("input,textarea").each(function(){
			$(this).attr("id",$(this).attr("id")+componentNum);
		});
		componentLeft = $(".FormTab").clone(true);//克隆代码包括事件
	}
	//修改左侧页面id值
	$(componentLeft).find("input,textarea").each(function(){
		if($(this).attr("id") != undefined &&　$(this).attr("id") != ""){
			var idd = $(this).attr("id").replace(componentNum+'',componentNum+1+'');
			$(this).attr("id",idd);
		}
	});
	//追加到左侧页面
	$(".FormTab").append($(componentLeft).html());
	//赋初值
	$('input').each(function(){
		//判断当前文本框是否属于form_div表单。
		if($(this).parent().attr("name")!="detailForm"){
			var this_id = $(this).attr("id");
			//给文本框赋初值
			if($(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text())) != ""){
				$(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text()));
			} else {
				$(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).attr("href")));
			}
		}
	});
	$('textarea').each(function(){
		//判断当前文本框是否属于form_div表单。
		if($(this).parent().attr("name")!="detailForm"){
			var this_id = $(this).attr("id");
			//给文本域赋初值
			$(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text()));
		}
	});
}

/**
 * 判断网址是否合法
 * 
 * @param str_url
 *            需要验证的网址
 * @returns 是否合法
 */
function checkUrl(str_url) {
	var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
			+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
			+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
			+ "|" // 允许IP和DOMAIN（域名）
			+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
			+ "[a-z]{2,6})" // first level domain- .com or .museum
			+ "(:[0-9]{1,4})?" // 端口- :80
			+ "((/?)|" // a slash isn't required if there is no file name
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re = new RegExp(strRegex);
	if (re.test(str_url)) {
		return true;
	} else {
		return false;
	}
}
/**
 * 获取元素本身html
 * 
 */
function getOuterHtml(obj) {
    var box = $('<div></div>');
    for (var i = 0; i < obj.length; i ++) {
        box.append($(obj[i]).clone());
    }
    return box.html();
}

var oldhtml = "";
var oldtext = "";
/**
 * 修改导航
 */
function editNavigate(navigateid){
	//获取导航html
	oldhtml = getOuterHtml($("#step_"+navigateid).parent());
	//获取导航名
	oldtext = $("#step_"+navigateid).text();
	//把原位置换为文本框的html
	var newhtml = "<div class=\"FormTab\"><input type=\"text\" style=\"width:150px;\" class=\"input_bg\" id=\"step_"+navigateid+"\" onfocusin=\"jumpAnchor(this)\" onblur=\"loseNavigate(this)\" value=\""+oldtext+"\" /><a href=\"#\" style=\"margin-left:5px;\" class=\"blueLine\" onclick=\"navigateOk('"+navigateid+"')\">确定</a><a href=\"#\" style=\"margin-left:5px;\" class=\"blueLine\" onclick=\"navigateCancel('"+navigateid+"')\">取消</a></div>"
	$("#step_"+navigateid).parent().after(newhtml);
	$("#step_"+navigateid).parent().remove();
}

/**
 * 修改导航取消
 * @param navigateid
 */
function navigateCancel(navigateid){
	// 清除border边框
	$("#" + navigateid, parent.frames['frame_main'].document).css("border", "")
	.css("height","")
	.css("background","")
	.css("-moz-border-radius","")
	.css("-webkit-border-radius","")
	.css("border-radius","");
	$("#step_"+navigateid).parent().after(oldhtml);
	$("#step_"+navigateid).parent().remove();
}

/**
 * 修改导航确定
 * @param navigateid
 */
function navigateOk(navigateid){
	losesFocus($("#step_"+navigateid));
	var newText = $("#step_"+navigateid).val();
	$("#step_"+navigateid).parent().after(oldhtml);
	$("#step_"+navigateid).parent().remove();
	$("#step_"+navigateid).text(newText);
	$("[id="+navigateid+"]",parent.frames['frame_main'].document).each(function(){
		$(this).text(newText);
	});
}
/**
 * 修改导航失去焦点
 * @param info
 */
function loseNavigate(info){
	var infoid = $(info).attr("id");
	//获取该对象控制的main页面对应对象id
	var divid = infoid.replace("step_","");
	// 清除border边框
	$("#" + divid, parent.frames['frame_main'].document).css("border", "")
	.css("height","")
	.css("background","")
	.css("-moz-border-radius","")
	.css("-webkit-border-radius","")
	.css("border-radius","");
	if($(info).val()==""){
		return;
	}
}