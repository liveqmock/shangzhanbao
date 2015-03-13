/*******************************************************************************
 * @author ETIP
 * @date 2009-3-20
 * @version 1.0
 ******************************************************************************/

var lastButton=null;//记录最后被点击的按钮
var rootPath;
// 设置每页显示信息条数
var pageSize = 10;
function globalSetting() {
	Ext.BLANK_IMAGE_URL = '/MH_tasksystem/view/ext22/resources/images/default/s.gif';
	Ext.QuickTips.init();
	Ext.lib.Ajax.defaultPostHeader += '; charset=UTF-8';
	Ext.form.Field.prototype.msgTarget = 'side';// 统一指定错误信息提示方式
}



function confirmAlertDlg(messageStr) {
	// 此处使用一个专门的FormPanel显示，而不是用MessageBox
	var message = widget('ErrorMessage', 'message', '95%', 'static');
	message.value = messageStr;
	var myItems = [message];
	var errorForm = new Ext.FormPanel({
				labelAlign : 'right',
				bodyStyle : 'padding:5px',
				width : 300,
				frame : true,
				border : false,// layout:'column',
				items : myItems,
				buttons : [{
							text : '关闭',
							handler : function() {
								errorWin.hide();
							}
						}]
			});

	var errorWin = getWinForm(300, 200, errorForm);
	var title = "<img src='/MH_tasksystem/img/alertDlg.gif'/>";
	errorWin.setTitle(title);
	errorWin.show();
	//
}

/**
 * 嵌入式登录窗口，在用户登录系统后，如果发现未登录，那么要求重新登录
 */
var loginWindow;
function innerLoginWindow(){
		if(typeof(loginWindow)=="undefined"){       
		var addForm = new Ext.FormPanel(
				{html:'<iframe name="air" src="/view/pages/mini/front/login.jsp" width="100%" height="100%" frameborder="0" style="border:0" scrolling="auto"></iframe>'}
		  );
		 
    	loginWindow = new Ext.Window({
			layout : 'fit',
			constrain : true,
			title:'你上次登录已经失效，请重新登录',
			width : 400,
			closeAction : 'hide',
			draggable:false,
			height : 240,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			bodyStyle : 'padding:5 5 5 5',
			animCollapse : true,
			items : [addForm]
		});
		}
		loginWindow.show();
}	

function confirmErrorDlg(message) {
	// 此处使用一个专门的FormPanel显示，而不是用MessageBox
	var errorCode = widget('ErrorMessage', 'errorCode', 400, 'static');// 支持编辑
	errorCode.value = message.errorCode;
	//此处需要校验 errorCode是否是UnLoginedUser,如果是，那么进入登录处理
	if(errorCode.value=="UnLoginedUser"){
		//弹出一个模态window，访问登录提示页面，让用户登录，登录后关闭窗口，可以继续操作。
		innerLoginWindow();
		return;
	}
	var errorName = widget('ErrorMessage', 'errorName', 400,'static');
	errorName.value = message.errorName;
	var errorCause = widget('ErrorMessage', 'errorCause', 400,'static');
	errorCause.value = message.errorCause;
	var errorSolution = widget('ErrorMessage', 'errorSolution', 400,'static');
	errorSolution.value = message.errorSolution;
	var errorRoot;
	var myItems;
	if (message.errorRoot != '') {
		errorRoot = widget('ErrorMessage', 'errorRoot', 400, 'readonly');
		errorRoot.value = message.errorRoot;
		errorCause.height = 50;
		errorRoot.height = 55;
		errorSolution.height = 55;
		myItems = [errorCode, errorName, errorCause, errorRoot, errorSolution];
	} else {
		errorCause.height = 80;
		errorSolution.height = 80;
		myItems = [errorCode, errorName, errorCause, errorSolution];
	}
	var errorWin;

	var errorForm = new Ext.FormPanel({
				labelAlign : 'right',
				bodyStyle : 'padding:5px',
				width : 600,
				frame : true,
				border : false,// layout:'column',
				items : myItems,
				buttons : [{
							text : '关闭',
							handler : function() {
								errorWin.hide();
							}
						}, {
							text : "<img src='/MH_tasksystem/img/gridSubmit.gif'/>保存",
							handler : function() {
								var cacheUrl = '/MH_tasksystem/dataCacheStore.jsp?';
								// 如果取form中控件的值，此处取出来的值没有改变
								// alert(errorName.getValue());

								var requestConfig = {
									url : cacheUrl,
									params : {
										errorCode : errorCode.getValue(),
										errorName : errorName.getValue(),
										errorCause : errorCause.getValue(),
										errorSolution : errorSolution
												.getValue()
									},
									callback : function(options, success, response) {
										alert("例外字典更新成功!");
									}
								}
								Ext.Ajax.request(requestConfig);
							}
						}]
			});

	errorWin = getWinForm(600, 400, errorForm);
	var title = "<img src='/MH_tasksystem/img/93.gif'/> 异常提示";
	errorWin.setTitle(title);
	errorWin.show();
	// Ext.MessageBox.alert('友情提示',message.errorCode+"//"+message.error);
}

