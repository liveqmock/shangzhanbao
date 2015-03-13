var Id='';
var PageId='';
var Type='';
var YuMing='';
var PageName='';

$(function(){
	
	
	
	$(".pageNameOver").mouseover(function(){
	
			
	});
	/**
	 * page分享
	 */
	$(".share").live("click",function(){
		var pageId=$(this).attr("data");
		var domain=$(this).attr("data1");
		var pageName=$(this).attr("data2");
		$.ajax({
			type : "POST",
			url : root + '/page_manage/key/sharePage',
			data : 'pageData.id=' + pageId,
			dataTyep: "text",
			success : function(data) {
				if(data!=0){
					var title="分享";
					var imgUrl=data.substring(0,data.indexOf('&'));   //截取出二维码大图地址
					var img=root+imgUrl;   //大图完整路径
					var imgUrlmin=data.substring(data.indexOf('&')+1,data.lastIndexOf('f')+1);   //截取出二维码小图地址
					var imgmin=root+imgUrlmin;
					var  url="/share.jsp?imgUrl="+imgmin+"&domain="+domain+"&pageName="+escape(encodeURIComponent(pageName))+" ";
					var content="<div class='ZingDiv'>" +
							"<div class='ZingImg'>" +
							"<img   src='"+img+"'>" +
							"</div>"+
							"<div class='ZingBtn'>" +
							"<span>更多分享：</span>" +
							"<iframe src='"+url+"' style='border: 0;width: 200px;padding-left: 30%;padding-top: 3%;'></iframe>" +
							"</div>" +
							"</div>";
					new bombBox('ZingDivA', 'thisDistype', {
						title : title,
						content : content,
						width : '567',
						height : '365',
						top : '',
						left : '',
						fixed : 'fixed',
						close : 'close'
					});
					$("#ZingDivA").click();
				}else{
					return false;
				}
			}
		});
		
	})
	


});

function overPageName(pageId){
	var dom=	$(".pageDomain_"+pageId).val();
	var name=  $(".pageName_"+pageId).val();
	  if(dom!=""){
		  if(name!=""){
			  $(".pageHref_"+pageId).html("设置")
		  }
	  }
}

function downPageName(pageId){
	var dom=	$(".pageDomain_"+pageId).val();
	var name=  $(".pageName_"+pageId).val();
	  if(dom!=""){
		  if(name!=""){
			  $(".pageHref_"+pageId).html(" ")
		  }
	  }
}
// 删除
function deletePaga(id) {
    if(confirm('你确认删除该商站吗，删除之后将无法恢复？？')){
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/deletePageDateById',
		data : 'pageData.id=' + id,
		success : function(data) {
			$('#' + id).hide();
			window.location.href=root+"/page_manage/key/getAllPaga";
		}
	});
    }
}

