$(function(){	
	$.ajax({
		type : "POST",
		url : root + '/page_manage/key/getUserPrivateNumber',
		success : function(data) {
			if(data>0){
				 $("#butuL").html('<lable>您有'+data+'个权限未使用<lable>');
				 $("#butuL").css("background","#E6E9E8");
				 $("#butuL").find("lable").css("font-weight","900");
			}else{
				 $("#butuL").find("a").html('购买发布权限');
				 $("#butuL").find("a").attr("href",root+"/shopping_cart/key/updateSaveShoppingCartData?sign=2");
			}
		}
	});
});