var storeButtonMap = new Map();

/**
 * 在启动列表查询时，都通过本方法执行，目的是统一控制重复提交
 * @param {} button 触发按钮
 * @param {} handler 需要调用的方法
 */
function gridSearch(button,handler){
	lastButton =button;
	button.disable();
	var store = eval(handler);
	storeButtonMap.put(store.id,button);
}

/**
 * 在列表加载完成后，调用此方法，要求将关联的按钮设置为enable
 */
function loadHandler(storeid) {
	var button = storeButtonMap.get(storeid);
	if(button!=null){
		button.enable();
		storeButtonMap.remove(storeid);
	}
}


function loadExceptionHandler(obj, params, response) {
	var message = response.responseText;
	//alert(message);
	//此处错误产生乱码，需要解决，重点是参数化例外，不然可以ajax方式获取错误信息。
	message = message.substring(message.indexOf("{"));
	message = message.substring(0, message.indexOf("}") + 1);
	var result = Ext.util.JSON.decode(message);
	
	confirmErrorDlg(result);
}

/**
 * ajax请求，统一的错误处理方法,此处错误提示信息有乱码，如何处理
 * 
 * @param {}
 *            response
 * @param {}
 *            options
 */
function failureHandler(response, options) {
	var message = response.responseText;
	message = message.substring(message.indexOf("{"));
	message = message.substring(0, message.indexOf("}") + 1);
	var result = Ext.util.JSON.decode(message);
	
	confirmErrorDlg(result);
}

var getGridNoAutoStore = function(fields, url) {
	var store = new Ext.data.Store({ // 配置分组数据集
		//autoLoad:{params:{start:0,limit:pageSize}},
		reader : new Ext.data.JsonReader({
					totalProperty : "results", // 记录总数
					root : "items", // 包含数据的JSON节点名
					fields : fields
				}),
		proxy : new Ext.data.HttpProxy({ // 创建HttpProxy代理
			url : url
		})
	});
	var curDate = new Date();
	store.id = curDate.getTime();
	store.proxy.addListener('loadexception', loadExceptionHandler);
	store.proxy.addListener("load",function() {loadHandler(store.id)});
	return store;
}

var getGridStore = function(fields, url) {
	var store = new Ext.data.Store({ // 配置分组数据集
		autoLoad : {
			params : {
				start : 0,
				limit : pageSize
			}
		},
		reader : new Ext.data.JsonReader({
					totalProperty : "results", // 记录总数
					root : "items", // 包含数据的JSON节点名
					fields : fields
				}),
		proxy : new Ext.data.HttpProxy({ // 创建HttpProxy代理
			url : url
		})
	});
	store.proxy.addListener('loadexception', loadExceptionHandler);
	var curDate = new Date();
	store.id = curDate.getTime();
	store.proxy.addListener("load",function(){loadHandler(store.id)});
	return store;
}

var getNormalStore=function(fields){
	var store = new Ext.data.Store({fields: fields});
	return store;
}



/*******************************************************************************
 * 通过读取JSON文件建立树结构菜单 *******
 * 
 * @param title
 *            树菜单显示的标题
 * @param titleid
 *            树菜单的唯一标识
 * @param url
 *            读取树节点的Json文件的路径
 * @param rootId
 *            树菜单所在节点的唯一标识
 ******************************************************************************/

