$(function(){
	$(".userFrame").live("click",function(){
		var id = $(this).attr("data");
		var url = root+"/back_temp_manage/key/editTemp?id="+id+"&componentData.type=2"
		$.ajax({
			type : 'POST',
			url : url,
			dataType : "text",
			success : function(data) {
				window.location.href = root + data;
			}
		});
	})
	
})