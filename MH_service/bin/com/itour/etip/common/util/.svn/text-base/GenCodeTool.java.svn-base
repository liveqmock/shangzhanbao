package com.itour.etip.common.util;

import java.util.Date;
import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.pub.util.UuidUtil;

public class GenCodeTool {
	
	

	public synchronized static String getBigOrderCode() {
		
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		
		String sql = "select g.CODEVALUE from GENCODE g where g.codeType=1";
		
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		String date = DateTool.format(new Date(), "yyMMdd");
		if(list == null || list.size() == 0){
			String returnValue = date+CacheUtil.paraCache.getParaValue("BigOrder")+"000001";
			String id = UuidUtil.getUUIDfor32();
			String mySQL = "insert into GENCODE(id,codeType,codeValue) values('"+id+"',1,'000001')";
			jdbc.executeSQL(mySQL);
			return returnValue;
		}else{
			ETIPResultSet set = list.get(0);
			
			String codeValue = set.getString("CODEVALUE");
			
			Long num = Long.parseLong(codeValue);
			
			num = num + 1;
			
			String changdu = String.valueOf(num);
			if(changdu.length()<6){
				switch(changdu.length()){
				case 1:
					changdu = "00000"+changdu;
					break;
				case 2:
					changdu = "0000"+changdu;
					break;
				case 3:
					changdu = "000"+changdu;
					break;
				case 4:
					changdu = "00"+changdu;
					break;
				case 5:
					changdu = "0"+changdu;
					break;
				}
			}
			
			String newStr = date+CacheUtil.paraCache.getParaValue("BigOrder") + changdu;
			
			String newSql = "update GENCODE g set g.CODEVALUE='"+num+"' where g.codeType=1";
			
			jdbc.executeSQL(newSql);
			
			return newStr;
		}
		
		
	}

	
	public synchronized static String getHotelOrderCode() {
		
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		
		String sql = "select g.CODEVALUE from GENCODE g where g.codeType=3";
		
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		
		String date = DateTool.format(new Date(), "yyMMdd");
		if(list == null || list.size() == 0){
			String returnValue = date+CacheUtil.paraCache.getParaValue("HotelOrder")+"000001";
			String id = UuidUtil.getUUIDfor32();
			String mySQL = "insert into GENCODE(id,codeType,codeValue) values('"+id+"',3,'000001')";
			jdbc.executeSQL(mySQL);
			return returnValue;
		}else{
			ETIPResultSet set = list.get(0);
			
			String codeValue = set.getString("CODEVALUE");
			
			Long num = Long.parseLong(codeValue);
			
			num = num + 1;
			
			String changdu = String.valueOf(num);
			if(changdu.length()<6){
				switch(changdu.length()){
				case 1:
					changdu = "00000"+changdu;
					break;
				case 2:
					changdu = "0000"+changdu;
					break;
				case 3:
					changdu = "000"+changdu;
					break;
				case 4:
					changdu = "00"+changdu;
					break;
				case 5:
					changdu = "0"+changdu;
					break;
				}
			}
			
			String newStr = date+ CacheUtil.paraCache.getParaValue("HotelOrder") + changdu;
			
			String newSql = "update GENCODE g set g.CODEVALUE='"+num+"' where g.codeType=3";
			
			jdbc.executeSQL(newSql);
			
			return newStr;
		}
	}

	
	public synchronized static String getAirlineTicketOrderCode() {
		
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		
		String sql = "select g.CODEVALUE from GENCODE g where g.codeType=2";
		
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		
		String date = DateTool.format(new Date(), "yyMMdd");
		if(list == null || list.size() == 0){
			String returnValue = date+CacheUtil.paraCache.getParaValue("AirOrder")+"000001";
			String id = UuidUtil.getUUIDfor32();
			String mySQL = "insert into GENCODE(id,codeType,codeValue) values('"+id+"',2,'000001')";
			jdbc.executeSQL(mySQL);
			return returnValue;
		}else{
			ETIPResultSet set = list.get(0);
			
			String codeValue = set.getString("CODEVALUE");
			
			Long num = Long.parseLong(codeValue);
			
			num = num + 1;
			
			String changdu = String.valueOf(num);
			if(changdu.length()<6){
				switch(changdu.length()){
				case 1:
					changdu = "00000"+changdu;
					break;
				case 2:
					changdu = "0000"+changdu;
					break;
				case 3:
					changdu = "000"+changdu;
					break;
				case 4:
					changdu = "00"+changdu;
					break;
				case 5:
					changdu = "0"+changdu;
					break;
				}
			}
			
			String newStr = date+ CacheUtil.paraCache.getParaValue("AirOrder") + changdu;
			
			String newSql = "update GENCODE g set g.CODEVALUE='"+num+"' where g.codeType=2";
			
			jdbc.executeSQL(newSql);
			
			return newStr;
		}
	}
	/**
	 * 创建订单号 目前只支持3种，大订单，机票订单，酒店订单
	 * @param type
	 * @return
	 */
	public synchronized static String getOrderCode(int type) {
		String order = "";
		switch (type) {
		case 1:
			order = "BigOrder";
			break;
		case 2:
			order = "AirlineTicket";
			break;
		case 3:
			order = "HotelOrder";
			break;
		}
		
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		
		String sql = "select g.CODEVALUE from GENCODE g where g.codeType=" + type;
		
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		
		if(list == null || list.size() == 0){
			String id = UuidUtil.getUUIDfor32();
			String mySQL = "insert into GENCODE(id,codeType,codeValue) values('"+id+"'," + type + ",'" + order + "-1')";
			jdbc.executeSQL(mySQL);
			return order + "-1";
		}else{
			ETIPResultSet set = list.get(0);
			
			String codeValue = set.getString("CODEVALUE");
			
			String[] arr = codeValue.split("-");
			
			Long num = Long.parseLong(arr[1]);
			
			num = num + 1;
			
			String newStr = arr[0] + "-" + num;
			
			String newSql = "update GENCODE g set g.CODEVALUE='"+newStr+"' where g.codeType=" + type;
			
			jdbc.executeSQL(newSql);
			
			return newStr;
		}
	}
	
}