// 设置
function extraUpdate(id, pageId,type,yuMing,pageName) {
	Id=id;
	PageId=pageId;
	Type=type;
	YuMing=yuMing;
	PageName=pageName;
	var name="";
	var content="";
	var title="";
	var path=$("#path").val();
	if(type==''){
		if(pageName == name){
			$('#repageId').val(pageId);
			title="设置";
			content="<form id='pageDomonclick' action=''>"
					+"<table>"
					+"<tr><td><div class='pageManager_editDomain_div'>"
					+"<div class='pageManager_editDomain_div_in_div'>"
					+"<p class='pageManager_editDomain_div_p'>商站名称:</p>" +
					"<p><input type='text' value='' class='pageNmae' name='' style='width: 225px; height: 30px;margin:10px 0px 0px -52px;m' max2='60' notnull='不能为空'></p>"
					+"<P style='text-align: left; margin-left: -50px; margin-top: 10px;'>访问网址:<label id='domaiName' style='table-layout: fixed;word-break: break-all;'>"
					+path
					+"</label><input  style='width:225px;height:30px;margin-top:10px;' type='text'  max2='16' engOrDigit='只能填写英文或者数字' notnull='不能为空'	value='' class='pageDom' name=''"
					+"ajax='"
					+root
			        +"/page/key/checkDomainIsUse,pageDatadomain,0,域名已被占用'	style='width: 200px; height: 30px; margin-left: 50px; margin-top: 10px;'>"
					+"<span id='dlym' style='margin-left: 50px;'></span></p></div></div></td></tr>"
					+"<td><input type='button' class='pageManager_editDomain_div_Btn' value='提 交' id='name_pageDomonclick' onclick='pageDomonclick()'>"
					+"</td></tr><tr></tr></table><div class='error' style='margin-left: 75px;position: absolute;margin-top: 170px;display:none ;'></div></form>"
		}	
	}
	
	if(type=='1'){
		title="独立域名";
		content="<form id='submitSZDLYU' action=''>" 
				+"<div class='DataStatistics_1' style='left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;'>"
				+"<div style='left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;'>"
				+"<table><tr><td><p style='text-align: left; margin-left: -50px; margin-top: 15px;'>商站名称:<input type='text' value='"+pageName+"' id='pageNameEjym' name='' style='width: 240px; height: 30px; margin-left: 10PX;' ></p>"
				+"<P style='text-align: left; margin-left: -50px; margin-top: 15px;'>独立域名:"+ yuMing +"</P></div></div></td></tr>" +
						"<tr><td><div class='error' style=' margin-left: 30px;display:none ;'></div></td></tr>"
				+"<tr style='height:40px;'><td></td></tr><tr><td><input type='button' value='提 交' id='name_pageDomonclick' onclick='submitSZDLYU()' style='font-size:15px;width: 400px; height: 30px; margin-left: -83px; border:1px solid #00a0b1;background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;'>"
				+"</td></tr><tr></tr></table></form>"
		
	}
	if(type=='2'){
		title="设置";
		content="<form id='submitForm' action=''>"
			+"<div class='DataStatistics_1' style='left: 40px; top: 60px; width: 420px; height: 180px; position: absolute;'>"
			+"<div style='left: 80px; top: 10px; width: 420px; height: 140px; position: absolute;'>"
			+"<table><tr><td><p style='text-align: left; margin-left: -50px; margin-top: 40px;'>商站名称:<input type='text' value='"+pageName+"' id='pageNameEjym' name='' style='width: 240px; height: 30px; margin-left: 10PX;' ></p>"
			+"<p style='text-align: left; margin-left: -50px; margin-top: 10px;float:left;'>访问网址：</p>    <lable id='ejym' style='margin-top: 10px;width: 200px;float: left;table-layout: fixed;word-break: break-all;'>"
			+path+YuMing
			+"</lable>"
			+"</div></div></td></tr><tr><td><div class='error' style='position: absolute;margin-top: 15px; margin-left: 33px;display:none ;'></div></td></tr>" +
					""
			+"<tr style='height:60px;'><td></td></tr><tr><td><input type='button' id='name_pageDomonclick' value='提 交' onclick='submitEjYuMing()' style='font-size:15px;width: 420px; height: 30px; margin-left: -83px; border:1px solid #00a0b1;background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;'>"
			+"</td></tr><tr></tr></table></form>";		
	}
	if(type=='1'){
		new bombBox('myOpDiv', 'thistype', {
			title : title,
			content : content,
			width : '500',
			height : '250',
			top : '',
			left : '',
			fixed : 'fixed',
			close : 'close'
		});
	}else{
		new bombBox('myOpDiv', 'thistype', {
			title : title,
			content : content,
			width : '500',
			height : '330',
			top : '',
			left : '',
			fixed : 'fixed',
			close : 'close'
		});
	}
	
	$("#myOpDiv").click();
	
}

//提交二级域名-----设置
function submitEjYuMing(){
	var name = $('#pageNameEjym').val();
	var help = $('#helpYm').val();
	if(name==""){
		$(".error").html("商站名称不能为空！");
		$(".error").show();
		return false;
	}
	$("#name_pageDomonclick").attr("disabled","disabled");
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/updatePageInfoExtraData',
		data : 'pageInfoExtraData.id=' + Id + '&pageInfoExtraData.pageId='+PageId+'&pageData.name='+name

+'&pageInfoExtraData.domain='+YuMing+'&pageInfoExtraData.type='+Type+'&helpYm='+help,
		success : function(data) {
			window.location.reload();
		}
	 }); 
}


