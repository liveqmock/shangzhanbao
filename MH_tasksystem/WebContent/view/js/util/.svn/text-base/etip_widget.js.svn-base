/** *********************李山添加，用于根据配置文件创建控件******************* */
Ext.ToolbarExt = Ext.extend(Ext.Toolbar,{
	autoCreate: {
		//cls:'x-toolbar x-small-editor',//此处注释掉保持样式一致性。
		html:'<table cellspacing="0" align="center"><tr></tr></table>'
	}
});

/**
 * 此处显示有问题，需要处理。
 */
Ext.reg('toolbarext',Ext.ToolbarExt);
Ext.PagingToolbarEx = Ext.extend(Ext.PagingToolbar, {
	//查询条件输入表单，在grid初始化时设置进来。
	searchForm : null,
//	onRender : function(ct, position){
//        Ext.PagingToolbar.superclass.onRender.call(this, ct, position);
//        if(this.displayInfo){
//            this.displayEl = Ext.fly(this.el.dom).createChild({cls:'x-paging-info'});
//        }
//        this.add("->");
//        this.first = this.addButton({
//            tooltip: this.firstText,
//            iconCls: "x-tbar-page-first",
//            disabled: true,
//            handler: this.onClick.createDelegate(this, ["first"])
//        });
//        this.prev = this.addButton({
//            tooltip: this.prevText,
//            iconCls: "x-tbar-page-prev",
//            disabled: true,
//            handler: this.onClick.createDelegate(this, ["prev"])
//        });
//        this.addSeparator();
//        this.add(this.beforePageText);
//        this.field = Ext.get(this.addDom({
//           tag: "input",
//           type: "text",
//           size: "3",
//           value: "1",
//           cls: "x-tbar-page-number"
//        }).el);
//        this.field.on("keydown", this.onPagingKeydown, this);
//        this.field.on("focus", function(){this.dom.select();});
//        this.field.on("blur", this.onPagingBlur, this);
//        //alert(this.afterPageText);
//        this.afterTextEl = this.addText(String.format(this.afterPageText, 1));
//        //this.afterTextEl = this.addText(String.format('{0}', 1));
//        this.field.setHeight(18);
//        this.addSeparator();
//        this.next = this.addButton({
//            tooltip: this.nextText,
//            iconCls: "x-tbar-page-next",
//            disabled: true,
//            handler: this.onClick.createDelegate(this, ["next"])
//        });
//        this.last = this.addButton({
//            tooltip: this.lastText,
//            iconCls: "x-tbar-page-last",
//            disabled: true,
//            handler: this.onClick.createDelegate(this, ["last"])
//        });
//        this.addSeparator();
//        this.loading = this.addButton({
//            tooltip: this.refreshText,
//            iconCls: "x-tbar-loading",
//            handler: this.onClick.createDelegate(this, ["refresh"])
//        });
//		this.addSeparator();
//        if(this.dsLoaded){
//            this.onLoad.apply(this, this.dsLoaded);
//        }
//    },
    //在点击分页按钮时调用,此处重载添加参数。
	doLoad : function(start){ 
		if(this.searchForm) {
	        this.store.load({
					params : {
					start : start,
					limit : pageSize,
					jsonData : Ext.util.JSON.encode(this.searchForm.form.getValues())
					}
				});  
		}else {
			this.store.load({params : {	start : start,limit : pageSize}});  
		}
    }
    
	});
	//注册扩展的PagingToolBar
	Ext.reg('pagingtoolbarex', Ext.PagingToolbarEx);

	//txc expands PageBarEx
Ext.SearchPagingToolbar = Ext.extend(Ext.PagingToolbarEx, {
	//添加ID
	jsonData : null,
	//在点击分页按钮时调用,此处重载添加参数。
	doLoad : function(start){  
        this.store.load({
				params : {
				start : start,
				limit : pageSize,
				jsonData : this.jsonData
				}
			});  
    }
	});
	
//注册扩展的SearchPagingToolBar
	Ext.reg('searchpagingtoolbar', Ext.SearchPagingToolbar);

Ext.EtipJsonReader = Ext.extend(Ext.data.JsonReader,{
	read : function(response){
		alert("reader read:");
		//此处重载reader方法，目的是检查错误
		var result = response.responseText;
		
		var resultJSONObj = Ext.util.JSON.decode(result);
		
		if(resultJSONObj.success==false){
			confirmErrorDlg(result.message);								
			return;
		}
        var json = response.responseText;
        var o = eval("("+json+")");
        if(!o) {
            throw {message: "JsonReader.read: Json object not found"};
        }
        return this.readRecords(o);
    }
});
Ext.reg('etipjsonreader',Ext.EtipJsonReader);

Ext.EtipCheckboxGroup = Ext.extend(Ext.form.CheckboxGroup,{
	setValues:function(values){
		var vitems = this.items;
		var vcount = vitems.length;
		for(var i = 0; i < vcount; i++) {
			values=","+values+",";
			var itemValue;
			if(vitems[i]){
				itemValue = ","+vitems[i].inputValue+",";
				if(values.indexOf(itemValue)>=0)
		   			vitems[i].checked=true;
	    		else 
	    			vitems[i].checked= false;
			}else{
				itemValue = ","+vitems.itemAt(i).inputValue+",";
				if(values.indexOf(itemValue)>=0)
	    			vitems.itemAt(i).setValue(true);
	    		else 
	    			vitems.itemAt(i).setValue(false);
			}
		}
	},
	getValues:function(){
		var vitems = this.items;
		var vcount = vitems.length;
		var values = "";
		for(var i = 0; i < vcount; i++) {
			if (typeof(vitems.item) == 'undefined'){
				
			}else{
				var item = vitems.item(i);
				if(item.checked==true){
	    			values= values+","+item.inputValue;
				}
			}
		   
		}
		return values.substring(1);
	}
});

Ext.reg('etipcheckboxgroup',Ext.EtipCheckboxGroup);


Ext.EtipRadioGroup = Ext.extend(Ext.form.RadioGroup,{
	setValues:function(values){
		var vitems = this.items;
		var vcount = vitems.length;
		for(var i = 0; i < vcount; i++) {
			//items.itemAt(i).getValue();
			values=","+values+",";
			var itemValue = ","+vitems[i].inputValue+",";
			if(values.indexOf(itemValue)>=0)
    			vitems[i].checked=true;
    		else 
    			vitems[i].checked= false;
		}
	},
	getValues:function(){
		var vitems = this.items;
		var vcount = vitems.length;
		var values = "";
		for(var i = 0; i < vcount; i++) {
			//items.itemAt(i).getValue();
			if(vitems[i].checked==true){
    			values= values+","+vitems[i].inputValue;
			}
		}
		return values.substring(1);
	}
});

