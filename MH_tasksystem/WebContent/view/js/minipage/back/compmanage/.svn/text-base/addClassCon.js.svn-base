
	
	 $(function() {
		 fl=true;
			/**
			 * 预览
			 */
		 $(".yulan").click(function(){
			 
			  $("#style").html("");
				 var clob=$(".clob").val();
				 var n=$(this).attr("data");
				 var css="";
				 var width="";
				   if(n=="1"){
					css=$(".conpc").val();  
					width="1000";
				   }
				   if(n=="2"){
					css=$(".conpc").val()+$(".conip").val();  
					width="780";
					 }
				   if(n=="3"){
					css=$(".conpc").val()+$(".conphone").val(); 
					width="480";
					 }
				   
				 if(document.all){  
						document.createStyleSheet("javascript:style");  
						}else{  
						var style = document.createElement('style'); 
						style.type = 'text/css';  
						style.innerHTML=css;  
						$("#style").html(style);  
						}  
				 	$("#pwdDiv").html(clob);
						 $("#pwdDiv").show();
						 $( "#dialog-message" ).dialog({
							 bgiframe: true,
							 resizable: false,
							 height:600,
							 width:width,
						      modal: true/*,
						      buttons: {
						    	  "提交修改": function() {
						    	alert("关闭！");
						        }
						      }*/
						    });

		 });
		 
		 $("#add").click(function(){
				var flag=0;
				var img=$("#filePC");
				if (img == null || img.val() == "") {
					flag = 2;
				}			
			    if(flag==2){
			    	alert("预览图不能为空");
			    	return false;	   
				}
				if(!checkSub($("#addComp"))){
					return;
				}
				$(".error").hide();
				$(".error1").hide();
			  
				 $.ajax({
						type :"post",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
						url : root+"/comp_manage/key/ajaxFindComponentClassData",
						data : $("#addComp").serialize(),
						dataType : "text",
						success : function(data){
							if(data!=""){
								if(data!="1"){
								alert(data+"该组件没有此样式!");
								return false;
								}else{
									alert("填写的css不符合规范!");
									return false;
								}
							}else{
								var form=$("#addComp");
								var url=root+"/component_class/key/addupdateComponentClassData";
								form.attr("action",url);
								form.submit();
							}
						       
							
							}
					});
				
			})
			
	
	 })	
	 
/*	 function a(){
		 $(document.forms[0]).ajaxSubmit({ 
	        	url: root+"/component_class/key/addupdateComponentClassData",
	        	dataType: 'json',
	        	iframe: true,
	        	data: $("#addComp").serialize(),
	        	success: function(res) {
	        		
	        		if(res==1){
	        			
						window.location.href=root+"/comp_manage/key/searchComponent";
	        		}else{
	        			alert("填写的css不符合规范!");
	        			return false;
	        		}
	        	}
	        })
	 }*/
