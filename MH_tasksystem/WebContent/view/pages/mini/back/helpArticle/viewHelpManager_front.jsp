<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 <%@include file="/mini_top.jsp"%>
 <%@include file="/view/pages/mini/back/helpArticle/helpFrontLeft.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助与支持</title>
<link href="${root }/view/css/helpArticle.css" rel="stylesheet" type="text/css" />

</head>
<body>
  <div class="content">
	  <div id="Help_left" style="min-height: 650px; width: 760px;height: auto;margin: 85 0 10 0;">
	   		<div id="u151" class="ax_文本框_单行_">
	        	<input id="u151_input" type="text" value="" class="text_sketch" data-label="Input Field" maxlength="128" tabindex="0">
	        	<div id="searchDiv">
	        	<span >搜索</span>
	        </div>
	        <div id="u18">
	        <div id="u19" class="text">
	        <p id="cache14_1">
					<span id="cache15" style="font-weight: 100;">
						<a style="text-decoration:none;color: #0099FF;font-weight: 700;" href="/help_manager/key/turnFrontHelpHelpArticleJSP" looyu_bound="1">
							帮助与支持-&gt;
						</a>
						<a style="text-decoration:none;color: #0099FF;font-weight: 700;" href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=${helpArticleCateData.id}&helpArticleCateData.helparticlecatestate=1&param=help">
							${helpArticleCateData.helparticlecatename}-&gt;
						</a>
						${helpArticleData.helparticlename}
					</span>
				
			</p>
	        <p id="cache14" style="font-size: 20px;"><span id="cache15">${helpArticleData.helparticlename}</span></p>
			 <iframe id="iframeHeight" name="iframeHeight" src="${root }/helpArticle/${helpArticleData.helparticlepath}"></iframe>
			  </div>
			  <div>
			  	<p class="about_p">
			  		相关问题：
			  		<c:forEach var="about" items="${about_helpArticle}">
			  			<label>
			  				<a class="about_a" href="${root }/help_manager/key/viewHelpArticleData?helpArticleData.id=${about.id}&helpArticleCateData.helparticlecatestate=${about.helparticlecate}&param=help">
			  					${about.helparticlename}
			  				</a>
			  			</label>
			  		</c:forEach>
			  </div>
			</div>
	   </div>
  </div>
</div>
<div style="height:10px;"></div>
 <%@include file="/mini_end.jsp"%>
</body>
</html>