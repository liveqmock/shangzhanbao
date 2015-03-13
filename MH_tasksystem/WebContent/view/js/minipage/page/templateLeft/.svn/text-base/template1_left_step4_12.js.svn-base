<script type="text/javascript">

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
 * 预览页面
 */
function yl(){
	var htmlinfo = mainframe.documentElement.outerHTML;
	$("#code").val(htmlinfo);
	$("#form").attr("action",root+"/template_structure/key/getTemplateYulan")
	$("#form").submit();
}

/**
 * 暂存页面
 */
function zc(){
	var htmlinfo = mainframe.documentElement.outerHTML;
	$("#code").val(htmlinfo);
	ajaxSubmit(document.getElementById("form"), function(data){
		if(confirm("暂存的商站只有你自己能访问，你可以在管理页面进行修改和发布。")){
			top.location.href=root+"/view/pages/mini/page/right.html";
		}
	});
}

/**
 * 发布页面
 */
function fb(){
	
}
 
 
//获取right页面
var mainframe = parent.frames['frame_main'].document;

//给添加的信息处添加边框
function initBorder(info){
	var slogan = mainframe.getElementById(info);
	$(slogan).css("border","2px solid red");
}

//给标语和卖点辅值
function getSlogan(info,divid,ms){
	var slogan = mainframe.getElementById(divid);
	if($(info).val()!=""){
		slogan.innerHTML = $(info).val();
	}else{
		$(info).val(ms);
	}
	$(slogan).css("border","");
}

//子页面跳转锚点
function gotoAnchor(info,url) {
	if($(info).val()=="请对公司、产品进行介绍，让你的客户可以更加了解信任你，增加成交机会"){
		$(info).val("");
	}
	parent.frames['frame_main'].window.clickOpen(url);
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

</script>