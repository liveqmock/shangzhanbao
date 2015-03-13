<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加帮助与支持内容</title>
<link href="${root }/view/css/helpArticle.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" src="${root}/view/js/kindeditor-master/kindeditor.js"></script>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			afterCreate : function() {
				this.loadPlugin('autoheight');
			},
			allowUpload : true, //允许上传图片
			uploadJson : root+'/upload_img/key/upload'//文件上传的地址
		})
		editor.html(""+document.getElementById('content').value);
		document.getElementById('helparticlename').value=$("#temphelparticlename").val();
	});
	//提交文本
	function suresubmit(state){
		editor.sync();
		//设置帮助文章状态
		$("#helparticlestate").val(state);
		$.ajax({
			type : "POST",
			url : root + '/help_manager/key/addHelpArticleAndFile',
			data : {"helpArticleData.helparticlecate":$("#helparticlecate").val(),
					"helpArticleData.isdelete":$("#isdelete").val(),
					"helpArticleData.helparticlestate":$("#helparticlestate").val(),
					"helpArticleData.helparticlename":$("#helparticlename").val(),
					"helpArticleData.id":$("#temphelparticleId").val(),
					"content":document.getElementById('editor_id').value
					},
			dataTyep: "text",
			success : function(data) {
				if(data==1){
					alert("增加成功");
					var url=root+"/help_manager/key/queryListHelpArticle?helpArticleCateData.id="+$("#helparticlecate").val();
					window.location.href=url;
				}
			}
		});
		
	}

</script>
</head>
<body>
<form id="submitContent" action="${root }/help_manager/key/addHelpArticleAndFile" method="post">
	<div>
	  	<div id="" class="u40">
	      <div id="u41" class="text">
	      <c:if test="${empty helpArticleData.id }">
	        <p><span><a href="${root}/frame/key/oprating" target="_parent">主页</a>-&gt;<a href="${root }/help_manager/key/queryHelpArticleTypeNum">【帮助与支持】内容管理</a>-&gt;<a href="${root }/help_manager/key/queryListHelpArticle?helpArticleCateData.id=${helpArticleCateData.id}">${helpArticleCateData.helparticlecatename }</a>
	        -&gt;增加文章</span></p>
	      </c:if>
	      <c:if test="${!empty helpArticleData.id }">
	        <p><span><a href="${root}/frame/key/oprating" target="_parent">主页</a>-&gt;<a href="${root }/help_manager/key/queryHelpArticleTypeNum">【帮助与支持】内容管理</a>-&gt;<a href="${root }/help_manager/key/queryListHelpArticle?helpArticleCateData.id=${helpArticleCateData.id}">${helpArticleCateData.helparticlecatename }</a>
	        -&gt;修改文章</span></p>
	      </c:if>
	      </div>
	    </div>
	    <div id="" class="u57" >
	        <img id="u57_line" class="img " src="${root }/view/images/help/line_horizontal_u57_line.png">
	     </div>
	     <div id="editTextarea" >
	     <!-- 文章标题 -->
	     <textarea style="width:740px;height:50px;font-size: 30px;text-align: center;" id="helparticlename"  name="helpArticleData.helparticlename" placeholder="文章标题"></textarea>
	     <!-- 文本编辑器 -->
	     <textarea id="editor_id" name="content" style="width:740px;height:400px;">
		 </textarea>
	     </div>
	     <div style="position:absolute; left:20px; top:550px;">
	     	<a href="###" class="btn_tianjia" onclick="suresubmit(1);">发布</a>
	     	<a href="###" class="btn_tianjia" style="position:absolute; left:550px;" onclick="suresubmit(0);">存草稿</a>
	     	<a href="###" class="btn_tianjia_1"  style="position:absolute;left:620px;" >取消</a>
	     </div>
	     <input type="hidden" id="helparticlecate" name="helpArticleData.helparticlecate" value="${helpArticleCateData.id}">
	     <input type="hidden" id="isdelete" name="helpArticleData.isdelete" value="1">
	     <input type="hidden" id="helparticlestate" name="helpArticleData.helparticlestate" value="">
	     <input type="hidden" id="temphelparticleId" value="${helpArticleData.id}" >
	     <input type="hidden" id="temphelparticlename" value="${helpArticleData.helparticlename}" >
	     <!-- 文件内容 -->
	     <input type="hidden" id="content" value="${content}" >
	</div>
</form>	
</body>
</html>