Ext.reg('etipradiogroup',Ext.EtipRadioGroup);
	

Ext.StaticTextField = Ext.extend(Ext.form.Field,{
	defaultAutoCreate:{tag:"div"},
	field:null,
	// value:'未设置',
	onRender:function(ct,position){
		Ext.StaticTextField.superclass.onRender.call(this,ct,position);
		Ext.DomHelper.append(this.el,{
			tag:'div',
			style:'height:100%;width:100%;',
			html:"<span style='FONT-SIZE: 12pt; FONT-FAMILY:system;color:#37b385' >"+this.getValue()+"</span>"
		});
	},
	isDirty:function(){
		return false;;
	},
	ifValid:function(){
		return true;
	},
	
	getValue:function(){
		 if(!this.rendered) {
            return this.value;
        }
        try {
        	var v = this.el.getValue();
        	if(v === this.emptyText || v === undefined){
            	v = '';
        	}
        }catch(ex){
        	alert("get value error of "+this.name);
        }
        
        return v;
	},
	
	//此处有bug，继续处理
	setValue:function(v){
  	  	var  cacheStore=null;
   	 	if(this.field.cache!=null)
    		cacheStore = parent.getCacheStoreByCacheName(this.field.cache);
   	  	if(this.field.dbcache!=null){
   	 		cacheStore = parent.getDBStoreByCacheName(this.field.dbcache);
   	  	}
		
   	  	if(this.field.dic!=null)
    		cacheStore = parent.getDicStoreByAttrCode(this.field.dic);
    	
    	if(cacheStore!=null){
    		//此处遍历是影响效率的
   			var count = cacheStore.getCount();
   			for(var i=0;i<count;i++){
				var record = cacheStore.getAt(i);
				var checkCode = record.get("code");
				if(checkCode==v){
					v = record.get("name")
					break;
				}
			}
    	}
 		
		this.value = v;
		//txc add for remove null
		if(v == null || v == "null" || v == "请选择"){
        	this.value = "";
        }
		//txc add for remove null
        if(this.rendered){
            this.el.dom.value = (v === null || v === undefined ? '' : v);
            this.validate();
            //日期控件的属性值需要特殊处理
            if(this.widgetName!=undefined && this.widetName=='datefield'){
            	//alert(this.value);
            }
            
            Ext.DomHelper.overwrite(this.el,{
			tag:'div',
			style:'height:100%;width:100%;',
			html:"<span style='FONT-SIZE: 12pt; FONT-FAMILY:system;color:#37b385' >"+this.value+"</span>"
			});
        }
	}
});

Ext.reg('statictextfield',Ext.StaticTextField);

/*定义验证类型触发控件*/
Ext.ValidateTriggerField = Ext.extend(Ext.form.TriggerField, {  
	oldValue : null,
	brandCode : 'itour',//增加品牌属性，在校验时判断，如果该属性不为空，那么校验的时候要取到brandCode增加校验条件，默认为itour
    allowBlank: false,   
    validateOnBlur: true,    
    validateField:'',
    invalidText: '此属性值已经存在!',   
    validator: function() {   
       	 return  logicValidate(this,false);   
    },   
    onTriggerClick: function() {   
    	return  logicValidate(this,true);   
    } ,
    setValue : function(v){
    	this.oldValue = v;
        if(this.emptyText && this.el && v !== undefined && v !== null && v !== ''){
            this.el.removeClass(this.emptyClass);
        }
        Ext.form.TextField.superclass.setValue.apply(this, arguments);
        this.applyEmptyText();
        this.autoSize();
    },
    processValue : function(value){
        if(this.stripCharsRe){
            var newValue = value.replace(this.stripCharsRe, '');
            if(newValue !== value){
                this.setRawValue(newValue);
                return newValue;
            }
        }
        return value;
    }
});   
Ext.reg('validatetrigerfield', Ext.ValidateTriggerField);


  
/*统一的逻辑验证方法*/
function logicValidate(element,isAlert) {
	var fieldLabel = element.fieldLabel;
	//此处采用同步调用，
	if(element.getValue().length==0){
		if(isAlert==true){
			Ext.Msg.alert("提示",fieldLabel+"没有输入值,请输入值后再校验!");
		}
		return true;
	}
	var cacheUrl = '/MH_tasksystem/dataCacheStore.jsp?validateField='+element.validateField+"&fieldValue="+encodeURI(encodeURI(element.getValue()));
	//var cacheUrl = '/etipcc/dataCacheStore.jsp?validateField=' + element.validateField;
	if(element.brandCode != null && element.brandCode != undefined && element.brandCode != ""){
		cacheUrl = cacheUrl + "&brandCode=" + encodeURI(element.brandCode);
	}
	var conn = Ext.lib.Ajax.getConnectionObject().conn;   
	conn.open("GET", cacheUrl,false);   
	conn.send(null);   
	
	var result = Ext.util.JSON.decode(conn.responseText);
	if(result.success==false){
		confirmErrorDlg(result.message);
		return;
	}
	
	
	var rvsize = result.rvsize;
	if( rvsize==0){
		if(isAlert==true){
			Ext.Msg.alert("提示",fieldLabel+"不存在"+element.getValue()+",可以添加!");
		}
		return true;
	}
	else {
		if(element.oldValue != null && element.oldValue !=""){
			//判断当前验证的
			if(element.getValue() == element.oldValue){
				return true;
			}
		}
		var error = "";
		if(result.error != undefined && result.error != null && result.error != "null"){
			error = result.error + ",";
		}
		element.invalidText=element.fieldLabel+"已经存在"+element.getValue()+"," + error + "不能再添加!";
		if(isAlert==true){
			Ext.Msg.alert("提示",fieldLabel+"已经存在"+element.getValue()+"," + error + "不能再添加!");
		}
		return false;
	}
	//alert("统一验证方法:"+element.getName()+":"+element.getValue());    
}  

/**
 * 根据url地址获得下列列表
 */
function getDBStoreBySql(cacheSql) {

	// 调用jsp从后台缓冲到前台
	var cacheUrl = '/MH_tasksystem/dataCacheStore.jsp?cacheSql=' + cacheSql;
	var cacheData;
	/**
	 * 以下采用同步调用
	 * @type 
	 */	
	var dataStore;
	var conn = Ext.lib.Ajax.getConnectionObject().conn;   
	conn.open("GET", cacheUrl,false);   
	conn.send(null);   
	
	var result = Ext.util.JSON.decode(conn.responseText);
	//alert(conn.responseText);
	if(result.success==false){
		confirmErrorDlg(result.message);
		return;
	}
	dataStore = new Ext.data.SimpleStore({
						data : result,
						fields : ['code', 'name']
	});
	//alert("dataStore:"+dataStore);
	return dataStore;
}
/**
 * 获取缓冲区值
 * @param {} className
 * @param {} fieldName
 * @param {} value
 * @return {}
 */
