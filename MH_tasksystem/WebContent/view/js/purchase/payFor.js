$(function(){
    minidomain = "http://www.91dzsw.net/pagehtml/";
    redPackageroot="http://223.203.224.227:8839";
    if(parent.frames['frame_top']==undefined){
             openId1=GetQueryString("openId"); =
    addCookie("openId",openId1,600000 ,"/"); 
    openId = getCookieValue("openId");
    $.each($("script[src$='getOpenId.js']"),function(){
    $(this).remove();       })
    if(openId=='null' || openId=='""'){
                    var fileref = document.createElement('script');
                fileref.setAttribute("type","text/javascript");
                fileref.setAttribute("src","/view/js/purchase/getOpenId.js");
                document.getElementsByTagName("head")[0].appendChild(fileref);
            }
    }
		//初始化加载，如果购买组件存在，就把次div添加到页面
	 if($("#goumaiwraper").html()!=""){
		 //当page页面内容为空时 或者不存在 才添加到页面
		    $("#order_paygoodsDiv").remove();//先删除再加  方便跟新数据
		    var html="<div class=\"user\" style=\"overflow: auto;display:none;\" id=\"order_paygoodsDiv\">" +
			"<div class=\"container clearfix\">" +
			"<div class=\"\"><div class=\"conleft\"><div class=\"top_pay\">" +
			"<label class=\"closed\"><a href=\"##\"	onclick=\"closeorder_PayforGood();\">X</a></label>" +
			"<p class=\"backeBut\"><a href=\"##\" onclick=\"closeorder_PayforGood();\"><font>返回</font></a></p></div>" +
			"<span class=\"order_title\">确认订单信息：</span><span class=\"orderSpan\">您选购的商品信息为：</span>" +
			"<div class=\"order_hr\"></div>" +
			"<div class=\"order_div1\" style=\"margin-top: 3%;\"><span>商品名称:</span><label id=\"order_goodsName\"></label></div>" +
		/*	"<div class=\"order_div1\"><span>商品品类:</span><label id=\"order_goodstype\"></label></div>" +*/
			"<div class=\"order_div1\"><span>商品规格:</span><label id=\"order_goodscom\"></label></div>" +
			"<div class=\"order_div1\" style=\"height: 35px;line-height: 35px;\"><span>订购数量:</span><label >" +
			"<a href=\"###\" class=\"inputTab_right_Sn1254\" onclick=\"reduceNum('0');\" style=\"border: 1px rgb(126, 120, 120) solid;height: 30px;width: 30px;margin-left:0px;\">-</a>" +
			"<input id=\"order_goodsnum\" onkeyup=\"changeNum()\" type=\"text\" class=\"inputTab_input_Sn1254\" style=\"height: 32px;width: 35px;\"value=\"1\"> " +
			"<a href=\"###\" class=\"inputTab_left_Sn1254\" onclick=\"addNum('0');\"style=\"border: 1px rgb(126, 120, 120) solid;height: 30px;width: 30px;\">+</a></label></div>" +
		/*  "<div class=\"order_div1\"><span>运费信息:</span><label id=\"order_goodsyunfei\" style=\"color: #FF0000\"></label></div>" +*/
			"<div class=\"order_div1\"><span>优惠信息:</span><label id=\"order_goodsyouhui\"></label></div>" +
			"<div class=\"order_div1\"><span>红包信息:</span>" +
			"<select id=\"redPackageSelect\" onchange=\"javascript:selectRed(this.options[this.selectedIndex]);\" " +
			"style=\"width: 150px;\" ><option value=\"0\" rid=\"\" sid=\"\" cid=\"\" selected=\"selected\">选择红包信息</option></select></div>" +
			"<div class=\"order_div1\"><span>订单总价:</span><label id=\"order_goodsprice\" style=\"color: #FF0000\"></label></div>" +
			"<div class=\"order_hr\"></div>" +
			"<div class=\"div1_1\"><p id=\"order_errorp\" class=\"errorp\"></p></div></div></div>" +
			"<div class=\"div8_1\" >" +
			"<input type=\"button\" value=\"确认订单\" onclick=\"payforGood();\" style=\"float: none;\"></div></div></div>" +
			"<input type=\"hidden\" id=\"changDis\" value=\"false\" rid=\"\" sid=\"\" cid=\"\" >";
			$("#goodsDiv").append(html);
	 }
	 $("#goodsDivBtn").live("click",function(){
		 //是微信浏览器就加载红包信息
		 if(isWeixin()==true){
		 	getRedPackage();
		 }
		 getRedPackage();
		 payfor_orderGood();
		})
});

	function payfor_orderGood(){
			sn = "_"+$("#compSn").val();
			if($("#spanNum").find('.span1'+sn).attr("data")!="" && $("#spanNum").find('.span1'+sn).attr("data")!=undefined  && $("#goodsInfoDataId").val()!=""){
				$("#order_goodsName").html($("#goodsName").html());
				$("#order_goodscom").html($("#spanNum").find('.span1'+sn).html());
				$("#order_goodsnum").val($("#amount").val());
				$("#order_goodsyouhui").html($("#promotion").html());
				$("#order_goodsprice").html(Math.floor((parseFloat($("#goodsPrice").html())*parseFloat($("#amount").val()))*100)/100);
				$("#order_goodsprice").attr("data",$("#goodsPrice").html());
				$("#order_paygoodsDiv").show();
			}else{
			alert("商品信息不正确，请联系页主！");
		 }
}
	
