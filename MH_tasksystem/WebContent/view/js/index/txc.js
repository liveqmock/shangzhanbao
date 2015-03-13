// Ext.BLANK_IMAGE_URL = './docs/resources/s.gif';
Docs = {};
var mainTabMap = new Map();
var taskTabMap = new Map();
var taskNum = 0;
ApiPanel = function() {
	ApiPanel.superclass.constructor.call(this, {
				id : 'api-tree',
				region : 'west',
				split : true,
				width : 150,
				minSize : 100,
				maxSize : 500,
				collapsible : true,
				margins : '0 0 0 0',
				cmargins : '0 0 0 0',
				rootVisible : false,
				lines : true,
				tbar : [],
				autoScroll : true,
				animCollapse : false,
				animate : false,
				border : false,
				collapseMode : 'mini',
				loader : new Ext.tree.TreeLoader({
							preloadChildren : true,
							clearOnLoad : false,
							dataUrl : '/MH_tasksystem/index_tree/key/getSystemTree'
						}),
				root : new Ext.tree.AsyncTreeNode({
					text : 'Ext JS',
					id : 'root',
					expanded : true
						// children : [ Docs.classData ]
					}),
				collapseFirst : false
			});

	this.getSelectionModel().on('beforeselect', function(sm, node) {
				return node.isLeaf();
			});
};

Ext.extend(ApiPanel, Ext.tree.TreePanel, {
			selectClass : function(cls) {
				if (cls) {
					var parts = cls.split('_');
					for (var i = 1; i < parts.length; i++) {
						parts[i] = parts[i - 1] + '_' + parts[i];
					}
					var path = '/root/' + parts.join('/');

					this.selectPath(path);
				}
			}
		});

DocPanel = Ext.extend(Ext.Panel, {
	closable : true,
	autoScroll : true,
	autoDestroy : true,
	initComponent : function() {
		var ps = this.cclass.split('.');
		// this.title = this.title;
		DocPanel.superclass.initComponent.call(this);
	},
	scrollToMember : function(member) {
		var el = Ext.fly(this.cclass + '-' + member);
		if (el) {
			var top = (el.getOffsetsTo(this.body)[1]) + this.body.dom.scrollTop;
			this.body.scrollTo('top', top - 25, {
						duration : .75,
						callback : this.hlMember.createDelegate(this, [member])
					});
		}
	},

	scrollToSection : function(id) {
		var el = Ext.getDom(id);
		if (el) {
			var top = (Ext.fly(el).getOffsetsTo(this.body)[1])
					+ this.body.dom.scrollTop;
			this.body.scrollTo('top', top - 25, {
						duration : .5,
						callback : function() {
							Ext.fly(el).next('h2').pause(.2).highlight(
									'#8DB2E3', {
										attr : 'color'
									});
						}
					});
		}
	},

	hlMember : function(member) {
		var el = Ext.fly(this.cclass + '-' + member);
		if (el) {
			el.up('tr').highlight('#cadaf9');
		}
	}
});

MainPanel = function() {
	this.searchStore = new Ext.data.Store({
				proxy : new Ext.data.ScriptTagProxy({
							url : 'http://extjs.com/playpen/api.php'
						}),
				reader : new Ext.data.JsonReader({
							root : 'data'
						}, ['cls', 'member', 'type', 'doc']),
				baseParams : {},
				listeners : {
					'beforeload' : function() {
						this.baseParams.qt = Ext.getCmp('search-type')
								.getValue();
					}
				}
			});

	var test = new Ext.form.TextField();
	MainPanel.superclass.constructor.call(this, {
				id : 'doc-body',
				region : 'center',
				margins : '0 5 5 0',
				resizeTabs : true,

				minTabWidth : 135,
				tabWidth : 135,
				plugins : new Ext.ux.TabCloseMenu(),
				enableTabScroll : true,
				activeTab : 0,
				items : {
					id : 'welcome-panel',
					iconCls : 'icon-docs',
					title : '我的桌面',
					autoScroll : true,
					tbar : [],
					// 此处需要添加grid，而不是嵌入一个页面
					autoLoad : {
						url : 'mydesk.html',
						callback : this.initSearch,
						scope : this
					}
				}

			});
};

