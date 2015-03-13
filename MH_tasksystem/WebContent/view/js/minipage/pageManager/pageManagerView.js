
	
	 $(function() {

			/**
			 * 禁用
			 */
		 $(".showDiv").click(function(){
			 
			 $("#pwdDiv").show();
			 $( "#dialog-message" ).dialog({
				 bgiframe: true,
				 resizable: false,
				 height:300,
				 width:450,
			      modal: true,
			      buttons: {
			    	  "提交修改": function() {
			    		  var pageId= $("#pageid").val();
			  	 		var disabledType=$("#disabledType").val();
			  		 	var disabledReason=$("#disabledReason").val();
			  			if(disabledType!=0){
			  				 if(confirm('你确认要禁用吗？')){
			  					$.ajax( {
			  						dataType:"text",
			  						type : "POST",
			  						url : root + '/page_manager/key/disabledPage',
			  						data : "pageHelpData.pageId="+pageId+"&pageData.disabledType="+disabledType+"&pageData.disabledReason="+disabledReason,					
			  						success : function(date) {
			  							alert("禁用成功！");
			  						window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
			  						$( this ).dialog( "close" );
			  						}
			  					});
			  				 }
			  			}else{
			  			alert("禁用类型不能为空！");
			  		return false;
			  		}
			        }
			      }
			    });

		 });
		 $(".showPower").click(function(){
			 
			 $("#PowerDiv").show();

		 });

		
 		/**
 		 * 解绑显示隐藏div
 		 */
 
 			 $(".dashow").click(function(){
 				 
 				 $("#daDiv").show();

 			 });
 			/**
 	 		 * 解绑div隐藏
 	 		 */
 	 
 	 			 $(".dashide").click(function(){
 	 				 
 	 				 $("#daDiv").hide();

 	 			 });
 	 			 /**
 	 			  * 解绑独立域名
 	 			  */
 		$(".dahuaPageInfoExtraInfo").click( function () {
	 		var pageId= $("#pageid").val();
			 if(confirm('你确认要解绑独立域名吗？')){
					$.ajax( {
						dataType:"text",
						type : "POST",
						url : root + '/page_manager/key/dahuaPageInfoExtraInfo',
						data : "pageId="+pageId,					
						success : function(date) {
						/*window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;*/
							window.location.href=root+"/page_manager/key/getAll";
						$("#daDiv").hide();
						}
					});
			 }
			
	 		});
 		/**
 		 *绑定域名div显示 
 		 */
 		 $(".boundshow").click(function(){
				 
				 $(".domainDiv").show();
				 $("#dialog").dialog({
					    bgiframe: true,
					    resizable: false,
					    height:450,
					    width:550,
					    modal: true,
					    overlay: {
					        backgroundColor: '#000',
					        opacity: 0.5
					    }
			 });
 		 })
 		
 		/**
 		 * 绑定独立域名
 		 */
 		/*$("#domainFrom").submit( function () {
	 		var pageId= $("#pageid").val();
	 		var domain=$("#domain").val();
	 		if(!checkSub($("#domainFrom"))){
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
			
	 		});*/
 		/**启用**/
		 $(".startPageState").click(function(){
				var pageId= $(this).attr("data");
				 if(confirm('你确认要启用吗？')){
			 $.ajax( {
					type : "POST",
					url : root + '/page_manager/key/startPageState',
					data : "pageData.id="+pageId,
					success : function() {
						alert("启用成功！");
						window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
					}
				});
				 }
		 });
	 
	});
	 
	 
	 function  closedDiv(){
    	 $("#pwdDiv").hide();
    }
	 function  closedDiv1(){
    	 $(".domainDiv").hide();
    }
	 function  opentalkDiv(){
		var  title="启用“talk99”";
		var	 content="<form id='submittalkForm' action='' method='post' onsubmit='return checkSub($(this))'>"
				+"<table><tr><td>"
				+"<div class='service_boday_div'  style='height: 170px;'><div class='service_boday_div_in_div' style='height: 170px;'>"
				+"<p style='margin:0px;'>请输入talk99的部署代码</p>"
				+"<p style='margin:0px;margin-top:10px;'><textarea rows='4' cols='70' name='contenu'  max='2000' class='contenuVal' style='resize:none'></textarea></p>"
				+"<p><div class='error' style='display:none;margin-top:-10px;'></div></p></div></div></td></tr>"
				+"<tr><td>" 
				+"<input type='button' class='service_boday_div_button_only_sure' value='ok,启用'  style='margin-left: 50px;margin-top: 225px;color:#FDF5E6;width: 400px;'  onclick='opentalk()'> </td></tr>"
				+"<tr></tr></table></form>";
				new bombBox('myBankOpDiv', 'myBankOpDivS', {
					title : title,
					content : content,
					width : '500',
					height : '330',
					top : '',
					left : '',
					fixed : 'fixed',
					close : 'close'
				});
			$("#myBankOpDiv").click();
	 }
	 
	 /*部署talk99*/
	 function opentalk(){
	 	var pageId= $("#pageid").val();   //pageid
	 	var id= $("#pageProductId").val();   //pageproductid
	 	var contenu=$(".contenuVal").val();
	 	var content;
	 	var title="启用成功";
	 			  content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
	 					+"</table>"; 
	 		 if(contenu==""){
	 			   	$(".error").html("talk99内容不能为空!");
	 		    	$(".error").show();
	 		    	return false;
	 			}


	   	$.ajax( {
	 		type : "POST",
	 		url : root + '/product_manage/key/updatePageProductTak',
	 		data : "pageProductData.id="+id+"&pageProductData.pageId="+pageId+"&contenu="+contenu,
	 		success : function(date) {
	 			if(date==1){		
	 				new bombBox('myqiDiv', 'tqitype', {
	 					title : title,
	 					content : content,
	 					width : '500',
	 					height : '150',
	 					top : '',
	 					left : '',
	 					fixed : 'fixed',
	 					close : 'close'
	 				});
	 				$("#myqiDiv").click();
	 				$("#myBankOpDivS").remove();
	 				setTimeout("timeHide('tqitype')",2000);//2秒后消失
	 				window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
	 				
	 				$(".hove").live("click",function(){
	 					window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
	 				});
	 			}else{
	 				return false;
	 			}
	 		}
	 	});
	 		 
	 	
	 	
	 }
	 //停用talk99


	 function extraUpdate(){
	 	var sel=$("#selDis").html();
	 	var content ="<div class='service_boday_div'  style='height: 200px;'>"
	 			+"<div style='left: 80px; top: 10px; width: 400px; height: 200px; position: absolute;'><table style='margin-left:-80px;height: 160px;'><tr><td><div style='margin-top: 10px;margin-left: 21px;'>"
	 			+sel
	 			+"</div></div></td></tr><tr><td><div style='margin-left: 19px;'><textarea rows='4' cols='60' style='resize:none;' name='pageProductData.stopDesc' id='stopDesc'></textarea></div>  </td></tr>"
	 			+"<tr><td><div  id='conDiv'><div class='errorDiv' style=' margin-left: 20px;display:none ;'></div></td></tr>" 
	 			+"</table>" +
	 					"<div style='margin-top: 5px;margin-left: 100px;'><input type='button' style='width: 400px;height: 40px;background-color: #444444;margin-left: -180px;margin-top: 20px;color:#FDF5E6;' name='updatesubmit' value='提交修改' class='submit' id='updatesubmit' onclick='onsubimt()'/>" +
	 					"</div></div></div>"

	 	var title="停用服务";
	 	new bombBox('myDisDiv', 'thisDistype', {
			title : title,
			content : content,
			width : '500',
			height : '360',
			top : '',
			left : '',
			fixed : 'fixed',
			close : 'close'
		});
		$("#myDisDiv").click();
	 }
	 
	//停用服务
		function onsubimt(){
			
		var id= $("#pageProductId").val();   //pageproductid
	 	var pageId= $("#pageid").val();   //pageid
		var stopType= $("#changDis").val();
		 var stopDesc=$("#stopDesc").val();
		 var content;
		 var title="停用成功";
		content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
								+"</table>"; 
			if(stopType!=0){
				$(".errorDiv").html("");
				$(".errorDiv").hide();
//				 if(confirm('你确认要停用用吗？')){
					$.ajax( {
						type : "POST",
						url : root + '/product_manage/key/stopPageProduct',
						data : "pageProductData.id="+id+"&pageProductData.stopType="+stopType+"&pageProductData.stopDesc="+stopDesc+"&pageProductData.type="+5,
						success : function() {
							
							new bombBox('myDiv', 'ttype', {
								title : title,
								content : content,
								width : '500',
								height : '150',
								top : '',
								left : '',
								fixed : 'fixed',
								close : 'close'
							});
							$("#myDiv").click();
							setTimeout("timeHide('ttype')",2000);//2秒后消失
							window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
							$("#thisDistype").remove();
							$(".hove").live("click",function(){
								window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageId;
							});
						}
					});
			}else{
				$(".errorDiv").html("停用类型不能为空！");
				$(".errorDiv").show();
				return false;
			}
			
	};
	//根据divId定时移除div
	 function timeHide(divId){
	 	$("#"+divId).remove();
//	 	$("#thistype").remove();
	 }
	//下拉框 选择事件
	 function bao(s)
	 {
	     //选择后,让第一项被选中,这样,就有Change啦.
	     document.getElementById("stopType").options[0].selected=true;  
	     $("#changDis").val(s);
	 }
	 function closedDiv(){
		 $("#PowerDiv").hide();
	 }
	 function poverPage(pageid){
		 if(!checkSub($("#PowerPage"))){
				return;
			}
		 $.ajax( {
				type : "POST",
				url : root + '/page_manager/key/powerPageByUserID',
				data : "userData.loginMail="+$("#powerUserName").val()+"&pageData.id="+pageid,
				success : function(data) {
					if(data=='true'){
						alert("赠送成功！");
						window.location.href=root+"/page_manager/key/getPageView?pageHelpData.pageId="+pageid;
					}else{
						alert("赠送失败！");
					}
				}
		 });
	 }
	 function submitDomain(){
		 var pageId= $("#pageid").val();
	 		var domain=$("#domain").val();
			if(!checkSub($("#domainFrom"))){
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
				alert('独立域名格式错误');
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