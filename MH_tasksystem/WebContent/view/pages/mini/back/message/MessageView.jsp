<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>留言详情</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root}/css/centerCss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/spBack.css" />
<script type="text/javascript" src="${root}/view/js/minipage/back/message/messageView.js"></script>
</head>
<body>
  <div class="current">当前位置：
  <span><a href="${root}/frame/key/oprating" target="_parent">首页</a></span><b>>></b>
	<span><a href="${root }/message/key/getAll?messageData.status=2" target="frame_main">留言管理</a> <b>>></b>
	<a href="${root }/message/key/getMessageDate?messageData.id=${messageData.id}" target="frame_main">留言详情</a>
	</span> </div>
<div class="content">
  <div class="OrderForm"  style="margin-top: -80px;">
    <div class="OrderForm_Tab6">
    <input type="hidden"  value="${messageData.id}"  class="mesId"/> 
      <table class="table">
      <tr>
      <td>留言标题</td>
       <td>${messageData.title }</td>
      </tr>
      
       <tr>
      <td>留言内容</td>
       <td>
       <textarea rows="6" cols="70"  style="resize:none;"  name="messageData.contenu">${messageData.contenu }</textarea></td>
      </tr>
      
       <tr>
      <td>留言时间</td>
       <td><fmt:formatDate value="${messageData.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
      </tr>
      
       <tr>
      <td>留言用户</td>
       <td>${messageData.userData.loginMail}</td>
      </tr>
       <tr>
      <td>标记内容</td>
       <td><textarea rows="6" cols="70"  style="resize:none;"    readonly="readonly">${messageData.signeContenu}</textarea>
       </td>
      </tr>
      
      <tr>
      <td colspan="2"> <textarea rows="6" cols="70"  style="resize:none;margin-left: 95px;"  name="messageData.signeContenu"  class="signeContenu"  ></textarea></td>
     
      </tr>
      
      <tr>
      <td colspan="2"><a  href="###"  class="btn_tianjia  edidMes" style="margin-left: 370px;">标记</a></td></td>
      </tr>
      </table>
    </div>
  </div>
</div>
<div class="clear"></div>
</body>
</html>


