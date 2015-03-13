<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账号管理 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link href="${root }/view/css/centerCss.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/userManage/userManage.js"></script>

</head>
<body>
<form action="" id="editPass" method="post" onsubmit="return checkSub($(this))">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
	<div class="UserCenter_Right"  >
		<div class="DataStatistics_1">
			<div class="DataStatistics_1Title">
				<h1>账号管理</h1>
      		</div>
      		<div style="width: 100%;">
      			<div class="LedgerDiv"  style="margin-top: 10px;">
      				<div class="control-group" style="margin-left: -100px;width: 100%">
          				<label class="control-label" style="font-size: 14px">登录账号：</label>
          				<div class="controls" style="margin-top: 7px;">${userData.loginMail }</div>
          				<span style="margin-top: 7px;">
          					<a href="${root }/user/key/toEditLoginAccount" class="font_blue" id="editLoginAccount" >修改</a>
          				</span>
        			</div>
         			<div class="control-group" id="hideDiv" style="margin-left: -100px;width: 100%">
          				<label class="control-label" style="font-size: 14px">密码：</label>
         				<div class="controls" style="margin-top: 9px;">********</div>    
            			<span style="margin-top: 7px;">
            				<a href="${root }/user/key/toEditPwd" class="font_blue" id="editLoginPwd" >修改</a>
            			</span>
           			</div>
       			</div>
      		</div>
      	</div>
	</div>
    <!-- 支付方式管理 -->
    <div class="UserCenter_Right"  >
	    <div class="DataStatistics_1" style="padding-bottom: 100px;"> 
	    	<input type="hidden" id="helpArticleCate" value='${helpArticleCate }' />
			<div  class="paytypeClass">
				<div class="DataStatistics_1Title">
					<h1>收款账号管理</h1>
      			</div>
      			<input type="hidden" id="listSize" value="${fn:length(accountNumberDataList) }" />
				<div class="divsum">
					<c:forEach var="accountNumberData" items="${accountNumberDataList }" varStatus="status">
	      			<div class="paytypeDiv" id="paytypeDiv${status.index + 1}">
						<div>
							<div style="float: left;color: red; font-size: 14px;" id="errorHtml${ status.index + 1}"></div>
							<div>
								<a href="###" onclick="editPayType(${status.index + 1})" id="edit${status.index + 1}">
									<img alt="编辑" src="${root }/images/mini/images/u70_1.png" />
								</a>
							</div>
						</div>
						<div>
      						<input type="hidden" id="accountNumberDataId${ status.index + 1}" value="${accountNumberData.id }" />
							<input type="hidden" id="userId${ status.index + 1}" value="${accountNumberData.userId }" />
							<span class="zhifuspan">收款方式：</span>
							<span>
								<select class="zhifuselect" id="accountType${ status.index + 1}">
								<c:set var="accountType" value='-1' />
								<s:iterator id="ed" value="#session.helpArticleState">
								<c:set var="accountType" value='${accountType+1 }' />
								<option value="<s:property value="#ed.key" />" <c:if test="${accountNumberData.accountType == accountType }">selected='selected'</c:if> ><s:property value="#ed.value" /></option>
								</s:iterator>
								</select>
								<label class="zhifulabel" style="display:none">${accountNumberData.accountType }</label>
							</span>
						</div>
						<div>
							<span class="zhifuspan">收款账号：</span>
							<span>
								<input type="text" id="receivableAccount${ status.index + 1}" value="${accountNumberData.receivableAccount }" class="zhifuinput" />
								<label  class="zhifulabel" style="display:none">${accountNumberData.receivableAccount }</label>
							</span>
						</div>
						<div class="divbtn" id="divbtn${ status.index + 1}" style="height: 45px;padding-top: 5px;">
							<a href="###" class="deletepay" id="delete${ status.index + 1}" onclick='deletePayType(this)'>删除</a>
							<a href="###" id="complete${ status.index + 1}" onclick='complete(${status.index + 1})' class="addpay">完成</a>
						</div>
					</div>
	      			</c:forEach>
					<div class="paytypeDiv_add">
						<div><a href="###" onclick="addpaytype()">+</a></div>
					</div>
				</div>
			</div>
		</div>
    </div>
</div>
<%@include file="/mini_end.jsp"%>
</form>
</body>
</html>
