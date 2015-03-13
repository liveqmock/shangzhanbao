package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.business.ICalenderEventBusiness;
import com.itour.etip.support.data.CalenderEventData;

public class CalenderEventService extends FrmService implements ICalenderEventService {

	private ICalenderEventBusiness calenderEventBusiness;
	
	public void setCalenderEventBusiness(
			ICalenderEventBusiness calenderEventBusiness) {
		this.calenderEventBusiness = calenderEventBusiness;
	}

	public CalenderEventData addCalenderEvent(CalenderEventData calenderEvent) {
		return calenderEventBusiness.addCalenderEvent(calenderEvent);
	}

	public void deleteCalenderEvent(String[] ids) {
		calenderEventBusiness.deleteCalenderEvent(ids);
	}

	public CalenderEventData retrieveCalenderEvent(String id) {
		return calenderEventBusiness.retrieveCalenderEvent(id);
	}

	public List<CalenderEventData> searchCalenderEvent(PageRoll pageRoll, JSONObject condition) {
		return calenderEventBusiness.searchCalenderEvent(pageRoll, condition);
	}

	public CalenderEventData updateCalenderEvent(CalenderEventData calenderEvent) {
		return calenderEventBusiness.updateCalenderEvent(calenderEvent);
	}

}
