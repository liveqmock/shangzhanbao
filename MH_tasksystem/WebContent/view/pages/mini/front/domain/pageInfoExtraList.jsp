<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="/mini_top.jsp"%>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>域名管理 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/jquery-ui-timepicker.css" />
<script type="text/javascript" src="${root}/view/js/minipage/page/domain/pageInfoExtra.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css" />
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<style type="text/css">
table,tr,td{
font: 14px "Hevetica Neve",Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial;
}
 </style>
</head>
<body>
	<a href="###" id="myDlymDiv" style="display: none;">独立域名</a>
	<div class="head"></div>
	<div class="content">
		<a href="###" id="myDlymDiv" style="display: none;">独立域名</a>
		<%@include file="/left.jsp"%>
		
		<div class="UserCenter_Right">
			<form action="${root }/page/key/getAllPageInfo" method="post">
			<c:if test="${!empty secondLevelList}">
				<div class="DataStatistics_1">
					<div class="DataStatistics_1Title">
						<h1>我的二级域名</h1>
					</div>
					<div class="widget-content">
						<table class="table">
							<thead>
								<tr>
									<th width="120">缩略图</th>
									<th width="120">商站名称</th>
									<th width="300">域名</th>
									<th width="190">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="p" items="${secondLevelList}" varStatus="i">
									<tr>
								<td height="71" style="padding-left: 0;padding-right: 0;">
								<span style="width: 110px; height: 80px; float: right; overflow: hidden; padding: 1px; padding: 0; margin-right: 7px;">
								<c:if test="${p.pageImg==null || p.pageImg==''}">
								<img src="${root }/img/edit/main_${p.templateData.id }.jpg"  style="max-width: 100px;max-height: 61px;">
								</c:if>
								<c:if test="${p.pageImg!=null && p.pageImg!=''}"><img src="${root }${p.pageImg}"></c:if>
								</span>
								</td>
								<td width="100" >
								<span style="white-space: normal;word-break: break-all;display: block;width: 120px;margin:0 auto;">
								${p.name }
								</span>
								</td>
								<td>
								<a   style="word-wrap: break-word;width: 300px;display: block;margin: 0 auto;"   href="${p.pageInfoExtra.domain}" class="font_blue" target="_blank">${p.pageInfoExtra.domain}</a></td>
								<td><span class="span1">
								<a href="http://www.net.cn" target="_blank">购买独立域名</a></span>
								 <span class="span2">
								 <a href="#" onclick="bundlingDomain('${i.index}','${p.pageInfoExtra.pageId}')">绑定独立域名</a></span></td>
									</tr>
									<input type="hidden" id="pageId${i.index}" value="${p.id}" />
									<input type="hidden" id="pageInfoId${i.index}"
										value="${p.pageInfoExtra.id }" />
								</c:forEach>
							</tbody>
						</table>
					</div>
					<page:PageRoll/>
				</div>
			</c:if>
			</form>
			<c:if test="${empty secondLevelList}">
				<div class="DataStatistics_box">
					<h1>还没有二级域名</h1>
					<div style="margin: 10px 0 0 10px"></div>
				</div>
			</c:if>
			<c:if test="${!empty independentList}">
				<div class="DataStatistics_1">
					<div class="DataStatistics_1Title">
						<h1>我的独立域名</h1>
					</div>
					<div class="widget-content">
						<table class="table">
							<thead>
								<tr>
									<th width="45"></th>
									<th width="200">域名</th>
									<th width="100">商站名称</th>
									<th width="180">二级域名</th>
									<th width="140">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="independent" items="${independentList}"
									varStatus="i">
									<tr>
										<td><span class="span5"><img
												src="${root}/images/mini/images/domain1.png"></span></td>
										<c:forEach var="pageInfoExtra"
											items="${independent.pageInfoExtraData }" varStatus="j">
											<c:if test="${pageInfoExtra.type==1}">
												<td style="word-break: break-all"><a
													href="${pageInfoExtra.domain}" class="font_blue"
													target="_blank">${pageInfoExtra.domain}</a><input
													type="hidden" id="oneid${i.index}"
													value="${pageInfoExtra.id }" /></td>
											</c:if>
										</c:forEach>
										<td>${independent.name }</td>
										<c:forEach var="pageInfoExtra"
											items="${independent.pageInfoExtraData }">
											<c:if test="${pageInfoExtra.type==2}">
												<td><span class="span9"><a href=""
														class="font_blue">${pageInfoExtra.domain}</a></span></td>
												<input type="hidden" id="twoid${i.index}"
													value="${pageInfoExtra.id }" />
											</c:if>
										</c:forEach>
										<c:forEach var="pageInfoExtra"
											items="${independent.pageInfoExtraData }" varStatus="j">
											<c:if test="${pageInfoExtra.type==1}">

												<td align="center"><span class="span2"><a
														href="${pageInfoExtra.domain}" target="_blank">检查绑定情况</a></span>
													<span class="span2" style="font-size: 14px;"><a
														href="#" onclick="showdiv('${i.index}')"
														style="font-size: 14px;">切换绑定商站</a></span> <span class="span1"><a
														href="#" style="font-size: 14px;">查看绑定IP</a></span> <span
													class="span1"><a href="#"
														onclick="unBundlingDomain('${i.index}');"
														style="font-size: 14px;">解除绑定</a></span></td>
											</c:if>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
		<div id="bing"
			style="left: 460px; top: 300px; width: 480px; height: 300px; position: absolute; background-color: #F0F0F0; display: none;">
			<div onclick="javascript:$('#bing').fadeToggle(500); "
				style="left: 450px; top: 0px; width: 30px; height: 20px; position: absolute; cursor: pointer;">
				<font size="3" color="black">×</font>
			</div>
			</center>
			<table class="table table-striped" style="margin-top: 20px;">
				<tr>
					<td>编号</td>
					<td align="center">二级域名</td>
					<td align="center">商站名称</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach var="p" items="${secondLevelList}" varStatus="i">
					<tr>
						<td width="100">${i.index+1}</td>
						<td width="100">${p.pageInfoExtra.domain}</td>
						<td width="100">${p.name }</td>
						<td width="100"><a class="btn btn-primary" href="###"
							onclick="togglePage('${p.id}','${p.pageInfoExtra.id}');">切换</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>