Ext.extend(MainPanel, Ext.TabPanel, {
	autoDestroy : true,
	initEvents : function() {
		MainPanel.superclass.initEvents.call(this);
		this.body.on('click', this.onClick, this);
	},

	onClick : function(e, target) {

		if (target = e.getTarget('a:not(.exi)', 3)) {
			var cls = Ext.fly(target).getAttributeNS('ext', 'cls');
			e.stopEvent();
			if (cls) {

				var member = Ext.fly(target).getAttributeNS('ext', 'member');
				this.loadClass(target.href, cls, '', member);
			} else if (target.className == 'inner-link') {
				this.getActiveTab().scrollToSection(target.href.split('#')[1]);
			} else {
				window.open(target.href);
			}
		} else if (target = e.getTarget('.micon', 2)) {
			e.stopEvent();
			var tr = Ext.fly(target.parentNode);
			if (tr.hasClass('expandable')) {
				tr.toggleClass('expanded');
			}
		}
	},

	loadClass : function(href, cls, title, member) {

		var id = cls;
		// 如果当前tab中存在该控件，那么不在打开，否则打开新控件，此处需要优化，如果该控件已经创建过，那么无需创建，直接显示出来
		var tab = this.getComponent(id);
		if (typeof(tab) != "undefined") {
			this.setActiveTab(tab);
			return;
		}
		// 然后检查mainTabMap中是否已经创建，如果已经创建，那么添加就可以了
		var oldP = null;
		if (id.indexOf("Task") == 0) {
			// 判断已经添加了多少个任务，超过3个不允许再添加。
			// 此处需要重构id：

			if (taskNum >= 3) {
				Ext.Msg.alert('友好提示', '同时只能打开三个订单!');
				return;
			}

			if (taskTabMap.size() > 0) {
				oldP = taskTabMap.element(0).value;
				taskTabMap.remove(oldP.id);
				taskNum++;
				// oldP.id = "Task"+taskNum;
			}
			// 如果taskIndex对应的tab取到了，再没有释放前，不能再取。
		} else {
			oldP = mainTabMap.get(id);
		}
		if (oldP != null) {
			// alert("find old P");
			this.add(oldP);
			this.setActiveTab(oldP);
			return;
		}
		/*
		 * var autoLoad = { url : href }; autoLoad.callback = function() { //
		 * Ext.getCmp(id).scrollToMember(member); // 渲染页面组件
		 * alert(id.replace('docs-', '')); alert($('#page_' +
		 * id.replace('docs-', '')).find('.formCon').size()); $.each($('#page_' +
		 * id.replace('docs-', '')).find('.formCon'), function(key, obj) { new
		 * Ext.Panel({ title : 'My Panel', collapsible : true, width : 400, el :
		 * obj }); }); }
		 */

		var doc = new DocPanel({
			autoDestroy : true,
			id : id,
			title : title,
			tabTip : title,
			cclass : cls,
			iconCls : 'icon-cls',
			// autoLoad :autoLoad,
			html : '<iframe src="'
					+ href
					+ '" width="100%" height="100%" frameborder="0" style="border:0" scrolling="auto"></iframe>'
		});

		var p = this.add(doc);
		p.id = id;
		this.setActiveTab(p);
		// 此处对查询预订要特殊处理，最多能够打开三个，超过三个不允许再打开，所以此处就缓存三个查询预订窗口。
		if (id.indexOf("Task") == 0) {
			// taskTabMap.put(p.id, p);
			taskNum++;
		} else {
			// 缓存滋生了好多问题，暂时不用:mainTabMap.put(id, p);
		}

	},
	// txc add
	/*
	 * loadClassID : function(oid, href, cls, title, member) { var id = 'docs-' +
	 * cls; var tab = this.getComponent(id); if (tab) { this.setActiveTab(tab);
	 * if (member) { tab.scrollToMember(member); } } else { var autoLoad = { url :
	 * href }; autoLoad.callback = function() { //
	 * Ext.getCmp(id).scrollToMember(member); // 渲染页面组件
	 * alert(id.replace('docs-', '')); alert($('#page_' + id.replace('docs-',
	 * '')).find('.formCon') .size()); $.each($('#page_' + id.replace('docs-',
	 * '')).find('.formCon'), function(key, obj) { alert(obj);
	 * 
	 * new Ext.Panel({ title : 'My Panel', collapsible : true,
	 * 
	 * width : 400, el : obj }); }); } var p = this.add(new DocPanel({ id : id,
	 * title : title, tabTip : title, cclass : cls, iconCls : 'icon-cls', //
	 * autoLoad :autoLoad, html : '<iframe id="' + oid + '" src="' + href + '"
	 * width="100%" height="100%" frameborder="0" style="border:0"
	 * scrolling="auto"></iframe>' })); // p this.setActiveTab(p); } },
	 */
	// txc add
	initSearch : function() {
		// Custom rendering Template for the View

	},

	doSearch : function(e) {
		var k = e.getKey();
		if (!e.isSpecialKey()) {
			var text = e.target.value;
			if (!text) {
				this.searchStore.baseParams.q = '';
				this.searchStore.removeAll();
			} else {
				this.searchStore.baseParams.q = text;
				this.searchStore.reload();
			}
		}
	}
});

