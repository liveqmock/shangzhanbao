var appid="wxb414d8cfd28ae3ed";
var root="http://www.91dzsw.com";

/**
 * 把code存入cookie
 */
function addCodeToCookie(){
	var redirect_uri="http%3a%2f%2fwww.91dzsw.net%2fpagehtml%2findex.jsp";
	//为性能获取code链接
	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +appid+
	 		"&redirect_uri=" +redirect_uri+ 
	 		"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	var code=GetQueryString("code");  //截取code参数
	alert("code1:"+code);
	addCookie("code",code,120000,"/");   //code 添加到cookie

}

/**
 * 把openId存入cookie
 */
function addOpenIdToCookie(){
	//微信code
    var code=getCookieValue("code");
    var openId=getCookieValue("openId");
	if(code=="null" || code==""){
		addCodeToCookie();
		window.location.reload();
	}
	//当code不为空获取微信openid
	$.ajax({
		type : 'POST',
		cache : false,
		url : root+"/get_open_id/key/getWeixinOpenId?code="+code,
		success : function(data) {
			var newData = $("<div>").html(data);
			data = $(newData).text();
			if(data!="1" && data!="0"){
				addCookie("openId",data,12000,"/"); //两分钟时效 
			}else{
				//openid为空  继续刷新页面
				addOpenIdToCookie();
			}
		}
	});
}

/**
 * 获取openid
 */
function queryOpenId(){
	var openId=getCookieValue("openId");
	if(openId=="null" || openId==""){
		addOpenIdToCookie();
		window.location.reload();
	}
	openId=getCookieValue("openId");
	return openId;
}

/**
 * 截取参数
 */
function GetQueryString(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null){
		return  unescape(r[2]); 
	}else{
		return null;
	}
}

/**
 * 获取cookie的值，根据cookie的键获取值
 */
function getCookieValue(name){
	//用处理字符串的方式查找到key对应value  
    var name = escape(name);  
    //读cookie属性，这将返回文档的所有cookie  
    var allcookies = document.cookie;         
    //查找名为name的cookie的开始位置  
    name += "=";  
    var pos = allcookies.indexOf(name);      
    //如果找到了具有该名字的cookie，那么提取并使用它的值  
    if (pos != -1){//如果pos值为-1则说明搜索"version="失败  
        var start = pos + name.length;//cookie值开始的位置  
        var end = allcookies.indexOf(";",start);//从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
        if (end == -1) end = allcookies.length;//如果end值为-1说明cookie列表里只有一个cookie  
        var value = allcookies.substring(start,end);//提取cookie的值  
        return (value);//对它解码        
    }else{  //搜索失败，返回空字符串  
        return "";  
    }  
}

//添加设置cookie
function addCookie(name,value,days,path){
    var name = escape(name);  
    var value = escape(value);  
    var expires = new Date();  
    expires.setTime(expires.getTime() + days);  
    //path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用  
    path = path == "" ? "" : ";path=" + path;  
    //GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC  
    //参数days只能是数字型  
    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();  
    document.cookie = name + "=" + value + _expires + path;  
}  

/**
 * 根据cookie的键，删除cookie，其实就是设置其失效、
 **/  
function deleteCookie(name){   
	var exp = new Date(); 
	exp.setTime(exp.getTime() - 1); 
	var _expires = (typeof days) == "string" ? "" : ";expires=" + exp.toUTCString(); 
	var cval=getCookieValue("userName");
	if(cval == name && cval!=null && cval!=""){
		document.cookie= name + "=" + "" + _expires + path; 
	}
}