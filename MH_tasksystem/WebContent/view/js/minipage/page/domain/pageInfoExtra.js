/**

 * 弹出绑定域名层
 */
function bundlingDomain(i,pageId){
	title="绑定独立域名";
	content = "<table><tr style='height: 8px;'></tr><tr class='page_manager_domain_table_tr'></tr>"
		+"<tr><td><span class='page_manager_domain_span'>敬请期待！</span> </td></tr><tr></tr></table>"; 
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
//	$.ajax({
//		type : "POST",
//		url : root + '/page_manage/key/ckeckPageInfoExtraData',
//		data : 'pageData.id=' + pageId,
//		success : function(data) {
//			if(data=='3'){
//				title="绑定独立域名";
//				content = "<table><tr style='height: 8px;'></tr><tr class='page_manager_domain_table_tr'></tr>"
//					+"<tr><td><span class='page_manager_domain_span'>请先发布商站！</span> </td></tr><tr></tr></table>"; 
//				new bombBox('myDlymDiv', 'thisDlymtype', {
//					title : title,
//					content : content,
//					width : '500',
//					height : '180',
//					top : '',
//					left : '',
//					fixed : 'fixed',
//					close : 'close'
//				});
//				$("#myDlymDiv").click();
//			}else{
//				$("#div"+i).fadeIn(500);
//			}
//		}
//	});
}
/**
 * 保存绑定的一级域名
 * @return
 */
function savedmain(i){
	
	var	title="绑定独立域名";
	var	content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
		+"<tr><td><span style='color:#888888;font-size:20px;margin-left:35px;'>二级域名存在，但还未发布商站，请先发布商站！</span> </td></tr><tr></tr></table>"; 
	var domain = $("#domainName"+i).val();
	var pageId = $("#pageId"+i).val();
	var pageInfoExtraId = $("#pageInfoId"+i).val();
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
		if(domain!= ""){
			 if(confirm('你确认要绑定独立域名吗？')){
				   
				if (!re.test(domain)) {
					alert("你输入的独立域名不合格！请重新输入")
					return false;
					}else{
				$.ajax( {
					dataType:"text",
					type : "POST",
					url : root + '/page_manager/key/boundPageInfoExtraInfo',
					data : "pageId="+pageId+"&domain="+domain,					
					success : function(data) {
						if(data==2){
							$("#div2").hide();
							new bombBox('myDlymDiv', 'thisDlymtype', {
								title : title,
								content : content,
								width : '500',
								height : '150',
								top : '',
								left : '',
								fixed : 'fixed',
								close : 'close'
							});
							$("#myDlymDiv").click();
						
						}else{
						window.location.href=root+"/page/key/getAllPageInfo";
						}
					}
				});
		}
 }
		}else{
		alert("独立域名不能为空！");
	return false;
	}
}

/**
 * 解除绑定一级域名
 * @param i
 * @return
 */
function unBundlingDomain(i){
	if(confirm("确认解绑！")){
	var oneid = $("#oneid"+i).val();
	var twoid = $("#twoid"+i).val();
	window.location.href=root+"/page/key/unBundlingDomain?oneid="+oneid+"&twoid="+twoid;
	}
}
/**
 * 检查域名绑定情况
 * @param name
 * @return
 */
function openwin(name){
	window.open("http://"+name,name,"_top",true);
}

/**
 * 切换绑定
 * @return
 */
var alongDomainId;
var twoLeaveid;
function showdiv(i){
//	$("#bing").fadeIn(500);
	alongDomainId = $("#oneid"+i).val();
	twoLeaveid = $("#twoid"+i).val();
}

/**
 * 保存切换绑定
 * @param pageid
 * @return
 */
function togglePage(pageid,erid){
	$("#bing").fadeToggle(1);
	var url = root+"/page/key/switchBundling?alongDomainId="+alongDomainId+"&twoLeaveid="+twoLeaveid+"&pageid="+pageid+"&erid="+erid;
	$.ajax({
		type : 'POST',
		cache:false,
		url : url,
		dataType : "text",
		success : function(data) {
		if(data=='success'){
			alert("切换成功!");
			window.location.href=root+"/page/key/getAllPageInfo";
		}
		}
	});
}
/**
 * 保存二级域名
 * @return
 */
