package com.itour.etip.pub.kit.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

/**
 * JSON 格式转换工具
 * 
 * @author wangsw
 * @version 1.00
 * @date 2010-9-1
 */
@SuppressWarnings("unchecked")
public class JsonUtil {

    /**
     * JSON字符串 转换成 一个指定的数据对象
     * 
     * @param json 对象字符串格式
     * @param cla 指定数据对象类型
     * 
     * @return 
     */
	public static Object getObjectWithJson(String json,Class cla){
        JSONObject jsonObject = JSONObject.fromObject( json );
        //设置Morpher，处理日期类型字符串转换问题
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
        return JSONObject.toBean(jsonObject,cla);
    }
    
    /**
     * JSON字符串 表达式中获取一个map，改map支持嵌套功能
     * 
     * @param json 对象字符串格式
     * 
     * @return 
     */
    public static Map getMapWithJson(String json){
        JSONObject jsonObject = JSONObject.fromObject( json );  
        Iterator  keyIter = jsonObject.keys();
        String key;
        Map valueMap = new HashMap();

        while( keyIter.hasNext() ) {
            key = (String)keyIter.next();
            valueMap.put(key, jsonObject.get(key));
        }
        return valueMap;
    }
    
    /**
     * JSON字符串 转换成 多个指定的数据对象
     * 以集合形式返回
     * 
     * @param json 对象字符串格式
     * @param cla 指定数据对象类型
     * 
     * @return
     */
    public static List getListJson(String json, Class cla){
        JSONArray jsonArray = JSONArray.fromObject(json);
        JSONObject jsonObject;
        Object pojoValue;
        
        List list = new ArrayList();
        for ( int i = 0 ; i<jsonArray.size(); i++){
            jsonObject = jsonArray.getJSONObject(i);
            pojoValue = JSONObject.toBean(jsonObject,cla);
            list.add(pojoValue);
        }
        return list;
    }
    
    /**
     * 将 java对象 转换成 json字符串
     * 
     * @param object  java Bean
     * 
     * @return
     */
    public static String getJsonWitchObject(Object object){
        JSONObject json = JSONObject.fromObject(object,configJson("yyyy-MM-dd HH:mm:ss"));
        return json.toString();
    }
    
	/**
	 * 将日期类型以指定的格式转换成json串
	 * 
	 * @param datePattern
	 *            String 要转换成的格式 如“yyyy-MM-dd HH:mm:ss”
	 * @return
	 */
	public static JsonConfig configJson(String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {""});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(datePattern));
		jsonConfig.registerJsonValueProcessor(Integer.class,new NumberJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Double.class,new NumberJsonValueProcessor());
		return jsonConfig;
	}
    
}