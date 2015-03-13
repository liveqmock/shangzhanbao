

function extraUpdate(id,count,type,pageId,domain,num){
	//获取页面的禁用原因的html
	var sel=$("#selDis").html();
	var content ="<div class='service_boday_div'  style='height: 220px;'>"
			+"<div style='top: 10px; width: 400px; height: 200px; position: absolute;'><table style='height: 160px;'><tr><td><div style='margin-top: 10px;margin-left: 21px;'>"
			+sel
			+"</div></div></td></tr><tr><td><div style='margin-left: 19px;'><textarea rows='7' cols='33' style='resize:none;' name='pageProductData.stopDesc' id='stopDesc'></textarea></div>  </td></tr>"
			+"<tr><td><div  id='conDiv'><div class='errorDiv' style=' margin-left: 20px;display: none;'></div></td></tr>" 
			+"</table><div style='margin-top: 5px;margin-left: 100px;'><input type='button' style='width: 400px;height: 40px;background-color: #444444;margin-left: -100px;margin-top: 30px;color:#FDF5E6;' name='updatesubmit' value='停用' class='submit' id='updatesubmit' onclick='onsubimt("+type+","+num+")'/>" +
			"</div></div></div>"

	var title="停用服务";
	$("#pageProductDataId").val(id);
	$("#pageIdDiv").val(pageId);
	$("#padomain").val(domain);
	//次page只有一个服务
		if(count==1){
			var data="<div class='service_boday_div' >"
			+"<div class='service_boday_div_in_div'><font style='font:14px Hevetica Neve,Helvetica Neve, Helvetica, Hiragino Sans GB, Microsoft Yahei, Arial; color:red;'>这是最后一个营销动作了，如果停用，将失去与客户的联系。<br/><br/><font style='color:#000'>你确定要停用吗？</font></font></div></div>"
			+"<table class='service_boday_div_table'><tr class='service_boday_div_table_tr'></tr><tr></tr>"
			+"<tr><td> <input type='button' class='service_boday_div_button_canel' value='取消'   onclick='quxiao()' >" 
			+" <input type='button' class='service_boday_div_button_sure' value='确定' id='queding'> </td></tr><tr></tr></table>"
		 	new bombBox('myOpDisDiv', 'thisOpDistype', {
				title : title,
				content : data,
				width : '500',
				height : '320',
				top : '',
				left : '',
				fixed : 'fixed',
				close : 'close'
			});
			$("#myOpDisDiv").click();
			 $("#queding").click(function(){
					new bombBox('myDisDiv', 'thisDistype', {
						title : title,
						content : content,
						width : '500',
						height : '380',
						top : '',
						left : '',
						fixed : 'fixed',
						close : 'close'
					});
					$("#myDisDiv").click();
					$("#thisOpDistype").remove();
			 });
		
		}else if(count>1){	  //此page有多个服务
			
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
}
//停用服务
	function onsubimt(type,num){
		
	var id=$("#pageProductDataId").val();
	var pageId=$("#pageIdDiv").val();
	var stopType= $("#changDis").val();
	 var stopDesc=$("#stopDesc").val();
	 var domain=$("#padomain").val();  //域名
	 var content;
	 var title="停用成功";
	content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr></table>"; 
		if(stopType!=0 && stopType!=""){
			$(".errorDiv").html("");
			$(".errorDiv").hide();
//			 if(confirm('你确认要停用用吗？')){
				$.ajax( {
					type : "POST",
					url : root + '/product_manage/key/stopPageProduct',
					data : "pageProductData.id="+id+"&pageProductData.stopType="+stopType+"&pageProductData.stopDesc="+stopDesc+"&pageProductData.type="+type,
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
						
						$("#qiyong"+num).show();
						$("#tingyong"+num).hide();
						$("#shiyongzhong"+num).hide();
						setTimeout("timeHide('ttype')",2000);//2秒后消失
						$("#thisDistype").remove();
						$("#changDis").val("");
						$(".hove").live("click",function(){
							window.location.href=root+"/product_manage/key/getAllProduct";
						});
					}
				});
//			 }
		}else{
			$(".errorDiv").html("停用类型不能为空！");
			$(".errorDiv").show();
			return false;
		}
		
};
/*继续管理服务*/

	function  getAllProduct(){
		window.location.href=root+"/product_manage/key/getAllProduct";
	}



