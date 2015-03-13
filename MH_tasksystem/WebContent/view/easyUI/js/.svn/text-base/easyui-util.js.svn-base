/***************************************************
 *          easyUI  一些方法的包装 
 * 1) 更改tabl的title
***************************************************/
/**修改面板的title*/
function modifyTabTitle(title , tabsID , which  ) {
	var options = new Object();
	var tab = null;
	var tabsObj = null;
	
	if( !tabsID  || 0 == ( tabsObj = $("#" +tabsID)).length ){
		//未找到
		return false;
	}
	
	if( which && "" != which ){
//		tab = tabsObj.tabs("getTab",which);
		tabs = tabsObj.tabs("tabs");//查找所有的tab,做匹配
		
		for ( var int = 0; int < tabs.length; int++) {
			
			if( execTabTitleReg(which,tabs[int].panel('options').title) ){
				tab = tabs[int];
				break;
			}
		}
		
	}else{
		//如果未指定,tab,默认当前选中
		tab = tabsObj.tabs('getSelected');
	}
	
	options.tab = tab ;
	options.options = new  Object() ;
	options.options.title = title ;
	
	tabsObj.tabs('update',options);
}

/**更新 tab title 附加 grid 的数量 -- 格式 意见箱[20]**/
function flauntTabGridTotal( title , tabsID ,easyUIGridID ) {
	var total =   getGridTotal(easyUIGridID);
	var oldTitle = title;
	if( undefined != total  ){
		title += "["+total+"]";
	}
	modifyTabTitle(title,tabsID,oldTitle);
}

/**更新 tab title 附加 grid 的数量 -- 格式 意见箱[20]**/
function flauntTabGridTotalByTotal( title , tabsID ,Total ) {
	if( undefined != total  ){
		title += "["+total+"]";
	}
	modifyTabTitle(title,tabsID);
}

/**更新 tab title 附加 grid 的数量 
 *通过获取数据的url 
 * -- 格式 意见箱[20]**/
function flauntTabGridTotalByUrl( title , tabsID ,url ,which ) {

	var gridInfo = getAjax(url);
	var gridInfoObj =  eval("(" + gridInfo + ")");
	var total = gridInfoObj.total;
	if( undefined != total ){
		title += "["+total+"]";
	}
	
	modifyTabTitle(title,tabsID,which);
}

//AJAX提交
function getAjax(url){
	var val;
	$.ajax({type : "POST",url : url,async:false
		,success : function(num){
			val = num;
		}
	})
	return val;
}

/**获取grid分页的总条数**/
function getGridTotal(easyUIGridID) {
	var  gridObj = $('#' + easyUIGridID );
	if( 0 ==  gridObj.length ){
		return  undefined;
	}
	return gridObj.datagrid("getData").total;
}

/**获取grid 分页属性*/
function getGridPagerOptions( easyUIGridID ) {
	var  gridObj = $('#' + easyUIGridID );
	if( 0 ==  gridObj.length ){
		return  undefined;
	}
	return gridObj.datagrid("getPager").pagination("options");
}

/**tab title正则匹配*/
function execTabTitleReg( regTitle,tabTitle ) {
	var	pattern = "^(^("+regTitle+")(\\[\\d+\\])?)$"
	var reg = new  RegExp( pattern );
    var execReSult	 = reg.exec(tabTitle);
    
    return null == execReSult ? false : true;
}