function payforGood(){
	var pc_flag=document.body.offsetWidth;
	  if(pc_flag>800){
		  $("#order_paygoodsDiv").hide();
	  }
	var content = "<div class='user' style=\"overflow: auto;\" id=\"paygoodsDiv\"><div class='container clearfix'>"
			+"<div class=''><div class='conleft'>"
			+"<div class='top_pay'>"
			+"<label class='closed'><a href='##' onclick='closePayforGood();'>X</a></label>"
			+"<p class='backeBut' ><a href='##' onclick='closePayforGood();'><font>返回</font></a></p>"
			+"</div>";
	var html1="<div class=\"orderTitle\">新增地址</div><div class=\"order_hr_s\"></div>"
			+"<div class='div1'><span>收货人:</span><input type='text' id='userName' value='' /></div>"
			+"<div class='div1'><span>手机号码:</span><input type='text' id='userMobile' value='' /></div>"
			+"<div class='div1'><span>收货地址:</span><select id='s_province' name='s_province'>"
			+"	</select> <select id='s_city' name='s_city'>"
			+"	</select> <select id='s_county' name='s_county'>"
			+"	</select><div id='show'></div><input type='text' id='userAddress' value='' class='' placeholder='详细地址'/>"
			+"</div>"
			+"<div class='div1'><span></span></div>"	
			+"<div class='div1_1'><p id='errorp' class='errorp'></p></div></div>"
			+"</div>"
			+"<div class=\"zhifu\">" +
			"<div class='div4'><img src='../../../images/mini/purchase/goumai/u138.png' />" +
			"<span class=\"redsolid\" id='1'  data='0'>" +
			"<div data='0' class=\"redsolid_div\"></div></span></div></div>" +
			"<!-- <div class='div5'>"
			+"	<img src='../../../images/mini/purchase/goumai/u62.png' />"
			+" <div class='div7'><img src='../../../images/mini/purchase/goumai/rectangle_u66.png' /></div>"
			+"</div>-->" 
			+"<div class='div9'><span>*支付功能由支付宝提供标准接口，您的账号及密码信息不会经过我们的站点，请您放心支付，特此声明！</span></div>"
			+"<div class='div8' style=\"height:50px;\"><input type='button' value='购买' onclick='toPayJsp();'></div></div>" 
			+"<form action='' method='post' id='toPayOrder'>"
			+"<input type='hidden' id='userMobile_form' name='conSumerUserData.userMobile' value=''>"
			+"<input type='hidden' id='userName_form' name='conSumerUserData.userName' value=''>"
			+"<input type='hidden' id='userAddress_form' name='conSumerUserData.userAddress' value=''>"
			+"<input type='hidden' id='commodityConfigDataid_form' name='commodityConfigData.id' value=''>"
			+"<input type='hidden' id='pageDomainName' name='pageDomainName' value=''>"
			+"<input type='hidden' id='goodsNum' name='goodsNum' value=''>"
			+"<input type='hidden' id='pcFlag' name='pcFlag' value='1'>"
			+"<input type='hidden' id='goodsInfoDataid_form' name='commodityConfigData.goodsInfoData.id' value=''>"
			+"<input type='hidden' id='radioCkecked' value=''>"
			+"<input type='hidden' id='conSumerUserDataId' name='conSumerUserData.id' value=''>"
			+"<input type='hidden' id='redPackageId' name='conSumerUserData.redPackageId' value=''>"
			+"<input type='hidden' id='cId' name='conSumerUserData.cId' value=''>"
			+"<input type='hidden' id='sId' name='conSumerUserData.sId' value=''>"
			+"</form>"
			+"</div>";
	sn = "_"+$("#compSn").val();
	 if(openId=="null" || openId==""){
		 	content=content+html1;
		 	if($("#spanNum").find('.span1'+sn).attr("data")!="" && $("#spanNum").find('.span1'+sn).attr("data")!=undefined  && $("#goodsInfoDataId").val()!=""){
				if($("#paygoodsDiv").html()){
					$("#userName").val("");
					$("#userMobile").val("");
					$("#userAddress").val("");
					$("#errorp").html("");
					$("#paygoodsDiv").show();
					$("#order_paygoodsDiv").hide();
				}else{
					$("#goodsDiv").append(content);
					$("#paygoodsDiv").show();  //确认订单显示
					$("#order_paygoodsDiv").hide();
				}
				//初始化省市县下拉框三级联动
				_init_area();
			}else{
				alert("商品信息不正确，请联系页主！");
			}
    }else{
    	ajaxConSuerWeixin(content,html1);
    }
	
	
	
}
  
