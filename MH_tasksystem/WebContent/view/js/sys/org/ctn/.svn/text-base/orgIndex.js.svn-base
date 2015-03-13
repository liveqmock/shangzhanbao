
/**
 * 机构配置管理  首页面js
 * @author jmj
 */
var currentTreeNode = "";//当前节点 

$(function(){
	initOrgTree();//加载树
});
function initOrgTree() {
	$('#orgTree').tree({  
		checkbox: true, 
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
function reloadViewOrg() {
	alert('reloadViewOrg');
	var url = root + "/org/key/viewOrgInfo?orgID=" + currentTreeNode;
	$("#viewOrg").attr("src",url);
}
