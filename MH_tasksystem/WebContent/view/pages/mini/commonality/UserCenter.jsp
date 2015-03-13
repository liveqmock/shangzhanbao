<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="/mini_top.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tag/PageTag.tld" prefix="page"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商站宝平台</title>
<link rel="stylesheet" type="text/css"
	href="${root}/view/css/mini/UserCenter.css" />
</head>
<body style="overflow: auto">
	<div class="head"></div>
	<form id="fileFrom" method="post" enctype="multipart/form-data"
		action="">
		<div class="content">
			<%@include file="/left.jsp"%>
			<script type="text/javascript"
				src="${root}/view/js/charts/jquery.1.9.1.min.js"></script>
			<script type="text/javascript"
				src="${root}/view/js/charts/highcharts.js"></script>
			<script type="text/javascript"
				src="${root}/view/js/minipage/front/management/userCenter.js"></script>
			<script type="text/javascript"
				src="${root}/view/js/minipage/front/pageManage/pageManage.js"
				type="text/javascript"></script>
			<script type="text/javascript"
				src="${root}/view/js/minipage/front/product/productList.js"
				type="text/javascript"></script>
			<script type="text/javascript"
				src="${root}/view/js/minipage/front/analysis/pageanalysis.js"></script>

			<div class="UserCenter_Right">
				<div class="DataStatistics_1">
					<div class="DataStatistics_1Title">
						<h1>昨日数据分析</h1>
						<div class="DataStatistics_1Title_r">
							<div class="font_list">
								<a href="#" onclick="findByTime('threemouth','近3个月')"
									class="font_blue">近3个月</a>
							</div>
							<div class="font_list">
								<a href="#" onclick="findByTime('onemouth','近1个月')"
									class="font_blue">近1个月</a>
							</div>
							<div class="font_list">
								<a href="#" onclick="findByTime('','近1周')" class="font_blue">近1周</a>
							</div>
							<div class="font_list">
								<a href="#" onclick="findByTime('hour','近一天')" class="font_blue">昨日</a>
							</div>
							<%--  <div class="font_form">自定义时间
         <input type="text" class="input_bg1" id="starttime" value="${starttime }" size="8">  至
            <input type="text" class="input_bg1" id="endtime" value="${endtime}" size="8">
            <input name="" onclick="findByTime();" value="确定" type="button" class="btn_confirm">
          </div> --%>
						</div>
					</div>
					<div class="DataStatistics_1_CL">
						<ul>
							<%--  <li><a href="#" class="font_blue">访客数<span id="visitNum"></span></a></li>
          <li><a href="#" class="font_blue">浏览量<span id="viewNum"></span></a></li> --%>
							<li><a href="#" class="font_blue"><span id="viewNum"></span><font
									id="showFont">近1周流量</font></a></li>
							<%--  <li><a href="#" class="font_blue">平均停留时间<span>02:50</span></a></li>
          <li><a href="#" class="font_blue">动作转化率<span>37.12%</span></a></li> --%>
						</ul>
					</div>
					<div class="DataStatistics_1_CR">
						<h1 id="showInfo">近1周数据趋势</h1>
						<!-- <h2><a href="#" class="font_blue">查看变化趋势</a></h2> -->
						<div id="oneweek" class="NubTab"></div>
					</div>
				</div>
				<div class="DataStatistics_1">
					<div class="DataStatistics_1Title">
						<h1>已经创建的Page</h1>
						<div style="float: right;">

							<span><a href="${root }/page_manage/key/getAllPaga?menuNum=1">全部</a></span>

						</div>
					</div>

					<c:forEach var="pageData" items="${pageDataList}" step="3">
						<c:if test="${ pageData.status!=2}">
							<div class="DataStatistics_2" id="${pageData.id}">
								<h1>
									<img src="${root }/view/model/images/zanwu.jpg">
								</h1>
								<ul>
									<li>
										<h2>${pageData.name}<span>设置</span></h2>
            <h3><span><a href="#" class="font_blue">${pageData.pageInfoExtra.domain}</a><font>
										
											
													  <c:if
														test="${pageData.use==1 && pageData.state==0 &&pageData.status!=2}">试用 </c:if>
													<c:if test="${pageData.use==0 && pageData.status==0}">暂存</c:if>
													<c:if test="${pageData.use==2}">异常数据</c:if> <c:if
														test="${pageData.use==0 && pageData.status==1 &&pageData.status!=2}">过期</c:if>
													<c:if test="${ pageData.status==2}">禁用 </c:if>
											</font>
											</span>
										</h3> <c:if test="${pageData.status!=2}">
											<%-- <p>
												<font class="black"><a href="#">可信网站</a></font> <font><a
													href="#">在线客服</a></font> <font><a href="#">数据分析</a></font> <font><a
													href="###" onclick="duliYuMing('${pageData.id}')">独立域名</a></font>
											</p> --%>
											<%-- <dl>
												<dt>
													访客数<span>${pageData.accesstatisticsData.fKS}</span>
												</dt>
												<dt>
													浏览量<span>${pageData.accesstatisticsData.lLL}</span>
												</dt>
												<dt>
													平均停留时间<span>02:55</span>
												</dt>
												<dt>
													动作转化率<span>26.20%</span>
												</dt>
												
											</dl> --%>
											<dl>
									             <dt><a href="#"><span>${pageData.accesstatisticsData.lLL}</span>近1周流量</a></dt>
									     
									           </dl>
										</c:if>
									</li>
									<c:if test="${pageData.status==2}">
										<figuer>
										<p>该商站已被管理员禁用，禁用原因是：</p>
										<p>
											<span>禁用原因:${disabledType[pageData.disabledType]}</span> <span>禁用备注说明:
												${pageData.disabledReason}</span>
										</p>
										<p>如有问题，请咨询管理员 400-666-3999</p>
										</figuey>
									</c:if>
								</ul>
								<div class="DataStatistics_2_line"></div>
								<div class="RBtnTab">
									<span class="fontR"> <a href="###"
										onclick="extraUpdate('${pageData.pageInfoExtra.id}','${pageData.id}','${pageData.pageInfoExtra.type}','${pageData.pageInfoExtra.domain}','${pageData.name}')">设置</a><br>
									</span> <span> <c:if test="${pageData.state==0}">
											<a class="btn_blue" href="###"
												onclick="shengjiQuanXian('${pageData.id}')">升级发布权限</a>
											<br>
										</c:if>
									</span> <span> <c:if
											test="${pageData.state==1 && pageData.use==0}">
											<a class="btn_blue" href="###"
												onclick="xuFeiQuanXian('${pageData.id}')">续费</a>
											<br>
										</c:if>
									</span> <span><a class="btn_blue"
										href="${root }/page_manage/key/toedit?id=${pageData.id}"
										target="_parent">编辑page</a></span> <span> <c:if
											test="${pageData.status==0}">
											<a class="btn_blue"
												href="${root }/page_manage/key/updatePageData?pageData.id=${pageData.id}&pageData.ymId=${pageData.pageInfoExtra.id}">发布page</a>
											<br>
										</c:if>
									</span> <span class="fontR"> <c:if test="${pageData.status!=1}">
											<a href="###" onclick="deletePaga('${pageData.id}')">删除</a>
										</c:if>
									</span>
								</div>
								<div class="clear"></div>
								<div class="listDiv">
									<ul>
										<li><img
											src="${root }${pageData.templateThumbnailData.path}"> <span>
												<a href="#" class="font_blue">${pageData.templateData.name}</a>
										</span></li>
										<c:forEach items="${pageData.pageServiceDataList}"
											var="service">
											<li><img src=""> <span> <a href="#"
													class="font_blue">${service.name}</a>
											</span></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<%--       <page:PageRoll/> --%>
				</div>

				<%-- <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>已购买的服务</h1>
        <span><a href="#" class="font_blue">全部</a></span> </div>
      <div class="DataStatistics_3">
        <ul>
          <li><span><img src="images/list.jpg"></span><font>可信网站认证服务</font></li>
        </ul>
      </div>
    </div>
  </div>