function toPayJsp(){
	 if($("#changDis").val()!="false"){
		$("#redPackageId").val($("#changDis").attr("rid"));
		$("#sId").val($("#changDis").attr("sid"));
		$("#cId").val($("#changDis").attr("cid"));
	 }
	var pc_flag=document.body.offsetWidth;
	// 电话号码正则表达式
	var teger=/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/; 
		//当又选择了常用地址 ，且填写了新增地址，所以在用户名 电话号码地址都不为空的清空下，选择把新增地址入库
	   if($('#userName').val()!="" && $('#userMobile').val()!="" && $('#userAddress').val()!=""){
		   $("#radioCkecked").val("");
	   }
	   var radio=$("#radioCkecked").val();
	//当没有选择常用地址时
	if(radio!="radio"){
		if($('#userName').val()==""){
			$('#errorp').html("收货人不能为空！");
			return;
		}
		if($('#userMobile').val()==""){
			$('#errorp').html("手机号码不能为空！");
			return;
		}
		if(!teger.test($('#userMobile').val())){
			$('#errorp').html("手机号码格式不对！");
			return;
		}
		if($('#userAddress').val()==""){
			$('#errorp').html("请填写收货地址！");
			return;
		}
		var userMobile=$('#userMobile').val();
		var userName=$('#userName').val();
		$('#userName_form').val(userName);
		$('#userMobile_form').val(userMobile);
		var address="";
		if($('#s_county').val()=="市、县级市"){
			address=$('#s_province').val()+","+$('#s_city').val()+","+$('#userAddress').val();
			$('#userAddress_form').val(address);
		}else{
			address=$('#s_province').val()+","+$('#s_city').val()+","+$('#s_county').val()+","+$('#userAddress').val();
			$('#userAddress_form').val(address);
		}
		//id清空
	  $("#conSumerUserDataId").val("");
	}
		$('#errorp').html("");
		$("#toPayOrder").attr("target","_blank");
		var pageDomainName="";
		if (window.location.pathname.indexOf("/pagehtml/") >= 0 && window.location.pathname.indexOf(".html") > 0) {
			pageDomainName=window.location.pathname.substring(window.location.pathname.lastIndexOf("/") + 1);
			$("#pageDomainName").val(pageDomainName);
		}
		var comdId=$("#spanNum").find('.span1'+sn).attr("data");  //规格id
		var goodsId=$("#goodsInfoDataId").val();
		var goodsNum=$('#order_goodsnum').val();
		var pcFlag="";
		$('#commodityConfigDataid_form').val(comdId);
		$('#goodsInfoDataid_form').val(goodsId);
		$("#goodsNum").val(goodsNum);
		//如果屏幕小于583  则走手机端支付
		if(pc_flag<583||pc_flag==583){
			$("#pcFlag").val("0");
			pcFlag="0";
		}
		var paytype=$(".redsolid_div").attr("data");
		if(paytype=="" || paytype==undefined){
			alert("请选择支付方式");
			return;
		}else{
			var money=$("#order_goodsprice").html();
			var url=$("#objectRoot").val()+"/order_manager/key/toPayOrder?" +
				"conSumerUserData.weixinOpenId="+openId+"&price="+money+"&paytype="+paytype;
			$("#toPayOrder").attr("action", url);
			$("#toPayOrder").submit();
			$("#order_paygoodsDiv").hide();
			 closePayforGood();
		}
			
}
function closePayforGood(){
	$("#paygoodsDiv").remove();
	$("#amount").val("1");
}
function closeorder_PayforGood(){
	$("#order_paygoodsDiv").hide();
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
/**
 * 查看常用地址
 * @param content  内容前一段
 * @param html1 后一段 用于拼接
 */
function ajaxConSuerWeixin(content,html1){
	$.ajax({
		type : "POST",
		url :  $("#objectRoot").val() + '/order_manager/key/payfor_orderGood',
		data : 'conSumerUserData.weixinOpenId='+openId,
		success : function(data) {
			if (data!="1") {
				var html="";
				var  html3="";
				var con=""
				 var list = eval("(" + data + ")");
					for(var i in list){ 
						if(list[i].userName!=""){
						//数据第一条默认显示在页面
			          if(i==0){
			        	   html="<div class=\"orderTitle\">常用地址</div><div class=\"order_hr_s\"></div>"
								+"<div class=\"order_changyong order_changyong_1\" >" 
								+"<label id=\"order_checkradio\"><input type=\"radio\" name=\"radio\" onclick=\"radio(this)\" id=\"checked\" data='"+list[i].id+"'/> </label>"
								+"<label id=\"order_name\" >" +list[i].userName
								+"</label>"
								+"<label id=\"order_phone\">"+list[i].userMobile
								+"</label>"
								+"<label id=\"order_address\">"+list[i].userAddress
								+"</label>"
								+"</div>";
			          }
			           //第一条以后的数据点击“查看更多”才显示出来
			            if(i>0){
			        	 con +="<div class=\"order_changyong\">" 
							+"<label id=\"order_checkradio\"><input type=\"radio\" name=\"radio\" onclick=\"radio(this)\" data='"+list[i].id+"'/> </label>"
							+"<label id=\"order_name\" >" +list[i].userName
							+"</label>"
							+"<label id=\"order_phone\">"+list[i].userMobile
							+"</label>"
							+"<label id=\"order_address\" >"+list[i].userAddress
							+"</label>"
							+"</div>";
			          }
					}  
			  }
					//当查询的有常用地址的数据，页面显示
			     if(list.length>1){
			    	 var sum=html+"<div style=\"margin-left: 5%;\"><a href=\"###\" onclick=\"selectAddress()\" id=\"selectAddress_a\">查看更多</a></div>" +
	        	  		"<div  id=\"selectAddress\" style=\"display: none;\">"+con+
	        	  		"<div class=\"div8\" style=\"height:50px;\"><input type=\"button\" value=\"返回\" onclick=\"closeselectAddress()\"></div></div>";
			    	 content=content+sum+html1;
			     }else{
			    	 //没有数据不显示
			    	 content=content+html+html1;
			     }
			}else{
				content=content+html1;
			}
			if($("#spanNum").find('.span1'+sn).attr("data")!="" && $("#spanNum").find('.span1'+sn).attr("data")!=undefined  && $("#goodsInfoDataId").val()!=""){
				if($("#paygoodsDiv").html()){
					$("#userName").val("");
					$("#userMobile").val("");
					$("#userAddress").val("");
					$("#errorp").html("");
					$("#paygoodsDiv").show();  //确认订单显示
					$("#order_paygoodsDiv").hide();
				}else{
					$("#goodsDiv").append(content);
					$("#paygoodsDiv").show();  //确认订单显示
					$("#order_paygoodsDiv").hide();
				}
				//初始化省市县下拉框三级联动
				_init_area();
			}else{
				alert("商品信息不正确，请联系页主！");
			}
		}
	});
	
}
/**
 * 单选框点击事件
 * @param con
 */
function radio(con){
	//消费者名称
	var name=$(con).parent().next("#order_name").html();
	//消费者电话号码
	var phone=$(con).parent().next().next("#order_phone").html();
	//消费者地址
	var address=$(con).parent().next().next().next("#order_address").html();
	//消费者id
	var conSumerUserDataId=$(con).attr("data");
	//获取选择的所以的内容
	var html=$(con).parent().parent("div").html();
	//常用地址第一条数据
	var html_1=$(".order_changyong_1").html();
	//表单替换数据
	$('#userAddress_form').val(address);
	$('#userName_form').val(name);
	$('#userMobile_form').val(phone);
	$('#conSumerUserDataId').val(conSumerUserDataId);
	//表示选择了常用地址，那么下面新增地址不走数据是否为空判断
	$("#radioCkecked").val("radio");
	$("#selectAddress").hide();
	$("#selectAddress_a").show();
	//替换成已经选择的数据
	$(".order_changyong_1").html(html);
	$(con).parent().parent("div").html(html_1)
	$(".div4").show();
	$(".div8").show();
	$(".div9").show();
	//获取常用地址的所以单选框，第一个添加默认选中
	 var rObj = document.getElementsByName("radio");
     for(var i = 0;i < rObj.length;i++){
         if(i==0){
             rObj[i].checked =  'checked';
         }
     }
}
/**
 * 查看更多地址按钮
 */
function selectAddress(){
	$("#selectAddress").show();
	$("#selectAddress_a").hide();
	$(".div4").hide();
	$(".div8").hide();
	$(".div9").hide();
}
/**
关闭
*/
function closeselectAddress(){
	$("#selectAddress_a").hide();
	$(".div4").show();
	$(".div8").show();
	$(".div9").show();
}
/**
 * 加载红包信息
 */
function getRedPackage(){
	var pageId=$("#pageId").val();
	if(openId!="null" || openId!=""){
		$.ajax({
		    async: false, 
		    url: redPackageroot+"/siims/vmaque/snatchPackage/getGoumaiSnatchPackageUserData.jspx", 
		    type: "GET", 
		    dataType: 'jsonp', 
		    //jsonp的值自定义,如果使用jsoncallback,那么服务器端,要返回一个jsoncallback的值对应的对象. 
		    jsonp: 'jsoncallback', 
		    //要传递的参数,没有传参时，也一定要写上 
		    data:"snatchPackageUserData.pageId="+pageId+"&snatchPackageUserData.openId="+openId, 
		    timeout: 5000, 
		    //返回Json类型 
		    contentType: "application/json;utf-8", 
		    //服务器段返回的对象包含name,data属性. 
		    success: function (result) { 
		    	if(result.redPackage!="1"){
		    		$("#redPackageSelect").html("");
			        var json = eval('(' + result.redPackage + ')'); 
			        var list=json.data;
			        var option="<option value=\"false\" rid=\"\" sid=\"\" cid=\"\" selected=\"selected\" >选择红包信息</option>"; 
			        for (var i = 0; i < list.length; i++) {
						option +="<option value=\""+list[i].snarchPrice.trim()+"\" " +
								"sid='"+list[i].id.trim()+"' rid='"+list[i].redpackageId.trim()+"'" +
								"cid='"+list[i].collarPackageUserId.trim()+"'>"
								+decodeURI(list[i].redPackageName.trim())+list[i].snarchPrice.trim()+"元</option>"
					}
			        $("#redPackageSelect").append(option);
		    	}
		    }, 
		    error: function (jqXHR, textStatus, errorThrown) { 
		        alert("出现异常"); 
		    } 
		})
	}
}
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
function changeTwoDecimal(x){
	var f_x = parseFloat(x);
if (isNaN(f_x)){
	return false;
	}
f_x = Math.round(f_x *100)/100;

	return f_x;
}
//下拉框 选择事件
function selectRed(s)
{
	var price=$(s).val();
    //为禁用类型原因赋值，用于js取值
    $("#changDis").val(price);
    $("#changDis").attr("rid",$(s).attr("rid"));
    $("#changDis").attr("sid",$(s).attr("sid"));
    $("#changDis").attr("cid",$(s).attr("cid"));
    var sumprice=parseFloat($("#goodsPrice").html())*parseFloat($("#amount").val());
    if($("#changDis").val()!="false"){
    	//changDis的值不为空说明用户选择了红包，那么单价得减去红包
    	var onePrice = parseFloat($("#goodsPrice").html());//单价
    	var redPrice = parseFloat($("#changDis").val());//红包
    	if(onePrice > redPrice){
    		onePrice = onePrice - redPrice;
            sumprice = onePrice*parseFloat($("#amount").val());
            $("#order_goodsprice").html(""+Math.round(sumprice*100)/100);
    	}else{
    		$("#order_goodsprice").html("0");
    	}
    	//改变 订单价格
    	//$("#order_goodsprice").html(changeTwoDecimal(sumprice-parseFloat( $("#changDis").val())));
    }else{
    	$("#order_goodsprice").html(changeTwoDecimal(parseFloat($("#goodsPrice").html())*parseFloat($("#amount").val())));
    }
}

