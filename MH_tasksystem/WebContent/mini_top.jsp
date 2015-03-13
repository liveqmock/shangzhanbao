<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
<script type="text/javascript" src="${root}/view/js/minipage/common/loadmessage.js"></script>
<style type="text/css">
body{
	margin:0;
}
a img{
width:1px;
}
.mainDiv {

	position:absolute;
	top:0px;
	padding:0;
	width:100%;
	min-width:1400px;
	margin:0 auto;
	height:100px;
/* 	border-bottom:1px solid #DDDDDD; */
	background:#FFFFFF;
}
.navDiv{
	margin:23px auto;
	width:1100px;
	height:50px;
	text-align:center;
}
.navDiv ul{
	list-style:none;

}
.navDiv ul li{
	list-style-type: none;
	line-height: 50px;
	float: left;
	margin-left: 50px;
	text-align: center;
}
.navContent {
	height:50px;
	margin:0;
	margin-left:230px;
	padding:0;
	float:left;
	width:400px;
}
.navContent ul li a{
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	font-size:16px;
/*  	color:#000000; */
	text-decoration:none;
}
.navContent ul li a:hover{
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	font-size:16px;
/*  	color:#0099CC;  */
	text-decoration:none;
}

.noselect a{
	color:#000000;
}

.select a{
	color:#0099CC;
}

.navLogo {
	font-family:'Heiti SC Light', 'Heiti SC';
	font-weight:200;
	font-size: 28px; 
	color: #0099CC;
	text-align: left; 
	line-height:50px;
	float:left;
}
.navUser{
	float:left;
	width:170px;
	height:35px;
	margin-top:11px;
	color:#FFFFFF;
	/* border: 1px solid #e6e6e6;
	background:#0099CC; */
	cursor:pointer;
}
.navUser:hover{
	background:#F2F2F2;
	color:#000000;
	border: 1px solid #e6e6e6;
}
.navUserimg{
	float:left;
	width:35px;
	height:35px;
	margin:0px 0 0 1px;
}
.navUserfont{
	float:left;
	margin-left:5px;
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	font-size: 16px;
	line-height: 30px;
	color: #0099CC;
}
.navShopDiv{
	float:left;
	margin-top:11px;
	/* margin-left:10px; */
	width:115px;
	height:30px;
	/* background:#0099CC; */
}
.navShopimg{
	float:left;
	width: 26px;
	height:25px;
	margin-top:2px;
	margin-left:1px;
	background:#FFFFFF;
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	color: #00B4CA;
	font-size:13px;
	line-height:25px;
}
.navShopfont{
	float:left;
	height:30px;
	padding:0;
	margin-left:5px;
	line-height:30px;
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	font-size: 14px;
}
.navShopnum{
	float:right;
	width: 26px;
	height:25px;
	margin-top:2px;
	margin-right:2px;
	background:#FFFFFF;
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	color:#FF6600;
	font-size:13px;
	line-height:25px;
}
.navMenu{
	position:absolute;
	left:1208px;
	top:50px;
	width: 175px;
	height:auto;
	display:none;
	background:#FFFFFF;
	text-align: center;
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	font-size: 16px;
	color:#000000;
	z-index: 10000;
}
.navMenu ul li{
	width: 170px;
	height: 35px;
	line-height: 35px;
	border:1px solid #e6e6e6;
	border-top: none;
}
.navMenu ul li:hover{
	background:#F2F2F2;
}
.navMenu ul li a{
	color:#000000;
	text-decoration:none;
}
.navMenu ul li a:hover{
	color:#3296FA;
	text-decoration:underline;
}
.loginBtn{
	float:left;
	width:70px;
	height:30px;
	margin-top:11px;
	margin-left:70px;
	color:#FFFFFF;
	background:#0099CC;
	cursor:pointer;
}
.loginBtn:hover {
	background:#999999;
	text-decoration: none;
}
.loginBtn a{
	font-family: 'Heiti SC Light', 'Heiti SC';
	font-weight: 200;
	color: #FFFFFF;
	font-size: 13px;
	line-height: 30px;
	text-decoration: none;
}
</style>
<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F4266fff7e3a7bca3b9db8b26a36fb44f' type='text/javascript'%3E%3C/script%3E"));
</script>

