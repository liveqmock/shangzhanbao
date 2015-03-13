<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>修改密码 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root }/view/css/centerCss.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/purchase/sysUser/editPwd.js"></script>
</head>
<body>
<form action="" id="editPass" method="post" onsubmit="return checkSub($(this))">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
  <div class="UserCenter_Right"  >
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>修改登陆密码</h1>
      </div>
      
      <div style="height: 370px;">
      <div style="margin-left: -23px;">
      <div class="error" style="margin-top:20px;margin-left:155px;display:none;position: absolute;margin-top: 50px;"></div>
       <div class="control-group" style="margin-top: 50px;">
          <label class="control-label" style="font-size: 14px">当前密码：</label>
          <div class="controls"><input type="password" trim="" notnull="请输入旧密码" id="oldPword"   class="input_23bor oldPass" size="30"/></div>
        </div>
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">新的密码：</label>
          <div class="controls"><input id="onePass" type="password" trim="" notnull="请输入新密码" min="8" max="16" notnum="不能是纯数字"  name="userData.passWord" class="input_23bor newPass" size="30"/></div>
        </div>
        <div class="control-group">
          <label class="control-label" style="font-size: 14px">确认密码：</label>
          <div class="controls"><input id="newPassword" type="password" trim=""  notnull="请重新输入新密码" refer="onePass" class="input_23bor" size="30"/></div>
        </div>
       <span>
       <a href="javascript:history.go(-1)" class="btn_blue" id="hide"  style="margin-left: 130px;margin-top: 10px;">取消</a></span> &nbsp;&nbsp;&nbsp; <span ><a  style="margin-left: 30px;margin-top: 10px;" href="#" class="btn_blue" id="eidt">确定</a></span>
      </div> 
     </div>
     </div>
     </div>
    </div>
     <%@include file="/mini_end.jsp"%>
   </form>
</body>
</html>