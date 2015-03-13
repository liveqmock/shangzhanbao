<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<html>
<head>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/role/ctn/authorityAdd.js"></script>
</head>

<body>
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a><b>>></b>
   <span><a href="${root }/role/key/queryAllRolesInfo" target="frame_main">角色管理</a></span> <b>>></b>

  <span><a href=" ${root }/role/key/getAuthorityList" target="frame_main">权限功能管理</a></span>
     <b>>></b> 
    <span><a href="${root }/view/pages/sys/role/ctn/authorityAdd.jsp" >新增权限功能</a></span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form id="roleForm" onsubmit="return checkSub($(this))" action="${root }/role/key/addAuthority" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
          <tr>
            <td width="80">功能名称： </td>
            <td>
             <input name="authorityData.name" type="text" size="40" class="input_bor" 
              data-placement="right"  notnull="请填写功能名称"/><font color="#FF0000">*</font>
           </td>
          </tr>
          <tr>
            <td>URL：</td>
            <td>
            <textarea rows="5" cols="40" name="authorityData.url" 
            class="input_bor" style="height:100px; width:400px"
			data-placement="right" max="100" notnull="请填写访问地址"></textarea><font color="#FF0000">*</font>
            </td>
          </tr>
          <tr>
            <td>类型：</td>
            <td>
            	<select name="authorityData.type">
            		<option value="0">查询</option>
            		<option value="1">增加</option>
            		<option value="2">删除</option>
            		<option value="3">修改</option>
            	</select>
            	<font color="#FF0000">*</font>
            </td>
            
          </tr>
        </table> 
      </form>
    </div><div class="clear"></div>
    <div class="Btn_tab">
          <div class="btn_red" style="margin:0 0 0 50px; float:left"><a href="###" class="" onclick="$('#roleForm').submit();">完 成</a></div>
          <div class="btn_red" style="margin:0 0 0 50px; float:left"><a href="###" class="cancel">取消</a></div>
        </div>
  </div>
</div>
</body>
</html>
