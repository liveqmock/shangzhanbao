function initPageRoll(){
	$("form input.pageRollHidden").val(0);
}
function turnTo(page){
	$("form input.pageRollHidden").val(page);
	$("form input.pageRollHidden").closest("form").submit();
}

$(function(){
	$(".checkAll").change(function(){
		if($(this).attr("parent")!=null){
			$(this).closest($(this).attr("parent")).find("input[type=checkbox]").prop("checked",this.checked);
		}
	});
	
	$(".btn-delete").click(function(){
		
	});
	
});