package com.itour.etip.support.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.CalenderEventData;
import com.itour.etip.support.persistence.ICalenderEventPersistence;

public class CalenderEventBusiness extends FrmBusiness implements
		ICalenderEventBusiness {

	private ICalenderEventPersistence calenderEventPersistence;
	
	public void setCalenderEventPersistence(
			ICalenderEventPersistence calenderEventPersistence) {
		this.calenderEventPersistence = calenderEventPersistence;
	}

	public CalenderEventData addCalenderEvent(CalenderEventData calenderEvent) {
		calenderEventPersistence.add(calenderEvent);
		return calenderEvent;
	}

	public void deleteCalenderEvent(String[] ids) {
		calenderEventPersistence.delete(ids);
	}

	public List<CalenderEventData> searchCalenderEvent(PageRoll pageRoll,
			JSONObject condition) {

		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String eventType = (String) condition.get("eventType");
		String filterCountry = (String) condition.get("filterCountry");
		String filterProvince = (String) condition.get("filterProvince");
		String country = (String) condition.get("country");
		String province = (String) condition.get("province");
		String city = (String) condition.get("city");
		
		
		StringBuffer sbFrom = new StringBuffer();
		StringBuffer sbWhere  = new StringBuffer();
		
		boolean flag = false;//判断是否所有条件都为空
		int num = 0;
		//查询后的集合
		List<CalenderEventData> list = null;
		
		sbFrom.append("from CalenderEventData c ");
		sbWhere.append("where 1=1 ");
		
		if(startTime !=null && !("".equals(startTime))){
			sbWhere.append(" and to_char(c.startTime,'yyyy-mm-dd')  >  '" + startTime + "'");
			flag = true;
		}
		if(endTime !=null && !("".equals(endTime))){
			sbWhere.append(" and to_char(c.endTime,'yyyy-mm-dd')  <  '" + endTime + "'");
			flag = true;
		} 
		if(eventType !=null && !("".equals(eventType))){
			sbWhere.append(" and c.eventType = '" + eventType + "'");			
			flag = true;
		}
		if(!"1".equals(filterCountry) && !"2".equals(filterProvince)) {
			if(country != null && !("".equals(country))) {
				sbWhere.append( " and ((c.city is null) and (c.province is null) and c.country = '"+country+"')");
				flag = true;
			}
			if(province != null && !("".equals(province))) {
				sbWhere.append("or ((c.city is null) and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
			if(city != null && !("".equals(city))) {
				sbWhere.append("or (c.city = '"+city+"' and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
		}else if("1".equals(filterCountry) && !"2".equals(filterProvince)){
			if(province != null && !("".equals(province))) {
				sbWhere.append("and ((c.city is null) and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
			if(city != null && !("".equals(city))) {
				sbWhere.append("or (c.city = '"+city+"' and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
			
		}else if("2".equals(filterProvince) && !"1".equals(filterCountry)) {
			if(country != null && !("".equals(country))) {
				sbWhere.append( " and ((c.city is null) and (c.province is null) and c.country = '"+country+"')");
				flag = true;
			}
			if(city != null && !("".equals(city))) {
				sbWhere.append("or (c.city = '"+city+"' and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
		}else if("2".equals(filterProvince) && "1".equals(filterCountry)){
			if(city != null && !("".equals(city))) {
				sbWhere.append("and (c.city = '"+city+"' and c.province = '"+province+"' and c.country = '"+country+"')");
				flag = true;
			}
			
		}
		
		String scroeHql = sbFrom.toString()+" "+ sbWhere.toString();
		if(!flag){
			return null;
		}else{
			String CountSQL = "select count(*) " + scroeHql;
			pageRoll.setCountSQL(CountSQL);
			pageRoll.setSearchSQL(scroeHql);
			list = calenderEventPersistence.search(pageRoll);
			return list;
		}
	}

	public CalenderEventData updateCalenderEvent(CalenderEventData calenderEvent) {
		calenderEventPersistence.update(calenderEvent);
		return calenderEvent;
	}

	public CalenderEventData retrieveCalenderEvent(String id) {
		return calenderEventPersistence.retrieve(id);
	}

}