var getTreeMenu = function(title, treeId, url, rootId) {
	var menu = new Ext.tree.TreePanel({
				title : title,
				border : false,
				deferHeight : true, // True表示为根据外置的组件延时计算高度，false表示允许该组件自行设置高度（缺省为false）
				id : treeId,
				autoScroll : true,
				enableDD : true,// 是否支持拖曳效果
				containerScroll : true, // 是否支持滚动条
				rootVisible : false, // 是否显示根节点
				loader : new Ext.tree.TreeLoader({
							dataUrl : url
						}),
				tools : [{
							id : 'refresh',
							handler : function() {
								var tree = Ext.getCmp(treeId);
								tree.root.reload();
							}
						}]
			});

	// 非同步读取树创建根节点
	var root = new Ext.tree.AsyncTreeNode({
				draggable : true, // 设置节点是否可以拖动，默认为false
				id : rootId
			});

	menu.setRootNode(root);
	root.expand();

	return menu;
}

/** ********** 为树菜单创建面板区域 ***************************************** */

var getTreePanel = function() {
	var treePanel = new Ext.Panel({
				autoScroll : true,
				layout : 'accordion',
				layoutConfig : {
					titleCollapse : true, // 默认是就是true，点击标题就可以折叠子面板,
					// 如果设置成false，就只能点击title右边的图标折叠子面板。
					animate : true, // 展开折叠的时候是否使用动画效果呢。
					activeOnTop : false, // 默认值是false，进行展开折叠后，子面板的顺序不会改变，
					// 如果改成true，就会随着展开折叠改变顺序，就是总把展开的子面板放在最上头啦。
					fill : true
					// 子面板充满父面板的剩余空间
				},
				border : false,
				width : 200,
				height : 200
			});

	return treePanel;
}

/*******************************************************************************
 * 创建中心功能面板区域*************
 * 
 * @param href
 *            刚加载进入时默认显示的页面
 ******************************************************************************/

var getContentPanel = function(href) {
	var contentPanel = new Ext.TabPanel({
		region : 'center', // 显示位置
		enableTabScroll : true,
		activeTab : 0, // 活动页面
		border : false,
		items : [{
			id : 'homePage',
			title : "欢迎页面",
			autoScroll : true,
			html : '<iframe id="ifr" scrolling="auto" frameborder="0" width="100%" height="600" src="'
					+ href + '"></iframe>'
		}]
	});

	return contentPanel;
}

/*******************************************************************************
 * 定义节点树的点击事件 **************
 * 
 * @param node
 *            读取的Json文件中包含所有属性的一个节点，通过它可以取得有关这个节点的所有属性
 * @param tabPanel
 *            加载的页面所要显示的面板区域
 ******************************************************************************/

var setOnClick = function(node, tabPanel) {
	// 得到节点的href
	var href = node.attributes.link;
	// event.stopEvent();
	var n = tabPanel.getComponent(node.id);
	if (!n) { // 判断是否已经打开该面板
		n = tabPanel.add({
			'id' : node.id,
			'title' : node.text,
			closable : true,
			// 通过html载入目标页
			html : '<iframe id="ifr" scrolling="auto" frameborder="0" width="100%" height="600" src="'
					+ href + '"></iframe>'
		});
	}
	tabPanel.setActiveTab(n); // 把当前加入的页面设为活动页面
}

/*******************************************************************************
 * 创建分页工具栏 ******************
 * 
 * @param store
 *            数据集对象
 * @param pageSize
 *            每页显示的数量
 ******************************************************************************/
var getPagingBar = function(store) {
	var pageTbar = new Ext.PagingToolbarEx({ // 分页工具栏
		store : store,
		pageSize : pageSize,
		displayInfo : true
	});

	return pageTbar;
}

/*******************************************************************************
 * 创建可编辑列表EditorGridPanel*****************
 * 
 * @param title
 *            编辑列表的标题
 * @param toDiv
 *            列表在页面的显示位置，页面定义的div的id
 * @param tbar,bbar
 *            编辑列表的上下工具栏
 * @param store
 *            数据集对象
 * @param columnModel
 *            用来显示的表格列信息
 * @param cb
 *            配置列的选择模式
 ******************************************************************************/

var getEditorGridPanel = function(title, toDiv, width, height, tbar, bbar,
		store, columnModel, cb) {

	var grid = new Ext.grid.EditorGridPanel({ // 创建表格面板组件
		title : title,
		applyTo : toDiv, // 设置表格显示的位置
		width : width,
		height : height,
		frame : true,
		loadMask : {
			msg : '数据加载中。。。'
		},
		tbar : tbar,
		bbar : bbar,
		store : store,
		stripeRows : true, // 显示斑马线
		autoScroll : true, // 当数据超出表格高度时，自动显示滚动条
		sm : cb, // 设置表格的选择模式
		cm : columnModel
	});

	return grid;
}

