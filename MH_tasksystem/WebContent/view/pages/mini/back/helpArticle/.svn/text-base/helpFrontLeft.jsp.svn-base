<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="${root}/view/css/mini/help/help.css" />

</head>
<body>
  <div id="Help_right">
  	<div class="navHelp">
    <h1><span></span>帮助与支持</h1>
    </div>
    <div class="ulHelp">
    <ul>
    	<c:forEach var="list" items="${list_helpArticleCate}">
    		<li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=${list.id}&helpArticleCateData.helparticlecatestate=${list.helparticlecatestate}&param=help"   class="${list.id==helpArticleCateData.id?'active':'act' }">${list.helparticlecatename}</a></li>
    	</c:forEach>
      <%-- <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=0&param=help"   class="${helpArticleData.helparticlecate==0?'active':'act' }">新手上路</a></li>
      <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=1&param=help"   class="${helpArticleData.helparticlecate==1?'active':'act' }">常见问题</a></li>
      <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=2&param=help"   class="${helpArticleData.helparticlecate==2?'active':'act' }">账号及登陆</a></li>
      <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=3&param=help"   class="${helpArticleData.helparticlecate==3?'active':'act' }">创建及编辑商站问题</a></li>
      <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=4&param=help"   class="${helpArticleData.helparticlecate==4?'active':'act' }">手机推广问题</a></li>
      <li><a href="${root }/help_manager/key/queryListHelpArticleByCate?helpArticleData.helparticlecate=5&param=help"   class="${helpArticleData.helparticlecate==5?'active':'act' }">高级操作技巧</a></li> --%>
    </ul>
    </div>
  </div>
  </body>
</html>
