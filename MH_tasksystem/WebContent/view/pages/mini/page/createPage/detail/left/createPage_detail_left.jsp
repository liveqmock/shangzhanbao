<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%
 	String stepNum = request.getAttribute("stepNum").toString();
	String allNum = request.getAttribute("allNum").toString();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"	href="${root }/view/pages/mini/page/css/frma_left.css">
<script type="text/javascript"	src="${root}/view/pages/mini/page/createPage/detail/js/detail.js"></script>
<script type="text/javascript"	src="${root}/view/js/product/ajaxfileupload.js"></script>
<style>
body {
	background: url(${root }/view/pages/mini/page/images/leftbg.jpg)
		repeat-y left top;
	margin: 0 auto;
	border-top: 1px solid #3d5164;
}
</style>
<script type="text/javascript">
$(function() {
	$("#step_point").html('<%=stepNum %>/<%=allNum%>');
	$("#step_num").html('<%=stepNum%>');
	$("#stepNum").html('<%=allNum%>');

	//如果是属于理由的页面
	$("#step_reason_content").attr("id","step_reason_content"+(<%=stepNum%>-2));
	$("#step_reason_img").attr("id","step_reason_img"+(<%=stepNum%>-2))
	$('input').each(function(){
		//判断当前文本框是否属于form_div表单。
		if($(this).parent().attr("name")!="detailForm"){
			var this_id = $(this).attr("id");
			//给文本框赋初值
			if($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text() != ""){
				$(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text()));
			}
			$(this).attr("onfocusin","jumpAnchor(this)");
			$(this).attr("onblur","losesFocus(this)");
		}
	});
	$('textarea').each(function(){
		//判断当前文本框是否属于form_div表单。
		if($(this).parent().attr("name")!="detailForm"){
			var this_id = $(this).attr("id");
			//给文本域赋初值
			$(this).val(trim($("#"+this_id.replace("step_",""),parent.frames['frame_main'].document).text()));
			$(this).attr("onfocusin","jumpAnchor(this)");
			$(this).attr("onblur","losesFocus(this)");
		}
	});

	//给导航赋初值
	$("[id$=navigate]").each(function(){
		if($("#"+$(this).attr("id").replace("step_",""),parent.frames['frame_main'].document).text()!=""){
			$(this).text($("#"+$(this).attr("id").replace("step_",""),parent.frames['frame_main'].document).text());
			//给修改导航添加事件
			$("#Btn_edit").attr("onclick","editNavigate('"+$(this).attr("id").replace("step_","")+"')");
		} else {
			$("#Btn_edit").parent().remove();
		}
	});
	
	/**如果是图文集合、图片集合和客户用例等组件**/
	if($(".FormTab").find("input[type=text]:eq(0)").length>0){
		//获取要编辑的组件id
		var componentId = $(".FormTab").find("input[id]:eq(0)").attr("id").replace(/[\d]/g,"").replace('step_',''); 
		var componentlist = $("[id^="+componentId+"]",parent.frames['frame_main'].document).parents(".update");
		if(componentlist.length>1){
			for(var i=1;i<componentlist.length;i++){
				addComponentLeft();
				componentNum = componentNum + 1;
			}
		}
	}
	$('input').each(function(){
		if($(this).parent().attr("name")!="detailForm"){
			if($("#"+$(this).attr("id").replace("step_",""),parent.frames['frame_main'].document).attr("href") != undefined && $("#"+$(this).attr("id").replace("step_",""),parent.frames['frame_main'].document).attr("href") != ""){
				$(this).val(trim($("#"+$(this).attr("id").replace("step_",""),parent.frames['frame_main'].document).attr("href")));
			}
		}
	});
	//判断当前步骤是否为最后一步
	if(<%=stepNum %>==<%=allNum%>){
		$("#Btn_befor").attr("class",$("#Btn_save").attr("class"));//修改返回按钮样式
		$("#Btn_befor").text("预览");//修改返回按钮文字
		$("#Btn_befor").attr("id","Btn_yulan");//修改返回按钮id
		$("#Btn_next").text("暂存");//修改跳过按钮文字
		$("#Btn_next").attr("id","Btn_zancun");//修改跳过按钮id
		$("#Btn_save").text("发布");//修改返回按钮文字
		$("#Btn_save").attr("id","Btn_fabu");//修改下一步按钮id
	}
	
	//给添加更多按钮添加事件
	$("#Btn_more").attr("href","javascript:addComponent()");
	
	//给返回、跳过、下一步、上传按钮添加事件
	$("#Btn_befor").attr("href","javascript:window.history.back(-1)");//添加返回按钮事件
	$("#Btn_next").attr("onclick","skippedStep()");//添加跳过点击事件
	$("#Btn_save").attr("onclick","nextStep()");//添加下一步点击事件
	$("#Btn_upload").attr("onclick","selectImg(this)");//上传事件
	
	//给暂存、发布、预览按钮添加事件
	$("#Btn_yulan").attr("onclick","yl()");//预览
	$("#Btn_zancun").attr("onclick","zc()");//暂存
	$("#Btn_fabu").attr("onclick","fb()");//发布
	
	var addLogoFontHtml = "<p>如果您还没有设计网站的logo，我们建议您先用文字描述来代替logo，等到以后有了正式的logo时，再来换掉。</p>"+
	"<p><input id=\'logoFont\' style=\'font-family:SimSun; color:#FF0000; width:200px;\' value=\'\'/></p>"+
	"<p><div style=\'float:left;\'>"+
	"<input type=\'button\' style=\'height:27px; width:60px; background:#666666; border:0px; color:#FFFFFF; font-size:12px; cursor:pointer;\' onclick=\'boldFont()\' value=\'加粗\' /></div>"+
	"<div style=\'margin-left:20px;float:left;width:25px; height:25px; background:#FF0000; border:1px solid #000000; cursor:pointer;\' onclick=\'coloropen(event)\' id=\'inputcolor\' ></div>"+
	"<div style=\'float:left;\'><input type=\'text\' style=\'margin-left:2px;float:left;width:100px; height:25px;\' name=\'color\' id=\'color\' onclick=\'coloropen(event)\' value=\'#FF0000\'/></div>"+
	"<div style=\'float:left;\'><select onchange=\'changeFont(this)\' style=\'margin-left:20px;float:left;width:100px; height:26px;\' id=\'fontselect\'>"+
	"<option selected=\'selected\' value=\'SimSun\'>宋体</option><option value=\'SimHei\'>黑体</option><option value=\'Microsoft YaHei\'>微软雅黑</option><option value=\'KaiTi\'>楷体</option></select>"+
	"</div></p><br/><p><input type=\'button\' style=\'height:27px; width:60px; background:#666666; border:0px; color:#FFFFFF; font-size:12px; cursor:pointer;\' onclick=\'logoOk()\' value=\'确定\' />"+
	"</p><div id=\'colorpane\' style=\'position:absolute; margin-top:50px;z-index:999;display:none;\'></div>";
	
	$("#nologo").attr("onclick","window.parent.alertWin(\"文字Logo\",\""+addLogoFontHtml+"\",\"400\",\"260\")");
});

//去除空格的方法
function trim(str){   
    str = str.replace(/^(\s|\u00A0)+/,'');   
    for(var i=str.length-1; i>=0; i--){   
        if(/\S/.test(str.charAt(i))){   
            str = str.substring(0, i+1);   
            break;   
        }   
    }   
    return str;   
}
</script>
</head>
<body>
	${stepcode }
	<div id="form_div" style="display: none;">
		<form action="${root }/component/key/getComponent" method="post" id="detailForm" name="detailForm">
			<input type="text" id="id" name="pageData.id" value="${id }" />
			<input type="text" id="templateid" name="templateid" value="${templateid }"/>
			<input type="text" id="status" name="pageData.status" value="3" />
			<input type="text" id="type" name="pageData.createType" value="0" />
			<input type="text" id="isdelete" name="pageData.isdelete" value="1" />
			<input type="text" id="stepNum" name="stepNum" value="${stepNum+1 }" />
			<textarea id="content" name="content" >
			</textarea>
		</form>
	</div>
</body>
</html>