/*******************************************************************************
 * 创建不可编辑列表GridPanel*****************
 * 
 * @param title
 *            编辑列表的标题
 * @param toDiv
 *            列表在页面的显示位置，页面定义的div的id
 * @param tbar,bbar
 *            编辑列表的上下工具栏
 * @param store
 *            数据集对象
 * @param columnModel
 *            用来显示的表格列信息
 * @param cb
 *            配置列的选择模式
 ******************************************************************************/

var getGridPanel = function(title, toDiv, width, height, tbar, bbar,
		store, columnModel, cb) {

	var grid = new Ext.grid.GridPanel({ // 创建表格面板组件
		title : title,
		applyTo : toDiv, // 设置表格显示的位置
		width : width,
		height : height,
		frame : true,
		loadMask : {
			msg : '数据加载中。。。'
		},
		tbar : tbar,
		bbar : bbar,
		store : store,
		stripeRows : true, // 显示斑马线
		autoScroll : true, // 当数据超出表格高度时，自动显示滚动条
		sm : cb, // 设置表格的选择模式
		cm : columnModel
	});

	return grid;
}

/*******************************************************************************
 * 创建弹出窗口************************
 * 
 * @param width
 *            窗口宽度
 * @param height
 *            窗口高度
 * @param form
 *            所要显示的表单
 ******************************************************************************/
var getWinForm = function(width, height, form) {
	var win = new Ext.Window({
				layout : 'fit',
				constrain : true,
				width : width,
				closeAction : 'hide',
				height : height,
				resizable : true,
				shadow : true,
				modal : true,
				closable : true,
				bodyStyle : 'padding:5 5 5 5',
				animCollapse : true,
				items : [form]
			});
	return win;
}

/*******************************************************************************
 * 加载表单数据*****************
 * 
 * @param id
 *            加载数据的唯一标识
 * @param url
 *            后台处理的url路径
 * @param formPanel
 *            表单
 ******************************************************************************/

var loadForm = function(id, url, formPanel) {
	formPanel.form.load({
				waitMsg : "正在加载数据请稍后...",// 提示信息
				waitTitle : "提示",// 标题
				url : url,// 请求的url地址
				params : {
					jsonData : id
				},
				method : 'GET',// 请求方式
				success : function(form, action) {// 加载成功的处理函数
					// Ext.Msg.alert('提示', '数据加载成功');
				},
				failure : function(form, action) {// 加载失败的处理函数
					Ext.Msg.alert("提示", "数据加载失败");
				}
			});
}

/*******************************************************************************
 * 提交表单数据 *****************
 * 
 * @param formPanel
 *            定义的表单信息
 * @param url
 *            后台处理的url路径
 * @param win
 *            定义的弹出窗口
 * @param store
 *            数据集对象
 * @param pageTbar
 *            分页工具栏对象
 ******************************************************************************/
var submitForm = function(formPanel, url, winForm, store, pageTbar) {
	var start = 0;
	if (pageTbar) {
		start = pageTbar.cursor;
	}
	formPanel.form.submit({
				clientValidation : true,// 进行客户端验证
				waitMsg : "正在提交数据请稍后...",// 提示信息
				waitTitle : "提示",// 标题
				url : url,// 请求的url地址
				method : 'GET',// 请求方式
				success : function(form, action) {// 加载成功的处理函数
					winForm.hide();
					store.load({
								params : {
									start : start,
									limit : pageSize
								}
							});
					Ext.Msg.alert("提示", "操作数据信息成功");
				},
				failure : function(form, action) {// 加载失败的处理函数
					if (action.result) {
						Ext.Msg.alert("提示", "操作数据信息失败");
					}
				}
			});
}

/*******************************************************************************
 * 删除数据记录************************
 * 
 * @param idLists
 *            删除信息的ID数组列表
 * @param url
 *            后台处理方法的URL
 * @param store
 *            数据集对象
 * @param pageTar
 *            分页工具栏对象
 ******************************************************************************/

