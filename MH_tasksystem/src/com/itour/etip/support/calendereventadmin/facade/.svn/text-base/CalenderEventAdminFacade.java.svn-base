package com.itour.etip.support.calendereventadmin.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.CalenderEventData;
import com.itour.etip.support.service.ICalenderEventService;

public class CalenderEventAdminFacade extends FrmFacade {

	private ICalenderEventService calenderEventService;

	/**
	 * 查询会展节日信息
	 * 
	 * @param calender
	 * @return
	 */
	public List<CalenderEventData> searchCalenderEvent(PageRoll pageRoll,
			JSONObject condition) throws ETIPException {
		return calenderEventService.searchCalenderEvent(pageRoll, condition);
	}

	/**
	 * 新增加会展节日信息
	 * 
	 * @param calender
	 * @return
	 */
	public CalenderEventData saveCalenderEvent(CalenderEventData calenderEvent)
			throws ETIPException {
		return calenderEventService.addCalenderEvent(calenderEvent);
	}

	public CalenderEventData updateCalenderEvent(CalenderEventData calenderEvent)
			throws ETIPException {
		return calenderEventService.updateCalenderEvent(calenderEvent);
	}

	/**
	 * 删除会展节日信息，可批量删除
	 * 
	 * @param objects
	 */
	public void deleteCalenderEvent(String[] ids) throws ETIPException {
		calenderEventService.deleteCalenderEvent(ids);
	}

	/**
	 * 查询会展节日对象
	 * 
	 * @param id
	 * @return
	 */
	public CalenderEventData retrieveCalenderEvent(String id) {
		return calenderEventService.retrieveCalenderEvent(id);
	}

	public void setCalenderEventService(
			ICalenderEventService calenderEventService) {
		this.calenderEventService = calenderEventService;
	}

}
