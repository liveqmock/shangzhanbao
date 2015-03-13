package com.itour.etip.support.positionmanage.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;

import com.itour.etip.support.data.RoleRegistryData;
import com.itour.etip.support.positionmanage.facade.PositionManageAdminFacade;

public class PositionManageAdminAction extends FrmAction{
	
	private PositionManageAdminFacade positionManageAdminFacade;

	public PositionManageAdminFacade getPositionManageAdminFacade() {
		return positionManageAdminFacade;
	}

	public void setPositionManageAdminFacade(
			PositionManageAdminFacade positionManageAdminFacade) {
		this.positionManageAdminFacade = positionManageAdminFacade;
	}
	
	public String getPositionList(){
		

		
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setPageSize(Integer.valueOf(limit));
		Object obj = getJson();
		
		JSONObject jobj = (JSONObject)obj;
		
		RoleRegistryData rrd = (RoleRegistryData)JSONObject.toBean(jobj, RoleRegistryData.class);
		
		List list = positionManageAdminFacade.getPositionList(pageRoll,rrd);
	
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer();
		sb.append("{'items':");
		sb.append(jsonArray.toString());
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");
		setJson(sb.toString());
		
		return null;
	
	}
	
	public String getProcessTask(){

		
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setPageSize(Integer.valueOf(limit));
		//此处查询岗位角色
		List list = positionManageAdminFacade.getProcessTask(pageRoll,null);
	
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer();
		sb.append("{'items':");
		sb.append(jsonArray.toString());
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");
		setJson(sb.toString());
		
		return null;
	
	
	}
	
	
	public String getTaskOfPosition(){

		
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;
		String id = jsonObject.getString("id");
		
		
		Map map = positionManageAdminFacade.getTaskOfPosition(id);
		
		RoleRegistryData data = (RoleRegistryData)map.get("position");
		
		List list = (List)map.get("tasks");
		
		JSONObject jsonPosition  = JSONObject.fromObject(data);
		JSONArray tasks = JSONArray.fromObject(list);
		
		/*JSONObject jsonTasks = new JSONObject();
		jsonTasks.put("results", tasks.size());
		jsonTasks.put("items", tasks);
		*/
		JSONObject jobj = new JSONObject();
		jobj.put("success", "true");
		jobj.put("formValue", jsonPosition);
		jobj.put("gridValue", tasks.toString());
		setJson(jobj.toString());
	
//		JSONArray jsonArray = JSONArray.fromObject();
//		StringBuffer sb = new StringBuffer();
//		sb.append("{'items':");
//		sb.append(jsonArray.toString());
//		sb.append(",'results':");
//		sb.append(pageRoll.getTotalRows());
//		sb.append("}");
//		setJson(sb.toString());
		
		return null;
	
	}
	
	public String addPosition(){
		
		System.out.println("@@@"+"添加岗位");
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;		
		JSONObject obj1 = jsonObject.getJSONObject("formValue");		
		JSONArray jsonArray = (JSONArray)jsonObject.get("gridValue");	
		
		RoleRegistryData rr = (RoleRegistryData)JSONObject.toBean(obj1, RoleRegistryData.class);
		String[] ids = new String[jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++){
			ids[i] = jsonArray.getJSONObject(i).getString("id");
		}
		
		positionManageAdminFacade.addPosition(rr,ids);
		setJson("{success:true}");
		
		return null;
	}
	
	public String updatePosition(){
		
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;
		JSONObject obj1 = jsonObject.getJSONObject("formValue");
		JSONArray jsonArray = (JSONArray)jsonObject.get("gridValue");
		RoleRegistryData rr = (RoleRegistryData)JSONObject.toBean(obj1, RoleRegistryData.class);
		String[] ids = new String[jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++){
			ids[i] = jsonArray.getJSONObject(i).getString("id");
		}
		positionManageAdminFacade.updatePosition(rr,ids);
		setJson("{success:true}");
		return null;
	}
	
	public String deletePosition(){
		
		Object obj = getJson();		
		JSONArray array = (JSONArray)obj;	
		String[] ids = new String[array.size()];
		for(int i=0;i<ids.length;i++){
			ids[i] = array.getString(i);
		}
		positionManageAdminFacade.deletePositions(ids);
		setJson("{success:true}");
		
		return null;
	}

}