var searchStore = new Ext.data.Store({
			proxy : new Ext.data.ScriptTagProxy({
						url : 'http://extjs.com/playpen/api.php'
					}),
			reader : new Ext.data.JsonReader({
						root : 'data'
					}, ['cls', 'member', 'type', 'doc']),
			baseParams : {},
			listeners : {
				'beforeload' : function() {
					this.baseParams.qt = Ext.getCmp('search-type').getValue();
				}
			}
		});
// left
var api;

// txc add for dynamic add tab
var mainPanel;

// txc add global variable
var orderID;

var tabNum = 0;

// txc add
Ext.onReady(function() {
			Ext.QuickTips.init();
			api = new ApiPanel();

			mainPanel = new MainPanel();
			mainPanel.autoDestroy = false;

			api.on('append', function(t, p, n) {
						if (n.id == 'finishNode') {
							getMyTree();
						}
					});

			api.on('click', function(node, e) {
						// 如果不是叶节点，不做操作
						if (!node.isLeaf()) {
							return;
						}
						e.stopEvent();
						var loadUrl = node.attributes.href;
						var myTreeID = node.id;
						openTaskNode(node.text, node.id, loadUrl);

					});

			//
			mainPanel.on('tabchange', function(tp, tab) {
						api.selectClass(tab.cclass);
					});
			mainPanel.on('remove', function(tp, tab) {
						// 释放到cache.
						if (tab.id.indexOf("Task") == 0) {
							// 暂时不用缓存，因为不能清空页面内容:taskTabMap.put(tab.id, tab);
							taskNum--;
						}
						tab.destroy();
					});

			var expandButton = function(b, pressed) {
				api.root.collapse(true);
				api.expandPath('/root/all/all_' + b.id);
			}
			var header = new Ext.Panel({
						border : false,
						layout : 'anchor',
						region : 'north',
						cls : 'docs-header',
						height : 50,
						items : [{
									xtype : 'box',
									el : 'header',
									border : false,
									anchor : 'none -26'
								}]
					})
			var menuBar = api;
			if (menuMode == "cascade") {
				menuBar = categoryMenu;
			}

			// 此处根据配置选择订单样式，
			var viewport = new Ext.Viewport({
						layout : 'border',
						// items : [header, api, mainPanel]
						items : [header, menuBar, mainPanel]
					});

			api.selectPath('/root/all/all.order');

			// allow for link in
			/*
			 * var page = window.location.href.split('?')[1]; if (page) { var ps =
			 * Ext.urlDecode(page); var cls = ps['class'];
			 * mainPanel.loadClass('./docs/output/' + cls + '.html', cls, '',
			 * ps.member); }
			 */
			viewport.doLayout();
			setTimeout(function() {
						Ext.get('loading').remove();
						Ext.get('loading-mask').fadeOut({
									remove : true
								});
					}, 150);

			var filter = new Ext.tree.TreeFilter(api, {
						clearBlank : true,
						autoClear : true
					});
			var hiddenPkgs = [];
			function filterTree(e) {
				var text = e.target.value;
				Ext.each(hiddenPkgs, function(n) {
							n.ui.show();
						});
				if (!text) {
					filter.clear();
					return;
				}
				api.expandAll();

				var re = new RegExp('^' + Ext.escapeRe(text), 'i');
				filter.filterBy(function(n) {
							return !n.attributes.isClass || re.test(n.text);
						});

				// hide empty packages that weren't filtered
				hiddenPkgs = [];
				api.root.cascade(function(n) {
							if (!n.attributes.isClass
									&& n.ui.ctNode.offsetHeight < 3) {
								n.ui.hide();
								hiddenPkgs.push(n);
							}
						});
			}
		});

