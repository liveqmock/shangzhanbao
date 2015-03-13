<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
 <%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助与支持 - 商站宝</title>
<meta name ="keywords" content="商站宝、麻雀微站在线帮助，在线客服，在线咨询，寻求帮助，提交意见，建议，留言">
<meta name="description" 
 content="网站模板，手机网站模板，大气，简约，经典，营销型网站模板，微信模板">
<link href="${root}/view/css/mini/axure_rp_page.css" type="text/css" rel="stylesheet"/>
<link href="${root}/view/css/mini/styles.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript"	src="${root}/view/js/minipage/common/help.js"></script>
<script type="text/javascript" src="http://lead.soperson.com/10028042/10040614.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<link rel="stylesheet" type="text/css" href="${root }/view/css/mini/pop_up_div.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript">
	function clickLi(obj,con){
		$("#divTest").animate({marginTop:"-"+((obj-1)*870)+"px"},500);
		$(con).find("img").attr("src",root+"/view/images/help/yuanquan.png");
		$(".onepage-scroll-li li").each(function(){
			if($(this).attr("id")!=$(con).attr("id")){
				$(this).find("img").attr("src",root+"/view/images/help/heiyuanquan.png");
			}
		})
	}
	 function mousemoveLi(obj){
		$("#div"+obj).stop().css('display', "block").animate({opacity: 1}, 500);
	}
	function mouseoutLi(obj){
		$("#div"+obj).stop().animate({opacity: 0}, 500, function(){
			$("#div"+obj).css('display', "none");
		});
	} 
</script>
<style type="text/css">
	a{
		font-family: 'Arial Normal', 'Arial';
		font-weight: 400;
		font-style: normal;
		font-size: 13px;
		color: #333333;
		cursor: pointer;
		text-decoration: none;
	}
