/**
 * @class My.ui.FormTableLayout
 * @extends Ext.layout.ContainerLayout
 * @author zfzheng
 * 
 * 
 * 
 * FormTableLayout= FormLayout + TableLayout
 * 
 * 适用于FormLayout/TableLayout适用的场合。 除拥有FormLayout/TableLayout特征外，还具有指定单元格显示功能：
 * 设置autoFlow为true，根据items项的row/col属性定位单元格排列。
 * 可以在同一单元格内显示多项item(指定row/col)为同一位置即可，按在原数组中的顺序排列。 注：
 * 1)若autoFlow为true，items项没有row或col属性的均不被显示。
 * 2)若某item的row/col设置在被融合了的单元格位置，则该项不被显示。
 * 
 * var items=[ { html:'横向融合', row:3, col:0, colspan:2 },{
 * html:'-------我的地盘--------', row:2, col:1 },{ html:'========我也来===========',
 * row:2, col:1 },{ html:'~~~~~~~~~真挤啊~~~~~~~~~~', row:2, col:1 },{
 * html:'非第一单元格起填充', row:0, col:1 },{ html:'纵向融合', row:1, col:0, rowspan:2 },{
 * html:'Hello,how are you?正常Cell', row:1, col:1 },{ name:'count',
 * fieldLabel:'件数', value:'1', xtype:'numberfield', row:4, col:0 },{
 * name:'logTime', fieldLabel:'编制日期', value:'', xtype:'datefield', row:4, col:1 } ]
 * 
 * var tableForm=new Ext.FormPanel({ layout: 'formtable', //使用FormTableLayout
 * style: 'height:100%', title: 'Table Form', items: items });
 * 
 * tableForm.renderTo(Ext.getBody());
 * 
 * 
 */
