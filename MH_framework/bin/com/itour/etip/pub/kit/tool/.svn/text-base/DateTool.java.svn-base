package com.itour.etip.pub.kit.tool;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.log.LogUtil;

/**
 * 公共日期类
 * @author yangcan
 *
 */
public class DateTool {

	private DateTool() {
	}

	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	public static String getDate() {
		return getDateTime("yyyy-MM-dd");
	}

	public static String getYM() {
		return getDateTime("yyyy-MM");
	}

	public static String getDateTime() {
		return getDateTime("yyyy-MM-dd HH:mm:ss");
	}

	//获得当前月的上一月
	public static String getLastMonth(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		Date date = df.parse(str);
		calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);   
        return df.format(calendar.getTime());
	}
    //	获得当前月的前两个月
	public static String getLastMonth1(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(str));   
        calendar.add(Calendar.MONTH,-2);   
        return df.format(calendar.getTime());
	}
	 //	获得当前月的下一个月
	public static String getLastMonth2(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(str));   
        calendar.add(Calendar.MONTH,+1);   
        return df.format(calendar.getTime());
	}
	
	// 获得当前日期前一天
	public static String getPreDate() {
		Date cur = Calendar.getInstance().getTime();
		Date pre = new Date(cur.getTime() - 24 * 60 * 60 * 1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(pre);
	}
	/**
	 * 获得当前时间的前一天
	 * @param curr
	 * @return
	 */
	public static Date getPreDate(Date curr) {
		return new Date(curr.getTime() - 24 * 60 * 60 * 1000);
	}
	//获得后一天
	public static String getNextDate(String datestr, String pattern) {
		Date cur = parse(datestr,pattern);
		Date next = new Date(cur.getTime() + 24 * 60 * 60 * 1000);
		return format(next,pattern);
	}
	//获得后15天
	public static String getNext15Date(String datestr, String pattern) {
		Date cur = parse(datestr,pattern);
		Date next = new Date(cur.getTime() + 24 * 60 * 60 * 1000 * 15);
		return format(next,pattern);
	}
	/**
	 * 获得当前时间的后一天
	 * @return
	 */
	public static Date getNextDate(Date curr) {
		return new Date(curr.getTime() + 24 * 60 * 60 * 1000);
	}
	// 获得当前月的第一天
	public static String getFirstDayOfMonth() {
		Calendar c = Calendar.getInstance();
		Calendar calfirst = Calendar.getInstance();
		int now = c.get(c.DAY_OF_MONTH);
		calfirst.add(calfirst.DATE, 1 - now);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(calfirst.getTime());
	}
	/**
	 * 获得月的第一天
	 */
	public static String getFirstDayOfMonth(String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date,null));
        c.set(c.DATE, 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(c.getTime());
	}
	/**
	 * 获得月的最后一天
	 */
	public static String getLastDayOfMonth(String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date,null));
        c.add(c.MONTH, 1);
        c.set(c.DATE, 1);
        c.add(c.DATE, -1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(c.getTime());
	}

	public static String getDateTime(String pattern) {
		Date datetime = Calendar.getInstance().getTime();
		return getDateTime(datetime, pattern);
	}

	public static String getDateTime(Date date, String pattern) {
		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";
		//如果date==null,也会抛错误。
		if(date==null){
			LogUtil.warn("CONSOLE","DateTool.getDateTime Error");
			date = new Date();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(1);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(2) + 1;
	}

	public static int getCurrentDay() {
		return Calendar.getInstance().get(5);
	}

	public static Date addDays(int days) {
		return add(getNow(), days, 5);
	}

	public static Date addDays(Date date, int days) {
		return add(date, days, 5);
	}

	public static Date addMonths(int months) {
		return add(getNow(), months, 2);
	}

	public static Date addMonths(Date date, int months) {
		return add(date, months, 2);
	}

	// 2007-11 to 2007
	public static int getYear(String date) {
		String[] str = date.split("-");
		return Integer.parseInt(str[0]);
	}

	// 2007-11 to 11
	public static String getMonth(String date) {
		String[] str = date.split("-");
		return str[1];
	}

	// 2007-11 to 2007-11-30
	public static String getDay(String date) {
		if (date == null || date.equals("")) {
			return null;
		}
		try {
			String[] str = date.split("-");
			int month = Integer.parseInt(str[1]);
			if (month == 2) {
				return "-28";
			} else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				return "-31";
			} else {
				return "-30";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 2007-01-01 to 【>=2007-01-01 00:00:00 and <=2007-01-01 23:59:59】
	public static String getDayAll(String date, String flag) {
		if (flag == null || flag.equals(""))
			return null;

		try {
			if (flag.equals("start")) {
				return date + " 00:00:00";
			} else if (flag.equals("end")) {
				return date + " 23:59:59";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取前一年
	 * 
	 * @param curYear
	 * @return
	 */
	public static String getPreYear(String curYear) {
		int curY = Integer.parseInt(curYear);
		int preY = curY - 1;
		return preY + "";
	}

	private static Date add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	public static int diffMinutes(String one,String two){
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			  long oneT= inputFormat.parse(one).getTime(); 
			  long twoT= inputFormat.parse(two).getTime(); 

			  long ss=(oneT-twoT)/(1000); //共计秒数
			  
			  int MM = (int)ss/60;   //共计分钟数
			 // int hh=(int)ss/3600;  //共计小时数
			  //int dd=(int)hh/24;   //共计天数
			  return MM;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static double diffHours(Date one, Date two) {
		try {
			return ((((one.getTime() - two.getTime())/1000)/60)/60);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static long diffDays(Date one, Date two) {
		try {
			return (one.getTime() - two.getTime()) / 0x5265c00L;
		} catch (Exception e) {
			return -1;
		}
	}

	public static int diffMonths(Date one, Date two) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(one);
		int yearOne = calendar.get(1);
		int monthOne = calendar.get(2);
		calendar.setTime(two);
		int yearTwo = calendar.get(1);
		int monthTwo = calendar.get(2);
		return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
	}

	public static Date parse(String datestr, String pattern) {
		if (datestr == null || "".equals(datestr))
			return null;
		Date date = null;
		String p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(p);
			date = dateFormat.parse(datestr);
		} catch (ParseException parseexception) {
		}
		return date;
	}

	public static String format(Date date, String pattern) {
		String p;
		p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(p);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getMonthLastDay() {
		return getMonthLastDay(getNow());
	}

	public static Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(1), calendar.get(2) + 1, 1);
		calendar.add(5, -1);
		return calendar.getTime();
	}
	//add by txc for ext,未完成，适用于记录内所有日期字段统一格式
	public static void setDateFormatForData(Object object,String dateFormat){
		Field[] fields = object.getClass().getFields();
		for(int i=0;i<fields.length;i++){
			Field field = fields[i];
			Object o = field.getType();
			if(o instanceof java.util.Date){
				
			}
		}
	}
	
	//add by txc 
	public static JSONObject clearNullValue(JSONObject jobj)throws ETIPException{
			Object[] keys = jobj.keySet().toArray();
			for(int i=0;i<keys.length;i++){
				JSONObject jsonObj = jobj.getJSONObject(keys[i].toString());
				if(jsonObj.isNullObject()){
					jobj.remove(jsonObj);
				}
			}
			return jobj;
	}
	//add by txc
	public static String getJSONString(Object object,String dateFormat) throws ETIPException{  
        String jsonString = null;  
        //日期值处理器  
        JsonConfig jsonConfig = new JsonConfig();  
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat));  
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat)); 
        if(object != null){  
            if(object instanceof Collection || object instanceof Object[]){  
                jsonString = JSONArray.fromObject(object, jsonConfig).toString();  
            }else{  
                jsonString = JSONObject.fromObject(object, jsonConfig).toString();  
                
            }  
        }  
        return jsonString == null ? "{}" : jsonString;  
    }  
	
	//add by txc
	public static JSONObject getJSONObj(Object object,String dateFormat)throws ETIPException{
		  
        JSONObject jsonObj = null;  
        //日期值处理器  
        JsonConfig jsonConfig = new JsonConfig();  
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat));  
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat)); 
        if(object != null){  
           
        	jsonObj = JSONObject.fromObject(object, jsonConfig);  
            
        }  
        return jsonObj == null ? null : jsonObj;  
    
	}
	//add by txc
	public static JSONArray getJSONArray(Object object,String dateFormat)throws ETIPException{
		JSONArray jsonArray = null;
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat)); 
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat));
			if(object != null){
				if(object instanceof Collection || object instanceof Object[]){
					jsonArray = JSONArray.fromObject(object, jsonConfig);
				}
			}else{
				//System.out.println("这不是一个列表或数组");
				return null;
			}
			
			return jsonArray;
	}
	//add by txc
	public static JSONObject getGridJSON(List list,int totalRows,String dateFormat)throws ETIPException{
		JSONArray array = null;
		if(dateFormat != null && dateFormat.trim().length()>0){
			array = getJSONArray(list, dateFormat);
		}else{
			array = JSONArray.fromObject(list);
		}
		JSONObject obj = new JSONObject();
		obj.put("results", totalRows);
		obj.put("items", array);
		return obj;
	}
	

	public static void main(String args[]) {
		double diffHours = diffHours(getNow(), parse("20090929081600","yyyyMMddHHmmss"));
		System.out.println(getNow());
		System.out.println(parse("20090929081600","yyyyMMddHHmmss"));
		System.out.println(diffHours);
//		String test = "2003-1-31";
//		try {
//			Date date = parse(test, "");
//			System.out
//					.println("\u5F97\u5230\u5F53\u524D\u65E5\u671F \uFF0D getDate():"
//							+ getDate());
//			System.out
//					.println("\u5F97\u5230\u5F53\u524D\u65E5\u671F\u65F6\u95F4 \uFF0D getDateTime():"
//							+ getDateTime());
//			System.out
//					.println("\u5F97\u5230\u5F53\u524D\u5E74\u4EFD \uFF0D getCurrentYear():"
//							+ getCurrentYear());
//			System.out
//					.println("\u5F97\u5230\u5F53\u524D\u6708\u4EFD \uFF0D getCurrentMonth():"
//							+ getCurrentMonth());
//			System.out
//					.println("\u5F97\u5230\u5F53\u524D\u65E5\u5B50 \uFF0D getCurrentDay():"
//							+ getCurrentDay());
//			System.out.println("\u89E3\u6790 \uFF0D parse(" + test + "):"
//					+ getDateTime(date, "yyyy-MM-dd"));
//			System.out.println("\u81EA\u589E\u6708\u4EFD \uFF0D addMonths(3):"
//					+ getDateTime(addMonths(3), "yyyy-MM-dd"));
//			System.out.println("\u589E\u52A0\u6708\u4EFD \uFF0D addMonths("
//					+ test + ",3):"
//					+ getDateTime(addMonths(date, 3), "yyyy-MM-dd"));
//			System.out.println("\u589E\u52A0\u65E5\u671F \uFF0D addDays("
//					+ test + ",3):"
//					+ getDateTime(addDays(date, 3), "yyyy-MM-dd"));
//			System.out.println("\u81EA\u589E\u65E5\u671F \uFF0D addDays(3):"
//					+ getDateTime(addDays(3), "yyyy-MM-dd"));
//			System.out.println("\u6BD4\u8F83\u65E5\u671F \uFF0D diffDays():"
//					+ diffDays(getNow(), date));
//			System.out.println("\u6BD4\u8F83\u6708\u4EFD \uFF0D diffMonths():"
//					+ diffMonths(getNow(), date));
//			System.out.println("\u5F97\u5230" + test
//					+ "\u6240\u5728\u6708\u4EFD\u7684\u6700\u540E\u4E00\u5929:"
//					+ getDateTime(getMonthLastDay(date), "yyyy-MM-dd"));
//			System.out.println(getPreDate());
//
//		} catch (Exception e) {
//			System.out.println(e.getStackTrace());
//		}
	}
	/**
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static String[] dringDate(String begin, String end, String pattern) {
		String[] dringDate = new String[0];
		long days = diffDays(parse(end,pattern),parse(begin,pattern));
		if(days >= 0){
			dringDate = new String[Integer.parseInt(Long.toString(days)) + 1];
			dringDate[0] = begin;
			String t = begin;
			for(int i=1;i<=days;i++){
				t = getNextDate(t,pattern);
				dringDate[i] = t;
			}
		}
		return dringDate;
	}
	
	/**
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isDring(Date begin, Date end, Date curr) {
		boolean inBetween = false;
		try{
			if( curr.getTime()>=begin.getTime() && curr.getTime()<=end.getTime())inBetween = true;
		}catch(Exception e){}
		return inBetween;
	}
	
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final int MAXYEAR = 2030; // 下拉列表年度选项的最大值

	public static final int MINYEAR = 1980; // 下拉列表年度选项的最小值
}
