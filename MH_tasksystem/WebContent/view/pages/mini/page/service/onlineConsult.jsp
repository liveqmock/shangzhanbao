<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/mini_top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet"
	type="text/css" />
<link href="${root }/view/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<title>在线咨询产品介绍</title>
<script type="text/javascript">

  $(".add").live("click",function(){
	    var pageId=$(".pageId").val();
		$.ajax({
			type : "post",
			url : root + "/shopping_cart/key/addShoppingCartDataPageProductView",
			data : "shoppingCartData.pageId=" + pageId,
			dataType : "text",
			success : function(data) {
				if (data == 1) {
					 window.location.href=root+"/shopping_cart/key/getAll?sign=1";
				} else {
					return false;
				}
			}
		});
	  
	  
  })

</script>
</head>
<body>
	<div class="head"></div>
	<div class="content">
	<input type="hidden"  value="${pageId}"  class="pageId">
		<%@include file="/left.jsp"%>
		<div class="UserCenter_Right">
			<div class="mesTi">
				<div class="h1Div">
					<h1 style="min-width:500px">${pageName}  <c:if test="${pageName==''}">未设置名称</c:if></h1>
				</div>
				<a href="${root }/page_manage/key/getAllPaga?menuNum=1"> <img
					alt="" src="${root}/view/images/product/u53.png"></a>
			</div>

			<div class="mesmain" style="height: 280px;">
				<div class="mes_mleft">
					<img alt="" src="${root}/view/images/product/image_u39.png">
				</div>
				<div class="mes_mright">
					<h1>在线咨询</h1>
					<div class="zuoxi">
						<select data-label="Dropdown Menu" tabindex="0"
							style="float: left;">
							<option selected="0" value="3个坐席">3个坐席</option>
						</select> <span style="float: left;"> 6888元/年</span>
						<div class="zuoxihbtn add">购买</div>
						<p style="clear: left; color: #333333; margin-top: 3%;line-height: 1.5;">
							服务简介：在线咨询是一款专为企业网络营销运营管理而设计的软件系统，专门帮助企业对网络营销过程进行精细化的管理和控制，
							它是企业构建网络营销运营系统必备的软件。实践证明，同样的网站和流量情况下，使用过在线咨询的企业其转化率至少可以提高10个百分点，
							ROI（投资回报率）至少可以增加6倍。</p>
					</div>
				</div>
			</div>
			<div class="mesbtm"></div>

			<div class="DataStatistics_1 UserCenter_RightOn">
				<div class="DataStatistics_1Title ">
					<h1 class="titleh11">在线咨询产品介绍</h1>
				</div>

				<div style="height: 345px;">
					<div class="zaixianleft">
						<h1>在线咨询</h1>
						<p>在线咨询是一款专为中小企业企业网络营销运营而设计的软件工具。网络营销人员可以通过在线咨询工具实时监控访客浏览情况，跟踪客户行为，与客户对话等等</p>
						<p>在线咨询帮助中小企业将网站的访客转化为客户，从而提高网络营销的转化率，带来更多生意机会</p>
					</div>
					<div class="zaixianright" style="float: right; margin-right: 5%;">
						<img alt="" src="${root}/view/images/product/image_u39.png"
							style="height: 280px; width: 280px; padding-right: 5%; margin-top: 3%;">
					</div>
				</div>
				<div class="sepContainer"></div>


				<div class="div2" style="height: 630px;">
					<div class="div2_left">
						<h1>强大的管理功能</h1>
						<div class="div2con">
							<span>在线对话</span>
							<p>访客可以随时向网络营销人员进行咨询，网络营销人员也可以随时对访客发起对话；</p>
						</div>
						<div class="div2con">
							<span>对话分析</span>
							<p>系统自动统计对话数量、漏接对话数，网站的流量和网络营销人员的工作质量；</p>
						</div>
						<div class="div2con">
							<span>名片管理</span>
							<p>通过在线对话获取到的信息，系统会自动分类并保存，企业人员可以随时查看客户信息并进行下一步跟踪，这些信息包括：来源城市、姓名、电话、QQ等；</p>
						</div>
						<div class="div2con">
							<span>对话报告</span>
							<p>企业自身服务的提升，从分析报告中，不但可以查看到业绩情况，还有助于自我检查，提升转化率</p>
						</div>

					</div>
					<div class="div2_right">
						<img alt="" src="${root}/view/images/product/1400037939046.jpg">
					</div>
				</div>
				<div class="sepContainer"></div>
				<div class="div3" style="clear: left;">
					<h1>服务提供商</h1>
					<p>“在线咨询”服务是由博元森禾与第三方合作机构【多友科技（北京）有限公司】共同提供，
						在本网站内购买的“在线咨询”工具会由两方共同为你开通服务，在开通完服务之后，我们会发送邮件或短信通知给你，请到时使用即可。</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>