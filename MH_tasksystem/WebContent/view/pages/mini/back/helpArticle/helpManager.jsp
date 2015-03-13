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
			url : root + '/help_manager/key/updateHelpArticleCateDataSort',
			data : "helpArticleCateData.helparticlecatestate="+$("#"+btnId+"_hidden").val()+"&helpArticleCateSort="+$("#list1SortOrder").val(),					
			success : function(data) {
				$("#list1SortOrder").val("");
			}
		});
	}
	function editObjectstate(id,state){
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/updateHelpArticleCate',
			data : "helpArticleCateData.helparticlecatestate="+state+"&helpArticleCateData.id="+id,					
			success : function(data) {
					window.location.href=root+"/help_manager/key/queryHelpArticleTypeNum";
			}
		});
	}
	function editObject(id,helparticlecatename){
		$("#"+id).attr("href","####");
		$("#"+id).html("<input id='"+id+"_saveId' type='text' value='"+helparticlecatename+"' >");
		$("#"+id+"_edit").html("保存");
		$("#"+id+"_edit").attr("onclick","editSaveObject('"+id+"')");
	}
	function editSaveObject(id){
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/updateHelpArticleCate',
			data : "helpArticleCateData.helparticlecatename="+$("#"+id+"_saveId").val()+"&helpArticleCateData.id="+id,					
			success : function(data) {
					window.location.href=root+"/help_manager/key/queryHelpArticleTypeNum";
			}
		});
	}
	function addHelpArticleCate(){
		$("#addhelpArticleCateLi").show();
	}
	function backAddhelpArticleCate(){
		$("#addhelpArticleCateLi").hide();
	}
	function savehelpArticleCate(){
		$.ajax( {
			dataType:"text",
			type : "POST",
			url : root + '/help_manager/key/addArticleCateData',
			data : "helpArticleCateData.helparticlecatename="+$("#addhelpArticleCateName").val()+"&helpArticleCateData.helparticlecatestate=0&helpArticleCateData.isdelete=1",					
			success : function(data) {
					window.location.href=root+"/help_manager/key/queryHelpArticleTypeNum";
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
</script>
</head>
<body style="margin-left: 0px;">
<div class="wrapbg_gp">
  <div class="current" ><span style="font-family: Arial, Helvetica, sans-serif '宋体';color: #2b6db4;">当前位置：</span>
   <span><a href="${root}/frame/key/oprating" target="_parent" style="font-family: Arial, Helvetica, sans-serif '宋体';color: #2b6db4;">首页</a></span><b style="font-family: Arial, Helvetica, sans-serif '宋体';color: #2b6db4;">>></b>
<span><a href="${root}help_manager/key/queryHelpArticleTypeNum" target="frame_main" style="font-family: Arial, Helvetica, sans-serif '宋体';color: #2b6db4;">【帮助与支持】内容管理</a> </span> </div>
  	<div>
	  	<div id="" class="u40">
	    </div>
	    <div id="" class="u57" >
	        <img id="u57_line" class="img " src="${root }/view/images/help/line_horizontal_u57_line.png">
	     </div>
	     <div id="u58">
	     	<ul id="ul_1">
	     	<c:forEach var="listhelpArticleCate" items="${list_helpArticleCate}" varStatus="i">
	     	<c:if test="${listhelpArticleCate.helparticlecatestate==1 }">
					<li onmouseover="mouseover('${listhelpArticleCate.id}');" onmouseout="mouseout('${listhelpArticleCate.id}');">
						<a id="${listhelpArticleCate.id}" href="${root }/help_manager/key/queryListHelpArticle?helpArticleCateData.id=${listhelpArticleCate.id}" >
						${listhelpArticleCate.helparticlecatename}(${fn:length(listhelpArticleCate.list_helpArticle)})
						</a>
						<a id="${listhelpArticleCate.id}_edit" href="####" onclick="editObject('${listhelpArticleCate.id}','${listhelpArticleCate.helparticlecatename}')" style="font-size: 12px;display: none">修改</a>
						<a id="${listhelpArticleCate.id}_hidden" href="####" onclick="editObjectstate('${listhelpArticleCate.id}','0');" style="font-size: 12px;margin-left: 5px;display: none">隐藏</a>
					</li>
			</c:if>
			</c:forEach>	
			</ul>
	     </div>
	     <input id="btn_1_hidden" type="hidden" value="1">
	     <div class="Btn" >
	     	<a href="###" id="btn_1" onclick="sortUl('btn_1','ul_1');">排序</a>
	     </div>
  	</div>
  	
  	<div>
	  	<div class="u40" style="top:400px">
	      <div id="u41" class="text">
	        <p><span style="font-family:'Heiti SC Medium', 'Heiti SC';font-weight:700;color:#333333;">未显示分类</span><span style="font-family:'Heiti SC Light', 'Heiti SC';font-weight:200;color:#999999;">（暂存在后台的草稿，没有在前台显示的）</span></p>
	      </div>
	    </div>
	    <div id="" class="u57" style="top:440px">
	        <img id="u57_line" class="img " src="${root }/view/images/help/line_horizontal_u57_line.png">
	     </div>
	     <div id="u58" style="top:450px">
	     	<ul id="ul_2">
					<c:forEach var="listhelpArticleCate" items="${list_helpArticleCate}" varStatus="i">
			     	<c:if test="${listhelpArticleCate.helparticlecatestate==0 }">
							<li onmouseover="mouseover('${listhelpArticleCate.id}');" onmouseout="mouseout('${listhelpArticleCate.id}');">
								<a id="${listhelpArticleCate.id}"  href="${root }/help_manager/key/queryListHelpArticle?helpArticleCateData.id=${listhelpArticleCate.id}" >
								${listhelpArticleCate.helparticlecatename}(${fn:length(listhelpArticleCate.list_helpArticle)})
								</a>
								<a id="${listhelpArticleCate.id}_edit" href="####" onclick="editObject('${listhelpArticleCate.id}','${listhelpArticleCate.helparticlecatename}')" style="font-size: 12px;display: none">修改</a>
								<a id="${listhelpArticleCate.id}_show" href="####" onclick="editObjectstate('${listhelpArticleCate.id}','1');" style="font-size: 12px;margin-left: 5px;display: none">显示</a>
							</li>
					</c:if>
					</c:forEach>	
					<li id="addhelpArticleCateLi" style="display: none">
						<a id="${listhelpArticleCate.id}"  href="##" >
						<input id='addhelpArticleCateName' type='text' value='' >
						</a>
						<a id="${listhelpArticleCate.id}_edit" href="####" onclick="savehelpArticleCate();"  style="font-size: 12px;">保存</a>
						<a id="${listhelpArticleCate.id}_show" href="####" onclick="backAddhelpArticleCate();"  style="font-size: 12px;margin-left: 5px;">取消</a>
					</li>
				</ul>
	     	</div>
	     	<input id="btn_2_hidden" type="hidden" value="0">
	     	<div style="position: absolute;top:650px;left:60px;">
	     		<a href="###" class="add_abuttion" onclick="addHelpArticleCate();"">新增加分类</a>
	     	</div>
	     	<div class="Btn" style="top:680px">
	     		<a href="###" id="btn_2" onclick="sortUl('btn_2','ul_2');">排序</a>
	     	</div>
     	</div>
     	</div>
     	<input id="list1SortOrder" name="list1SortOrder" type="hidden" />
  	</body>

</html>