<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助与支持内容管理</title>
<link href="${root }/view/css/helpArticle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root }/view/js/dragsort/jquery.dragsort-0.5.1.min.js"></script>
<script type="text/javascript">
	function sortUl(btnId,id){
		$("#"+btnId).html("保存");
		$("#"+btnId).parent().html("<a href=\"###\" id=\""+btnId+"\" onclick=\"saveSort('"+btnId+"','"+id+"');\">保存</a>")
		$("#"+id).dragsort({ dragSelector: "li", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li ></li>" });
		function saveOrder() {
			var data = $("#"+id+" a").map(function() { return this.id; }).get();
			$("input[name=list1SortOrder]").val(data.join(","));
		}
	}
	function saveSort(btnId,id){
		$("#"+id).dragsort("destroy");
		$("#"+btnId).parent().html("<a href=\"###\" id=\""+btnId+"\" onclick=\"sortUl('"+btnId+"','"+id+"');\">排序</a>");
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/updateHelpArticleDataSort',
			data : "helpArticleData.helparticlestate="+$("#"+btnId+"_hidden").val()+"&helpArticleCateSort="+$("#list1SortOrder").val()+"&helpArticleData.helparticlecate="+$("#helparticlecatecate").val(),					
			success : function(data) {
				$("#list1SortOrder").val("");
			}
		});
	}
	function mouseover(id){
		$("#"+id+"_edit").show();
		$("#"+id+"_hidden").show();
		$("#"+id+"_show").show();
	}
	function mouseout(id){
		$("#"+id+"_edit").hide();
		$("#"+id+"_hidden").hide();
		$("#"+id+"_show").hide();
	}
	function editObject(id,helparticlename){
		$("#"+id).attr("href","####");
		$("#"+id).html("<input id='"+id+"_saveId' type='text' value='"+helparticlename+"' >");
		$("#"+id+"_edit").html("保存");
		$("#"+id+"_edit").attr("onclick","editSaveObject('"+id+"')");
	}
	function editObjectstate(id,state){
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/updateHelpArticleData',
			data : "helpArticleData.helparticlestate="+state+"&helpArticleData.id="+id,					
			success : function(data) {
				window.location.reload();
			}
		});
	}
	function editSaveObject(id){
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/updateHelpArticleData',
			data : "helpArticleData.helparticlename="+$("#"+id+"_saveId").val()+"&helpArticleData.id="+id,					
			success : function(data) {
					window.location.reload();
			}
		});
	}
</script>
</head>
<body>
  	<div>
	  	<div id="" class="u40">
	      <div id="u41" class="text">
	        <p><span><a href="${root}/frame/key/oprating" target="_parent">主页</a>-&gt;<a href="${root }/help_manager/key/queryHelpArticleTypeNum">【帮助与支持】内容管理</a>-&gt;${helpArticleCateData.helparticlecatename}</span></p>
	      </div>
	    </div>
	    <div id="" class="u57" >
	        <img id="u57_line" class="img " src="${root }/view/images/help/line_horizontal_u57_line.png">
	     </div>
	     <div id="u58">
	     	<ul id="ul_list">
	     		<c:forEach var="list" items="${list_helpArticle}" varStatus="i">
	     		<c:if test="${list.helparticlestate==1}">
					<li onmouseover="mouseover('${list.id}');" onmouseout="mouseout('${list.id}');">
						<a id="${list.id}" href="${root }/help_manager/key/findHelpArticleData?helpArticleData.id=${list.id}">
						${list.helparticlename}
						</a>
						<a id="${list.id}_edit" href="####" onclick="editObject('${list.id}','${list.helparticlename}')" style="font-size: 12px;display: none">修改</a>
						<a id="${list.id}_hidden" href="####" onclick="editObjectstate('${list.id}','0');" style="font-size: 12px;margin-left: 5px;display: none">隐藏</a>
					</li>
				</c:if>
				</c:forEach>
			</ul>
	     	</div>
	     	<input id="btn_list_hidden" type="hidden" value="1">
	     	<div class="Btn" >
	     		<a href="###" id="btn_list" onclick="sortUl('btn_list','ul_list');">排序</a>
	     	</div>
  	</div>
  	
  	<div>
	  	<div id="" class="u40" style="top:400px">
	      <div id="u41" class="text">
	        <p><span style="font-family:'Heiti SC Medium', 'Heiti SC';font-weight:700;color:#333333;">未显示文章</span><span style="font-family:'Heiti SC Light', 'Heiti SC';font-weight:200;color:#999999;">（暂存在后台的草稿，没有在前台显示的）</span></p>
	      </div>
	    </div>
	    <div id="" class="u57" style="top:440px">
	        <img id="u57_line" class="img " src="${root }/view/images/help/line_horizontal_u57_line.png">
	     </div>
	     <div id="u58" style="top:450px">
	     	<ul id="ul_list_1">
	     		<c:forEach var="list" items="${list_helpArticle}" varStatus="i">
	     		<c:if test="${list.helparticlestate==0}">
					<li onmouseover="mouseover('${list.id}');" onmouseout="mouseout('${list.id}');">
						<a id="${list.id}" href="${root }/help_manager/key/findHelpArticleData?helpArticleData.id=${list.id}">
						${list.helparticlename}
						</a>
						<a id="${list.id}_edit" href="####" onclick="editObject('${list.id}','${list.helparticlename}')" style="font-size: 12px;display: none">修改</a>
						<a id="${list.id}_hidden" href="####" onclick="editObjectstate('${list.id}','1');" style="font-size: 12px;margin-left: 5px;display: none">显示</a>
					</li>
				</c:if>
				</c:forEach>
			</ul>
	     	</div>
	     	<div style="position: absolute;top:650px;left:60px;">
	     		<a class="add_abuttion" href="${root }/help_manager/key/turnAddHelpArticleJSP?helpArticleCateData.id=${helpArticleCateData.id}">新增加文章</a>
	     	</div>
	     	<input id="btn_1_hidden" type="hidden" value="0">
	     	<div class="Btn" style="top:680px">
	     		<a href="###" id="btn_1" onclick="sortUl('btn_1','ul_list_1');">排序</a>
	     	</div>
     	</div>
     	<input id="list1SortOrder" name="list1SortOrder" type="hidden" />
     	<input type="hidden" id="helparticlecatecate" value="${helpArticleCateData.id}">
  	</body>

</html>