function cacheValue(className,fieldName,value){
	var classConfig=parent.objectMap.get(className);
		if(classConfig==null){
			alert("can not find class config of "+className);
			return null;
		}
		var field = classConfig.get(fieldName);
		if(field==null){
			alert("can not find field config of "+className+"."+fieldName);
			return null;
		}
		
		var returnStr="未知";
		var  cacheStore=null;
		
   	 	if(field.cache!=null)
    		cacheStore = parent.getCacheStoreByCacheName(field.cache);
   	  	if(field.dbcache!=null){
   	 		cacheStore = parent.getDBStoreByCacheName(field.dbcache);
   	  	}
   	 	if(field.dic!=null)
    		cacheStore = parent.getDicStoreByAttrCode(field.dic);
    	
    	if(cacheStore!=null){
    		//此处遍历值?
   			var count = cacheStore.getCount();
   			//alert(count);
   			
			for(var i=0;i<count;i++){
				var record = cacheStore.getAt(i);
				var checkCode = record.get("code");
				if(checkCode==value){
					returnStr = record.get("name")
					break;
				}
			}
    	}
		return returnStr;
}		


/**
 * 此处定义widget全局变量，目的是为了减少编程复杂度
 */
var widgetClassName = null;
var widgetWidth="95%";
var widgetViewType ="editable";
var widgetIsTest = false;

/**
 * 根据配置文件，使用className,fieldName,自动创建控件值 在此方法中提供布局需要的特殊配置，包括：width、readonly
 * 
 * @param {}
 *            className
 * @param {}
 *            fieldName
 * @param {}
 *            width
 * @param viwType
 *            哪种显示类型，'editable','readonly','static'
 * @param cacheURL
 * 			   仅仅用于动态生成cacheUrl,此处要求传入一个合法的cacheUrl
 */
var widget= function(className,fieldName,width,viewType,subfield,cacheSql,showDic){
	/*
	 * 以下进行默认值处理
	 */
	if(className==null||className==''){
		className = widgetClassName;
	}
	/*注释是为了提高效率
	if(className==null||className==''){
		alert("widget()必须设置className参数");
		return;
	}*/
	
	/*width有默认值，不一定要设置*/
	if(width==null||width==""||width==undefined){
		width= widgetWidth;
	}
	width=width+"";//width此处应该兼容字符串和数字格式
	
	/*viewType默认值处理*/	
	if(viewType==null||viewType==undefined){
		viewType = widgetViewType;
	}
	
	/*
	 * 根据className,fieldName获取配置项目
	 */ 
	var classConfig=parent.objectMap.get(className);
	
	if(classConfig==null){
		alert("can not find class config of "+className);
		return null;
	}
	
	var field = classConfig.get(fieldName);
	if(field==null){
		alert("can not find field config of "+className+"."+fieldName);
		return null;
	}
	// 此处控件不能在index.jsp中构造，而且也不支持clone
	var widget = null;
	
	//特殊处理，对于创建人，创建日期，最后更新人员，最后更新日期,默认设置属性为static
	/*注释是为了提高效率，
	if(fieldName=="creator"||fieldName=='createDate'||fieldName=="lastUptUser"||fieldName=='lastUptDate'){
		viewType='static';
	}*/
	
	// 此处控件不能在index.jsp中构造，而且也不支持clone
	if(viewType=='static'){
		widget = statictextfield(field);
		widget.field = field;
		widget.name = fieldName;
		
		if(width!=null && width.indexOf('%')>0){
			widget.anchor=width;
		}
		else {
			widget.width = width;
		}
		
		return widget;
	}
	//创建隐藏字段。
	if(viewType=='hidden'){
		widget=hidden(field);
		widget.field = field;
		widget.name = fieldName;
		return widget;
	}
	
	
	var widgetName = field.widget;
	if(widgetName=='checkboxgroup'){
		widget = checkboxgroup(field);
	}
	if(widgetName=='radiogroup'){
		widget =radiogroup(field);
	}
    if(widgetName=='textfield'){
		widget = textfield(field);
	}else if(widgetName=='combo'){
		widget = combo(field,fieldName,subfield,cacheSql,showDic);
	}else if(widgetName=='textarea'){  
		widget = textarea(field);
	}else if(widgetName=='numberfield'){
		widget=numberfield(field);
	}else if(widgetName=='trigger'){ 
		widget = trigger(field);
	}else if(widgetName=='validatetrigger'){ 
		widget = validatetrigger(field);
	}else if(widgetName=='datefield'){ 
		widget=datefield(field);
	}else if(widgetName=='hidden'){ 
		widget=hidden(field);
	}else if(widgetName=='htmleditor'){ 
		widget(htmleditor);
	}else if(widgetName=='label'){ 
		wiget=label(label);
	}else if(widgetName=='checkbox'){
		widget=checkbox(field);
	}else if(widgetName=='radio'){ 
		widget=radio(field);
	}else if(widgetName=='timefield'){ 
		widget=timefield(field);
	}
	// 如果是只读的
	if(viewType=='readonly'){
		widget.readOnly = true;
	}
	else if(viewType=="search") {
		widget.regex="";
		widget.allowBlank=true;
		//恢复可能被变更了的名称
		widget.fieldLabel = field.fieldLabel;
	}
	
	//设置名称
	widget.name = fieldName;
	
	//设置宽度，不知道为什么有错误
	if(width!=null ){
		try {
			if(width.indexOf("%")>0){
				widget.anchor=width;
				//alert("width:"+width);
			}else
				widget.width = width;
		}catch(ex){
			//此处错误是可能直接输入了数字，而不是字符串。
		
			widget.width = width;
		}
	}
	
	//此处添加测试值,只是对编辑状态有效
	/* 注释是为了提高效率
	if(widgetIsTest==true&&viewType=='editable'){
		//alert(field.tvalue);
		if(field.tvalue!=undefined && field.tvalue!=null){
			widget.value = field.tvalue;
		}
	}
	*/
	return widget;
}