</head>
<body>
	<input type="hidden" id="etipUserEmail" value="${frmUser.etipUserEmail}"/>
	<div class="mainDiv">
		<div class="navDiv">
			<div class="navLogo">
			<img alt="商站宝" src="${root }/view/images/logo/logo.jpg" style="width: 123px;height: 65px;">
			</div>
			<div class="navContent">
				<ul>
					<li class="${requestScope.param=='index'?'select':'noselect' }"><a href="${root }/frame/key/toIndex">首页</a></li>
					<li class="${requestScope.param=='about'?'select':'noselect' }"><a href="${root}/frame/key/about">服务功能</a></li>
					<li class="${requestScope.param=='help'?'select':'noselect' }"><a href="${root}/help_manager/key/turnHelpPage">帮助与支持</a></li>
				</ul>
			</div>
			<c:if test="${frmUser.etipUserEmail==null ||  frmUser.etipUserEmail == ''}">
			<div class="loginBtn" onclick="login()"><a href="###">登录</a></div>
			</c:if>
			<c:if test="${frmUser.etipUserEmail!=null &&  frmUser.etipUserEmail != ''}">
				
			<div class="navUser" onmouseover="showMenu();" onmouseout="hidenMenu()">	
			<div class="navUserimg">
					<img width="33px;" height="33px" src="${root }/view/images/image_u55.png" />
				</div>
				<div id="loginUserName" class="navUserfont"></div>
			</div>
			</c:if>
			<c:if test="${frmUser.etipUserEmail==null ||  frmUser.etipUserEmail == ''}">
			<div class="loginBtn" style="margin-left: 10px;" onclick="register()"><a href="###">注册</a></div>
			</c:if>
			<c:if test="${frmUser.etipUserEmail!=null &&  frmUser.etipUserEmail != ''}">
			<div class="navShopDiv">
				<div class="navShopimg"><img width="33px;" height="33px" src="${root }/view/images/image_u53.png" /></div>
				<div class="navShopfont">
					<a href="${root }/shopping_cart/key/getAll?sign=1" style="text-decoration: none;color: #0099CC;padding-left:10px">购物车</a>
				</div>
				<div class="navShopnum">
					<a href="${root }/shopping_cart/key/getAll?sign=1" style="text-decoration: none;color: #FF6600;"><span id="goodsnum"></span></a>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	<div class="navMenu" onmouseover="showMenu();" onmouseout="hidenMenu()">
      <ul>
	  	<a href="${root }/page_manage/key/getAllPaga?menuNum=1"><li>我的商站</li></a>
		<a href="/product_manage/key/getAllProduct?menuNum=3" class=""><li>服务管理</li></a>
		<a href="${root }/order/key/orderList?menuNum=5" class=""><li>订单管理</li></a>
		<a href="${root }/user/key/getUserInfos?menuNum=7" class=""><li>账号管理</li></a>
		<a href="${root }/frame/key/redPackageIndex?menuNum=8" class=""><li>红包管理</li></a>
		<a href="#" onclick=" window.parent.location.href='${root }/j_spring_security_logout'"><li>退出</li></a>
      </ul>
    </div>
    <div id="msgImg" style="position: fixed; bottom: 100; right: 20;display: none;">
		<div id="msgdiv" style="display:none;position:relative;height400px;right:0px; bottom:50px;">
		   <div class="rc_box1">
		       <div class="rc_box2">
		          <div class="rc_box3" id="box3_id">
		          	<div class="loadMsgTop">
		          		<lable class='meslable'>商站宝改进建议</lable>
		          		<span class="closeLoadMsg">
		              		<img src="${ root}/view/pages/mini/page/images/Delete-32.png"/>
		              	</span>
		             </div>
		             <div class="loadMsgCont">
		             	<textarea class="loadMsgContent"></textarea>
		             	<lable style="color:red;margin-top:4px;margin-left:7px;font-size:12px;" id="labMes"></lable>
		             </div>
		             <div class="loadMsgfoot">
		             	<span></span>
		              	<input type="button" class="btn20 mesAdd" value="提交"/>
		             </div>
		           </div>
		       </div>
		       <div class="ov1"></div>
		       <div class="ov2"></div>
		    </div>
		 </div>
		 <div style="position: absolute;bottom: 0; right: 20;height:40px;width:40px">
		 	<img style="height:40px;width:40px" class="addMsgImg" src="${root}/view/images/pages/u0.png"/>
		 </div>
	</div>
</body>
</html>