Ext.app.SearchField = Ext.extend(Ext.form.TwinTriggerField, {
			initComponent : function() {
				if (!this.store.baseParams) {
					this.store.baseParams = {};
				}
				Ext.app.SearchField.superclass.initComponent.call(this);
				this.on('specialkey', function(f, e) {
							if (e.getKey() == e.ENTER) {
								this.onTrigger2Click();
							}
						}, this);
			},

			validationEvent : false,
			validateOnBlur : false,
			trigger1Class : 'x-form-clear-trigger',
			trigger2Class : 'x-form-search-trigger',
			hideTrigger1 : true,
			width : 180,
			hasSearch : false,
			paramName : 'query',

			onTrigger1Click : function() {
				if (this.hasSearch) {
					this.store.baseParams[this.paramName] = '';
					this.store.removeAll();
					this.el.dom.value = '';
					this.triggers[0].hide();
					this.hasSearch = false;
					this.focus();
				}
			},

			onTrigger2Click : function() {
				var v = this.getRawValue();
				if (v.length < 1) {
					this.onTrigger1Click();
					return;
				}
				if (v.length < 2) {
					Ext.Msg.alert('操作错误', '必须输入2个以上字符才能查询!');
					return;
				}
				this.store.baseParams[this.paramName] = v;
				var o = {
					start : 0
				};
				this.store.reload({
							params : o
						});
				this.hasSearch = true;
				this.triggers[0].show();
				this.focus();
			}
		});

/**
 * Makes a ComboBox more closely mimic an HTML SELECT. Supports clicking and
 * dragging through the list, with item selection occurring when the mouse
 * button is released. When used will automatically set {@link #editable} to
 * false and call {@link Ext.Element#unselectable} on inner elements.
 * Re-enabling editable after calling this will NOT work.
 * 
 * @author Corey Gilmore http://extjs.com/forum/showthread.php?t=6392
 * 
 * @history 2007-07-08 jvs Slight mods for Ext 2.0
 */
Ext.ux.SelectBox = function(config) {
	this.searchResetDelay = 1000;
	config = config || {};
	config = Ext.apply(config || {}, {
				editable : false,
				forceSelection : true,
				rowHeight : false,
				lastSearchTerm : false,
				triggerAction : 'all',
				mode : 'local'
			});

	Ext.ux.SelectBox.superclass.constructor.apply(this, arguments);

	this.lastSelectedIndex = this.selectedIndex || 0;
};