function checkboxgroup(field){
	
	  /* 从data缓冲区中取值 */
    if(field.cache!=null){
    	// 此处需要
    	var cacheStore = parent.getCacheStoreByCacheName(field.cache);
    	var myItems=new Array();
    	if(cacheStore==null){
    		alert("没有发现"+field.cache+"对应的配置!");
    	}
    	else{
    		//此处从cacheStore中取值，生成items.
    		var count = cacheStore.getCount();
			for(var i=0;i<count;i++){
				var record = cacheStore.getAt(i);
				var checkCode = record.get("code");
				var checkName = record.get("name");
				myItems[i] = {boxLabel:checkName, name: field.name, inputValue:checkCode};
			}

    	}
    }
    mycolumns = field.columns;
    if(mycolumns==null || mycolumns==0){
    	mycolumns=2;
    }
	var widget = new Ext.EtipCheckboxGroup({columns: mycolumns,items:myItems,vertical:false,anchor:'90%',style:'margin-left:0px;'});
	widget.fieldLabel=field.fieldLabel;
	/* 注释是为了提高效率
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    */
    //此处需要从dataStore中取值，生成items
   return widget;
    
}

function radiogroup(field){
	
	  /* 从data缓冲区中取值 */
    if(field.cache!=null){
    	// 此处需要
    	var cacheStore = parent.getCacheStoreByCacheName(field.cache);
    	var myItems=new Array();
    	if(cacheStore==null){
    		alert("没有发现"+field.cache+"对应的配置!");
    	}
    	else{
    		//此处从cacheStore中取值，生成items.
    		var count = cacheStore.getCount();
			for(var i=0;i<count;i++){
				var record = cacheStore.getAt(i);
				var checkCode = record.get("code");
				var checkName = record.get("name");
				myItems[i] = {boxLabel:checkName, name: field.name, inputValue:checkCode};
			}

    	}
    }
    
    mycolumns = field.columns;
    if(mycolumns==null || mycolumns==0){
    	mycolumns=2;
    }
    
	var widget = new Ext.EtipRadioGroup({columns: mycolumns,items:myItems,vertical:false,anchor:'90%',style:'margin-left:0px;'});
	widget.fieldLabel=field.fieldLabel;
	/*注释是为了提高效率
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    */
   return widget;
    
}


function textarea(field){ 
	var widget = new Ext.form.TextArea({preventScrollbars:'false'});
    // 以下设置公共属性值
	widget.fieldLabel=field.fieldLabel;
	/*注释是为了提高效率
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    
    /* 设置自定义属性 */
    /*
	 * if(field.autoCreate!=null) widget.autoCreate=field.autoCreate;//String
	 * //不够最小长度时提示信息 else widget.autoCreate='';
	 */
     /*
     if(field.growMax!=null) 
    	widget.growMax=field.growMax;// String //不够最小长度时提示信息
     else
    	widget.growMax=1000;
    
     if(field.growMin!=null) 
    	widget.growMin=field.growMin;// String //不够最小长度时提示信息
     else
    	widget.growMin=60;
    	
     if(field.preventScrollbars!=null) 
    	widget.preventScrollbars=field.preventScrollbars;// String
															// //不够最小长度时提示信息
     else
    	widget.preventScrollbars=false;
    */
    return widget;

}



function numberfield(field){ 
	var widget=new Ext.form.NumberField({allowDecimals:'true',allowNegative:'true',baseChars:'0123456789',decimalPrecision:'2',decimalSeparator:'.',maxText:'不允许超出最大值',minValueText:'不允许低于最小值',nanText:'不是有效的数字格式'});
	/* 公共属性设置 */
	widget.fieldLabel=field.fieldLabel;
	/*
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    /* 控件自有属性,注释后提高效率 */
    /*
    if(field.allowDecimals!=null) 
    	widget.allowDecimals=field.allowDecimals;// String //超出最大长度时提示文本
    else 
    	widget.allowDecimals=true;
    
    if(field.allowNegative!=null) 
    	widget.allowNegative=field.allowNegative;// String //超出最大长度时提示文本
    else 
    	widget.allowNegative=false;
     
    if(field.baseChars!=null) 
    	widget.baseChars=field.baseChars;// String //超出最大长度时提示文本
    else 
    	widget.baseChars='0123456789';
    	
    if(field.decimalPrecision!=null) 
    	widget.decimalPrecision=field.decimalPrecision;// String //超出最大长度时提示文本
    else 
    	widget.decimalPrecision='2';
    if(field.decimalSeparator!=null) 
    	widget.decimalSeparator=field.decimalSeparator;// String //超出最大长度时提示文本
    else 
    	widget.decimalSeparator='.';
    // fieldClass : String //默认样式为x-form-field x-form-num-field
    if(field.maxText!=null) 
    	widget.maxText=field.maxText;// String //超出最大长度时提示文本
    else 
    	widget.maxText='不能超过最大值';
    if(field.maxValue!=null) 
    	widget.maxValue=field.maxValue;// String //超出最大长度时提示文本
    else 
    	widget.maxValue=Number.MAX_VALUE;
     if(field.minText!=null) 
    	widget.minText=field.minText;// String //超出最大长度时提示文本
    else 
    	widget.minText='不能小于最小值'; 
   
    if(field.minValue!=null) 
    	widget.minValue=field.minValue;// String //超出最大长度时提示文本
    else 
    	widget.minValue=Number.NEGATIVE_INFINITY; 
    if(field.nanText!=null) 
    	widget.nanText=field.nanText;// String //超出最大长度时提示文本
    else 
    	widget.nanText='未设置值'; 
    */ 		
    return widget;
}