</div> --%>

				<div class="DataStatistics_1">
					<div class="DataStatistics_1Title">
						<h1>已购买的服务</h1>
						<span><a href="#" class="font_blue">全部</a></span>
					</div>
				</div>
				<div class="widget-content">
					<table class="table">
						<thead>
							<tr>
								<th width="55"></th>
								<th>服务名称</th>
								<th width="160">有效期</th>
								<th>使用PAGE</th>
								<th width="190">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pageProductData" items="${list }">
								<c:if test="${pageProductData.decide==1}">
									<tr>
										<td><span class="span5"></span></td>
										<td><span class="span6">${pageProductData.productData.name
												}</span></td>
										<td><span class="font_EN"> <fmt:formatDate
													value="${pageProductData.createTime}" type="date" /> - <fmt:formatDate
													value="${pageProductData.expireTime}" type="date" />

										</span></td>
										<td><span class="font_blue">${pageProductData.pageData.name
												}</span></td>
										<!-- 正常使用 -->
										<c:if
											test="${pageProductData.decide==1 && pageProductData.isdelete==1}">
											<td><span class="span3"></span><span class="span1"><a
													href="#">使用中</a></span> <c:if
													test="${pageProductData.isdelete==1}">
													<span class="span4"><a href="###"
														onclick="extraUpdate('${pageProductData.id}','${pageProductData.count}')"
														class=" font_blue">停用</a></span>
												</c:if></td>
										</c:if>
										<!-- 30天到期 -->
										<c:if
											test="${pageProductData.decide==3 && pageProductData.isdelete==1}">
											<td><span class="span3">30天到期</span><span class="span2"><a
													href="#">续费</a></span> <c:if test="${pageProductData.isdelete==1}">
													<span class="span4"><a href="###"
														onclick="extraUpdate('${pageProductData.id}','${pageProductData.count}')"
														class=" font_blue">停用</a></span>
												</c:if></td>

										</c:if>
										<!-- 启用 -->
										<c:if test="${pageProductData.isdelete==0}">
											<td><span class="span3"></span><span class="span2"><a
													href="#" class=" font_blue"
													onclick="openPageproduct('${pageProductData.id}','${pageProductData.productData.type}')">启用</a></span></td>
										</c:if>

									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="footer"></div>

			<!-- 独立域名不存在弹出层 -->
			<div
				style="display: none; width: 500px; height: 300px; position: absolute; margin-top: 700px; margin-left: 450px; box-shadow: 2px 2px 30px #909090;"
				class="DataStatistics_1Title domainDiv">
				<a href="#" onclick="closedomainDiv()"
					style="float: right; margin-top: -10px;">关闭</a>

				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">绑定独立域名</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 120px; position: absolute;">
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">1.
										请先去域名服务提供商申请一个独立域名</p>
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">2.
										如果你已申请或者有备用域名，请在下面输入域名：</p>
									<input type="text" value="" id="didomain" name=""
										style="width: 350px; height: 40px; margin-left: -50px; margin-top: 10px;">
								</div>
							</div>

						</td>
					</tr>
					<!-- 	<tr >
			<tr style="height: 8px;"></tr>
			<tr><td><h3>绑定独立域名</h3></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>1. 请先去域名服务提供商申请一个独立域名</td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>2. 如果你已申请或者有备用域名，请在下面输入域名：</td></tr>
			<tr style="height: 20px;"></tr>
			<tr><td> <input type="text" value="" id="didomain" name="" style="width: 400px;height: 40px;margin-left: 50px;"> </td></tr>
			<tr></tr>
			<tr style="height: 20px;"></tr> -->
					<tr>
						<td><input type="button" value="提交"
							onclick="submitDuLiYuMing()"
							style="width: 400px; height: 40px; margin-left: 50px; margin-top: 150px; background-color: #444444; color: #ffffff;">
						</td>
					</tr>
					<tr style="height: 10px;"></tr>

					<tr style="height: 10px;"></tr>
					<tr>
						<td>
							<h5>推荐域名服务提供商：</h5>
						</td>
					</tr>
					<tr style="height: 10px;"></tr>

					<tr>
						<td><a href="##" style="color: blue;">百度</a> &nbsp; &nbsp;
							&nbsp; <a href="##" style="color: blue;">谷歌</a></td>
					</tr>
				</table>
			</div>

			<!-- 独立域名存在弹出层 -->
			<div
				style="display: none; width: 500px; height: 250px; position: absolute; margin-top: 700px; margin-left: 400px; box-shadow: 2px 2px 30px #909090;"
				class="DataStatistics_1Title domainYesDiv">
				<a href="#" onclick="closedomainYesDiv()"
					style="float: right; margin-top: -10px;">关闭</a>
				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">独立域名</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;">
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">该商站已绑定独立域名</p>

								</div>
							</div>

						</td>
					</tr>

					<tr>
						<td><input type="button" value="检查绑定情况" id=""
							style="width: 400px; height: 40px; margin-left: 50px; background-color: #444444; margin-top: 160px; color: #ffffff;">
						</td>
					</tr>
					<tr></tr>
				</table>
			</div>


			<!--设置 独立域名弹出层 -->
			<div
				style="box-shadow: 2px 2px 30px #909090; display: none; width: 500px; height: 250px; position: absolute; margin-top: 700px; margin-left: 400px;"
				class="DataStatistics_1Title SZDLdomainDiv">
				<a href="#" onclick="closeSZDLdomainDiv()"
					style="float: right; margin-top: -10PX;">关闭</a>
				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">独立域名设置</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;">
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										page名称:<input type="text" value="" id="pageNameDlym" name=""
											style="width: 240px; height: 30px; margin-left: 10PX;">
									</p>
									<P
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										独立域名: <label id="dlym" style="margin-left: 0px;"></label>
									</P>
								</div>
							</div>

						</td>
					</tr>
					<!-- 	<tr style="height: 8px;"></tr>
			<tr><td><h1>独立域名设置</h1></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>page名称:<input type="text" value="" id="pageNameDlym" name="" style="width: 300px;height: 40px;margin-left: 50px;"></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>独立域名: <span id="dlym" style="margin-left: 50px;"></span> </td></tr>
			<tr></tr>
			<tr><td>  </td></tr>
			<tr></tr> -->
					<tr>
						<td><input type="button" value="提交" onclick="submitSZDLYU()"
							style="width: 400px; height: 40px; margin-left: 50px; background-color: #444444; margin-top: 160px; color: #ffffff;">
						</td>
					</tr>
					<tr></tr>
				</table>
			</div>



			<!--设置 二级域名弹出层 -->
			<div
				style="box-shadow: 2px 2px 30px #909090; display: none; width: 500px; height: 250px; position: absolute; margin-top: 700px; margin-left: 400px;"
				class="DataStatistics_1Title SZEJdomainDiv">
				<a href="#" onclick="closeSZEJdomainDiv()"
					style="float: right; margin-top: -10px;">关闭</a>
				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">二级域名设置</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;">
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										page名称:<input type="text" value="" id="pageNameEjym" name=""
											style="width: 240px; height: 30px; margin-left: 10PX;">
									</p>
									<P
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										二级域名：<label id="ejym" style="margin-left: -0px;"></label> <input
											type="hidden" id="helpYm" name="" value=""
											style="width: 100px; height: 40px;">
									</p>
								</div>
							</div>

						</td>
					</tr>
					<!-- 	<tr style="height: 8px;"></tr>
			<tr><td><h1>二级域名设置</h1></td></tr>
			<tr style="height: 20px;"></tr>
			<tr><td>page名称:<input type="text" value="" id="pageNameEjym" name="" style="width: 300px;height: 40px;margin-left: 50px;"></td></tr>
			<tr style="height: 8px;"></tr>
			<tr>
			<td>二级域名：<span id="ejym" style="margin-left: 50px;"></span>
			     <input type="hidden" id="helpYm" name="" value="" style="width: 100px;height: 40px;">
			</td></tr>
			<tr></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr><td>  </td></tr>
			<tr></tr> -->
					<tr>
						<td><input type="button" value="提   交"
							onclick="submitEjYuMing()"
							style="width: 400px; height: 40px; margin-left: 50px; background-color: #444444; margin-top: 160px; color: #ffffff;">
						</td>
					</tr>
					<tr></tr>
				</table>
			</div>

			<!--设置 Page名称及二级域名设置 -->
			<div
				style="box-shadow: 2px 2px 30px #909090; display: none; width: 500px; height: 250px; position: absolute; margin-top: 700px; margin-left: 400px;"
				class="DataStatistics_1Title name_pageDom">
				<a href="#" onclick="closedname_pageDom()"
					style="float: right; margin-top: -10px;">关闭</a>
				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">Page名称及二级域名设置</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;">
									<p
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										page名称:<input type="text" value="" class="pageNmae" name=""
											style="width: 300px; height: 30px;">
									</p>
									<P
										style="text-align: left; margin-left: -50px; margin-top: 5px;">
										二级域名:http://www.minipage.com/michelle/<input type="text"
											value="" class="pageDom" name=""
											style="width: 300px; height: 30px; margin-left: 50px; margin-top: 10px;">
										<span id="dlym" style="margin-left: 50px;"></span>
									</p>
								</div>
							</div>

						</td>
					</tr>
					<!-- <tr style="height: 8px;"></tr>
			<tr><td><h1>Page名称及二级域名设置</h1></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>page名称:<input type="text" value="" class="pageNmae" name="" style="width: 300px;height: 40px;margin-left: 50px;"></td></tr>
			<tr style="height: 8px;"></tr>
			<tr><td>二级域名:http://www.minipage.com/michelle/<input type="text" value="" class="pageDom" name="" style="width: 200px;height: 40px;margin-left: 10px;"> <span id="dlym" style="margin-left: 50px;"></span> </td></tr>
			<tr></tr>
			<tr><td>  </td></tr>
			<tr style="height: 40px;"></tr> -->
					<tr>
						<td><input type="button" value="提交" id="name_pageDomonclick"
							onclick="pageDomonclick()"
							style="width: 400px; height: 40px; margin-left: 50px; background-color: #444444; margin-top: 160px; color: #ffffff;">
						</td>
					</tr>
					<tr></tr>
				</table>
			</div>
			<input type="hidden" id="repageId" value="">

			<!-- 服务 -->



			<!-- 停用原因div -->

			<div
				style="box-shadow: 2px 2px 30px #909090; margin-left: 300px; width: 400px; height: 200px; display: none; position: absolute;"
				id="pwdDiv" class="DataStatistics_1Title ">
				<a href="#" onclick="closedDiv1()"
					style="float: right; margin-top: -10px;">关闭</a>
				<!-- <form  id="disForm" method="post"> -->
				<table>
					<tr>
						<td>
							<div style="margin-top: 20px; margin-left: 30px;">
								<select style="width: 100px;" name="pageProductData.stopType"
									id="stopType">
									<s:iterator id="yy" value="#session.stopType">
										<option value="<s:property value="#yy.key"/>">
											<s:property value="#yy.value" />
										</option>
									</s:iterator>

								</select>
							</div>
						</td>
						<td><div style="margin-top: px;">
								<textarea rows="7" cols="28" style="resize: none;"
									name="pageProductData.stopDesc" id="stopDesc"></textarea>
							</div></td>
					</tr>
					<tr>
						<td>
							<div style="margin-top: 5px; margin-left: 100px;">
								<input type="button" name="updatesubmit" value="提交修改"
									class="submit" id="updatesubmit" />
							</div>
						</td>
					</tr>
				</table>
				<!-- 	</form> -->
			</div>

			<!-- 停用原因div -->

			<!-- 询问是否停用 -->
			<div
				style="display: none; width: 500px; height: 300px; position: absolute; margin-left: 500px; box-shadow: 2px 2px 30px #909090;"
				id="daDiv" class="DataStatistics_1Title">
				<a href="#" onclick="closedDiv()"
					style="float: right; margin-top: -10px;">关闭</a> <font
					style="font-size: 22px; left: 30px; top: 20px; position: absolute;">停用“在线客服”</font>
				<div class="DataStatistics_1"
					style="left: 50px; top: 80px; width: 400px; height: 100px; position: absolute;">
					<div
						style="left: 80px; top: 10px; width: 400px; height: 100px; position: absolute;">
						<p style="text-align: left; margin-left: -50px; color: red;">该服务是你商站上唯一个营销动作了，如果去掉将无法与客户联系。</p>
						<div>你确定要停用吗？</div>
					</div>
				</div>
				<!-- 		<div  style="left: 50px; top: 180px; width: 480px; height: 100px; position: absolute;"></div> -->

				<table style="margin-top: 150px; margin-left: 30px;">
					<tr style="height: 40px;"></tr>
					<tr>
					<tr></tr>
					<tr>
						<td><input type="button" value="取消"
							style="width: 180px; height: 40px; background-color: #DDDDDD; margin-left: 30px;"
							onclick="quxiao()"> <input type="button" value="确定"
							style="width: 180px; height: 40px; background-color: #444444; color: #ffffff;"
							id="queding"></td>
					</tr>
					<tr></tr>


				</table>

			</div>
			<!-- 询问是否停用-->
			<!-- 啟用成功彈出div -->
			<div
				style="display: none; width: 500px; height: 150px; position: absolute; margin-left: 500px; box-shadow: 2px 2px 30px #909090;"
				id="opendiv" id="daDiv" class="DataStatistics_1Title">
				<a href="#" onclick="closedDiv2()"
					style="float: right; margin-top: -10px;">关闭</a>

				<table>
					<tr style="height: 8px;"></tr>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">启用成功！</font></td>
					</tr>

					<tr style="height: 40px;"></tr>
					<tr>
					<tr></tr>
					<td><input type="button" value="查看商站效果"
						style="width: 180px; height: 40px; background-color: #DDDDDD; margin-left: 30px;"
						onclick=""> <input type="button" value="继续管理服务"
						style="width: 180px; height: 40px; background-color: #444444; color: #ffffff;"
						id="managePr"></td>
					</tr>
					<tr></tr>


				</table>

			</div>



			<!-- 启用成功1div -->
			<div
				style="display: none; width: 500px; height: 250px; position: absolute; margin-left: 500px; box-shadow: 2px 2px 30px #909090;"
				id="fileDiv" class="DataStatistics_1Title">
				<a href="#" onclick="closedfile()"
					style="float: right; margin-top: -10px;">关闭</a>
				<table style="margin-top:; margin-left: 30px;">
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">启用“实名网站认证”</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 80px; width: 400px; height: 60px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 60px; position: absolute;">
									<p style="text-align: left; margin-left: -50px;">请上传标识文件：</p>
									<p style="text-align: left; margin-left: -50px;">
										<input type="file" name="imgFile" id="imgFile" />
									</p>
								</div>
							</div>

						</td>
					</tr>

					<tr>

						<td><input type="submit" value="ok,启用"
							style="width: 400px; height: 40px; background-color: #444444; margin-left: 20px; margin-top: 150px; color: #ffffff;"
							id="filesub"></td>
					</tr>
					<tr></tr>


				</table>

			</div>

			<!-- 启用成功2div -->
			<div
				style="display: none; width: 500px; height: 280px; position: absolute; margin-left: 500px; box-shadow: 2px 2px 30px #909090;"
				id="phoneDiv" class="DataStatistics_1Title">
				<a href="#" onclick="closedphone()"
					style="float: right; margin-top: -10px;">关闭</a>
				<table>
					<tr>
						<td><font
							style="font-size: 22px; left: 30px; top: 20px; position: absolute;">启用“拨打销售电话”</font>
						</td>
					</tr>

					<tr>
						<td>
							<div class="DataStatistics_1"
								style="left: 50px; top: 80px; width: 400px; height: 120px; position: absolute;">
								<div
									style="left: 80px; top: 10px; width: 400px; height: 120px; position: absolute;">
									<p style="text-align: left; margin-left: -50px;">请输入销售电话号码：</p>
									<p style="text-align: left; margin-left: -50px;">
										<input type="text" style="height: 38px; width: 300px;"
											class="phone">
									</p>
								</div>
							</div>

						</td>
					</tr>
					<tr>

						<td><input type="button" value="ok,启用"
							style="width: 400px; height: 40px; background-color: #444444; margin-left: 50px; margin-top: 170px;"
							id="" onclick="openPhone() "></td>
					</tr>
					<tr></tr>


				</table>

			</div>
		</div>
	</form>
</body>
</html>
