package com.itour.etip.support.serviceregistry.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.data.ServiceRegistryData;
import com.itour.etip.support.serviceregistry.facade.ServiceRegistryAdminFacade;

public class ServiceRegistryAdminAction extends FrmAction {
	private ServiceRegistryAdminFacade serviceRegistryAdminFacade;

	public ServiceRegistryAdminFacade getServiceRegistryAdminFacade() {
		return serviceRegistryAdminFacade;
	}

	public void setServiceRegistryAdminFacade(
			ServiceRegistryAdminFacade serviceRegistryAdminFacade) {
		this.serviceRegistryAdminFacade = serviceRegistryAdminFacade;
	}

	/**
	 * 查询权限信息
	 * 
	 * @return
	
	 */
	public String getServiceList() {
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");

		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setPageSize(Integer.valueOf(limit));
		Object obj = getJson();

		List list = serviceRegistryAdminFacade.getServiceList(pageRoll, null);

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

	/**
	 * 添加权限信息
	 * @return
	
	 */
	public String addService()throws IllegalAccessException, InvocationTargetException {
		Object json = getJson();

		JSONObject jobj = (JSONObject) json;
		
		ServiceRegistryData sr = (ServiceRegistryData) jobj.toBean(jobj, ServiceRegistryData.class);
		ServiceRegistryData srs = serviceRegistryAdminFacade.addService(sr);
		JSONObject obj = JSONObject.fromObject(srs);
		obj.put("uiProvider", "col");
		obj.put("leaf", "true");
		setJson("{success:true,data:"+obj.toString()+"}");
		return null;
	}
	
	/**
	 * 根据id取得权限信息
	 * @return
	
	 */
	public String selectService(){
		/*JSONObject idOBJ = (JSONObject)getJson();
		ServiceRegistry sr = serviceRegistryAdminFacade.selectService(idOBJ.getString("serviceID"));
		this.setJson(idOBJ.toString());*/
		return null;
		
	}
	/**
	 * 修改权限信息
	 * @return
	
	 */
	public String updateService(){
		JSONObject  jsonObj=(JSONObject)getJson();
		ServiceRegistryData sr = (ServiceRegistryData)jsonObj.toBean(jsonObj,ServiceRegistryData.class);
		ServiceRegistryData srd = serviceRegistryAdminFacade.updateService(sr);
		JSONObject obj = JSONObject.fromObject(srd);
		obj.put("uiProvider", "col");
		obj.put("leaf", "true");
		setJson("{success:true,data:"+obj.toString()+"}");
		return null;
	}
	
	/**
	 * 删除权限信息
	 * @return
	
	 */
	public String deleteService() {
		JSONArray idListOBJ=(JSONArray)getJson();
		String[] serviceCodes = new String[idListOBJ.size()];
		for(int i=0;i<idListOBJ.size();i++){
			serviceCodes[i] = idListOBJ.getString(i);
		}
		
		serviceRegistryAdminFacade.deleteService(serviceCodes);
		System.out.println(idListOBJ);
		setJson("{success:true}");
		return null;
	
	}
	
	public String getServiceTree(){
		
		Object obj = getJson();
		
		JSONObject jobj = (JSONObject)obj;
		System.err.println("%%%%%%%%%%%%%%%%%%%");
		if(jobj != null){
			
			System.err.println(jobj.toString());
		}
		
		String id = request.getParameter("id");
		System.err.println("!!!!!!!!!!!!!!!!!!"+id);
		ServiceRegistryData srd = (ServiceRegistryData)JSONObject.toBean(jobj, ServiceRegistryData.class);
		List list = serviceRegistryAdminFacade.getServiceTree(srd,id);
		JSONArray array = DateTool.getJSONArray(list, "yyyy-MM-dd");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(array.toString());
		setJson(array.toString());
		
		return null;
	}
}