function trigger(field){ 
	var widget = new Ext.form.TriggerField({hideTrigger:'false'});
	widget.triggerClass = 'x-form-search-trigger';
	widget.onTriggerClick=function(e){
		var field = form.findById(field.name);
		//alert("为配置验证函数，请在etip-config中配置validator");
	}
	
	/* 公共属性设置 */
	
    /* 自定义属性，注释提高效率  */
    if(field.hideTrigger!=null) 
    	widget.hideTrigger=field.hideTrigger;// String //超出最大长度时提示文本
    else 
    	widget.hideTrigger=false;
    if(field.triggerClass!=null) 
    	widget.triggerClass=field.triggerClass;// String //超出最大长度时提示文本
   
    	
    /**
     * 继承textfield的属性
     */	
    // 以下设置公共属性值
	 
	widget.fieldLabel=field.fieldLabel;
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    
	/* 然后控件设置自有属性默认值 */
	if(field.grow!=null) 
		widget.grow=field.grow;// Boolean 自动生长?,如果需要,会加宽当前input type="text"
    if(field.growMax!=null) 
    	widget.growMax=field.growMax;// Number
    if(field.growMin!=null) 
    	widget.growMin=field.growMin;// Number
   	if(field.disableKeyFilter!=null)
   		widget.disableKeyFilter=field.disableKeyFilter; // Boolean
   	else
   		
    if(field.emptyClass!=null) 
    	widget.emptyClass=field.emptyClass;// String
   
    	
   
    if(field.emptyText!=null) 
    	widget.emptyText=field.emptyText;// String
    else
    	widget.emptyText="";
    
    if(field.maskRe!=null) 
    	widget.maskRe=field.maskRe;// RegExp 仅允许输入与maskRe匹配的按键
   
   
	if(field.validator!=null) {
    	widget.validator=field.validator;// Function
  }
	// 自定义验证方法,接受当前字段的值,如果合法,返回真,反之返回自定义信息
	if(field.allowBlank!=null)	
		widget.allowBlank=field.allowBlank;
	else
		widget.allowBlank=true;
	// 如果allowBlank=false,那么需要在fieldLabel上添加红色的*
	if(widget.allowBlank==false){
		widget.fieldLabel = widget.fieldLabel+"<span style='FONT-SIZE: 12pt; FONT-FAMILY:黑体;color:red' >*</span>";
	}
		
    if(field.blankText!=null)
    	widget.blankText=field.blankText;
    else
    	widget.blankText='不允许为空';    	
    if(field.maxLength!=null) 
    	widget.maxLength=field.maxLength;// Number
    if(field.maxLengthText!=null) 
    	widget.maxLengthText=field.maxLengthText;// String //超出最大长度时提示文本
    else 
    	widget.maxLengthText="不能超出最大长度:"+field.maxLength;
    if(field.minLength!=null) 
    	widget.minLength=field.minLength;// Number
    if(field.minLengthText!=null) 
    	widget.minLengthText=field.minLengthText;// String //不够最小长度时提示信息
    else
    	widget.minLengthText="不允许低于最小长度:"+field.minLength;
    	
    //如果当前是查询条件模式，那么无需进行输入校验，此处regex,是从cache中取值
    if(field.regex!=null){
    	var regexItem = parent.regexMap.get(field.regex);
    	if(regexItem!=null){
    		// 此处的正则表达式赋值时要把字符串转行为Json对象。
    		widget.regex=eval(regexItem.name);// RegExp,正则匹配
    		widget.regexText =regexItem.text;
    	}
    	else{
    		widget.regex = field.regex;
    	}
    }
 
    if(field.regexText!=null) 
    	widget.regexText=field.regexText;// String,提示
    
    if(field.vtype!=null) 
    	widget.vtype=field.vtype;// String Ext.form.VTypes
									// 中定义的vtype类型名,支持简单的类型验证
    if(field.vtypeText!=null) 
    	widget.vtypeText=field.vtypeText;// String,如果不是,则提示
    if(field.selectOnFocus!=null) 
    	widget.selectOnFocus=field.selectOnFocus;// Boolean
    else
    	widget.selectOnFocus=true;
    return widget;
}


function validatetrigger(field){ 
	var widget = new Ext.ValidateTriggerField({hideTrigger:'false'});
	widget.triggerClass = 'x-form-search-trigger';
	//指定验证的字段
    widget.validateField = field.validateField;
	
    /* 自定义属性 */
    if(field.hideTrigger!=null) 
    	widget.hideTrigger=field.hideTrigger;// String //超出最大长度时提示文本
    else 
    	widget.hideTrigger=false;
    if(field.triggerClass!=null) 
    	widget.triggerClass=field.triggerClass;// String //超出最大长度时提示文本
    	
    	
  	widget.fieldLabel=field.fieldLabel;
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    
	/* 然后控件设置自有属性默认值 */
	if(field.grow!=null) 
		widget.grow=field.grow;// Boolean 自动生长?,如果需要,会加宽当前input type="text"
    if(field.growMax!=null) 
    	widget.growMax=field.growMax;// Number
    if(field.growMin!=null) 
    	widget.growMin=field.growMin;// Number
   	if(field.disableKeyFilter!=null)
   		widget.disableKeyFilter=field.disableKeyFilter; // Boolean
   	else
   		
    if(field.emptyClass!=null) 
    	widget.emptyClass=field.emptyClass;// String
   
    	
   
    if(field.emptyText!=null) 
    	widget.emptyText=field.emptyText;// String
    else
    	widget.emptyText="";
    
    if(field.maskRe!=null) 
    	widget.maskRe=field.maskRe;// RegExp 仅允许输入与maskRe匹配的按键
    // 以下属于输入校验的类型
	if(field.validator!=null) {
    	widget.validator=field.validator;// Function
    	//widget.onTriggerClick=widget.validator;
	}
	// 自定义验证方法,接受当前字段的值,如果合法,返回真,反之返回自定义信息
    	
	if(field.allowBlank!=null)	
		widget.allowBlank=field.allowBlank;
	else
		widget.allowBlank=true;
	// 如果allowBlank=false,那么需要在fieldLabel上添加红色的*
	if(widget.allowBlank==false){
		widget.fieldLabel = widget.fieldLabel+"<span style='FONT-SIZE: 12pt; FONT-FAMILY:黑体;color:red' >*</span>";
	}
		
    if(field.blankText!=null)
    	widget.blankText=field.blankText;
    else
    	widget.blankText='不允许为空';    	
    if(field.maxLength!=null) 
    	widget.maxLength=field.maxLength;// Number
    if(field.maxLengthText!=null) 
    	widget.maxLengthText=field.maxLengthText;// String //超出最大长度时提示文本
    else 
    	widget.maxLengthText="不能超出最大长度:"+field.maxLength;
    if(field.minLength!=null) 
    	widget.minLength=field.minLength;// Number
    if(field.minLengthText!=null) 
    	widget.minLengthText=field.minLengthText;// String //不够最小长度时提示信息
    else
    	widget.minLengthText="不允许低于最小长度:"+field.minLength;
    //如果当前是查询条件模式，那么无需进行输入校验，此处regex,是从cache中取值
    if(field.regex!=null){
    	
    	var regexItem = parent.regexMap.get(field.regex);
    	
    	if(regexItem!=null){
    		// 此处的正则表达式赋值时要把字符串转行为Json对象。
    		widget.regex=eval(regexItem.name);// RegExp,正则匹配
    		widget.regexText =regexItem.text;
    	}
    	else{
    		widget.regex = field.regex;
    	}
    }
    if(field.regexText!=null) 
    	widget.regexText=field.regexText;// String,提示
    if(field.vtype!=null) 
    	widget.vtype=field.vtype;// String Ext.form.VTypes
									// 中定义的vtype类型名,支持简单的类型验证
    if(field.vtypeText!=null) 
    	widget.vtypeText=field.vtypeText;// String,如果不是,则提示
    if(field.selectOnFocus!=null) 
    	widget.selectOnFocus=field.selectOnFocus;// Boolean
    else
    	widget.selectOnFocus=true;
    return widget;
}

