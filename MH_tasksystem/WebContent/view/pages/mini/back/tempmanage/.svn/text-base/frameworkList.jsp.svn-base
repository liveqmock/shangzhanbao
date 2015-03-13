	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript"	src="${root}/view/js/jquery/jquery.form.js"></script>	
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/bootstrap-modal.js"></script>
<script type="text/javascript"	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/front/template/Template.js"></script>
<script type="text/javascript"	src="${root}/view/js/minipage/back/tempmanage/frameworkList.js"></script>
<link rel="stylesheet" type="text/css"	href="${root }/view/css/bootstrap.css" />
<link href="${root }/view/css/mini/templateShop/css/Template.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"  type="text/css" href="${root }/view/pages/mini/commonality/back.css" />
<title>模板架构</title>
</head>
<body style="height:100%;border-top:1px solid #D5D5D5;background-image: none;">
<div class="wrapbg_gp">
  <div class="current"><span>当前位置：<a href="###" target="frame_main" style="color: #2b6db4;">主页</a> <b>>></b>
<a href="${root }/temp_manage/key/searchAllToAdmin?templateData.status=1" target="frame_main" style="color: #2b6db4;">模板管理</a> </span> </div>
		</div>
  <div id="main_shop">
			<c:forEach var="componentData" items="${componentDatas }" varStatus="i">
				<div class="pic">
					<img src="${root }${componentData.pcJpgPath}">
					<div class="edit">
						<ul>
							<li>
								<h1>${componentData.name }</h1>
							</li>
							<li><font style="color: red;">设计师：</font><span>${componentData.creator }</span></li>
							<li><font>布局：</font><span>一栏</span></li>
							<li><font>价格：</font><span> <c:if
										test="${componentData.price==null }">
										<td>免费</td>
									</c:if> <c:if test="${componentData.price!=null }">
										<td>${componentData.price }</td>
									</c:if>
							</span></li>
							<li><font>支持设备：</font><span><img
									src="${root }/images/mini/templateShop/images/icon_0.png"
									width="167" height="51"></span></li>
							<li>
								<p>
									<span
										class="btn_orange"><a href="###" data="${componentData.id }" class="userFrame">使用</a></span>
								</p>
							</li>
						</ul>
					</div>
					<c:if test="${i.index !=0 && i.index%2 != 0 }">
						<br>
					</c:if>
				</div>
			</c:forEach>
		</div>
</body>
</html>