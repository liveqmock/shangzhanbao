<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>留言板管理</title>
<style type="text/css">
	.noreadtr{
		font-weight: bold;
		color:red;
	}
	.msg{
		color: blue;
	}
</style>
<script type="text/javascript">
$(".openMsg").live("click",function(){
	var pageId=$("#pageid").val();
	var productId=$("#productId").val();
	$.ajax({
		url:root+"/product_manage/key/openPageProductmes?productid="+productId+"&pageid="+pageId,
		type : "post",
		success : function(){
			$("#state").val("1");
			alert("启用成功！");
			//刷新当前页面
			location.reload();
		}
	});
});

var isroload = false;
/**
 * 获取窗口高度
 */
function getHeight() {
	var winHeight = 0;
	// 获取窗口高度
	if (window.innerHeight) {
		winHeight = window.innerHeight;
	} else if ((document.body) && (document.body.clientHeight)) {
		winHeight = document.body.clientHeight;
	}
	// 通过深入document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientHeight) {
		winHeight = document.documentElement.clientHeight;
	}
	return winHeight;
}
/**
 * 获取窗口宽度
 */
function getWidth() {
	var winWidth = 0;
	// 获取窗口宽度
	if (window.innerWidth) {
		winWidth = window.innerWidth;
	} else if ((document.body) && (document.body.clientWidth)) {
		winWidth = document.body.clientWidth;
	}
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientWidth) {
		winWidth = document.documentElement.clientWidth;
	}
	return winWidth;
}
/**
 * 弹出div窗口
 * 
 * @param title
 *            窗口的标题
 * @param msg
 *            窗口中的内容（html代码）
 * @param w
 *            窗口宽度
 * @param h
 *            窗口高度
 */
 function alertWin(title, msg, w, h) {
		var titleheight = "80px"; // 提示窗口标题高度
		var bordercolor = "#666699"; // 提示窗口的边框颜色
		var titlecolor = "#999999"; // 提示窗口的标题颜色
		var titlebgcolor = "#FFFFFF"; // 提示窗口的标题背景色
		var bgcolor = "#FFFFFF"; // 提示内容的背景色

		var iWidth = getWidth();
		var iHeight = getHeight();
		var bgObj = document.createElement("div");
		bgObj.style.cssText = "position:absolute;left:0px;top:0px;width:"
				+ iWidth
				+ "px;height:"
				+ iHeight
				+ "px;filter:Alpha(Opacity=30);opacity:0.3;background-color:#000000;z-index:101;";
		document.body.appendChild(bgObj);
		$(bgObj).attr("id", "bgDiv");

		var msgObj = document.createElement("div");
		msgObj.style.cssText = "position:absolute;font:15px '宋体';top:"
				+ (iHeight - h) / 2 + "px;left:" + (iWidth - w) / 2 + "px;width:"
				+ w + "px;height:" + h + "px;text-align:center;border:1px solid "
				+ bordercolor + ";background-color:" + bgcolor
				+ ";padding:1px;line-height:22px;z-index:102;";
		document.body.appendChild(msgObj);
		$(msgObj).attr("id", "msgDiv");
		var table = document.createElement("table");
		msgObj.appendChild(table);
		table.style.cssText = "margin:0px;border:0px;cellspacing:0; cellpadding:0;padding:0px;";
		table.cellSpacing = 0;
		var tr = table.insertRow(-1);
		var titleBar = tr.insertCell(-1);
		titleBar.style.cssText = "width:100%;height:"
				+ titleheight
				+ "px;text-align:left;padding:8px 0px;margin:0px;font:bold 16pt '宋体';color:"
				+ titlecolor + ";border:0px solid " + bordercolor
				+ ";background-color:" + titlebgcolor;
		titleBar.style.paddingLeft = "10px";
		titleBar.innerHTML = title;
		var moveX = 0;
		var moveY = 0;
		var moveTop = 0;
		var moveLeft = 0;
		var moveable = false;
		var closeBtn = tr.insertCell(-1);
		closeBtn.style.cssText = "cursor:pointer; padding:2px;background-color:"
				+ titlebgcolor;
		closeBtn.innerHTML = "<span style=\"font-size:15pt;float:right;color:&quot;\">×</span>";
		// 移除窗口事件
		closeBtn.onclick = function() {
			document.body.removeChild(bgObj);
			document.body.removeChild(msgObj);
			//刷新当前页面
			location.reload();
		}
		var msgBox = table.insertRow(-1).insertCell(-1);
		msgBox.style.cssText = "padding:10px;";
		msgBox.colSpan = 2;
		msgBox.innerHTML = msg;
		// 获得事件Event对象，用于兼容IE和FireFox
		function getEvent() {
			return window.event || arguments.callee.caller.arguments[0];
		}
	}
/**
 * 查看详情的方法
 */