function combo(field,fieldName,subfield,cacheSql,showDic){
	var widget=new Ext.form.ComboBox();
	widget.fieldLabel=field.fieldLabel;
	/*	
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */
	if(field.value!=null){
    	widget.value=field.value;
    }else {
    	widget.value='';
    }

    /* 自定义属性 */
    if(field.allQuery!=null){
    	widget.allQuery=field.allQuery;
    }
    
    if(field.autoCreate!=null){
    	widget.autoCreate=field.autoCreate;
    }
    if(field.displayField!=null){
    	widget.displayField=field.displayField;
    }
    else {
    	widget.displayField='name';
    } 
    if(field.editable!=null){
    	widget.editable=field.editable;
    }
    else {
    	widget.editable=false;
    }
    if(field.forceSelection!=null){
    	widget.forceSelection=field.forceSelection;
    }
    else {
    	widget.forceSelection=false;
    }
    
    if(field.handleHeight!=null){// 如果resiable为真时,设置
    	widget.handleHeight=field.handleHeight;
    }
    else {
    	widget.handleHeight=2;
    } 
    if(field.hiddenName!=null){
    	widget.hiddenName=field.hiddenName;
    }
    else {
    	widget.hiddenName=fieldName;
    }   
 	
    if(field.lazyInit!=null){
    	widget.lazyInit=field.lazyInit;
    }
     
    if(field.lazyRender!=null){
    	widget.lazyRender=field.lazyRender;
    }
    else {
    	widget.lazyRender=false;
    }  
    if(field.listAlign!=null){
    	widget.listAlign=field.listAlign;
    }
    else {
    	widget.listAlign='tl-bl';
    }  
       
   if(field.listClass!=null){
    	widget.listClass=field.listClass;
    }
    
    
    if(field.loadingText!=null){
    	widget.loadingText=field.loadingText;
    }else {
    	widget.loadingText='数据在加载';
    } 
    if(field.maxHeight!=null){
    	widget.maxHeight=field.maxHeight;
    }else {
    	widget.maxHeight=300;
    }  
    if(field.minChars!=null){
    	widget.minChars=field.minChars;
    }else {
    	widget.minChars=0;
    } 
    
    if(field.minListWidth!=null){
    	widget.minListWidth=field.minListWidth;
    }else {
    	widget.minListWidth=10;
    } 
    if(field.mode!=null){
    	widget.mode=field.mode;
    }else {
    	widget.mode='local';
    }
    if(field.pageSize!=null){
    	widget.pageSize=field.pageSize;
    }else {
    	widget.pageSize=0;
    } 
    if(field.queryDelay!=null){
    	widget.queryDelay=field.queryDelay;
    }else {
    	widget.queryDelay=10;
    }  
    if(field.queryParam!=null){
    	widget.queryParam=field.queryParam;
    }
    if(field.resizable!=null){
    	widget.resizable=field.resizable;
    }else {
    	widget.resizable=false;
    } 
    if(field.selectOnFocus!=null){
    	widget.selectOnFocus=field.selectOnFocus;
    }else {
    	widget.selectOnFocus!=true;
    }
    if(field.selectedClass!=null){
    	widget.selectedClass=field.selectedClass;
    }
   
    if(field.shadow!=null){
    	widget.shadow=field.shadow;
    }else {
    	widget.shadow=false;
    }
    if(field.valueField!=null){
    	widget.valueField=field.valueField;
    }else {
    	widget.valueField='code';
    }
     
    if(field.typeAhead!=null){
    	widget.typeAhead=field.typeAhead;
    }else {
    	widget.typeAhead=false;
    }
   
    if(field.triggerAction!=null){
    	widget.triggerAction=field.triggerAction;
    }else{
    	widget.triggerAction = 'all';
    }
    if(field.triggerClass!=null){
    	widget.triggerClass=field.triggerClass;
    }
    
   /* 从data缓冲区中取值 */
    if(field.cache!=null){
    	// 此处需要
    	var cacheStore = parent.getCacheStoreByCacheName(field.cache);
    	if(cacheStore==null){
    		alert("没有发现"+field.cache+"对应的配置!");
    	}
    	else{
    		widget.store=cacheStore;
    		// alert("to find CacheStore:"+field.cache+":"+cacheStore);
    	}
    }
    /**
     * 从数据库缓冲区中取值
     */
     if(field.dbcache!=null){
    	var cacheStore = parent.getDBStoreByCacheName(field.dbcache);
    	//alert(cacheStore);
    	if(cacheStore==null){
    		alert("没有发现"+field.dbcache+"对应的配置!");
    	}
    	else{
    		widget.store=cacheStore;
    		// alert("to find CacheStore:"+field.cache+":"+cacheStore);
    	}
    }
    
    //txc add
    if(showDic!=null && showDic!=""){
		var showDicStore = parent.getShowDicStoreByDicType(showDic);
		if(showDicStore==null){
			alert("没有对应"+showDic+"的配置");
		}
		else{
			var arr = [];
   					var dArr = showDicStore.data.items;
   					
   					for(var i=0;i<dArr.length;i++){
   						var myArr = [];
   						myArr.push(dArr[i].data.code);
   						myArr.push(dArr[i].data.name);
   						arr.push(myArr);
   					}
   			widget.store = new Ext.data.SimpleStore({
						data : [],
						fields : ['code', 'name']
					});
			widget.store.loadData(arr);
		}
	}
    //txc add
    
    //从数据库字典中取值
    if(field.dic!=null){
    	// 主要用于配置数据库字典
   	  var dicStore = parent.getDicStoreByAttrCode(field.dic);
    	if(dicStore==null){
    		alert("没有发现"+field.dic+"对应的dic配置!");
    	}
    	else{
    		widget.store=dicStore;
    	}
    }    
    /**
     * 此处要求从自定义的url中取值，因为此处要求带条件，所以不能用公共函数。
     */
    if(cacheSql!=null){
    	// 此处实时查询出下拉框
    	var dbStore = getDBStoreBySql(cacheSql);
    	//此处需要检查
    	if(dbStore==null){
    		alert("没有发现"+cacheSql+"对应的配置数据!");
    	}
    	else{
    		widget.store=dbStore;
    	}
    }  
   	
    // subfield!=null,那么当该控件值改变时，刷新subfield的值。
    if(subfield!=null){
    	widget.subWidget = subfield;
    		widget.on('select',function(){
    			//txc update
 					//alert("value changed:"+widget.value);	
    				if(subfield.subWidget!=null){
    					subfield.subWidget.clearValue();
    				}
    				subfield.clearValue();
   					var attrCode = widget.value;
   					var arr = [];
   					var dArr = parent.getDicStoreByAttrCode(attrCode).data.items;
   					
   					for(var i=0;i<dArr.length;i++){
   						var myArr = [];
   						myArr.push(dArr[i].data.code);
   						myArr.push(dArr[i].data.name);
   						arr.push(myArr);
   					}
   					subfield.store.loadData(arr);
   					
			});
	}
    return widget;
}