// store,pageTbar应该去掉
var deleteRecords = function(idLists, url, store, pageTbar, grid,
		researchHandler) {
	// var ids = idLists.join('-'); // join() 方法用于把数组中的所有元素放入一个字符串。
	// 元素是通过指定的分隔符进行分隔的。
	var msgTip = Ext.MessageBox.show({
				title : "提示",
				width : 250,
				msg : "正在删除信息请稍后..."
			});
	Ext.Ajax.request({
				url : url,
				params : {
					jsonData : idLists
				},
				method : 'POST',
				success : function(response, options) {
					msgTip.hide();
					var result = Ext.util.JSON.decode(response.responseText);
					if (result.success) {
						if (researchHandler != null) {
							researchHandler();
						}
						Ext.Msg.alert("提示", "删除信息成功！");
					} else {
						Ext.Msg.alert("提示", "删除信息失败！");
					}
				},
				failure : function(response, options) {
					msgTip.hide();
					Ext.Msg.alert("提示", "删除信息请求失败！");
				}
			});
}

/*******************************************************************************
 * 获取所选信息的ID列表*************************
 * 
 * @param id
 *            列表记录的唯一标识
 * @param grid
 *            可编辑列表对象
 ******************************************************************************/

var getIdList = function(id, grid) {
	var recs = grid.getSelectionModel().getSelections();
	var list = [];
	// recs
	if (recs.length == 0) {
		Ext.MessageBox.alert("提示", "请选择要进行操作的信息！");
	} else {
		for (var i = 0; i < recs.length; i++) {
			var rec = recs[i];
			list.push(rec.get(id));
		}
	}
	return list;
}

// 该函数用于将编辑过的Grid中的数据行对应的Store中的数据项转换成JSON
function convertRecordsToJson(items) {
	if (items.length == 0) {
		return '';
	}
	var jsonData = "[";
	for (i = 0; i < items.length; i++) {
		record = items[i];
		jsonData += Ext.util.JSON.encode(record.data) + ",";
	}
	jsonData = jsonData.substring(0, jsonData.length - 1) + "]";
	return jsonData;
}

function getStoreTOJson(store) {
	if (store.getCount() == 0) {
		return '';
	}
	var jsonData = "[";
	for (var i = 0; i < store.getCount(); i++) {
		jsonData += Ext.util.JSON.encode(store.getAt(i).data) + ",";
	}
	jsonData = jsonData.substring(0, jsonData.length - 1) + "]";
	return jsonData;
}
function getStoreTOObject(store) {
	var jsonData = [];
	if (store.getCount() == 0) {
		return jsonData;
	}
	for (var i = 0; i < store.getCount(); i++) {
		//alert(store.getAt(i).data);
		jsonData.push(store.getAt(i).data);
	}
	return jsonData;
}

function arrayToJson(items) {
	if (items.length == 0) {
		return '';
	}
	var jsonData = "[";
	for (i = 0; i < items.length; i++) {
		record = items[i];
		jsonData += Ext.util.JSON.encode(record) + ",";
	}
	jsonData = jsonData.substring(0, jsonData.length - 1) + "]";
	return jsonData;
}

// 显示一个进度对话框
function showProcessMsg() {
	Ext.MessageBox.show({
				msg : "正在保存数据, 请稍侯",
				progressText : "正在保存中",
				width : 300,
				wait : true,
				waitConfig : {
					interval : 200
				},
				icon : 'ext-mb-save'
			});
}

function showError() {
	Ext.MessageBox.hide();
	Ext.MessageBox.show({
				title : "错误",
				msg : "操作失败！",
				buttons : Ext.Msg.OK,
				icon : Ext.MessageBox.ERROR
			});
}

function submit(form, url, method, params, success, failure) {
	form.submit({
				url : url,
				method : method,
				params : params,
				success : success,
				failure : failure
			});
}

// txc add
function searchCondition() {
	var v = document.getElementById('form-div').style.display;
	if (v == 'none') {
		document.getElementById('form-div').style.display = '';
	} else {
		document.getElementById('form-div').style.display = 'none';
	}
}
/*
 * lhc add 判断json对象是否相等
 */

function compareObject(obj1, obj2) {
	if (typeof obj1 != typeof obj2) {
		return false;
	}
	if (typeof obj1 == 'object') {
		for (var o in obj1) {
			if (typeof obj2[o] == 'undefined')
				return false;
			if (!compareObject(obj1[o], obj2[o]))
				return false;
		}
		return true;
	} else {
		return obj1 == obj2;
	}
}

