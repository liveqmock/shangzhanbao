package com.itour.etip.support.calendereventadmin.action;

import java.util.List;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.calendereventadmin.facade.CalenderEventAdminFacade;
import com.itour.etip.support.data.CalenderEventData;

/**
 * @author Administrator
 *
 */
public class CalenderEventAdminAction extends FrmAction {

	private CalenderEventAdminFacade calenderEventAdminFacade;

	// 通过spring依赖注入实例化类
	public void setCalenderEventAdminFacade(
			CalenderEventAdminFacade calenderEventAdminFacade) {
		this.calenderEventAdminFacade = calenderEventAdminFacade;
	}

	/**
	 * 查询会展节日信息
	 * 
	 * @return
	
	 */
	public String searchCalenderEvent(){
		JSONObject condition = (JSONObject) getJson();
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");

		PageRoll pageRoll = new PageRoll();
		if(start != null) {
			pageRoll.setStartRow(Integer.valueOf(start));
		}
		if(limit != null) {
			pageRoll.setPageSize(Integer.valueOf(limit));
		}

		List<CalenderEventData> list = calenderEventAdminFacade
				.searchCalenderEvent(pageRoll, condition);

		String rvJson = this.getListJsonStr(pageRoll, list);
		setJson(rvJson);
		return null;
	}
	

	/**
	 * 保存会展节日信息
	 * 
	 * @return
	
	 */
	public String saveCalenderEvent() {
		JSONObject jsonObj = (JSONObject) getJson();

		// 转化日期格式
		String[] dateFormats = new String[] { "yyyy-MM-dd" };
		//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		
		CalenderEventData calender = (CalenderEventData) JSONObject.toBean(
				jsonObj, CalenderEventData.class);

		CalenderEventData calenderEvent = calenderEventAdminFacade
				.saveCalenderEvent(calender);
		String rvJson = DateTool.getJSONString(calenderEvent, "yyyy-MM-dd");
		setJson("{success:true,data:" + rvJson + "}");
		return null;
	}

	/**
	 * 更新会展节日信息
	 * 
	 * @return
	
	 */
	public String updateCalenderEvent() {
		JSONObject jsonObj = (JSONObject) getJson();

		// 转化日期格式
		String[] dateFormats = new String[] { "yyyy-MM-dd" };
		//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));

		CalenderEventData calender = (CalenderEventData) JSONObject.toBean(
				jsonObj, CalenderEventData.class);

		calenderEventAdminFacade.updateCalenderEvent(calender);

		setJson("{success:true}");
		return null;
	}

	/**
	 * @return
	 * @throws ETIPException
	 */
	public String deleteCalenderEvent(){
		JSONArray jsonArr = (JSONArray) getJson();
		String[] ids = new String[jsonArr.toArray().length];
		for(int i = 0; i < jsonArr.toArray().length; i++) {
			ids[i] = (String) jsonArr.toArray()[i];
		}
		
		calenderEventAdminFacade.deleteCalenderEvent(ids);

		setJson("{success:true}");
		return null;
	}
	
	/**
	 * @return
	 */
	public String retrieveCalenderEvent() {
		JSONObject jsonObj = (JSONObject) getJson();
		String id = jsonObj.getString("id");
		
		CalenderEventData calenderEvent = calenderEventAdminFacade.retrieveCalenderEvent(id);
		String rvJson = DateTool.getJSONString(calenderEvent, "yyyy-MM-dd");
		
		setJson("{success:true,data:" + rvJson + "}");
		
		return null;
	}
	
}