function datefield(field){
	var widget = new Ext.form.DateField();
	/* 公共属性设置 */
	widget.fieldLabel=field.fieldLabel;
	/*
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */
    	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    /* 控件自有属性 */
    /*
    if(field.altFormats!=null){
    	widget.altFormats=field.altFormats;
    }
    if(field.autoCreate!=null){
    	widget.autoCreate=field.autoCreate;
    }
    if(field.disabledDates!=null){
    	widget.disabledDates=field.disabledDates;
    }
    if(field.disabledDatesText!=null){
    	widget.disabledDatesText=field.disabledDatesText;
    }
    if(field.disabledDays!=null){
    	widget.disabledDays=field.disabledDays;
    }
   	if(field.disabledDaysText!=null){
    	widget.disabledDaysText=field.disabledDaysText;
    }*/
    if(field.format!=null){
    	widget.format=field.format;
    }
    else {
    	widget.format='Y-m-d';
    }
    /*
    if(field.invalidText!=null){
    	widget.invalidText=field.invalidText;
    }
    else {
    	widget.invalidText='格式不正确';
    } 
    if(field.maxText!=null){
    	widget.maxText=field.maxText;
    } 
    if(field.maxValue!=null){
    	widget.maxValue=field.maxValue;
    }
    if(field.minText!=null){
    	widget.minText=field.minText;
    }
    if(field.minValue!=null){
    	widget.minValue=field.minValue;
    } 
    if(field.triggerClass!=null){
    	widget.triggerClass=field.triggerClass;
    }*/
    return widget;
}

function hidden(field){ 
	var widget=new Ext.form.Hidden();
		/* 公共属性设置 */
		
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
	
	return widget;
}

function htmleditor(field){ 
	var widget=new Ext.form.HtmlEditor();
	/* 公共属性设置 */
	if(field.fieldLabel!=null) 
		widget.fieldLabel=field.fieldLabel;
	else 
		widget.fieldLabel='未设置' ;
	
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    /* 控件自定义属性 */
    
    if(field.createLinkText!=null){
    	widget.createLinkText=field.createLinkText;
    }
    if(field.defaultLinkValue!=null){
    	widget.defaultLinkValue=field.defaultLinkValue;
    }
 	if(field.enableAlignments!=null){
    	widget.enableAlignments=field.enableAlignments;
    }
 	if(field.enableColors!=null){
    	widget.enableColors=field.enableColors;
    }
 	if(field.enableFont!=null){
    	widget.enableFont=field.enableFont;
    }
 	if(field.enableFontSize!=null){
    	widget.enableFontSize=field.enableFontSize;
    }
 	if(field.enableFormat!=null){
    	widget.enableFormat=field.enableFormat;
    }
 	if(field.enableLinks!=null){
    	widget.enableLinks=field.enableLinks;
    }
    if(field.enableLists!=null){
    	widget.enableLists=field.enableLists;
    }
 	if(field.enableSourceEdit!=null){
    	widget.enableSourceEdit=field.enableSourceEdit;
    }
	// fontFamilies : Array //这个当然要用汉字的字体组成的数组了
    return widget;
}

function label(field){ 
	var widget=new Ext.form.Label();
	/* 公共属性设置 */
	if(field.fieldLabel!=null) 
		widget.fieldLabel=field.fieldLabel;
	else 
		widget.fieldLabel='未设置' ;
	
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
	return widget;
}

function checkbox(field){
	var widget=new Ext.form.Checkbox({boxLabel:'',checked:'false'});
	widget.fieldLabel=field.fieldLabel;
	/*	
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }

    /* 定义控件自有属性 */
    // autoCreate : String/Object,
    /*
    if(field.boxLabel!=null){
    	widget.boxLabel=field.boxLabel;
    }
    if(field.checked!=null){
    	widget.checked=field.checked;
    }
    else {
    	widget.checked=false;
    } 
    if(field.fieldClass!=null){
    	widget.fieldClass=field.fieldClass;
    } 
   if(field.focusClass!=null){
    	widget.focusClass=field.focusClass;
    }
    */
	return widget;
}

function radio(field){ 
	var widget=new Ext.form.Radio();
	/* 公共属性设置 */
	widget.fieldLabel=field.fieldLabel;
	
	/*
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    /* 定义控件自有属性 */
    // autoCreate : String/Object,
    /*
    if(field.boxLabel!=null){
    	widget.boxLabel=field.boxLabel;
    }*/
    if(field.checked!=null){
    	widget.checked=field.checked;
    }
    else {
    	widget.checked=false;
    } 
    /*
    if(field.fieldClass!=null){
    	widget.fieldClass=field.fieldClass;
    } 
   if(field.focusClass!=null){
    	widget.focusClass=field.focusClass;
    }
    */
	return widget;
}

function timefield(field){ 
	var widget=new Ext.form.TimeField();
	
	/* 公共属性设置 */
	widget.fieldLabel=field.fieldLabel;
	/*
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    /* 控件自定义属性设置 */
    /*
	if(field.altFormats!=null){
    	widget.altFormats=field.altFormats;
    }
    if(field.increment!=null){
    	widget.increment=field.increment;
    }
    else{
    	widget.increment=5;
    }
    if(field.invalidText!=null){
    	widget.invalidText=field.invalidText;
    }
    else{
    	widget.invalidText='格式不正确';
    }
   if(field.maxText!=null){
    	widget.maxText=field.maxText;
    } 
    if(field.maxValue!=null){
    	widget.maxValue=field.maxValue;
    }
    if(field.minText!=null){
    	widget.minText=field.minText;
    }
    if(field.minValue!=null){
    	widget.minValue=field.minValue;
    } 
    */
	return widget;
}

