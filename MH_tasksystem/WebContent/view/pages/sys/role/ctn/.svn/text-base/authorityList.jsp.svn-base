<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ include file="/baseHead.jsp"%>
<html>
<head>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root }/view/js/sys/role/ctn/roleList.js"></script>
<title>功能权限列表</title>
</head>

<body style="height:100%;border-top:1px solid #D5D5D5;">
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a> <b>>></b> 
  <span><a href="${root }/role/key/queryAllRolesInfo" target="frame_main">角色管理</a></span>
  <b>>></b> 
  <span><a href=" ${root }/role/key/getAuthorityList" target="frame_main">权限功能管理</a></span>
 
   </div>
  <div id="ContentDiv">
    <div class="User_TopSearch">
      <form action="${root }/role/key/queryAllRolesInfo" id="roleForm" method="post">
        <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td width="80" align="right">角色名称：</td>
            <td width="120"><input name="roleData.rolename" type="text" class="input_blue" size="20" /></td>
            <td><div style="margin:0 0 0 20px">
                <input type="submit" name="button" id="button" value="" class="Btn_TopSearch" />
              </div></td>
          </tr>
        </table>
      </form>
    </div>
    
    <!-- 标题开始 -->
    
    <div class="TabContent">
      <div class="Btn_div">
        <div><a href="${root }/view/pages/sys/role/ctn/authorityAdd.jsp" class="btn_tianjia">添加权限</a>
        <a href="###" class="btn_tianjia" id="deleteRole">删除权限</a></div>
      </div>
      <div class="hm_content">
        <form action="${root }/role/key/queryAllRolesInfo" id="roleForm" method="post">
          <table width="100%" border="0" cellspacing="1" cellpadding="1">
            <tr>
              <td width="110"><div class="td_redbg">
                  <input type="checkbox" name="allcbx" id="allcbx" style="margin:9px 0 0 0"/>
                </div></td>
              <td width="100"><div class="td_redbg">编号 </div></td>
              <td width="650"><div class="td_redbg">功能名称
 			 </div></td>
              <td width="300"><div class="td_redbg">访问路径
 			 </div></td>
              <td width="300"><div class="td_redbg">创建时间
 			 </div></td>
            </tr>
            <c:forEach items="${authorityDatas }" var="authorityData" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${authorityData.name }</td>
					<td>${authorityData.url }</td>
					<td>${authorityData.createTime }</td>
				</tr>            
            </c:forEach>
          </table>
          <page:PageRoll/>
        </form>
      </div>
  </div>
</div>
</div>
</body>
</html>
