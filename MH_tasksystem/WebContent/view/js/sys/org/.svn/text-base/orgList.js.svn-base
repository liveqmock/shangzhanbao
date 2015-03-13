/*
 * 添加子机构
 */
function addChildOrg(){
	location.href = root+"/org/key/intoAddOrgPage?orgID="+ $('#orgID').val();
}

/*
 * 修改机构信息
 */
function editChildOrg(){
	location.href = root+'/org/key/intoEditOrgPage?orgID='+ $('#orgID').val();
}
/*
 * 保存新增机构信息
 */
function saveOrgInfo(){
	parent.saveOrgInfo();
}
/*
 * 保存修改机构信息
 */
function updateOrgInfo(){
	parent.updateOrgInfo();
}
/*
 * 删除机构
 */
function delChildOrg(){
	if(confirm("确认删除!")){
		var orgID = $('#orgID').val();
		$.ajax( {
			type : "POST",
			url : root + '/org/key/deleteOrg',
			data : "orgID=" + orgID,
			success : function(msg) {
				top.showMessage(msg);
				if ( parent != this ) {
					parent.deleteNode();//删除树节点
				}
			}
		});
	}
}