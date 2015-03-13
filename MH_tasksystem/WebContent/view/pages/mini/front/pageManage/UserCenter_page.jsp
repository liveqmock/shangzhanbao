<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的商站 - 商站宝</title>
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript"	src="${root}/view/js/minipage/front/pageManage/pageManage.js"></script>
<script type="text/javascript"	src="${root}/view/pages/mini/page/preview/js/preview_main.js"></script>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
</head>
<body>
<a href="###" id="myOpDiv" style="display:none;">设置</a>
<a href="###" id="myDlymDiv" style="display:none;">独立域名</a>
<a href="###" id="fabuquanxian" style="display:none;">购买发布权限</a>
<a href="###" id="sjfbquanxian" style="display:none;">升级发布权限</a>
<a href="###" id="sjfbquanxiancg" style="display:none;">升级发布权限</a>
<a href="###" id="fabu" style="display:none;">设置</a>
<a href="###" id="ZingDivA" style="display:none;">分享给小伙伴</a>
<a href="###" id="copyPageDiv" style="display:none;">另存</a>
	<div class="head"></div>
	 <form action="${root }/page_manage/key/getAllPaga" method="post">
	<input type="hidden" value="${status}" name="pageData.status">
		<div class="content">
			<%@include file="/left.jsp"%>
			<div class="UserCenter_Right">
				<!-- page为空时  立即创建page -->
				<c:if test="${pageDataList=='[]'&& empty pageData.status}">
					<div class="DataStatistics_box">
		        		<h1>还未创建商站，请点击 </h1>
		      	 		<div style="margin:10px 0 0 10px"></div>
		      	 	<a href="${root }/page_manage/key/toCreatePage?id=ff808081461cf1ef01461dd929f501fd&userData.id="" class="btn_blue"   style="margin-left: 10px;margin-top: 20px;">立即创建</a>
		     		</div>
				</c:if>
				<c:if test="${pageDataList=='[]'&& pageData.status==1}">
				<div class="DataStatistics_1Title">
							<h1>商站管理</h1>
							<div>
								<c:if test="${pageDisNum!= 0 }">
								<span><a id="changeClass_4" href="${root }/page_manage/key/getAllPaga?pageData.status=2" class="${pageData.status==2?'font_blue':'' }">已禁用</a></span>
								</c:if>
								<span><a id="changeClass_3" href="${root }/page_manage/key/getAllPaga?pageData.status=0" class="${pageData.status==0?'font_blue':'' }">暂存</a></span>
								<span><a id="changeClass_2" href="${root }/page_manage/key/getAllPaga?pageData.status=1" class="${pageData.status==1?'font_blue':'' }">已发布</a></span> 
								<span><a id="changeClass_1" href="${root }/page_manage/key/getAllPaga" class="${pageData.status=='' || pageData.status==null && (pageData.status!=0 && pageData.status!=1 && pageData.status!=2)?'font_blue':'' }">全部</a></span>
							</div>
				</div>
				<div class="DataStatistics_box" style="margin-top: 40px;">
		        	<h1>还没有已发布的商站</h1>
		      	 	<div style="margin:10px 0 0 10px;"></div>
		     	</div>
				</c:if>
				<c:if test="${pageDataList=='[]'&& pageData.status==0}">
				<div class="DataStatistics_1Title">
							<h1>商站管理</h1>
							<div>
								<c:if test="${pageDisNum!= 0 }">
								<span><a id="changeClass_4" href="${root }/page_manage/key/getAllPaga?pageData.status=2" class="${pageData.status==2?'font_blue':'' }">已禁用</a></span>
								</c:if>
								<span><a id="changeClass_3" href="${root }/page_manage/key/getAllPaga?pageData.status=0" class="${pageData.status==0?'font_blue':'' }">暂存</a></span>
								<span><a id="changeClass_2" href="${root }/page_manage/key/getAllPaga?pageData.status=1" class="${pageData.status==1?'font_blue':'' }">已发布</a></span> 
								<span><a id="changeClass_1" href="${root }/page_manage/key/getAllPaga" class="${pageData.status=='' || pageData.status==null && (pageData.status!=0 && pageData.status!=1 && pageData.status!=2)?'font_blue':'' }">全部</a></span>
							</div>
					</div>
					<div class="DataStatistics_box" style="margin-top: 40px;">
		        		<h1>还没有暂存的商站</h1>
		      	 		<div style="margin:10px 0 0 10px"></div>
		     		</div>
				</c:if>
				<c:if test="${pageDataList!='[]'}">
					<div class="DataStatistics_1">
						<div class="DataStatistics_1Title">
							<h1>商站管理</h1>
							<div>
								<c:if test="${pageDisNum!= 0 }">
								<span><a id="changeClass_4" href="${root }/page_manage/key/getAllPaga?pageData.status=2" class="${pageData.status==2?'font_blue':'' }">已禁用</a></span>
								</c:if>
								<span><a id="changeClass_3" href="${root }/page_manage/key/getAllPaga?pageData.status=0" class="${pageData.status==0?'font_blue':'' }">暂存</a></span>
								<span><a id="changeClass_2" href="${root }/page_manage/key/getAllPaga?pageData.status=1" class="${pageData.status==1?'font_blue':'' }">已发布</a></span> 
								<span><a id="changeClass_1" href="${root }/page_manage/key/getAllPaga" class="${pageData.status=='' || pageData.status==null && (pageData.status!=0 && pageData.status!=1 && pageData.status!=2)?'font_blue':'' }">全部</a></span>
							</div>
						</div>
						<c:forEach var="pageData" items="${pageDataList}">
							<div class="DataStatistics_2" id="${pageData.id}">
						  <div style="width: 270px;height: 190px;float: left;padding: 12px;padding-top: 0px;" class="divH1"> 
							<div style="width: 270px;height: 190px;">
							<h1>
								<c:if test="${pageData.pageImg==null || pageData.pageImg==''}">
								<img src="${root }/img/edit/main_${pageData.templateData.id }.jpg" >
								</c:if>
								<c:if test="${pageData.pageImg!=null && pageData.pageImg!=''}"><img src="${root }${pageData.pageImg}"></c:if>
							</h1> 
							</div>
							<img alt="" src="">
					<c:if test="${pageData.status==1 }">
					<a class="share" data="${pageData.id}" data1="${path}${pageData.pageInfoExtra.domain}" data2="${pageData.name}" data3="${pageData.zing}" style="color: #999999;text-decoration: none;" >
					<img src="${root}/view/images/zing/u4.png" class="pageShare_a"  data="${pageData.id}" data1="${path}${pageData.pageInfoExtra.domain}">
					 <p  class="pageShare_p">分享给小伙伴</p> 
					</a>
					</c:if>
							</div>
							<div onmouseout="downPageName('${pageData.id }')" onmousemove="overPageName('${pageData.id }')">
								<ul style="white-space: normal; word-break: break-all; overflow: hidden;">
									<li>
										<h2>
											<c:if test="${empty pageData.name }">
												<label style="color: red; word-break: normal;float: left;display: block;overflow: hidden;max-width: 200px;">未设置名称</label>
											</c:if>
											<label style="word-break: normal;float: left;color: black;display: block;overflow: hidden;max-width: 200px;" title="${pageData.name}">${pageData.name}</label> 
											<input type="hidden" value="${path }${pageData.pageInfoExtra.domain}" class="pageDomain_${pageData.id }">
												  <input type="hidden" value="${pageData.name}" class="pageName_${pageData.id }">
											<c:if test="${empty pageData.pageInfoExtra.domain}">
												<c:if test="${empty pageData.name}">
													<a style="display: block;float: right;width: 50px;height: 30px;font-size: 14px;margin-top: 5px;" href="###" class="pageHref" onclick="extraUpdate('${pageData.pageInfoExtra.id}','${pageData.id}','${pageData.pageInfoExtra.type}','${pageData.pageInfoExtra.domain}','${pageData.name}')">设置</a>
												</c:if>
											</c:if>
											<c:if test="${!empty pageData.pageInfoExtra.domain}">
												<c:if test="${ !empty pageData.name}">
													<a style="display: block;float: right;width: 50px;height: 30px;font-size: 14px;margin-top: 5px;" href="###" class="pageHref_${pageData.id }" onclick="extraUpdate('${pageData.pageInfoExtra.id}','${pageData.id}','${pageData.pageInfoExtra.type}','${pageData.pageInfoExtra.domain}','${pageData.name}')"></a>
												</c:if>
											</c:if>
										</h2> <br />
										<h3>
											<span style="min-height: 30px;display: block;"> 
												<c:if test="${pageData.pageInfoExtra.domain=='' }">
													<span class="font_blue"> ${path}<label style="color: red;">未设置</label></span>
												</c:if> 
												<c:if test="${pageData.pageInfoExtra.domain!='' }">
													<c:if test="${pageData.pageInfoExtra.type=='2' }">
														<a href="${path }${pageData.pageInfoExtra.domain}?a=<%=new Date()%>" target="_blank" class="font_blue"> ${path }${pageData.pageInfoExtra.domain} </a>
													</c:if> 
													<c:if test="${pageData.pageInfoExtra.type=='1' }">
														<a href="${pageData.pageInfoExtra.domain}?a=<%=new Date()%>" target="_blank" class="font_blue">${pageData.pageInfoExtra.domain} </a>
													</c:if> 
												</c:if> 
												<font style="margin-left: 10px;"> 
													<c:if test="${pageData.state!=1 && pageData.status==1 && pageData.use==1 && pageData.pageInfoExtra.domain!='' && pageData.pageInfoExtra.domain!=null}">
														<label style="color: red;">试用</label>
													</c:if>
													<c:if test="${pageData.use==0}">
														<label style="color: red;">过期</label>
													</c:if>
												</font>
											</span>
										</h3> 
										<c:if test="${pageData.status!=2}">
											<dl style="margin-left: 0px">
												<dt>
													<a href="${root }/accesstatistics/key/JumpToJsp?menuNum=2&sign=week&pageDataId=${pageData.id}&pageDataName=${pageData.name}"><span>${pageData.accesstatisticsData.lLL}</span>近1周流量</a>
												</dt>
											</dl>
										</c:if>
									</li>
									<c:if test="${pageData.status==2}">
										<figuey>
										<p>该商站已被管理员禁用，禁用原因是：</p>
										<p>
											<span>禁用原因:${disabledType[pageData.disabledType]}</span> 
											<span>禁用备注说明:${pageData.disabledReason}</span>
										</p>
										<p>如有问题，请咨询管理员 400-666-3999</p>
										</figuey>
									</c:if>
								</ul>
							</div>
							<br>
							<div class="DataStatistics_2_line" style="margin-left: 20px;"></div>
							<c:if test="${pageData.status==3 || pageData.status == null || pageData.status==''}">
								<div class="RBtnTab">
									<h3>
									<span class="fontR"> <br>
									</span>
									</h3>
									<span>
										<a 	class="btn_blue" href="${root }/page_manage/key/toedit?id=${pageData.id}&pageName=${pageData.name }&pageLink=${pageData.pageInfoExtra.domain }&pageData.status=${pageData.status }"
									target="_parent">继续修改</a>
									</span>
									<!-- 删除 -->
									<span class="fontR"> 
										<a href="###" onclick="deletePaga('${pageData.id}')">删除</a>
										<br>
									</span>
								</div>
							</c:if>
							<c:if test="${pageData.status!=3 && pageData.status != null && pageData.status!=''}">
								<div class="RBtnTab">
									<h3>
									<span class="fontR"> <br>
									</span>
									</h3>
								    <!-- 升级发布权限 -->
									<c:if test="${pageData.state==0 && pageData.status==1}">
									<span> 
										<input type="button" class="btn_blue" id="btn_shengjiQuanxian" onclick="shengjiQuanXian('${pageData.id}')" value="升级发布权限" />
										<br>
									</span> 
									</c:if>
									<!-- 编辑 -->
									<span>
									<a class=${(pageData.state==1 && pageData.status==1)?"btn_blue":"btn_gray"} href="${root }/page_manage/key/toedit?id=${pageData.id}&pageName=${pageData.name }&pageLink=${pageData.pageInfoExtra.domain }&pageData.status=${pageData.status }"
									target="_parent">修改</a>
									</span> 
									<!-- 发布 -->
									<c:if test="${pageData.status !=1 && pageData.hasShop!=1 && pageData.hasOrder!=1 && pageData.status !=2}">
										<span>
										<a class="btn_blue" href="#" onclick="publishPage('${pageData.id}','${pageData.name }','${pageData.pageInfoExtra.domain }')">发布</a>
										<br>
										</span> 
									</c:if>
									<!-- 结算 -->
									<c:if test="${pageData.hasShop==1}">
									<span> 
										<a class="btn_blue" href="${root }/shopping_cart/key/getAll?sign=1">结算</a>
									</span>
									</c:if>
									<!-- 支付 -->
									<c:if test="${pageData.hasOrder==1}">
									<span> 
										<a class="btn_blue" href="${root }/order/key/orderList?menuNum=5">支付</a>
									</span>
									</c:if>
									<!-- 删除 -->
									<span class="fontR"> 
										<a href="###" onclick="deletePaga('${pageData.id}')">删除</a>
										<br>
									</span>

								</div>
							</c:if>
							
							<div class="clear"></div>
							<div class="listDiv">
								<ul>
									<c:forEach items="${pageData.pageProductDatas}" var="service">
										<li>
										<!-- 如果是服务为客户留言    则在图片上加入留言链接 -->
										<c:if test="${service.productData.type == 1 }">
											<!--启用此服务所显示的图标  -->
											<div style="background-color: ${pageData.messageBoardNum>0?'#D55A4B':'#999' };height: 20px;width: 25px;position:absolute; z-index:2;border-radius: 3px;margin-left: 60px;text-align: center;line-height: 20px;margin-top: 5px;color: white;">${pageData.messageBoardNum }</div>
											<c:if test="${service.status==1 }">
												<div><a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageData.id}&productId=${service.productData.id}&pageName=${pageData.name}" class="font_blue" style="z-index: 9"><img src="${root }/images/mini/images/message1.png" /></a></div> 
											</c:if>
											<!--未启用此服务所显示的图标  -->
											<c:if test="${service.status==0 }">
												<a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageData.id}&productId=${service.productData.id}&pageName=${pageData.name}" class="font_blue"><img src="${root }/images/mini/images/message4.png" /> 
												</a>
											</c:if>
										</c:if>
										<!-- 如果是服务为拨打销售电话     则在图片上加入留言链接 -->
										<c:if test="${service.productData.type == 2 }">
											<!--启用此服务所显示的图标  -->
											<c:if test="${service.status==1 }">
												<a href="${root }/product_manage/key/tophoneDetail?id=${service.id}&pageName=${pageData.name}" class="font_blue">
													<img src="${root }/images/mini/images/Incoming-Call1.png" /> 
												</a>
											</c:if>
											<!--未启用此服务所显示的图标  -->
											<c:if test="${service.status==0 }">
												<a href="${root }/product_manage/key/tophoneDetail?id=${service.id}&pageName=${pageData.name}" class="font_blue"> 
													<img src="${root }/images/mini/images/Incoming-Call4.png" /> 
												</a>
											</c:if>
										</c:if>
										<!-- 如果是服务为在线客服       则在图片上加入留言链接 -->
										<c:if test="${service.productData.type == 5 }">
											<a href="${root }/product_manage/key/toserviceDetail?id=${service.id}&hasShop=${pageData.hasShop}&hasOrder=${pageData.hasOrder}&pageId=${pageData.id}"
														class="font_blue">
														<c:if test="${pageData.hasShop==1 }">
															<c:forEach items="${pageData.shopDatas}" var="pShopDatas">
																<c:if test="${service.productData.id==pShopDatas.productId }">
																	<img src="${root }/images/mini/images/talk993.png" /> 
																</c:if>
															</c:forEach>
														</c:if>
														<c:if test="${pageData.hasOrder==1 }">
															<c:forEach items="${pageData.orderProductDatas}" var="pOrderProductDatas">
																<c:if test="${service.productData.id==pOrderProductDatas.productId}">
																	<img src="${root }/images/mini/images/talk993.png" /> 
																</c:if>
															</c:forEach>
														</c:if>
														<c:if test="${empty pageData.hasOrder&&empty pageData.hasShop}">
															<!--收费服务待开通   未开通和标记收款有冲突 -->
															<c:if test="${service.status==2 }">
																	<img src="${root }/images/mini/images/talk994.png" /> 
															</c:if>
															<!--收费服务已开通  -->
															<c:if test="${service.status==3 }">
																	<img src="${root }/images/mini/images/talk994.png" /> 
															</c:if>
															<c:if test="${service.status==0 }">
																	<img src="${root }/images/mini/images/talk992.png" /> 
															</c:if>
															<c:if test="${service.status==1 }">
																	<img src="${root }/images/mini/images/talk991.png" /> 
															</c:if>
															<c:if test="${empty service.status}">
																	<img src="${root }/images/mini/images/talk992.png" /> 
															</c:if>
														</c:if>
												</a>
										</c:if>
										<!-- 如果服务为购买则在图片上加入留言链接 -->
										<c:if test="${service.productData.type == 6 }">
											<c:if test="${service.status==1 }">
											<!--启用此服务所显示的图标  -->
											<div style="background-color: ${pageData.notProcessOrderNum > 0?'#D55A4B':'#999' };height: 20px;width: 25px;position:absolute; z-index:2;border-radius: 3px;margin-left: 60px;text-align: center;line-height: 20px;margin-top: 5px;color: white;">
												<c:if test="${pageData.notProcessOrderNum <= 0 }">0</c:if>
												<c:if test="${pageData.notProcessOrderNum > 0 }">${pageData.notProcessOrderNum }</c:if>
											</div>
												<div><a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageData.id }" class="font_blue" style="z-index: 9">
												<img src="${root }/images/mini/purchase/buy/buy_meitu_3.jpg" /></a>
												</div> 
											</c:if>
											<!--未启用此服务所显示的图标  -->
											<c:if test="${service.status==0 }">
												<a href="###" class="font_blue"><img style="height: 60px;width: 60px" src="${root }/images/mini/purchase/buy/buy_stop.jpg" /> 
												</a>
											</c:if>
										</c:if>
										<span>
												<c:if test="${service.productData.type == 1}">
													<a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageData.id}&productId=${service.productData.id}&pageName=${pageData.name}"
														class="font_blue">${service.productName}</a>
												</c:if>
												<c:if test="${service.productData.type == 2}">
													<a href="${root }/product_manage/key/tophoneDetail?id=${service.id}&pageName=${pageData.name}"
														class="font_blue">${service.productName}</a>
												</c:if>
												<c:if test="${service.productData.type == 5}">
													<a href="${root }/product_manage/key/toserviceDetail?id=${service.id}&hasShop=${pageData.hasShop}&hasOrder=${pageData.hasOrder}"
														class="font_blue">${service.productName}</a>
												</c:if>
												<c:if test="${service.productData.type == 6}">
													<a href="${root }/order_manager/key/toconSumerOrderManager?pageid=${pageData.id }"
														class="font_blue">${service.productName}</a>
												</c:if>
												<c:if test="${service.productData.type !=1 && service.productData.type != 2 && service.productData.type != 5 && service.productData.type != 6}">
													<a href="###" class="font_blue">${service.productName}</a>
												</c:if>
										</span>
										</li>
										<!-- 此局部变量是未了下面显示用 -->
										<c:if test="${service.productName eq '在线咨询' }">
											<c:set var="ishave" value="1"></c:set>
										</c:if>
									</c:forEach>
									<!-- 未购买在线客服这以服务，默认显示灰色  -->
									<c:if test="${ishave!='1' }">
										<li>
											<a href="${root }/product_manage/key/toserviceDetail?pageId=${pageData.id}" class="font_blue">
												<img src="${root }/images/mini/images/talk992.png" /> 
											</a>
											<span><a href="${root }/product_manage/key/toserviceDetail?pageId=${pageData.id}" class="font_blue">在线咨询</a></span>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</c:forEach>
					</div>
				<page:PageRoll  /> 
				</c:if>
				</div >
			</div>
			
	</form> 
	<%@include file="/mini_end.jsp"%>
	<input type="hidden" id="repageId" value="">
	<input id="path" style="display: none;" value="${path }">
	
	
</body>
</html>
