	Ext.BLANK_IMAGE_URL = './docs/resources/s.gif';

	Docs = {};
	
	
	ApiPanel = function() {
	ApiPanel.superclass.constructor.call(this, {
				id : 'api-tree',
				region : 'west',
				split : true,
				width : 200,
				minSize : 100,
				maxSize : 500,
				collapsible : true,
				margins : '0 0 5 5',
				cmargins : '0 0 0 0',
				rootVisible : false,
				lines : false,
				tbar : [],
				autoScroll : true,
				animCollapse : false,
				animate : false,
				border : true,
				collapseMode : 'mini',
				loader : new Ext.tree.TreeLoader({
							preloadChildren : true,
							clearOnLoad : false,
							dataUrl : parent.projectNamePath+'/index_tree/key/getSystemTree'
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
	initComponent : function() {
		//var ps = this.cclass.split('.');
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
	
		var test= new Ext.form.TextField();
		MainPanel.superclass.constructor.call(this, {
				id : 'doc-body',
				region : 'center',
				margins : '0 5 5 0',
				resizeTabs : true,
				minTabWidth : 135,
				tabWidth : 135,
				plugins : new Ext.ux.TabCloseMenu(),
				enableTabScroll : true
			//	activeTab : 0,
			//	items : {
			/*		id : 'welcome-panel',
					iconCls : 'icon-docs',
					title : '我的桌面',
					autoScroll : true,
					tbar : [],
					//此处需要添加grid，而不是嵌入一个页面
					autoLoad : {
						url : 'mydesk.html',
						callback : this.initSearch,
						scope : this
					}
					*/
			//	}
				
			});
	};

	Ext.extend(MainPanel, Ext.TabPanel,	{
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
		var id = 'docs-' + cls;
		var tab = this.getComponent(id);
		/*
		 * 每次点击后都重新load页面所以注释下列代码 如需恢复:用变量tab替换if语句中的false。 Comment by Leo
		 */
		if (false) {
			this.setActiveTab(tab);
			if (member) {
				tab.scrollToMember(member);
			}
		} else {
			var autoLoad = {
				url : href
			};
			autoLoad.callback = function() {
				// Ext.getCmp(id).scrollToMember(member);
				// 渲染页面组件
				alert(id.replace('docs-', ''));
				alert($('#page_' + id.replace('docs-', '')).find('.formCon')
						.size());
				$.each($('#page_' + id.replace('docs-', '')).find('.formCon'),
						function(key, obj) {
							new Ext.Panel({
										title : 'My Panel',
										collapsible : true,
										width : 400,
										el : obj
									});
						});
			}
			var p = this.add(new DocPanel({
				id : id,
				title : title,
				tabTip : title,
				cclass : cls,
				iconCls : 'icon-cls',
				// autoLoad :autoLoad,
				html : '<iframe src=\''
						+ href
						+ '\' width=\'100%\' height=\'100%\' frameborder=\'0\' style=\'border:0\' scrolling=\'auto\'></iframe>'
			}));
			// p
			this.setActiveTab(p);
		}
	},
	// txc add
	loadClassID : function(oid, href, cls, title, member) {
		var id = 'docs-' + cls;
		var tab = this.getComponent(id);
		if (tab) {
			this.setActiveTab(tab);
			if (member) {
				tab.scrollToMember(member);
			}
		} else {
			var autoLoad = {
				url : href
			};
			autoLoad.callback = function() {
				// Ext.getCmp(id).scrollToMember(member);
				// 渲染页面组件
				alert(id.replace('docs-', ''));
				alert($('#page_' + id.replace('docs-', '')).find('.formCon')
						.size());
				$.each($('#page_' + id.replace('docs-', '')).find('.formCon'),
						function(key, obj) {
							alert(obj);

							new Ext.Panel({
										title : 'My Panel',
										collapsible : true,

										width : 400,
										el : obj
									});
						});

			}
			var p = this.add(new DocPanel({
				id : id,
				title : title,
				tabTip : title,
				cclass : cls,
				iconCls : 'icon-cls',
				// autoLoad :autoLoad,
				html : '<iframe id=\''
						+ oid
						+ '\' src=\''
						+ href
						+ '\' width=\'100%\' height=\'100%\' frameborder=\'0\' style=\'border:0\' scrolling=\'auto\'></iframe>'
			}));
			// p
			this.setActiveTab(p);
		}
	},
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

// txc add
Ext.onReady(function() {

	Ext.QuickTips.init();

	api = new ApiPanel();

	mainPanel = new MainPanel();
	
	api.on('append', function(t,p,n){ 
       if(n.id == 'finishNode'){
        getMyTree();
        } 
     });
     
     api.hide();

	api.on('click', function(node, e) {
				if (node.isLeaf()) {
					e.stopEvent();
					var loadUrl = node.attributes.href;
					// var loadUrl='/etipcc/joey.html';
					mainPanel.loadClass(loadUrl, node.id, node.text);
				}
			});

	mainPanel.on('tabchange', function(tp, tab) {
				api.selectClass(tab.cclass);
			});

	var expandButton = function(b, pressed) {
		api.root.collapse(true);
		api.expandPath('/root/all/all_' + b.id);
	}
	//txc zhu
/*	var header = new Ext.Panel({
		border : false,
		layout : 'anchor',
		region : 'north',
		cls :    'docs-header',
		height : 40,
		items : [{
					xtype : 'box',
					el : 'header',
					border : false,
					anchor : 'none -26'
				}]
	})
	*/
	

	var viewport = new Ext.Viewport({
				layout : 'border',
//				items : [header, api, mainPanel]
				items : [api, mainPanel]
			});

	api.selectPath('/root/all/all.order');

	// allow for link in
	var page = window.location.href.split('?')[1];
	if (page) {
		//txc zhu
	/*	var ps = Ext.urlDecode(page);
		var cls = ps['class'];
		mainPanel.loadClass('./docs/output/' + cls + '.html', cls, '',
				ps.member);
				*/
	}

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
					if (!n.attributes.isClass && n.ui.ctNode.offsetHeight < 3) {
						n.ui.hide();
						hiddenPkgs.push(n);
					}
				});
	}
	
	if(treeID == null){
		mainPanel.loadClass(parent.projectNamePath+'/welcome.html', 'welcome','欢迎页面');
	}
	if(treeID == "all_member_userbase_userbaseadmin"){
		mainPanel.loadClass(parent.projectNamePath+'/view/pages/member/user_member_admin/list.html', 'all_member_userbase_userbaseadmin','维护个体会员信息');
	}
	if(treeID == "all_member_groupbase_groupbaseadmin"){
		mainPanel.loadClass(parent.projectNamePath+'/view/pages/member/group_member_admin/list.jsp', 'all_member_groupbase_groupbaseadmin','维护组织会员信息');
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
		

	