function saveTwoDomain(){
	var domainId = $("#domainId").val();
	var domainName = $("#domainName").text();
	var lastName = $("#lastName").val();
	var pageId = $("#pageId").val();
	var pageName = $("#pageName").val();
	var company = $("#company").val();
	var param = "{'domainName':'"+domainName+lastName+"'}";
	var json = getAsyncAjax(root+"/page/key/checkDomainIsUse?pageDatadomain="+domainName, null);
	if(json=="1"){
		//alert("该二级域名已存在！");
		return;
	}
	pageName = encodeURIComponent(pageName);
	var value = "{'pageId':'"+pageId+"','pageName':'"+pageName+"','domainName':'"+domainName+"','lastName':'"+lastName+"','company':'"+company+"','domainId':'"+domainId+"'}"
	var url = root+"/page/key/addTwoDomain?json="+encodeURIComponent(value);
	
		if(!checkSub($("#fengxin"))){
			return;
		}
		$.ajax({
			type : 'POST',
			cache:false,
			url : url,
			dataType : "text",
			success : function(data) {
			$("#pageName").attr("disabled",true);//将page名称和二级域名在保存成后,设置成不可编辑状态
			$("#lastName").attr("disabled",true);
			var json = eval('('+data+')');
			var noPayState = $("#noPayState").val();
			if(noPayState=='0'){
				/*var content="<div class='' id=''><div class='page_pb_success_div_in_div'>"
					+"<div style='left: 30px; top: 10px; width: 480px; height: 100px; position: absolute;font-size:15px;'>"
					+"<div id='wangyeName' style='margin-left: 0px;'>商站名称："+decodeURIComponent(json.pageName)+"</div><div id='pageaddress' style='margin-top: 10px;'>微站网址："+json.pageaddress+"</div></div></div>"
					+"<div class='page_pb_success_div_in_div_tip' style='margin-top: 10px;'>OK，你已经将网页发布到互联网上，所有网民都可以访问到你的商站了。快去推广吧！</div>"
					+"<div class='page_pb_success_div_in_div_managerBtn' ><a class='page_pb_success_div_in_div_Btn' href='"+root+"/mini_index.jsp' target='_parent'>进入管理页面</a>"
					+"</div><div class='page_pb_success_div_in_div_managerBtn2'>"
					+"<a class='page_pb_success_div_in_div_Btn'style='background:linear-gradient(to bottom, #00a0b1 0%,#008299 100%);color:#FFFFFF;'   href='#' onclick='visitPage()'"
					+">访问商站</a></div></div>";*/
				
				
				$.ajax({
					type : "POST",
					url : root + '/page_manage/key/sharePage',
					data : 'pageData.id=' + pageId,
					success : function(data1) {
						if(data1!=0){
							var imgUrl=data1.substring(0,data1.indexOf('&'));   //截取出二维码大图地址
							var img=root+imgUrl;   //大图完整路径
							var url1=root+"/page_manage/key/toWeixin?ImgUrl="+img+"&domain="+json.pageaddress+"&pageName="+pageName;
							var content = "<div style='width: 597px;height: 570px;'>" +
									"<div class='weixinDivTop'>手机分享，用微信扫一扫</div>" +
									"<div class='weixinDivTop_img'>" +
									"<img  src='"+img+"' >" +
								    "<p class='weixinDivTop_p '><a href='"+url1+"' target='_blank'>怎么分享？</a></p>" +
								    "</div>" +
								    "<div class='wexinDiv_hr'></div>" +
								    "<div class='weixininput'>" +
								    "<a    href='"+root+"/page_manage/key/getAllPaga?menuNum=1' target='_parent'>进入管理页面</a>" +
								    "<a   onclick='visitPage()'" +
								    " href='###'>访问商站</a></div></div> <input type='hidden'  value='"+img+"'   class='imgUrl'>";
							new bombBox('publicSuccess', 'myOpDiv1', {
								title : "发布成功",
								content : content,
								width : '597',
								height : '580',
								top : '',
								left : '',
								fixed : 'fixed',
								close : 'close'
							});
							$("#publicSuccess").click();
						}else{
							return false;
						}
					}
				});
				
				
			}else{
						$("#shoppingCartDivPage").show();
						
			}
			}
		});
}

/**
 * 访问页面 按钮触发方法
 * @return
 */
function visitPage(){
	var lastName = $("#lastName").val();
	var firstName = $("#domainName").html()
	window.open (firstName+lastName+".html");
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
function closeDIV(){
	/*document.getElementById("makeError").style.display = "none";
	history.back();*/
	var url = root+"/page_manage/key/zancun?pageData.id="+$("#pageId").val()+"&pageData.status=0";
	$.ajax({
		type : 'POST',
		cache:false,
		url : url,
		dataType : "text",
		success : function(data) {
			window.location.href=root+"/page_manage/key/editPageState?pageData.id="+$("#pageId").val();
		}
	});
	
}
function turnPayForAction(){
	$.ajax({
		type : 'POST',
		cache:false,
		url : root+"/page/key/changePageState?pageData.id="+$("#pageId").val(),
		dataType : "text",
		success : function(data) {
			getAsyncAjax(root+"/shopping_cart/key/editNoPayProductState?noPayPageId="+$("#pageId").val()+"&noPayProductID="+$("#noPayProductID").val());
		}
	});
	window.location.href=root+"/shopping_cart/key/getAll?sign=1";
}

