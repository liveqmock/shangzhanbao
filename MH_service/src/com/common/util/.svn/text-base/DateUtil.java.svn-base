/**
 * com.gomai.common.action
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   1		 2013-9-24 		何大勇
 *
 * Copyright (c) 2013, gomai.
*/
package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 何大勇
 * @date 2013-9-24
 */
public class DateUtil {
	public static Date getThisWeekStart(){
//		Calendar calendar = Calendar.getInstance();
//		calendar.get(Calendar.DAY_OF_WEEK);
//		calendar.roll(Calendar.DAY_OF_WEEK,calendar.get(Calendar.DAY_OF_WEEK));
//		//时间起点从8点开始，而非零点，所以最后要减去8小时
//		return new Date(calendar.getTime().getTime()-calendar.getTime().getTime()%(1000*60*60*24)-1000*60*60*8);
		
		int changceDay;
		 Calendar cd = Calendar.getInstance();
		 // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		 int sunday = cd.get(Calendar.DAY_OF_WEEK);
		 if(sunday==1){
			 changceDay = -6;
		 }else{
			 int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
			 changceDay = 1 - dayOfWeek;
		 }
		 
		 GregorianCalendar currentDate = new GregorianCalendar();
		 currentDate.add(GregorianCalendar.DATE, changceDay);
		 Date monday = currentDate.getTime();
		 
		return monday;
		 

	}
	
	
	/**
	 * 
	* @Title: getEveryDayOfWeek 
	* @Description: 获取指定日期所在周的每一天
	* @param  date
	* @param @return    设定文件 
	* @return List<String>    返回类型 
	* @throws
	 */
	public static List<String> getEveryDayOfWeek(Date date) {
		List<String> days = new ArrayList<String>();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		int d = c1.get(Calendar.DAY_OF_WEEK);// SUNDAY：1，MONDAY：2，……SATURDAY：7
		if(d==1) {// 周日
			d = 7;
		} else {
			d --;
		}
		Long fTime = c1.getTimeInMillis() - d * 24 * 3600000;
	    Date fdate;  
		for(int i = 0; i < 7; i ++) {
			fdate = new Date();
	        fdate.setTime(fTime + ((i+1) * 24 * 3600000));  
			days.add(dateToStr(fdate, "yyyy-MM-dd"));
		}
//		for(String s:days) {
//			System.out.println(s);
//		}
		return days;
	}
	
	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date strToDate(String str, String dateFormat) {

		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {

		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(specifiedDay);
		} catch (ParseException e) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}
	

	/**
	 * 获取当前日期
	 * @return
	 */
	public static String currentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	
	
	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 */
	public static String dateToStr(Date date, String dateformat) {

		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		String str = format.format(date);
		return str;
	}
	
	/**
	 * 日期转换为字符串
	 * @param date 需要转换的日期
	 * @param dateType 转换的日期格式
	 */
	public String dateConversionString(Date date, String dateType){
		String newDate = "";
		if(date != null){
			SimpleDateFormat format = new SimpleDateFormat(dateType);
			newDate = format.format(date);
		}
			return newDate;
	}
	
	/**
	 * 字符串转日期
	 */
	public Date stringConversionDate(String str, String dateType){
		if(str != null && !"".equals(str)){
			SimpleDateFormat format = new SimpleDateFormat(dateType);
			try {
				return format.parse(str); 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return new Date();
	}
	
	/**
	 * 获得指定日期的n天前或后
	 * 
	 * num为正时：num天后 num为负时：num天前
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDay(String specifiedDay,
			String dateFormat, int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat(dateFormat).format(c.getTime());
		return dayAfter;
	}
	/**
	 * 获取char图日期
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static List<String> getTimeforChar(String startTime,String endTime) {
		int byear = Integer.valueOf(startTime.substring(0, startTime.indexOf("-")));
		int bmouth = Integer.valueOf(startTime.substring(startTime.indexOf("-")+1, startTime.lastIndexOf("-")));
		int bday = Integer.valueOf(startTime.substring(startTime.lastIndexOf("-")+1, startTime.length()));
		
		int tyear = Integer.valueOf(endTime.substring(0, endTime.indexOf("-")));
		int tmouth = Integer.valueOf(endTime.substring(endTime.indexOf("-")+1, endTime.lastIndexOf("-")));
		int tday = Integer.valueOf(endTime.substring(endTime.lastIndexOf("-")+1, endTime.length()));
		
		Calendar c_begin = new GregorianCalendar();
	     Calendar c_end = new GregorianCalendar();
	     c_begin.set(byear, bmouth-1, bday); //Calendar的月从0-11  所以2月 是1
	     c_end.set(tyear,tmouth-1,tday); //Calendar的月从0-11 所以3月 是2
	     int count = 1;
	     c_end.add(Calendar.DAY_OF_YEAR, 0);  //结束日期下滚一天是为了包含最后一天
	    List<String> list = new ArrayList<String>();
	     while(c_begin.before(c_end)){
	      if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	          count++;
	      }
	      c_begin.add(Calendar.DAY_OF_YEAR, 1);
	      list.add(new java.sql.Date(c_begin.getTime().getTime()).toString());
	     }
		return list;
	}
	public static List<String> getAllMonths(String start, String end){
        String splitSign="-";
        String regex="\\d{4}"+splitSign+"(([0][1-9])|([1][012]))"; //判断YYYY-MM时间格式的正则表达式
        /*if(!start.matches(regex) || !end.matches(regex)) return new String[0];*/
         
        List<String> list=new ArrayList<String>();
        if(start.compareTo(end)>0){
            //start大于end日期时，互换
            String temp=start;
            start=end;
            end=temp;
        }
         
        String temp=start; //从最小月份开始
        while(temp.compareTo(start)>=0 && temp.compareTo(end)<0){
            list.add(temp); //首先加上最小月份,接着计算下一个月份
            String[] arr=temp.split(splitSign);
            int year=Integer.valueOf(arr[0]);
            int month=Integer.valueOf(arr[1])+1;
            if(month>12){
                month=1;
                year++;
            }
            if(month<10){//补0操作
                temp=year+splitSign+"0"+month;
            }else{
                temp=year+splitSign+month;
            }
        }
         
       /* int size=list.size();
        String[] result=new String[size+1]; 
        for(int i=0;i<size;i++){
            result[i]=list.get(i);
        }
        result[size] = end;*/
        list.add(end);
        list.remove(0);
        return list;
    }
 public static Map<String,Object> getAllMonthMap(String start, String end){
     Map<String,Object> map = new HashMap<String, Object>();
     List<String> list  =getAllMonths(start, end);
     for (int i = 0; i < list.size(); i++) {
         map.put(list.get(i), 0);
    }
    return map;
 }
	
}
