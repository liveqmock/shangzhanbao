<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@ taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page"%>
<html>
<head>
<meta charset="utf-8">
<title>商站宝</title>
<meta name="viewport"
  content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css"
  href="${root }/view/model/css/screen.css" media="screen">
<link rel="stylesheet" type="text/css"
  href="${root }/view/model/css/grid.css" media="screen">
<link rel="stylesheet" type="text/css"
  href="${root }/view/model/css/normalize.css" media="screen">
<script type="text/javascript"
	src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"
	src="${root}/view/js/jquery/jquery.form.js"></script>
	<script type="text/javascript"
	src="${root}/view/js/minipage/bootstrap.js"></script>
	<script type="text/javascript"
	src="${root}/view/js/minipage/bootstrap-modal.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript"
  src="${root }/view/model/js/jquery.stellar.min.js"></script>
<script type="text/javascript"
  src="${root }/view/model/js/waypoints.min.js"></script>
<script type="text/javascript"
  src="${root }/view/model/js/jquery.easing.1.3.js"></script>
<script type="text/javascript"
  src="${root }/temp/pagetemp/MinipageTemp01/js/index.js"></script>
  <link rel="stylesheet" type="text/css"
	href="${root }/view/css/bootstrap.css" />
<script type="text/javascript">
  var clickOpen = function click_scroll(id) {
    var scroll_offset = $("#" + id).offset();
    $("body,html").animate({
      scrollTop : scroll_offset.top - 200
    }, 1000);
  }
</script>
</head>
<body>
  <div class="Header">
    <div class="container clearfix update">
      <header id="header" style="background-color: red;text-align: center;">
      	<button class="selectComp">请选择导航</button><button class="clearComp">重置</button>
      </header>
    </div>
  </div>
  <!--导航结束-->
  <!--banner-->
  <div class="wraper">
    <div id="Banerlider" style="background-color: red;text-align: center;">
      	<button class="selectComp">请选择banner内容</button><button class="clearComp">重置</button>
    </div>
  </div>
  <button class = "addComponent3">添加框架组件</button>
  <button class = "look">获取页面内容</button>
  <div id="div_compent">
  </div>
  <div id="addTemp" class="modal modal-mslmgmt hide" style='width: 450px; height: 500px;'>
  <form  id="templateComp" method="post" enctype="multipart/form-data">
		<table style="margin-left: 20px;"  class="addTempTb">
			<tr>
				<td>
					模板名称
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="templateData.name" style="width:380px;"/>
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
		<span style="margin-left: 20px;"><a href="###" class="submitTemp btn btn-primary">提交模板</a>&nbsp<a href="###" class="exis btn btn-primary">取消</a></span>
	</form>
  </div>
</body>
</html>                                   