Ext.extend(Ext.ux.SelectBox, Ext.form.ComboBox, {
			lazyInit : false,
			initEvents : function() {
				Ext.ux.SelectBox.superclass.initEvents.apply(this, arguments);
				// you need to use keypress to capture upper/lower case and
				// shift+key,
				// but it doesn't work in IE
				this.el.on('keydown', this.keySearch, this, true);
				this.cshTask = new Ext.util.DelayedTask(
						this.clearSearchHistory, this);
			},

			keySearch : function(e, target, options) {
				var raw = e.getKey();
				var key = String.fromCharCode(raw);
				var startIndex = 0;

				if (!this.store.getCount()) {
					return;
				}

				switch (raw) {
					case Ext.EventObject.HOME :
						e.stopEvent();
						this.selectFirst();
						return;

					case Ext.EventObject.END :
						e.stopEvent();
						this.selectLast();
						return;

					case Ext.EventObject.PAGEDOWN :
						this.selectNextPage();
						e.stopEvent();
						return;

					case Ext.EventObject.PAGEUP :
						this.selectPrevPage();
						e.stopEvent();
						return;
				}

				// skip special keys other than the shift key
				if ((e.hasModifier() && !e.shiftKey) || e.isNavKeyPress()
						|| e.isSpecialKey()) {
					return;
				}
				if (this.lastSearchTerm == key) {
					startIndex = this.lastSelectedIndex;
				}
				this.search(this.displayField, key, startIndex);
				this.cshTask.delay(this.searchResetDelay);
			},

			onRender : function(ct, position) {
				this.store.on('load', this.calcRowsPerPage, this);
				Ext.ux.SelectBox.superclass.onRender.apply(this, arguments);
				if (this.mode == 'local') {
					this.calcRowsPerPage();
				}
			},

			onSelect : function(record, index, skipCollapse) {
				if (this.fireEvent('beforeselect', this, record, index) !== false) {
					this.setValue(record.data[this.valueField
							|| this.displayField]);
					if (!skipCollapse) {
						this.collapse();
					}
					this.lastSelectedIndex = index + 1;
					this.fireEvent('select', this, record, index);
				}
			},

			render : function(ct) {
				Ext.ux.SelectBox.superclass.render.apply(this, arguments);
				if (Ext.isSafari) {
					this.el.swallowEvent('mousedown', true);
				}
				this.el.unselectable();
				this.innerList.unselectable();
				this.trigger.unselectable();
				this.innerList.on('mouseup', function(e, target, options) {
							if (target.id && target.id == this.innerList.id) {
								return;
							}
							this.onViewClick();
						}, this);

				this.innerList.on('mouseover', function(e, target, options) {
							if (target.id && target.id == this.innerList.id) {
								return;
							}
							this.lastSelectedIndex = this.view
									.getSelectedIndexes()[0]
									+ 1;
							this.cshTask.delay(this.searchResetDelay);
						}, this);

				this.trigger.un('click', this.onTriggerClick, this);
				this.trigger.on('mousedown', function(e, target, options) {
							e.preventDefault();
							this.onTriggerClick();
						}, this);

				this.on('collapse', function(e, target, options) {
							Ext.getDoc().un('mouseup', this.collapseIf, this);
						}, this, true);

				this.on('expand', function(e, target, options) {
							Ext.getDoc().on('mouseup', this.collapseIf, this);
						}, this, true);
			},

			clearSearchHistory : function() {
				this.lastSelectedIndex = 0;
				this.lastSearchTerm = false;
			},

			selectFirst : function() {
				this.focusAndSelect(this.store.data.first());
			},

			selectLast : function() {
				this.focusAndSelect(this.store.data.last());
			},

			selectPrevPage : function() {
				if (!this.rowHeight) {
					return;
				}
				var index = Math.max(this.selectedIndex - this.rowsPerPage, 0);
				this.focusAndSelect(this.store.getAt(index));
			},

			selectNextPage : function() {
				if (!this.rowHeight) {
					return;
				}
				var index = Math.min(this.selectedIndex + this.rowsPerPage,
						this.store.getCount() - 1);
				this.focusAndSelect(this.store.getAt(index));
			},

			search : function(field, value, startIndex) {
				field = field || this.displayField;
				this.lastSearchTerm = value;
				var index = this.store.find.apply(this.store, arguments);
				if (index !== -1) {
					this.focusAndSelect(index);
				}
			},

			focusAndSelect : function(record) {
				var index = typeof record === 'number' ? record : this.store
						.indexOf(record);
				this.select(index, this.isExpanded());
				this.onSelect(this.store.getAt(record), index, this
								.isExpanded());
			},

			calcRowsPerPage : function() {
				if (this.store.getCount()) {
					this.rowHeight = Ext.fly(this.view.getNode(0)).getHeight();
					this.rowsPerPage = this.maxHeight / this.rowHeight;
				} else {
					this.rowHeight = false;
				}
			}

		});

Ext.Ajax.on('requestcomplete', function(ajax, xhr, o) {
			if (typeof urchinTracker == 'function' && o && o.url) {
				urchinTracker(o.url);
			}
		});

// 李山添加，创建节点多任务，得与菜单保持一致
function openTaskNode(nodeName, nodeID, loadUrl, num, dnis) {

	if (nodeName == "查询预订") {
		tabNum = tabNum + 1;
		nodeID = "Task" + tabNum;
		nodeName = nodeName;// 此处增加数字不好，因为会一直增加下去，要保持id唯一性，可以使用该方法，但是显示就不用了
		var orderInfoID = createTask();
		loadUrl = loadUrl + '?orderInfoID=' + orderInfoID + "&num=" + num
				+ "&dnis=" + dnis + "";
	}
	var now = new Date(); // 获取系统日期，即Sun Apr 29 16:41:48 UTC+0800 2007
	var nowTime = now.getTime();
	if (loadUrl.indexOf("?") > 0) {
		loadUrl = loadUrl + '&time=' + nowTime;
	} else {
		loadUrl = loadUrl + '?time=' + nowTime;
	}
	mainPanel.loadClass(loadUrl, nodeID, nodeName);

	return nowTime;

}