/*启用*/
function openPageproduct(id,type,pageId,productName,domain,num){
	var content = '';
	var title="";
	 if(type==1 || type == 6){  //客户留言 或购买服务
		 			var content1;
					 if(domain==""){
						 content1 = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
								+"</table>"; 
					 }else{
						  content1 = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
								+"</table>";
					 }
				
			 	title1="启用成功";
			  	$.ajax( {
			  		type : "POST",
			  		url : root + '/product_manage/key/openPageProduct',
			  		data : "pageProductData.id="+id+"&pageProductData.type="+type+"&pageProductData.pageId="+pageId,
			  		success : function() {
			  			new bombBox('myqiDiv', 'tqitype', {
							title : title1,
							content : content1,
							width : '500',
							height : '150',
							top : '',
							left : '',
							fixed : 'fixed',
							close : 'close'
						});
						$("#myqiDiv").click();
						
						$("#qiyong"+num).hide();
						$("#tingyong"+num).show();
						$("#shiyongzhong"+num).show();
						setTimeout("timeHide('tqitype')",2000);//2秒后消失
						$("#thisDistype").remove();
						$(".hove").live("click",function(){
							window.location.href=root+"/product_manage/key/getAllProduct";
						});
			  	}
		  		});
			  	
			} else if(type==2){ 
				//拨打销售电话
				title="启用“拨打销售电话”";
				content="<form id='submitPhoneForm' action='' method='post' onsubmit='return checkSub($(this))'><table>"
					+"	<tr><td>"
					+"	<div class='service_boday_div'  style='height: 140px;'>"
					+"	<div class='service_boday_div_in_div' style='height: 140px;'>"
					+"		<p>请输入销售电话号码：</p>"
					+"		<p style='text-align: left;margin-top: 20px;'><input type='text' style='height: 38px;width: 230px;' class='phone' ></p>"
					+"      <p><div class='error' style='display:none;margin-top:10px;'></div></p>	</div></div></td></tr>" +
							"<tr ><td> "
 					+"  <input type='button' class='service_boday_div_button_only_sure' value='ok,启用'  id='' onclick='openPhone("+num+")'/>"
 					+" </td></tr><tr></tr></table></form>"
				 $(".productId").val(id); //pageproductid
				 $(".pageId").val(pageId);
				 $("#padomain").val(domain); //域名
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
				 	$("#myOpDiv").click();
			}else if(type==3){  //实名认证信息
				title="启用“实名网站认证”";
				content=" <div class='error' style=' margin-left: 40px;display:none;height:20px;'></div>"
					+" <form id='fileFrom'  method='post' enctype='multipart/form-data' action='' > <table style='margin-top: ;margin-left: 30px;'>"
					+" <tr><td><div class='DataStatistics_1'  style='left: 50px; top: 80px; width: 400px; height: 150px; position: absolute;'>"
					+" <div style='left: 80px; top: 10px; width: 370px; height:140px; position: absolute;'>"
					+" <p style='text-align: left;margin-left:-50px;'>请上传标识文件：</p>"
					+"<p style='text-align: left;margin-left:-50px;'><input type='file' name='imgFile' id='imgFile' /></p> </div></div></td></tr>" 
					+"<tr ><td> "
					+"<input type='submit' value='ok,启用'  style='width: 400px;height: 40px;background-color: #444444;margin-left: 17px;margin-top:190px;color: #ffffff;' id='filesub' onclick='openFile()'>"
					+"</td></tr><tr></tr></table></from>"
				 $(".productId").val(id);
				 $(".pageId").val(pageId);
				 $("#padomain").val(domain); //域名
			}else if(type==5){   //在线客服
				title="启用“talk99”";
				content="<form id='submittalkForm' action='' method='post' onsubmit='return checkSub($(this))'>"
					+"<table><tr><td>"
					+"<div class='service_boday_div'  style='height: 170px;'><div class='service_boday_div_in_div' style='height: 170px;'>"
					+"<p >请输入talk99的部署代码</p>"
					+"<p ><textarea rows='6' cols='40' name='contenu'    max='2000' class='contenuVal' style='resize:none'></textarea></p>"
					+"<p><div class='error' style='display:none;margin-top:10px;'></div></p></div></div></td></tr>"
					+"<tr><td>" 
					+"<input type='button' class='service_boday_div_button_only_sure' value='ok,启用'  style='margin-left: 50px;margin-top: 225px;color:#FDF5E6;'  onclick='opentalk("+num+")'> </td></tr>"
					+"<tr></tr></table></form>"
				$(".productId").val(id);
				$(".pageId").val(pageId);
				 $("#padomain").val(domain); //域名
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
				 	$("#myOpDiv").click();
			}
}