Ext.layout.FormTableLayout = Ext.extend(Ext.layout.ContainerLayout, {
	// private
	monitorResize : false,

	/**
	 * Table列数
	 */
	columns : 2,
	/**
	 * 是否自动排列 若为true，则按行方向自动排列。 若为false，则根据item指定的[row,col]排列，无row/col属性的项被忽略显示。
	 */
	autoFlow : false,
	/**
	 * Form Element显示模板
	 */

	/**
	 * Table列数
	 */
	formTableStyle : "width:90%;",

	fieldTpl : new Ext.XTemplate(
			'<table class="x-form-item {hideLabel}" tabIndex="-1" style="width:100%;"><tr>',
			'<td id="x-form-el-label-{id}" style="width:20%;align:left;"><label for="{id}" style="{fromtablelayout_labelWidth}{labelStyle}" class="x-form-item-label">{fieldLabel}{labelSeparator}</label></td>',
			'<td id="x-form-el-{id}" style="align:left;"></td>',
			'</tr></table>'),

	fieldTextAreaTpl : new Ext.XTemplate(
			'<table class="x-form-item {hideLabel}" tabIndex="-1" style="width:100%;"><tr>',
			'<td id="x-form-el-label-{id}" style="width:{labeltdwidth};align:left;"><label for="{id}" style="{fromtablelayout_labelWidth}{labelStyle}" class="x-form-item-label">{fieldLabel}{labelSeparator}</label></td>',
			'<td id="x-form-el-{id}" style="align:left;"></td>',
			'</tr></table>'),
			
	dynamicGenFieldTpl : new Ext.XTemplate(
			'<div id="x-form-el-norender-{id}" style="float:left;padding-left:20px;" class="x-form-item {hideLabel}">',
			'<label for="{id}" style="{fromtablelayout_labelWidth}{labelStyle}" class="x-form-item-label">{fieldLabel}{labelSeparator}</label>',
			'<div id="x-form-el-{id}" style="float:left;"></div>',
			'</div>'),

	/**
	 * 普通内容(非Form Element)显示模板
	 */
	cellContentTpl : new Ext.Template('<table><tr><td class="x-form-item-label">{0}</td></tr></table>'),

	// private
	setContainer : function(ct) {
		Ext.layout.FormTableLayout.superclass.setContainer.call(this, ct);
		this.currentRow = 0;
		this.currentColumn = 0;
		this.spanCells = [];
		this.maxCreatedRowIndex = -1;
	},

	// private
	onLayout : function(ct, target) {
		
		var cs = ct.items.items, len = cs.length;

		if (!this.table) {
			// target.addClass('x-table-layout-ct');
			this.table = target.createChild(
					// txc 将border设为0,原值为1
					{
				tag : 'table',
				style : this.formTableStyle,
				border : 0,
				cellspacing : 3,
				cn : {
					tag : 'tbody'
				}
			}, null, true);
		}
		if (this.table) {
			if (!this.autoFlow) {
				var items = [];
				for (var i = 0; i < len; i++) {
					// 如果设置了autoFlow为true，则无row、col属性的字段将无法显示。
					if (typeof cs[i].row != 'undefined'
							&& typeof cs[i].col != 'undefined') {
						cs[i].__index = i;
						items.push(cs[i]);
					}
				}

				ct.items.items = items.sort(function(item1, item2) {
							if (item1.row == item2.row) {
								if (item1.col == item2.col) {
									return item1.__index - item2.__index;
								}
								return item1.col - item2.col;
							}
							return item1.row - item2.row;
						});
			}
			this.renderAll(ct, target);
		}
	},

	// private
	createRow : function(index) {
		var row = this.table.tBodies[0].childNodes[index];
		if (!row) {
			row = document.createElement('tr');
			this.table.tBodies[0].appendChild(row);
			this.maxCreatedRowIndex = Math.max(this.maxCreatedRowIndex, index);
		}
		return row;
	},

	// private
	getRow : function(index) {
		if (!this.autoFlow) {
			// 确保创建index之前的row
			for (var i = Math.max(0, this.maxCreatedRowIndex + 1); i < index; i++) {
				this.createRow(i);
			}
		}
		return this.createRow(index);
	},

	// private
	getCellAt : function(c, row, col) {
		// txc debugger;
		if (this.spanCells[col] && this.spanCells[col][row]) {
			return null;
		}
		// 计算之前有多少spanCells
		var spanCount = 0;
		for (var i = 0; i < col; i++) {
			if (this.spanCells[i] && this.spanCells[i][row]) {
				spanCount++;
			}
		}
		var r = this.getRow(row);
		var cell = r.childNodes[col - spanCount];
		if (cell) {
			return cell;
		}
		this.currentRow = row;
		// 预设置nextCell之前的初始列索引
		this.currentColumn = spanCount - 1;
		for (var i = spanCount; i <= col; i++) {
			this.getNextCell(c);
		}
		return r.childNodes[col - spanCount];
	},

	// private
	getNextCell : function(c) {
		var td = document.createElement('td'), row, colIndex;

		if (!this.columns) {
			row = this.getRow(0);
		} else {
			colIndex = this.currentColumn;
			if (colIndex !== 0 && (colIndex % this.columns === 0)) {
				this.currentRow++;
				colIndex = (c.colspan || 1);
			} else {
				colIndex += (c.colspan || 1);
			}

			// advance to the next non-spanning row/col position
			var cell = this.getNextNonSpan(colIndex, this.currentRow);
			this.currentColumn = cell[0];
			if (cell[1] != this.currentRow) {
				this.currentRow = cell[1];
				if (c.colspan) {
					this.currentColumn += c.colspan - 1;
				}
			}
			row = this.getRow(this.currentRow);
		}
		if (c.colspan) {
			td.colSpan = c.colspan;
		}
		td.className = 'x-table-layout-cell';
		if (c.rowspan) {
			td.rowSpan = c.rowspan;
			var rowIndex = this.currentRow, colspan = c.colspan || 1;
			// track rowspanned cells to add to the column index during the next
			// call to getNextCell
			for (var r = rowIndex + 1; r < rowIndex + c.rowspan; r++) {
				for (var col = this.currentColumn - colspan + 1; col <= this.currentColumn; col++) {
					if (!this.spanCells[col]) {
						this.spanCells[col] = [];
					}
					this.spanCells[col][r] = 1;
				}
			}
		}
		row.appendChild(td);
		return td;
	},

	// private
	getNextNonSpan : function(colIndex, rowIndex) {
		var c = (colIndex <= this.columns ? colIndex : this.columns), r = rowIndex;
		for (var i = c; i <= this.columns; i++) {
			if (this.spanCells[i] && this.spanCells[i][r]) {
				if (++c > this.columns) {
					// exceeded column count, so reset to the start of the next
					// row
					return this.getNextNonSpan(1, ++r);
				}
			} else {
				break;
			}
		}
		return [c, r];
	},
	
    
	// private
	renderItem : function(c, position, target) {
		// target is form or other container
		if (c && !c.rendered) {
			var td = this.autoFlow ? this.getNextCell(c) : this.getCellAt(c,
					c.row, c.col);
			if (!td) {
				// cell at[row,col] is spanCell，不渲染。(row,col设置不正确)
				return;
			}
			if (c.isFormField && c.inputType != 'hidden') {
				var args = {
					id : c.id,
					fieldLabel : c.fieldLabel,
					labelStyle : c.labelStyle || this.labelStyle || '',
					elementStyle : this.elementStyle || '',
					labelSeparator : typeof c.labelSeparator == 'undefined'
							? this.labelSeparator
							: c.labelSeparator,
					hideLabel : (c.itemCls || this.container.itemCls || '')
							+ (c.hideLabel ? ' x-hide-label' : ''),
					clearCls : c.clearCls || 'x-form-clear-left',
					labeltdwidth : typeof c.labeltdwidth == 'undefined'
							? ''
							: c.labeltdwidth,
					fromtablelayout_labelWidth : typeof c.fromtablelayout_labelWidth == 'undefined'
							? ''
							: 'width:' + c.fromtablelayout_labelWidth + ';'
				};
				if (typeof c.fromtablelayout_dynamicGen != 'undefined' && c.fromtablelayout_dynamicGen){
					this.dynamicGenFieldTpl.append(td, args);
				} else {
					if (typeof c.labeltdwidth != 'undefined') {
						this.fieldTextAreaTpl.append(td, args);
					} else {
						this.fieldTpl.append(td, args);
					}
				}
				c.render('x-form-el-' + c.id);
			} else {
				// Ext.layout.FormTableLayout.superclass.renderItem.apply(this,
				// arguments);
				//this.cellContentTpl.append(td, [c.text || c.html || c.value]);
				c.render(td, 'x-form-el-' + c.id);
				//c.rendered = true;
			}
			
		}
	},

	// private
	isValidParent : function(c, target) {
		return true;
	}
});
Ext.Container.LAYOUTS['formtable'] = Ext.layout.FormTableLayout;