/*
 * 保存信息
 */
function saveRole() {
	if ($('#roleForm').form('validate')){
		$.ajax({
			type : "POST",
			url : root + '/role/key/saveRole',
			data : $('#roleForm').serialize(), 
			success : function(msg){
				top.showMessage(msg);
				if( parent != this ){
					parent.closeIframeWindow();//关闭窗口
					parent.reloadRoleGrid();//刷新grid
				}
			}
		})
	}
}

/*
 * 修改权限(角色)信息 
 */
function updateRole(){
	if ($('#roleForm').form('validate')){
		$.ajax({
			type : "POST",
			url : root + '/role/key/updateRole',
			data : $('#roleForm').serialize(), 
			success : function(msg){
				top.showMessage(msg);
				if( parent != this ){
					parent.closeIframeWindow();//关闭窗口
					parent.reloadRoleGrid();//刷新grid
				}
			}
		})
	}
}

/*
 * 关闭窗口
 */
function closeWindow() {
	parent.closeIframeWindow();
}