<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<%@include file="/user_info.jsp"%>
<html>
<head>
<link href="${root }/view/css/ctn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/sys/role/ctn/roleEdit.js"></script>
</head>

<body>
<div class="wrapbg_gp">
  <div class="current">当前位置：<a href="${root }/portal/key/gotoPortal" target="frame_main" >主页</a>
   <b>>></b> <span><a href="${root }/role/key/queryAllRolesInfo" target="frame_main">角色管理</a></span> <b>>></b> <span>修改角色</span> </div>
  <div id="ContentDiv">
    <div class="HaveBeen">
      <form id="roleForm">
      <input type="hidden" id="roleid" name="roleData.id" value="${roleData.id}" />
	  <input type="hidden" name="roleData.creator" value="${roleData.creator}" />
	  <input type="hidden" name="roleData.createdate" value="${roleData.createdate}" />
        <table width="100%" border="0" cellspacing="1" cellpadding="1" class="table1">
          <tr>
            <td width="80">角色名称： </td>
            <td>
             <input name="roleData.rolename" id="rolename"  type="text" value="${roleData.rolename}" size="40" class="input_bor"
              data-placement="right"  notnull="角色名称不能为空!"/><font color="#FF0000">*</font>
           </td>
          </tr>
          <tr>
            <td>描述：</td>
            <td>
	            <textarea rows="5" cols="40" name="roleData.description" id="roleData.description"
	            class="input_bor" style="height:100px; width:400px"
				data-placement="right" max="300">${roleData.description}</textarea>
            </td>
          </tr>
          <tr>
            <td valign="top">权 限：</td>
            <td><a href="###" class="btn_tianjia addOperateAuthority">修改操作权限</a>
              <div class="clear"></div>
              <div class="juese_tab operateAuthority" style="display: none;">
                <h1><strong class="font_14px">修改操作权限</strong>（选择模块名称可选中该模块下所有功能权限）</h1>
                <c:forEach var="parentResource" items="${parentResourceList}">
	                <div class="juese_tab_div" >
	                   <div class="juese_tab_title" style="width: 130px;"> <span class="juese_input">
	                    <input type="checkbox" name="parentcbx"/>
	                    </span>${parentResource.resName } </div>
	                    <div class="juese_tab_listdiv">
		                  <c:forEach var="sonResource" items="${sonResourceList}">
		                  	<c:if test="${parentResource.id == sonResource.parentId}">
			                    <div class="juese_tab_list">
			                    	<input type="hidden" class="sonResourceId" value="${sonResource.id }"/>
			                    	<span class="juese_input">
			                         <input type="checkbox" name="soncbx" 
			                        	<c:forEach var="roleRes" items="${roleResList}">
			                        	<c:if test="${sonResource.id==roleRes.resId }">checked</c:if>
			                        	</c:forEach>
			                         />
			                        </span>${sonResource.resName }
			                    </div>
		                    </c:if>
		                  </c:forEach>
	                   </div>
	                </div>
                </c:forEach>
              </div>
              
              <div class="clear"></div><a href="###" class="btn_tianjia addSearchAuthority">修改查询权限</a>
              <div class="clear"></div>
              <div class="juese_tab searchAuthority" style="display: none;">
                <h1><strong class="font_14px">修改查询权限</strong></h1>
                <div class="juese_tab_div">
                  <div class="juese_tab_listdiv">
                  	<c:forEach var="parentResource" items="${parentResourceList}">
                    <div class="juese_tab_list">
                    	<input type="hidden" class="sonResourceId" value="${parentResource.id }"/>
                    	<span class="juese_input">
                         <input type="checkbox" name="searchcbx"
                         <c:forEach var="roleRes" items="${roleResList}">
			                 <c:if test="${parentResource.id==roleRes.resId }">checked</c:if>
			             </c:forEach>
                         />
                      	</span>${parentResource.resName }
                    </div>
                    </c:forEach>
                  </div>
                </div>
              </div>
              </td>
          </tr>
        </table> 
      </form>
    </div><div class="clear"></div>
    <div class="Btn_tab">
          <div class="btn_red" style="margin:0 0 0 50px; float:left"><a href="###" class="updateRole">保存</a></div>
          <div class="btn_red" style="margin:0 0 0 50px; float:left"><a href="###" class="cancel">取消</a></div>
        </div>
  </div>
</div>
</body>
</html>
