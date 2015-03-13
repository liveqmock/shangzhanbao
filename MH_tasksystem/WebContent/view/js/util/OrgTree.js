function getTreeLoader(url) {
	var treeLoader = new Ext.tree.TreeLoader( {
		url : url,
		listeners : {
			"loadexception" : loadExceptionHandler
		}
	});
	return treeLoader;
}

/* 创建AsyncTreeNode（非同步树） */
function getRoot(treeId, treeName) {
	var root = new Ext.tree.AsyncTreeNode( {
		id : treeId,
		text : treeName,
		allowDrag : false
	// false表示不能被拖动
			});
	return root;
}

