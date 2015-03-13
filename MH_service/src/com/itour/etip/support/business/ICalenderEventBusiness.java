package com.itour.etip.support.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.CalenderEventData;

public interface ICalenderEventBusiness extends IBusiness{

	/**
	 * 根据Id查找会展节日对象
	 * @param id
	 * @return
	 */
	public CalenderEventData retrieveCalenderEvent(String id);
	/**
	 * 添加会展节日对象
	 * @param calenderEvent
	 * @return
	 */
	public CalenderEventData addCalenderEvent(CalenderEventData calenderEvent);
	
	/**
	 * 更新会展节日对象
	 * @param calenderEvent
	 * @return
	 */
	public CalenderEventData updateCalenderEvent(CalenderEventData calenderEvent);
	
	/**
	 * 删除会展节日记录
	 * @param ids
	 */
	public void deleteCalenderEvent(String[] ids);
	
	/**
	 * 查询会展节日记录
	 * @param pageRoll
	 * @param condition
	 * @return
	 */
	public List<CalenderEventData> searchCalenderEvent(PageRoll pageRoll, JSONObject condition);
}
