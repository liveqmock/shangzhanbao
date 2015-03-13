var currentTreeNode = "";//当前节点 

$(function(){
	initOrgTree();//加载树
});

function reloadViewOrg() {
	var url = root + "/org/key/viewOrgInfo?orgID=" + currentTreeNode;
	$("#viewOrg").attr("src",url);
}

function initOrgTree() {
	$('#orgTree').tree({   
        url : root + '/org/key/getOrgTree',
        onBeforeSelect : function(node){
			currentTreeNode = node.id;//保存当前节点
			reloadViewOrg(node.id);//刷新视图
		},
		onBeforeExpand : function(node,param){//异步加载子节点
			$('#orgTree').tree('options').url = root+'/org/key/getOrgChild?orgID='+ node.id;                      
        },
        onLoadSuccess : function(node,param){//加载成功
        	if( !$('#orgTree').tree("getSelected") ){
        	  var rootNode = $('#orgTree').tree("getRoot");//根节点
        	  $('#orgTree').tree( "select",rootNode.target );//选中根节点
        	  currentTreeNode = rootNode.id;//设置当前节点:rootNode
        	}
        }
   });
}
/*
 * 保存新增机构信息
 */
function saveOrgInfo(){
	var deptManager = $('#orgData\\.deptManagerID option:selected').val();
	var deptDeputyManager = $('#orgData\\.deptDeputyManagerID option:selected').val();
	if ($('#orgForm').form('validate')) { // 进行校验
		if(deptManager != '' && deptDeputyManager != ''){
			$.ajax({
				type : "POST",
				url : root+"/org/key/saveOrgInfo",
				data : $("#orgForm").serialize(),
				success : function(json){
					var message = eval('(' + json + ')');
					if(message.id == 1){
						top.showMessage(message.msg);
					}else{
						top.showMessage(message.msg);
						window.location = root + "/org/key/viewOrgInfo?orgID=" + message.id;
						parent.openOrgTree(message.id);
					}
				}
			})
		}else{
			$.messager.alert("消息提示", "请先选择部门管理!", "warning");
		}
	}
}
/*
 * 保存修改机构信息
 */
function updateOrgInfo(){
	var deptManager = $('#orgData\\.deptManagerID option:selected').val();
	var deptDeputyManager = $('#orgData\\.deptDeputyManagerID option:selected').val();
	if ($('#orgForm').form('validate')) { // 进行校验
		if(deptManager != '' && deptDeputyManager != ''){
			$.ajax({
				type : "POST",
				url : root+"/org/key/updateOrgInfo",
				data : $("#orgForm").serialize(),
				success : function(json){
					var message = eval('(' + json + ')');
					if(message.id == 1){
						top.showMessage(message.msg);
					}else{
						top.showMessage(message.msg);
						window.location = root + "/org/key/viewOrgInfo?orgID=" + message.id;
						parent.flushNode();
					}
				}
			})
		}else{
			$.messager.alert("消息提示", "请先选择部门管理!", "warning");
		}
	}
}
/*
 * 打开机构树,选中子节点
 */
function openOrgTree(id){
	var node = $('#orgTree').tree('getSelected');
	var children = $('#orgTree').tree('getChildren',node.target);
	if( children.length	== 0 ){//子节点为0:1)未打开的节点,子节点
		if( !$('#orgTree').tree('isLeaf',node.target)){//不是子节点
			$('#orgTree').tree('expand',node.target);//展开这个节点
		}
	}
	$.ajax({
		type : "POST",
		url : root + '/org/key/getOrgInfo?orgID='+ id,
		success : function(json){
			var jsonData = eval('(' + json + ')');
			$('#orgTree').tree('append',{  //填充数据
				parent: ( node? node.target :null),
				data:jsonData
			});
			var tager = $('#orgTree').tree('find', jsonData[0].id); //获取刚加入的id项
			$('#orgTree').tree('select', tager.target);//选择此项getChildren
		}
	})
}
/*
 * 刷新节点
 */
function flushNode(){
	var node = $('#orgTree').tree('getSelected');
	var children = $('#orgTree').tree('getChildren',node.target);
	if( children.length	== 0 ){//子节点为0:1)未打开的节点,子节点
		if( !$('#orgTree').tree('isLeaf',node.target)){//不是子节点
			$('#orgTree').tree('expand',node.target);//展开这个节点
		}
	}
	$.ajax( {
		type : "POST",
		url : root + "/org/key/getOrgInfo",
		data : "orgID=" + node.id,
		success : function(jsonData) {
			var json =   eval('(' + jsonData+ ')');
			$('#orgTree').tree('update',{
					target:node.target,
					text:json[0].text
			});		
		}	
	})
}
/*
 * 删除节点及其子节点
 */
function deleteNode(node) {
	if(!node){
		 node = $('#orgTree').tree('getSelected');
	}
	if ( null != node ) {
		var parentNode = $('#orgTree').tree('getParent', node.target);
		$('#orgTree').tree('remove', node.target);
		$('#orgTree').tree('select', parentNode.target );//选中父节点
		currentTreeNode = parentNode.id;//设置当前节点:rootNode
	} else {
		alert("错误的节点");
	}
}