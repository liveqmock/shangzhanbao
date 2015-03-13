package com.itour.etip.common.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: 酒店产品工具类</p>
 * <p>Description: 酒店产品工具类</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-06-05
 */
public class ProductTool {

	public ProductTool() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 将日期字符串转化为日期对象
	 * @author zoumingming by 2009-06-05
	 * @param strDate String 日期字符串
	 * @param format String 格式化方案（yyyyMMddHHmmssSSS）
	 * @return String 格式化的日期对象
	 */
	public static Date stringToDate(String strDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	/**
	 * 将日期转化为字符串
	 * @author zoumingming by 2009-06-05
	 * @param date Date 要格式化的日期对象
	 * @param format String 格式化方案（yyyyMMddHHmmssSSS）
	 * @return String 格式化后的日期字符串
	 */
	public static String dateToString(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**  
	 * 常用的格式化日期
	 * @author zoumingming by 2009-06-05
	 * @param date Date 要格式化的日期对象
	 * @return String 格式化后的日期字符串
	 */
	public String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}
	
	/**
	 * 返回年份
	 * @author zoumingming by 2009-06-05
	 * @param date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * 返回月份
	 * @author zoumingming by 2009-06-05
	 * @param date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 返回日份
	 * @author zoumingming by 2009-06-05
	 * @param date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	/**   
	 * 返回小时
	 * @author zoumingming by 2009-06-05
	 * @param date 日期   
	 * @return 返回小时   
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**   
	 * 返回分钟
	 * @author zoumingming by 2009-06-05
	 * @param date 日期   
	 * @return 返回分钟   
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**   
	 * 返回秒钟
	 * @author zoumingming by 2009-06-05
	 * @param date 日期   
	 * @return 返回秒钟   
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}
	
	/**   
	 * 返回周几(按照周日为每个星期的第1天来计算)
	 * @author zoumingming by 2009-06-05
	 * @param date 日期   
	 * @return 返回周几(按照周日为1来计算)
	 */
	public static int getWEEK(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 返回当年中的第几周
	 * @author zoumingming by 2009-06-05
	 * @param date 日期
	 * @return 返回当年中的第几周
	 */
	public static int getWEEK_OF_YEAR(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
     * 获得一个日期所在的周的星期X的日期，如要找出2009年6月4日所在周的星期一是几号
     * @author zoumingming by 2009-06-05
     * @param date 日期
     * @param num 要确定的是周几（0表示周日,1表示周一,2表示周二...）
     * @return
     */
    public static Date getDAY_OF_WEEK(Date date, String num) {
    	Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (num.equals("7")){ // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	}else if (num.equals("1")){ // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		}else if (num.equals("2")){ // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		}else if (num.equals("3")){ // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    	}else if (num.equals("4")){ // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    	}else if (num.equals("5")){ // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    	}else if (num.equals("6")){ // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    	}
		return c.getTime();
	}
    
    /**
     * 返回"日期范围"内指定"星期"的"日期列表"
     * @author zoumingming by 2009-06-05
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @param weekdays 星期列表{"7","1","2","3","4","5","6"}
     * @return "日期范围"内指定"星期"的"日期列表"
     */
    public static List<Date> getDayList(Date beginDate, Date endDate ,String[] weekdays) {
    	List<Date> dateList=new ArrayList<Date>();
    	if(weekdays==null){
    		/**
    		 * 星期参数列表为空，则获取时间段所有日期列表
    		 */
    		dateList.add(beginDate);
    		int j=1;
	    	Date nextDate=null;
	    	while(true){
	    		int radix=j;
	    		Calendar calendar = Calendar.getInstance();
	    		calendar.setTime(beginDate);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + radix);// 让日期加7
				nextDate=calendar.getTime();
				/*如果获取到的日期大于结束日期则不加入返回列表*/
				if((nextDate.getTime()-endDate.getTime())>0){
					break;
				}else{
					dateList.add(nextDate);
					j++;
				}
	    	}
    	}else{
    		/**
        	 * 星期参数列表不为空，获取该月指定星期的所有日期
        	 */
        	for(int i=0;i<weekdays.length;i++){
        		/**
        		 * 开始获取是星期weekdays[i]的所有日期
        		 */
        		/*获取开始日期所在周的星期weekdays[i]日期*/
    	    	Date firstDate=getDAY_OF_WEEK(beginDate, weekdays[i]);
    	    	/*如果第一天小于开始日期则不加入返回列表*/
    	    	if((firstDate.getTime()-beginDate.getTime())>=0){
    	    		dateList.add(firstDate);
    	    	}
    	    	int j=1;
    	    	Date nextDate=null;
    	    	while(true){
    	    		/**
    	    		 * 获取下周的星期weekdays[i]
    	    		 */
    	    		int radix=7*j;
    	    		Calendar calendar = Calendar.getInstance();
    	    		calendar.setTime(firstDate);
    				calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + radix);// 让日期加7
    				nextDate=calendar.getTime();
    				/*如果获取到的日期大于结束日期则不加入返回列表*/
    				if((nextDate.getTime()-endDate.getTime())>0){
    					break;
    				}else{
    					dateList.add(nextDate);
    					j++;
    				}
    	    	}
        	}
    	}
    	/*排序*/
    	Collections.sort(dateList);
    	return dateList;
    }
    
    /**
     * 返回两个日期的相隔天数
     * @param firstDate 日期1
     * @param secondDate 日期2
     * @return 两个日期的相隔天数
     */
    public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay = (int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));
		return nDay;
	}
    