//提交独立域名-----设置
function submitSZDLYU(){
	var name = $('#pageNameEjym').val();  
	if(name==""){
		$(".error").html("商站名称不能为空！");
		$(".error").show();
		 return ;
		}else{
			 if(Len(name)>12)
			   {
			  return ;
			   }	
		}
	$("#name_pageDomonclick").attr("disabled","disabled");
    $.ajax({
		type : "POST",
		url : root + '/page_manage/key/updatePageInfoExtraData',
		data : 'pageInfoExtraData.id=' + Id + '&pageInfoExtraData.pageId='+PageId+'&pageData.name='+name

+'&pageInfoExtraData.domain='+YuMing+'&pageInfoExtraData.type='+Type,
		success : function(data) {
			window.location.reload();
		}
	 });

}


// 升级权限
function shengjiQuanXian(pageId) {
	$("#btn_shengjiQuanxian").attr("disabled","disabled");
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/getPrivilegeData',
		success : function(data) {
			$("#btn_shengjiQuanxian").removeAttr("disabled");
			if (data == '1') {
				$.ajax({
					type : "POST",
					url : root + '/page_manage/key/getUserPrivateNumber',
					success : function(data) {
						var title="升级发布权限";
						var content="<div class='DataStatistics_1'  style='left: 50px; top: 80px; width: 400px; height: 100px; position: absolute;'>"
							+"<div style='left: 80px; top: 10px; width: 400px; height: 100px; position: absolute;'><p style='text-align: left;margin-left:-50px;color: red;'>你还有"
							+data
							+"个发布权限可使用</p></div></div></div>"
							+"<table style='margin-top: 150px;margin-left: 30px;'><tr style='height: 40px;'></tr><tr></tr>"
							+"<tr><td> <input type='button' value='取消'  style='font-size:15px;width: 180px;height:40px;background-color: #DDDDDD ;margin-left: 30px;' onclick='quxiao()' >" 
							+" <input type='button' value='升级'  style='font-size:15px;width: 180px;height: 40px;background-color: #444444;color: #ffffff;' onclick=\"sjfbquanxian('"+pageId+"')\"> </td></tr><tr></tr></table>"
						 	new bombBox('sjfbquanxian', 'sjfbquanxianDiv', {
								title : title,
								content : content,
								width : '500',
								height : '300',
								top : '',
								left : '',
								fixed : 'fixed',
								close : 'close'
							});
							$("#sjfbquanxian").click();
					}
				});
			} else if (data == '0') {
				new bombBox('fabuquanxian', 'box', {
					title : '提示',
					content : '<div class="pageManager_fabuquanxian_div">没有发布权限，是否进入购物车购买发布权限？</div><div class="pageManager_fabuquanxian_div_in_div"><button class="pageManager_fabuquanxian_div_Btn">取消</button><input type="button" class="pageManager_fabuquanxian_div_BuyBtn" onclick="bugFabuquanxian()" value="购买" /></div>',
					width : '400',
					height : '180',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#fabuquanxian").click();
				/*window.location.href = root+"/shopping_cart/key/updateSaveShoppingCartData?sign=2";*/
			}
		}
	});
}
function bugFabuquanxian(){
	window.location.href = root+"/shopping_cart/key/updateSaveShoppingCartData?sign=2";
}


//续费功能;

function xuFeiQuanXian(pageId) {
	var lp=1;
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/getPrivilegeData',
		success : function(data) {
			if (data == '1') {// 已有发布权限---可以升级
                if(confirm('确定操作吗？')){
				$.ajax({
					type : "POST",
					url : root + '/page_manage/key/doPrivilegeData',
					data : 'pageData.id=' + pageId+'&pageData.lp='+lp,
					success : function(data) {
						alert('续费成功!');
						window.location.reload();
					}
				});
                }

			} else if (data == '0') {
				alert('没有发布权限,不可操作');
			}
		}
	});
}



