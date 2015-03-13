$(function(){

	
	 
	/*//服务到期时间必须大于上前时间
	$('input.datepicker').datepicker({
		changeYear:true,
		changeMonth:true,
		startDate:new Date(),
		minDate:new Date()
	});
	*/

	
	 
	 //完成
	 $('#finish').click(function(){
			
		 if(!checkSub($("#productForm"))){
				return;
			}else{
				  var productNameValue = $('.getProductName').val();
				 $.ajax({
	    				type :"post",
	    				url : root+"/product/key/ajaxGetAllProductName",
	    				data : $("#productForm").serialize(),
	    				dataType : "text",
	    				success : function(data){
	    					 data = eval("("+data+")");
	    					 var name=data.name;
	    			
			   			     if(productNameValue==name){
	    						 var pId=$("#pId").val();
	    						 var form = document.getElementById('productForm');
	    						 form.action=root+"/product/key/updateProductFinish?productData.id="+pId;
	    						 form.submit();
	    					 }else if(productNameValue!=name) {
	    				    	  
	    						 $.ajax({
			   		    				type :"post",
			   		    				url : root+"/product/key/ajaxGetAllProductName",
			   		    				data : $("#productForm").serialize(),
			   		    				dataType : "text",
			   		    				success : function(data){
			   		    					 data = eval("("+data+")");
			   		    					 if(data.remark==1){
			   		    						 alert('该服务名称已存在！');
			   		    					 }
			   		    				}
	    						 });
	    					 }
	    				}
	    			});
		}		 
	 });
	 
}); 
/*计算时间*/
function formatTime(){
	
	
	Date.prototype.format = function(format) {
		var year=$("#yearNum").val();
		var newYear=this.getFullYear();
	    var o = {
	        "M+" :this.getMonth() + 1, // month		
	        "d+" :this.getDate(), // day		
	        "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter		
	        "S" :this.getMilliseconds()
	    }
	    if (/(y+)/.test(format)) {		
	        format = format.replace(RegExp.$1, (parseInt(year)+parseInt(newYear)+ "")		
	                .substr(4 - RegExp.$1.length));		
	    }
	    for ( var k in o) {		
	        if (new RegExp("(" + k + ")").test(format)) {	
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]		
	                    : ("00" + o[k]).substr(("" + o[k]).length));		
	        }		
	    }
	
	    return format;
	
	}

var myDate = new Date().format("yyyy-MM-dd");
  $(".datepickers").val(myDate);
}