function statictextfield(field){
	
	var widget=new Ext.StaticTextField();
		widget.fieldLabel=field.fieldLabel;
	/*
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    	//此处需要向控件赋值
    }
    else {
    	widget.value='';
    }
    
    //此处设置控件名称，对日期字段进行特殊处理
    widget.widgetName = field.widgetName;

    return widget;
}

function caption(store,code){
	var row = store.getTotalCount();
	for(var i=0;i<row;i++){
		var codei = store.getAt(i).get('code');
		if(codei==code){
			return store.getAt(i).get('name');
		}
	}
	return code;
}


function textfield(field){
	// 首先构造一个空对象
	var widget=new Ext.form.TextField();
    // 以下设置公共属性值
	widget.fieldLabel=field.fieldLabel;
	/*	
    if(field.labelSeparator!=null)	
    	widget.labelSeparator=field.labelSeparator; 
    else
    	widget.labelSeparator=':';
    
    if(field.validateOnBlur!=null)
    	widget.validateOnBlur=field.validateOnBlur; 
    else
    	 widget.validateOnBlur=true;
    	 
    if(field.validationDelay!=null)
    	widget.validationDelay=field.validationDelay;
    else 
    	widget.validationDelay=250;
    */	
    if(field.value!=null){
    	widget.value=field.value;
    }
    else {
    	widget.value='';
    }
    
	/* 然后控件设置自有属性默认值 */
	/*
	if(field.grow!=null) 
		widget.grow=field.grow;// Boolean 自动生长?,如果需要,会加宽当前input type="text"
    if(field.growMax!=null) 
    	widget.growMax=field.growMax;// Number
    if(field.growMin!=null) 
    	widget.growMin=field.growMin;// Number
   	if(field.disableKeyFilter!=null)
   		widget.disableKeyFilter=field.disableKeyFilter; // Boolean
   	else
   		
    if(field.emptyClass!=null) 
    	widget.emptyClass=field.emptyClass;// String
   
    	
   
    if(field.emptyText!=null) 
    	widget.emptyText=field.emptyText;// String
    else
    	widget.emptyText="";
    
    if(field.maskRe!=null) 
    	widget.maskRe=field.maskRe;// RegExp 仅允许输入与maskRe匹配的按键
    */
    // 以下属于输入校验的类型
	if(field.validator!=null) 
    	widget.validator=field.validator;// Function
											// 自定义验证方法,接受当前字段的值,如果合法,返回真,反之返回自定义信息
    	
	if(field.allowBlank!=null)	
		widget.allowBlank=field.allowBlank;
	else
		widget.allowBlank=true;
	// 如果allowBlank=false,那么需要在fieldLabel上添加红色的*
	if(widget.allowBlank==false){
		widget.fieldLabel = widget.fieldLabel+"<span style='FONT-SIZE: 12pt; FONT-FAMILY:黑体;color:red' >*</span>";
	}
	/*
    if(field.blankText!=null)
    	widget.blankText=field.blankText;
    else
    	widget.blankText='不允许为空';    	
    	
    if(field.maxLength!=null) 
    	widget.maxLength=field.maxLength;// Number
    if(field.maxLengthText!=null) 
    	widget.maxLengthText=field.maxLengthText;// String //超出最大长度时提示文本
    else 
    	widget.maxLengthText="不能超出最大长度:"+field.maxLength;
    if(field.minLength!=null) 
    	widget.minLength=field.minLength;// Number
    if(field.minLengthText!=null) 
    	widget.minLengthText=field.minLengthText;// String //不够最小长度时提示信息
    else
    	widget.minLengthText="不允许低于最小长度:"+field.minLength;
    */
    	
    //如果当前是查询条件模式，那么无需进行输入校验，此处regex,是从cache中取值
    if(field.regex!=null){
    	var regexItem = parent.regexMap.get(field.regex);
    	if(regexItem!=null){
    		// 此处的正则表达式赋值时要把字符串转行为Json对象。
    		widget.regex=eval(regexItem.name);// RegExp,正则匹配
    		widget.regexText =regexItem.text;
    	}
    	else{
    		widget.regex = field.regex;
    	}
    }
 	/*
    if(field.regexText!=null) 
    	widget.regexText=field.regexText;// String,提示
    
    if(field.vtype!=null) 
    	widget.vtype=field.vtype;// String Ext.form.VTypes
									// 中定义的vtype类型名,支持简单的类型验证
    if(field.vtypeText!=null) 
    	widget.vtypeText=field.vtypeText;// String,如果不是,则提示
    	
    if(field.selectOnFocus!=null) 
    	widget.selectOnFocus=field.selectOnFocus;// Boolean
    else
    	widget.selectOnFocus=true;
    */
    return widget;
}





function dicTree(dicCode,treeName,width) {
	// 以下json数组从DBDic中获取。
	var address = parent.getDicByCode(dicCode);
	
	// 将树形结构生成一棵树，root声明为根节点，没有父节点的就是根节点，根节点只有一个
	var root;
	var treeMap = new Map();
	
	for(var i=0;i<address.length;i++){
		var record = address[i];
		// 生成树节点并添加到Map
		var treeNode =new Ext.tree.AsyncTreeNode({
			text : record.attrName,
			id : record.attrCode,
			allowDrag : false,
			checked: false,
			leaf:false
		});
		var dicCode = record.dicCode;
		treeMap.put(dicCode,treeNode);
		// 获取父亲节点
		
		parentCode= dicCode.substring(0,dicCode.length-2);
		
		parentNode = treeMap.get(parentCode);
		
		if(parentNode==null){
			root = treeNode;
			break;
		}
		else {
			//txc zhu
		//	parentNode.appendChild(treeNode);
		}
		
	}
	var loader = new Ext.tree.TreeLoader({dataUrl:''});
	var tree = new Ext.tree.TreePanel({
		title : treeName,
		width : width,
		root : root,
		loader:loader
	});
	tree.on('beforeload', function(node,event){ 
				loader.dataUrl='/MH_tasksystem/dataCacheStore.jsp?treeId='+node.id; 
			}
	); 
	tree.treeMap = treeMap;
	
	//此处需要解决取值和赋值的问题
	return tree;
}

/**
 * 此处设置树形数据字典的值。 
 */
function setDicTreeValue(tree,values){
	//alert("set dic tree value:");
	var treeMap = tree.treeMap;
	tree.values = values;
	var size = treeMap.size();
	values = ","+values+",";
	var nodes = treeMap.values();
	
	for(var i=0;i<size;i++){
		var node = nodes[i];
		node.checked = false;
		if(values.indexOf(node.id)>=0){
			node.checked = true;
			node.el.checked = true;
			
		}
	}
}


/**
 * 此处设置树形数据字典的值。 
 */
function getDicTreeValue(tree){
	var treeMap = tree.treeMap;
	var size = treeMap.size();
	values = "";
	var nodes = treeMap.values();
	for(var i=0;i<size;i++){
		var node = nodes[i];
		if(node!=null&& node.checked==true){
			values=values+","+node.id;
		}
	}
	values = values.substring(1);
	return values;
}

