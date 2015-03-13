<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>模板库，带营销方法的模板 - 商站宝</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name ="keywords" content="网站模板，手机网站模板，微信网站模板，商站，微网站模板">
<meta name="description" 
 content="网站模板，手机网站模板，大气，简约，经典，营销型网站模板，微信模板">
<link rel="stylesheet" type="text/css" href="${root}/view/css/temp/styles.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<script type="text/javascript"
	src="${root}/view/js/minipage/front/template/tempShop.js"></script>
</head>
<body>
<input type="text" id="userid" name="" value="${userData.id}"> 
<form action="" method="post">
<%-- 	<input type="hidden" name="templateData.esc" value="${requestScope.param }"/> --%>
	<div style="text-align: center;margin-top: 150px;">
		<span style="font-size:28px;font-family:'Heiti SC Light', 'Heiti SC';font-weight:200;">请选择一个你喜欢的模板</span>
	</div>
	<div class="SelectTemplate_right2">
		<div id="aside">
			<ul>
				<li class="${requestScope.param=='all'?'liBlue':'active' }"><a href="${root }/temp_manage/key/searchOpenTemp?templateData.esc=all&templateData.status=OPEN">全部</a></li>
				<li class="${requestScope.param=='like'?'liBlue':'active' }"><a href="${root }/temp_manage/key/searchOpenTemp?templateData.esc=like">最多喜欢</a></li>
				<li class="${requestScope.param=='new'?'liBlue':'active' }"><a href="${root }/temp_manage/key/searchOpenTemp?templateData.esc=new&templateData.status=OPEN">最新发布</a></li>
			</ul>
		</div>
		<div id="temps" >
			<c:forEach var="templateData" items="${templateDatas }" varStatus="i">
  				<div class="temppic">
  					<div class="pic1">
  						<a href="${root }/temp_manage/key/ajaxSearchTempById?id=${templateData.id }" target="_blank" data="${templateData.id }">
  							<img class="temp" src="${root }${templateData.imgpath}">
  						</a>
  					</div>
					<div style="height: 30px;width: 490px;float: left;margin-top: 8px">
						<div style="float: right;">
							<span class="btn_graytmp searchTemp" data2="${userData.id }" data="${templateData.id }" id="btn_graytmp_${templateData.id}" onmouseover="hou('${templateData.id }')" onmouseout="out('${templateData.id }')"><a href="###">查看</a></span>
							<span class="btn_orange userTemp" data2="${userData.id }" data="${templateData.id }" onmouseover="hous('${templateData.id }')" onmouseout="outs('${templateData.id }')" id="shi_${templateData.id}"><a href="###" id="sa_${templateData.id }">使用</a></span>
						</div>
					</div>
 				</div>
  			</c:forEach>
  			
  		</div>
  		
	</div>
	<div id="u84">
        <img id="u84_line" src="${root}/view/css/temp/images/temp/u84_line.png"/>
    	<div id="u101">
          <span>没有找到合适的模板？<a href="${root}/temp_manage/key/totempMes" style="color: #00779F;text-decoration: none;" class="">请点这里—&gt;</a></span>
    	</div>
    	</div>
	<div class="ListPageTabt">
		<page:PageRoll />
	</div>
</form>
    
	

<div id="tempShopFoot">
</div>


<div style="position:relative; bottom:0; right:0;width: 100%">
<%@include file="/mini_end.jsp"%>
</div>
</body>
</html>