//独立域名
function duliYuMing(pageId,domain) {
	$("#name_pageDomonclick").attr("disabled","disabled");
	$('#repageId').val(pageId);
	var content="";
	var title="";
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/ckeckPageInfoExtraData',
		data : 'pageData.id=' + pageId,
		success : function(data) {
			if(data==1){
					title="绑定独立域名";
					content = "<table><tr style='height: 8px;'></tr><tr class='page_manager_domain_table_tr'></tr>"
						+"<tr><td><span class='page_manager_domain_span'>还未设置二级域名，请先设置二级域名！</span> </td></tr><tr></tr></table>"; 
				
			}else if(data==0){//不存在独立域名
				title="绑定独立域名";
				content="<div style=''></div><form action='' id='DlymFrom'><table><tr><td><div class='pageManager_duliDomain_div' >"
						+"<div class='pageManager_duliDomain_div_div'>"
						+"<p class='pageManager_duliDomain_div_div_p'>1.请先去域名服务提供商申请一个独立域名</p><p class='pageManager_duliDomain_div_div_p'>2.如果你已申请或者有备用域名，请在下面输入域名：</p>"
						+"<input type='text' value='' class='pageManager_duliDomain_div_div_Btn' id='didomain' name='' notnull='独立域名不能为空!'></div></div></td></tr>"
						+"<tr><td><input type='button' value='提交' onclick='submitDuLiYuMing()' style='font-size:15px;width: 400px; height: 30px; align:center; margin-top: 170px;margin-left: 20px; border:1px solid #00a0b1;background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;'>	</td></tr>"
						+"<tr style='height: 10px;'></tr><tr style='height: 10px;'></tr><tr><td><h5>推荐域名服务提供商：</h5></td></tr><tr style='height: 10px;'></tr>"
						+"<tr><td><a target='_blank' href='http://www.baidu.com' style='color: blue;'>百度</a> &nbsp; &nbsp;&nbsp; <a href='http://www.google.com' target='_blank' style='color: blue;'>谷歌</a></td></tr></table></from>"
			}else if(data==2){
				title="绑定独立域名";
				content = "<table><tr style='height: 8px;'></tr><tr class='page_manager_domain_table_tr'></tr>"
					+"<tr><td><span class='page_manager_domain_span'>二级域名存在，但还未发布商站，请先发布商站！</span> </td></tr><tr></tr></table>"; 
			}else if(data==3){
				title="绑定独立域名";
				content = "<table><tr style='height: 8px;'></tr><tr class='page_manager_domain_table_tr'></tr>"
					+"<tr><td><span class='page_manager_domain_span'>请先发布商站！</span> </td></tr><tr></tr></table>"; 
			}else{
				title="独立域名"
				content="<table><tr><td><div class='DataStatistics_1' style='left: 50px; top: 60px; width: 400px; height: 120px; position: absolute;'>"
						+"<div style='left: 80px; top: 10px; width: 400px; height: 80px; position: absolute;'><p style=''text-align: left; margin-left: -50px; margin-top: 5px;'>该商站已绑定独立域名</p></div></div></td></tr>"
						+"<tr><td> 	<div style='width: 400px; height: 40px; margin-left: 50px; background-color: #444444; margin-top: 160px; line-height: 37px;text-align: center;'> <a href='"+domain+"'  target='_blank' style='color: #FDF5E6;font-size: 17px;' >检查绑定情况</a></div></td></tr><tr></tr></table>"
				
			/*	$(".domainYesDiv").show();*/
			};
			if(data==0){
				new bombBox('myDlymDiv', 'thisDlymtype', {
					title : title,
					content : content,
					width : '460',
					height : '340',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#myDlymDiv").click();
			}else  if(data==1){
				new bombBox('myDlymDiv', 'thisDlymtype', {
					title : title,
					content : content,
					width : '500',
					height : '200',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#myDlymDiv").click();
			}else  if(data==2){
				new bombBox('myDlymDiv', 'thisDlymtype', {
					title : title,
					content : content,
					width : '500',
					height : '200',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#myDlymDiv").click();
			}else  if(data==3){
				new bombBox('myDlymDiv', 'thisDlymtype', {
					title : title,
					content : content,
					width : '500',
					height : '180',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#myDlymDiv").click();
			}
		}
	});
}

//提交绑定独立域名
function submitDuLiYuMing(){
	$("#name_pageDomonclick").attr("disabled","disabled");
	var domain = $('#didomain').val();
	if(!checkSub($("#DlymFrom"))){
		return;
	}
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
		+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
		+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
		+ "|" // 允许IP和DOMAIN（域名）
		+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
		+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
		+ "[a-z]{2,6})" // first level domain- .com or .museum
		+ "(:[0-9]{1,4})?" // 端口- :80
		+ "((/?)|" // a slash isn't required if there is no file name
		+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re = new RegExp(strRegex);
	if (!re.test(domain)) {
		$(".error").html("你输入的独立域名不合格！请重新输入");
		$(".error").show();
		return false;
	} else {
		$.ajax({
			type : "POST",
			url : root + '/page_manage/key/addPageInfoExtraData',
			data : 'pageData.id='+ $('#repageId').val()+'&pageInfoExtraData.domain='+domain,
			success : function(data) {
				if(data==1){
					alert('绑定独立域名成功');
					window.location.reload();
				} 
			}
		});
		
	}

}


/*当page名称为新建page  和域名为空时，设置域名*/
function pageDomonclick(){
	var pageNamedd=$(".pageNmae").val();
	var pageDom=$(".pageDom").val();
	var id=$('#repageId').val();
	var domainName = $("#domaiName").html();
	var param = "{'domainName':'"+domainName+pageDom+"'}";
	var json = getAsyncAjax(root+"/page/key/checkDomainIsUse?pageDatadomain="+pageDom, null);
	if(json=="1"){
		$(".error").html("该二级域名已存在！");
		$(".error").show();
		return;
	}
	if(pageNamedd==''){
		$(".error").html("你输入的独立域名不合格,请重新输入！");
		$(".error").show();
		return;
	}
	if(pageDom==''){
		$(".error").html("二级域名不能为空");
		$(".error").show();
		return;
	}
	var filter = /^(?!_)(?!-)[a-zA-Z_-]*[a-zA-Z0-9_-]+$/;
	if(!filter.exec(pageDom)){
		$(".error").html("二级域名不合法！");
		$(".error").show();
		return;
	}	
	$("#name_pageDomonclick").attr("disabled","disabled");
	pageNamedd = encodeURIComponent(pageNamedd);
	var value = "{'pageId':'"+id+"','pageName':'"+pageNamedd+"','domainName':'"+domainName+"','lastName':'"+pageDom+"'}"
	var url = root + '/page/key/aloneSetTwoDomain?json='+encodeURIComponent(value);
	 $.ajax({
			type : "POST",
			cache:false,
			url : url,
			dataType : "text",
			success : function(data) {
				window.location.reload();
			}
		 });
	

}

function closeSZEJdomainDiv(){
	$(".SZEJdomainDiv").hide();
}

function closeSZDLdomainDiv(){
	$(".SZDLdomainDiv").hide();
}
function closedomainYesDiv(){
	$(".domainYesDiv").hide();
}
function closedomainDiv(){
	$(".domainDiv").hide();
}
function closedname_pageDom(){
	$(".name_pageDom").hide();
}


/*
 * 获取异步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}


//可信网站未付钱  和未开通状态  div显示
function showProductDiv(price,status,pageId){
	if(status==1){
		if(price==0){
			$("#pricr_"+pageId).show();
		}
	}else{
		$("#state_"+pageId).show();
	}
	
}
//服务未付钱  和未开通状态  div显示
function showProductServiceDiv(price,status,pageId){
	if(status==1){
		if(price==0){
			$("#pricr_"+pageId).show();
		}
	}else{
		$("#state_"+pageId).show();
	}
	
}
//服务未付钱  和未开通状态  div隐藏
function CloseProductDiv(pageId){
	$("#state_"+pageId).hide();
	$("#pricr_"+pageId).hide();
}


function Len(str)
{
     var i,sum;
     sum=0;
     for(i=0;i<str.length;i++)
     {
         if ((str.charCodeAt(i)>=0) && (str.charCodeAt(i)<=255))
             sum=sum+1;
         else
             sum=sum+2;
     }
     return sum;
}


/**
 * pageu管理页面 发布page 弹出未付款服务列表
 */
function publishPage(pageid,pageName,pagedomainName){
	// 发布之前查询是否有使用购买服务和收款账号
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/ajaxisExitReceivableAccount?pageData.id＝'+pageid,
		data : 'pageData.id='+ pageid,
		success : function(data){
			// 若用户存在收款账号，则让发布页面  反之提示用户需要添加收款账号
			if(data == "existence"){
				if(pageName==""||pagedomainName==""){
					window.location.href = root+"/page_manage/key/updatePageData?pageData.id="+pageid;
				}else{
					var path=$("#path").val();
					$.ajax({
						type : "POST",
						url : root + '/page_manage/key/publicPageState',
						data : 'pageData.id='+ pageid,
						success : function(data) {
							var addFbHtml = "<div>"+
							"<div class='edit_pb_success_div_div'>"+
							"<div class='edit_pb_success_div_only_div'><div>"+
							"<div style=\"height:10px;\"></div>"+
							"<font>商站名称："+pageName+"</font></div>"+
							"<div class='edit_pb_secondMond_font'><font>二级域名："+path+pagedomainName+"</font></div>"+
							"</div></div>"+
							"<div style=\"margin-top: 20px;margin-left: 50px;\">"+
							"<input class=\"pb_success_tip_Btn\" onclick=\"personalToGuanLi()\" type=\"button\" value=\"进入管理页面\" />"+
							"<input class=\"pb_success_tip_Btn2\"  onclick=\"personalToPage('"+path+pagedomainName+"')\" type=\"button\" value=\"访问商站\" />"+
							"</div></div>";
						window.parent.fabuSuccess(addFbHtml,"470","250");
						$(".hove").live("click",function(){
							window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
						});
						}
					});
				}
			}else{
				// 定义弹出提示层
				var toAddReceivableHtml = "<div id=\"addReceivable\" style=\"display:none;position:fixed;z-index:10;top:30%;right:30%;width: 520px;height: 165;background-color: gray;\">" +
										  "<img style=\"width: 89px;height: 92px;text-align: center;float: left;margin-left: 55px;margin-top: 45px;\" src=\"" + root + "/images/mini/purchase/buy/image_u289.png\">" +
										  "<div style=\"padding-top: 50px;padding-left:200px;\">" +
										  "<span style=\"font-family:'微软雅黑Regular','微软雅黑';font-size: 16px;color: #FFF;\">请补充收款账号，以免影响收款。</span><br>" +
										  "<span><a  style=\"margin-left: 5px;margin-top: 20px;background: none repeat scroll 0% 0% #F60;width: 100px;height: 40px;float: left;color: #FFF;font-size: 13px;text-decoration: none;line-height: 40px;text-align: center\" href=\"" +
										  root + "/user/key/toEditReceivableAccount\" >立即补充</a>" +
										  "<a  style=\"margin-left: 20px;margin-top: 20px;background: none repeat scroll 0% 0% #F60;width: 100px;height: 40px;float: left;color: #FFF;font-size: 13px;text-decoration: none;line-height: 40px;text-align: center\" href=\"###\" onclick=\"conFabu('"+pagedomainName+"','"+pageid+"')\">继续发布</a></span>" +
										  "</div></div>";
				$("body").append(toAddReceivableHtml);
				$("#addReceivable").show(300);
				var h=document.documentElement.clientHeight;
				var w=document.documentElement.clientWidth;
				var div="<div style='background-color: rgba(0,0,70,.1);position:fixed;border:0px solid;z-index:4;left:0;top:0;width:"+w+"px;height:"+h+"px;'></div>";
				$("body").append(div);
			}
		}
	})
}
/**
 * 跳转到管理页面
 */
function personalToGuanLi(){
	top.location.href=root+"/page_manage/key/getAllPaga";
}
/**
 * 跳转到page页面
 */
function personalToPage(pageLink){
	window.open(pageLink);
}
function personalTurnPayForAction(){
	window.location.href=root+"/shopping_cart/key/getAll?sign=1";
}
//关闭升级发布权限div
function quxiao(){
	$("#sjfbquanxianDiv").remove();
}

//升级发布权限操作
function sjfbquanxian(pageId){
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/doPrivilegeData',
		data : 'pageData.id=' + pageId+"&pageData.lp=1",
		success : function(data) {
			$("#sjfbquanxianDiv").remove();
			var content="<div style='margin-top:30px;font-size:15px;'>有效期为:" 
				+data
				+"</div>"
			new bombBox('sjfbquanxiancg', 'sjfbquanxiancgDiv', {
				title : '升级成功！',
				content :content ,
				width : '400',
				height : '200',
				top : '',
				left : '',
				fixed : 'fixed',
				close : 'close'
			});
			$("#sjfbquanxiancg").click();
			setTimeout("timeHide('sjfbquanxiancgDiv')",2000);//2秒后消失
			$(".hove").live("click",function(){
				window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
			});
		}
	});
}
function  closeSJFBQX(){
	$("#sjfbquanxiancgDiv").remove();
	window.location.reload();
}

function conFabu(domainName,pageid){
	if(domainName ==null || domainName == ""){
		window.location.href = root+"/page_manage/key/updatePageData?pageData.id="+pageid;
	}else{
		var path=$("#path").val();
		$.ajax({
			type : "POST",
			url : root + '/page_manage/key/publicPageState',
			data : 'pageData.id='+ pageid,
			success : function(data) {
				var addFbHtml = "<div>"+
				"<div class='edit_pb_success_div_div'>"+
				"<div class='edit_pb_success_div_only_div'><div>"+
				"<div style=\"height:10px;\"></div>"+
				"<font>商站名称："+pageName+"</font></div>"+
				"<div class='edit_pb_secondMond_font'><font>二级域名："+path+pagedomainName+"</font></div>"+
				"</div></div>"+
				"<div style=\"margin-top: 20px;margin-left: 50px;\">"+
				"<input class=\"pb_success_tip_Btn\" onclick=\"personalToGuanLi()\" type=\"button\" value=\"进入管理页面\" />"+
				"<input class=\"pb_success_tip_Btn2\"  onclick=\"personalToPage('"+path+pagedomainName+"')\" type=\"button\" value=\"访问商站\" />"+
				"</div></div>";
			window.parent.fabuSuccess(addFbHtml,"470","250");
			$(".hove").live("click",function(){
				window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
			});
			}
		});
	}
		
}
	//根据divId定时移除div
	function timeHide(divId){
		$("#"+divId).remove();
		window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
	}
	function  copyPage(pageId){
		$.ajax({
			type : "POST",
			url : root + '/page_manage/key/copyPage',
			data : 'pageData.id=' + pageId,
			success : function(data) {
				  content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
						+"</table>"; 
				new bombBox('copyPageDiv', 'copyPageDiv_', {
					title : '另存成功！',
					content :content ,
					width : '400',
					height : '200',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
				$("#copyPageDiv").click();
				setTimeout("timeHide('copyPageDiv_')",2000);//2秒后消失
				$(".hove").live("click",function(){
					window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
				});
			}
		});
	}
	//根据divId定时移除div
	function timeHide(divId){
		$("#"+divId).remove();
		window.location.href=root+"/page_manage/key/getAllPaga?menuNum=1";
	}