</style>
</head>
<body style="min-width: 1400px">
<div style="width:80%; margin:0 auto; margin-top:100px; min-width: 1100px;">
		<div style="font-family: '微软雅黑 Bold', '微软雅黑';font-weight: 700;font-size: 36px;color: #666666; margin:0 auto;text-align:center;">
			帮助与支持
		</div>
		<div style="background: url(${root }/view/images/helpnew/u14_line.png); height:5px; width:100%; margin-top:5px; min-width:1100px;"></div>
	</div>
	<div style="width:80%;margin:10px auto;height: 900px;margin-bottom: 80px;">
		<div style="float:left; width:210px; ">
			<table cellpadding="1" cellspacing="1" width="100%" style="background:#CCCCCC;">
				<tr style="width:206px; height:42px;background: #194872;">
					<td style="font-size: 16px;color: #FFFFFF; text-align:center;">帮助与支持中心</td>
				</tr>
				<tr style="width:206px; height:42px;background:#F3F3F3;">
					<td style="font-family: 'Arial Normal', 'Arial'; font-weight: 400; font-style: normal; font-size: 13px; color: #333333; text-align: center;">
						<div align="center">
							<span style="background:url(${root }/view/images/helpnew/u21.png); width:16px; height:16px;font-family: 'Arial Normal', 'Arial';font-weight: 400;font-style: normal;font-size: 13px;color: #FFFFFF; text-align:center; display:-moz-inline-box; display:inline-block;">
							>
							</span>
							<span><a href="${root}/help_manager/key/tohelpmini">建站流程</a></span>
						</div>
					</td>
				</tr>
				<tr style="width:206px; height:42px;background:#F3F3F3;">
					<td style="font-family: 'Arial Normal', 'Arial'; font-weight: 400; font-style: normal; font-size: 13px; color: #333333; text-align: center;">
						<span><img src="${root }/view/images/helpnew/u15.png" style="vertical-align:middle;" width="21" height="18" /></span>
						<span><a href="${root}/help_manager/key/tohelpmini1">常见问题</a></span>
					</td>
				</tr>
				<tr style="width:206px; height:42px;background:#F3F3F3;">
					<td style="font-family: 'Arial Normal', 'Arial'; font-weight: 400; font-style: normal; font-size: 13px; color: #333333; text-align: center;">
						<span><img src="${root }/view/images/helpnew/u15.png" style="vertical-align:middle;" width="21" height="18" /></span>
						<span><a href="${root}/help_manager/key/tohelpmini2">联系我们</a></span>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<ul class="onepage-scroll-li">
				<li onclick="clickLi(1,this)" onmousemove="mousemoveLi(1)" onmouseout="mouseoutLi(1)" id="ul_1" >
				<img  src="${root}/view/images/help/heiyuanquan.png" width="30px" height="30px">
				<div id="div1" style="display:none;margin-left: -110px;margin-top: -28px;">注册商站宝账号</div>
				</li>
				<li onclick="clickLi(2,this)" onmousemove="mousemoveLi(2)" onmouseout="mouseoutLi(2)" id="ul_2">
				<img  src="${root}/view/images/help/heiyuanquan.png" width="30px" height="30px">
				<div id="div2" style="display:none;margin-left: -215;margin-top: -28px;">点击“立即创建，进入创建流程”</div>
				</li>
				<li onclick="clickLi(3,this)" onmousemove="mousemoveLi(3)" onmouseout="mouseoutLi(3)" id="ul_3">
				<img  src="${root}/view/images/help/heiyuanquan.png" width="30px" height="30px">
				<div id="div3" style="display:none;margin-left: -205;margin-top: -28px;">修改页面细节，完善商战内容</div>
				</li>
				<li onclick="clickLi(4,this)" onmousemove="mousemoveLi(4)" onmouseout="mouseoutLi(4)" id="ul_4">
				<img  src="${root}/view/images/help/heiyuanquan.png" width="30px" height="30px">
				<div id="div4" style="display:none;margin-left: -60;margin-top: -28px;">发布商站</div>
				</li>
				<li onclick="clickLi(5,this)" onmousemove="mousemoveLi(5)" onmouseout="mouseoutLi(5)" id="ul_5">
				<img  src="${root}/view/images/help/heiyuanquan.png" width="30px" height="30px">
				<div id="div5" style="display:none;margin-left: -90;margin-top: -28px;">商战发布成功</div>
				</li>
			</ul>
		</div>
		<div style="font-family: '微软雅黑 Bold', '微软雅黑';color: #194872;font-weight: 700;
			font-style: normal;font-size: 24px; margin-left:5px;line-height: 50px;width: 80%;float: left;">
				<img src="${root }/view/images/help/image_u13.png" width="50" height="50" style="vertical-align:bottom;" /><span style="margin-left:5px;">建站流程</span>
			<div style="height: 1px;background-color: rgb(221, 209, 209);width: 98%;margin-left: 2%;margin-bottom: 40px;"></div>
			</div>
			<div  class="onepage-scroll">
				<div id="divTest">
					<div class="onsdiv">
					<span>第一步：注册商站宝账号</span>
					<img  src="/view/images/help/u35.png">
					<hr />
					</div>
					<div class="onsdiv">
					<span>第二步：点击“立即创建，进入创建流程”</span>
					<img  src="/view/images/help/u24.png">
					<hr />
					</div>
					<div class="onsdiv">
					<span>第三步：修改页面细节，完善商战内容</span>
					<img  src="/view/images/help/u31.png" style="height: 360px;">
					<hr />
					</div>
					<div class="onsdiv">
					<span>第四步：发布商站</span>
					<img  src="/view/images/help/u37.png"  style="height: 281px;">
					<hr />
					</div>
					<div class="onsdiv" >
					<span>第五步：商战发布成功</span>
					<div style="border: solid;width: 741px;margin: 0 auto;height: 595px;margin-top: 30px;">
					<img  src="/view/images/help/u45.png" 
					style="width: 598px;border: none;margin-bottom: 0px;margin-top: 0px;height: 590px;margin: 2px;margin-left: 70px;">
					</div>
					</div>
				</div>
		</div>
	</div>
<%@include file="/mini_end.jsp"%>
</body>
</html>
