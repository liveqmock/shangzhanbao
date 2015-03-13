// 建议此处使用另外一个目录菜单来取代apiPanel，这样可以节省空间
function menuAction(menu) {
	var id = menu.id;
	var subid = "sub_" + id;
	var subMenu = document.getElementById(subid);
	subMenu.style.display = (subMenu.style.display == 'none') ? '' : 'none';
}

/**
 * 不知道什么原因，此处出现问题，调用两次
 * 
 * @param {}
 *            nodeName
 * @param {}
 *            nodeID
 * @param {}
 *            nodeAction
 */
var oldTime = 0;
function loadAction(nodeName, nodeID, nodeAction) {
	var now = new Date(); // 获取系统日期，即Sun Apr 29 16:41:48 UTC+0800 2007
	var nowTime = now.getTime();
	// alert("nowTime:"+nowTime+"/oldTime:"+oldTime);
	if ((nowTime - oldTime) > 1000) {
		oldTime = openTaskNode(nodeName, nodeID, nodeAction);
	}
}

/**
 * 此处调用IndexTreeAction的getCascadeMenu形成菜单，此处采用同步调用
 */
function loadMenuHtml() {
	
	//var url = '/etipcc/index_tree/key/getCascadeMenu';
	var url = '/MH_tasksystem/index_tree/key/getCascadeMenu';
	//var url = parent.projectNamePath+'/index_tree/key/getCascadeMenu';
	var conn = Ext.lib.Ajax.getConnectionObject().conn;
	conn.open("POST", url, false);
	conn.send(null);
	var menuHtml = conn.responseText;
	return menuHtml;
}

// 此处应该在jsp中执行，生成menuHtml,
var menuHtml = loadMenuHtml();
var categoryMenu = new Ext.Panel({
			title : '系统菜单',// 此处可以修饰一下
			collapsible : true,// 右上角上的那个收缩按钮，设为false则不显示
			region : 'west',
			// 这个panel显示在html中id为container的层中
			width : 110,
			height : 700,
			html : menuHtml

		});
