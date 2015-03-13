
	 jQuery(function () {
         // 时间设置
         jQuery('#time').datetimepicker({
             timeFormat: "HH:mm:ss",
             dateFormat: "yy-mm-dd"
         });
      // 时间设置
         jQuery('#time2').datetimepicker({
             timeFormat: "HH:mm:ss",
             dateFormat: "yy-mm-dd"
         });
         // 时间设置
         jQuery('#time3').datetimepicker({
             timeFormat: "HH:mm:ss",
             dateFormat: "yy-mm-dd"
         });
         // 时间设置
         jQuery('#time4   ').datetimepicker({
             timeFormat: "HH:mm:ss",
             dateFormat: "yy-mm-dd"
         });
     });

	 function showProduct(){
			var form = $("#disForm");
			form.action = root+"/page_manager/key/getAll?pageHelpData.pageState=6";
			form.submit();
		}
//禁用显示隐藏的div
	 $(function() {
		 $(".showDiv").click(function(){
			 
			 $("#pwdDiv").show();

				var pageId= $(this).attr("data");
				 $( "#dialog-message" ).dialog({
					 bgiframe: true,
					 resizable: false,
					 height:300,
					 width:450,
				      modal: true,
				      buttons: {
				    	  "提交修改": function() {
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
				  							 window.location.href=root+"/page_manager/key/getAll?pageHelpData.pageState=6";
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
		 /*启用*/
/*		 $(".startPageState").click(function(){
				var pageId= $(this).attr("data");
				var 
				 if(confirm('你确认要发布吗？')){
			 $.ajax( {
					type : "POST",
					url : root + '/page_manager/key/startPageState',
					data : "pageId="+pageId,
					success : function() {
						alert("发布成功！");
						window.location.href=root+"/page_manager/key/getAll?pageHelpData.pageState=6";
					}
				});
		 }
		 });*/
		 
		  var lis = $('#myTab00 li');
			for(var i=0;i<lis.length;i++){
				$(lis[i]).bind("click",function(){
					window.location.href=root+"/page_manager/key/getAll?pageHelpData.pageState="+this.value;
				})
			}
			
		//批量删除
			$(".deletePage").click(function(){
				  var num=0;
					 $("input[class=clPageIds]:checked").each(function(){
							if($(this).attr("checked")){
								num+=1;
							}
						});
					if(num==0){
						 alert('请选择数据');
						 return ;
					}else{
						if(confirm("确认删除?")){
							$.ajax({
								type:'POST',
								url:root+'/page_manager/key/deletePageData',
							   data:$("#disForm").serialize(),
							   success:function(data){
								   if(data==1){
									   alert("删除成功！");
									   window.location.href=root+"/page_manager/key/getAll?pageHelpData.pageState=6";
								   }
							   }
								
							})
						}
					}
			})
	 
	});
    function  closedDiv(){
    	 $("#pwdDiv").hide();
    }