//根据divId定时移除div
function timeHide(divId){
	$("#"+divId).remove();
	window.location.href=root+"/product_manage/key/getAllProduct";
}

//拨打销售电话
function openPhone(num){
	var id= $(".productId").val();  //pageproductid
	var phone=$(".phone").val();
	var pageId= $(".pageId").val();
	 var domain=$("#padomain").val();  //域名
	var content;
	var title="启用成功";
	content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
					+"</table>"; 

	
	var reg=/^(1[3,5,8,7]{1}[\d]{9})|(((400)-(\d{3})-(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{3,7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;

	if(phone==""){
	   	$(".error").html("电话号码不能为空!");
    	$(".error").show();
    	return false;
	}
	/*if(!reg.test(phone)){
		$(".error").html("电话号码格式不正确!");
    	$(".error").show();
    	return false;
	}*/
  	$.ajax({		
		type : "POST",
		url : root + '/product_manage/key/updateProductPagePhone',
		data : "pageProductData.id="+id+"&pageId="+pageId+"&phone="+phone,
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
			$("#thistype").remove();

			$("#qiyong"+num).hide();
			$("#tingyong"+num).show();
			$("#shiyongzhong"+num).show();
			setTimeout("timeHide('tqitype')",2000);//2秒后消失
			
			
			$("#opendiv").show();
			$(".hove").live("click",function(){
				window.location.href=root+"/product_manage/key/getAllProduct";
			});
			}else{
				return false;
			}
		}
	});
		 
	
}
/*部署talk99*/
function opentalk(num){
	var pageId= $(".pageId").val();   //pageid
	var id= $(".productId").val();   //pageproductid
	var contenu=$(".contenuVal").val();
	var domain=$("#padomain").val();  //域名
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
				$("#thistype").remove();
				
				$("#qiyong"+num).hide();
				$("#tingyong"+num).show();
				$("#shiyongzhong"+num).show();
				setTimeout("timeHide('tqitype')",2000);//2秒后消失
				
				
				$(".hove").live("click",function(){
					window.location.href=root+"/product_manage/key/getAllProduct";
				});
			}else{
				return false;
			}
		}
	});
		 
	
	
}


function  closedDiv(){
	 $("#daDiv").hide();
}
function  closedDiv1(){
	 $("#pwdDiv").hide();
}
function  closedDiv2(){
	 $("#openDiv").hide();
}
function  quxiao(){
	$("#thisOpDistype").remove();
}
/*关闭部署上传文件号码div*/
function  closedfile(){
	 $("#fileDiv").hide();
}
/*关闭部署修改电话号码div*/
function  closedphone(){
	 $("#phoneDiv").hide();
}
/*关闭部署talk99div*/
function  closedtalk(){
	 $("#talkDiv").hide();
}
//启用实名网站认证
function  openFile(){
			var pageId= $(".pageId").val();   //pageid
			var id= $(".productId").val();  //pageproductid
			var domain=$("#padomain").val();  //域名
			var content;
			var title="启用成功";
			content = "<table><tr style='height: 8px;'></tr><tr style='height: 40px;'></tr>"
							+"</table>";
			
			var flag=0;
			var flag1=0;
			var img=$("#imgFile");
			if (img == null || img.val() == "") {
				flag = 2;
			}			
		    if(flag==2){
		    	$(".error").html("上传文件不能为空!");
		    	$(".error").show();
		    	return false;	   
			}
		    if(!checkSub($("#fileFrom"))){
				return;
			}	
			$(".error").html("");
			$(".error").hide();
				var form=$("#fileFrom");
				var url=root+"/product_manage/key/updateProductPageFile?pageProductData.id="+id;
		    	form.attr("action",url);
		    	form.submit(); 
	
		    	
		}

/**
 * 获取元素本身html
 * 
 */
function getOuterHtml(obj) {
    var box = $('<div></div>');
    for (var i = 0; i < obj.length; i ++) {
        box.append($(obj[i]).clone());
    }
    return box.html();
}
//下拉框 选择事件
function bao(s)
{
    //选择后,让第一项被选中,这样,就有Change啦.
    document.getElementById("stopType").options[0].selected=true;  
    //为禁用类型原因赋值，用于js取值
    $("#changDis").val(s);
}

function  getPage(pageId){
	$.ajax( {
		type : "POST",
		url : root + '/product_manage/key/getPageDomain',
		data : "pageId="+pageId,
		success : function(date) {
			 window.open(date,"toolbar=no,,menubar=no,location=no,scrollbars=no");  
		}
	});
}
