package com.itour.etip.pub.kit.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JSON 日期处理
 * 
 * @author wangsw
 * @version 1.00
 * @date 2010-9-1
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";   
    private DateFormat dateFormat;   

    /**  
     * 构造方法
     *  
     * @param datePattern 日期格式  
     */  
    public DateJsonValueProcessor(String datePattern) {   
        if( null == datePattern )
            dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);  
        else
            dateFormat = new SimpleDateFormat(datePattern); 
    }
    
    public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
    	if(arg1 !=null){
    		return dateFormat.format((Date) arg1);  
    	}else{
    		return "";
    	}
    }

	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return "";
	}

}
