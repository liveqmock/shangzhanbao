<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<%@include file="/view/pages/mini/back/helpArticle/helpFrontLeft.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助与支持</title>
<link href="${root }/view/css/helpArticle.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript">
		function submitForm(){
			$("#search").submit();
		}
	</script>
</head>
<body>
	<div class="content" style="min-height: 100%;">
	<form action="${root }/help_manager/key/searchListHelpArticle" id="search">
			<div id="Help_left"
			style="min-height: 650px; width: 760px; height: auto;margin: 85 0 10 0;">
			<div id="u151" class="ax_文本框_单行_">
				<input id="u151_input" type="text" value="" class="text_sketch"
					data-label="Input Field" maxlength="128" tabindex="0" name="helpArticleData.helparticlename">
				<div id="searchDiv">
					<span><a href="###" onclick="submitForm();">搜索</a></span>
				</div>

				<div id="u18">
					<c:if test="${empty helpArticleData.helparticlecate}">
					<c:forEach var="list" items="${list_helpArticleCate}">
					
						<div id="u19" class="text">
							<p id="cache14">
								<span id="cache15" >
									<a style="color:#333333;text-decoration: none;" href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=${list.id}&helpArticleCateData.helparticlecatestate=${list.helparticlecatestate}&param=help">
										${list.helparticlecatename}
									</a>
								</span>
							</p>
							<ul>
								<c:forEach var="list_1" items="${list.list_helpArticle}">
									<c:if test="${list_1.helparticlestate==1 }">
										<li><a
											href="${root }/help_manager/key/viewHelpArticleData?helpArticleData.id=${list_1.id}&helpArticleCateData.helparticlecatestate=${list.helparticlecatestate}&param=help">${list_1.helparticlename}</a>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</c:forEach>
						<div style="height: 30px;"></div>
					</c:if>
					<c:if test="${!empty helpArticleData.helparticlecate}">
						<div id="u19_1" class="text">
							<p id="cache14_1">
									<span id="cache15" style="font-weight: 100;">
									<a style="text-decoration:none" href="/help_manager/key/turnFrontHelpHelpArticleJSP?param=help" looyu_bound="1">
									帮助与支持</a>-&gt;${helpArticleCateData.helparticlecatename}</span>
								
							</p>
							<ul>
								<c:forEach var="list" items="${list_helpArticle}">
									
										<li><a
											href="${root }/help_manager/key/viewHelpArticleData?helpArticleData.id=${list.id}&helpArticleCateData.helparticlecatestate=${helpArticleCateData.helparticlecatestate}&param=help">${list.helparticlename}</a>
										</li>
									
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</div>

			</div>
		</div>
		<input type="hidden" value="${helpArticleCateData.helparticlecatestate }" name="helpArticleCateData.helparticlecatestate">
		<input type="hidden" value="help" name="param">
		</form>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>