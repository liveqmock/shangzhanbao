package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateFormatUtil{
	private static final DateFormatUtil util = new DateFormatUtil();
	
	private DateFormatUtil(){super();}
	
	public static DateFormatUtil getInstance(){
		return util;
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
		return days;
	}
	
	/**
	 * @Title: getDateList
	 * @Description: TODO(获得两个时间间隔之间 的 时间精确度的List)
	 * @param @param startDate 起始时间， endDate 结束时间 ，interval 时间间隔 单位 秒
	 *        "yyyy-MM-dd"
	 * @return List<String> 时间分辨率的list （如 两日期之间 以15分钟为一个时间间隔，拆分成时间段）
	 */
	public static  List<String> getDate(String startDate, String endDate,
			String startTime, String endTime, int interval) {

		startDate = startDate.substring(0, 10);
		endDate = endDate.substring(0, 10);
		int days = countDays(startDate, endDate);

		int seconds = days * 24 * 60 * 60;

		String dateTem = startDate + " " + startTime;

		List<String> list = new ArrayList<String>();

		// StringBuffer sb = new StringBuffer() ;

		for (int i = 0; i < seconds;) {

			list.add(dateTem);
			dateTem = getDateAdd(dateTem, interval);
			i = i + interval;
		}

		return list;

	}
	/**
	 * @Title: getDateStr
	 * @Description: TODO(获得两个时间间隔之间 的 时间精确度的String)
	 * @param @param startDate 起始时间， endDate 结束时间 ，interval 时间间隔 单位 秒
	 *        "yyyy-MM-dd"
	 * @return String 时间分辨率的str （'2012-01-01' ,'','','','01:00:00'......）
	 */

	public static String getDateStr(String start, String end, String startTime,
			String endTime, int interval) {

		StringBuffer sb = new StringBuffer();
		List<String> list = getDate(start, end, startTime, endTime,
				interval);
		String timeTem = "";
		for (int i = 0; i < list.size(); i++) {
			timeTem = list.get(i);
			if (timeTem.substring(14, timeTem.length()).equals("00:00")) {
				if (timeTem.substring(11, 13).equals("00")) {
					sb.append("'" + timeTem.substring(0, 10) + "',");
				} else {
					sb.append("'" + timeTem.substring(11, 13) + "',");
				}
			} else {

				sb.append("'" + timeTem + "',");
			}

		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	


	
	
	
	/**
	 * @Title: getDateList
	 * @Description: TODO(获得两个时间间隔之间 的 时间精确度的List)
	 * @param @param startDate 起始时间， endDate 结束时间 ，interval 时间间隔 单位 秒
	 *        "yyyy-MM-dd"
	 * @return List<String> 时间分辨率的list （如 两日期之间 以15分钟为一个时间间隔，拆分成时间段）
	 */
	public static List<String> getDateList(String startDate, String endDate,
			String startTime, String endTime, int interval) {

		startDate = startDate.substring(0, 10);
		endDate = endDate.substring(0, 10);
		int days = countDays(startDate, endDate);

		int seconds = days * 24 * 60 * 60;

		String dateTem = startDate + " " + startTime;

		List<String> list = new ArrayList<String>();

		// StringBuffer sb = new StringBuffer() ;

		for (int i = 0; i < seconds;) {

			list.add(dateTem);
			dateTem = getDateAdd(dateTem, interval);
			i = i + interval;
		}

		return list;

	}
	
	
	/**
	 * @Title: countDays
	 * @Description: TODO(两日期间相差天数)
	 * @param @param begin 起始时间， end 结束时间
	 * @return int
	 */
	public static int countDays(String begin, String end) {
		int days = 0;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();

		try {
			c_b.setTime(df.parse(begin));
			c_e.setTime(df.parse(end));

			while (c_b.before(c_e)) {
				days++;
				c_b.add(Calendar.DAY_OF_YEAR, 1);
			}

		} catch (ParseException pe) {
		}

		return days + 1;
	}
	
	/**
	 * @Title: getDateAdd
	 * @Description: TODO(获得传入时间后XX分钟后的时间)
	 * @param @param dateInput 传入时间， seconds 时间间隔 单位秒
	 * @return String XX分钟后的时间
	 */
	public static String getDateAdd(String dateInput, int seconds) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		Calendar calendar = Calendar.getInstance();

		Date d = new Date();
		// getTime()方法是取得当前的日期，其返回值是一个java.util.Date类的对象
		try {
			calendar.setTime(df.parse(dateInput));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// calendar.add(Calendar.HOUR_OF_DAY, 24) ; //小时
		calendar.add(Calendar.SECOND, seconds); // 分钟

		d = calendar.getTime();
		// 投票的有效期30天
		String date = df.format(d);
		return date;
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
	 * 毫秒数 转换为 字符串日期类型
	 */
	public String millisecondConversionDate(long millisecond, String dateType){
		Date date = new Date(millisecond);
		String dateString = new DateFormatUtil().dateConversionString(date, dateType);
		return dateString;
	}
	
	/**
	 * 获取当前日期的若干年后的日期
	 */
	public Date aFewYearsAfter(Date date, int repeatInterval){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			cal.setTime(date);
			cal.add(Calendar.YEAR, repeatInterval);
		}
		return cal.getTime();
	}
	
	/**
	 * 取当前日期的某个月后的日期
	 */
	public Date aFewMonthsAfter(Date date, int repeatInterval){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			cal.setTime(date);
			cal.add(Calendar.MONTH, repeatInterval);
		}
		return cal.getTime();
	}
	
	/**
	 * 返回当前日期 某几天后的日期
	 * @param date 日期时间
	 * @param repeatInterval 时间间隔
	 */
	public static Date aFewDaysAfter(Date date, int repeatInterval){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			cal.setTime(date);
			cal.add(Calendar.DATE, repeatInterval);
		}
		return cal.getTime();
	}
	
	/**
	 * 判断当前日期是否是闰年366天
	 */
	public boolean isLeapYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		boolean leapYear = ((GregorianCalendar)cal).isLeapYear(cal.get(Calendar.YEAR));
		return leapYear;
	}
	
	/**
	 * 获取某个月里有多少天
	 */
	public static int getDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
        int days[]={31,31,28,31,30,31,30,31,31,30,31,30,31}; 
        if(((GregorianCalendar)cal).isLeapYear(year)){
        	days[2]=29;
        }
        return days[month]; 
	}
	
	/**
	 * 返回两个日期之间相差多少天
	 */
	public int getDaysOfDiscrepant(Date date, Date anotherDate){
		int days = 0;
		long daysMillisecond = date.getTime() - anotherDate.getTime();
		days = Math.abs((int)(daysMillisecond / 24 / 60 / 60 / 1000));
		return days;
	}
	
	/**
	 * 返回两个日期之间相差多少个月
	 */
	public int getMonthOfDiscrepant(Date date, Date anotherDate){
		int month = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Calendar anotherCal = Calendar.getInstance();
		anotherCal.setTime(anotherDate);
		int cal_year = cal.get(Calendar.YEAR);
		int another_year = anotherCal.get(Calendar.YEAR);
		int cal_month = cal.get(Calendar.MONTH);
		int another_month = anotherCal.get(Calendar.MONTH);
		month = Math.abs((cal_year-another_year)*12 + (cal_month-another_month));
		return month;
	}
	
	/**
	 * 返回两个日期之间相差多少年 
	 */
	public int getYearOfDiscrepant(Date date, Date anotherDate){
		int month = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Calendar anotherCal = Calendar.getInstance();
		anotherCal.setTime(anotherDate);
		int cal_year = cal.get(Calendar.YEAR);
		int another_year = anotherCal.get(Calendar.YEAR);
		month = Math.abs(cal_year-another_year);
		return month;
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
	     c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
	    List<String> list = new ArrayList<String>();
	     while(c_begin.before(c_end)){
	    	 list.add(new java.sql.Date(c_begin.getTime().getTime()).toString());
	      if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	          count++;
	      }
	      c_begin.add(Calendar.DAY_OF_YEAR, 1);
	     }
		return list;
	}
	/**
	 * 获取一天24小时
	 * @param currenttime 
	 * @return
	 */
	public static List<String> getdayHour(String currenttime){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			String str = currenttime+" "+(i+1)+":00:00";
			list.add(str);
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