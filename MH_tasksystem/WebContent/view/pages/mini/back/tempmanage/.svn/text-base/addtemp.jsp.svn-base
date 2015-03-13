<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/tempmanage/addTemp.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/css/bootstrap.css" />
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<title>添加模板</title>
<style type="text/css">
.addTempTb tr{
margin-top: 10px;
height: 40px;
width: 400px;
}

</style>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;">
 <div class="current" style="color: #0044BB ;">当前位置： <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b> <a href="${root }/portal/key/gotoPortal" target="frame_main" style="color: #0044BB ;">主页</a> <b>>></b>
<a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main">模板管理</a> </div>
  <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
	<form  id="addTemp" method="post" enctype="multipart/form-data" onsubmit="return checkSub($(this))">
		<table style="margin-left: 20px;"  class="addTempTb">
			<tr>
				<td>
					模板名称
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="templateData.name" notnull="模板名称不能为空" style="width:380px;"/>
				</td>
			</tr>
			<tr>
				<td>
					描述
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="" cols="15" name="templateData.memo" style="width:380px;height: 125px;"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<a class="addComponent btn btn-primary">添加模板组件</a>
					<div id="div_component">
						<select id="select_component">
							
						</select>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					主预览图（JPG或PNG, 300*350像素）
				</td>
			</tr>
			<tr>
				<td>
				<input style="width: 250px;height: 30px" type="file" name="fileMain" class="fileJPG btn btn-primary"/>
				</td>
			</tr>
			<tr>
				<td>
					电脑预览图（JPG或PNG）
				</td>
			</tr>
			<tr>
				<td>
				<input style="width: 250px;height: 30px" type="file" name="filePC" class="fileJPG btn btn-primary"/>
				</td>
			</tr>
			<tr>
				<td>
					平板电脑预览图（JPG或PNG）
				</td>
			</tr>
			<tr>
				<td>
				<input style="width: 250px;height: 30px" type="file" name="filePad" class="fileJPG btn btn-primary"/>
				</td>
			</tr>
			<tr>
				<td>
					手机预览图
				</td>
			</tr>
			<tr>
				<td>
				<input style="width: 250px;height: 30px" type="file" name="filePhone" class="fileJPG btn btn-primary"/>
				</td>
			</tr>
		</table>
		 <div style="background-color: #AAAAAA;height: 1px;width: 980px;margin:20 0 20 10;"></div>
		<span style="margin-left: 20px;"><a href="###" class="submitTemp btn btn-primary">提交模板</a>&nbsp<a href="###" class="btn btn-primary">取消</a></span>
	</form>
</body>
</html>