
/**
 * 角色配置管理 列表页面 js
 * @author jmj
 */
$(function(){
	deleteRole();
	addRoleInfo();
});

/*
 * 添加角色
 */
function addRoleInfo() {
	$(".addRole").click(function(){
		window.location.href=root+"/role/key/intoAddRole";
	});
}
///*
// * 条件查询
// */
//function searchByParam(){
//	$(".searchByParam").click(function(){
//		$("#roleForm").submit();
//	});
//}
/*
 * 删除角色
 */
function deleteRole(){
	var num=0;
	var start=0;
	var roleids;
	//判断全选复选框是否选中(全选和取消全选)
	$("#allcbx").bind("click",function(){
		var ck=$("input[name=allcbx]").attr("checked");
		if(ck == "checked"){
			$("input[name=cbox]").attr("checked","true");
		}else{
			$("input[name=cbox]").removeAttr("checked");
		}
	});
	
	$("#deleteRole").click(function(){
		$("input[name=cbox]:checked").each(function(){
			if($(this).attr("checked")){
				num+=1;
			}
		});
		if(num==0){
			alert("请选择数据!");
		}else if(num>=1){
			$("input[name=cbox]:checked").each(function(){
				if(start==0){
					roleids=$(this).val()+',';
				}else{
					roleids+=$(this).val()+',';
				}
				start+=1;
			});
			if(confirm("确定删除?")){
			window.location.href=root+"/role/key/deleteRole?id="+roleids;
			return true;
			}
			return false;
		}
	});
}


