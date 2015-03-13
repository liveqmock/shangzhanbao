package com.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;



public class Snippet {

	public static void main(String[] args){
	
		     Calendar beginTime = new GregorianCalendar();
		     Calendar endTime = new GregorianCalendar();
		     Calendar calendar=Calendar.getInstance();//创建实例
		     calendar.setTime(new Date());	      
		     calendar.add(Calendar.MONTH,-3);//三个月前的日期
		     Date date=calendar.getTime();//三个月后的日期（Date类型）

			
			SimpleDateFormat dff2 = new SimpleDateFormat("yyyy");
			SimpleDateFormat dff3 = new SimpleDateFormat("MM");
			SimpleDateFormat dff4 = new SimpleDateFormat("dd");
			
			String endyear = dff2.format(new Date());
			String endmonth = dff3.format(new Date());
			String endday = dff4.format(new Date());
		
			//三个月
			String beginyear3=dff2.format(date);
			String beginmonth3=dff3.format(date);
			String beginday3=dff4.format(date);

		  
			
			beginTime.set(Integer.parseInt(beginyear3),Integer.parseInt(beginmonth3)-1,Integer.parseInt(beginday3));   //三个月个月
			endTime.set(Integer.parseInt(endyear),Integer.parseInt(endmonth)-1,Integer.parseInt(endday)); 
	     List<String> days=new ArrayList<String>();
	     while(beginTime.before(endTime)){
	     days.add(new java.sql.Date(beginTime.getTime().getTime()).toString());
	     if(beginTime.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	      }
	      beginTime.add(Calendar.DAY_OF_YEAR, 1);
	     
	     }
	     	System.out.println(days);
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
		 * 返回两个日期之间相差多少天
		 */
		public static int getDaysOfDiscrepant(Date date, Date anotherDate){
			int days = 0;
			long daysMillisecond = date.getTime() - anotherDate.getTime();
			days = Math.abs((int)(daysMillisecond / 24 / 60 / 60 / 1000));
			return days;
		}
	
}

