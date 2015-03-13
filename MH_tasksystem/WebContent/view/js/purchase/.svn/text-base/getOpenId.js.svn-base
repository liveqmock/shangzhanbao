

$(function(){
	//page访问地址
	minidomain = "http://www.91dzsw.net/pagehtml/";
	domain = "http://www.91dzsw.net";
	//红包系统路径
    redPackageroot="http://223.203.224.227:8839";
    //微信appid
    appid="wxb414d8cfd28ae3ed";
    //微信openId
    openId="";
    code="";
	//是否是微信
	if(isWeixin()==true){
		var redirect_uri = domain+"/view/wxpayDemo/getOpenId.jsp";
		var state_uri = "";
		if(window.location.search == null || window.location.search == ""){
			state_uri = escape(window.location.href+"?a=1");
		}else{
			state_uri = escape(window.location.href);
		}
		//为性能获取code链接
		 window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +appid+
		 		"&redirect_uri=" +redirect_uri+ 
		 		"&response_type=code&scope=snsapi_base&state="+state_uri+"#wechat_redirect";
	}
});
/**
 * 判断是否是微信浏览器
 * @returns {Boolean}
 */
function  isWeixin(){
	var bl=true;
	var ua = window.navigator.userAgent.toLowerCase(); 
	if(ua.match(/MicroMessenger/i) == 'micromessenger'){
		bl=true;
	}else{
		bl=false;
	}
	return bl;
}
function getCookieValue(name){  /**获取cookie的值，根据cookie的键获取值**/  
    //用处理字符串的方式查找到key对应value  
    var name = escape(name);  
    //读cookie属性，这将返回文档的所有cookie  
    var allcookies = document.cookie;         
    //查找名为name的cookie的开始位置  
    name += "=";  
    var pos = allcookies.indexOf(name);      
    //如果找到了具有该名字的cookie，那么提取并使用它的值  
    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败  
        var start = pos + name.length;                  //cookie值开始的位置  
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie  
        var value = allcookies.substring(start,end); //提取cookie的值  
        return (value);                           //对它解码        
    }else{  //搜索失败，返回空字符串  
        return "";  
    }  
}  
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
function addCookie(name,value,time,path){   /**添加设置cookie**/  
    var name = escape(name);  
    var value = escape(value);  
    var expires = new Date();  
    expires.setTime(expires.getTime() + time);  
    //path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用  
    path = path == "" ? "" : ";path=" + path;  
    //GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC  
    //参数days只能是数字型  
    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();  
    document.cookie = name + "=" + value + _expires + path;  
}