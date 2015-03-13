<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"  type="text/css" href="${root }/view/css/bootstrap.css" />
<link href="${root }/view/css/mini/div.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-1.9.1.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/back/tempmanage/tempView.js"></script>
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<style type="text/css">
.viewTa tr td{
 width: 160px;
 text-align: left;
 height: 30px;

}
.viewTa tr {

}
.spanDiv {
margin-left: 10px;
background-color: #AAAAAA;
width: 160px;
height: 30px;
margin-top: 20px;
} 
.spanDiv a{
line-height: 30px;
margin-left: 30px;
color: #FFFFFF  ;
}
.tdC{
font-weight: bold;
}
.divImg{
font-size: 16px;
margin-top: -100px;
}
.viewTa tr{
height: 38px;
}
</style>
<title>模板信息</title>
</head>
<body style="margin: 0">
	  <div class="current" >当前位置：
	   <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
<span><a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main" style="color: #2b6db4;text-decoration: none;">模板管理</a> 
<b>>></b>	<a href="${root}/temp_manage/key/getTemplateDataView?templateData.id=${templateData.id}" target="frame_main" style="color: #2b6db4;text-decoration: none;">模板详情</a>
</span> </div>
  
	<input type="hidden" value="${templateData.id}" id="tempId" name="tempIds">
	<form action="" id="tempFrom" method="post">
	<!-- 主预览图 -->
	<div style="float: left;margin-left: 20px;margin-top: 20px;">
	<img alt="" src="${root }${templateData.esc }"  width="381px;" height="300px;">
	</div>
	
	
	<table class="viewTa"  width="400px;" style="margin-left:15px;float: left;margin-top: 20px;">
	
		<tr>
			<td class="tdC"  style="text-align: right;">模板编号:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.sn }</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">模板名称:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.name }</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">描述:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.memo }</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">布局:&nbsp;&nbsp;&nbsp;</td>
			<td> 
			
			</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">价格:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.price }</td>
		</tr>
		
		<tr>
			<td class="tdC" style="text-align: right;">上传人:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.uploadingName}</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">启用状态:&nbsp;&nbsp;&nbsp;</td>
			<td>
			<c:if test="${templateData.status eq 'OPEN'}">启用</c:if>
			<c:if test="${templateData.status eq 'CLOSED'}">停用</c:if>
		
			</td>
		</tr>
		<tr>
			<td class="tdC" style="text-align: right;">启用时间:&nbsp;&nbsp;&nbsp;</td>
			<td>${templateData.openTime}</td>
		</tr>
		<tr>
				<td colspan="2" style="text-align: right;">
			
			<a href="${root}/temp_manage/key/getTemplateDataViewC?templateData.id=${templateData.id}" id="cImg" target="_Blank">电脑预览图</a>&nbsp;&nbsp;&nbsp;
			<a href="${root}/temp_manage/key/getTemplateDataViewF?templateData.id=${templateData.id}" id="fImg" target="_Blank">平板预览图</a>&nbsp;&nbsp;&nbsp;
			<a href="${root}/temp_manage/key/getTemplateDataViewP?templateData.id=${templateData.id}" id="pImg"  target="_Blank">手机预览图</a>
			</td>
		</tr>	
		
		</table>
 
		
			
 	<c:if test="${sum!=0}"> 
 	<div style="clear: left;margin-left: 20px;font-size: 15px;margin-bottom: 20px;font-weight: 700;">创建 page的情况</div>
	<table  class="tablepage" style="width: 50%;">
	<tr  style="background-color: #AAAAAA;height: 30px;">
	<td>创建Page总数</td>
	<td>正在使用该模板的Page数</td>
	<td>发布的Page数</td>
	</tr>
	<tr>
	<td>${sum}</td>
	<td>${sum1}</td>
	<td>${sum2}</td>
	</tr>
	<tr>
	<td></td>
	<td >
	<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin:0 auto;line-height: 30px;"  class="btnhui" >
	<a href="${root }/temp_manage/key/countTempPage?pageHelpData.tempId=${templateData.id}&pageHelpData.pageState=0"  target="_blank">查看这些page</a>
	</div>
	</td>
	
	<td>
	<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin:0 auto;line-height: 30px;"  class="btnhui" >
	<a href="${root }/temp_manage/key/countTempPage?pageHelpData.tempId=${templateData.id}&pageHelpData.pageState=1" target="_blank">查看这些page</a>
	</div>
	</td>
	</tr>
	</table> 
	</c:if> 
	<c:if test="${sum==0}">
	<div style="clear:left;width: 980px;height:20px;"></div>
	 <div style="margin-top:30px;clear:left;width: 980px;height:60px; filter: alpha(opacity=70); opacity: 0.7; background-color: #cccccc;border-style: solid;margin-left:15px;" >
		<c:if test="${templateData.status eq 'CLOSED'}">
		<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin-left: 40px;float: left;margin-top: 15px;" class="btnhui">
			<a href="#" id="deleteTemp">删除</a>an>
			</div>
			</c:if>
		<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin-left: 40px;float: left;margin-top: 15px;" class="btnhui">
			<a href="#" id="showUpdateDiv">修改</a>
			</div>
				<c:if test="${templateData.status eq 'OPEN'}">
				<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin-left: 40px;float: left;margin-top: 15px;"class="btnhui">
				<a href="#" onclick="closedTemp()">停用</a>
				</div>
				</c:if>
				<c:if test="${templateData.status eq 'CLOSED'}">
				<div style="height: 30px;width: 150px;background-color: #aaaaaa;margin-left: 40px;float: left;margin-top: 15px;" class="btnhui">
				<a href="#" onclick="openTemp()">启用</a>
				</div>
				</c:if>
	
		</div>
	</c:if>
	</form>
	
	<!-- 修改隐藏的  div -->
	<div style="display:none;width: 515px;height: 450px;margin-left: 500px;margin-top: -500px; box-shadow:2px 2px 30px #909090; position: absolute;" class="DataStatistics_1Title" id="tempDiV">
	<form action="" id="divFrom" method="post">

	<table class="viewTa"  width="" style="margin-left:15px;">
	
		<tr style="height: 20px;">
			<td>模板编号:</td>
			<td>${templateData.sn }</td>
		</tr>
		<tr>
			<td>模板名称:</td>
			<td><input name="templateData.name" value="${templateData.name }" type="text" id="name" notnull="模板名称不能为空"> </td>
		</tr>
		<tr>
			<td>描述:</td>
			<td><input name="templateData.memo" value="${templateData.memo }" type="text" id="memo"></td>
		</tr>
		<tr>
			<td>布局:</td>
			<td> 
			<input name="templateData.id" value="${templateData.id}" type="hidden" id="">
			</td>
		</tr>
		<tr>
			<td>价格:</td>
			<td><input name="templateData.price" value="${templateData.price }" type="text" id="price"></td>
		</tr>
	
		<tr>
			<td>上传人:</td>
			<td>${templateData.uploadingName}</td>
		</tr>
		<tr>
			<td>启用状态:</td>
			<td>
			<c:if test="${templateData.status eq 'OPEN'}">启用</c:if>
			<c:if test="${templateData.status eq 'CLOSED'}">停用</c:if>
		
			</td>
		</tr>
		<tr>
			<td>启用时间:</td>
			<td>${templateData.openTime}</td>
		</tr>
		<tr>
			<td colspan="2">
			<a href="${root}/temp_manage/key/getTemplateDataViewC?templateData.id=${templateData.id}" id="cImg" target="_Blank" style="color: blue;">电脑预览图</a>&nbsp;&nbsp;&nbsp;
			<a href="${root}/temp_manage/key/getTemplateDataViewF?templateData.id=${templateData.id}" id="fImg" target="_Blank" style="color: blue;">平板预览图</a>&nbsp;&nbsp;&nbsp;
			<a href="${root}/temp_manage/key/getTemplateDataViewP?templateData.id=${templateData.id}" id="pImg"  target="_Blank" style="color: blue;">手机预览图</a>
			</td>
		</tr>	
		
		<tr>
		
			<td>
			<div style="float: left;" class="btnhui">
			<a href="#" id="closedDiV" style="text-align: center;" >取消</a>
			</div>
			</td>
			<td>
			<div style="float: left;" class="btnlan">
			<a href="#" id="sub"  style="text-align: center;" >保存</a>
			</div>
			</td>
		</tr>
		</table>
	</form>
	</div>
</body>
</html>