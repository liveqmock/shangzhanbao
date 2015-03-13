$(function(){
	initUserGrid();//初始化表格
});

function initUserGrid() {
	$('#userList').datagrid( {
		title : '用户管理列表显示',
		iconCls : 'icon-ok',
		width : 650,
		height : 350,
		pageSize : 20,
		pageList : [ 5, 10, 15, 20 ],
		striped : true,
		collapsible : true,
		url : root + '/user/key/getAllUserInfo',
		remoteSort : true,// 服务器端排序
		fitColumns :true,
		singleSelect : false,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'account',
			title : '用户帐号',
			width : 100,
			rowspan : 2,
			align : 'center'
		} , {
			field : 'name',
			title : '用户名称',
			width : 80,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'orgnamedefault',
			title : '所在机构',
			width : 200,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'telephone',
			title : '电话',
			width : 100,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'mobile',
			title : '手机',
			width : 100,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'email',
			title : '邮箱地址',
			width : 100,
			rowspan : 2,
			align : 'center'
		}, {
			field : 'remark',
			title : '备注',
			width : 100,
			rowspan : 2,
			align : 'center'
		},{field:'operator',
			title:'操作列',
			width:50,
			rowspan:2,
			align:'center',
            formatter:function(value,row,index){
				var e = '<a href="#" onclick="userInfo(\''+row.id
	                		+'\');return false;" style="text-decoration: none;color: #800080;">详情</a>';
				return e;
			}
		}
		] ],
		pagination : true,
		rownumbers : true,
		toolbar : [ 
			{
			text : '增加',
			iconCls : 'icon-add',
			handler : addUser
		
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editUser
		}, '-', {
			text : '删除',
			iconCls : 'icon-no',
			handler : deleteUser
		}]
	});
};

/*
 * 新增用户
 */
function addUser() {
	var url = root + "/user/key/intoAddUserPage"
	setWindowSrc(url);
	setWindowAttr("新增用户",{width:800,height:400});
	openIframeWindow();
}
/*
 * 保存用户信息
 */
function saveTaskOper(){
	if ($('#userForm').form('validate')) { // 进行校验
		var checked = $('input[name="userRoleS"]:checked').val();
		if(checked == undefined || checked == ''){
			alert("请选择角色!");
			return;
		}
		if(!checkAccount_add()){
			$.ajax( {
				type : "POST",
				url : root + '/user/key/addUser',
				data : $('#userForm').serialize(),
				success : function(msg) {
					top.showMessage(msg);
					//新增用户界面为子页面，因此不能直接调用，需调用其父类
					parent.reloadGird();
					cancel();
				}
			});
		}else{
			$.messager.alert("消息提示", "用户名已存在", "warning");
		}
	}
}
/*
 * 修改用户
 */
function editUser() {
	var row = $("#userList").datagrid("getSelected");
	var selectedTaskRole = $('#userList').datagrid('getSelections');
	if (row == null) {
		$.messager.alert("消息提示", "请先选择", "warning");
		return;
	}
	if(selectedTaskRole.length >1){
		$.messager.alert("消息提示","只能修改一条记录","warning");
		return;
	}
	var url = root + "/user/key/intoEditUserPage?userID=" + row.id;
	setWindowSrc(url);
	setWindowAttr("修改用户",{width:800,height:400});
	openIframeWindow();
}
/*
 * 保存修改信息
 */
function saveEditUser(){
	if ($('#userForm').form('validate')) { // 进行校验
		var checked = $('input[name="userRoleS"]:checked').val();
		if(checked == undefined || checked == ''){
			alert("请选择角色!");
			return;
		}
		if(!checkAccount_update()){
			$.ajax( {
				type : "POST",
				url : root + '/user/key/editUser',
				data : $('#userForm').serialize(),
				success : function(msg) {
					top.showMessage(msg);
					//新增用户界面为子页面，因此不能直接调用，需调用其父类
					parent.reloadGird();
					cancel();
				}
			});
		}else{
			$.messager.alert("消息提示", "用户名已存在", "warning");
		}
	}
}

/*
 * 查看用户详细信息
 */
function userInfo(id) {
	var json = '{"userID":"'+ id +'"}';
	var url =  root + "/user/key/getUserInfo?json="+escape(escape(json));
	top.setWindowSrc(url);
	top.setWindowAttr("用户信息",{width:840,height:320});
	top.openIframeWindow();
}


/*
 * 删除 用户
 */
function deleteUser() {
	var selected = $('#userList').datagrid('getSelections');
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
					url : root + '/user/key/deleteUser',
					data : "ids=" + ids,
					success : function(msg) {
						top.showMessage(msg);
						reloadGird();
					}
				});
			}
		});
	}
}

/*
 * 刷新grid
 */
function reloadGird() {
	$('#userList').datagrid('load');
}

/*
 * 关闭窗口
 */
function cancel(){
	parent.closeIframeWindow();
}
/*
 * 获取异步AJAX 
 */
function getAsyncAjax(url, data){
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(msg){
			json = msg;
		}
	})
	return json;
}
/*
 * 新增用户--验证账户是否已存在
 */
function checkAccount_add(){
	var json = '{"account":"'+ $('#account').val() +'"}';
	var url = root + "/user/key/checkAccount";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num == 1){
		flag = true;
	}
	return flag;
}
/*
 * 修改用户--验证账户是否已存在
 */
function checkAccount_update(){
	var json = '{"account":"'+ $('#account').val() 
			+'","userID":"'+ $("#id").val() +'"}';
	var url = root + "/user/key/checkAccount";
	var data = "json=" + json;
	var flag = false;
	var num = getAsyncAjax(url, data);
	if(num == 0){
		//同用户名称和ID查询，没有信息。则表示当前用户修改了账户名称，还的再此验证用户名是否存在 
		if(checkAccount_add())	flag = true;
	}
	return flag;
}