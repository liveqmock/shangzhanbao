<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page" %>
<%@ include file="/baseHead.jsp"%>
<html>
<head>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root }/view/js/sys/role/ctn/roleList.js"></script>
<title>角色管理列表</title>
</head>

<body style="height:100%;border-top:1px solid #D5D5D5;">
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a> 
  <b>>></b> <span><a href="${root }/role/key/queryAllRolesInfo" target="frame_main">角色管理</a></span> </div>
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
        <div><a href="###" class="btn_tianjia addRole">添加角色</a>
        <a href="###" class="btn_tianjia" id="deleteRole">删除角色</a></div>
        <a href="${root }/role/key/getAuthorityList" class="btn_tianjia" >权限功能管理</a></div>
      </div>
      <div class="hm_content">
        <form action="${root }/role/key/queryAllRolesInfo" id="roleForm" method="post">
          <table width="100%" border="0" cellspacing="1" cellpadding="1">
            <tr>
              <td width="110"><div class="td_redbg">
                  <input type="checkbox" name="allcbx" id="allcbx" style="margin:9px 0 0 0"/>
                </div></td>
              <td width="100"><div class="td_redbg">编号 </div></td>
              <td width="650"><div class="td_redbg">角色
 			 </div></td>
              <td width="300"><div class="td_redbg">操作
 			 </div></td>
            </tr>
            
            <c:forEach var="rolelist" items="${rolelist}" varStatus="status">
			<input type="hidden" value="${rolelist.id }" id="roleid"/>
			<tr style="background: #fff;" align="center">
			<td><input type="checkbox" id="cbox" name="cbox" value="${rolelist.id }"/></td>
			<td><span class="Number">${status.index+1+pageRoll.currentPage*pageRoll.pageSize }</span></td>
			<td><span>${rolelist.rolename }</span></td>
			<td>
			<a href="${root }/role/key/viewRoleInfo?id=${rolelist.id}" class="blue">查看</a>
			<span class="line_12px">|</span>
			<a href="${root }/role/key/intoRoleEditPage?id=${rolelist.id}" class="green">修改</a>
			<!--<a href="${root }/view/pages/sys/role/ctn/configRoleUser.jsp?roleID=${rolelist.id}" class="configRoleUser">配置角色</a>-->
			</td>
			</tr>
			</c:forEach>
            <tr>
              <td colspan="4"><div class="statistical">角色数量：<span>${pageRoll.totalRows }</span></div></td>
            </tr>
          </table>
          <page:PageRoll/>
        </form>
      </div>
  </div>
</div>
</div>
</body>
</html>