function select(info){
	//获取留言对象信息
	var id = info;
	var name = $("#"+info).find("#name").text();
	var email = $("#"+info).find("#email").text();
	var createtime = $("#"+info).find("#createtime").text();
	var demand = $("#"+info).find("#demand").text();
	var isread = $("#"+info).find("#isread").text();
	if(isread == 0){
		//调用修改留言信息方法
		$.ajax({
			url : root+"/page_messageboard/key/editPageMessageboard?pageMessageboardData.id="+id,
			type : "post",
			success : function(){
			}
		});
		isroload = true;
	}
	var addFbHtml = "<div style=\"height:70px;\"><div style=\"height:35px;\">"+
		"<div style=\"float:left; margin-left:20px; margin-top:5px;\">留言人："+name+"</div>"+
		"<div style=\"float:left; margin-left:20px; margin-top:5px;\">留言时间："+createtime+"</div>"+
		"</div><div style=\"float:left; margin-left:20px; margin-top:5px;\">联系邮箱："+email+"</div>"+
		"</div><div><textarea disabled=\"disabled\" style=\"resize:none;margin-left:20px; width:480px;\" rows=\"10\">"+demand+"</textarea>"+
		"</div><div style=\"margin-top:10px;\" align=\"center\"><input type=\"button\" style=\"height:30px; width:120px; background:#666666; border:0px; color:#FFFFFF; font-size:12px; cursor:pointer;\" onclick=\"closeWin()\" value=\"关闭\" />"+
		"<input style=\"margin-left:40px;height:30px; width:120px; background:#666666; border:0px; color:#FFFFFF; font-size:12px; cursor:pointer;\" onclick=\"deleteMsgboard('"+id+"')\" type=\"button\" value=\"删除\" /></div>";
	alertWin("留言详情",addFbHtml,"550","350");
}
//删除事件
function deleteMsgboard(msgid){
	$.ajax({
		url:root+"/page_messageboard/key/deletePageMessageboard?id="+msgid,
		type : "post",
		success : function(){
			alert("删除成功！");
			//刷新当前页面
			location.reload();
		}
	});
}
//关闭窗口
function closeWin(){
	//刷新当前页面
	location.reload();
}

</script>
</head>
<body>
	<div class="head"></div>
	<div class="content">
		<%@include file="/left.jsp"%>
		<div class="UserCenter_Right">
		    <div class="mesTi">
		     <div class="h1Div"> <h1>
		     ${pageName}
		     <c:if test="${pageName==''}">未设置名称</c:if>
		     </h1></div>
		   <a href="${root }/page_manage/key/getAllPaga?menuNum=1"> <img alt="" src="${root}/view/images/product/u53.png"></a>
		    </div>
		
			<div class="mesmain">
			  <div class="mes_mleft">
			  <img alt=""  src="${root}/images/mini/images/message1.png">
			  </div>
			  <div  class="mes_mright">
			  	<h1>留言</h1>
			  	<p>有效期：永久</p>
			  
			  	<c:if test="${messtatus==1}">
			  	<div class="hbtn" style="float: left;">已启用 </div>
			  	<div style="float: left;line-height: 27px;height: 27px;margin-left: 5%;"><a href="${root }/product_manage/key/getAllProduct?menuNum=3" style="text-decoration: none;">服务管理</a></div>
			  	</c:if>
			  	
			  	<c:if test="${messtatus==0}">
			  	<div class="hbtn">已停用</div>
			  	
			  	<div class="openbtn openMsg">
			  	<input type="hidden" value="${productId}" id="productId">
			  	<input type="hidden" value="${pageid}" id="pageid">
			  	<span >启用</span></div>
			  	</c:if>
			  	</div>
			  </div>
			<div class="mesbtm"></div>
	
	
	
			<div class="DataStatistics_1">
				<div class="DataStatistics_1Title">
					<h1>留言信息管理</h1>
					<div>
						<span><a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageid}&productId=${productId}&pageName=${pageName}" class="${isread!=null?'msg':'' }">全部留言</a></span>
						<span><a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageid}&isread=0&productId=${productId}&pageName=${pageName}" class="${isread!=0?'msg':'' }">未读留言</a></span>
						<span><a href="${root }/page_messageboard/key/topageMessageboardManage?pageid=${pageid}&isread=1&productId=${productId}&pageName=${pageName}" class="${isread!=1?'msg':'' }">已读留言</a></span>
					</div>
				</div>
				<div class="widget-content">
					<form action="" method="post">
						<table class="table">
							<thead>
								<tr>
									<th width="150">客户名称</th>
									<th width="200">留言时间</th>
									<th width="200">客户邮箱</th>
									<th width="250">留言内容</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pmData" items="${pmDatalist}">
									<tr id="${pmData.id}">
										<td width="150">
											<span class="${pmData.isread==0?'noreadtr':'' }" id="name">${pmData.name }</span>
										</td>
										<td width="150">
											<span class="${pmData.isread==0?'noreadtr':'' }" id="email">${pmData.email }</span>
										</td>
										<td width="200">
											<span class="${pmData.isread==0?'noreadtr':'' }" id="createtime">${pmData.createtime }</span>
										</td>
										<td style="display: none;">
											<span class="${pmData.isread==0?'noreadtr':'' }" id="isread">${pmData.isread }</span>
										</td>
										<td width="250">
											<span style="display: none;" class="${pmData.isread==0?'noreadtr':'' }" id="demand">${pmData.demand }</span>
											<span class="${pmData.isread==0?'noreadtr':'' }" >${fn:substring(pmData.demand, 0, 8)}...</span>
										</td>
										<td width="150"><span class="span2"><a href="javascript:select('${pmData.id}')">查看详情</a></span></td>
									</tr>
								</c:forEach>
								<tr><td colspan="6" height="40"><div style="float:right"> <page:PageRoll/></div></td></tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			</div>
		</div>
</body>
</html>