/** **************************txc add Map***************************** */
/*
 * MAP对象，实现MAP功能 written by txc, 2009-05-19
 * 
 * 接口： size() 获取MAP元素个数 isEmpty() 判断MAP是否为空 clear() 删除MAP所有元素 put(key, value)
 * 向MAP中增加元素（key, value) remove(key) 删除指定KEY的元素，成功返回True，失败返回False get(key)
 * 获取指定KEY的元素值VALUE，失败返回NULL element(index)
 * 获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL containsKey(key)
 * 判断MAP中是否含有指定KEY的元素 containsValue(value) 判断MAP中是否含有指定VALUE的元素 values()
 * 获取MAP中所有VALUE的数组（ARRAY） keys() 获取MAP中所有KEY的数组（ARRAY）
 * 
 * 例子： var map = new Map();
 * 
 * map.put("key", "value"); var val = map.get("key")
 */
function Map() {
	this.elements = new Array();

	// 获取MAP元素个数
	this.size = function() {
		return this.elements.length;
	}

	// 判断MAP是否为空
	this.isEmpty = function() {
		return (this.elements.length < 1);
	}

	// 删除MAP所有元素
	this.clear = function() {
		this.elements = new Array();
	}

	// 向MAP中增加元素（key, value)
	this.put = function(_key, _value) {
		this.elements.push({
					key : _key,
					value : _value
				});
	}

	// 删除指定KEY的元素，成功返回True，失败返回False
	this.remove = function(_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	}

	// 获取指定KEY的元素值VALUE，失败返回NULL
	this.get = function(_key) {
		var value = null;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					value = this.elements[i].value;
				}
			}
		} catch (e) {
			value = null;
		}
		return value;
	}

	// 获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
	this.element = function(_index) {
		if (_index < 0 || _index >= this.elements.length) {
			return null;
		}
		return this.elements[_index];
	}

	// 判断MAP中是否含有指定KEY的元素
	this.containsKey = function(_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					bln = true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	}

	// 判断MAP中是否含有指定VALUE的元素
	this.containsValue = function(_value) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].value == _value) {
					bln = true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	}

	// 获取MAP中所有VALUE的数组（ARRAY）
	this.values = function() {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	}

	// 获取MAP中所有KEY的数组（ARRAY）
	this.keys = function() {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	}
}

/** ***************txc add for maptoarr*********************** */
function mapToArr(map) {
	var items = map.elements;
	items.sort(function compare(a, b) {
				return a.key - b.key;
			});
	var arr = [];
	for (var i = 0; i < items.length; i++) {
		var els = [];
		els.push(items[i].key);
		els.push(items[i].value);
		arr.push(els);
	}
	return arr;
}
/** **********************lc时间验证************************************ */
function checkTime(beginTime, endTime) {

	var beginDate = beginTime.getValue();
	var endDate = endTime.getValue();

	if (beginDate == null || beginDate == "") {
		Ext.Msg.alert("提示", "请选择起始时间!");
		return false;
	} else if (endDate == null || endDate == "") {
		Ext.Msg.alert("提示", "请选择结束时间!");
		return false;
	} else if (beginDate > endDate) {
		Ext.Msg.alert("提示", "时间范围设置错误!");
		return false;
	} else {
		return true;
	}

}
// 房型验证
function checkState(form) {
	var ckbox = form.items.items;
	var count = 0;
	for (var i = 0; i < ckbox.length; i++) {
		if (ckbox[i].checked) {
			count++;
		};
	}
	if (count == 0) {
		Ext.Msg.alert("提示", "请选择房型！");
		return false;
	} else {
		return true;
	}
}

// 提交工作流请求，创建工作流实例
		 
function createJBPM(jbpmClassName, jbpmObjectId, jbpmStatus) {
			Ext.Ajax.request(
				{url : '/MH_tasksystem/process_registry_admin/key/createProcessInstance',
				 params : {jbpmClassName:jbpmClassName,jbpmObjectId:jbpmObjectId,jbpmStatus:jbpmStatus},
				 method:'POST',
				 success : function(response, options) {
				 		alert("提交成功!");
					},
				 failure : failureHandler
				});
	
}
