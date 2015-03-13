package com.common.util;

import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTreeUtil {
	
	/**jsonArray add a collection*/
	@SuppressWarnings("unchecked")
	public static JSONArray jsonArray_add(JSONArray jsonArr ,List obj){
		jsonArr = null==jsonArr ? new JSONArray() : jsonArr;
		
		for (Object object : obj) {
			jsonArr.add(object);
		}
		return jsonArr;
	}
	
	////////////////jsonTree相关/////////////////////////////
	
	
	/**添加孩子*
	 * @category 对已有的tree 节点进行添加孩子
	 * @param state 是否更改/指定叶子的状态,默认不/关闭
	 * @return 
	 * */
	public static JSONObject addChild(JSONObject treeNodeJson , JSONObject newChild )throws Exception{
		return addChild(treeNodeJson, newChild, null , null);
	}
	/**添加孩子(组)*
	 * @category 对已有的tree 节点进行添加孩子
	 * @param state 是否更改/指定叶子的状态,默认不/关闭
	 * * @param index 插入位置
	 * @return 
	 * */
	public static JSONObject addChildren(JSONObject treeNodeJson , JSONArray children,Integer index )throws Exception{

		for (Object object : children) {
			JSONObject child = JSONObject.fromObject( (JSONObject)object );
			addChild(treeNodeJson, child);
		}
		return treeNodeJson;
	}
	
	/**添加孩子*
	 * @category 对已有的tree 节点进行添加孩子
	 * @param state 是否更改/指定叶子的状态,默认不/关闭
	 * * @param index 插入位置
	 * @return 
	 * */
	public static JSONObject addChild(JSONObject treeNodeJson , JSONObject newChild,Integer index )throws Exception{
		return addChild(treeNodeJson, newChild, null , index);
	}
	
	/**添加孩子*
	 * @category 对已有的tree 节点进行添加孩子
	 * @param state 是否更改/指定叶子的状态,默认不/关闭
	 * @param index 插入位置
	 * @return 
	 * */
	public static JSONObject addChild(JSONObject treeNodeJson , JSONObject newChild ,Boolean state ,Integer index )throws Exception{
		
		if( null == treeNodeJson || treeNodeJson.isEmpty()
				|| null == newChild || newChild.isEmpty() ){
			System.out.println( "JsonTreeUtil.addChild 传入参数为空"  );
			throw new NullPointerException("JsonTreeUtil.addChild参数为空");
		}
		
		String nodeState = ( null == state )?  "close" : ( state? "open" : "close" );//如果为指定state,或者为假,定机构是关闭的,否则,为打开
		
		JSONArray childrenJson  = null;
		
		if( null != treeNodeJson.get("children") ){
			childrenJson =  JSONArray.fromObject( treeNodeJson.getString("children") );
			if( null != state){//如果要指定改变节点状态
				treeNodeJson.element("state", nodeState);
			}
		}else{
			childrenJson = new JSONArray();//本来没有孩子,为其新建个
			if( null == treeNodeJson.get("state")  ){
				//如果本来是叶子,还需要为其添加
				treeNodeJson.element("state", nodeState);
			}
		}
		
		//把新孩子仍到孩子堆里面去
		if( null == index || 0 > index ){
			childrenJson.add( newChild );
		}else{
			childrenJson.add(index , newChild );
		}
		
		treeNodeJson.element("children", childrenJson.toString() );//更新节点
		
		return treeNodeJson;
	}
	
	/**移除节点的一个子节点*
	 * @param treeNodeJson 焦点节点的json ;deadChild 要移除的节点的json
	 * @param state 是否更改节点的状态 : true 打开  false 关闭
	 * */
	public static JSONObject removeChild(JSONObject treeNodeJson , JSONObject deadChild )throws Exception{
		return removeChild(treeNodeJson, deadChild, null);
		
	}
	
	/**移除节点的一个子节点*
	 * @param treeNodeJson 焦点节点的json ;deadChild 要移除的节点的json
	 * @param state 是否更改节点的状态 : true 打开  false 关闭
	 * */
	public static JSONObject removeChild(JSONObject treeNodeJson , JSONObject deadChild ,Boolean state )throws Exception{
		
		if( null == treeNodeJson || treeNodeJson.isEmpty()
				|| null == deadChild || deadChild.isEmpty() ){
			System.out.println( "JsonTreeUtil.addChild 传入参数为空"  );
			throw new NullPointerException("JsonTreeUtil.addChild参数为空");
		}
		String nodeState = ( null == state )?  "close" : ( state? "open" : "close" );//如果为指定state,或者为假,定机构是关闭的,否则,为打开
		JSONArray childrenJson  = null;
		
		if( null != treeNodeJson.get("children") ){
			childrenJson =  JSONArray.fromObject( treeNodeJson.getString("children") );
			if( null != state){//如果要指定改变节点状态
				treeNodeJson.element("state", nodeState);
			}
			childrenJson.remove( deadChild );//移除要,去掉的子节点
			
			if( childrenJson.isEmpty() ){
				//已经没有子节点了
				treeNodeJson.remove("state");//移除状态
				treeNodeJson.remove("children");//移除子节点
			}else{
				treeNodeJson.element("children", childrenJson.toString());//更新子节点
			}
		}
		
		return treeNodeJson;
	}
	
	/**以树节点的形式,将一个list数据添加到一个JSONArray中*
	 * * @param updates 更新内容
	 * @throws Exception 
	 * @updates state[很重要] :  它决定node的状态(1.打开的;2.关闭的;3.叶子(默认))
	 * @updates id[很重要] : 决定前台取id时候的数据 与 数据的属性对应,如user.id,写作 id:id.
	 * @updates text[必填] : 决定前台取text时的数据 与数据对应性(同上),如user.name,写作 text:name 
	 * @updates children[重要] : 决定子节点数据,一般与state一起使用(一般情况下打开的state,
	 * 必需要;关闭的可要可不要,叶子绝对不要),他与state同时存在,与以上情况又矛盾时候,决定在state
	 * @updates icon[可选] : 前台显示的图标样式,无则默认前台(但是前台未定义也会设置成默认的)
	 * @updates attr[可选] : 前台取attributes的值,附加其他信息*/
	@SuppressWarnings("unchecked")
	public static JSONArray jsonArray_addTreeNode(JSONArray jsonArr ,Collection data,JSONObject updates) throws Exception{

		jsonArr =  null==jsonArr ? new JSONArray() : jsonArr;//初始化
		
		for (Object object : data) {
			JSONObject dataJson = JSONObject.fromObject( object );
			jsonArr.add( upgradeJSONObj2TreeJSONObj(dataJson, updates) );
		}
		
		return jsonArr;
	}
	
	/**将JSONObject升级成treeJSONObject*
	 * @param updates 更新内容
	 * @updates state[很重要] :  它决定node的状态(1.打开的;2.关闭的;3.叶子(默认))
	 * @updates id[很重要] : 决定前台取id时候的数据 与 数据的属性对应,如user.id,写作 id:id.
	 * @updates text[必填] : 决定前台取text时的数据 与数据对应性(同上),如user.name,写作 text:name 
	 * @updates children[重要] : 决定子节点数据,一般与state一起使用(一般情况下打开的state,
	 * 必需要;关闭的可要可不要,叶子绝对不要),他与state同时存在,与以上情况又矛盾时候,决定在state
	 * @updates icon[可选] : 前台显示的图标样式,无则默认前台(但是前台未定义也会设置成默认的)
	 * @updates attr[可选] : 前台取attributes的值,附加其他信息
	 * */
	public static JSONObject upgradeJSONObj2TreeJSONObj(JSONObject data 
			,JSONObject updates )throws Exception{
		
		if( null == data || data.isEmpty()
			    || null == updates || updates.isEmpty()	){
			System.out.println( "JsonTreeUtil.upgradeJSONObj2TreeJSONObj 传入参数为空"  );
			throw new NullPointerException("JsonTreeUtil.upgradeJSONObj2TreeJSONObj参数为空");
		}
		
		JSONObject result =  new JSONObject();
		
		//节点状态
		if( null != updates.get("state") ){
			switch ( updates.getInt("state") ) {
			case 1:
				result.accumulate("state", "open");
				break;
			case 2:
				result.accumulate("state", "closed");
				break;
			}
		}
		if( null != updates.get("children") ){
			//子节点
			result.accumulate("children", updates.getString("children") );
		}
		
		//id
		if( null != updates.get("id") ){
			String idKey = updates.getString("id");
			if( null == data.getString( idKey ) ){
				//data中不存在该数据
				System.out.println("JsonTreeUtil.upgradeJSONObj2TreeJSONObj中,参数不匹配,data中不存在updates更新的id");
				throw new NullPointerException("数据中不存在指定id");
			}
			result.accumulate("id", data.getString( idKey ) );
		}
		
		//text
		if( null != updates.get("text") ){
			String textKey = updates.getString("text");
			if( null == data.getString( textKey ) ){
				//data中不存在该数据
				System.out.println("JsonTreeUtil.upgradeJSONObj2TreeJSONObj中,参数不匹配,data中不存在updates更新的text");
				throw new NullPointerException("数据中不存在指定text");
			}
			result.accumulate("text", data.getString( textKey ) );
		}else{
			throw new NullPointerException("updates未指定显示信息text");
		}
		
		//icon 图标
		if( null != updates.get("icon") ){
			result.accumulate("iconCls", updates.getString("icon") );
		}
		
		//attr 附加属性
		if( null != updates.get("attr") ){
			result.accumulate("attributes", updates.getString("attr") );
		}
		
		return result;
	}

}