<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
  <link href="${root}/view/css/mini/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${root}/view/css/mini/tempstyles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript"	src="${root}/view/js/minipage/common/help.js"></script>
</head>
<body style="background: #e6e6e6;">
      <!-- 留言背景 (形状) -->
      <div id="clientMsg" class="" data-label="全局_导航栏背景">
      </div>
      
     <div id="u4" class="ax_图片" data-label="Image">
        <img id="u4_img" class="img " src="${root}/images/mini/tempmes/image_u4.png">
        <div id="u5" class="text"></div>
      </div>
      
      	<div id="u38" class="ax_文本" data-label="Header 1">
        	<div id="u39" class="text">
          		<p><span style="font-size: 24px;color: #0099CC;text-align: center;">定制模板需求</span></p>
          		
        	</div>
      	</div>
     	<div id="u40" class="ax_文本" data-label="Header 1">
          		<p><span style="font-size: 16px;color: #949494;">没有找到满意的模板？</span></p>
          		<span>没关系，现在可以把你的想法发给我们，我们根据你的需求专门定制一个模板。它是完全免费的！</span>
      	</div>
	
      <%-- 	<div id="u42" class="ax_形状" data-label="Rectangle">
        	<img id="u42_img" class="img " src="${root}/view/images/help/rectangle_u42.png"/>
      	</div> --%>
      
      	<div id="u44" class="ax_文本框_单行_">
        	<input id="u44_input" type="text" placeholder="请输入你的姓名" class="text_sketch name" data-label="Input Field"/>
      	</div>
      
      	<div id="u45" class="ax_文本框_单行_">
        	<input id="u45_input" type="text" placeholder="请输入你的邮箱或手机号码" class="text_sketch userlogin" data-label="Input Field" onkeyup="emilandphoneCheck()" />
      	</div>
     
      	<div id="u46" class="ax_文本框_单行_">
        	<textarea id="u46_input" type="text" placeholder="请输入你的留言" style="resize:none" class="text_sketch helploadMsgContent" data-label="Input Field"></textarea>
      	</div>
      
      	 <div id="u49" class="ax_形状" data-label="Button">
       <%--  <img id="u49_img" class="img " src="${root}/view/images/help/button_u49_mouseOver.png"/> --%>
        <!-- Unnamed () -->
        <div id="u50" class="text">
          <p><input type="button" value="提交" style="width:100px;height:30px;color:white ;border:0px;text-align: center;line-height: 10px;background-color: #00BFFF;" onclick="mesAddHelp()" ></p>
        </div>
      </div>
        <!-- 输入错误提醒信息-案例 (形状) -->
     	<div id="u51" class="ax_文本" data-label="输入错误提醒信息-案例">
        	<img id="u51_img" class="img " src="${root}/view/images/help/transparent.gif"/>
        	<!-- Unnamed () -->
      
          		<p><span style="font-weight: 200;color: #6B6B6B;top:10px;font-size: 14px;width: 450px;">在完成制作模板时，我们会通过你提供的联系方式去通知你。</span></p>
          		<p></p>
          		<p><div id="helplabMes" style="font-size: 12px;display: none;margin-top: 5px;" class="error"></div></p>
      	</div>
	
      <!-- Rectangle (形状) -->
    <div id="u53" class="ax_形状" data-label="Rectangle">
    
     <div class='msgDivstyle' style="display:none ;">
        <h1>感谢你的反馈!</h1>
        <div>我们会在1个工作日内回复你的信息，请注意查收，谢谢！</div>
        <input type='button' value='好的' onclick="shuaxin()">
      </div>
    
     <%@include file="/mini_end.jsp"%>
      </div> 
  </body>
</html>