    /**
     * 合并相邻日期为二纬日期数组
     * @param dateList 日期集合
     * @return
     */
    public static Date[][] unite(List<Date> dateList){
    	Date[][] dateList_unite=new Date[dateList.size()][2];
    	
    	/*最终返回到数组中的开始日期*/
		Date beginDateInit=null;
		/*最终返回到数组中的结束日期*/
		Date endDateInit=null;
		/*日期比较时临时使用的开始日期*/
		Date beginDate=null;
		/*日期比较时临时使用的结束日期*/
		Date endDate=null;
		
		int begin=0;
		for(int i=0;i<dateList.size();i++){
	    	/*初始化最终返回到数组中的开始日期*/
	    	beginDateInit=dateList.get(begin);
	    	endDateInit=null;
	    	/*初始化日期比较时临时使用的开始日期*/
	    	beginDate=dateList.get(begin);
			for(int j=begin+1;j<dateList.size();j++){
				endDate=dateList.get(j);
				int nDays=nDaysBetweenTwoDate(beginDate,endDate);
				/*重置日期比较时临时使用的开始日期*/
				beginDate=endDate;
				endDateInit=endDate;
				if(nDays>1){
					endDateInit=dateList.get(j-1);
					/*重置下个轮循开始索引*/
					begin=j;
					break;
				}
			}
			if(i>0 && dateList_unite[i-1][0]==beginDateInit){
				break;
			}
			if(beginDateInit!=null){
				if(endDateInit==null){
					endDateInit=beginDateInit;
				}
			}
			dateList_unite[i][0]=beginDateInit;
			dateList_unite[i][1]=endDateInit;
		}
    	
    	return dateList_unite;
    }
    
    /**
     * 返回"日期范围"内指定"星期"的"日期列表(合并相邻日期为二纬日期数组)"
     * @author zoumingming by 2009-06-05
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @param weekdays 星期列表{"7","1","2","3","4","5","6"}
     * @return "日期范围"内指定"星期"的"日期列表"
     */
    public static Date[][] getDayList_Unite(Date beginDate, Date endDate ,String[] weekdays) {
    	return ProductTool.unite(ProductTool.getDayList(beginDate, endDate, weekdays));
    }
    
    /**
     * 日期加减
     * @param date 原日期
     * @param num 加减幅度
     * @return 加减后的日期
     */
    public static Date dateOperation(Date date ,int num){
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + num);
		return calendar.getTime();
    }
	
}
