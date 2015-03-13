//获取任务类型系数
function getModulus(type, importance, approvalerID){
	var modulus;
	$.ajax({
		type : 'POST',
		url : root +'/task_info/key/getModulus',
		data : "type=" +type+"&importance="+importance+"&approvalerID="+ approvalerID,
		async : false,
		success : function(json){
			modulus = json;
		}
	})
	return modulus;
}