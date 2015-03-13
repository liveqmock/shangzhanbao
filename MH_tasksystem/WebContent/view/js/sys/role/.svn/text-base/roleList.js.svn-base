$(function(){
	initTaskRoleGrid();//加载grid
});

/*
 * 添加角色
 */
function addRoleInfo() {
	var url = root + "/view/pages/sys/role/roleAdd.jsp";
	setWindowSrc(url);
	setWindowAttr("添加角色",{width:450,height:270});
	openIframeWindow();
}

/*
 * 修改角色
 */
function editRoleInfo() {
	var row = $("#roleGrid").datagrid("getSelected");
	var selectedTaskRole = $('#roleGrid').datagrid('getSelections');
	if (row == null) {
		$.messager.alert("消息提示", "请先选择", "warning");
		return;
	}
	if(selectedTaskRole.length >1){
		$.messager.alert("消息提示","只能修改一条记录","warning");
		return;
	}
	var url = root + "/role/key/intoRoleEditPage?id="+row.id;;
	setWindowSrc(url);
	setWindowAttr("修改角色",{width:450,height:270});
	openIframeWindow();
}

/*
 * 查看详情
 */
function viewRoleInfo(id) {
	var url = root + "/role/key/viewRoleInfo?id="+id;
	top.setWindowSrc(url);
	top.setWindowAttr("角色详情",{width:450,height:230});
	top.openIframeWindow();
}


/*
 * 删除
 */
function deleteRole() {
	var selected = $('#roleGrid').datagrid('getSelections');
	if (selected.length <= 0) {
		$.messager.alert('waring', '至少要选择一个要删除的记录');
	} else {
		var ids = new Array();
		for(var i=0,len=selected.length; i<len; i++){
			ids.push(selected[i].id);
		}
		ids = ids.join(",");//转换为字符串
		$.messager.confirm('删除', '确认删除吗?', function(d) {
			if (d) {
				$.ajax( {
					type : "POST",
					url : root + '/role/key/deleteRole',
					data : "ids=" + ids,
					success : function(json) {
						top.showMessage(json);
						reloadRoleGrid();
					}
				});
			}
		});
	}
}

/*
 * 刷新机构Grid
 */
function reloadRoleGrid() {
	$('#roleGrid').datagrid("reload");
}

/*
 * 加载角色grid
 */
function initTaskRoleGrid() {
	$('#roleGrid').datagrid( {
		title : '角色管理',
		iconCls : 'icon-ok',
		width : 650,
		height : 350,
		pageSize : 20,
		pageList : [ 5, 10, 15, 20 ],
		striped : true,
		collapsible : true,
		url : root + '/role/key/queryAllRoleInfo',
		remoteSort : true,// 服务器端排序
		fitColumns :true,
		singleSelect : true,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'rolename',
			title : '角色名称',
			width : 100,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'description',
			title : '角色描述',
			width : 100,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'createdate',
			title : '创建时间',
			width : 100,
			rowspan : 2,
			align : 'center'
		},{
			field : 'status',
			title : '状态',
			width : 100,
			rowspan : 2,
			align : 'center',
			formatter:function(value,row,index){
			  return "NORMAL"==value?"正常":"注销";
			}
		},{field:'operator',
			title:'操作列',
			width:30,
			rowspan:2,
			align:'center',
            formatter:function(value,row,index){
	                var e = '<a href="javascript:void(0);" onclick="viewRoleInfo('+"'"+row.id+"'"+');" style="text-decoration: none;color: #800080;">详情</a> ';
	                return e;
			}
		}
		] ],
		pagination : true,
		rownumbers : true,
		toolbar : [{
			text : '增加',
			iconCls : 'icon-add',
			handler : addRoleInfo	
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editRoleInfo
		}, '-', {
			text : '删除',
			iconCls : 'icon-no',
			handler : deleteRole
		}, '-', {
			text : '配置角色',
			iconCls : 'icon-tip',
			handler : configRoleUser
		}]
	});
};

/*
 * 配置角色——用户
 */
function configRoleUser(){
	var row = $("#roleGrid").datagrid("getSelected");
	var selectedTaskRole = $('#roleGrid').datagrid('getSelections');
	if (row == null) {
		$.messager.alert("消息提示", "请先选择", "warning");
		return;
	}
	if(selectedTaskRole.length >1){
		$.messager.alert("消息提示","只能修改一条记录","warning");
		return;
	}
	var url = root + "/view/pages/sys/role/configRole_User.jsp?roleID="+row.id;
	top.setWindowSrc(url);
	top.setWindowAttr("配置角色用户",{width:750,height:500});
	top.openIframeWindow();
}