<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/sys/role/ctn/roleView.js"></script>
</head>

<body>
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a>
   <b>>></b> <span><a href="${root }/role/key/queryAllRolesInfo" target="frame_main">角色管理</a></span> <b>>></b> <span>查看角色</span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form action="" method="get">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
          <tr>
            <td width="70">角色名称： </td>
            <td>${roleData.rolename}</td>
          </tr>
          <tr>
            <td>描述：</td>
            <td>${roleData.description}</td>
          </tr>
          <tr>
            <td valign="top">权 限：</td>
            <td style="margin-left: 100px;"><div class="juese_tab" style="width: 1050px;" >
                <h1><strong class="font_14px">操作权限 </strong></h1>
                <c:forEach var="oneRoleRes" items="${oneRoleResList}" varStatus="status">
                <c:if test="${oneRoleRes.resourceData.resType=='URL'&&status.index==0}">
                <div class="juese_tab_div">
                  <div class="juese_tab_title"> <span class="juese_input"> </span>${map[oneRoleRes.resourceData.parentId]}</div>
                  <div class="juese_tab_listdiv">
                  <c:forEach var="roleRes" items="${oneRoleResList}">
                  	<c:if test="${roleRes.resourceData.resType=='URL'}">
                    <div class="juese_tab_list"><span class="juese_input"> </span>${roleRes.resourceData.resName }</div>
                    </c:if>
                  </c:forEach>
                  </div>
                </div>
                </c:if>
                </c:forEach>
              </div>
              <div class="clear"></div>
              <div class="juese_tab" style="width: 1050px;">
                <h1><strong class="font_14px">查询权限</strong></h1>
                <div class="juese_tab_div">
                  <div class="juese_tab_listdiv">
                  	<c:forEach var="oneRoleRes" items="${oneRoleResList}" varStatus="status">
                	<c:if test="${oneRoleRes.resourceData.resType=='模块'}">
                    <div class="juese_tab_list"><span class="juese_input"> </span>${oneRoleRes.resourceData.resName }</div>
                    </c:if>
               		</c:forEach>
                  </div>
                </div>
              </div>
             </td>
          </tr>
          <tr>
           <td colspan="2" align="center">
           <div class="Btn_tab">
	          <div class="btn_hui" style="margin:0 10px; float:left"><a href="###" class="cancel">关闭</a></div>
	       </div>
		   </td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</div>
</body>
</html>
