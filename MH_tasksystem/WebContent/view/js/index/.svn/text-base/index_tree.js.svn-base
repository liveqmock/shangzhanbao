/* 用于子模块之间的传递,子模块修改数据 */
var _hotelID;
/* 用于对应酒店信息中页签数据的加载 */
var _ID;
/*用于存放酒店动态信息*/
var proId;
function getTree(jsonUrl,roottext) {
	var root = new Ext.tree.AsyncTreeNode({
				text : roottext,
				expanded : true,
				id : 'root'
			});
			
	var tree = new Ext.tree.TreePanel({
		autoScroll : true,
		id : 'leftTree',
		loader : new Ext.tree.TreeLoader({
			dataUrl : jsonUrl 
		}),
		title : roottext,
		width : 170,
		height : 500,
		applyTo : 'tree-div',
		root : root
	});
}