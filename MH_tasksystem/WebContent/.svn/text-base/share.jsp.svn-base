<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分享资料</title>
<style type="text/css">
.weixinDivTop{
	font-family: 'Heiti SC Medium', 'Heiti SC';
font-weight: 700;
font-size: 16px;
color: #FF6600;
text-align: center;
line-height: 28px;
padding-top: 80px;
}
.weixinDivTop_img{
background: url("/view/images/share/rectangle_u19.png");
width: 280px;
height: 280px;
text-align: center;
margin:  0 auto;
margin-top: 10px;
}
.weixinDivTop_img img{
width: 263px;
height: 263px;
padding-top: 15px;
padding-left: 10px;
}
.weixinDivTop_p{
font-family: 'Heiti SC Light', 'Heiti SC';
font-weight: 200;
text-decoration: underline;
color: #999999;
}
.wexinDiv_hr{
width: 597px;
height: 1px;
background-color: #888;
margin-top: 80px;
}
.weixininput{
text-align:  center;
padding-top: 20px;
padding-right: 40px;
}
.weixininput a{
font-family: 'Heiti SC Light', 'Heiti SC';
font-weight: 200;
text-decoration: underline;
color: #0099CC;
font-size: 13px;
padding-left: 20px;
}
.share_a{
cursor:pointer;
color:#2e3192;
display: block;
width: 32px;
height: 33px;
float: left;
margin-left: 6px;
}

</style>
</head>
<body>


<div style="font-size:13px;background-color: white;width: 120px;height: 33px;">
   
   
   <a title="分享到微信"   class="weixinZ share_a" target="_blank"
    onmouseout="weixinout()" onmouseover="weixinHov()">
   <img src="${root}/view/images/share/weixinhui.png" style="height:33px; width:33px; vertical-align:middle;"/>
   </a>
   
   <a title="分享到新浪微博" onclick="javascript:bShare.share(event,'sinaminiblog',0);return false;" 
    onmouseout="weiboout()" onmouseover="weiboHov()" class="weibo share_a">
   <img src="${root}/view/images/share/weibohui.png" style="height:33px; width:33px; vertical-align:middle;"/> 
   </a>
   
   <a title="分享到QQ空间" onclick="javascript:bShare.share(event,'qzone',1);return false;" 
	   onmouseout="qqout()" onmouseover="qqHov()" class="qq share_a">
   <img src="${root}/view/images/share/qqhui.png" style="height:33px; width:33px; vertical-align:middle;"/>
   <span style="padding-left:2px; vertical-align:middle;"></span></a>
<script type="text/javascript" charset="utf-8" src="${root}/buttonLite.js#style=-1&uuid=&pophcol=2&lang=zh"></script>
</div>
 <script type="text/javascript" charset="utf-8">
 //截取地址栏参数
   $(function(){
	   //截取参数
	   function GetQueryString(name){
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null){
		    	 return  unescape(r[2]); 
		     }else{
		    	 return null;
		     }
		}
	var url=GetQueryString('imgUrl');   //图片路径
	var domain=GetQueryString('domain');    //page页面地址
	var pageName=GetQueryString('pageName');    //page名称
	//微信分享
	  $(".weixinZ").live("click",function(){
			var url1=root+"/page_manage/key/toWeixin?ImgUrl="+url+"&domain="+domain+"&pageName="+pageName;
			$(this).attr("href",url1);
	  })
	  
	  bShare.addEntry({
	     title: "【"+pageName+"】",
	     url:domain ,
	     summary: "（分享自@商站宝）",
	     pic:  url
	 });
	  bShare.addEntry({
		     title: "【"+decodeURIComponent(pageName)+"】",
		     url:domain ,
		     summary: "（分享自@商站宝）",
		     pic:  url
		 })
	 
	

 })
	
	 
	function weiboHov(){
		 var img=root+"/view/images/share/weibohover.png";
		 $(".weibo").find("img").attr("src",img);
  }
   function weiboout(){
		 var img=root+"/view/images/share/weibohui.png";
		 $(".weibo").find("img").attr("src",img);
}
	function weixinHov(){
		 var img=root+"/view/images/share/weixinhover.png";
		 $(".weixinZ").find("img").attr("src",img);
 }
  function weixinout(){
		 var img=root+"/view/images/share/weixinhui.png";
		 $(".weixinZ").find("img").attr("src",img);
}
  
	function qqHov(){
		 var img=root+"/view/images/share/qqhover.png";
		 $(".qq").find("img").attr("src",img);
}
 function qqout(){
		 var img=root+"/view/images/share/qqhui.png";
		 $(".qq").find("img").attr("src",img);
}
 
   
 </script> 
<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
</body>
</html>